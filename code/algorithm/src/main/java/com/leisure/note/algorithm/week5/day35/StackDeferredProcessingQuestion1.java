package com.leisure.note.algorithm.week5.day35;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Day35 栈模式题：普通栈的回退、延迟处理与过程模拟。
 *
 * <p>这组题对应 `04_stack_queue_monotonic_stack.md` 里的 `3.1 普通栈：匹配、回退、延迟处理`。
 * 这里不再只把“栈”理解成括号匹配，而是把它统一看成“保存最近未消化状态”的容器：
 *
 * <ul>
 * <li>`150`：表达式求值，训练“操作数暂存 + 运算符触发结算”。</li>
 * <li>`636`：调用栈模拟，训练“函数上下文切换时的延迟结算”。</li>
 * <li>`316`：回退式贪心构造，训练“当前选择不优时如何撤回并重做”。</li>
 * </ul>
 */
public class StackDeferredProcessingQuestion1 {

  /**
   * 150. 逆波兰表达式求值
   *
   * <p>题目描述：
   *
   * <p>给定一个字符串数组 {@code tokens}，表示一个根据逆波兰表示法（后缀表达式）写出的算术表达式。
   * 请你计算该表达式的值，并返回结果整数。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int evalRPN(String[] tokens)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：tokens = ["2","1","+","3","*"]
   * 输出：9
   * 解释：表达式等价于 ((2 + 1) * 3)。
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：tokens = ["4","13","5","/","+"]
   * 输出：6
   * 解释：表达式等价于 (4 + (13 / 5))。
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>有效运算符只有 {@code +}、{@code -}、{@code *}、{@code /}</li>
   * <li>两个整数相除时结果向零截断</li>
   * <li>输入保证是合法逆波兰表达式，不会出现除零</li>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用额外栈空间</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>普通栈：表达式求值模板题。</li>
   * <li>题型信号是“读到当前 token 时，是否要和最近尚未结算的操作数立即发生关系”。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先确认后缀表达式没有括号歧义，因此可以单遍扫描。</li>
   * <li>再区分 token 是操作数还是运算符，并明确谁入栈、谁触发出栈。</li>
   * <li>注意弹栈顺序：先弹出的是右操作数，后弹出的是左操作数。</li>
   * <li>最后检查负数 token 和除法向零截断这两个易错点。</li>
   * </ol>
   */
  public int evalRPN(String[] tokens) {
    if (tokens == null || tokens.length == 0) {
      return 0;
    }

    Deque<String> stack = new ArrayDeque<>();
    for (String token : tokens) {
      if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
        // 这里的弹栈顺序不能反：
        // 先弹出的是右操作数，后弹出的是左操作数。
        int num2 = Integer.parseInt(stack.pop());
        int num1 = Integer.parseInt(stack.pop());
        int res;
        switch (token) {
          case "+":
            res = num1 + num2;
            break;
          case "-":
            res = num1 - num2;
            break;
          case "*":
            res = num1 * num2;
            break;
          default:
            res = num1 / num2;
            break;
        }
        // 当前运算结果也会成为后续表达式的操作数，所以要重新压回栈里。
        stack.push(String.valueOf(res));
      } else {
        // 逆波兰表达式里读到操作数时先暂存，等待后面某个运算符来结算它。
        stack.push(token);
      }
    }

