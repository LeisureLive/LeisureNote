package com.leisure.note.algorithm.week5.day31;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Day31 栈题复习。
 *
 * <p>这一组题都在练“栈”的不同用法，但核心模型不一样：
 *
 * <ul>
 * <li>{@code evalRPN}：表达式求值，训练“读到操作数入栈，读到运算符弹出两个数做计算”的标准栈模板。</li>
 * <li>{@code exclusiveTime}：调用栈模拟，训练“父函数 / 子函数切换时的时间切片结算”。</li>
 * </ul>
 *
 * <p>这两题放在一起回顾的价值是：
 *
 * <ul>
 * <li>一个偏“语法型栈”，一个偏“过程型栈”。</li>
 * <li>一个解决表达式求值，一个解决调用链时间统计。</li>
 * <li>都能帮助你把“栈”的使用从单一模板扩展成更完整的面试表达。</li>
 * </ul>
 *
 * @author jie.he
 * @version 1.0.0
 * @since 2026/04/25 23:21
 */
public class StackQuestion {

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
   * <li>栈专题：表达式求值模板题。</li>
   * <li>题型信号：后缀表达式没有括号歧义，天然适合“读一个 token 就处理一个 token”的单遍扫描。</li>
   * </ul>
   *
   * <p>解题思路：
   *
   * <ol>
   * <li>遇到数字，直接入栈，作为后续运算的操作数。</li>
   * <li>遇到运算符，先弹出两个操作数，再按运算符完成计算。</li>
   * <li>把计算结果重新压回栈中，继续参与后续运算。</li>
   * <li>遍历结束后，栈中只会剩下最终答案。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>规则非常稳定，是“遇到操作数入栈、遇到运算符出栈计算”的标准模板。</li>
   * <li>这类题适合训练你对“后缀表达式”和“栈的入栈 / 出栈时机”的直觉。</li>
   * </ul>
   *
   * <p>适用前提 / 注意事项：
   *
   * <ul>
   * <li>弹栈顺序不能写反，先弹出的是右操作数，后弹出的是左操作数。</li>
   * <li>{@code -11} 这类负数是一个完整操作数，不是运算符。</li>
   * <li>Java 的 {@code int / int} 本身就是向零截断，和题目要求一致。</li>
   * </ul>
   */
  public int evalRPN(String[] tokens) {
    if (tokens == null || tokens.length == 0) {
      return 0;
    }

    Deque<String> stack = new ArrayDeque<>();
    for (String token : tokens) {
      if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
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
        stack.push(String.valueOf(res));
      } else {
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
   * <li>栈专题：调用栈 + 时间切片结算题。</li>
   * <li>题型信号：单线程、函数嵌套调用、要求独占时间，天然对应“调用栈”模型。</li>
   * </ul>
   *
   * <p>解题思路：
   *
   * <ol>
   * <li>用栈保存当前正在执行的函数，以及它“下一段还没结算的起始时间”。</li>
   * <li>遇到 {@code start} 时，如果已有父函数在运行，先结算父函数从上次恢复执行到当前子函数开始前一刻的独占时间。</li>
   * <li>把新函数压栈，表示 CPU 切去执行子函数。</li>
   * <li>遇到 {@code end} 时，弹出栈顶函数，结算它从本段起始时间到当前时刻的执行时间。</li>
   * <li>如果栈里还有父函数，把父函数下一段的起始时间更新为 {@code time + 1}，因为当前时刻已经被子函数占用。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>把“嵌套调用”直接映射成“调用栈”，逻辑非常直观。</li>
   * <li>适合训练你对“父函数暂停 / 子函数执行 / 父函数恢复”的时间结算意识。</li>
   * </ul>
   *
   * <p>适用前提 / 注意事项：
   *
   * <ul>
   * <li>{@code end} 是闭区间，所以结束结算一定要 {@code +1}。</li>
   * <li>子函数开始时，父函数必须先结算掉开始前的那一小段时间。</li>
   * <li>子函数结束后，父函数不是从 {@code time} 继续，而是从 {@code time + 1} 继续。</li>
   * </ul>
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
          ans[stack.peek()[0]] += time - stack.peek()[1];
          stack.peek()[1] = time;
        }
        stack.push(new int[] {functionId, time});
      } else {
        int[] current = stack.pop();
        ans[current[0]] += time - current[1] + 1;
        if (!stack.isEmpty()) {
          stack.peek()[1] = time + 1;
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    StackQuestion stackQuestion = new StackQuestion();
    System.out.println(stackQuestion.evalRPN(new String[] {"4", "13", "5", "/", "+"}));
  }
}
