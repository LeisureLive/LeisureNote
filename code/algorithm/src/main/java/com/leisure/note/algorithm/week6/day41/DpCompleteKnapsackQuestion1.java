package com.leisure.note.algorithm.week6.day41;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Day41 动态规划模式题：3.2 完全背包 / 容量 DP。
 *
 * <p>对应 {@code 11_dynamic_programming.md} 的 3.2 小节。
 * 本文件只保留题目描述和方法骨架，不写提示和具体实现。
 */
public class DpCompleteKnapsackQuestion1 {

  /**
   * 279. 完全平方数
   *
   * <p>题目描述：
   *
   * <p>给定一个整数 {@code n}，返回和为 {@code n} 的完全平方数的最少数量。
   *
   * <p>完全平方数是一个整数乘以它自己得到的数，例如 {@code 1}、{@code 4}、{@code 9}、{@code 16}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int numSquares(int n)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：n = 12
   * 输出：3
   * 解释：12 = 4 + 4 + 4，因此最少需要 3 个完全平方数。
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：n = 13
   * 输出：2
   * 解释：13 = 4 + 9，因此最少需要 2 个完全平方数。
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>{@code 1 <= n <= 10^4}</li>
   * <li>只需要返回最少数量，不需要返回具体组合</li>
   * </ul>
   */
  public int numSquares(int n) {
    int maxNum = 1;
    List<Integer> subNums = new ArrayList<>();
    for (; maxNum <= n / 2 + 1; maxNum++) {
      if (maxNum * maxNum > n) {
        break;
      }
      subNums.add(maxNum * maxNum);
    }

    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
      int min = Integer.MAX_VALUE;
      for (int subNum : subNums) {
        if (subNum > i) {
          break;
        }
        min = Math.min(min, dp[i - subNum] + 1);
      }
      dp[i] = min;
    }

    return dp[n];
  }

  /**
   * 518. 零钱兑换 II
   *
   * <p>题目描述：
   *
   * <p>给定不同面额的硬币数组 {@code coins} 和一个总金额 {@code amount}。
   *
   * <p>请计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 {@code 0}。
   *
   * <p>每一种面额的硬币都有无限个。
   *
   * <p>注意这里统计的是组合数，而不是排列数。也就是说，使用相同硬币、只是顺序不同的两种取法，算作同一种组合。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int change(int amount, int[] coins)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：amount = 5, coins = [1,2,5]
   * 输出：4
   * 解释：共有 4 种组合：
   *       5 = 5
   *       5 = 2 + 2 + 1
   *       5 = 2 + 1 + 1 + 1
   *       5 = 1 + 1 + 1 + 1 + 1
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：amount = 3, coins = [2]
   * 输出：0
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>{@code 0 <= amount <= 5000}</li>
   * <li>{@code 1 <= coins.length <= 300}</li>
   * <li>{@code 1 <= coins[i] <= 5000}</li>
   * <li>{@code coins} 中所有值互不相同</li>
   * <li>结果保证在 32 位有符号整数范围内</li>
   * </ul>
   */
  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int coin : coins) {
      for (int i = 1; i <= amount; i++) {
        if (coin <= i) {
          dp[i] += dp[i - coin];
        }
      }
    }
    return dp[amount];
  }

  /**
   * 377. 组合总和 IV
   *
   * <p>题目描述：
   *
   * <p>给定一个由互不相同的正整数组成的数组 {@code nums}，以及一个目标整数 {@code target}。
   *
   * <p>请返回用 {@code nums} 中的元素构成和为 {@code target} 的不同有序序列个数。
   *
   * <p>注意这里统计的是排列数。只要元素顺序不同，就视为不同的答案。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int combinationSum4(int[] nums, int target)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums = [1,2,3], target = 4
   * 输出：7
   * 解释：7 种有序序列分别为：
   *       [1,1,1,1]
   *       [1,1,2]
   *       [1,2,1]
   *       [2,1,1]
   *       [2,2]
   *       [1,3]
   *       [3,1]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums = [9], target = 3
   * 输出：0
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>{@code 1 <= nums.length <= 200}</li>
   * <li>{@code 1 <= nums[i] <= 1000}</li>
   * <li>{@code nums} 中所有元素互不相同</li>
   * <li>{@code 1 <= target <= 1000}</li>
   * <li>结果保证在 32 位有符号整数范围内</li>
   * </ul>
   */
  public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int i = 1; i <= target; i++) {
      for (int num : nums) {
        if (i >= num) {
          dp[i] += dp[i - num];
        }
      }
    }
    return dp[target];
  }
}
