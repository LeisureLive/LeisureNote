package com.leisure.note.algorithm.week2.day12;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

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

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>单调栈专题：最近更大元素模板</li>
   * <li>核心信号：需要先在 {@code nums2} 里找到每个元素的“下一个更大元素”，再回答 {@code nums1} 的查询</li>
   * <li>单调栈负责预处理，哈希表负责按值快速回查结果</li>
   * </ul>
   *
   * <p>思路：
   *
   * <ol>
   * <li>先遍历 {@code nums2}，用单调递减栈维护“还没找到下一个更大元素”的下标。</li>
   * <li>当前元素更大时，持续弹出栈顶下标，并把“该元素值 -> 它的下一个更大元素值”记录到哈希表里。</li>
   * <li>{@code nums2} 遍历结束后，栈里剩余元素都不存在更大值，统一映射为 {@code -1}。</li>
   * <li>最后再遍历 {@code nums1}，直接用哈希表回填答案数组。</li>
   * </ol>
   *
   * <p>易错点：
   *
   * <ul>
   * <li>这题不是直接在 {@code nums1} 上做单调栈，而是要先在完整的 {@code nums2} 上把映射关系预处理出来。</li>
   * <li>哈希表的 key 是元素值，不是下标；因为最终查询是按 {@code nums1} 的值来问答案。</li>
   * <li>题目保证两个数组元素都不重复，所以“值 -> 下一个更大值”的映射不会冲突。</li>
   * </ul>
   */
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    if (nums1.length == 0 || nums2.length == 0) {
      return nums1;
    }

    // 记录 nums2 中每个元素值 -> 比他大的下一个元素值
    Map<Integer, Integer> map = new HashMap<>();
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < nums2.length; i++) {
      while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
        int index = stack.pop();
        map.put(nums2[index], nums2[i]);
      }
      stack.push(i);
    }

    while (!stack.isEmpty()) {
      int index = stack.pop();
      map.put(nums2[index], -1);
    }

    int[] res = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      res[i] = map.get(nums1[i]);
    }

    return res;
  }

  public static void main(String[] args) {
    MonotonicStackQuestion2 stackQuestion = new MonotonicStackQuestion2();
    int[] nums1 = new int[] {4, 1, 2};
    int[] nums2 = new int[] {1, 3, 4, 2};
    System.out.println(Arrays.toString(stackQuestion.nextGreaterElement(nums1, nums2)));
  }
}
