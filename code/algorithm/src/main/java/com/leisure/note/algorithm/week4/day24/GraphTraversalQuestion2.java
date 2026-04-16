package com.leisure.note.algorithm.week4.day24;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：994. 腐烂的橘子
 *
 * <p>题目描述：
 *
 * <p>在给定的网格中，每个单元格可以有以下三个值之一：0 代表空单元格，1 代表新鲜橘子，2 代表腐烂橘子。
 * 返回直到所有新鲜橘子腐烂所需的最小分钟数；如果不可能，返回 -1。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int orangesRotting(int[][] grid)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标思路是多源 BFS，复杂度为 {@code O(m * n)}</li>
 * <li>如果一开始就没有新鲜橘子，返回 {@code 0}</li>
 * <li>每分钟所有当前腐烂橘子都会同时向四个方向扩散</li>
 * <li>如果最终仍有新鲜橘子无法被腐烂，返回 {@code -1}</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练多源 BFS</li>
 * <li>重点说清按层扩散和时间推进的关系</li>
 * </ul>
 */
public class GraphTraversalQuestion2 {

  private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public int orangesRotting(int[][] grid) {
    // 本题定位：图 / 多源 BFS / 按层扩散。
    // 题型特征：有多个初始起点，并且题目问“最少多少分钟全部扩散完成”，所以不是普通遍历，而是多源最短扩散问题。
    // 解题思路：
    // 1. 先把所有初始腐烂橘子一起入队，同时统计新鲜橘子数量 freshCount。
    // 2. 每次 while 循环处理一整层队列，这一层表示“这一分钟开始时已经腐烂的所有橘子”。
    // 3. 只有相邻新鲜橘子才会被感染，并加入下一层队列，同时 freshCount--。
    // 4. 处理完一整层后，minutes++，表示真实过去 1 分钟。
    // 优点：和题目的“同时扩散”语义完全一致，不需要额外 visited，直接改 grid 即可完成状态标记。
    // 缺点 / 前提：这题依赖“每条边扩散代价都相同”，所以 BFS 合适；如果扩散代价不同，就不能直接套这版模板。
    // 变体 / 注意事项：
    // 1. 这次真正犯过的错是把四个方向无条件塞进下一层，导致无效位置也可能把分钟数多推 1。
    // 2. 这次真正犯过的错是“只要 nextLevel 非空就 minutes++”，但 nextLevel 里必须只放“本轮新感染的橘子”。
    // 3. 这题最关键的不是 visited，而是“队列里这一层到底代表谁”。
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return -1;
    }

    Queue<int[]> queue = new ArrayDeque<>();
    int freshCount = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2) {
          queue.offer(new int[] {i, j});
        }
        if (grid[i][j] == 1) {
          freshCount++;
        }
      }
    }

    if (freshCount == 0) {
      return 0;
    }

    int minutes = 0;
    while (!queue.isEmpty() && freshCount > 0) {
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        int[] current = queue.poll();
        int row = current[0];
        int col = current[1];

        for (int[] direction : DIRECTIONS) {
          int nextRow = row + direction[0];
          int nextCol = col + direction[1];
          if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length) {
            continue;
          }
          if (grid[nextRow][nextCol] != 1) {
            continue;
          }

          grid[nextRow][nextCol] = 2;
          freshCount--;
          queue.offer(new int[] {nextRow, nextCol});
        }
      }
      minutes++;
    }

    return freshCount == 0 ? minutes : -1;
  }

  public int orangesRottingRecursiveBfs(int[][] grid) {
    // 本题定位：图 / 递归版层序 BFS。
    // 题型特征：保留“按层递归处理”的思路，但本质上仍然是 BFS，不是 DFS。
    // 解题思路：
    // 1. currentLevel 表示“当前这一分钟开始时已经腐烂的橘子集合”。
    // 2. 递归函数只负责根据 currentLevel 生成 nextLevel。
    // 3. nextLevel 里只能放“本轮真实新感染的橘子”，然后递归处理下一层。
    // 优点：更贴近你之前“收集下一层再递归”的思路，适合对照理解为什么原写法会多 1。
    // 缺点 / 前提：表达比标准队列版更绕，面试里不如显式队列版稳，不建议作为主解。
    // 变体 / 注意事项：
    // 1. 这版最容易错的地方就是把“扫描到的四邻居”误当成“下一层真实节点”。
    // 2. 如果 nextLevel 为空但 freshCount 还大于 0，说明剩余新鲜橘子不可达，应该返回 -1。
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return -1;
    }

    List<int[]> currentLevel = new ArrayList<>();
    int freshCount = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2) {
          currentLevel.add(new int[] {i, j});
        }
        if (grid[i][j] == 1) {
          freshCount++;
        }
      }
    }

    if (freshCount == 0) {
      return 0;
    }

    return bfsByLevelRecursive(grid, currentLevel, freshCount);
  }

  private int bfsByLevelRecursive(int[][] grid, List<int[]> currentLevel, int freshCount) {
    if (freshCount == 0) {
      return 0;
    }
    if (currentLevel.isEmpty()) {
      return -1;
    }

    List<int[]> nextLevel = new ArrayList<>();
    for (int[] cell : currentLevel) {
      int row = cell[0];
      int col = cell[1];

      for (int[] direction : DIRECTIONS) {
        int nextRow = row + direction[0];
        int nextCol = col + direction[1];
        if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length) {
          continue;
        }
        if (grid[nextRow][nextCol] != 1) {
          continue;
        }

        // 只有真实从 1 变成 2 的橘子，才能进入下一层。
        grid[nextRow][nextCol] = 2;
        freshCount--;
        nextLevel.add(new int[] {nextRow, nextCol});
      }
    }

    int nextResult = bfsByLevelRecursive(grid, nextLevel, freshCount);
    if (nextResult == -1) {
      return -1;
    }
    return nextLevel.isEmpty() ? 0 : nextResult + 1;
  }

  private int[][] copyGrid(int[][] grid) {
    int[][] copy = new int[grid.length][];
    for (int i = 0; i < grid.length; i++) {
      copy[i] = grid[i].clone();
    }
    return copy;
  }

  public static void main(String[] args) {
    GraphTraversalQuestion2 graph = new GraphTraversalQuestion2();
    int[][] grid = new int[][] {
      {2, 1, 1},
      {1, 1, 0},
      {0, 1, 1}};
    System.out.println(graph.orangesRotting(graph.copyGrid(grid)));
    System.out.println(graph.orangesRottingRecursiveBfs(graph.copyGrid(grid)));
  }
}
