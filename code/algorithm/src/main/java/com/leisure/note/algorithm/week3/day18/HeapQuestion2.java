package com.leisure.note.algorithm.week3.day18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    // 这题分两步：先哈希计数，再维护一个按“出现次数”比较的小顶堆。
    // 易错点：
    // 1. 堆里比较的不是元素值大小，而是元素出现频次。
    // 2. 参数校验也要统一处理 k <= 0，避免和前一道题风格不一致。
    if (nums == null || nums.length == 0) {
      throw new IllegalArgumentException("nums must not be null or empty");
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }

    if (k <= 0 || map.size() < k) {
      throw new IllegalArgumentException("k must be between 1 and unique element count");
    }

    int[] res = new int[k];
    int index = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      // key 是元素值，value 是该元素出现次数。
      int key = entry.getKey();
      int value = entry.getValue();
      if (index < k) {
        res[index++] = key;
        continue;
      }

      // 前 k 个唯一元素装满后，才开始正式建成“小顶堆候选集”。
      if (index == k) {
        for (int j = k / 2 - 1; j >= 0; j--) {
          siftDown(res, j, map);
        }
      }

      // 只有当前频次比堆顶更高，才替换掉“前 k 高频里最弱的那个”。
      if (value > map.get(res[0])) {
        res[0] = key;
        siftDown(res, 0, map);
      }
      index++;
    }

    return res;
  }

  private void siftDown(int[] res, int i, Map<Integer, Integer> map) {
    int cur = i;
    while (cur <= (res.length) / 2 - 1) {
      int left = 2 * cur + 1;
      int right = 2 * cur + 2;
      int minIndex;
      if (left < res.length && right < res.length) {
        minIndex = map.get(res[left]) <= map.get(res[right]) ? left : right;
      } else if (left < res.length) {
        minIndex = left;
      } else {
        break;
      }

      // 小顶堆下沉时，比较依据是频次而不是元素本身。
      if (map.get(res[cur]) > map.get(res[minIndex])) {
        swap(res, minIndex, cur);
        cur = minIndex;
      } else {
        break;
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    HeapQuestion2 heapQuestion = new HeapQuestion2();
    int[] nums = new int[] {1, 1, 1, 2, 2, 3, 4, 6, 7, 9, 9};
    int[] res = heapQuestion.topKFrequent(nums, 3);
    System.out.println(Arrays.toString(res));
  }
}
