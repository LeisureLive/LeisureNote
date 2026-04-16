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

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>二分专题：答案空间二分</li>
   * <li>核心信号：不是在数组里找某个值，而是在一段“可能的答案范围”里找最小可行解</li>
   * <li>关键单调性：吃香蕉速度越大，总耗时越小</li>
   * </ul>
   *
   * <p>思路：
   *
   * <ol>
   * <li>先确定答案范围：最小速度至少要能在 {@code h} 小时内吃完，最大速度不会超过最大那一堆香蕉数。</li>
   * <li>对速度 {@code k} 做二分，检查以这个速度吃完所有香蕉需要多少小时。</li>
   * <li>如果总耗时大于 {@code h}，说明速度太慢，不可行，要去更大的速度区间。</li>
   * <li>如果总耗时小于等于 {@code h}，说明当前速度可行，还可以继续尝试更小速度。</li>
   * </ol>
   *
   * <p>易错点：
   *
   * <ul>
   * <li>这题二分的不是数组下标，而是“速度”这个答案空间。</li>
   * <li>单堆耗时要做向上取整，常见写法是 {@code (pile + speed - 1) / speed}，也可以用 {@code Math.ceil}。</li>
   * <li>因为目标是“最小可行速度”，所以遇到可行解时不能直接返回，而要继续向左收缩答案空间。</li>
   * </ul>
   */
  public int minEatingSpeed(int[] piles, int h) {
    if (piles == null || piles.length == 0) return -1;
    if (piles.length > h) return -1;


    int total = 0;
    int maxPile = -1;
    for (int i = 0; i < piles.length; i++) {
      total += piles[i];
      maxPile = Math.max(maxPile, piles[i]);
    }
    int minSpeed = (int) Math.ceil((double) total / h);
    int maxSpeed = maxPile;

    int result = maxSpeed;
    while (maxSpeed >= minSpeed) {
      int midSpeed = (maxSpeed + minSpeed) / 2;
      int totalCost = 0;
      for (int i = 0; i < piles.length; i++) {
        totalCost += (int) Math.ceil((double) piles[i] / midSpeed);
      }

      if (totalCost > h) {
        minSpeed = midSpeed + 1;
      } else {
        maxSpeed = midSpeed - 1;
        result = midSpeed;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    BinarySearchQuestion2 binarySearchQuestion2 = new BinarySearchQuestion2();
    int[] piles = {30, 11, 23, 4, 20};
    System.out.println(binarySearchQuestion2.minEatingSpeed(piles, 6));
  }
}
