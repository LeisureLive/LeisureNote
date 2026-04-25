package com.leisure.note.algorithm.week5.day31;

/**
 * 题目：485. 最大连续 1 的个数
 *
 * <p>题目描述：
 *
 * <p>给定一个二进制数组 {@code nums}，计算其中最大连续 {@code 1} 的个数。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int findMaxConsecutiveOnes(int[] nums)
 * </pre>
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1，所以最大连续 1 的个数是 3。
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标时间复杂度为 {@code O(n)}</li>
 * <li>尽量只做一次线性扫描</li>
 * <li>输入数组只包含 {@code 0} 和 {@code 1}</li>
 * </ul>
 *
 * <p>注意：
 *
 * <ul>
 * <li>这是 Day31 复习题骨架，只保留题面和方法签名</li>
 * <li>当前这版已补上你本次复习最需要记住的滑动窗口注释，重点不是背答案，而是记住窗口不变量和边界语义</li>
 * </ul>
 *
 * <p>本题复习重点：
 *
 * <ul>
 * <li>不要只把它看成“数连续 1”，而要能转成“求窗口内 0 的个数为 0 的最长子数组”</li>
 * <li>滑动窗口不是左右指针随意移动，而是先定义窗口合法条件，再统一处理扩张、收缩和答案更新</li>
 * <li>这题最容易写错的点不是思路本身，而是右边界推进时机和区间语义</li>
 * </ul>
 *
 * <p>这题当前采用的窗口语义：
 *
 * <ul>
 * <li>窗口使用右开区间 {@code [left, right)}</li>
 * <li>{@code right} 表示“下一个准备进入窗口的位置”，不是当前窗口最后一个元素的位置</li>
 * <li>因此窗口长度是 {@code right - left}，不是 {@code right - left + 1}</li>
 * </ul>
 *
 * <p>这次复习暴露出的典型错误：
 *
 * <ul>
 * <li>如果只在 {@code nums[right] == 1} 时才推进 {@code right}，而遇到 {@code 0} 不推进，就会反复处理同一个 {@code 0}</li>
 * <li>这样会导致 {@code left} 持续右移，最终可能访问到越界位置</li>
 * <li>正确顺序应该是：先把 {@code nums[right]} 纳入窗口状态，再推进 {@code right}，然后根据是否合法决定是否收缩 {@code left}</li>
 * </ul>
 */
public class SlidingWindowReviewQuestion1 {

  public int findMaxConsecutiveOnes(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int left = 0;
    int right = 0;
    int zeroCount = 0;
    int maxCount = 0;
    while (right < nums.length) {
      // 第一步：把 nums[right] 纳入当前窗口状态。
      // 这题的合法条件是“窗口内 0 的个数必须为 0”，所以只需要维护 zeroCount。
      if (nums[right] == 0) {
        zeroCount++;
      }

      // 第二步：无论当前是 0 还是 1，right 都要推进。
      // 因为当前实现采用的是右开区间 [left, right)，
      // 一旦 nums[right] 已经被统计进窗口状态，就应该让 right 指向下一个待进入位置。
      //
      // 你前一版的核心错误就在这里：
      // 只在遇到 1 时推进 right，遇到 0 不推进，
      // 会导致同一个 0 被重复处理，窗口状态和指针位置脱节。
      right++;

      // 第三步：如果窗口不合法（包含 0），就收缩左边界，直到窗口重新合法。
      // 这里的 while 不是“遇到问题就重开一段”，而是标准滑窗的“修复窗口”动作。
      while (zeroCount > 0) {
        if (nums[left] == 0) {
          zeroCount--;
        }
        left++;
      }

      // 第四步：窗口重新合法后更新答案。
      // 当前窗口是 [left, right)，所以长度是 right - left。
      // 如果你采用的是闭区间 [left, right]，这里才会写成 right - left + 1，
      // 但那种写法要求 right 的推进顺序和更新时机也一起对应调整。
      maxCount = Math.max(maxCount, right - left);
    }

    return maxCount;
  }

  public static void main(String[] args) {
    SlidingWindowReviewQuestion1 slidingWindowReviewQuestion1 = new SlidingWindowReviewQuestion1();
    System.out.println(slidingWindowReviewQuestion1.findMaxConsecutiveOnes(new int[] {1,0,1,1,0,1}));
  }
}
