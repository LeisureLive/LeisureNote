package com.leisure.note.algorithm.week5.day32;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Day32 哈希表模式复习题（三）：计数统计。
 *
 * <p>这一轮按 `02_hashing.md` 里的 `3.3 计数统计` 收口，重点不是只会写
 * {@code map.put(x, map.getOrDefault(x, 0) + 1)}，而是能分清：
 *
 * <ul>
 * <li>什么时候可以用定长数组计数，什么时候必须用 `HashMap`。</li>
 * <li>计数后是直接判断、还是继续做筛选 / TopK。</li>
 * <li>map 的 value 表示的到底是什么。</li>
 * </ul>
 *
 * <p>当前文件覆盖 3 道代表题：
 *
 * <ul>
 * <li>{@code 242. 有效的字母异位词}</li>
 * <li>{@code 169. 多数元素}</li>
 * <li>{@code 347. 前 K 个高频元素}</li>
 * </ul>
 */
public class HashQuestion3 {

  /**
   * 242. 有效的字母异位词
   *
   * <p>题目描述：
   *
   * <p>给定两个字符串 {@code s} 和 {@code t}，编写一个函数来判断 {@code t} 是否是 {@code s} 的字母异位词。
   *
   * <p>方法签名：
   *
   * <pre>
   * public boolean isAnagram(String s, String t)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：s = "anagram", t = "nagaram"
   * 输出：true
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>默认字符集按小写英文字母处理</li>
   * <li>需要说清为什么这题可以用计数而不需要排序</li>
   * </ul>
   */
  public boolean isAnagram(String s, String t) {
    if (s == null || t == null || s.length() != t.length()) {
      return false;
    }

    int[] count = new int[26];
    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a']++;
      count[t.charAt(i) - 'a']--;
    }

    for (int num : count) {
      if (num != 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * 169. 多数元素
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
   * <p>示例：
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
   */
  public int majorityElement(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    Map<Integer, Integer> frequency = new HashMap<>();
    for (int num : nums) {
      frequency.put(num, frequency.getOrDefault(num, 0) + 1);
      if (frequency.get(num) > nums.length / 2) {
        return num;
      }
    }
    return -1;
  }

  /**
   * 347. 前 K 个高频元素
   *
   * <p>题目描述：
   *
   * <p>给你一个整数数组 {@code nums} 和一个整数 {@code k}，请你返回其中出现频率前 {@code k} 高的元素。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int[] topKFrequent(int[] nums, int k)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：nums = [1,1,1,2,2,3], k = 2
   * 输出：[1,2]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>结果元素顺序不作要求</li>
   * <li>目标思路是“哈希计数 + 堆”，复杂度尽量做到 {@code O(n log k)}</li>
   * <li>允许使用额外空间</li>
   * </ul>
   */
  public int[] topKFrequent(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k <= 0) {
      return new int[0];
    }

    Map<Integer, Integer> frequency = new HashMap<>();
    for (int num : nums) {
      frequency.put(num, frequency.getOrDefault(num, 0) + 1);
    }


    // 堆里存的是 [元素值, 出现次数]，比较依据是出现次数而不是元素本身。
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
      minHeap.offer(new int[] {entry.getKey(), entry.getValue()});
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    int[] result = new int[minHeap.size()];
    for (int i = result.length - 1; i >= 0; i--) {
      result[i] = minHeap.poll()[0];
    }
    return result;
  }

  public static void main(String[] args) {
    HashQuestion3 q = new HashQuestion3();
    System.out.println(q.isAnagram("anagram", "nagaram"));
    System.out.println(q.majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));
    int[] topK = q.topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2);
    for (int num : topK) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}
