package com.leisure.note.algorithm.week4.day27;

import java.util.Arrays;

/**
 * 题目：322. 零钱兑换
 *
 * <p>题目描述：
 *
 * <p>给你一个整数数组 {@code coins}，表示不同面额的硬币；以及一个整数 {@code amount}，表示总金额。
 * 计算并返回可以凑成总金额所需的最少硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int coinChange(int[] coins, int amount)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：coins = [1,2,5], amount = 11
 * 输出：3
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>每种硬币数量无限</li>
 * <li>目标思路是完全背包 / 动态规划，复杂度尽量做到 {@code O(amount * coins.length)}</li>
 * <li>如果无法凑出总金额，返回 {@code -1}</li>
 * <li>关键边界是不可达状态的初始化和转移时的越界判断</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练完全背包 / DP 进阶</li>
 * <li>重点说清不可达状态的初始化</li>
 * </ul>
 */
public class DpQuestion3 {

  public int coinChange(int[] coins, int amount) {
    // 本题定位：动态规划 / 完全背包 / 一维最值 DP。
    // 题型特征：每种硬币都可以重复使用，目标是“凑出指定金额时所需硬币数最少”，
    // 所以这是典型的“完全背包 + 最小值”问题。
    // DP 四问：
    // 1. 状态是什么：
    //    dp[i] 表示“凑出金额 i 所需的最少硬币个数”。
    // 2. 转移方程是什么：
    //    枚举最后选择的一枚硬币 coin，
    //    如果想凑出 i，那么前面必须先凑出 i - coin，
    //    所以可以从 dp[i - coin] 转移过来：
    //    dp[i] = Math.min(dp[i], dp[i - coin] + 1)。
    // 3. 初始条件是什么：
    //    dp[0] = 0，表示“凑出金额 0 不需要任何硬币”；
    //    其余 dp[1..amount] 先初始化为不可达状态。
    //    这里用 Integer.MAX_VALUE 表示“当前还凑不出来”。
    // 4. 遍历顺序是什么：
    //    因为 dp[i] 依赖比 i 更小的金额状态，所以按金额从小到大遍历即可。
    // 易错点：
    // 1. 不要把初始条件写成 dp[coin] = 1 作为主逻辑。
    //    这些值应该由统一转移自然推出：
    //    当 i == coin 时，dp[i] 会由 dp[0] + 1 得到 1。
    // 2. 真正的递推起点是 dp[0] = 0，而不是某几个硬币面值位置先手动赋值。
    // 3. 不可达状态不能直接参与转移，否则会出现“无意义的 +1”甚至整数溢出风险。
    //    所以只有当 dp[i - coin] 可达时，当前转移才有效。
    // 4. 这题求的是“最少硬币数”，不是“组合数”或“是否可达”，
    //    所以状态语义和返回条件都要围绕“最小值”来写。
    if (amount == 0) {
      return 0;
    }

    int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      int min = Integer.MAX_VALUE;
      for (int coin : coins) {
        if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
          min = Math.min(min, dp[i - coin] + 1);
        }
      }
      dp[i] = min;
    }

    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }

  public static void main(String[] args) {
    DpQuestion3 dpQuestion3 = new DpQuestion3();
    System.out.println(dpQuestion3.coinChange(new int[]{2}, 3));
  }

}
