package com.leisure.note.algorithm.week6.day37;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Day37 堆模式题：3.3 多路归并。
 *
 * <p>这组题对应 `07_heap_priority_queue.md` 里的 `3.3 多路归并：多个有序来源里持续取最优`。
 * 台账里 `23` 已完成，这里补两道更适合训练“来源下标 + 局部有序扩展”的代表题：
 *
 * <ul>
 * <li>`373`：查找和最小的 K 对数字。</li>
 * <li>`378`：有序矩阵中第 K 小的元素。</li>
 * </ul>
 *
 * <p>本文件只初始化题目骨架，不提供提示和具体实现。
 */
public class HeapMultiWayMergeQuestion1 {

  /**
   * 373. 查找和最小的 K 对数字
   *
   * <p>题目描述：
   *
   * <p>给定两个以非递减顺序排列的整数数组 {@code nums1} 和 {@code nums2}，以及一个整数 {@code k}，
   * 定义一对值 {@code (u, v)}，其中第一个元素来自 {@code nums1}，第二个元素来自 {@code nums2}。
   *
   * <p>请返回和最小的 {@code k} 对数值。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums1 = [1,7,11], nums2 = [2,4,6], k = 3
   * 输出：[[1,2],[1,4],[1,6]]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums1 = [1,1,2], nums2 = [1,2,3], k = 2
   * 输出：[[1,1],[1,1]]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>{@code nums1} 和 {@code nums2} 已按非递减顺序排列</li>
   * <li>返回结果数量不超过 {@code k}</li>
   * <li>目标时间复杂度优先考虑与 {@code k} 相关的解法，而不是枚举所有数对</li>
   * </ul>
   */
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
      return Collections.emptyList();
    }

    PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
      }
    });

    for (int i = 0; i < Math.min(k, nums1.length); i++) {
      queue.offer(new int[] {i, 0});
    }

    List<List<Integer>> ans = new ArrayList<>();
    while (k-- > 0 && !queue.isEmpty()) {
      int[] pair = queue.poll();
      List<Integer> list = new ArrayList<>();
      list.add(nums1[pair[0]]);
      list.add(nums2[pair[1]]);
      ans.add(list);

      if (pair[1] + 1 < nums2.length) {
        queue.offer(new int[] {pair[0], pair[1] + 1});
      }
    }

    return ans;
  }

  /**
   * 378. 有序矩阵中第 K 小的元素
   *
   * <p>题目描述：
   *
   * <p>给你一个 {@code n x n} 矩阵 {@code matrix}，其中每行和每列元素均按升序排列，
   * 请返回矩阵中第 {@code k} 小的元素。
   *
   * <p>注意，它是排序后的第 {@code k} 小元素，而不是第 {@code k} 个不同的元素。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int kthSmallest(int[][] matrix, int k)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
   * 输出：13
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：matrix = [[-5]], k = 1
   * 输出：-5
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>矩阵每行、每列都已按升序排列</li>
   * <li>{@code 1 <= k <= n * n}</li>
   * <li>优先考虑利用矩阵局部有序性的解法</li>
   * </ul>
   */
  public int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(arr -> matrix[arr[0]][arr[1]]));
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
      queue.offer(new int[] {i, 0});
    }

    while (k-- > 1 && !queue.isEmpty()) {
      int[] pos = queue.poll();

      if (pos[1] + 1 < n) {
        queue.offer(new int[]{pos[0], pos[1] + 1});
      }
    }

    int[] finalPos = queue.poll();
    return matrix[finalPos[0]][finalPos[1]];
  }
}
