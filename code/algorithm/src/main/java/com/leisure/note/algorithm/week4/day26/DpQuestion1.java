package com.leisure.note.algorithm.week4.day26;

/**
 * 题目：70. 爬楼梯
 *
 * <p>题目描述：
 *
 * <p>假设你正在爬楼梯，需要 {@code n} 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。问有多少种不同的方法可以爬到楼顶。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int climbStairs(int n)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：n = 2
 * 输出：2
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：n = 3
 * 输出：3
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标时间复杂度为 {@code O(n)}</li>
 * <li>可以使用 {@code O(n)} 或优化到 {@code O(1)} 的额外空间</li>
 * <li>{@code n} 为正整数</li>
 * <li>关键是明确状态定义、转移关系和初始化，而不是直接背斐波那契结论</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练 DP 入门模板</li>
 * <li>重点说清状态、转移和初始化</li>
 * </ul>
 */
public class DpQuestion1 {

  public int climbStairs(int n) {
    // 本题定位：动态规划入门 / 一维 DP。
    // 题型特征：要求“到第 n 阶一共有多少种方法”，并且当前状态只依赖前面少量状态，
    // 所以优先想到把大问题拆成“到每一阶的方法数”。
    // DP 四问：
    // 1. 状态是什么：
    //    dp[i] 表示“爬到第 i 阶台阶时，一共有多少种不同方法”。
    // 2. 转移方程是什么：
    //    最后一步要么从 i - 1 迈 1 步上来，要么从 i - 2 迈 2 步上来，
    //    所以 dp[i] = dp[i - 1] + dp[i - 2]。
    // 3. 初始条件是什么：
    //    dp[0] = 1 表示“什么都不做，停在 0 阶”也算 1 种起点状态；
    //    dp[1] = 1 表示爬到第 1 阶只有 1 种方法。
    // 4. 遍历顺序是什么：
    //    因为 dp[i] 依赖更小的状态，所以从小到大遍历即可。
    // 易错点：
    // 1. 不要把这题只背成“斐波那契”，面试里要先把状态和转移说清。
    // 2. dp[0] 的定义容易漏，它本质上是在给 dp[2] 这类状态提供统一的转移起点。
    if (n < 2) {
      return n;
    }

    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }

  public static void main(String[] args) {
    DpQuestion1 dpQuestion1 = new DpQuestion1();
    System.out.println(dpQuestion1.climbStairs(3));
  }
}
