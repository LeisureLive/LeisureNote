package com.leisure.note.algorithm.week1.day3;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 题目：3. 无重复字符的最长子串
 *
 * <p>题目描述：
 *
 * <p>给定一个字符串 {@code s}，请你找出其中不含有重复字符的最长子串的长度。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int lengthOfLongestSubstring(String s)
 * </pre>
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：s = "abcabcbb"
 * 输出：3
 * 解释：最长不含重复字符的子串是 "abc"，长度为 3。
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：s = "bbbbb"
 * 输出：1
 * 解释：最长不含重复字符的子串是 "b"，长度为 1。
 * </pre>
 *
 * <p>示例 3：
 *
 * <pre>
 * 输入：s = "pwwkew"
 * 输出：3
 * 解释：最长不含重复字符的子串是 "wke"，长度为 3。
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 *   <li>目标时间复杂度为 {@code O(n)}</li>
 *   <li>允许使用额外空间</li>
 *   <li>不接受 {@code O(n^2)} 的暴力枚举所有子串解法</li>
 * </ul>
 *
 * <p>答题框架：
 *
 * <ol>
 *   <li>先说明为什么这是滑动窗口题：连续子串 + 最长 + 窗口内约束</li>
 *   <li>定义窗口：左右指针 {@code left}/{@code right} 表示当前无重复子串区间</li>
 *   <li>定义状态：用哈希表记录字符最近一次出现的位置</li>
 *   <li>扩张规则：右指针向右扫描新字符</li>
 *   <li>收缩规则：如果新字符在窗口内重复，移动左指针到重复字符上次出现位置的后一位</li>
 *   <li>更新答案：每次窗口合法后，用 {@code right - left + 1} 更新最大长度</li>
 *   <li>最后补充复杂度和边界：空串、单字符串、重复字符连续出现等情况</li>
 * </ol>
 *
 * <p>注意：
 *
 * <ul>
 *   <li>这是出题骨架文件，只保留方法签名，不直接给标准实现</li>
 *   <li>答题时先口头说明题型和窗口维护方式，再补代码</li>
 * </ul>
 */
public class SlidingWindowQuestion1 {

  public int lengthOfLongestSubstring(String s) {
    if (s == null) {
      return 0;
    }
    if (s.length() <= 1) {
      return s.length();
    }
    Set<Character> set = new HashSet<>();
    int i = 0;
    int j = 0;
    int longestLength = 0;
    while (j <= s.length() - 1) {
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j));
        j++;
        longestLength = Math.max(longestLength, j - i);
      } else {
        set.remove(s.charAt(i));
        i++;
      }
    }
    return longestLength;
  }

  public static void main(String[] args) {
    SlidingWindowQuestion1 question1 = new SlidingWindowQuestion1();
    String s = "abcabcbb";
    System.out.println(question1.lengthOfLongestSubstring(s));
  }
}
