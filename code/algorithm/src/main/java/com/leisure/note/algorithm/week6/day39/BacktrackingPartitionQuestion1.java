package com.leisure.note.algorithm.week6.day39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Day39 回溯模式题：3.4 切割型。
 *
 * <p>对应 {@code 09_backtracking.md} 的 3.4 小节。
 * 本文件只保留题目描述和方法骨架，不写提示和具体实现。
 */
public class BacktrackingPartitionQuestion1 {

  /**
   * 131. 分割回文串
   *
   * <p>题目描述：
   *
   * <p>给定一个字符串 {@code s}，将 {@code s} 划分成若干个子串，使得每个子串都是回文串。
   * 返回所有可能的分割方案。
   * 一个分割方案可以表示为字符串列表，列表中的每个元素都是连续切出来的一段。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<List<String>> partition(String s)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：s = "aab"
   * 输出：[["a","a","b"],["aa","b"]]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：s = "efe"
   * 输出：[["e","f","e"],["efe"]]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>每个分割方案都必须把整个字符串完整切完</li>
   * <li>每一段都必须是回文串</li>
   * <li>结果中不要求分割方案的输出顺序</li>
   * </ul>
   */
  public List<List<String>> partition(String s) {
    List<String> list = new ArrayList<>();
    List<List<String>> ans = new ArrayList<>();
    char[] chars = s.toCharArray();
    backTrack1(chars, 0, 0, list, ans);
    return ans;
  }

  private void backTrack1(char[] chars, int startIndex, int cur, List<String> list, List<List<String>> ans) {
    if (cur == chars.length) {
      if (startIndex == cur) {
        ans.add(new ArrayList<>(list));
      }
      return;
    }

    if (checkSequence(chars, startIndex, cur)) {
      list.add(new String(Arrays.copyOfRange(chars, startIndex, cur + 1)));
      backTrack1(chars, cur + 1, cur + 1, list, ans);
      list.remove(list.size() - 1);
    }
    backTrack1(chars, startIndex, cur + 1, list, ans);
  }

  private boolean checkSequence(char[] chars, int startIndex, int endIndex) {
    while (startIndex < endIndex) {
      if (chars[startIndex] != chars[endIndex]) {
        return false;
      }
      startIndex++;
      endIndex--;
    }
    return true;
  }

  /**
   * 93. 复原 IP 地址
   *
   * <p>题目描述：
   *
   * <p>给定一个只包含数字的字符串 {@code s}，返回所有可能的有效 IP 地址。
   * 一个有效 IP 地址由 4 段组成，每一段的取值范围是 {@code 0} 到 {@code 255}，
   * 且不能包含前导零，除非这一段本身就是 {@code 0}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<String> restoreIpAddresses(String s)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：s = "25525511135"
   * 输出：["255.255.11.135","255.255.111.35"]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：s = "0000"
   * 输出：["0.0.0.0"]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>必须恰好切成 4 段</li>
   * <li>每一段都必须是合法整数</li>
   * <li>所有字符必须被用完，不能有剩余</li>
   * </ul>
   */
  public List<String> restoreIpAddresses(String s) {
    if (s == null || s.length() < 4 || s.length() > 12) {
      return Collections.emptyList();
    }
    List<String> ans = new ArrayList<>();
    List<String> list = new ArrayList<>();
    char[] chars = s.toCharArray();
    backTrack2(chars, 0, list, ans);
    return ans;
  }

  private void backTrack2(char[] chars, int startIndex, List<String> list, List<String> ans) {
    if (list.size() == 4) {
      if (startIndex == chars.length) {
        String addr = String.join(".", list);
        ans.add(addr);
      }
      return;
    }

    int remainChars = chars.length - startIndex;
    int remainParts = 4 - list.size();
    if (remainChars < remainParts || remainChars > remainParts * 3) {
      return;
    }

    for (int i = startIndex; i < chars.length && i < startIndex + 3; i++) {
      if (!checkSubString(chars, startIndex, i)) {
        continue;
      }
      list.add(new String(Arrays.copyOfRange(chars, startIndex, i + 1)));
      backTrack2(chars, i + 1, list, ans);
      list.remove(list.size() - 1);
    }
  }

  private boolean checkSubString(char[] chars, int startIndex, int endIndex) {
    if (startIndex > endIndex) {
      return false;
    }
    if (chars[startIndex] == '0' && startIndex != endIndex) {
      return false;
    }

    int value = 0;
    for (int i = startIndex; i <= endIndex; i++) {
      value = value * 10 + (chars[i] - '0');
    }
    return value >= 0 && value <= 255;
  }

  public static void main(String[] args) {
    BacktrackingPartitionQuestion1 question1 = new BacktrackingPartitionQuestion1();
//    System.out.println(question1.partition("aaba"));
    System.out.println(question1.restoreIpAddresses("25525511135"));
  }
}
