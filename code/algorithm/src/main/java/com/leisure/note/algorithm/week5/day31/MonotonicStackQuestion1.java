package com.leisure.note.algorithm.week5.day31;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * TODO
 *
 * @author jie.he
 * @version 1.0.0
 * @since 2026/04/25 23:21
 */
public class MonotonicStackQuestion1 {

  public int[] finalPrices(int[] prices) {
    if (prices == null || prices.length == 0) {
      return prices;
    }

    Deque<int[]> stack = new ArrayDeque<>();
    int[] ans = new int[prices.length];
    System.arraycopy(prices, 0, ans, 0, prices.length);
    for (int i = 0; i < prices.length; i++) {
      if (stack.isEmpty()) {
        stack.push(new int[] {i, prices[i]});
      } else {
        while (!stack.isEmpty()) {
          if (prices[i] <= stack.peek()[1]) {
            int[] node = stack.pop();
            ans[node[0]] = node[1] - prices[i];
          } else {
            break;
          }
        }
        stack.push(new int[] {i, prices[i]});
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    MonotonicStackQuestion1 stack = new MonotonicStackQuestion1();
    System.out.println(Arrays.toString(stack.finalPrices(new int[] {8, 4, 6, 2, 3})));
  }

}
