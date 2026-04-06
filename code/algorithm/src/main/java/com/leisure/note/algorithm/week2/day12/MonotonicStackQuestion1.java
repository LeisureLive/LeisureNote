package com.leisure.note.algorithm.week2.day12;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 题目：739. 每日温度
 *
 * <p>题目描述：
 *
 * <p>给定一个整数数组 {@code temperatures}，表示每天的温度，返回一个数组 {@code answer}，
 * 其中 {@code answer[i]} 表示在第 {@code i} 天之后，才会有更高温度出现在几天后。
 * 如果气温在这之后都不会升高，请在该位置用 {@code 0} 来代替。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int[] dailyTemperatures(int[] temperatures)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：temperatures = [73,74,75,71,69,72,76,73]
 * 输出：[1,1,4,2,1,1,0,0]
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：temperatures = [30,40,50,60]
 * 输出：[1,1,1,0]
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标时间复杂度为 {@code O(n)}</li>
 * <li>允许使用额外空间</li>
 * <li>不接受对每个位置向后暴力枚举的 {@code O(n^2)} 解法</li>
 * <li>返回结果数组 {@code answer} 的长度必须与输入数组相同</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练单调栈基础模板</li>
 * <li>重点说清为什么栈里通常存下标而不是值</li>
 * </ul>
 */
public class MonotonicStackQuestion1 {

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>单调栈专题：基础模板题</li>
   * <li>核心信号：要求找到“当前位置右侧第一个更大元素”</li>
   * <li>栈里保存的是“还没找到答案的位置下标”，而不是温度值本身</li>
   * </ul>
   *
   * <p>思路：
   *
   * <ol>
   * <li>维护一个单调递减栈，栈中下标对应的温度从栈顶到栈底递增难以保持，但核心是“栈顶对应最近、且尚未找到更高温度的位置”。</li>
   * <li>遍历到当天温度 {@code temperatures[i]} 时，只要它比栈顶位置温度更高，就说明栈顶位置终于等到了答案。</li>
   * <li>弹出栈顶下标 {@code index}，并记录 {@code result[index] = i - index}。</li>
   * <li>当前下标处理完后入栈，继续等待右侧更高温度。</li>
   * </ol>
   *
   * <p>易错点：
   *
   * <ul>
   * <li>栈里通常要存下标，因为最后要计算“相差多少天”；如果只存值，就丢失位置信息了。</li>
   * <li>这题找的是“更高温度”，所以弹栈条件是严格小于 {@code temperatures[i]}，不是小于等于。</li>
   * <li>每个下标最多进栈一次、出栈一次，所以整体复杂度是 {@code O(n)}，不要误以为 while 就是 {@code O(n^2)}。</li>
   * </ul>
   */
  public int[] dailyTemperatures(int[] temperatures) {
    if (temperatures == null || temperatures.length == 0) {
      return new int[0];
    }

    Deque<Integer> stack = new ArrayDeque<>();
    int[] result = new int[temperatures.length];
    for (int i = 0; i < temperatures.length; i++) {
      while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
        int index = stack.pop();
        result[index] = i - index;
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      int index = stack.pop();
      result[index] = 0;
    }

    return result;
  }

  public static void main(String[] args) {
    MonotonicStackQuestion1 stackQuestion = new MonotonicStackQuestion1();
    int[] temperatures = new int[]{7, 0, 2, 1, 5, 4};
    System.out.println(Arrays.toString(stackQuestion.dailyTemperatures(temperatures)));
  }
}
