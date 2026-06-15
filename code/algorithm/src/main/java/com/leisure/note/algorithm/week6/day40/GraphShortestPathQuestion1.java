package com.leisure.note.algorithm.week6.day40;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Day40 图模式题：3.2 最短步数。
 *
 * <p>本文件对应 `10_graphs.md` 的 `3.2 最短步数：分层 BFS 与多源 BFS`，
 * 只保留题目描述和方法骨架。
 */
public class GraphShortestPathQuestion1 {

  /**
   * 1091. 二进制矩阵中的最短路径
   *
   * <p>题目描述：
   *
   * <p>给定一个大小为 {@code n x n} 的二进制矩阵 {@code grid}，其中 {@code 0} 表示可以通过的单元格，
   * {@code 1} 表示被阻塞的单元格。
   *
   * <p>如果存在一条从左上角 {@code (0, 0)} 到右下角 {@code (n - 1, n - 1)} 的路径，
   * 且路径上的每一步都可以移动到八个方向之一的相邻单元格，请返回这条路径的最短长度；
   * 如果不存在这样的路径，返回 {@code -1}。
   *
   * <p>路径长度按经过的单元格数量计算，起点和终点都计入长度。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int shortestPathBinaryMatrix(int[][] grid)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：grid = [[0,1],[1,0]]
   * 输出：2
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
   * 输出：4
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>可以向八个方向移动</li>
   * <li>如果起点或终点被阻塞，答案为 {@code -1}</li>
   * <li>目标时间复杂度为 {@code O(n * n)}</li>
   * </ul>
   */
  public int shortestPathBinaryMatrix(int[][] grid) {
    if (grid[0][0] == 1) {
      return -1;
    }
    int n = grid.length;
    int[][] dist = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dist[i], Integer.MAX_VALUE);
    }
    // 这里对于最短长度问题，如果用 dfs 耗时会很长，因为需要走过所有的路径，并且会重复走
    // 使用 bfs, 每一层能走完当前步数的所有节点，当首次走到 [n-1][n-1] 节点时，自然就是最短路径，无需继续遍历了
    Queue<int[]> queue = new ArrayDeque<int[]>();
    queue.offer(new int[] {0, 0});
    dist[0][0] = 1;
    while (!queue.isEmpty()) {
      int[] pos = queue.poll();
      int row = pos[0];
      int col = pos[1];
      if (row == n - 1 && col == n - 1) {
        return dist[row][col];
      }
      for (int dx = -1; dx <= 1; dx++) {
        for (int dy = -1; dy <= 1; dy++) {
          if (row + dx < 0 || row + dx >= n || col + dy < 0 || col + dy >= n) {
            continue;
          }

          if (grid[row + dx][col + dy] == 1 || dist[row + dx][col + dy] != Integer.MAX_VALUE) {
            continue;
          }
          dist[row + dx][col + dy] = dist[row][col] + 1;
          queue.offer(new int[] {row + dx, col + dy});
        }
      }
    }

    return -1;
  }


  /**
   * 542. 01 矩阵
   *
   * <p>题目描述：
   *
   * <p>给定一个大小为 {@code m x n} 的二进制矩阵 {@code mat}，请返回一个同样大小的矩阵 {@code answer}。
   *
   * <p>{@code answer[i][j]} 表示从位置 {@code (i, j)} 到最近的 {@code 0} 的最短距离。
   * 相邻单元格仅指上下左右四个方向，每移动一步距离加 {@code 1}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int[][] updateMatrix(int[][] mat)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
   * 输出：[[0,0,0],[0,1,0],[0,0,0]]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
   * 输出：[[0,0,0],[0,1,0],[1,2,1]]
   * </pre>
   *
   * <p>示例说明：
   *
   * <pre>
   * 左下角的 1 距离最近的 0 只需要走 1 步；
   * 底部中间的 1 需要先走到上方或左右的 0，因此距离为 2。
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>只考虑上下左右四个方向</li>
   * <li>返回结果需要保留原有矩阵形状</li>
   * <li>目标时间复杂度优先考虑 {@code O(m * n)}</li>
   * </ul>
   */
  public int[][] updateMatrix(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    int[][] ans = new int[m][n];
    for (int i = 0; i < ans.length; i++) {
      Arrays.fill(ans[i], -1);
    }
    Queue<int[]> queue = new ArrayDeque<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (mat[i][j] == 0) {
          ans[i][j] = 0;
          queue.offer(new int[] {i, j});
        }
      }
    }

    int[][] dirs = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    int step = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int k = 1; k <= size; k++) {
        int[] pos = queue.poll();
        int i = pos[0];
        int j = pos[1];

        for (int[] dir : dirs) {
          int dx = dir[0];
          int dy = dir[1];
          // 越界
          if (i + dx < 0 || i + dx >= m || j + dy < 0 || j + dy >= n) {
            continue;
          }
          // 已经处理过或者元素为 0
          if (ans[i + dx][j + dy] != -1 || mat[i + dx][j + dy] == 0) {
            continue;
          }

          // 这里一定要先赋值再加入队列，不然会导致这一位置被重复加入队列
          ans[i+dx][j+dy] = step;
          queue.offer(new int[] {i + dx, j + dy});
        }
      }
      step++;
    }
    return ans;
  }


  public static void main(String[] args) {
    GraphShortestPathQuestion1 question1 = new GraphShortestPathQuestion1();
//    System.out.println(question1.shortestPathBinaryMatrix(new int[][] {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
    int[][] ans = question1.updateMatrix(new int[][] {{0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}});
    for (int i = 0; i < ans.length; i++) {
      System.out.println(Arrays.toString(ans[i]));
    }

  }
}
