package com.leisure.note.algorithm.week2.day8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：49. 字母异位词分组
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
 * <p>示例 1：
 *
 * <pre>
 * 输入：strs = ["eat","tea","tan","ate","nat","bat"]
 * 输出：[["bat"],["nat","tan"],["ate","eat","tea"]]
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：strs = [""]
 * 输出：[[""]]
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>允许使用额外空间</li>
 * <li>结果中的分组顺序、组内字符串顺序都不作要求</li>
 * <li>需要把“如何构造稳定分组 key”说清楚</li>
 * <li>默认字符集按小写英文字母处理；如果放宽到通用字符集，要能说明方案如何调整</li>
 * </ul>
 *
 * <p>这道题为什么放在 Day8：
 *
 * <ul>
 * <li>Day8 对应“哈希计数 / 分组 1 题”</li>
 * <li>这题正好训练哈希分组归类和稳定 key 设计</li>
 * </ul>
 *
 * <p>答题顺序要求：
 *
 * <ol>
 * <li>先复述题目要求和限制条件</li>
 * <li>先判断题型，并说明为什么这是“分组归类 + HashMap”题</li>
 * <li>先口头说明如何构造稳定 key</li>
 * <li>再补代码实现</li>
 * <li>最后说明复杂度、边界和 key 设计取舍</li>
 * </ol>
 */
public class HashGroupingQuestion1 {

  /**
   * 解法一：排序后字符串做 key。
   *
   * <p>思路：
   *
   * <ol>
   * <li>异位词的字符组成相同，排序后一定得到同一个字符串。</li>
   * <li>所以可以把“排序后的字符串”作为稳定 key。</li>
   * <li>再用 {@code HashMap<key, List<String>>} 直接分桶。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>最直观，最好理解，也最适合面试第一版回答。</li>
   * <li>对字符集要求低，放宽到通用字符集时仍然适用。</li>
   * </ul>
   *
   * <p>注意：
   *
   * <ul>
   * <li>这题是分组归类题，不要退化成两两比较。</li>
   * <li>排序 key 的时间复杂度约为 {@code O(n * k log k)}，其中 {@code k} 是单个字符串长度。</li>
   * </ul>
   */
  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) {
      return Collections.emptyList();
    }

    Map<String, List<String>> groups = new HashMap<>();
    for (String str : strs) {
      String key = buildSortedKey(str);
      groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
    }

    return new ArrayList<>(groups.values());
  }

  /**
   * 解法二：频次数组签名做 key。
   *
   * <p>思路：
   *
   * <ol>
   * <li>如果字符集固定为 26 个小写字母，那么异位词的本质就是 26 个字母的出现次数完全一致。</li>
   * <li>所以可以先统计频次数组，再把这个频次数组编码成稳定签名。</li>
   * <li>相同签名的字符串直接放进同一个桶。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>单个字符串构造 key 不需要排序，时间复杂度约为 {@code O(k)}。</li>
   * <li>更贴近“异位词本质是频次相同”的理解。</li>
   * </ul>
   *
   * <p>缺点：
   *
   * <ul>
   * <li>写法不如排序版直观。</li>
   * <li>依赖“字符集固定且较小”的前提。</li>
   * </ul>
   *
   * <p>注意：
   *
   * <ul>
   * <li>不能直接把 {@code int[]} 当作 key，因为 Java 数组默认比较的是引用地址。</li>
   * <li>签名里要加分隔符，例如 {@code #1#11}，避免数字直接拼接产生歧义。</li>
   * <li>如果题目放宽到通用字符集，这种 26 位数组写法就不再通用了。</li>
   * </ul>
   */
  public List<List<String>> groupAnagramsByCountSignature(String[] strs) {
    if (strs == null || strs.length == 0) {
      return Collections.emptyList();
    }

    Map<String, List<String>> groups = new HashMap<>();
    for (String str : strs) {
      String key = buildCountSignatureKey(str);
      groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
    }

    return new ArrayList<>(groups.values());
  }

  /**
   * 排序版 key：
   *
   * <p>把字符串排序后转回字符串，同组异位词会得到同一个 key。
   */
  private String buildSortedKey(String str) {
    char[] chars = str.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  /**
   * 频次签名版 key：
   *
   * <p>默认只适用于小写英文字母。比如 "eat" 和 "tea" 都会得到同一个频次签名。
   */
  private String buildCountSignatureKey(String str) {
    int[] count = new int[26];
    for (int i = 0; i < str.length(); i++) {
      count[str.charAt(i) - 'a']++;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      sb.append('#').append(count[i]);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    HashGroupingQuestion1 hashGroupingQuestion1 = new HashGroupingQuestion1();
    String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(hashGroupingQuestion1.groupAnagrams(input));
    System.out.println(hashGroupingQuestion1.groupAnagramsByCountSignature(input));
  }
}
