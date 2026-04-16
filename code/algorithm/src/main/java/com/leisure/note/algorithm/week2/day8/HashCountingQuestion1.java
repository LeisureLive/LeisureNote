package com.leisure.note.algorithm.week2.day8;

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

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>哈希专题：计数统计</li>
   * <li>字符串专题：哈希统计 / 分组</li>
   * <li>特征：不关心字符顺序，只关心字符频次是否一致</li>
   * </ul>
   *
   * <p>思路：
   *
   * <ol>
   * <li>题目默认字符集是 26 个小写字母，所以优先使用数组计数，而不是排序或两张哈希表。</li>
   * <li>遍历 {@code s} 时对应字符计数加一，遍历 {@code t} 时对应字符计数减一。</li>
   * <li>如果最后 26 个位置都回到 0，说明两个字符串的字符组成完全一致。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>时间复杂度 {@code O(n)}，比排序的 {@code O(n log n)} 更优。</li>
   * <li>空间复杂度在固定字符集前提下可视为 {@code O(1)}。</li>
   * <li>很适合作为“字符计数模板”记忆。</li>
   * </ul>
   *
   * <p>缺点：
   *
   * <ul>
   * <li>依赖“字符集固定且较小”的前提。</li>
   * <li>如果字符集放宽到通用字符集，这种 `c - 'a'` 的写法就不再适用。</li>
   * </ul>
   *
   * <p>变体应对：
   *
   * <ul>
   * <li>如果字符集放宽到通用字符集，可以改用 `HashMap<Character, Integer>` 计数。</li>
   * <li>如果只是想快速写稳，也可以用排序后字符串比较，但复杂度更高。</li>
   * <li>如果后续升级到 `49. 字母异位词分组`，就要从“字符 -> 次数”过渡到“稳定 key -> 一组字符串”。</li>
   * </ul>
   */
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
