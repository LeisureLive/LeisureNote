package com.leisure.note.algorithm.week5.day30;

/**
 * 题目：45. 跳跃游戏 II
 *
 * <p>题目描述：
 *
 * <p>给定一个长度为 {@code n} 的非负整数数组 {@code nums}，你最初位于数组的第一个下标。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。假设你总是可以到达数组的最后一个位置，
 * 返回到达最后一个位置的最少跳跃次数。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int jump(int[] nums)
 * </pre>
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums = [2,3,1,1,4]
 * 输出：2
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：nums = [2,3,0,1,4]
 * 输出：2
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标思路是贪心，复杂度尽量做到 {@code O(n)}</li>
 * <li>不要用暴力枚举每一次起跳位置的方式求最少步数</li>
 * <li>重点是理解当前一步可覆盖区间与下一步最远可达区间的关系</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练覆盖范围 + 最少跳数贪心</li>
 * <li>重点说清为什么这题像按层推进，而不是暴力试每种跳法</li>
 * </ul>
 */
public class GreedyQuestion1 {

  public int jump(int[] nums) {
    throw new UnsupportedOperationException("TODO: implement jump");
  }
}
