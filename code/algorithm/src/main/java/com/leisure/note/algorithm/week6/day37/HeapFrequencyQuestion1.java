package com.leisure.note.algorithm.week6.day37;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Day37 堆模式题：3.2 哈希 + 堆频次筛选。
 *
 * <p>这组题对应 `07_heap_priority_queue.md` 里的 `3.2 哈希 + 堆：频次排序与 TopK 高频`。
 * 台账里 `347` 已完成，这里补一题更能训练“频次 + 多关键字比较器”的代表题：
 *
 * <ul>
 * <li>`692`：前 K 个高频单词。</li>
 * </ul>
 *
 * <p>本文件只初始化题目骨架，不提供提示和具体实现。
 */
public class HeapFrequencyQuestion1 {

  /**
   * 692. 前 K 个高频单词
   *
   * <p>题目描述：
   *
   * <p>给定一个单词列表 {@code words} 和一个整数 {@code k}，返回出现次数最多的 {@code k} 个单词。
   *
   * <p>返回结果需要按出现频率从高到低排序；如果频率相同，则按字典序从小到大排序。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<String> topKFrequent(String[] words, int k)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：words = ["i","love","leetcode","i","love","coding"], k = 2
   * 输出：["i","love"]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
   * 输出：["the","is","sunny","day"]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>{@code 1 <= k <=} 不同单词数量</li>
   * <li>需要同时处理频次和字典序两个排序维度</li>
   * <li>目标时间复杂度优先考虑 {@code O(n log k)} 或同数量级实现</li>
   * </ul>
   */
  public List<String> topKFrequent(String[] words, int k) {
    if (words == null || words.length == 0) {
      return Collections.emptyList();
    }

    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return Objects.equals(o1.getValue(), o2.getValue()) ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue();
      }
    }
    );
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      queue.offer(entry);
      if (queue.size() > k) {
        queue.poll();
      }
    }

    List<String> res = new ArrayList<>();
    while (!queue.isEmpty()) {
      res.add(queue.poll().getKey());
    }
    Collections.reverse(res);
    return res;
  }
}
