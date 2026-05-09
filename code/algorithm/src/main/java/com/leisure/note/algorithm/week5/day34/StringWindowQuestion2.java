package com.leisure.note.algorithm.week5.day34;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Day34 字符串模式题：滑动窗口。
 *
 * <p>这组题对应 `05_strings.md` 里的字符串滑动窗口主线，刻意避开当前台账里已经做过的
 * `3`、`438`、`76`，改用三道不同层次的代表题继续练窗口语义：
 *
 * <ul>
 * <li>`567`：固定长度窗口 + 频次匹配，作为 `438` 的存在性版本。</li>
 * <li>`424`：容错型窗口，训练“窗口内允许最多 k 个不一致字符”的合法性定义。</li>
 * <li>`30`：进阶分组窗口，训练按单词长度分块推进而不是按单字符推进。</li>
 * </ul>
 *
 * <p>本文件只初始化题目骨架，不直接给标准实现。
 */
public class StringWindowQuestion2 {

  /**
   * 567. 字符串的排列
   *
   * <p>题目描述：
   *
   * <p>给你两个字符串 {@code s1} 和 {@code s2}，写一个函数来判断 {@code s2} 是否包含 {@code s1}
   * 的排列。如果是，返回 {@code true}；否则，返回 {@code false}。
   *
   * <p>换句话说，{@code s1} 的排列之一是 {@code s2} 的子串。
   *
   * <p>方法签名：
   *
   * <pre>
   * public boolean checkInclusion(String s1, String s2)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：s1 = "ab", s2 = "eidbaooo"
   * 输出：true
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：s1 = "ab", s2 = "eidboaoo"
   * 输出：false
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度尽量做到 {@code O(n)}</li>
   * <li>允许使用额外空间维护字符频次</li>
   * <li>窗口长度固定为 {@code s1.length()}</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>字符串滑动窗口：固定长度窗口代表题。</li>
   * <li>重点是把“找异位词起点”简化成“判断是否存在一个合法窗口”。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先确认这是子串问题，因此窗口必须连续。</li>
   * <li>再明确窗口状态是字符频次是否匹配，而不是排序后比较。</li>
   * <li>窗口长度固定后，思考“进一个、出一个、何时判断答案”。</li>
   * <li>最后检查 {@code s1.length() > s2.length()} 的提前返回。</li>
   * </ol>
   */
  public boolean checkInclusion(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return false;
    }

