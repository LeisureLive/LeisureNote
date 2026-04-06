package com.leisure.note.algorithm.week2.day11;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 题目：20. 有效的括号
 *
 * <p>题目描述：
 *
 * <p>给定一个只包括 {@code '('}、{@code ')'}、{@code '{'}、{@code '}'}、{@code '['}、{@code ']'} 的字符串 {@code s}，
 * 判断字符串是否有效。
 *
 * <p>方法签名：
 *
 * <pre>
 * public boolean isValid(String s)
 * </pre>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练普通栈的入栈 / 出栈匹配</li>
 * <li>重点说清栈里保存的是什么、什么时候匹配失败</li>
 * </ul>
 */
public class StackQueueQuestion1 {

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>栈专题：普通栈匹配模板</li>
   * <li>核心信号：输入是成对符号，且要求按最近未匹配元素优先配对</li>
   * <li>栈里保存的是“还没匹配的左括号”</li>
   * </ul>
   *
   * <p>思路：
   *
   * <ol>
   * <li>遍历字符串，遇到左括号就直接入栈，表示后面等待与之配对。</li>
   * <li>遇到右括号时，只能和当前栈顶元素匹配，因为最近打开的括号必须最先关闭。</li>
   * <li>如果栈为空，或者栈顶左括号类型不匹配，说明括号顺序已经非法，直接返回 {@code false}。</li>
   * <li>遍历结束后，只有栈也为空，才说明所有括号都恰好配对完成。</li>
   * </ol>
   *
   * <p>易错点：
   *
   * <ul>
   * <li>右括号来了只能检查栈顶，不能继续向栈底找可匹配元素，否则会破坏嵌套顺序。</li>
   * <li>最后要检查栈是否为空；如果还有左括号残留，也是不合法。</li>
   * <li>这题训练的是“最近未匹配元素”视角，适合和最小栈这种“栈中保存辅助状态”题对照理解。</li>
   * </ul>
   */
  public boolean isValid(String s) {
    if (s == null || s.isEmpty()) {
      return true;
    }
    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        char top = stack.pop();
        if ((c == ')' && top != '(')
          || (c == ']' && top != '[')
          || (c == '}' && top != '{')) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    StackQueueQuestion1 stackQueueQuestion1 = new StackQueueQuestion1();
    System.out.println(stackQueueQuestion1.isValid("()[]{}"));
  }

}
