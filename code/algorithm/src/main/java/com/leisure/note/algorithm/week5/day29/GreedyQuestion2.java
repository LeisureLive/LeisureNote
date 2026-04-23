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
    // 本题定位：贪心 / 维护历史最优状态。
    // 题型特征：只能交易一次，目标是“某天卖出时利润最大”，
    // 所以每一天真正需要的历史信息只有一份：此前最低买入价。
    // 贪心依据：
    // 1. 如果未来打算在第 i 天卖出，那么最优买点一定是 0..i-1 中价格最低的那天。
    // 2. 其他更高的历史价格都会被更低价格支配，不会带来更大利润。
    // 状态定义：
    // minPrice 表示“遍历到当前天之前，历史最低买入价”；
    // maxProfit 表示“遍历到当前天时，能得到的最大利润”。
    // 易错点：
    // 1. 不要把这题写成完整 DP 数组，这题只需维护一个历史最优值。
    // 2. 更顺的语义是“先算今天卖出的利润，再更新历史最低价”，
    //    这样能清楚表达买入日必须在卖出日之前。
    // 3. 如果一路下降，答案应为 0，不是负数。
    if (prices == null || prices.length <= 1) {
      return 0;
    }

    int minPrice = prices[0];
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      // 先把今天当作卖出日，看看搭配历史最低价能赚多少。
      maxProfit = Math.max(maxProfit, prices[i] - minPrice);
      // 再更新历史最低价，留给后面的天作为潜在买点。
      if (prices[i] < minPrice) {
        minPrice = prices[i];
      }
    }

    return maxProfit;
  }

  public static void main(String[] args) {
    GreedyQuestion2 greedyQuestion2 = new GreedyQuestion2();
    System.out.println(greedyQuestion2.maxProfit(new int[]{1}));
    System.out.println(greedyQuestion2.maxProfit(new int[]{7,1,5,3,6,4}));
    System.out.println(greedyQuestion2.maxProfit(new int[]{7,6,4,3,1}));
    System.out.println(greedyQuestion2.maxProfit(new int[]{1,2,3,4,5}));
  }
}
