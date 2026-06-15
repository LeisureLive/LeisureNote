package com.leisure.note.algorithm.week5.day32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Day32 哈希表模式复习题（四）：分组归类。
 *
 * <p>这一轮按 `02_hashing.md` 里的 `3.4 分组归类` 收口，重点不是继续做两两比较，而是能分清：
 *
 * <ul>
 * <li>同一组元素的共同特征到底是什么。</li>
 * <li>这个特征能不能编码成稳定且唯一的 key。</li>
 * <li>不同 key 设计的复杂度和表达成本分别是什么。</li>
 * </ul>
 *
 * <p>当前文件覆盖 3 组内容：
 *
 * <ul>
 * <li>{@code 49. 字母异位词分组}：排序 key</li>
 * <li>{@code 49. 字母异位词分组}：频次数组签名 key</li>
 * <li>{@code 249. 移位字符串分组}：位移差签名 key</li>
 * </ul>
 */
public class HashQuestion4 {

  /**
   * 49. 字母异位词分组
   *
   * <p>题目描述：
   *
   * <p>给你一个字符串数组 {@code strs}，请你将字母异位词组合在一起。可以按任意顺序返回结果列表。
   *
   * <p>字母异位词指字母相同，但排列不同的字符串。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<List<String>> groupAnagrams(String[] strs)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：strs = ["eat","tea","tan","ate","nat","bat"]
   * 输出：[["bat"],["nat","tan"],["ate","eat","tea"]]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>允许使用额外空间</li>
   * <li>结果中的分组顺序、组内字符串顺序都不作要求</li>
   * <li>需要把“如何构造稳定分组 key”说清楚</li>
   * </ul>
   *
   * <p>当前方法：排序后的字符串作为 key。
   */
  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) {
      return Collections.emptyList();
    }

    Map<String, List<String>> grouped = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String key = new String(chars);
      grouped.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
    }

    return new ArrayList<>(grouped.values());
  }

  /**
   * 49. 字母异位词分组
   *
   * <p>题目描述同上，这里保留同一题的第二种高频写法。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<List<String>> groupAnagramsByCountSignature(String[] strs)
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>默认字符集按小写英文字母处理</li>
   * <li>重点说清为什么频次数组也可以作为稳定 key</li>
   * <li>还要注意 Java 里不能直接把 {@code int[]} 当作 map key</li>
   * </ul>
   *
   * <p>当前方法：频次数组转签名作为 key。
   */
  public List<List<String>> groupAnagramsByCountSignature(String[] strs) {
    if (strs == null || strs.length == 0) {
      return Collections.emptyList();
    }

    Map<String, List<String>> grouped = new HashMap<>();
    for (String str : strs) {
      int[] count = new int[26];
      for (int i = 0; i < str.length(); i++) {
        count[str.charAt(i) - 'a']++;
      }

      StringBuilder key = new StringBuilder();
      for (int i = 0; i < 26; i++) {
        key.append('#').append(count[i]);
      }
      grouped.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(str);
    }

    return new ArrayList<>(grouped.values());
  }

  /**
   * 249. 移位字符串分组
   *
   * <p>题目描述：
   *
   * <p>字符串 {@code "abc"}、{@code "bcd"}、{@code "xyz"} 都属于同一个移位序列，
   * 因为它们相邻字符之间的相对位移关系一致。
   *
   * <p>给你一个字符串数组 {@code strings}，请将所有属于同一移位序列的字符串分组，返回结果。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<List<String>> groupStrings(String[] strings)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：strings = ["abc","bcd","acef","xyz","az","ba","a","z"]
   * 输出：[["acef"],["a","z"],["abc","bcd","xyz"],["az","ba"]]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>允许使用额外空间</li>
   * <li>重点说清“同一组字符串的稳定 key 到底是什么”</li>
   * <li>默认字符集按小写英文字母处理，注意循环位移（如 {@code z -> a}）</li>
   * </ul>
   */
  public List<List<String>> groupStrings(String[] strings) {
    if (strings == null || strings.length == 0) {
      return Collections.emptyList();
    }

    Map<String, List<String>> grouped = new HashMap<>();
    for (String str : strings) {
      grouped.computeIfAbsent(buildShiftKey(str), k -> new ArrayList<>()).add(str);
    }

    return new ArrayList<>(grouped.values());
  }

  private String buildShiftKey(String str) {
    if (str == null) {
      return "NULL";
    }
    if (str.length() <= 1) {
      return "SINGLE";
    }

    StringBuilder key = new StringBuilder();
    for (int i = 1; i < str.length(); i++) {
      int diff = str.charAt(i) - str.charAt(i - 1);
      if (diff < 0) {
        diff += 26;
      }
      key.append(diff).append('#');
    }
    return key.toString();
  }

  public static void main(String[] args) {
    HashQuestion4 q = new HashQuestion4();
    System.out.println(q.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    System.out.println(q.groupAnagramsByCountSignature(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    System.out.println(q.groupStrings(new String[] {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));
  }
}
