package com.leisure.note.algorithm.week5.day32;

import java.util.HashSet;
import java.util.Set;

/**
 * Day32 哈希表模式复习题（一）：存在性判断。
 *
 * <p>这一轮按 `02_hashing.md` 里的 `3.1 存在性判断` 收口，重点不是机械背 `HashSet`，而是能分清：
 *
 * <ul>
 * <li>什么时候题目只关心“某个值是否存在”。</li>
 * <li>什么时候只需要 `Set`，不需要升级成 `Map`。</li>
 * <li>为什么“只从起点开始扩展”能把重复扫描降掉。</li>
 * </ul>
 *
 * <p>当前文件覆盖 2 道代表题：
 *
 * <ul>
 * <li>{@code 217. 存在重复元素}</li>
 * <li>{@code 128. 最长连续序列}</li>
 * </ul>
 */
public class HashQuestion1 {

  /**
   * 217. 存在重复元素
   *
   * <p>题目描述：
   *
   * <p>给你一个整数数组 {@code nums}。如果任一值在数组中出现至少两次，返回 {@code true}；
   * 如果数组中每个元素互不相同，返回 {@code false}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public boolean containsDuplicate(int[] nums)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：nums = [1,2,3,1]
   * 输出：true
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用额外空间</li>
   * <li>重点说清为什么这里只需要 {@code HashSet}，不需要 {@code HashMap}</li>
   * </ul>
   */
  public boolean containsDuplicate(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return false;
    }

    Set<Integer> seen = new HashSet<>();
    for (int num : nums) {
      if (seen.contains(num)) {
        return true;
      }
      seen.add(num);
    }
    return false;
  }

  /**
   * 128. 最长连续序列
   *
   * <p>题目描述：
   *
   * <p>给定一个未排序的整数数组 {@code nums}，找出数字连续的最长序列（不要求元素在原数组中连续）的长度。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int longestConsecutive(int[] nums)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：nums = [100,4,200,1,3,2]
   * 输出：4
   * 解释：最长连续序列是 [1,2,3,4]。
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用额外空间</li>
   * <li>如果先排序再扫描，虽然能做出来，但不是这题优先训练的线性解法</li>
   * </ul>
   */
  public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }

    int maxLength = 0;
    for (int num : set) {
      // 只从连续段起点开始扩展，避免每个元素都重复向后扫。
      if (set.contains(num - 1)) {
        continue;
      }

      int current = num;
      int length = 1;
      while (set.contains(current + 1)) {
        current++;
        length++;
      }
      maxLength = Math.max(maxLength, length);
    }

    return maxLength;
  }

  public static void main(String[] args) {
    HashQuestion1 q = new HashQuestion1();
    System.out.println(q.containsDuplicate(new int[] {1, 2, 3, 1}));
    System.out.println(q.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
  }
}
