package com.leisure.note.algorithm.week3.day18;

/**
 * 题目：347. 前 K 个高频元素
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
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums = [1,1,1,2,2,3], k = 2
 * 输出：[1,2]
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>结果元素顺序不作要求</li>
 * <li>目标思路是“哈希计数 + 堆”，复杂度尽量做到 {@code O(n log k)}</li>
 * <li>允许使用额外空间</li>
 * <li>返回的是前 {@code k} 个高频元素，不需要按频率排序输出</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练哈希统计 + 堆</li>
 * <li>重点说清计数和排序职责是怎么拆分的</li>
 * </ul>
 */
public class HeapQuestion2 {

  public int[] topKFrequent(int[] nums, int k) {
    throw new UnsupportedOperationException("TODO: implement topKFrequent");
  }
}
