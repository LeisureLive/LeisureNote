package com.leisure.note.algorithm.week3.day19;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：415. 字符串相加
 *
 * <p>题目描述：
 *
 * <p>给定两个字符串形式的非负整数 {@code num1} 和 {@code num2}，计算它们的和并同样以字符串形式返回。
 *
 * <p>方法签名：
 *
 * <pre>
 * public String addStrings(String num1, String num2)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>不允许直接把整个字符串转成整数类型后再相加</li>
 * <li>目标时间复杂度为 {@code O(max(m, n))}</li>
 * <li>两个输入字符串都只包含数字字符，且表示非负整数</li>
 * <li>需要处理长度不同以及最高位进位的情况</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练字符串模拟</li>
 * <li>重点说清为什么从后往前处理，以及如何维护进位</li>
 * </ul>
 */
public class StringSimulationQuestion1 {

  public String addStrings(String num1, String num2) {
    // 这题按竖式加法模拟：从低位往高位累加，同时维护进位。
    // 易错点：
    // 1. 我这次一开始漏掉了“最后一位进位”的处理，像 99 + 1 会错。
    // 2. 这题不能从前往后做，因为进位方向是从低位传到高位。
    if (num1 == null && num2 == null) {
      return null;
    }
    if (num1 == null) {
      return num2;
    }
    if (num2 == null) {
      return num1;
    }

    int i = num1.length() - 1;
    int j = num2.length() - 1;
    List<Character> result = new ArrayList<>();
    int more = 0;
    while (i >= 0 || j >= 0) {
      int n1 = 0;
      int n2 = 0;
      if (i >= 0) {
        n1 = num1.charAt(i) - '0';
        i--;
      }
      if (j >= 0) {
        n2 = num2.charAt(j) - '0';
        j--;
      }

      int sum = n1 + n2 + more;
      result.add((char) (sum % 10 + '0'));
      more = sum / 10;
    }

    // 循环结束后如果还有进位，要补到结果最高位。
    if (more > 0) {
      result.add((char) (more + '0'));
    }
    StringBuilder sb = new StringBuilder();
    for (int k = result.size() - 1; k >= 0; k--) {
      sb.append(result.get(k));
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    StringSimulationQuestion1 stringSimulationQuestion1 = new StringSimulationQuestion1();
    System.out.println(stringSimulationQuestion1.addStrings("99", "1"));
  }

}
