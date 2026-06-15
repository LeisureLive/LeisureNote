package com.leisure.note.algorithm.week6.day40;

/**
 * Day40 图模式题：3.1 连通性。
 *
 * <p>本文件对应 `10_graphs.md` 的 `3.1 连通性：网格 / 图上的 DFS 与 BFS`，
 * 只保留题目描述和方法骨架。
 */
public class GraphConnectivityQuestion1 {

  /**
   * 695. 岛屿的最大面积
   *
   * <p>题目描述：
   *
   * <p>给定一个大小为 {@code m x n} 的二进制矩阵 {@code grid}，其中 {@code 1} 表示陆地，
   * {@code 0} 表示水域。岛屿由水平方向或竖直方向上相邻的陆地连接形成。
   *
   * <p>请返回矩阵中最大的岛屿面积。如果没有岛屿，返回 {@code 0}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int maxAreaOfIsland(int[][] grid)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：grid = [[0,0,1,0,0,0,1,1],
   *              [0,1,1,0,1,0,1,1],
   *              [0,0,0,0,1,0,0,0],
   *              [1,1,0,0,0,0,0,0]]
   * 输出：4
   * 解释：右上角由 4 个相连的陆地单元组成，是面积最大的岛屿。
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：grid = [[0,0,0],[0,0,0],[0,0,0]]
   * 输出：0
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>只考虑上下左右四个方向的连通关系</li>
   * <li>目标时间复杂度为 {@code O(m * n)}</li>
   * <li>允许修改原矩阵，或使用额外访问标记结构</li>
   * </ul>
   */
  public int maxAreaOfIsland(int[][] grid) {
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    int maxArea = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (!visited[i][j] && grid[i][j] == 1) {
          maxArea = Math.max(bfs(i, j, grid, visited), maxArea);
        }
      }
    }
    return maxArea;
  }

  private int bfs(int row, int col, int[][] grid, boolean[][] visited) {
    if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0) {
      return 0;
    }

    if (visited[row][col] || grid[row][col] != 1) {
      return 0;
    }

    visited[row][col] = true;
    return 1 + bfs(row - 1, col, grid, visited)
      + bfs(row + 1, col, grid, visited)
      + bfs(row, col - 1, grid, visited)
      + bfs(row, col + 1, grid, visited);
  }

  /**
   * 733. 图像渲染
   *
   * <p>题目描述：
   *
   * <p>给定一个整数矩阵 {@code image} 表示图像，其中 {@code image[i][j]} 表示像素值。
   * 再给定起始坐标 {@code (sr, sc)} 和一个新的颜色值 {@code color}。
   *
   * <p>请把起始像素以及与它在上下左右方向连通、且像素值与起始像素原始值相同的所有像素，
   * 全部渲染成新的颜色值，并返回渲染后的图像。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int[][] floodFill(int[][] image, int sr, int sc, int color)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
   * 输出：[[2,2,2],[2,2,0],[2,0,1]]
   * </pre>
   *
   * <p>示例说明：
   *
   * <pre>
   * 起点是中间位置 image[1][1]，它的原始颜色是 1。
   * 所有与它连通且颜色也为 1 的像素都会被改成 2，
   * 右下角的 image[2][2] 虽然也是 1，但它不与起点连通，因此保持不变。
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
   * 输出：[[0,0,0],[0,0,0]]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>只考虑上下左右四个方向的连通关系</li>
   * <li>返回结果需要保留原有矩阵形状</li>
   * <li>起始坐标保证在矩阵范围内</li>
   * </ul>
   */
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    boolean[][] visited = new boolean[image.length][image[0].length];
    int matchColor = image[sr][sc];
    dfs2(image, visited, sr, sc, matchColor, color);
    return image;
  }

  private void dfs2(int[][] image, boolean[][] visited, int i, int j, int matchColor, int color) {
    if (i < 0 || j < 0 || i >= image.length || j >= image[0].length) {
      return;
    }

    if (image[i][j] != matchColor || visited[i][j]) {
      return;
    }

    visited[i][j] = true;
    image[i][j] = color;
    dfs2(image, visited, i + 1, j, matchColor, color);
    dfs2(image, visited, i, j + 1, matchColor, color);
    dfs2(image, visited, i - 1, j, matchColor, color);
    dfs2(image, visited, i, j - 1, matchColor, color);
  }

  /**
   * 130. 被围绕的区域
   *
   * <p>题目描述：
   *
   * <p>给定一个大小为 {@code m x n} 的矩阵 {@code board}，矩阵中的元素为 {@code 'X'} 或 {@code 'O'}。
   *
   * <p>请你找出所有被 {@code 'X'} 完全围绕的区域，并将这些区域中的所有 {@code 'O'} 改写为 {@code 'X'}。
   *
   * <p>所谓“被围绕”，是指某个 {@code 'O'} 所在区域内的所有 {@code 'O'} 都不与边界上的 {@code 'O'} 连通。
   *
   * <p>方法签名：
   *
   * <pre>
   * public void solve(char[][] board)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：board = [["X","X","X","X"],
   *               ["X","O","O","X"],
   *               ["X","X","O","X"],
   *               ["X","O","X","X"]]
   * 输出：board = [["X","X","X","X"],
   *               ["X","X","X","X"],
   *               ["X","X","X","X"],
   *               ["X","O","X","X"]]
   * </pre>
   *
   * <p>示例说明：
   *
   * <pre>
   * 中间那一片 O 被 X 完全包围，因此要翻转成 X。
   * 最后一行第二列的 O 与边界直接连通，不属于被围绕区域，所以保留为 O。
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：board = [["X"]]
   * 输出：board = [["X"]]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>需要原地修改矩阵</li>
   * <li>只考虑上下左右四个方向的连通关系</li>
   * <li>边界上的 {@code 'O'} 以及与其连通的 {@code 'O'} 不应被翻转</li>
   * </ul>
   */
  public void solve(char[][] board) {
    int m = board.length;
    if (m == 0) {
      return;
    }
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      dfs3(board, i, 0);
      dfs3(board, i, n - 1);
    }
    for (int i = 1; i < n - 1; i++) {
      dfs3(board, 0, i);
      dfs3(board, m - 1, i);
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'A') {
          board[i][j] = 'O';
        } else if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
      }
    }
  }

  private void dfs3(char[][] board, int i, int j) {
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
      return;
    }

    if (board[i][j] == 'A' || board[i][j] != 'O') {
      return;
    }

    board[i][j] = 'A';

    dfs3(board, i + 1, j);
    dfs3(board, i - 1, j);
    dfs3(board, i, j + 1);
    dfs3(board, i, j - 1);
  }

  public static void main(String[] args) {
    GraphConnectivityQuestion1 question1 = new GraphConnectivityQuestion1();
    System.out.println(question1.maxAreaOfIsland(new int[][] {{1, 1, 0}, {0, 1, 0}, {0, 0, 0}}));
  }
}
