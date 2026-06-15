package com.leisure.note.algorithm.week6.day41;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Day41 动态规划模式题：3.1 一维线性 DP / 线性递推型。
 *
 * <p>对应 {@code 11_dynamic_programming.md} 的 3.1 小节。
 * 本文件只保留题目描述和方法骨架，不写提示和具体实现。
 */
public class DpLinearRecurrenceQuestion1 {

  /**
   * 509. 斐波那契数
   *
   * <p>题目描述：
   *
   * <p>斐波那契数列定义如下：
   *
   * <pre>
   * F(0) = 0，F(1) = 1
   * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
   * </pre>
   *
   * <p>给定整数 {@code n}，请返回第 {@code n} 个斐波那契数 {@code F(n)}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int fib(int n)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：n = 2
   * 输出：1
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：n = 4
   * 输出：3
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>{@code 0 <= n <= 30}</li>
   * <li>结果保证在 {@code int} 范围内</li>
   * </ul>
   */
  public int fib(int n) {
    if (n == 0 || n == 1) {
      return n;
    }
    int[] fn = new int[n + 1];
    fn[0] = 0;
    fn[1] = 1;
    for (int i = 2; i <= n; i++) {
      fn[i] = fn[i - 1] + fn[i - 2];
    }
    return fn[n];
  }

  /**
   * 746. 使用最小花费爬楼梯
   *
   * <p>题目描述：
   *
   * <p>给定一个整数数组 {@code cost}，其中 {@code cost[i]} 是从楼梯第 {@code i} 个台阶向上爬时需要支付的费用。
   *
   * <p>一旦支付了该费用，你可以选择向上爬一个台阶或两个台阶。你可以从下标 {@code 0} 或下标 {@code 1} 作为起点开始爬楼梯。
   *
   * <p>请返回到达楼梯顶部的最低花费。楼梯顶部是数组最后一个下标之后的位置，不对应 {@code cost} 中的某一项。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int minCostClimbingStairs(int[] cost)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：cost = [10,15,20]
   * 输出：15
   * 解释：从下标 1 开始，先支付 15，然后直接跨两级到达顶部，总花费最小。
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
   * 输出：6
   * 解释：一种最低花费方案是依次踩到费用为 1 的台阶，避开高花费台阶。
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>{@code 2 <= cost.length <= 1000}</li>
   * <li>{@code 0 <= cost[i] <= 999}</li>
   * <li>只需要返回最低花费，不需要返回具体路径</li>
   * </ul>
   */
  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int[] dp = new int[n];
    dp[0] = cost[0];
    dp[1] = cost[1];
    for (int i = 2; i < n; i++) {
      dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
    }

    return Math.min(dp[n - 1], dp[n - 2]);
  }

  /**
   * 91. 解码方法
   *
   * <p>题目描述：
   *
   * <p>一条包含字母 {@code A-Z} 的消息通过以下映射进行了编码：
   *
   * <pre>
   * 'A' -> "1"
   * 'B' -> "2"
   * ...
   * 'Z' -> "26"
   * </pre>
   *
   * <p>给定一个只包含数字的非空字符串 {@code s}，请计算它有多少种解码方法。
   *
   * <p>如果某种切分方式中出现了无法映射成字母的片段，则该切分方式无效。例如：
   *
   * <pre>
   * "06" 无法解码，因为 "6" 可以映射为 "F"，但前导零 "06" 不是一个合法编码。
   * </pre>
   *
   * <p>方法签名：
   *
   * <pre>
   * public int numDecodings(String s)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：s = "12"
   * 输出：2
   * 解释：可以解码为 "AB"（1 2）或者 "L"（12）。
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：s = "226"
   * 输出：3
   * 解释：可以解码为 "BZ"（2 26）、"VF"（22 6）或者 "BBF"（2 2 6）。
   * </pre>
   *
   * <p>示例 3：
   *
   * <pre>
   * 输入：s = "06"
   * 输出：0
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>{@code 1 <= s.length <= 100}</li>
   * <li>{@code s} 只包含数字字符</li>
   * <li>返回值保证在 {@code int} 范围内</li>
   * </ul>
   */
  public int numDecodings(String s) {
    int n = s.length();
    Map<Integer, Character> map = new HashMap<>();
    for (int i = 0; i <= 25; i++) {
      char ch = (char) ('A' + i);
      map.put(i + 1, ch);
    }
    int[] dp = new int[n + 1];
    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
      int key = Integer.parseInt(String.valueOf(s.charAt(i - 1)));
      if (map.containsKey(key)) {
        dp[i] += dp[i - 1];
      }

      if (i >= 2) {
        String sub = s.substring(i - 2, i);
        if (sub.charAt(0) == '0') {
          continue;
        }
        key = Integer.parseInt(sub);
        if (map.containsKey(key)) {
          dp[i] += dp[i - 2];
        }
      }

    }
    return dp[n];
  }
}
