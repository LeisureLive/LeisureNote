package com.leisure.note.algorithm.week5.day32;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：523. 连续的子数组和
 *
 * <p>题目描述：
 *
 * <p>给你一个整数数组 {@code nums} 和一个整数 {@code k}，如果 {@code nums} 有一个长度至少为 2 的连续子数组，
 * 其元素总和为 {@code k} 的倍数，返回 {@code true}；否则返回 {@code false}。
 *
 * <p>方法签名：
 *
 * <pre>
 * public boolean checkSubarraySum(int[] nums, int k)
 * </pre>
 *
 * <p>示例：
 *
 * <pre>
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标时间复杂度为 {@code O(n)}</li>
 * <li>允许使用额外空间</li>
 * <li>重点说清为什么这里 map 存的是“某个余数最早出现的位置”</li>
 * <li>还要注意子数组长度至少为 2 这个额外约束</li>
 * </ul>
 *
 * <p>这道题为什么放在 Day32：
 *
 * <ul>
 * <li>对应 `02_hashing.md` 里前缀和 + 哈希的“最早位置型”进阶题</li>
 * <li>适合和 `525`、`325` 一起对照“为什么有时要存位置，不存次数”</li>
 * </ul>
 */
public class PrefixSumHashQuestion2 {

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>哈希专题：前缀和 + 最早位置</li>
   * <li>特征：区间和是否满足“可被 k 整除”，并且子数组长度至少为 2</li>
   * </ul>
   *
   * <p>答题重点：
   *
   * <ol>
   * <li>把“区间和是 k 的倍数”翻译成“两个前缀和对 k 的余数相同”。</li>
   * <li>这里需要保留某个余数最早出现的位置，才能尽量拉长区间，并检查长度约束。</li>
   * <li>遇到同一个余数再次出现时，优先用最早位置做判断，不要覆盖掉它。</li>
   * </ol>
   *
   * <p>注意：
   *
   * <ul>
   * <li>这是 Day32 题目骨架，不直接给标准实现。</li>
   * <li>这题和 `974` 最大的区别是：`974` 统计个数，这题判断存在性并带长度约束。</li>
   * </ul>
   */
  public boolean checkSubarraySum(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return false;
    }

    if (k == 0) {
      // k == 0 时，条件退化成“是否存在长度至少为 2 的连续子数组和为 0”。
      // 这时不能再取模，而是直接判断前缀和是否重复出现且距离至少为 2。
      int[] prefixSum = new int[nums.length + 1];
      Map<Integer, Integer> map = new HashMap<>();
      map.put(0, 0);
      for (int i = 1; i <= nums.length; i++) {
        prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        if (map.containsKey(prefixSum[i]) && i - map.get(prefixSum[i]) >= 2) {
          return true;
        }
        if (!map.containsKey(prefixSum[i])) {
          map.put(prefixSum[i], i);
        }
      }
      return false;
    }

    // prefixSum[i] 表示前 i 个元素的和。
    int[] prefixSum = new int[nums.length + 1];
    prefixSum[0] = 0;
    // map 记录“某个余数最早出现的位置”。
    // 这里初始化成 0 -> 0，是因为当前写法里前缀和位置用的是“前 i 个元素”的位置语义。
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 0);

    // 这里必须遍历到 nums.length。
    // 你之前第一次写时只遍历到 nums.length - 1，
    // 会漏掉“最后一个元素刚好参与组成答案”的情况。
    for (int i = 1; i <= nums.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
      int mod = prefixSum[i] % k;
      if (mod < 0) {
        mod += k;
      }

      // 同一个余数再次出现，说明中间这段区间和能被 k 整除。
      // 再结合长度至少为 2 的约束做判断。
      if (map.containsKey(mod) && i - map.get(mod) >= 2) {
        return true;
      }

      // 位置型题目：只记录最早位置，不覆盖后来的位置。
      if (!map.containsKey(mod)) {
        map.put(mod, i);
      }
    }

    return false;
  }

  public static void main(String[] args) {
    PrefixSumHashQuestion2 p = new PrefixSumHashQuestion2();
    System.out.println(p.checkSubarraySum(new int[]{23,2,4,6,7}, 6));
  }

}
