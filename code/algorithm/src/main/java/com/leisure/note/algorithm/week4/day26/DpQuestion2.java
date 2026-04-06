package com.leisure.note.algorithm.week4.day26;

/**
 * 题目：198. 打家劫舍
 *
 * <p>题目描述：
 *
 * <p>你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定现金，相邻房屋装有连通的防盗系统。
 * 如果两间相邻房屋在同一晚上被偷，系统会自动报警。返回你不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int rob(int[] nums)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：nums = [2,7,9,3,1]
 * 输出：12
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标时间复杂度为 {@code O(n)}</li>
 * <li>允许使用额外空间，也可以继续优化空间复杂度</li>
 * <li>数组中的金额为非负整数</li>
 * <li>相邻房屋不能同时选择，核心是比较“选当前”和“不选当前”两种状态</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练一维 DP 状态转移</li>
 * <li>重点说清“选当前”与“不选当前”的比较</li>
 * </ul>
 */
public class DpQuestion2 {

  public int rob(int[] nums) {
    throw new UnsupportedOperationException("TODO: implement rob");
  }
}
