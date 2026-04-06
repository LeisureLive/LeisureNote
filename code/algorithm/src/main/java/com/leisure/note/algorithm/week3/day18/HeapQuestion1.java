package com.leisure.note.algorithm.week3.day18;

/**
 * 题目：215. 数组中的第 K 个最大元素
 *
 * <p>题目描述：
 *
 * <p>给定整数数组 {@code nums} 和整数 {@code k}，请返回数组中第 {@code k} 个最大的元素。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int findKthLargest(int[] nums, int k)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums = [3,2,1,5,6,4], k = 2
 * 输出：5
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：nums = [3,2,3,1,2,4,5,5,6], k = 4
 * 输出：4
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标思路是维护大小为 {@code k} 的小顶堆，复杂度尽量做到 {@code O(n log k)}</li>
 * <li>返回的是第 {@code k} 个最大的元素，不是第 {@code k} 个不同的元素</li>
 * <li>允许使用额外空间，例如优先队列</li>
 * <li>不要先整体排序再取第 {@code k} 个作为唯一思路</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练堆的 TopK 模板</li>
 * <li>重点说清为什么维护大小为 k 的小顶堆即可</li>
 * </ul>
 */
public class HeapQuestion1 {

  public int findKthLargest(int[] nums, int k) {
    throw new UnsupportedOperationException("TODO: implement findKthLargest");
  }
}
