package com.leisure.note.algorithm.week5.day32;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：217. 存在重复元素
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
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标时间复杂度为 {@code O(n)}</li>
 * <li>允许使用额外空间</li>
 * <li>重点说清为什么这里只需要 {@code HashSet}，不需要 {@code HashMap}</li>
 * </ul>
 *
 * <p>这道题为什么放在 Day32：
 *
 * <ul>
 * <li>对应 `02_hashing.md` 里的 `3.1 存在性判断`</li>
 * <li>适合作为 `HashSet` 入门模板，和 `128` 的“起点枚举”形成对照</li>
 * </ul>
 */
public class HashExistenceQuestion1 {

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>哈希专题：存在性判断</li>
   * <li>特征：只关心“某个值有没有出现过”，不需要索引、次数或分组信息</li>
   * </ul>
   *
   * <p>答题重点：
   *
   * <ol>
   * <li>先判断题目是否只关心存在性。</li>
   * <li>如果只关心存在性，优先用 {@code HashSet}。</li>
   * <li>遍历时先查是否出现过，再决定是否加入集合。</li>
   * </ol>
   *
   * <p>注意：
   *
   * <ul>
   * <li>这是 Day32 题目骨架，不直接给标准实现。</li>
   * <li>这题比 `128` 更基础，目的是先把 `Set` 的使用边界讲清楚。</li>
   * </ul>
   */
  public boolean containsDuplicate(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return false;
    }

    // Set 里只记录“某个值是否已经出现过”，不需要额外的索引或次数信息。
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      // 先查再放：
      // 如果当前值已经出现过，直接返回 true。
      if (set.contains(nums[i])) {
        return true;
      }

      // 你之前第一次写这题时漏掉了这一步，
      // 结果就是 Set 永远为空，方法会对所有输入都返回 false。
      set.add(nums[i]);
    }

    return false;
  }

  public static void main(String[] args) {
    HashExistenceQuestion1 hashExistenceQuestion1 = new HashExistenceQuestion1();
    System.out.println(hashExistenceQuestion1.containsDuplicate(new int[]{1, 2, 3, 1}));
  }
}
