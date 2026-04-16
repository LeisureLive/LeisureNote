package com.leisure.note.algorithm.week4.day27;

import java.util.Arrays;

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
    // 本题定位：动态规划 / 一维序列型 DP。
    // 题型特征：题目要求“最长递增子序列”，并且子序列不要求连续，
    // 所以当前位置的答案需要回看它前面的所有位置，判断能否把当前元素接到某条递增序列后面。
    // DP 四问：
    // 1. 状态是什么：
    //    dp[i] 表示“以 nums[i] 结尾的最长递增子序列长度”。
    // 2. 转移方程是什么：
    //    枚举 i 前面的每个位置 j，
    //    如果 nums[i] > nums[j]，说明 nums[i] 可以接在以 nums[j] 结尾的递增子序列后面，
    //    那么就可以从 dp[j] 转移到 dp[i]：
    //    dp[i] = Math.max(dp[i], dp[j] + 1)。
    // 3. 初始条件是什么：
    //    每个元素单独都可以构成长度为 1 的递增子序列，
    //    所以 dp[i] 初始都为 1。
    // 4. 遍历顺序是什么：
    //    因为 dp[i] 依赖 0..i-1 的状态，所以外层从左到右遍历 i，
    //    内层回看 i 前面的所有 j。
    // 易错点：
    // 1. 这题的“子序列”不要求连续，所以不能写成连续子数组那种只看相邻元素的转移。
    // 2. dp[i] 的语义不是“前 i 个元素中的 LIS 长度”，而是“以 i 结尾”的 LIS 长度。
    //    这个语义一旦写错，转移方程就会跟着混乱。
    // 3. 最终答案不是 dp[nums.length - 1]，因为最长递增子序列不一定以最后一个元素结尾，
    //    所以要在所有 dp[i] 里取最大值。
    // 4. 题目要求“严格递增”，所以条件必须是 nums[i] > nums[j]，不能写成 >=。
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);
    int max = 1;
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      max = Math.max(max, dp[i]);
    }

    return max;
  }

  public int lengthOfLISGreedyBinarySearch(int[] nums) {
    // 本题还可以用“贪心 + 二分”优化到 O(n log n)。
    // 这版思路不是去显式求“每个位置结尾的 LIS 长度”，
    // 而是维护一个 tails 数组：
    // tails[k] 表示“长度为 k + 1 的递增子序列中，当前能找到的最小结尾值”。
    //
    // 这里的贪心核心是：
    // 1. 在长度相同的递增子序列里，结尾越小越好；
    // 2. 结尾越小，后面越容易接上更大的数；
    // 3. 所以我们总是尽量把同长度序列的结尾压到最小。
    //
    // 遍历每个 num 时，分两种情况：
    // 1. 如果 num 比当前 tails 的最后一个元素还大，
    //    说明它可以把当前最长递增子序列再延长一位，直接追加到 tails 末尾。
    // 2. 否则，在 tails 中找到第一个 >= num 的位置，用 num 替换它。
    //    这样不会改变已有的最长长度，但会把某个长度对应的结尾变得更小，
    //    从而给未来留下更好的扩展空间。
    //
    // 为什么可以二分：
    // tails 始终保持递增，所以可以在其中二分查找“第一个 >= num 的位置”。
    //
    // 易错点：
    // 1. tails 不是某条真实 LIS 本身，而是“各长度下的最优结尾表”。
    // 2. 替换不是在破坏答案，而是在保留长度信息的同时，让结尾更优。
    // 3. 这题要求严格递增，所以二分时要找的是“第一个 >= num 的位置”。
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int[] tails = new int[nums.length];
    int size = 0;
    for (int num : nums) {
      int left = 0;
      int right = size;
      while (left < right) {
        int mid = left + (right - left) / 2;
        if (tails[mid] < num) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }

      tails[left] = num;
      if (left == size) {
        size++;
      }
    }
    return size;
  }

  public static void main(String[] args) {
    DpQuestion4 dpQuestion4 = new DpQuestion4();
    System.out.println(dpQuestion4.lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
    System.out.println(dpQuestion4.lengthOfLISGreedyBinarySearch(
        new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
  }
}
