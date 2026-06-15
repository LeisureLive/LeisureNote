package com.leisure.note.algorithm.week6.day37;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Day37 堆模式题：3.1 TopK 固定容量维护最值集合。
 *
 * <p>这组题对应 `07_heap_priority_queue.md` 里的 `3.1 TopK：固定容量维护最值集合`。
 * 台账里 `215`、`347` 已完成，这里补一题更适合训练“固定容量堆保留候选集合”的代表题：
 *
 * <ul>
 * <li>`973`：最接近原点的 K 个点。</li>
 * </ul>
 *
 * <p>本文件只初始化题目骨架，不提供提示和具体实现。
 */
public class HeapTopKQuestion1 {

  /**
   * 973. 最接近原点的 K 个点
   *
   * <p>题目描述：
   *
   * <p>给定一个数组 {@code points}，其中 {@code points[i] = [xi, yi]} 表示二维平面上的一个点，
   * 返回离原点 {@code (0, 0)} 最近的 {@code k} 个点。
   *
   * <p>答案可以按任意顺序返回。除距离平方外，不需要对结果做额外排序。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int[][] kClosest(int[][] points, int k)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：points = [[1,3],[-2,2]], k = 1
   * 输出：[[-2,2]]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：points = [[3,3],[5,-1],[-2,4]], k = 2
   * 输出：[[3,3],[-2,4]]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>{@code 1 <= k <= points.length}</li>
   * <li>目标时间复杂度优先考虑 {@code O(n log k)}</li>
   * <li>距离比较使用平方值即可，无需开方</li>
   * </ul>
   */
  public int[][] kClosest(int[][] points, int k) {
    if (points.length == 0) {
      return null;
    }

    PriorityQueue<int[]> queue =
      new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
          return o2[0] - o1[0];
        }
      });

    for (int i = 0; i < k; i++) {
      queue.offer(new int[] {points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
    }

    for (int i = k; i < points.length; i++) {
      int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
      if (dist < queue.peek()[0]) {
        queue.poll();
        queue.offer(new int[]{dist, i});
      }
    }

    int[][] ans = new int[k][2];
    int index = 0;
    while (!queue.isEmpty()) {
      ans[index] = points[queue.poll()[1]];
      index++;
    }
    return ans;
  }
}
