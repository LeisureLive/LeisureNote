package com.leisure.note.algorithm.week4.day27;

/**
 * 题目：300. 最长递增子序列
 *
 * <p>题目描述：
 *
 * <p>给你一个整数数组 {@code nums}，找到其中最长严格递增子序列的长度。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int lengthOfLIS(int[] nums)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>这里的“子序列”不要求连续，只要求保持原相对顺序</li>
 * <li>目标先按动态规划版本实现，复杂度可以是 {@code O(n^2)}</li>
 * <li>如果能进一步说出 {@code O(n log n)} 的贪心 + 二分思路，属于加分项</li>
 * <li>数组中元素可以重复，但严格递增要求后一个元素必须大于前一个元素</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练 DP 高频题</li>
 * <li>重点说清状态定义以及为什么这题不要求连续</li>
 * </ul>
 */
public class DpQuestion4 {

  public int lengthOfLIS(int[] nums) {
    throw new UnsupportedOperationException("TODO: implement lengthOfLIS");
  }
}
