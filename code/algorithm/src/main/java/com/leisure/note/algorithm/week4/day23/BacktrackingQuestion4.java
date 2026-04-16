package com.leisure.note.algorithm.week4.day23;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：22. 括号生成
 *
 * <p>题目描述：
 *
 * <p>数字 {@code n} 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
 *
 * <p>方法签名：
 *
 * <pre>
 * public List<String> generateParenthesis(int n)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：n = 1
 * 输出：["()"]
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>返回所有可能的有效括号组合，顺序不作要求</li>
 * <li>不要先暴力生成所有长度为 {@code 2 * n} 的字符串再筛合法结果</li>
 * <li>允许使用额外空间，例如路径构造和递归栈</li>
 * <li>关键边界是：任意时刻右括号数量不能超过左括号数量</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练状态约束回溯</li>
 * <li>重点说清 left/right 计数限制</li>
 * </ul>
 */
public class BacktrackingQuestion4 {

  public List<String> generateParenthesis(int n) {
    // 这题是状态约束型回溯：不是先生成所有字符串再筛，而是在构造过程中始终保持合法。
    // 易错点：
    // 1. 任意时刻右括号数量都不能超过左括号数量，否则当前前缀已经非法。
    // 2. 这题和组合/子集不一样，核心状态不是 startIndex，而是 left/right 两个计数。
    // 3. 我这里每次 append 后都要 deleteCharAt 回退，否则 StringBuilder 状态会串到别的分支。
    if (n == 0) return new ArrayList<>();

    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    backTrace(0, 0, n, sb, res);
    return res;
  }

  private void backTrace(int left, int right, int n, StringBuilder sb, List<String> res) {
    if (left == right && left == n) {
      res.add(sb.toString());
      return;
    }

    // right 大于 left 时已经非法，这条分支可以直接剪掉。
    if (left < right) {
    } else if (left == right) {
      // 左右相等时，下一个字符只能放左括号。
      sb.append("(");
      backTrace(left + 1, right, n, sb, res);
      // 这里一定要删，不然实际上 sb 没有回退
      sb.deleteCharAt(sb.length() - 1);
    } else {
      if (left < n) {
        // left 还没用完时，可以继续放左括号，也可以在合法前提下放右括号。
        sb.append("(");
        backTrace(left + 1, right, n, sb, res);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        backTrace(left, right + 1, n, sb, res);
        sb.deleteCharAt(sb.length() - 1);
      } else {
        // 左括号已经用完后，后面只能补右括号直到结束。
        sb.append(")");
        backTrace(left, right + 1, n, sb, res);
        // 这里一定要删，不然实际上 sb 没有回退
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }

  public static void main(String[] args) {
    BacktrackingQuestion4 backtrackingQuestion4 = new BacktrackingQuestion4();
    System.out.println(backtrackingQuestion4.generateParenthesis(3));
  }
}
