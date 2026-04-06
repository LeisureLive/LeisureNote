package com.leisure.note.algorithm.week2.day12;

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

  public int[] dailyTemperatures(int[] temperatures) {
    throw new UnsupportedOperationException("TODO: implement dailyTemperatures");
  }
}
