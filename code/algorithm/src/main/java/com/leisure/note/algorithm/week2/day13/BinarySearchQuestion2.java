package com.leisure.note.algorithm.week2.day13;

/**
 * 题目：875. 爱吃香蕉的珂珂
 *
 * <p>题目描述：
 *
 * <p>珂珂喜欢吃香蕉。这里有 {@code n} 堆香蕉，第 {@code i} 堆中有 {@code piles[i]} 根香蕉。
 * 警卫已经离开，将在 {@code h} 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 {@code k}（单位：根 / 小时），每小时会选择一堆香蕉吃掉最多 {@code k} 根。
 * 返回她可以在 {@code h} 小时内吃掉所有香蕉的最小速度 {@code k}。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int minEatingSpeed(int[] piles, int h)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标思路是答案空间二分，整体复杂度尽量做到 {@code O(n log maxPile)}</li>
 * <li>每小时只能选择一堆香蕉吃，且最多吃 {@code k} 根</li>
 * <li>所有香蕉堆大小和 {@code h} 都为正整数，并且保证存在可行解</li>
 * <li>返回的是满足条件的最小速度 {@code k}，不是任意可行速度</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练答案空间二分</li>
 * <li>重点说清“速度越大，总耗时越小”形成单调性</li>
 * </ul>
 */
public class BinarySearchQuestion2 {

  public int minEatingSpeed(int[] piles, int h) {
    throw new UnsupportedOperationException("TODO: implement minEatingSpeed");
  }
}
