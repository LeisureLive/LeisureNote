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

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>数组专题：滑动窗口</li>
   * <li>特征：连续子数组 + 最短 + 窗口和达到目标值</li>
   * </ul>
   *
   * <p>思路：
   *
   * <ol>
   * <li>维护窗口和 {@code sum}，右指针不断扩张窗口。</li>
   * <li>一旦 {@code sum >= target}，就尝试移动左指针收缩窗口，并更新当前最短长度。</li>
   * <li>因为数组元素全为正数，所以左指针右移后窗口和只会变小，这个单调性保证了窗口做法成立。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>时间复杂度 {@code O(n)}，额外空间 {@code O(1)}。</li>
   * <li>非常适合训练“窗口合法条件”和“收缩时机”这两个滑动窗口核心点。</li>
   * </ul>
   *
   * <p>缺点：
   *
   * <ul>
   * <li>强依赖“数组元素都是正整数”这个前提。</li>
   * <li>一旦数组里允许负数，这个窗口单调性就不存在了。</li>
   * </ul>
   *
   * <p>变体应对：
   *
   * <ul>
   * <li>如果题目改成“最长”或“恰好等于某值”，窗口定义和更新时机可能会变化。</li>
   * <li>如果允许负数，通常需要改用前缀和或更复杂的数据结构，而不能机械套本题模板。</li>
   * </ul>
   */
  public int minSubArrayLen(int target, int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int i = 0;
    int j = 0;
    int sum = 0;
    int length = 0;
    while (j < nums.length) {
      // 注意相比 day3 第一题，这里的右边界 j 每次都要扩张，因为 nums[j] 每次都被纳入了窗口
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
