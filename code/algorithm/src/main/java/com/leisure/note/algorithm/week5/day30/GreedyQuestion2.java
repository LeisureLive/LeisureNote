package com.leisure.note.algorithm.week5.day30;

/**
 * 题目：435. 无重叠区间
 *
 * <p>题目描述：
 *
 * <p>给定一个区间集合 {@code intervals}，其中 {@code intervals[i] = [starti, endi]}。
 * 返回需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int eraseOverlapIntervals(int[][] intervals)
 * </pre>
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出：1
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：intervals = [[1,2],[1,2],[1,2]]
 * 输出：2
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标思路是排序 + 贪心，复杂度尽量做到 {@code O(n log n)}</li>
 * <li>重点理解为什么常按结束位置排序</li>
 * <li>区间端点可能相同，边界判断要和“是否重叠”的定义保持一致</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练区间选择型贪心</li>
 * <li>重点说清“最多保留几个”和“最少删除几个”的关系</li>
 * </ul>
 */
public class GreedyQuestion2 {

  public int eraseOverlapIntervals(int[][] intervals) {
    throw new UnsupportedOperationException("TODO: implement eraseOverlapIntervals");
  }
}
