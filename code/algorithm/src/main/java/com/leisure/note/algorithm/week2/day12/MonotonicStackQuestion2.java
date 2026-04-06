package com.leisure.note.algorithm.week2.day12;

/**
 * 题目：496. 下一个更大元素 I
 *
 * <p>题目描述：
 *
 * <p>给你两个没有重复元素的数组 {@code nums1} 和 {@code nums2}，其中 {@code nums1} 是 {@code nums2} 的子集。
 * 请你找出 {@code nums1} 中每个元素在 {@code nums2} 中的下一个比其大的值。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int[] nextGreaterElement(int[] nums1, int[] nums2)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2]
 * 输出：[-1,3,-1]
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：nums1 = [2,4], nums2 = [1,2,3,4]
 * 输出：[3,-1]
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标时间复杂度尽量做到 {@code O(n + m)}，其中 {@code n = nums1.length}，{@code m = nums2.length}</li>
 * <li>允许使用额外空间，例如单调栈和哈希映射</li>
 * <li>不接受对 {@code nums1} 中每个元素都在 {@code nums2} 中向后暴力扫描的写法</li>
 * <li>{@code nums1} 中每个元素一定都出现在 {@code nums2} 中，且两个数组中的元素都不重复</li>
 * </ul>
 *
 * <p>这道题为什么放在 Day12：
 *
 * <ul>
 * <li>作为 `739. 每日温度` 的加练题</li>
 * <li>训练“最近更大元素”模板，以及单调栈和哈希映射配合输出答案</li>
 * </ul>
 */
public class MonotonicStackQuestion2 {

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    throw new UnsupportedOperationException("TODO: implement nextGreaterElement");
  }
}
