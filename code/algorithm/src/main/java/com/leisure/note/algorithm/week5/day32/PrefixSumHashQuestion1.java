package com.leisure.note.algorithm.week5.day32;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：974. 和可被 K 整除的子数组
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
 * <li>重点说清哈希表里为什么存“某个余数出现过几次”</li>
 * <li>需要注意负数取模后的归一化处理</li>
 * </ul>
 *
 * <p>这道题为什么放在 Day32：
 *
 * <ul>
 * <li>对应 `02_hashing.md` 里的 `3.5 前缀和 + 哈希表`</li>
 * <li>它和 `560`、`525` 同属前缀和 + 哈希，但这里的状态是“前缀和余数”，很适合做二轮扩展</li>
 * </ul>
 */
public class PrefixSumHashQuestion1 {

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>哈希专题：前缀和 + 哈希计数</li>
   * <li>特征：把“区间和可被 k 整除”翻译成“两个前缀和对 k 的余数相同”</li>
   * </ul>
   *
   * <p>答题重点：
   *
   * <ol>
   * <li>先定义滚动前缀和，再把条件改写成余数关系。</li>
   * <li>如果两个前缀和对 {@code k} 的余数相同，它们的差就能被 {@code k} 整除。</li>
   * <li>因此哈希表存的是“某个余数出现过几次”。</li>
   * <li>注意 Java 负数取模可能为负，需要先归一化到 {@code [0, k)}。</li>
   * </ol>
   *
   * <p>注意：
   *
   * <ul>
   * <li>这是 Day32 题目骨架，不直接给标准实现。</li>
   * <li>这题很适合和 `560` 对照：前者查的是 {@code prefixSum - k}，这里查的是“同余类出现次数”。</li>
   * </ul>
   */
  public int subarraysDivByK(int[] nums, int k) {
    if (nums == null || nums.length == 0) return 0;
    if (k == 0) return 0;

    // prefixSum[i] 表示前 i 个元素的和，因此长度是 nums.length + 1。
    int[] prefixSum = new int[nums.length + 1];
    prefixSum[0] = 0;
    // map 记录“某个余数出现过几次”。
    // 先放入 0 -> 1，表示空前缀的余数为 0，已经出现过一次。
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int count = 0;
    for (int i = 1; i <= nums.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
      int mod = prefixSum[i] % k;
      if (mod < 0) {
        // Java 负数取模可能为负，需要归一化到 [0, k)。
        mod += k;
      }

      // 当前余数如果历史上出现过 N 次，就说明以当前位置结尾新增了 N 个合法子数组。
      count += map.getOrDefault(mod, 0);

      // 计数型题目：先统计答案，再更新当前余数出现次数。
      map.put(mod, map.getOrDefault(mod, 0) + 1);
    }

    return count;
  }

  public static void main(String[] args) {
    PrefixSumHashQuestion1 q = new PrefixSumHashQuestion1();
    System.out.println(q.subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
  }
}
