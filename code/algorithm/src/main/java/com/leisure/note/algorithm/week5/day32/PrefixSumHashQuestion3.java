package com.leisure.note.algorithm.week5.day32;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：930. 和相同的二元子数组
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
 *
 * <p>这道题为什么放在 Day32：
 *
 * <ul>
 * <li>对应 `02_hashing.md` 里前缀和 + 哈希的“计数型”扩展题</li>
 * <li>它和 `560` 本质几乎同构，适合做模板迁移训练</li>
 * </ul>
 */
public class PrefixSumHashQuestion3 {

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>哈希专题：前缀和 + 哈希计数</li>
   * <li>特征：统计满足条件的区间个数，map 存的是“某个前缀和出现过几次”</li>
   * </ul>
   *
   * <p>答题重点：
   *
   * <ol>
   * <li>把区间和改写成前缀和之差。</li>
   * <li>当当前前缀和是 {@code prefixSum} 时，历史上每出现一次 {@code prefixSum - goal}，就贡献一个答案。</li>
   * <li>核心仍然是“先统计答案，再更新当前前缀和次数”。</li>
   * </ol>
   *
   * <p>注意：
   *
   * <ul>
   * <li>这是 Day32 题目骨架，不直接给标准实现。</li>
   * <li>这题最值得和 `560` 成组复盘，看你能不能做到不看答案就直接迁移模板。</li>
   * </ul>
   */
  public int numSubarraysWithSum(int[] nums, int goal) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    // prefixSum[i] 表示前 i 个元素的和。
    int[] prefixSum = new int[nums.length + 1];
    prefixSum[0] = 0;
    // map 记录“某个前缀和出现过几次”。
    // 先放入 0 -> 1，表示空前缀已经出现过一次。
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int res = 0;
    for (int i = 1; i <= nums.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
      int expect = prefixSum[i] - goal;

      // 当前前缀和是 prefixSum[i] 时，
      // 历史上每出现一次 prefixSum[i] - goal，就新增一个合法子数组。
      res += map.getOrDefault(expect, 0);

      // 计数型前缀和模板：先统计答案，再更新当前前缀和出现次数。
      map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
    }
    return res;
  }

  public static void main(String[] args) {
    PrefixSumHashQuestion3 p = new PrefixSumHashQuestion3();
    System.out.println(p.numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
  }
}
