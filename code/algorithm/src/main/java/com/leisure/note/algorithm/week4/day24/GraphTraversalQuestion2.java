package com.leisure.note.algorithm.week4.day24;

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

  public int orangesRotting(int[][] grid) {
    throw new UnsupportedOperationException("TODO: implement orangesRotting");
  }
}
