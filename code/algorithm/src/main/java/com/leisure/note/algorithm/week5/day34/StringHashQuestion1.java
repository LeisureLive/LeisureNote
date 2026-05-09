package com.leisure.note.algorithm.week5.day34;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Day34 字符串模式题：哈希统计 / 映射。
 *
 * <p>这组题对应 `05_strings.md` 里的“哈希统计 / 分组”主线，重点继续补字符串里的计数和映射能力。
 * 由于台账里 `242`、`49`、`205`、`249` 已完成，这里改用不重复题目延伸同类模式：
 *
 * <ul>
 * <li>`383`：字符频次统计。</li>
 * <li>`387`：计数后再按原顺序找答案。</li>
 * <li>`890`：双向映射关系的字符串数组版本。</li>
 * </ul>
 *
 * <p>本文件只初始化题目骨架，不直接给标准实现。
 */
public class StringHashQuestion1 {

  /**
   * 383. 赎金信
   *
   * <p>题目描述：
   *
   * <p>给你两个字符串：{@code ransomNote} 和 {@code magazine}，判断 {@code ransomNote} 能不能由
   * {@code magazine} 里面的字符构成。如果可以，返回 {@code true}；否则返回 {@code false}。
   *
   * <p>{@code magazine} 中的每个字符只能在 {@code ransomNote} 中使用一次。
   *
   * <p>方法签名：
   *
   * <pre>
   * public boolean canConstruct(String ransomNote, String magazine)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：ransomNote = "a", magazine = "b"
   * 输出：false
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：ransomNote = "aa", magazine = "aab"
   * 输出：true
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(m + n)}</li>
   * <li>当字符集固定较小时，优先考虑数组计数</li>
   * </ul>
   */
  public boolean canConstruct(String ransomNote, String magazine) {
    if (ransomNote == null || magazine == null) {
      return false;
    }

    if (ransomNote.length() == 0) {
      return true;
    }

    // need[c] 表示当前这个字符还缺多少个，不需要额外维护“已经收集了多少”的 current。
    // 这题真正要判断的是“缺口能不能被 magazine 抵消完”，所以直接在 need 上做减法最自然。
    // 你前面在这题上做过一次结构调整：从维护 current 计数改成只维护缺口。
    // 后者更贴近题意，也更容易看清“什么字符还有贡献”。
    int[] need = new int[26];
    int remaining = ransomNote.length();
    for (int i = 0; i < ransomNote.length(); i++) {
      need[ransomNote.charAt(i) - 'a']++;
    }

    for (int i = 0; i < magazine.length(); i++) {
      int idx = magazine.charAt(i) - 'a';
      // 只有这个字符当前仍然有缺口时，它才对答案有贡献。
      // 这样可以避免把多余字符也算进来。
      if (need[idx] > 0) {
        need[idx]--;
        remaining--;
        // 一旦所有缺口都补齐，就可以提前返回，不需要继续扫描 magazine。
        if (remaining == 0) {
          return true;
        }
      }
    }

    return remaining == 0;
  }

  /**
   * 387. 字符串中的第一个唯一字符
   *
   * <p>题目描述：
   *
   * <p>给定一个字符串 {@code s}，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 {@code -1}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int firstUniqChar(String s)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：s = "leetcode"
   * 输出：0
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：s = "loveleetcode"
   * 输出：2
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>重点解释为什么这题通常是“两遍扫描”：先计数，再按原顺序找第一个唯一字符</li>
   * </ul>
   */
  public int firstUniqChar(String s) {
    if (s == null || s.length() == 0) {
      return -1;
    }

    // 第一遍只统计频次。
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }

    // 第二遍必须按原串顺序找第一个频次为 1 的字符。
    // 这题的关键词是“第一个唯一字符”，所以只做哈希统计还不够，还要回到原始顺序上取答案。
    for (int i = 0; i < s.length(); i++) {
      if (map.get(s.charAt(i)) == 1) {
        return i;
      }
    }

    return -1;
  }

  /**
   * 890. 查找和替换模式
   *
   * <p>题目描述：
   *
   * <p>你有一个单词数组 {@code words} 和一个模式 {@code pattern}，如果某个单词与模式之间存在字母双向映射，
   * 使得按该映射替换后能够得到模式，则称该单词匹配该模式。
   *
   * <p>返回 {@code words} 中所有匹配 {@code pattern} 的单词列表。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<String> findAndReplacePattern(String[] words, String pattern)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
   * 输出：["mee","aqq"]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>重点讲清“模式匹配”本质是双向映射关系，而不是简单比较字符出现次数</li>
   * <li>返回顺序与输入数组遍历顺序一致</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>字符串哈希：映射关系代表题。</li>
   * <li>它比 `205` 更进一步，因为要把同样的映射规则批量应用到多个单词上。</li>
   * </ul>
   */
  public List<String> findAndReplacePattern(String[] words, String pattern) {
    if (words == null || words.length == 0) {
      return Collections.emptyList();
    }

    // 先把 pattern 归一化成“首次出现顺序模板”。
    // 例如 pattern = "abb" 会映射成 [1,2,2]，后面每个单词只要能映射成相同模板就匹配。
    Map<Character, Integer> map = new HashMap<>();
    int[] template = new int[pattern.length()];
    int count = 1;
    for (int i = 0; i < pattern.length(); i++) {
      char ch = pattern.charAt(i);
      if (map.containsKey(ch)) {
        template[i] = map.get(ch);
      } else {
        map.put(ch, count);
        template[i] = count;
        count++;
      }
    }

    List<String> res = new ArrayList<>();
    for (String word : words) {
      if (word.length() != pattern.length()) {
        continue;
      }

      // 这题本质是在验证 word 能不能归一化成和 pattern 相同的结构模板，
      // 不是比较字符种类数，更不是比较字符出现次数。
      Map<Character, Integer> wordMap = new HashMap<>();
      count = 1;
      boolean match = true;
      for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        if (wordMap.containsKey(ch) && !wordMap.get(ch).equals(template[i])) {
          match = false;
          break;
        }

        if (!wordMap.containsKey(ch)) {
          wordMap.put(ch, count);
          if (count != template[i]) {
            match = false;
            break;
          }
          count++;
        }
      }

      if (match) {
        res.add(word);
      }
    }

    return res;
  }

  public static void main(String[] args) {
    StringHashQuestion1 stringHashQuestion1 = new StringHashQuestion1();
//    System.out.println(stringHashQuestion1.canConstruct("aa", "aab"));
    System.out.println(
      stringHashQuestion1.findAndReplacePattern(new String[] {"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"));
  }
}
