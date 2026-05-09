package com.leisure.note.algorithm.week5.day32;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：249. 移位字符串分组
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
 * <li>默认字符集按小写英文字母处理，注意循环位移（如 `z -> a`）</li>
 * </ul>
 *
 * <p>这道题为什么放在 Day32：
 *
 * <ul>
 * <li>对应 `02_hashing.md` 里的 `3.4 分组归类`</li>
 * <li>它比 `49. 字母异位词分组` 更强调“如何设计稳定 key”，适合做二轮分组题扩展</li>
 * </ul>
 */
public class HashGroupingQuestion1 {

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>哈希专题：分组归类</li>
   * <li>特征：关键不在两两比较，而在于为每个字符串构造稳定且唯一的分组 key</li>
   * </ul>
   *
   * <p>答题重点：
   *
   * <ol>
   * <li>先想清楚同一组字符串的共同特征是什么，而不是先两两比较。</li>
   * <li>这题常见做法是把相邻字符的位移差编码成 key。</li>
   * <li>然后用 {@code HashMap<key, List<String>>} 直接分桶。</li>
   * </ol>
   *
   * <p>注意：
   *
   * <ul>
   * <li>这是 Day32 题目骨架，不直接给标准实现。</li>
   * <li>这题很适合训练“key 设计稳定性”，和 `49` 的排序 key / 频次签名 key 对照着看。</li>
   * </ul>
   */
  public List<List<String>> groupStrings(String[] strings) {
    if (strings == null || strings.length == 0) {
      return Collections.emptyList();
    }

    // key -> 同组字符串列表
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strings) {
      if (str == null) {
        map.computeIfAbsent(null, k -> new ArrayList<>()).add(null);
      } else {
        StringBuilder key = new StringBuilder();
        // 单字符串统一从 "0" 开始，表示“相对起点的偏移量”。
        key.append("0");
        key.append("|");
        for (int i = 1; i < str.length(); i++) {
          // 这里不是看绝对字符，而是看“相对第一个字符的位移量”。
          // 这样像 "abc"、"bcd"、"xyz" 都会得到同一个规范化 key。
          if (str.charAt(i) >= str.charAt(0)) {
            key.append(str.charAt(i) - str.charAt(0));
          } else {
            // 处理循环位移，比如从 z 再移到 a。
            key.append(26 - str.charAt(0) + str.charAt(i));
          }

          // 这里必须加分隔符。
          // 你之前直接拼数字时，像 "al" 和 "abb" 都可能得到 "011"，发生 key 冲突。
          if (i < str.length() - 1) {
            key.append("|");
          }
        }
        map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(str);
      }
    }

    List<List<String>> result = new ArrayList<>();
    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
      result.add(entry.getValue());
    }

    return result;
  }

  public static void main(String[] args) {
    HashGroupingQuestion1 hashGroupingQuestion1 = new HashGroupingQuestion1();
    System.out.println(hashGroupingQuestion1.groupStrings(new String[]{"abc","bcd","acef","xyz","az","ba","a","z"}));
  }
}
