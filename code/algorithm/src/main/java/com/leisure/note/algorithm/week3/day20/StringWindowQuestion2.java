package com.leisure.note.algorithm.week3.day20;

/**
 * 题目：76. 最小覆盖子串
 *
 * <p>题目描述：
 *
 * <p>给你一个字符串 {@code s}、一个字符串 {@code t}，返回 {@code s} 中涵盖 {@code t} 所有字符的最小子串。
 *
 * <p>方法签名：
 *
 * <pre>
 * public String minWindow(String s, String t)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：s = "a", t = "aa"
 * 输出：""
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>如果不存在覆盖 {@code t} 所有字符的子串，返回空字符串 {@code ""}</li>
 * <li>要考虑 {@code t} 中字符的重复次数，而不只是字符是否出现过</li>
 * <li>目标思路是滑动窗口，复杂度尽量做到 {@code O(|s| + |t|)}</li>
 * <li>允许使用额外空间，例如哈希表统计字符需求和窗口状态</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练复杂窗口题</li>
 * <li>重点说清窗口什么时候合法、什么时候可以收缩</li>
 * </ul>
 */
public class StringWindowQuestion2 {

  public String minWindow(String s, String t) {
    throw new UnsupportedOperationException("TODO: implement minWindow");
  }
}
