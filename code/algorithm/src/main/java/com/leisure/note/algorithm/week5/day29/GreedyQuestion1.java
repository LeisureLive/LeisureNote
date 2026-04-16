package com.leisure.note.algorithm.week5.day29;

/**
 * 题目：55. 跳跃游戏
 *
 * <p>题目描述：
 *
 * <p>给定一个非负整数数组 {@code nums}，你最初位于数组的第一个下标。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * <p>方法签名：
 *
 * <pre>
 * public boolean canJump(int[] nums)
 * </pre>
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标思路是贪心，复杂度尽量做到 {@code O(n)}</li>
 * <li>重点不是枚举所有跳法，而是维护当前最远可达边界</li>
 * <li>数组中的元素均为非负整数</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练覆盖范围型贪心</li>
 * <li>重点说清为什么不需要回头枚举每一种跳法</li>
 * </ul>
 */
public class GreedyQuestion1 {

  public boolean canJump(int[] nums) {
    throw new UnsupportedOperationException("TODO: implement canJump");
  }
}
