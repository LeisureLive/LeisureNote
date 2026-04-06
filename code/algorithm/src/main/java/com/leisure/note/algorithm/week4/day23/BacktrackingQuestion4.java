package com.leisure.note.algorithm.week4.day23;

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
    throw new UnsupportedOperationException("TODO: implement generateParenthesis");
  }
}
