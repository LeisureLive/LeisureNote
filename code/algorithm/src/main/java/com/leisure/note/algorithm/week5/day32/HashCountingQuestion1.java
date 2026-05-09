package com.leisure.note.algorithm.week5.day32;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：169. 多数元素
 *
 * <p>题目描述：
 *
 * <p>给定一个大小为 {@code n} 的数组 {@code nums}，返回其中的多数元素。
 *
 * <p>多数元素是指在数组中出现次数大于 {@code ⌊n / 2⌋} 的元素。题目保证数组非空，并且给定的数组总是存在多数元素。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int majorityElement(int[] nums)
 * </pre>
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums = [3,2,3]
 * 输出：3
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>可以先按哈希计数解法完成</li>
 * <li>需要说清 {@code HashMap<元素, 次数>} 的 value 表示什么</li>
 * <li>做完后可以再对比 Boyer-Moore 投票法，但当前骨架先按哈希表理解</li>
 * </ul>
 *
 * <p>这道题为什么放在 Day32：
 *
 * <ul>
 * <li>对应 `02_hashing.md` 里的 `3.3 计数统计`</li>
 * <li>适合作为最直接的“元素 -> 次数”模板题，和 `242`、`347` 一起构成计数统计对照组</li>
 * </ul>
 */
public class HashCountingQuestion1 {

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>哈希专题：计数统计</li>
   * <li>特征：核心不是查找存在性，而是统计频次后做判断</li>
   * </ul>
   *
   * <p>答题重点：
   *
   * <ol>
   * <li>先判断这题是否适合“元素 -> 次数”的频次统计。</li>
   * <li>遍历过程中更新每个元素出现次数。</li>
   * <li>当某个元素计数超过 {@code n / 2} 时即可返回，或者遍历完后再找最大频次。</li>
   * </ol>
   *
   * <p>注意：
   *
   * <ul>
   * <li>这是 Day32 题目骨架，不直接给标准实现。</li>
   * <li>当前重点是哈希计数模板，不是空间最优解。</li>
   * </ul>
   */
  public int majorityElement(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    // map 的 value 表示“这个元素目前出现了多少次”。
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

      // 一旦某个元素次数超过 n / 2，就已经可以提前返回。
      // 这题题目保证多数元素一定存在，因此这里提前结束是安全的。
      if (map.get(nums[i]) > nums.length / 2) {
        return nums[i];
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    HashCountingQuestion1 hashCountingQuestion1 = new HashCountingQuestion1();
    System.out.println(hashCountingQuestion1.majorityElement(new int[]{2}));
  }
}
