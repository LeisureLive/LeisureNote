package com.leisure.note.algorithm.week5.day34;

/**
 * Day34 字符串模式题：双指针 / 回文判断。
 *
 * <p>这组题对应 `05_strings.md` 里的“双指针 / 回文判断”主线，覆盖从基础到带一次容错的对照训练：
 *
 * <ul>
 * <li>`344`：原地反转字符数组，训练最基础的左右夹逼。</li>
 * <li>`125`：验证回文串，训练字符过滤、大小写统一和边界控制。</li>
 * <li>`680`：验证回文串 II，训练“一次容错”分支判断。</li>
 * </ul>
 *
 * <p>本文件只初始化题目骨架，不直接给标准实现。
 */
public class StringTwoPointerQuestion1 {

  /**
   * 344. 反转字符串
   *
   * <p>题目描述：
   *
   * <p>编写一个函数，其作用是将输入的字符数组原地反转。
   *
   * <p>方法签名：
   *
   * <pre>
   * public void reverseString(char[] s)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：s = ['h','e','l','l','o']
   * 输出：['o','l','l','e','h']
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：s = ['H','a','n','n','a','h']
   * 输出：['h','a','n','n','a','H']
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>必须原地修改输入数组</li>
   * <li>目标额外空间复杂度为 {@code O(1)}</li>
   * <li>重点说清什么时候停止交换</li>
   * </ul>
   */
  public void reverseString(char[] s) {
    if (s == null || s.length <= 1) {
      return;
    }

    // 最基础的左右夹逼双指针模板：
    // 每轮交换两端字符，然后 left / right 同时向中间收缩，直到相遇或交错。
    int left = 0;
    int right = s.length - 1;
    while (left < right) {
      swap(s, left, right);
      left++;
      right--;
    }
  }

  private void swap(char[] s, int i, int j) {
    char ch = s[i];
    s[i] = s[j];
    s[j] = ch;
  }

  /**
   * 125. 验证回文串
   *
   * <p>题目描述：
   *
   * <p>如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。
   * 则可以认为该短语是一个回文串。
   *
   * <p>给你一个字符串 {@code s}，如果它是回文串，返回 {@code true}；否则，返回 {@code false}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public boolean isPalindrome(String s)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：s = "A man, a plan, a canal: Panama"
   * 输出：true
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：s = "race a car"
   * 输出：false
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>需要忽略非字母数字字符</li>
   * <li>需要忽略大小写差异</li>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>字符串双指针：回文判断基础模板题。</li>
   * <li>关键不在技巧，而在“先过滤无效字符，再做主体比较”。</li>
   * </ul>
   */
  public boolean isPalindrome(String s) {
    if (s == null || s.length() <= 1) {
      return true;
    }

    // 这题的关键不是直接双指针比原串，而是先把“真正参与比较的字符”过滤出来。
    // 你前面这里真实踩过的坑是：一开始只保留了字母，漏掉了数字字符。
    // 典型反例："0P"。如果把 '0' 过滤掉，会错误返回 true。
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch >= 'a' && ch <= 'z') {
        sb.append(ch);
      } else if (ch >= 'A' && ch <= 'Z') {
        sb.append(Character.toLowerCase(ch));
      } else if (ch >= '0' && ch <= '9') {
        sb.append(ch);
      }
    }

    String str = sb.toString();

    if (str.length() <= 1) {
      return true;
    }

    // 过滤和归一化完成后，剩下的就是标准回文比较模板。
    int left = 0;
    int right = str.length() - 1;
    while (left < right) {
      if (str.charAt(left) != str.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }

    return true;
  }

  /**
   * 680. 验证回文串 II
   *
   * <p>题目描述：
   *
   * <p>给定一个非空字符串 {@code s}，最多删除一个字符。判断是否能成为回文字符串。
   *
   * <p>方法签名：
   *
   * <pre>
   * public boolean validPalindrome(String s)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：s = "aba"
   * 输出：true
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：s = "abca"
   * 输出：true
   * 解释：你可以删除字符 'c'。
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度尽量做到 {@code O(n)}</li>
   * <li>重点解释第一次失配时为什么只需要检查两种删除方案</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>字符串双指针：一次容错回文判断题。</li>
   * <li>重点是把“遇到第一次不等时怎么分支”讲清楚。</li>
   * </ul>
   */
  public boolean validPalindrome(String s) {
    if (s == null || s.length() <= 1) {
      return true;
    }

    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        // 你前面在这题上真实踩过的坑是：第一次失配时贪心地只删一边。
        // 反例："abbab"。
        // 正确做法是把“删左字符”和“删右字符”两种方案都验证一遍，
        // 因为第一次失配就是唯一一次决策点，不能只靠局部看起来可行就直接推进。
        return isValidPalindromeRange(s, left + 1, right) || isValidPalindromeRange(s, left, right - 1);
      }
      left++;
      right--;
    }

    return true;
  }

  private boolean isValidPalindromeRange(String s, int left, int right) {
    // helper 只负责验证一个闭区间本身是不是回文，
    // 让主流程专注处理“第一次失配后要尝试哪两个删除分支”。
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }

      left++;
      right--;
    }

    return true;
  }


  public static void main(String[] args) {
    StringTwoPointerQuestion1 stringTwoPointerQuestion1 = new StringTwoPointerQuestion1();
//    char[] s = new char[] {'H', 'a', 'n', 'n', 'a', 'h'};
//    stringTwoPointerQuestion1.reverseString(s);
//    System.out.println(s);
//    System.out.println(stringTwoPointerQuestion1.isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println(stringTwoPointerQuestion1.validPalindrome("abbab"));
  }
}
