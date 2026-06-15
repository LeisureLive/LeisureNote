package com.leisure.note.algorithm.week6.day41;

/**
 * Day41 动态规划模式题：3.1 一维线性 DP / 选或不选型。
 *
 * <p>对应 {@code 11_dynamic_programming.md} 的 3.1 小节。
 * 本文件只保留题目描述和方法骨架，不写提示和具体实现。
 */
public class DpDecisionQuestion1 {

  /**
   * 213. 打家劫舍 II
   *
   * <p>题目描述：
   *
   * <p>你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定金额。
   *
   * <p>这一次所有的房屋都围成一个圈，这意味着第一个房屋和最后一个房屋是相邻的。
   * 如果两间相邻房屋在同一晚上被偷，系统会自动报警。
   *
   * <p>给定一个代表每个房屋存放金额的非负整数数组 {@code nums}，请返回在不触动警报装置的情况下，今晚能够偷窃到的最高金额。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int rob(int[] nums)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums = [2,3,2]
   * 输出：3
   * 解释：因为第一个房屋和最后一个房屋相邻，不能同时偷，最高金额为 3。
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums = [1,2,3,1]
   * 输出：4
   * 解释：可以偷第 1 间和第 3 间房屋（下标从 0 开始时为下标 0 和 2），总金额为 4。
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>{@code 1 <= nums.length <= 100}</li>
   * <li>{@code 0 <= nums[i] <= 1000}</li>
   * <li>只需要返回最大金额，不需要返回具体偷窃方案</li>
   * </ul>
   */
  public int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }

    if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }

    // 从 0 —> i 最大金额
    int[] dp = new int[nums.length];
    // 从 1 —> i 最大金额
    int[] bp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    bp[1] = nums[1];
    bp[2] = Math.max(nums[1], nums[2]);
    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
      if (i >= 3) {
        bp[i] = Math.max(bp[i - 2] + nums[i], bp[i - 1]);
      }
    }

    int n = nums.length - 1;
    // 偷第一家不偷最后一家 、 偷最后一家不偷第一家
    return Math.max(dp[n - 1], bp[n]);
  }

  /**
   * 740. 删除并获得点数
   *
   * <p>题目描述：
   *
   * <p>给定一个整数数组 {@code nums}，你可以对它执行若干次操作。
   *
   * <p>每次操作中，选择任意一个 {@code nums[i]} 并删除它，从而获得 {@code nums[i]} 点数。
   * 之后，所有等于 {@code nums[i] - 1} 和 {@code nums[i] + 1} 的元素也必须同时从数组中删除。
   *
   * <p>请返回你能获得的最大点数。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int deleteAndEarn(int[] nums)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums = [3,4,2]
   * 输出：6
   * 解释：先删除 4 得到 4 分会同时删除 3，剩余只能再拿 2，总分为 6；
   *       删除 3 只能得到 3 分，因此最优答案是 6。
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums = [2,2,3,3,3,4]
   * 输出：9
   * 解释：如果选择数值 3，可以得到 3 + 3 + 3 = 9 分，
   *       同时所有 2 和 4 都会被删除，因此最优答案为 9。
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>{@code 1 <= nums.length <= 2 * 10^4}</li>
   * <li>{@code 1 <= nums[i] <= 10^4}</li>
   * <li>结果保证在 {@code int} 范围内</li>
   * </ul>
   */
  public int deleteAndEarn(int[] nums) {
    int maxVal = 0;
    for (int num : nums) {
      maxVal = Math.max(maxVal, num);
    }
    int[] sum = new int[maxVal + 1];
    for (int num : nums) {
      sum[num] += num;
    }

    int first = sum[0];
    int second = Math.max(sum[0], sum[1]);
    for (int i = 2; i < sum.length; i++) {
      int val = Math.max(first + sum[i], second);
      first = second;
      second = val;
    }

    return second;
  }

  public static void main(String[] args) {
    DpDecisionQuestion1 question1 = new DpDecisionQuestion1();
//    System.out.println(question1.rob(new int[] {1, 2, 3, 1}));
    System.out.println(question1.deleteAndEarn(new int[] {2, 2, 3, 3, 3, 4}));
  }
}
