package com.leisure.note.algorithm.week4.day26;

/**
 * 题目：198. 打家劫舍
 *
 * <p>题目描述：
 *
 * <p>你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定现金，相邻房屋装有连通的防盗系统。
 * 如果两间相邻房屋在同一晚上被偷，系统会自动报警。返回你不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int rob(int[] nums)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：nums = [2,7,9,3,1]
 * 输出：12
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标时间复杂度为 {@code O(n)}</li>
 * <li>允许使用额外空间，也可以继续优化空间复杂度</li>
 * <li>数组中的金额为非负整数</li>
 * <li>相邻房屋不能同时选择，核心是比较“选当前”和“不选当前”两种状态</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练一维 DP 状态转移</li>
 * <li>重点说清“选当前”与“不选当前”的比较</li>
 * </ul>
 */
public class DpQuestion2 {

  public int rob(int[] nums) {
    // 本题定位：动态规划 / 一维最值 DP。
    // 题型特征：每个位置都面临“选当前”还是“不选当前”的决策，
    // 并且相邻位置不能同时选择，这是非常典型的一维 DP 信号。
    // DP 四问：
    // 1. 状态是什么：
    //    dp[i] 表示“考虑下标 0..i 的房屋时，能偷到的最大金额”。
    // 2. 转移方程是什么：
    //    - 不选第 i 间：最大金额就是 dp[i - 1]
    //    - 选第 i 间：因为不能选相邻房屋，所以金额是 dp[i - 2] + nums[i]
    //    二者取最大：
    //    dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i])。
    // 3. 初始条件是什么：
    //    dp[0] = nums[0]
    //    dp[1] = Math.max(nums[0], nums[1])
    // 4. 遍历顺序是什么：
    //    因为当前位置依赖前两个位置，所以从左到右遍历。
    // 易错点：
    // 1. dp[i] 不是“必须偷第 i 间”的最大值，而是“考虑到第 i 间为止”的全局最优。
    // 2. 这题的核心不是贪心地挑更大的房子，而是比较“选 / 不选当前”两种状态。
    // 3. 边界要先处理空数组和只有 1 间房的情况，否则初始化会越界。
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }

    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    return dp[nums.length - 1];
  }

  public static void main(String[] args) {
    DpQuestion2 dpQuestion2 = new DpQuestion2();
    int[] nums = new int[] {2, 7, 9, 3, 1};
    System.out.println(dpQuestion2.rob(nums));
  }
}
