package com.leisure.note.algorithm.week5.day29;

/**
 * 题目：55. 跳跃游戏
 *
 * <p>题目描述：
 *
 * <p>给定一个非负整数数组 {@code nums}，你最初位于数组的第一个下标。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * <p>方法签名：
 *
 * <pre>
 * public boolean canJump(int[] nums)
 * </pre>
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标思路是贪心，复杂度尽量做到 {@code O(n)}</li>
 * <li>重点不是枚举所有跳法，而是维护当前最远可达边界</li>
 * <li>数组中的元素均为非负整数</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练覆盖范围型贪心</li>
 * <li>重点说清为什么不需要回头枚举每一种跳法</li>
 * </ul>
 */
public class GreedyQuestion1 {

  public boolean canJump(int[] nums) {
    // 本题定位：贪心 / 覆盖范围型。
    // 题型特征：数组元素非负，只问“能不能到终点”，不要求给出具体跳法，
    // 所以重点不是枚举路径，而是看“当前整体最远能覆盖到哪里”。
    // 贪心依据：
    // 1. 对未来是否可达来说，历史上所有能到达的位置里，只有“最远可达边界”最重要。
    // 2. 那些只能跳得更近的位置，都会被更远边界支配，没必要单独保留。
    // 状态定义：
    // maxIndex 表示“遍历到当前位置时，前面所有可达位置综合起来最远能覆盖到的下标”。
    // 易错点：
    // 1. 不要把这题写成“每次真的选一个下一跳落点”，这题只需要维护可达范围，不需要恢复路径。
    // 2. 一旦出现 i > maxIndex，说明当前位置已经不可达，后面更不用看，直接返回 false。
    // 3. 这题和 45 的区别要分清：55 只问能否到达，不需要按层统计步数。
    if (nums == null || nums.length == 0) {
      return false;
    }

    int maxIndex = nums[0];
    for (int i = 0; i < nums.length; i++) {
      if (i <= maxIndex) {
        // 当前位置可达时，才有资格继续扩展整体最远边界。
        maxIndex = Math.max(maxIndex, i + nums[i]);
        if (maxIndex >= nums.length - 1) {
          return true;
        }
      } else {
        // 当前下标已经落在最远可达边界之外，说明这里根本走不到。
        return false;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    GreedyQuestion1 greedyQuestion1 = new GreedyQuestion1();
    System.out.println(greedyQuestion1.canJump(new int[]{3,2,1,0,4}));
  }
}
