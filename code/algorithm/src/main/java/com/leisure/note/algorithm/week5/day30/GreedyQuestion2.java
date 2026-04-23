package com.leisure.note.algorithm.week5.day30;

import java.util.Arrays;
import java.util.Comparator;

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
    // 本题定位：贪心 / 区间选择型。
    // 题型特征：表面上问“最少删除几个区间”，本质上等价于“最多能保留几个互不重叠区间”。
    // 贪心依据：
    // 1. 如果想给后面留下更大选择空间，就应该优先保留结束更早的区间。
    // 2. 所以最稳的排序规则是按 end 升序，而不是按 start 升序。
    // 状态定义：
    // retainNum 表示当前最多能保留几个互不重叠区间；
    // curEnd 表示当前最后一个被保留区间的结束位置。
    // 易错点：
    // 1. 这题不要直接想“删哪个”，而要转成“保留哪个”更顺。
    // 2. 端点相接不算重叠，所以判断条件是 start >= curEnd，不是 start > curEnd。
    // 3. 按 start 排序后再临时修补，代码很容易绕；按 end 排序才和这套状态天然匹配。
    if (intervals.length == 0) {
      return 0;
    }
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
    int retainNum = 1;
    int curEnd = intervals[0][1];

    // 第一个区间已经默认保留，所以从第二个区间开始判断能否接在它后面。
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= curEnd) {
        retainNum++;
        // 一旦保留当前区间，就把“最后保留区间”的结束位置更新为它的 end。
        curEnd = intervals[i][1];
      }
    }

    // 最少删除数 = 总区间数 - 最多可保留的不重叠区间数。
    return intervals.length - retainNum;
  }

  public static void main(String[] args) {
    GreedyQuestion2 greedyQuestion2 = new GreedyQuestion2();
    System.out.println(greedyQuestion2.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
    System.out.println(greedyQuestion2.eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}}));
    System.out.println(greedyQuestion2.eraseOverlapIntervals(new int[][]{{1,4},{2,3},{3,4}}));
  }
}
