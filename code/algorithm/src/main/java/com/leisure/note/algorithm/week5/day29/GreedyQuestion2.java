package com.leisure.note.algorithm.week5.day29;

/**
 * 题目：121. 买卖股票的最佳时机
 *
 * <p>题目描述：
 *
 * <p>给定一个数组 {@code prices}，它的第 {@code i} 个元素 {@code prices[i]} 表示一支给定股票第 {@code i} 天的价格。
 * 你只能选择某一天买入这只股票，并选择在未来的某一个不同的日子卖出。设计一个算法来计算你所能获取的最大利润。
 * 如果你不能获取任何利润，返回 {@code 0}。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int maxProfit(int[] prices)
 * </pre>
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：5
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标思路是单次遍历 + 贪心，复杂度尽量做到 {@code O(n)}</li>
 * <li>重点不是完整 DP 数组，而是维护历史最小买入价格</li>
 * <li>只能交易一次，先买后卖</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练维护历史最优状态型贪心</li>
 * <li>重点说清为什么只维护一个历史最小值就够了</li>
 * </ul>
 */
public class GreedyQuestion2 {

  public int maxProfit(int[] prices) {
    throw new UnsupportedOperationException("TODO: implement maxProfit");
  }
}
