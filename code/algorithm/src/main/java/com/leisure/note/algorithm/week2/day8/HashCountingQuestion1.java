package com.leisure.note.algorithm.week2.day8;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：242. 有效的字母异位词
 *
 * <p>题目描述：
 *
 * <p>给定两个字符串 {@code s} 和 {@code t}，编写一个函数来判断 {@code t} 是否是 {@code s} 的字母异位词。
 *
 * <p>方法签名：
 *
 * <pre>
 * public boolean isAnagram(String s, String t)
 * </pre>
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：s = "anagram", t = "nagaram"
 * 输出：true
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：s = "rat", t = "car"
 * 输出：false
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>默认字符集按小写英文字母处理</li>
 * <li>需要说清为什么这题可以用计数而不需要排序</li>
 * </ul>
 *
 * <p>这道题为什么放在 Day8：
 *
 * <ul>
 * <li>作为 `49. 字母异位词分组` 的加练题</li>
 * <li>训练哈希计数 / 数组计数的基础模板</li>
 * </ul>
 */
public class HashCountingQuestion1 {

  public boolean isAnagram(String s, String t) {
    if (s == null || t == null) {
      return false;
    }
    if (s.length() != t.length()) {
      return false;
    }

    int[] arr = new int[26];
    for (int i = 0; i < s.length(); i++) {
      arr[s.charAt(i) - 'a']++;
      arr[t.charAt(i) - 'a']--;
    }
    for (int i = 0; i < 26; i++) {
      if (arr[i] != 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    HashCountingQuestion1 hashCountingQuestion1 = new HashCountingQuestion1();
    System.out.println(hashCountingQuestion1.isAnagram("anagram", "nagaram"));
  }
}
