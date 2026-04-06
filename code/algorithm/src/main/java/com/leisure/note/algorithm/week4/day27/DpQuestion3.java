package com.leisure.note.algorithm.week4.day27;

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
    throw new UnsupportedOperationException("TODO: implement coinChange");
  }
}
