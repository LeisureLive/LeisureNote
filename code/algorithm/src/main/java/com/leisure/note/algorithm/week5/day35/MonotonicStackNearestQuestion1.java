package com.leisure.note.algorithm.week5.day35;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Day35 单调栈模式题：找最近更大 / 更小元素。
 *
 * <p>这组题对应 `04_stack_queue_monotonic_stack.md` 里的 `3.3 单调栈：找最近更大 / 更小元素`。
 * 核心不是背固定模板，而是把问题统一识别成“当前元素能否结算左边还没完成的元素”：
 *
 * <ul>
 * <li>`739`：右侧第一个严格更大元素。</li>
 * <li>`1475`：右侧第一个小于等于元素。</li>
 * </ul>
 */
public class MonotonicStackNearestQuestion1 {

  /**
   * 739. 每日温度
   *
   * <p>题目描述：
   *
   * <p>给定一个整数数组 {@code temperatures}，表示每天的气温。请你返回一个数组 {@code answer}，
   * 其中 {@code answer[i]} 是指对于第 {@code i} 天，下一个更高气温出现在几天后。
   * 如果气温在这之后都不会升高，请在该位置用 {@code 0} 来代替。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int[] dailyTemperatures(int[] temperatures)
   * </pre>
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
   * <li>不接受对每个位置向右暴力扫描的 {@code O(n^2)} 写法</li>
   * <li>重点说清栈里为什么存下标而不是温度值</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>单调栈：右侧第一个严格更大元素基础模板题。</li>
   * <li>它最适合建立“当前元素出现时，负责结算谁”的第一直觉。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先确认答案要的是“相差几天”，因此栈里要存位置而不是只存数值。</li>
   * <li>再明确这题是找右边第一个更大元素，所以当前元素出现时会去弹栈并结算前面元素。</li>
   * <li>弹栈条件必须是严格大于，不能误写成大于等于。</li>
   * <li>最后说明为什么虽然有 {@code while}，但每个下标最多只会进栈和出栈一次。</li>
   * </ol>
   */
  public int[] dailyTemperatures(int[] temperatures) {
    if (temperatures == null || temperatures.length == 0) {
      return new int[0];
    }

    int[] ans = new int[temperatures.length];
    // 栈里存“还没找到右侧更高温度”的下标，不能只存值，因为答案要算相差几天。
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < temperatures.length; i++) {
      // 当前温度一旦更高，就能连续结算左边那些仍在等更高温度的下标。
      while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        int index = stack.pop();
        ans[index] = i - index;
      }
      // 当前下标自己还没找到答案，继续入栈等待右侧更高温度。
      stack.push(i);
    }

    return ans;
  }

  /**
   * 1475. 商品折扣后的最终价格
   *
   * <p>题目描述：
   *
   * <p>给你一个数组 {@code prices}，其中 {@code prices[i]} 是商店里第 {@code i} 件商品的价格。
   * 商店正在进行促销活动，如果你要买第 {@code i} 件商品，那么你可以得到与
   * {@code prices[j]} 相等的折扣，其中 {@code j} 是满足 {@code j > i} 且
   * {@code prices[j] <= prices[i]} 的最小下标。如果没有满足条件的 {@code j}，你将没有折扣。
   *
   * <p>请你返回一个数组，数组中第 {@code i} 个元素是折扣后的最终价格。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int[] finalPrices(int[] prices)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：prices = [8,4,6,2,3]
   * 输出：[4,2,4,2,3]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：prices = [1,2,3,4,5]
   * 输出：[1,2,3,4,5]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>不接受对每个价格向右暴力找折扣的 {@code O(n^2)} 写法</li>
   * <li>重点说清这题为什么是“右侧第一个小于等于元素”</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>单调栈：右侧第一个小于等于元素模板题。</li>
   * <li>它和 `739` 正好构成一组对照，训练你切换“更大 / 更小”和“是否带等号”的能力。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先把题意翻译成“对每个位置，找右边第一个小于等于它的元素”。</li>
   * <li>再决定栈该保持什么单调性，以及当前元素出现时该弹掉哪些左边候选。</li>
   * <li>注意答案数组初始值可以先复制原价格，再对能拿到折扣的位置回填。</li>
   * <li>最后检查相等价格是否允许作为折扣来源，本题答案是允许，所以比较符号要带等号。</li>
   * </ol>
   */
  public int[] finalPrices(int[] prices) {
    if (prices == null || prices.length == 0) {
      return new int[0];
    }

    // 先复制原数组，默认“没有折扣”时直接保留原价。
    int[] ans = Arrays.copyOf(prices, prices.length);
    // 栈里存还没找到“右侧第一个小于等于值”的下标。
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < prices.length; i++) {
      // 当前价格只要更小或相等，就能成为左边商品的第一个有效折扣来源。
      while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
        int index = stack.pop();
        ans[index] = prices[index] - prices[i];
      }
      // 当前商品还没拿到折扣，继续等待右侧答案。
      stack.push(i);
    }

    return ans;
  }
}
