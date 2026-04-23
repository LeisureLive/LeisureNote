package com.leisure.note.algorithm.week5.day30;


/**
 * 题目：45. 跳跃游戏 II
 *
 * <p>题目描述：
 *
 * <p>给定一个长度为 {@code n} 的非负整数数组 {@code nums}，你最初位于数组的第一个下标。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。假设你总是可以到达数组的最后一个位置，
 * 返回到达最后一个位置的最少跳跃次数。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int jump(int[] nums)
 * </pre>
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums = [2,3,1,1,4]
 * 输出：2
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：nums = [2,3,0,1,4]
 * 输出：2
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标思路是贪心，复杂度尽量做到 {@code O(n)}</li>
 * <li>不要用暴力枚举每一次起跳位置的方式求最少步数</li>
 * <li>重点是理解当前一步可覆盖区间与下一步最远可达区间的关系</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练覆盖范围 + 最少跳数贪心</li>
 * <li>重点说清为什么这题像按层推进，而不是暴力试每种跳法</li>
 * </ul>
 */
public class GreedyQuestion1 {

  public int jump(int[] nums) {
    // 本题定位：贪心 / 覆盖范围进阶 / 最少跳数。
    // 题型特征：题目保证一定能到终点，但要求“最少跳几次”，
    // 所以这题不是像 55 一样只判断可达性，而是要按“层”统计步数。
    // 思路理解：
    // 1. curEnd 表示“当前这一步最多能覆盖到的右边界”；
    // 2. nextEnd 表示“把当前层所有位置都看完后，下一步最远能覆盖到哪里”；
    // 3. 当 i 走到 curEnd，说明当前层扫描完了，必须真正跳一次，step++。
    // 这题本质上像把 BFS 的一层区间压缩成顺序遍历，不需要真的用队列或栈。
    // 易错点：
    // 1. 不要写成“每次挑一个下一跳下标”，那样容易把自己绕进路径选择里。
    // 2. for 只遍历到 nums.length - 2，因为最后一个位置是终点，不是起跳点；
    //    如果把最后一个位置也扫进去，容易多记一次步数。
    // 3. step++ 的时机不是“看到更远位置时”，而是“当前层扫完时”。
    if (nums == null || nums.length <= 1) {
      return 0;
    }

    int curEnd = 0;
    int nextEnd = 0;
    int step = 0;
    // i < nums.length - 1，因为 nums.length - 1 是终点，我们扫描的是可以作为起跳点的位置。
    for (int i = 0; i < nums.length - 1; i++) {
      // 扫描当前层时，顺手更新“下一层最远能到哪”。
      nextEnd = Math.max(nextEnd, i + nums[i]);
      if (i == curEnd) {
        step++;
        // 当前层看完后，把边界推进到下一层。
        curEnd = nextEnd;
      }
    }

    return step;
  }

  public static void main(String[] args) {
    GreedyQuestion1 greedyQuestion1 = new GreedyQuestion1();
    System.out.println(greedyQuestion1.jump(new int[] {2, 3, 0, 1, 4}));
  }
}