    if (s1.length() > s2.length()) {
      return false;
    }

    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s1.length(); i++) {
      map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
    }

    int left = 0;
    int right = 0;
    int matchSize = 0;
    Map<Character, Integer> matchMap = new HashMap<>();
    while (right < s2.length()) {
      // 固定长度窗口：先把右侧字符入窗，再决定窗口何时需要移动左边界。
      char ch = s2.charAt(right);
      matchMap.put(ch, matchMap.getOrDefault(ch, 0) + 1);
      right++;

      if (map.containsKey(ch)) {
        if (matchMap.get(ch).equals(map.get(ch))) {
          matchSize++;
        } else if (matchMap.get(ch) - map.get(ch) == 1) {
          matchSize--;
        }
      }

      if (right - left < s1.length()) {
        continue;
      }

      if (matchSize == map.size()) {
        return true;
      } else {
        // 你前面在这题上真实踩过的坑是：窗口左边字符移出后，
        // 如果某个字符“重新回到刚好匹配”，matchSize 没有补回来。
        // 典型反例：
        // 1. s1 = "ab", s2 = "aab"
        // 2. s1 = "a",  s2 = "ba"
        // 所以这里移出左边字符前后，matchSize 都要按“刚好匹配 / 刚好失配”精确维护。
        char tmp = s2.charAt(left);
        if (matchMap.get(tmp).equals(map.getOrDefault(tmp, 0))) {
          matchSize--;
        }
        matchMap.put(tmp, matchMap.get(tmp) - 1);
        if (map.containsKey(tmp) && matchMap.get(tmp).equals(map.get(tmp))) {
          matchSize++;
        }
        left++;
      }
    }


    return false;
  }

  /**
   * 424. 替换后的最长重复字符
   *
   * <p>题目描述：
   *
   * <p>给你一个仅由大写英文字母组成的字符串 {@code s} 和一个整数 {@code k}。你可以最多替换
   * {@code k} 次，将字符串中的任意字符替换为另一个大写英文字母。
   *
   * <p>请你返回在执行上述操作后，包含相同字母的最长子串的长度。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int characterReplacement(String s, int k)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：s = "ABAB", k = 2
   * 输出：4
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：s = "AABABBA", k = 1
   * 输出：4
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度尽量做到 {@code O(n)}</li>
   * <li>允许使用额外空间维护频次</li>
   * <li>重点解释窗口为什么合法，以及何时需要收缩</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>字符串滑动窗口：容错型窗口代表题。</li>
   * <li>重点是把“最多替换 k 次”翻译成“窗口内除最高频字符外的其他字符数量最多为 k”。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先讲清窗口合法的定义，不要直接写代码。</li>
   * <li>再说明为什么窗口长度减去最高频字符数，可以表示当前最少替换次数。</li>
   * <li>最后再决定窗口何时收缩、何时更新答案。</li>
   * </ol>
   */
  public int characterReplacement(String s, int k) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    if (s.length() <= k) {
      return s.length();
    }

    Map<Character, Integer> map = new HashMap<>();
    int left = 0;
    int right = 0;
    int max = 0;
    while (right < s.length()) {
      // 当前实现保持你的原始思路：每轮把 right 扩进窗口，再重新判断当前窗口是否合法。
      char ch = s.charAt(right);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
      right++;

      // 你前面在这题上真实踩过的坑是：窗口较小时直接 continue，导致像 "AB", k = 2 会错误返回 0。
      // 当前这版通过提前处理 s.length() <= k，把这个边界收住了。
      if (right - left <= k) {
        continue;
      }

      int totalCharacterCount = right - left;
      int characterMaxCount = 0;
      // 这里每轮都会扫描一遍窗口频次，功能上没有问题。
      // 但这一步还能继续优化：维护一个历史 maxFreq，就能把整题写成更标准的 O(n) 解法。
      for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        if (entry.getValue() > characterMaxCount) {
          characterMaxCount = entry.getValue();
        }
      }
      int needSwitchCharacterCount = totalCharacterCount - characterMaxCount;
      if (needSwitchCharacterCount <= k) {
        max = Math.max(max, totalCharacterCount);
      } else {
        char leftChar = s.charAt(left);
        map.put(leftChar, map.get(leftChar) - 1);
        left++;
      }
    }

    return max;
  }

  /**
   * 30. 串联所有单词的子串
   *
   * <p>题目描述：
   *
   * <p>给定一个字符串 {@code s} 和一个字符串数组 {@code words}。{@code words} 中所有字符串长度相同。
   * {@code s} 中的串联子串是指恰好由 {@code words} 中所有字符串按任意顺序连接形成的子串，中间不能有其他字符。
   *
   * <p>返回所有串联子串在 {@code s} 中的起始下标，可以按任意顺序返回答案。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<Integer> findSubstring(String s, String[] words)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
   * 输出：[0,9]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
   * 输出：[]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>所有 {@code words[i]} 长度相同</li>
   * <li>允许使用额外空间维护单词频次</li>
   * <li>重点解释为什么这题要按“单词长度”分组滑动，而不是按字符逐个滑</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>字符串滑动窗口：进阶验收题。</li>
   * <li>它比 `438` 和 `567` 更复杂，因为窗口单位不再是字符，而是固定长度单词块。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先确认窗口推进单位是“单词长度”，不是单个字符。</li>
   * <li>再讲清需要维护的是“当前窗口中各单词出现次数”。</li>
   * <li>最后再处理单词过多、遇到非法单词、窗口刚好满足时的逻辑分支。</li>
   * </ol>
   */
  public List<Integer> findSubstring(String s, String[] words) {
    if (s == null || s.length() == 0 || words == null || words.length == 0) {
      return Collections.emptyList();
    }

    int wordLength = words[0].length();
    int wordTotalLength = wordLength * words.length;
    if (s.length() < wordTotalLength) {
      return Collections.emptyList();
    }

    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    int left = 0;
    List<Integer> res = new ArrayList<>();
    // 当前这版是“枚举每个起点 + 拷贝剩余频次表 + 按单词长度分块校验”的写法。
    // 功能上已经正确，但不是最优复杂度。
    // 更优写法可以按 wordLength 分组做滑动窗口，复用相邻起点的计算结果。
    while (left <= s.length() - wordTotalLength) {
      // 左闭右开区间
      int right = left + wordTotalLength;
      int prev = left;
      int cur = left + wordLength;
      Map<String, Integer> remainingMap = new HashMap<>(map);
      boolean match = true;
      while (cur <= right) {
        String sub = s.substring(prev, cur);
        if (remainingMap.containsKey(sub) && remainingMap.get(sub) > 0) {
          remainingMap.put(sub, remainingMap.get(sub) - 1);
        } else {
          match = false;
          break;
        }
        prev = cur;
        cur = cur + wordLength;
      }

      if (match) {
        res.add(left);
      }

      // 你前面在这题上真实踩过的坑是外层边界写成了 <，
      // 导致最后一个合法起点不会被检查到。
      // 反例："barfoo" + ["bar", "foo"]，正确答案应该包含起点 0。
      // 所以这里必须写成 <= s.length() - wordTotalLength。
      left++;
    }

    return res;
  }

  public static void main(String[] args) {
    StringWindowQuestion2 stringWindowQuestion2 = new StringWindowQuestion2();
//    System.out.println(stringWindowQuestion2.checkInclusion("a", "ba"));
    System.out.println(stringWindowQuestion2.characterReplacement("AB", 2));
//    System.out.println(stringWindowQuestion2.findSubstring("barfoothefoobarman", new String[] {"foo", "bar"}));
  }

}
