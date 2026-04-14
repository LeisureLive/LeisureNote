package com.leisure.note.algorithm.week4.day24;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 题目：200. 岛屿数量
 *
 * <p>题目描述：
 *
 * <p>给你一个由 {@code '1'}（陆地）和 {@code '0'}（水）组成的二维网格，请你计算网格中岛屿的数量。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int numIslands(char[][] grid)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：grid = [
 *   ['1','1','1','1','0'],
 *   ['1','1','0','1','0'],
 *   ['1','1','0','0','0'],
 *   ['0','0','0','0','0']
 * ]
 * 输出：1
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：grid = [
 *   ['1','1','0','0','0'],
 *   ['1','1','0','0','0'],
 *   ['0','0','1','0','0'],
 *   ['0','0','0','1','1']
 * ]
 * 输出：3
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>岛屿只按上下左右四个方向连通，不考虑对角线</li>
 * <li>目标时间复杂度为 {@code O(m * n)}</li>
 * <li>允许使用额外空间保存访问状态，也允许原地修改网格做标记</li>
 * <li>空网格或全是水时返回 {@code 0}</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练图上的 DFS / BFS</li>
 * <li>重点说清“访问过”的标记方式</li>
 * </ul>
 */
public class GraphTraversalQuestion1 {

  private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public int numIslands(char[][] grid) {
    // 本题定位：图 / 连通块计数 / 网格 DFS。
    // 题型特征：给二维网格、四方向连通、问题是“有多少块”，优先想到连通性搜索。
    // 解题思路：
    // 1. 外层遍历整个网格。
    // 2. 每遇到一个“未访问的陆地”，岛屿数量加 1，并启动一次 DFS。
    // 3. DFS 负责把这整块连通陆地全部标记掉，避免后续重复计数。
    // 优点：代码短，连通块计数主线很直观。
    // 缺点 / 前提：递归版依赖调用栈深度，大网格最坏情况下可能栈深较大；如果更追求稳妥，优先看下面的 BFS 版本。
    // 变体 / 注意事项：
    // 1. 这题求的是“块数”，不是“最短步数”，所以 DFS / BFS 都可以。
    // 2. 如果题目改成“最大岛屿面积”，就在搜索过程中额外累计当前块大小。
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int num = 0;
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (!visited[i][j] && grid[i][j] == '1') {
          num++;
          dfsTraversal(grid, visited, i, j);
        }
      }
    }

    return num;
  }

  public int numIslandsBfs(char[][] grid) {
    // 本题定位：图 / 连通块计数 / 网格 BFS。
    // 题型特征：和上面的 DFS 版本同类，只是把“递归淹没整块陆地”改成了“队列逐层扫描整块陆地”。
    // 解题思路：
    // 1. 外层扫描到未访问陆地时计数。
    // 2. 把这个起点入队。
    // 3. 用队列把整块连通陆地全部弹出并扩展四邻居。
    // 优点：不依赖递归栈，写法更稳，也更适合和后面的图题 BFS 统一理解。
    // 缺点 / 前提：这题只是连通块遍历，BFS 比 DFS 稍长一些，但语义同样正确。
    // 变体 / 注意事项：
    // 1. 这里虽然是 BFS，但它不是“最短路 BFS”，只是用队列遍历整块区域。
    // 2. visited 必须在入队时就标记，避免同一个节点被重复入队。
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int num = 0;
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (!visited[i][j] && grid[i][j] == '1') {
          num++;
          bfsTraversal(grid, visited, i, j);
        }
      }
    }

    return num;
  }

  private void dfsTraversal(char[][] grid, boolean[][] visited, int row, int col) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
      return;
    }
    if (grid[row][col] == '0' || visited[row][col]) {
      return;
    }

    visited[row][col] = true;
    dfsTraversal(grid, visited, row - 1, col);
    dfsTraversal(grid, visited, row + 1, col);
    dfsTraversal(grid, visited, row, col - 1);
    dfsTraversal(grid, visited, row, col + 1);
  }

  private void bfsTraversal(char[][] grid, boolean[][] visited, int startRow, int startCol) {
    Queue<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[] {startRow, startCol});
    // 入队时就标记，避免多个相邻节点把同一个陆地点重复加入队列。
    visited[startRow][startCol] = true;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int row = current[0];
      int col = current[1];

      for (int[] direction : DIRECTIONS) {
        int nextRow = row + direction[0];
        int nextCol = col + direction[1];
        if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length) {
          continue;
        }
        if (visited[nextRow][nextCol] || grid[nextRow][nextCol] == '0') {
          continue;
        }

        visited[nextRow][nextCol] = true;
        queue.offer(new int[] {nextRow, nextCol});
      }
    }
  }

  public static void main(String[] args) {
    GraphTraversalQuestion1 graph = new GraphTraversalQuestion1();
    char[][] grid = new char[4][5];
    grid[0] = new char[]{'1','1','1','1','0'};
    grid[1] = new char[]{'1','1','0','1','0'};
    grid[2] = new char[]{'1','1','0','0','0'};
    grid[3] = new char[]{'0','0','0','0','0'};
    System.out.println(graph.numIslands(grid));
    System.out.println(graph.numIslandsBfs(grid));
  }

}
