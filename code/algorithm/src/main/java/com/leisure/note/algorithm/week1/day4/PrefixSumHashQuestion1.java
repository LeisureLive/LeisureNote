package com.leisure.note.algorithm.week1.day4;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：560. 和为 K 的子数组
 *
 * <p>题目描述：
 *
 * <p>给定一个整数数组 {@code nums} 和一个整数 {@code k}，请你返回和为 {@code k} 的连续子数组的个数。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int subarraySum(int[] nums, int k)
 * </pre>
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 解释：满足条件的连续子数组是 [1,1]（下标 0 到 1）和 [1,1]（下标 1 到 2）。
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * 解释：满足条件的连续子数组是 [1,2] 和 [3]。
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标时间复杂度为 {@code O(n)}</li>
 * <li>允许使用额外空间</li>
 * <li>不接受暴力枚举所有子数组的 {@code O(n^2)} 解法</li>
 * <li>数组元素可能包含负数、零和正数，这一点非常关键</li>
 * <li>返回的是满足条件的连续子数组个数，不是任意一个区间</li>
 * </ul>
 *
 * <p>答题顺序要求：
 *
 * <ol>
 * <li>先复述题目要求和限制条件</li>
 * <li>先判断题型，并说明为什么普通滑动窗口不适合这题</li>
 * <li>先口头说清前缀和 + 哈希表的思路</li>
 * <li>再补代码实现</li>
 * <li>最后说明复杂度、边界和易错点</li>
 * </ol>
 *
 * <p>答题框架：
 *
 * <ol>
 * <li>先说明为什么这是前缀和 + 哈希表题：连续子数组求和 + 需要在线统计个数 + 存在负数</li>
 * <li>定义前缀和：{@code prefixSum} 表示从下标 {@code 0} 到当前位置的元素和</li>
 * <li>定义哈希表：{@code prefixCount} 记录“某个前缀和出现过几次”</li>
 * <li>关键等式：如果当前位置前缀和是 {@code prefixSum}，那么只要之前出现过 {@code prefixSum - k}，就说明存在若干个区间和为 {@code k}</li>
 * <li>初始化：先放入 {@code prefixCount.put(0, 1)}，表示空前缀出现过一次</li>
 * <li>遍历时先统计答案，再更新当前前缀和出现次数，避免把当前前缀和自己提前匹配上</li>
 * <li>最后补复杂度和边界：空数组、包含负数、包含 0、存在多个重叠区间等情况</li>
 * </ol>
 *
 * <p>注意：
 *
 * <ul>
 * <li>这是出题骨架文件，只保留方法签名，不直接给标准实现</li>
 * <li>这题不能直接套普通滑动窗口，因为数组里可能有负数，窗口右移后区间和不具备单调性</li>
 * </ul>
 */
public class PrefixSumHashQuestion1 {

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>哈希专题：前缀和 + 哈希计数</li>
   * <li>特征：连续子数组求和 + 统计个数 + 数组中可能有负数</li>
   * </ul>
   *
   * <p>思路：
   *
   * <ol>
   * <li>把区间和改写成两个前缀和之差。</li>
   * <li>遍历到当前位置时，如果当前前缀和是 {@code prefixSum}，那么历史上每出现一次 {@code prefixSum - k}，就贡献一个答案。</li>
   * <li>因此哈希表存的是“前缀和出现次数”，而不是位置。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>能处理包含负数的情况，这是普通滑动窗口做不到的。</li>
   * <li>时间复杂度 {@code O(n)}，适合在线统计区间个数。</li>
   * </ul>
   *
   * <p>缺点：
   *
   * <ul>
   * <li>需要额外的哈希表空间。</li>
   * <li>初始化和更新顺序容易写错，尤其是 {@code 0 -> 1} 和“先统计再更新”。</li>
   * </ul>
   *
   * <p>变体应对：
   *
   * <ul>
   * <li>如果题目改成求“最长长度”，通常 map 不再存次数，而是存最早出现位置，例如 `525`。</li>
   * <li>如果数组元素全为正数且只求最短 / 最长满足条件的区间，有时可以退回到滑动窗口。</li>
   * </ul>
   */
  public int subarraySum(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    Map<Integer, Integer> prefixCountMap = new HashMap<>();
    prefixCountMap.put(0, 1);
    int prefixSum = 0;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      prefixSum += nums[i];
      count += prefixCountMap.getOrDefault(prefixSum - k, 0);
      prefixCountMap.put(prefixSum, prefixCountMap.getOrDefault(prefixSum, 0) + 1);
    }
    return count;
  }

  public static void main(String[] args) {
    PrefixSumHashQuestion1 question1 = new PrefixSumHashQuestion1();
    int[] nums = new int[] {1, 1, 1};
    System.out.println(question1.subarraySum(nums, 2));
  }
}
