package com.leisure.note.algorithm.week5.day32;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：205. 同构字符串
 *
 * <p>题目描述：
 *
 * <p>给定两个字符串 {@code s} 和 {@code t}，判断它们是否是同构的。
 *
 * <p>如果 {@code s} 中的字符可以按某种映射关系替换得到 {@code t}，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * <p>方法签名：
 *
 * <pre>
 * public boolean isIsomorphic(String s, String t)
 * </pre>
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：s = "egg", t = "add"
 * 输出：true
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标时间复杂度为 {@code O(n)}</li>
 * <li>允许使用额外空间</li>
 * <li>重点说清为什么单向映射不够，为什么通常需要双向约束</li>
 * </ul>
 *
 * <p>这道题为什么放在 Day32：
 *
 * <ul>
 * <li>对应 `02_hashing.md` 里的 `3.2 补数 / 映射关系` 中“映射关系”这一支</li>
 * <li>目的是把哈希表的 `值 -> 值` 映射思维和 `1. 两数之和` 的 `值 -> 下标` 区分开</li>
 * </ul>
 */
public class HashMappingQuestion1 {

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>哈希专题：映射关系一致性</li>
   * <li>特征：不是找补数，而是检查一组字符映射是否一一对应</li>
   * </ul>
   *
   * <p>答题重点：
   *
   * <ol>
   * <li>先明确这里的哈希表存的不是次数，也不是下标，而是字符之间的映射关系。</li>
   * <li>只维护 {@code s -> t} 不够，因为可能出现两个不同字符都映射到同一个字符。</li>
   * <li>更稳的做法通常是同时维护两个方向，或维护“字符最后一次出现位置”的同步关系。</li>
   * </ol>
   *
   * <p>注意：
   *
   * <ul>
   * <li>这是 Day32 题目骨架，不直接给标准实现。</li>
   * <li>这题适合训练“哈希表里存映射关系”而不是“存统计信息”。</li>
   * </ul>
   */
  public boolean isIsomorphic(String s, String t) {
    if (s == null || t == null) {
      return false;
    }
    if (s.length() != t.length()) {
      return false;
    }

    // 正向映射：s 中字符 -> t 中字符
    Map<Character, Character> map = new HashMap<>();
    // 反向映射：t 中字符 -> s 中字符
    // 只维护单向映射不够，因为可能出现两个不同字符都映射到同一个字符。
    Map<Character, Character> reverseMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      char target = t.charAt(i);

      if (map.containsKey(ch)) {
        char expected = map.get(ch);

        // 如果当前字符之前已经建立过映射，就必须和旧映射保持一致。
        if (target != expected) {
          return false;
        }

        // 同时反向映射也要一致，确保一一对应。
        if (reverseMap.containsKey(expected) && reverseMap.get(expected) != ch) {
          return false;
        }
        reverseMap.put(expected, ch);
      } else {
        // 第一次出现时建立正向映射，但建立前要先检查反向是否被别人占用。
        map.put(ch, target);
        if (reverseMap.containsKey(target) && reverseMap.get(target) != ch) {
          return false;
        }
        reverseMap.put(target, ch);
      }
    }

    return true;
  }

  public static void main(String[] args) {
    HashMappingQuestion1 hashMappingQuestion1 = new HashMappingQuestion1();
    System.out.println(hashMappingQuestion1.isIsomorphic("eggaadd", "dccaaee"));
  }
}
