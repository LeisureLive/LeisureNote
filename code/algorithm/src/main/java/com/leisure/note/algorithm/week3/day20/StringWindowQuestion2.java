package com.leisure.note.algorithm.week3.day20;

import java.util.HashMap;
import java.util.Map;

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
    // 这题是变长窗口：先扩张到覆盖 t，再持续收缩左边界找更短答案。
    // 易错点：
    // 1. 我前一版是每次全量 containsMap 判断，现在改成 valid 计数。
    // 2. 我还犯过“无解时返回整个 s / 首次合法窗口没赋值”的问题，所以答案初始值必须是空串。
    // 3. 这题和 438 的区别在于收缩条件：这里只要合法，就要 while(valid == need.size()) 持续收缩。
    if (s == null || s.isEmpty() || t == null || t.isEmpty()) {
      return "";
    }

    if (s.length() < t.length()) {
      return "";
    }

    Map<Character, Integer> need = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
    }

    int left = 0;
    int right = 0;
    int valid = 0;
    Map<Character, Integer> window = new HashMap<>();
    String minWindow = "";
    while (right < s.length()) {
      // 右指针先扩张，把新字符纳入窗口统计。
      char c = s.charAt(right);
      right++;
      if (need.containsKey(c)) {
        window.put(c, window.getOrDefault(c, 0) + 1);
        // 只有字符频次“刚好满足”时，valid 才加一。
        if (window.get(c).equals(need.get(c))) {
          valid++;
        }
      }

      // 只要窗口已经覆盖 t，就不断尝试收缩左边界。
      while (valid == need.size()) {
        if (minWindow.length() == 0 || right - left < minWindow.length()) {
          minWindow = s.substring(left, right);
        }

        char d = s.charAt(left);
        left++;
        if (need.containsKey(d)) {
          // 左边字符移出前如果正好满足 need，移出后窗口就不再合法，所以先 valid--。
          if (window.get(d).equals(need.get(d))) {
            valid--;
          }
          window.put(d, window.get(d) - 1);
        }
      }
    }

    return minWindow;
  }


  public static void main(String[] args) {
    StringWindowQuestion2 stringWindowQuestion2 = new StringWindowQuestion2();
    String s = "ADOBECODEBANC";
    String t = "ABC";
    System.out.println(stringWindowQuestion2.minWindow(s, t));
  }
}
