package com.leisure.note.algorithm.week1.day4;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：525. 连续数组
 *
 * <p>题目描述：
 *
 * <p>给定一个二进制数组 {@code nums}，请返回含有相同数量的 {@code 0} 和 {@code 1} 的最长连续子数组的长度。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int findMaxLength(int[] nums)
 * </pre>
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：整个数组中 0 和 1 的数量相同，所以最长长度为 2。
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：nums = [0,1,0]
 * 输出：2
 * 解释：最长的连续子数组可以是 [0,1] 或 [1,0]。
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标时间复杂度为 {@code O(n)}</li>
 * <li>允许使用额外空间</li>
 * <li>不接受暴力枚举所有子数组的 {@code O(n^2)} 解法</li>
 * <li>数组元素只包含 {@code 0} 和 {@code 1}</li>
 * <li>返回的是最长连续子数组的长度，不是子数组个数</li>
 * </ul>
 *
 * <p>答题顺序要求：
 *
 * <ol>
 * <li>先复述题目要求和限制条件</li>
 * <li>先判断题型，并说明为什么它本质上仍然是前缀和 + 哈希表</li>
 * <li>先口头说明如何把“0 和 1 数量相同”转成“前缀和相等”</li>
 * <li>再补代码实现</li>
 * <li>最后说明复杂度、边界和易错点</li>
 * </ol>
 *
 * <p>答题框架：
 *
 * <ol>
 * <li>先做等价转换：把 {@code 0} 看成 {@code -1}，把 {@code 1} 看成 {@code +1}</li>
 * <li>这样题目就变成：求和为 {@code 0} 的最长连续子数组长度</li>
 * <li>定义前缀和：{@code prefixSum} 表示从下标 {@code 0} 到当前位置的累加和</li>
 * <li>如果两个位置的前缀和相等，说明这两个位置之间的子数组和为 {@code 0}</li>
 * <li>哈希表记录“某个前缀和第一次出现的位置”</li>
 * <li>遍历时：
 * 如果当前前缀和第一次出现，就记录当前位置；
 * 如果之前出现过，就用当前下标减去最早出现位置，更新最大长度</li>
 * <li>初始化时放入 {@code 0 -> -1}，表示在数组开始前，前缀和 {@code 0} 已经出现过</li>
 * <li>最后补复杂度和边界：空数组、全 0、全 1、前缀本身就满足条件等情况</li>
 * </ol>
 *
 * <p>注意：
 *
 * <ul>
 * <li>这是出题骨架文件，只保留方法签名，不直接给标准实现</li>
 * <li>这题和 560 的区别很重要：560 统计“个数”，所以 map 存次数；525 求“最长长度”，所以 map 存最早位置</li>
 * </ul>
 */
public class PrefixSumHashQuestion2 {

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>哈希专题：前缀和 + 哈希位置</li>
   * <li>特征：求最长长度，不是求区间个数</li>
   * </ul>
   *
   * <p>思路：
   *
   * <ol>
   * <li>先把 `0/1` 问题等价转换成 `-1/+1` 的前缀和问题。</li>
   * <li>如果两个位置前缀和相同，说明中间这段区间和为 0，也就意味着 `0` 和 `1` 数量相同。</li>
   * <li>因为要求最长长度，所以哈希表要记录“最早出现位置”，这样才能拉出最长区间。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>时间复杂度 {@code O(n)}，能把“最长平衡区间”问题转成前缀和等值问题。</li>
   * <li>很适合和 `560` 对照理解“存次数”和“存位置”的差异。</li>
   * </ul>
   *
   * <p>缺点：
   *
   * <ul>
   * <li>等价转换如果没想清楚，就容易停留在题面上绕不出来。</li>
   * <li>初始化 {@code 0 -> -1} 的含义如果讲不清，面试里容易被追问。</li>
   * </ul>
   *
   * <p>变体应对：
   *
   * <ul>
   * <li>如果改成求“有多少段”，通常 map 就要存次数，而不是最早位置。</li>
   * <li>如果题目不再是二进制数组，而是其他平衡条件，也可以尝试找等价转换后的前缀关系。</li>
   * </ul>
   */
  public int findMaxLength(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int prefixSum = 0;
    int maxLength = 0;
    Map<Integer, Integer> prefixSumMap = new HashMap<>();
    prefixSumMap.put(0, -1);
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        prefixSum += -1;
      } else {
        prefixSum += 1;
      }

      if (prefixSumMap.get(prefixSum) != null) {
        maxLength = Math.max(maxLength, i - prefixSumMap.get(prefixSum));
      } else {
        prefixSumMap.put(prefixSum, i);
      }
    }
    return maxLength;
  }

  public static void main(String[] args) {
    PrefixSumHashQuestion2 question2 = new PrefixSumHashQuestion2();
    int[] nums = new int[] {0, 1, 0};
    System.out.println(question2.findMaxLength(nums));
  }
}
