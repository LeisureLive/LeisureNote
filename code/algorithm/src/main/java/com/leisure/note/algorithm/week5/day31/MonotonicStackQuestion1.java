package com.leisure.note.algorithm.week5.day31;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Day31 单调栈复习题。
 *
 * <p>这组题都在练“栈”的不同用法，核心上分成两类：
 *
 * <ul>
 * <li>边界查找型：{@code dailyTemperatures}、{@code largestRectangleArea}，重点是找右侧第一个更大元素或左右第一个更小元素。</li>
 * <li>贪心构造型：{@code removeDuplicateLetters}，重点是用单调栈维护当前字典序最优的结果字符串。</li>
 * </ul>
 *
 * <p>其中 {@code largestRectangleArea} 很容易一开始误判成“接雨水”类题，但两者核心目标不同：
 *
 * <ul>
 * <li>接雨水：关注当前位置上方能积多少水，本质依赖左右更高边界。</li>
 * <li>最大矩形：关注当前位置作为最低高度时，能向左右扩多宽，本质依赖左右第一个更小边界。</li>
 * </ul>
 *
 * <p>{@code removeDuplicateLetters} 则是单调栈里更偏贪心的一类题：
 *
 * <ul>
 * <li>它不是找边界，而是维护“当前已经选出的最优子序列”。</li>
 * <li>当新字符更小、且栈顶字符后面还能再出现时，就可以把栈顶弹掉，让更小字符尽量靠前。</li>
 * </ul>
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

  /**
   * 739. 每日温度
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>单调栈专题：右侧第一个更大元素基础模板题。</li>
   * <li>题型信号：每个位置都要找“右侧最近一个更大元素”，并且目标复杂度是 {@code O(n)}。</li>
   * </ul>
   *
   * <p>解题思路：
   *
   * <ol>
   * <li>栈中存还没找到更高温度的下标，而不是温度值本身，因为最后要算“相差几天”。</li>
   * <li>从左到右遍历，当 {@code temperatures[i]} 比栈顶下标对应温度更高时，说明当前天就是它右侧第一个更大元素。</li>
   * <li>弹出栈顶下标 {@code index}，记录 {@code ans[index] = i - index}。</li>
   * <li>当前下标入栈，继续等待右侧更高温度。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>这是“右侧第一个更大元素”最标准的单调栈模板，后续很多题都能由这题变形得到。</li>
   * </ul>
   *
   * <p>适用前提 / 注意事项：
   *
   * <ul>
   * <li>这题找的是“更高温度”，所以弹栈条件必须是严格大于，不能写成大于等于。</li>
   * <li>虽然有 {@code while}，但每个下标最多入栈一次、出栈一次，所以总复杂度仍然是 {@code O(n)}。</li>
   * </ul>
   *
   * <p>变体应对：
   *
   * <ul>
   * <li>如果改成“右侧第一个更小元素”，就调整栈的单调性和比较符号。</li>
   * <li>如果改成“左侧最近满足条件元素”，通常在当前元素入栈前就能确定答案。</li>
   * </ul>
   */
  public int[] dailyTemperatures(int[] temperatures) {
    if (temperatures == null || temperatures.length <= 0) {
      return null;
    }

    int[] ans = new int[temperatures.length];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < temperatures.length; i++) {
      while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        int index = stack.pop();
        ans[index] = i - index;
      }
      stack.push(i);
    }

    return ans;
  }

  /**
   * 316. 去除重复字母
   *
   * <p>题目描述：
   *
   * <p>给你一个字符串 {@code s}，请你去除字符串中重复的字母，使得每个字母只出现一次。
   * 你需要保证返回结果的字典序最小，并且不能打乱其他字符的相对顺序。
   *
   * <p>方法签名：
   *
   * <pre>
   * public String removeDuplicateLetters(String s)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：s = "bcabc"
   * 输出："abc"
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：s = "cbacdcbc"
   * 输出："acdb"
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用额外空间</li>
   * <li>{@code 1 <= s.length <= 10^4}</li>
   * <li>{@code s} 仅由小写英文字母组成</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>单调栈专题：贪心构造结果字符串的代表题。</li>
   * <li>它不是“找左边 / 右边第一个更大 / 更小元素”的经典边界题，而是“维护当前最优答案”的构造题。</li>
   * </ul>
   *
   * <p>题型特征：
   *
   * <ul>
   * <li>结果要保留原相对顺序，说明不能随便排序，答案一定是原串的一个子序列。</li>
   * <li>结果要求每个字符只出现一次，说明需要去重状态。</li>
   * <li>结果还要求字典序最小，说明当前已经选进答案的字符，在某些条件下需要允许“撤回重选”。</li>
   * </ul>
   *
   * <p>这题为什么不容易第一眼想到单调栈：
   *
   * <ul>
   * <li>因为题面没有直接给出“最近更大 / 更小元素”这种显式信号。</li>
   * <li>真正的突破口不是“找边界”，而是：当前字符更小的时候，能不能把前面已经选进答案的更大字符弹掉。</li>
   * <li>只要前面的更大字符后面还会再出现，就可以先弹掉，让更小字符更早进入答案，从而让整体字典序更小。</li>
   * </ul>
   *
   * <p>解题思路：
   *
   * <ol>
   * <li>先统计每个字符后面还剩多少次可用，用来判断某个字符现在弹掉后，将来还能不能补回来。</li>
   * <li>用栈维护“当前构造出的答案字符序列”。</li>
   * <li>用 {@code inStack} 记录某个字符是否已经在答案里，避免重复入栈。</li>
   * <li>遍历到当前字符 {@code c} 时，如果它还没入栈，就尝试把栈顶比它大、且后面还能再出现的字符弹掉。</li>
   * <li>弹栈结束后，把当前字符压入栈中，表示它进入当前最优答案。</li>
   * <li>最后把栈中字符拼起来。由于这里用的是 {@code push/pop}，出栈顺序和答案顺序相反，所以最后需要反转。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>把“去重”“字典序最小”“保持相对顺序”三件事统一收口到一条贪心逻辑里，整体复杂度是 {@code O(n)}。</li>
   * <li>很适合作为“单调栈不只会找边界，也能维护当前最优结构”的代表题来记。</li>
   * </ul>
   *
   * <p>适用前提 / 注意事项：
   *
   * <ul>
   * <li>弹栈必须同时满足两个条件：当前字符更小，且栈顶字符后面还能再出现；少任何一个条件都不能弹。</li>
   * <li>如果某个字符已经在栈里，当前这个重复字符必须直接跳过，否则会破坏“每个字符只出现一次”。</li>
   * <li>这题本质是“字典序最小的去重子序列”，不是简单排序，也不是普通去重。</li>
   * </ul>
   *
   * <p>变体应对：
   *
   * <ul>
   * <li>如果题目不要求保持相对顺序，而只要求去重后字典序最小，直接排序去重即可，不需要单调栈。</li>
   * <li>如果题目要求保留 {@code k} 个字符、构造最小 / 最大子序列，通常也会落到“栈 + 是否还能补回”的同类思路。</li>
   * </ul>
   */
  public String removeDuplicateLetters(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }

    // 记录每个字符后续还剩多少次可用，用来判断弹栈后能不能在后面补回来。
    Map<Character, Integer> remainingMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      remainingMap.put(s.charAt(i), remainingMap.getOrDefault(s.charAt(i), 0) + 1);
    }

    // 栈里维护当前已经选入答案的字符序列。
    Deque<Character> stack = new ArrayDeque<>();
    // 记录某个字符是否已经在栈里，避免重复入栈。
    Set<Character> inStack = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!inStack.contains(c)) {
        // 当前字符更小，且栈顶字符后面还能再出现时，可以弹掉栈顶，让答案字典序更小。
        while (!stack.isEmpty() && c < stack.peek() && remainingMap.get(stack.peek()) >= 1) {
          char ch = stack.pop();
          inStack.remove(ch);
        }
        stack.push(c);
        inStack.add(c);
        // 本实现把“消费当前字符”放在分支末尾，因此这里统一减一。
        remainingMap.put(s.charAt(i), remainingMap.getOrDefault(s.charAt(i), 0) - 1);
      } else {
        // 当前字符已经在答案里，只消耗次数，不再重复入栈。
        remainingMap.put(s.charAt(i), remainingMap.getOrDefault(s.charAt(i), 0) - 1);
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      char ch = stack.pop();
      sb.append(ch);
    }
    // 这里出栈顺序和答案顺序相反，所以最后需要翻转。
    return sb.reverse().toString();
  }

  /**
   * 84. 柱状图中最大的矩形
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>单调栈专题：左右边界类代表题。</li>
   * <li>题型信号：对于每个位置，都要找“左边第一个更小元素”和“右边第一个更小元素”。</li>
   * </ul>
   *
   * <p>这题为什么不能按“接雨水”去做：
   *
   * <ul>
   * <li>接雨水是在问：当前位置上方能积多少水，所以要找左右更高边界。</li>
   * <li>本题是在问：如果当前柱子作为矩形的最低高度，最多能向左右扩多宽，所以要找左右第一个更小边界。</li>
   * <li>因此核心公式不是“水高 = 左右高边界的较小值减当前高度”，而是
   * {@code 面积 = heights[i] * (right[i] - left[i] - 1)}。</li>
   * </ul>
   *
   * <p>解题思路：
   *
   * <ol>
   * <li>把每个柱子都当成“矩形最低高度”来考虑。</li>
   * <li>向左找到第一个比它小的位置 {@code left[i]}，向右找到第一个比它小的位置 {@code right[i]}。</li>
   * <li>这样当前柱子能扩展的最大宽度就是 {@code right[i] - left[i] - 1}。</li>
   * <li>再乘以当前高度 {@code heights[i]}，得到以它为最低高度时的最大矩形面积。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>左右边界数组显式可见，适合训练“最近更小元素”这类题的思维。</li>
   * <li>这版写法很适合复盘：能清楚看出左边界、右边界和面积公式是如何配合的。</li>
   * </ul>
   *
   * <p>适用前提 / 注意事项：
   *
   * <ul>
   * <li>本题要找的是“第一个更小元素”，所以弹栈条件要写成 {@code >=}，这样相等高度会合并到同一侧边界处理，避免宽度重复或边界不稳。</li>
   * <li>{@code left[i]} 如果不存在，记为 {@code -1}；{@code right[i]} 如果不存在，记为 {@code heights.length}，这是宽度计算的边界哨兵。</li>
   * <li>这题可以进一步优化成一个栈处理左右边界，但当前双栈写法更直观，便于先把题意和边界吃透。</li>
   * </ul>
   *
   * <p>变体应对：
   *
   * <ul>
   * <li>如果题目只要求某一侧最近更小元素，可以只保留一个栈，不必同时维护左右边界数组。</li>
   * <li>如果再遇到“接雨水”这类题，要先判断目标到底是“求当前位置上方容量”还是“求以当前位置为最短板的最大跨度”。</li>
   * </ul>
   */
  public int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }

    // left[i] 表示第 i 个柱子左侧第一个更小元素下标；不存在时用 -1 作为左边界哨兵。
    int[] left = new int[heights.length];
    // right[i] 表示第 i 个柱子右侧第一个更小元素下标；不存在时用 n 作为右边界哨兵。
    int[] right = new int[heights.length];
    Arrays.fill(right, heights.length);

    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();
    for (int i = 0; i < heights.length; i++) {
      // 维护递增栈：弹掉所有大于等于当前高度的元素，栈顶剩下的就是左侧第一个更小元素。
      while (!stack1.isEmpty() && heights[stack1.peek()] >= heights[i]) {
        stack1.pop();
      }
      left[i] = stack1.isEmpty() ? -1 : stack1.peek();
      stack1.push(i);


      // 同样维护递增栈：当前元素一旦更小，就成为被弹出元素右侧第一个更小边界。
      while (!stack2.isEmpty() && heights[stack2.peek()] >= heights[i]) {
        int index = stack2.pop();
        right[index] = i;
      }
      stack2.push(i);
    }

    int largestArea = 0;
    for (int i = 0; i < heights.length; i++) {
      // 以 heights[i] 作为矩形最低高度时，可扩展宽度是 (left[i], right[i]) 开区间的长度。
      largestArea = Math.max(largestArea, (right[i] - left[i] - 1) * heights[i]);
    }

    return largestArea;
  }

  public static void main(String[] args) {
    MonotonicStackQuestion1 stack = new MonotonicStackQuestion1();
//    System.out.println(Arrays.toString(stack.finalPrices(new int[] {8, 4, 6, 2, 3})));
//    System.out.println(stack.largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3}));
    System.out.println(stack.removeDuplicateLetters("cbacdcbc"));
  }

}
