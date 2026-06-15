package com.leisure.note.algorithm.week6.day37;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Day37 堆模式题：3.4 数据流维护。
 *
 * <p>这组题对应 `07_heap_priority_queue.md` 里的 `3.4 数据流维护：动态维护第 k 大、中位数等结果`。
 * 这里补两道最常见的数据流代表题：
 *
 * <ul>
 * <li>`703`：数据流中的第 K 大元素。</li>
 * <li>`295`：数据流的中位数。</li>
 * </ul>
 *
 * <p>本文件只初始化题目骨架，不提供提示和具体实现。
 */
public class HeapDataStreamQuestion1 {

  /**
   * 703. 数据流中的第 K 大元素
   *
   * <p>题目描述：
   *
   * <p>设计一个类，在一个数据流中持续接收整数，并在每次插入后返回当前数据流中的第 {@code k} 大元素。
   *
   * <p>请实现 {@code KthLargest} 类：
   *
   * <ul>
   * <li>{@code KthLargest(int k, int[] nums)} 使用整数 {@code k} 和当前数据流初始化对象</li>
   * <li>{@code int add(int val)} 将整数 {@code val} 加入数据流后，返回当前数据流中的第 {@code k} 大元素</li>
   * </ul>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：
   * ["KthLargest", "add", "add", "add", "add", "add"]
   * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
   * 输出：[null, 4, 5, 5, 8, 8]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>每次 {@code add} 后都要返回最新的第 {@code k} 大元素</li>
   * <li>初始化数组长度可以小于 {@code k}</li>
   * <li>优先考虑单次插入对数级维护的方案</li>
   * </ul>
   */
  public static class KthLargest {

    private PriorityQueue<Integer> queue;
    private int k;

    public KthLargest(int k, int[] nums) {
      this.k = k;
      this.queue = new PriorityQueue<>();
      for (int num : nums) {
        queue.offer(num);
        if (queue.size() > k) {
          queue.poll();
        }
      }
    }

    public int add(int val) {
      queue.offer(val);
      while (queue.size() > k) {
        queue.poll();
      }
      return queue.peek();
    }
  }


  /**
   * 295. 数据流的中位数
   *
   * <p>题目描述：
   *
   * <p>中位数是有序整数列表中的中间值。如果列表长度是偶数，则中位数是中间两个数的平均值。
   *
   * <p>请实现 {@code MedianFinder} 类：
   *
   * <ul>
   * <li>{@code MedianFinder()} 初始化对象</li>
   * <li>{@code void addNum(int num)} 将数据流中的整数 {@code num} 添加到数据结构中</li>
   * <li>{@code double findMedian()} 返回到目前为止所有元素的中位数</li>
   * </ul>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：
   * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
   * [[], [1], [2], [], [3], []]
   * 输出：[null, null, null, 1.5, null, 2.0]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>数据是持续加入的，不是一次性给定</li>
   * <li>需要支持多次交替调用 {@code addNum} 和 {@code findMedian}</li>
   * <li>优先考虑单次插入对数级维护方案</li>
   * </ul>
   */
  public static class MedianFinder {

    private PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    private PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });
    private Integer middle = null;

    public MedianFinder() {
    }

    public void addNum(int num) {
      if (middle == null) {
        middle = num;
        return;
      }

      if (num >= middle) {
        minQueue.offer(num);
      } else {
        maxQueue.offer(num);
      }

      if (minQueue.size() - maxQueue.size() >= 2) {
        maxQueue.offer(middle);
        middle = minQueue.poll();
      } else if(maxQueue.size() - minQueue.size() >= 2) {
        minQueue.offer(middle);
        middle = maxQueue.poll();
      }
    }

    public double findMedian() {
      if (minQueue.size() == maxQueue.size()) {
        return middle;
      } else if (minQueue.size() > maxQueue.size()) {
        return (middle + maxQueue.peek()) / 2.0d;
      } else {
        return (middle + minQueue.peek()) / 2.0d;
      }
    }
  }

  public static void main(String[] args) {
    MedianFinder finder = new MedianFinder();
    finder.addNum(1);
    finder.addNum(2);
    finder.addNum(3);
    System.out.println(finder.findMedian());
  }
}
