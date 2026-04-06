package com.leisure.note.algorithm.week4.day24;

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

  public int numIslands(char[][] grid) {
    throw new UnsupportedOperationException("TODO: implement numIslands");
  }
}
