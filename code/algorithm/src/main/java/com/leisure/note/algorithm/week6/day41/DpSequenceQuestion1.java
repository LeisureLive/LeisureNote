package com.leisure.note.algorithm.week6.day41;

/**
 * Day41 动态规划模式题：3.3 序列型 DP。
 *
 * <p>对应 {@code 11_dynamic_programming.md} 的 3.3 小节。
 * 本文件只保留题目描述和方法骨架，不写提示和具体实现。
 */
public class DpSequenceQuestion1 {

  /**
   * 1143. 最长公共子序列
   *
   * <p>题目描述：
   *
   * <p>给定两个字符串 {@code text1} 和 {@code text2}，返回这两个字符串的最长公共子序列长度。
   *
   * <p>字符串的子序列是指：在不改变字符相对顺序的前提下，删除某些字符（也可以不删除）后得到的新字符串。
   *
   * <p>例如，{@code "ace"} 是 {@code "abcde"} 的一个子序列，但 {@code "aec"} 不是。
   *
   * <p>如果两个字符串不存在公共子序列，返回 {@code 0}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int longestCommonSubsequence(String text1, String text2)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：text1 = "abcde", text2 = "ace"
   * 输出：3
   * 解释：最长公共子序列是 "ace"，长度为 3。
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：text1 = "abc", text2 = "abc"
   * 输出：3
   * </pre>
   *
   * <p>示例 3：
   *
   * <pre>
   * 输入：text1 = "abc", text2 = "def"
   * 输出：0
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>{@code 1 <= text1.length, text2.length <= 1000}</li>
   * <li>{@code text1} 和 {@code text2} 仅由小写英文字母组成</li>
   * <li>只需要返回最长长度，不需要返回具体子序列内容</li>
   * </ul>
   */
  public int longestCommonSubsequence(String text1, String text2) {
    return 0;
  }

  /**
   * 72. 编辑距离
   *
   * <p>题目描述：
   *
   * <p>给定两个单词 {@code word1} 和 {@code word2}，请返回将 {@code word1} 转换成 {@code word2} 所使用的最少操作数。
   *
   * <p>你可以对一个单词执行以下三种操作：
   *
   * <ul>
   * <li>插入一个字符</li>
   * <li>删除一个字符</li>
   * <li>替换一个字符</li>
   * </ul>
   *
   * <p>方法签名：
   *
   * <pre>
   * public int minDistance(String word1, String word2)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：word1 = "horse", word2 = "ros"
   * 输出：3
   * 解释：
   * horse -> rorse（将 'h' 替换为 'r'）
   * rorse -> rose（删除 'r'）
   * rose -> ros（删除 'e'）
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：word1 = "intention", word2 = "execution"
   * 输出：5
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>{@code 0 <= word1.length, word2.length <= 500}</li>
   * <li>{@code word1} 和 {@code word2} 由小写英文字母组成</li>
   * <li>只需要返回最少操作数，不需要输出操作序列</li>
   * </ul>
   */
  public int minDistance(String word1, String word2) {
    return 0;
  }

  /**
   * 516. 最长回文子序列
   *
   * <p>题目描述：
   *
   * <p>给定一个字符串 {@code s}，请返回其中最长回文子序列的长度。
   *
   * <p>子序列不要求连续，但需要保持原有相对顺序。
   *
   * <p>例如，字符串 {@code "bbbab"} 的一个回文子序列是 {@code "bbbb"}，
   * 它由原字符串中下标不同的字符组成，但不需要在原字符串中连续出现。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int longestPalindromeSubseq(String s)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：s = "bbbab"
   * 输出：4
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：s = "cbbd"
   * 输出：2
   * 解释：最长回文子序列之一是 "bb"。
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>{@code 1 <= s.length <= 1000}</li>
   * <li>{@code s} 仅由小写英文字母组成</li>
   * <li>只需要返回最长长度，不需要返回具体子序列</li>
   * </ul>
   */
  public int longestPalindromeSubseq(String s) {
    return 0;
  }
}
