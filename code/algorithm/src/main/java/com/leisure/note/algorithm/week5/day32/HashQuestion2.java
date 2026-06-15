package com.leisure.note.algorithm.week5.day32;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Day32 哈希表模式复习题（二）：补数 / 映射关系。
 *
 * <p>这一轮按 `02_hashing.md` 里的 `3.2 补数 / 映射关系` 收口，重点不是只会写
 * {@code target - nums[i]}，而是能分清：
 *
 * <ul>
 * <li>map 里存的是“值 -> 下标”，还是“对象 -> 对象”的映射关系。</li>
 * <li>为什么补数题通常要先查再放。</li>
 * <li>为什么映射一致性题往往需要双向约束。</li>
 * </ul>
 *
 * <p>当前文件覆盖 3 道代表题：
 *
 * <ul>
 * <li>{@code 1. 两数之和}</li>
 * <li>{@code 205. 同构字符串}</li>
 * <li>{@code 290. 单词规律}</li>
 * </ul>
 */
public class HashQuestion2 {

  /**
   * 1. 两数之和
   *
   * <p>题目描述：
   *
   * <p>给定一个整数数组 {@code nums} 和一个整数目标值 {@code target}，
   * 请你在该数组中找出和为目标值 {@code target} 的那两个整数，并返回它们的数组下标。
   *
   * <p>你可以假设每种输入只会对应一个答案，并且同一个元素不能被重复使用。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int[] twoSum(int[] nums, int target)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：nums = [2,7,11,15], target = 9
   * 输出：[0,1]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用额外空间</li>
   * <li>重点说清为什么这里必须“先查再放”</li>
   * </ul>
   */
  public int[] twoSum(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
      return new int[0];
    }

    Map<Integer, Integer> indexByValue = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int expect = target - nums[i];
      if (indexByValue.containsKey(expect)) {
        return new int[] {indexByValue.get(expect), i};
      }

      // 先查再放，避免把当前元素自己和自己配对。
      indexByValue.put(nums[i], i);
    }

    return new int[0];
  }

  /**
   * 205. 同构字符串
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
   * <p>示例：
   *
   * <pre>
   * 输入：s = "egg", t = "add"
   * 输出：true
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用额外空间</li>
   * <li>重点说清为什么单向映射不够，为什么通常需要双向约束</li>
   * </ul>
   */
  public boolean isIsomorphic(String s, String t) {
    if (s == null || t == null || s.length() != t.length()) {
      return false;
    }

    Map<Character, Character> forward = new HashMap<>();
    Map<Character, Character> reverse = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char source = s.charAt(i);
      char target = t.charAt(i);

      if (forward.containsKey(source) && forward.get(source) != target) {
        return false;
      }
      if (reverse.containsKey(target) && reverse.get(target) != source) {
        return false;
      }

      forward.put(source, target);
      reverse.put(target, source);
    }

    return true;
  }

  /**
   * 290. 单词规律
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
   * <p>示例：
   *
   * <pre>
   * 输入：pattern = "abba", s = "dog cat cat dog"
   * 输出：true
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用额外空间</li>
   * <li>重点说清为什么它本质上还是“同构关系模板迁移”</li>
   * </ul>
   */
  public boolean wordPattern(String pattern, String s) {
    if (pattern == null || s == null) {
      return false;
    }

    String[] words = s.split(" ");
    if (words.length != pattern.length()) {
      return false;
    }

    Map<Character, String> forward = new HashMap<>();
    Map<String, Character> reverse = new HashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
      char ch = pattern.charAt(i);
      String word = words[i];

      if (forward.containsKey(ch) && !forward.get(ch).equals(word)) {
        return false;
      }
      if (reverse.containsKey(word) && reverse.get(word) != ch) {
        return false;
      }

      forward.put(ch, word);
      reverse.put(word, ch);
    }

    return true;
  }

  public static void main(String[] args) {
    HashQuestion2 q = new HashQuestion2();
    System.out.println(Arrays.toString(q.twoSum(new int[] {2, 7, 11, 15}, 9)));
    System.out.println(q.isIsomorphic("egg", "add"));
    System.out.println(q.wordPattern("abba", "dog cat cat dog"));
  }
}
