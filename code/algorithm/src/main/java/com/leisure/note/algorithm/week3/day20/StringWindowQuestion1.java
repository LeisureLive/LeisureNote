package com.leisure.note.algorithm.week3.day20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    // 这题是固定长度滑动窗口：窗口长度始终保持为 p.length()。
    // 易错点：
    // 1. 我前一版是每次全量比较 map，现在改成 valid 计数，只在“刚好达标/刚好失效”时更新。
    // 2. 固定窗口和最小覆盖子串不一样，这里窗口长度一到就只滑动一格，不是 while 收缩到不合法。
    // 3. 空串或 s 比 p 短时要提前返回，否则窗口初始化没有意义。
    if (s == null || p == null) {
      return Collections.emptyList();
    }

    if (s.length() == 0 || s.length() < p.length()) {
      return Collections.emptyList();
    }

    Map<Character, Integer> need = new HashMap<>();
    for (int i = 0; i < p.length(); i++) {
      need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
    }

    int left = 0;
    int right = 0;
    List<Integer> ans = new ArrayList<>();
    Map<Character, Integer> window = new HashMap<>();
    int valid = 0;
    while (right < s.length()) {
      // 右指针扩张窗口，把新字符纳入统计。
      char c = s.charAt(right);
      right++;

      if (need.containsKey(c)) {
        window.put(c, window.getOrDefault(c, 0) + 1);
        // 只有字符频次“刚好满足”时，valid 才加一。
        if (window.get(c).equals(need.get(c))) {
          valid++;
        }
      }

      // 固定窗口：长度达到 p.length() 后，先判断答案，再移出最左字符。
      if (right - left == p.length()) {
        if (valid == need.size()) {
          ans.add(left);
        }
        char d = s.charAt(left);
        left++;
        if (window.containsKey(d)) {
          // 左边字符移出前如果正好满足 need，移出后就会失效，所以先 valid--。
          if (window.get(d).intValue() == need.get(d).intValue()) {
            valid--;
          }
          window.put(d, window.get(d) - 1);
        }
      }

    }

    return ans;
  }

  public static void main(String[] args) {
    StringWindowQuestion1 stringWindowQuestion1 = new StringWindowQuestion1();
    String s = "cbaebabacd";
    String p = "abc";
    System.out.println(stringWindowQuestion1.findAnagrams(s, p));
  }
}
