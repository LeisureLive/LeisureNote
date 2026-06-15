package com.leisure.note.algorithm.week5.day32;

import java.util.HashMap;
import java.util.Map;

/**
 * Day32 哈希表模式复习题（五）：前缀和 + 哈希表。
 *
 * <p>这一轮按 `02_hashing.md` 里的 `3.5 前缀和 + 哈希表` 收口，重点不是单独背一题，而是把
 * “计数型 / 存在性 / 最长长度 / 同余类”几种常见变体放在一起对照。
 *
 * <p>当前文件覆盖 5 道代表题：
 *
 * <ul>
 * <li>{@code 560. 和为 K 的子数组}</li>
 * <li>{@code 974. 和可被 K 整除的子数组}</li>
 * <li>{@code 523. 连续的子数组和}</li>
 * <li>{@code 930. 和相同的二元子数组}</li>
 * <li>{@code 325. 和等于 k 的最长子数组长度}</li>
 * </ul>
 */
public class HashQuestion5 {

  /**
   * 560. 和为 K 的子数组
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
   * <p>示例：
   *
   * <pre>
   * 输入：nums = [1,1,1], k = 2
   * 输出：2
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用额外空间</li>
   * <li>数组中可能包含负数、零和正数，因此不能直接套普通滑动窗口</li>
   * </ul>
   */
  public int subarraySum(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    Map<Integer, Integer> prefixCount = new HashMap<>();
    prefixCount.put(0, 1);
    int prefixSum = 0;
    int count = 0;
    for (int num : nums) {
      prefixSum += num;
      count += prefixCount.getOrDefault(prefixSum - k, 0);
      prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
    }
    return count;
  }

  /**
   * 974. 和可被 K 整除的子数组
   *
   * <p>题目描述：
   *
   * <p>给定一个整数数组 {@code nums} 和一个整数 {@code k}，返回其中和可被 {@code k} 整除的非空子数组的个数。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int subarraysDivByK(int[] nums, int k)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：nums = [4,5,0,-2,-3,1], k = 5
   * 输出：7
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用额外空间</li>
   * <li>需要注意负数取模后的归一化处理</li>
   * </ul>
   */
  public int subarraysDivByK(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k == 0) {
      return 0;
    }

    Map<Integer, Integer> modCount = new HashMap<>();
    modCount.put(0, 1);
    int prefixSum = 0;
    int count = 0;
    for (int num : nums) {
      prefixSum += num;
      int mod = prefixSum % k;
      if (mod < 0) {
        mod += k;
      }
      count += modCount.getOrDefault(mod, 0);
      modCount.put(mod, modCount.getOrDefault(mod, 0) + 1);
    }
    return count;
  }

  /**
   * 523. 连续的子数组和
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
   * <p>按当前题面约束，`k >= 1`，因此这里直接维护滚动余数。
   */
  public boolean checkSubarraySum(int[] nums, int k) {
    if (nums == null || nums.length < 2 || k == 0) {
      return false;
    }

    Map<Integer, Integer> earliestModIndex = new HashMap<>();
    earliestModIndex.put(0, 0);
    int prefixMod = 0;
    for (int i = 1; i <= nums.length; i++) {
      prefixMod = (prefixMod + nums[i - 1]) % k;
      if (earliestModIndex.containsKey(prefixMod) && i - earliestModIndex.get(prefixMod) >= 2) {
        return true;
      }
      if (!earliestModIndex.containsKey(prefixMod)) {
        earliestModIndex.put(prefixMod, i);
      }
    }
    return false;
  }

  /**
   * 930. 和相同的二元子数组
   *
   * <p>题目描述：
   *
   * <p>给你一个二元数组 {@code nums} 和一个整数 {@code goal}，请返回有多少个非空子数组的元素和等于 {@code goal}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int numSubarraysWithSum(int[] nums, int goal)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：nums = [1,0,1,0,1], goal = 2
   * 输出：4
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用额外空间</li>
   * <li>重点说清为什么这题虽然是二元数组，但仍然可以直接套“前缀和 + 哈希计数”模板</li>
   * </ul>
   */
  public int numSubarraysWithSum(int[] nums, int goal) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    Map<Integer, Integer> prefixCount = new HashMap<>();
    prefixCount.put(0, 1);
    int prefixSum = 0;
    int count = 0;
    for (int num : nums) {
      prefixSum += num;
      count += prefixCount.getOrDefault(prefixSum - goal, 0);
      prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
    }
    return count;
  }

  /**
   * 325. 和等于 k 的最长子数组长度
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
   */
  public int maxSubArrayLen(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    Map<Integer, Integer> earliestIndex = new HashMap<>();
    earliestIndex.put(0, 0);
    int prefixSum = 0;
    int maxLength = 0;
    for (int i = 1; i <= nums.length; i++) {
      prefixSum += nums[i - 1];
      if (earliestIndex.containsKey(prefixSum - k)) {
        maxLength = Math.max(maxLength, i - earliestIndex.get(prefixSum - k));
      }
      if (!earliestIndex.containsKey(prefixSum)) {
        earliestIndex.put(prefixSum, i);
      }
    }
    return maxLength;
  }

  public static void main(String[] args) {
    HashQuestion5 q = new HashQuestion5();
    System.out.println(q.subarraySum(new int[] {1, 1, 1}, 2));
    System.out.println(q.subarraysDivByK(new int[] {4, 5, 0, -2, -3, 1}, 5));
    System.out.println(q.checkSubarraySum(new int[] {23, 2, 4, 6, 7}, 6));
    System.out.println(q.numSubarraysWithSum(new int[] {1, 0, 1, 0, 1}, 2));
    System.out.println(q.maxSubArrayLen(new int[] {1, -1, 5, -2, 3}, 3));
  }
}
