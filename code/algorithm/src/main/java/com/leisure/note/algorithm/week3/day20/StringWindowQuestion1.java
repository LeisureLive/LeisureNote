package com.leisure.note.algorithm.week3.day20;

import java.util.List;

/**
 * 题目：438. 找到字符串中所有字母异位词
 *
 * <p>题目描述：
 *
 * <p>给定两个字符串 {@code s} 和 {@code p}，找到 {@code s} 中所有 {@code p} 的异位词子串，返回这些子串的起始索引。
 *
 * <p>方法签名：
 *
 * <pre>
 * public List<Integer> findAnagrams(String s, String p)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：s = "cbaebabacd", p = "abc"
 * 输出：[0,6]
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：s = "abab", p = "ab"
 * 输出：[0,1,2]
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标时间复杂度尽量做到 {@code O(n)}</li>
 * <li>允许使用额外空间，例如频次数组或哈希表</li>
 * <li>窗口长度固定为 {@code p.length()}</li>
 * <li>返回的是所有异位词子串的起始下标，按出现顺序输出</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练固定长度滑动窗口</li>
 * <li>重点说清窗口长度固定时如何维护频次差异</li>
 * </ul>
 */
public class StringWindowQuestion1 {

  public List<Integer> findAnagrams(String s, String p) {
    throw new UnsupportedOperationException("TODO: implement findAnagrams");
  }
}
