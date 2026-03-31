package com.leisure.note.algorithm.week1.day3;

/**
 * 题目：209. 长度最小的子数组
 *
 * <p>题目描述：
 *
 * <p>给定一个含有 {@code n} 个正整数的数组 {@code nums} 和一个正整数 {@code target}，
 * 请你找出该数组中满足其总和大于等于 {@code target} 的长度最小的连续子数组，并返回其长度。
 * 如果不存在符合条件的子数组，返回 {@code 0}。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int minSubArrayLen(int target, int[] nums)
 * </pre>
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 解释：子数组 [4] 已经满足条件，所以最短长度为 1。
 * </pre>
 *
 * <p>示例 3：
 *
 * <pre>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * 解释：不存在满足和大于等于 11 的连续子数组。
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 *   <li>目标时间复杂度为 {@code O(n)}</li>
 *   <li>允许使用 {@code O(1)} 额外空间</li>
 *   <li>不接受暴力枚举所有子数组的 {@code O(n^2)} 解法</li>
 *   <li>注意：数组元素都是正整数，这个条件非常关键</li>
 * </ul>
 *
 * <p>答题框架：
 *
 * <ol>
 *   <li>先说明为什么这是滑动窗口题：连续子数组 + 最短 + 窗口和约束</li>
 *   <li>定义窗口：左右指针 {@code left}/{@code right} 表示当前连续子数组区间</li>
 *   <li>定义状态：维护当前窗口元素和 {@code windowSum}</li>
 *   <li>扩张规则：右指针向右移动，把新元素加入窗口和</li>
 *   <li>收缩规则：当 {@code windowSum >= target} 时，尝试移动左指针缩小窗口并更新答案</li>
 *   <li>关键条件：数组元素都是正整数，所以左指针右移后窗口和一定不会变大</li>
 *   <li>最后补复杂度和边界：空数组、单元素数组、不存在满足条件的子数组</li>
 * </ol>
 *
 * <p>注意：
 *
 * <ul>
 *   <li>这是出题骨架文件，只保留方法签名，不直接给标准实现</li>
 *   <li>答题时先口头说明思路，再补代码</li>
 * </ul>
 */
public class SlidingWindowQuestion2 {

  public int minSubArrayLen(int target, int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int i = 0;
    int j = 0;
    int sum = 0;
    int length = 0;
    while (j < nums.length) {
      sum += nums[j];
      j++;
      while (sum >= target) {
        length = length == 0 ? j - i : Math.min(length, j - i);
        sum -= nums[i];
        i++;
      }
    }
    return length;
  }

  public static void main(String[] args) {
    SlidingWindowQuestion2 question2 = new SlidingWindowQuestion2();
    int target = 7;
    int[] nums = new int[] {2, 3, 1, 2, 4, 3};
    System.out.println(question2.minSubArrayLen(target, nums));
  }
}
