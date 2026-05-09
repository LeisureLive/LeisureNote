package com.leisure.note.algorithm.week5.day32;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：290. 单词规律
 *
 * <p>题目描述：
 *
 * <p>给定一种规律 {@code pattern} 和一个字符串 {@code s}，判断 {@code s} 是否遵循相同的规律。
 *
 * <p>这里的“遵循”指的是：{@code pattern} 中的每个字母和 {@code s} 中的每个非空单词之间存在双向一一对应关系。
 *
 * <p>方法签名：
 *
 * <pre>
 * public boolean wordPattern(String pattern, String s)
 * </pre>
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：pattern = "abba", s = "dog cat cat dog"
 * 输出：true
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：pattern = "abba", s = "dog cat cat fish"
 * 输出：false
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标时间复杂度为 {@code O(n)}</li>
 * <li>允许使用额外空间</li>
 * <li>重点说清为什么这题和 `205. 同构字符串` 本质相同，但映射对象从“字符”扩展成了“字符 -> 单词”</li>
 * </ul>
 *
 * <p>这道题为什么放在 Day32：
 *
 * <ul>
 * <li>对应 `02_hashing.md` 里的“映射关系一致性”进阶题</li>
 * <li>很适合在 `205` 之后练一轮“同构关系模板迁移”</li>
 * </ul>
 */
public class HashMappingQuestion2 {

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>哈希专题：映射关系一致性</li>
   * <li>特征：需要维护字符和单词之间的双向一一对应关系</li>
   * </ul>
   *
   * <p>答题重点：
   *
   * <ol>
   * <li>先拆分字符串 {@code s} 得到单词序列。</li>
   * <li>再判断长度是否和 {@code pattern} 一致。</li>
   * <li>核心仍然是双向映射：字符不能重复映射到不同单词，不同字符也不能映射到同一个单词。</li>
   * </ol>
   *
   * <p>注意：
   *
   * <ul>
   * <li>这是 Day32 题目骨架，不直接给标准实现。</li>
   * <li>这题和 `205` 非常适合成组复盘。</li>
   * </ul>
   */
  public boolean wordPattern(String pattern, String s) {
    if (pattern == null || s == null) return false;

    // 先把原字符串拆成单词序列。长度不一致时，一定不可能匹配成功。
    String[] words = s.split(" ");
    if (words.length != pattern.length()) return false;

    // 正向映射：pattern 字符 -> 单词
    Map<Character, String> map = new HashMap<>();
    // 反向映射：单词 -> pattern 字符
    Map<String, Character> reverseMap = new HashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
      char ch = pattern.charAt(i);
      String word = words[i];

      if (map.containsKey(ch)) {
        String expected = map.get(ch);

        // 正向映射必须和之前保持一致。
        if (!word.equals(expected)) return false;

        // 同时反向映射也要一致，避免两个字符映射到同一个单词。
        if (!reverseMap.containsKey(expected) || reverseMap.get(expected) != ch) return false;
      } else {
        map.put(ch, word);
        if (reverseMap.containsKey(word) && reverseMap.get(word) != ch) return false;
        reverseMap.put(word, ch);
      }
    }

    return true;
  }

  public static void main(String[] args) {
    HashMappingQuestion2 hashMappingQuestion2 = new HashMappingQuestion2();
    System.out.println(hashMappingQuestion2.wordPattern("abba", "dog cat cat dog"));
  }
}
