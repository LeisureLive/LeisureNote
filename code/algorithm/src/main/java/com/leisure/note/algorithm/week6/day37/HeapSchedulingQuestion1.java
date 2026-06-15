package com.leisure.note.algorithm.week6.day37;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Day37 堆模式题：3.5 优先级调度。
 *
 * <p>这组题对应 `07_heap_priority_queue.md` 里的 `3.5 优先级调度：按当前最早结束或最高优先级决策`。
 * 这里补两道最常见的调度 / 代价合并代表题：
 *
 * <ul>
 * <li>`253`：会议室 II。</li>
 * <li>`1167`：连接棒材的最低费用。</li>
 * </ul>
 *
 * <p>本文件只初始化题目骨架，不提供提示和具体实现。
 */
public class HeapSchedulingQuestion1 {

  /**
   * 253. 会议室 II
   *
   * <p>题目描述：
   *
   * <p>给定一个会议时间安排数组 {@code intervals}，其中 {@code intervals[i] = [starti, endi]}，
   * 返回所需会议室的最小数量。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int minMeetingRooms(int[][] intervals)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：intervals = [[0,30],[5,10],[15,20]]
   * 输出：2
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：intervals = [[7,10],[2,4]]
   * 输出：1
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>{@code intervals[i][0] < intervals[i][1]}</li>
   * <li>目标时间复杂度优先考虑 {@code O(n log n)}</li>
   * <li>结果表示任意时刻并发会议数的最大值</li>
   * </ul>
   */
  public int minMeetingRooms(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }

    // 按开始时间从小到大排序
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });


    // 小顶堆，按结束时间排序
    PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1] - o2[1];
      }
    });

    int maxSize = 0;
    for (int i = 0; i < intervals.length; i++) {
      while (!queue.isEmpty()) {
        if (intervals[i][0] < queue.peek()[1]) {
          break;
        }
        queue.poll();
      }
      queue.offer(intervals[i]);
      maxSize = Math.max(maxSize, queue.size());
    }

    return maxSize;
  }

  /**
   * 1167. 连接棒材的最低费用
   *
   * <p>题目描述：
   *
   * <p>给定一些棒材的长度数组 {@code sticks}。每次连接两根棒材的费用等于它们长度之和，
   * 连接后会得到一根新的棒材，其长度也等于两根棒材长度之和。
   *
   * <p>返回连接所有棒材所需的最低总费用。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int connectSticks(int[] sticks)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：sticks = [2,4,3]
   * 输出：14
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：sticks = [1,8,3,5]
   * 输出：30
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>如果棒材数量小于 2，则总费用为 {@code 0}</li>
   * <li>每次连接后得到的新棒材仍需继续参与后续连接</li>
   * <li>目标时间复杂度优先考虑 {@code O(n log n)}</li>
   * </ul>
   */
  public int connectSticks(int[] sticks) {
    if (sticks == null || sticks.length <= 1) {
      return 0;
    }

    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int stick : sticks) {
      queue.offer(stick);
    }

    int sum = 0;
    while (queue.size() > 1) {
      int num1 = queue.poll();
      int num2 = queue.poll();
      int merged = num2 + num1;
      sum += merged;
      queue.offer(merged);
    }
    return sum;
  }

  public static void main(String[] args) {
    HeapSchedulingQuestion1 question1 = new HeapSchedulingQuestion1();
//    System.out.println(question1.minMeetingRooms(new int[][] {
//      {0, 30},
//      {5, 10},
//      {15, 20}
//    }));

    System.out.println(question1.connectSticks(new int[] {1, 8, 3, 5}));
  }
}
