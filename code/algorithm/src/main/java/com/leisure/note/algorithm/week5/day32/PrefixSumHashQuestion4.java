package com.leisure.note.algorithm.week5.day32;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：325. 和等于 k 的最长子数组长度
 *
 * <p>题目描述：
 *
 * <p>给定一个整数数组 {@code nums} 和一个整数 {@code k}，返回和等于 {@code k} 的最长连续子数组的长度。
 * 如果不存在任意一个符合要求的子数组，则返回 {@code 0}。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int maxSubArrayLen(int[] nums, int k)
 * </pre>
 *
 * <p>示例：
 *
 * <pre>
 * 输入：nums = [1,-1,5,-2,3], k = 3
 * 输出：4
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标时间复杂度为 {@code O(n)}</li>
 * <li>允许使用额外空间</li>
 * <li>重点说清为什么这题必须存“最早位置”，不能存“最近位置”</li>
 * </ul>
 *
 * <p>这道题为什么放在 Day32：
 *
 * <ul>
 * <li>对应 `02_hashing.md` 里前缀和 + 哈希的“最长长度型”代表题</li>
 * <li>很适合和 `560`、`525` 做“三题对照”：次数、最早位置、最长长度</li>
 * </ul>
 */
public class PrefixSumHashQuestion4 {

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>哈希专题：前缀和 + 最早位置</li>
   * <li>特征：不是统计个数，而是尽量让区间更长，因此要保留最早出现位置</li>
   * </ul>
   *
   * <p>答题重点：
   *
   * <ol>
   * <li>区间和等于 {@code k} 仍然可以转成“当前前缀和 - 历史前缀和 = k”。</li>
   * <li>要让区间最长，就应该尽量把左端点压到更早，因此 map 存最早位置。</li>
   * <li>同一个前缀和再次出现时，通常不覆盖最早位置。</li>
   * </ol>
   *
   * <p>注意：
   *
   * <ul>
   * <li>这是 Day32 题目骨架，不直接给标准实现。</li>
   * <li>这题和 `560` 最大的区别不是公式，而是 map 里 value 的含义变化了。</li>
   * </ul>
   */
  public int maxSubArrayLen(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    // prefixSum[i] 表示前 i 个元素的和。
    int[] prefixSum = new int[nums.length + 1];
    prefixSum[0] = 0;
    // map 记录“某个前缀和第一次出现的位置”。
    // 这里放 0 -> 0，因为当前用的是前缀数组位置语义，而不是原数组下标语义。
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 0);
    int res = 0;
    for (int i = 1; i <= nums.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
      int expect = prefixSum[i] - k;
      if (map.containsKey(expect)) {
        // 要让区间尽量长，就必须和“最早出现的 expect”做差。
        res = Math.max(res, i - map.get(expect));
      }

      // 长度型题目：只保留最早位置，后面重复出现时不覆盖。
      if (!map.containsKey(prefixSum[i])) {
        map.put(prefixSum[i], i);
      }
    }

    return res;
  }

  public static void main(String[] args) {
    PrefixSumHashQuestion4 p = new PrefixSumHashQuestion4();
    System.out.println(p.maxSubArrayLen(new int[]{1,-1,5,-2,3}, 3));
  }
}