    return Integer.parseInt(stack.pop());
  }

  /**
   * 636. 函数的独占时间
   *
   * <p>题目描述：
   *
   * <p>有一个单线程 CPU 正在执行 {@code n} 个函数，函数编号从 {@code 0} 到 {@code n - 1}。
   * 给定日志数组 {@code logs}，其中每条日志格式为 {@code "function_id:start_or_end:timestamp"}，
   * 表示某个函数在某一时刻开始或结束执行。请你返回一个长度为 {@code n} 的数组，
   * 其中 {@code ans[i]} 表示函数 {@code i} 的独占时间。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int[] exclusiveTime(int n, List<String> logs)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：n = 2,
   * logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
   * 输出：[3,4]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：n = 1,
   * logs = ["0:start:0","0:end:0"]
   * 输出：[1]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>CPU 是单线程，同一时刻只会有一个函数真正运行</li>
   * <li>{@code end} 时间戳是闭区间，也就是结束时刻本身也算执行时间</li>
   * <li>函数之间可以嵌套调用，目标时间复杂度为 {@code O(m)}，其中 {@code m = logs.size()}</li>
   * <li>允许使用额外栈空间记录调用链</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>普通栈：调用过程模拟题。</li>
   * <li>栈里保存的不是值本身，而是“当前仍处于执行上下文中的函数”。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先确认题目的本质是单线程调用栈，而不是并发调度。</li>
   * <li>再决定栈里需要保存哪些最小信息：函数编号和这一段待结算起点。</li>
   * <li>分别梳理 {@code start} 和 {@code end} 两种日志如何结算当前时间片。</li>
   * <li>最后检查闭区间 {@code end} 的 {@code +1}、以及父函数恢复时间应为 {@code time + 1}。</li>
   * </ol>
   */
  public int[] exclusiveTime(int n, List<String> logs) {
    if (n <= 0) {
      return new int[0];
    }
    if (logs == null || logs.isEmpty()) {
      return new int[0];
    }

    int[] ans = new int[n];
    Deque<int[]> stack = new ArrayDeque<>();
    for (String log : logs) {
      String[] split = log.split(":");
      int functionId = Integer.parseInt(split[0]);
      String op = split[1];
      int time = Integer.parseInt(split[2]);

      if ("start".equals(op)) {
        if (!stack.isEmpty()) {
          // 子函数启动前，要先把父函数从“上次恢复执行时刻”到“当前 start 前一刻”的独占时间结算掉。
          ans[stack.peek()[0]] += time - stack.peek()[1];
          // 父函数这一段已经结算完，下一次它重新开始计时会在子函数结束之后。
          stack.peek()[1] = time;
        }
        // 栈里保存“当前活跃调用链”，栈顶始终是 CPU 此刻正在执行的函数。
        stack.push(new int[] {functionId, time});
      } else {
        int[] current = stack.pop();
        // end 是闭区间，所以当前函数这一段执行时间要额外 +1。
        ans[current[0]] += time - current[1] + 1;
        if (!stack.isEmpty()) {
          // 子函数在 time 这个时刻已经执行完，父函数只能从 time + 1 继续计时。
          stack.peek()[1] = time + 1;
        }
      }
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
   * <li>普通栈：回退 / 延迟处理变体题。</li>
   * <li>虽然很多资料会把它归到“单调栈 + 贪心”，但按 `3.1-3.4` 四分法，它更接近“当前选择不优时允许回退重做”的普通栈模式。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先确认答案必须保持原相对顺序，因此结果一定是原串的一个子序列。</li>
   * <li>再明确栈里保存的是“当前已经选进答案、但未来仍可能被撤回”的字符。</li>
   * <li>弹栈前同时检查两个条件：当前字符更小，且栈顶字符后面还能再次出现。</li>
   * <li>最后处理去重状态，避免同一个字符被重复放入结果。</li>
   * </ol>
   */
  public String removeDuplicateLetters(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }

    Map<Character, Integer> remainingMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      remainingMap.put(s.charAt(i), remainingMap.getOrDefault(s.charAt(i), 0) + 1);
    }

    // 栈里维护“当前已经选入答案的字符序列”。
    Deque<Character> stack = new ArrayDeque<>();
    // inStack 用来去重，保证同一个字符在答案里只保留一次。
    Set<Character> inStack = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!inStack.contains(c)) {
        // 只有在“当前字符更小”且“栈顶字符后面还能再出现”时，才能安全弹栈重构答案。
        while (!stack.isEmpty() && c < stack.peek() && remainingMap.get(stack.peek()) >= 1) {
          char ch = stack.pop();
          inStack.remove(ch);
        }
        stack.push(c);
        inStack.add(c);
      }
      // 不管当前字符是否入栈，本次遍历都已经消耗掉了一个 c。
      remainingMap.put(c, remainingMap.getOrDefault(c, 0) - 1);
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    // 这里是栈顶到栈底的出栈顺序，所以最后要翻转回真正答案。
    return sb.reverse().toString();
  }
}
