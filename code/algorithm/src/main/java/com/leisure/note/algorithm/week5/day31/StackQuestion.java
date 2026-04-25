package com.leisure.note.algorithm.week5.day31;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 题目：150. 逆波兰表达式求值
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
 * <p>答题重点：
 *
 * <ul>
 * <li>训练“遇到操作数入栈，遇到运算符弹出两个操作数计算后再入栈”的标准栈模板</li>
 * <li>重点说清弹栈顺序：先弹出的是右操作数，后弹出的是左操作数</li>
 * </ul>
 */
public class StackQuestion {

  public int evalRPN(String[] tokens) {
    // 本题定位：栈 / 表达式求值。
    // 题型特征：后缀表达式没有括号歧义，天然适合“读到一个 token 就处理一个 token”的单遍扫描。
    // 解题主线：
    // 1. 遇到数字，直接入栈。
    // 2. 遇到运算符，从栈中弹出两个操作数，完成计算后把结果重新压回栈顶。
    // 3. 扫描结束后，栈中只会剩下最终答案。
    //
    // 易错点：
    // 1. 弹栈顺序不能写反。
    //    先 pop 出来的是右操作数 num2，后 pop 出来的是左操作数 num1，
    //    所以减法和除法必须写成 num1 - num2、num1 / num2。
    // 2. 像 "-11" 这样的负数是一个完整操作数，不是运算符。
    //    所以判断运算符时要只匹配四个固定符号，不能看“是否包含减号”。
    // 3. 这题当前实现用的是 Deque<String>，所以每次计算前都要把字符串转成整数；
    //    如果更追求简洁，也可以直接改成 Deque<Integer>。
    // 4. Java 的 int / int 本身就是向零截断，和题目要求一致。
    if (tokens == null || tokens.length == 0) {
      return 0;
    }

    Deque<String> stack = new ArrayDeque<>();
    for (String token : tokens) {
      if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
        // 注意顺序：先弹出的是右操作数，后弹出的是左操作数。
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
        // 当前 token 是数字，直接入栈，等待后续运算符消费。
        stack.push(token);
      }
    }

    // 最终栈中只剩一个元素，它就是整个表达式的值。
    return Integer.parseInt(stack.pop());
  }

  public static void main(String[] args) {
    StackQuestion stackQuestion = new StackQuestion();
    System.out.println(stackQuestion.evalRPN(new String[]{"4","13","5","/","+"}));
  }

}
