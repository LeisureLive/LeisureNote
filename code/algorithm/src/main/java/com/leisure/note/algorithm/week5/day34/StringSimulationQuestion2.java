package com.leisure.note.algorithm.week5.day34;

import java.util.ArrayList;
import java.util.List;

/**
 * Day34 字符串模式题：模拟与解析。
 *
 * <p>这组题对应 `05_strings.md` 里的“模拟与解析”主线。台账里 `415` 已完成，因此这里继续补三个不同方向的代表题：
 *
 * <ul>
 * <li>`8`：多条件解析与边界控制。</li>
 * <li>`71`：路径语义模拟与分段处理。</li>
 * <li>`43`：字符串大数乘法，训练多位累积和进位管理。</li>
 * </ul>
 *
 * <p>本文件只初始化题目骨架，不直接给标准实现。
 */
public class StringSimulationQuestion2 {

  /**
   * 8. 字符串转换整数 (atoi)
   *
   * <p>题目描述：
   *
   * <p>请你来实现一个 {@code myAtoi(String s)} 函数，使其能将字符串转换成一个 32 位有符号整数。
   *
   * <p>函数的算法如下：
   *
   * <ul>
   * <li>读入并丢弃无用的前导空格</li>
   * <li>检查下一个字符是否为正负号，确定结果符号</li>
   * <li>尽可能多地读取数字字符并转换为整数</li>
   * <li>如果整数数值超过 32 位有符号整数范围，需要截断到边界值</li>
   * </ul>
   *
   * <p>方法签名：
   *
   * <pre>
   * public int myAtoi(String s)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：s = "42"
   * 输出：42
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：s = "   -42"
   * 输出：-42
   * </pre>
   *
   * <p>示例 3：
   *
   * <pre>
   * 输入：s = "4193 with words"
   * 输出：4193
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>必须按题意顺序解析，不能直接调用现成库完成转换</li>
   * <li>重点解释溢出判断放在什么时候做</li>
   * </ul>
   */
  public int myAtoi(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    boolean hasFuhao = false;
    boolean hasNumber = false;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        if (!hasNumber && !hasFuhao) {
          continue;
        } else {
          break;
        }
      } else if (s.charAt(i) == '+') {
        if (!hasFuhao) {
          hasFuhao = true;
          sb.append(s.charAt(i));
        } else {
          break;
        }
      } else if (s.charAt(i) == '-') {
        if (!hasFuhao) {
          hasFuhao = true;
          sb.append(s.charAt(i));
        } else {
          break;
        }
      } else if (s.charAt(i) < '0' || s.charAt(i) > '9') {
        break;
      } else {
        sb.append(s.charAt(i));
        long val = Long.parseLong(sb.toString());
        if (val < Integer.MIN_VALUE || val > Integer.MAX_VALUE) {
          sb.deleteCharAt(sb.length() - 1);
          break;
        }
      }
    }

    return Integer.parseInt(sb.toString());
  }

  /**
   * 71. 简化路径
   *
   * <p>题目描述：
   *
   * <p>给你一个字符串 {@code path}，表示指向某一文件或目录的 Unix 风格绝对路径，请你将其转化为更加简洁的规范路径。
   *
   * <p>规范路径要求：
   *
   * <ul>
   * <li>始终以斜杠 {@code '/'} 开头</li>
   * <li>两个目录名之间必须只有一个斜杠</li>
   * <li>最后一个目录名后不能以斜杠结尾</li>
   * <li>路径中只包含从根目录到目标目录的目录名，不包含 {@code .} 和 {@code ..}</li>
   * </ul>
   *
   * <p>方法签名：
   *
   * <pre>
   * public String simplifyPath(String path)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：path = "/home/"
   * 输出："/home"
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：path = "/a/./b/../../c/"
   * 输出："/c"
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>重点解释 {@code .}、{@code ..}、连续斜杠各自代表什么语义</li>
   * <li>先把路径按片段拆开，再决定每种片段如何处理</li>
   * </ul>
   */
  public String simplifyPath(String path) {
    if (path == null || path.length() == 0) {
      return path;
    }

    String[] splits = path.split("/");
    List<String> validSplit = new ArrayList<>();
    for (String split : splits) {
      if (split.equals(".") || split.isEmpty()) {
      } else if (split.equals("..")) {
        validSplit.remove(validSplit.size() - 1);
      } else {
        validSplit.add(split);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (String split : validSplit) {
      sb.append("/").append(split);
    }
    return sb.toString();
  }

  /**
   * 43. 字符串相乘
   *
   * <p>题目描述：
   *
   * <p>给定两个以字符串形式表示的非负整数 {@code num1} 和 {@code num2}，返回它们的乘积，乘积也用字符串表示。
   *
   * <p>注意：不能使用任何内置的 BigInteger 库，也不能直接将输入转换为整数。
   *
   * <p>方法签名：
   *
   * <pre>
   * public String multiply(String num1, String num2)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：num1 = "2", num2 = "3"
   * 输出："6"
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：num1 = "123", num2 = "456"
   * 输出："56088"
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>不能把整个字符串直接转成整数后相乘</li>
   * <li>目标时间复杂度通常为 {@code O(m * n)}</li>
   * <li>重点解释每一位乘积应该累积到结果数组的哪个位置</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>字符串模拟：大数运算进阶题。</li>
   * <li>它比 `415` 更进一步，因为不只是处理单条进位链，还要处理多位乘积的叠加。</li>
   * </ul>
   */
  public String multiply(String num1, String num2) {
    if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
      return null;
    }

    List<Integer> sums = new ArrayList<>();
    int base = 1;
    for (int i = num1.length() - 1; i >= 0; i--) {
      int num = (num1.charAt(i) - '0') * base;

      int sum = 0;
      int innerBase = 1;
      for (int j = num2.length() - 1; j >= 0; j--) {
        int tmp = num2.charAt(j) - '0';
        sum += tmp * innerBase * num;
        innerBase *= 10;
      }
      sums.add(sum);

      base = base * 10;
    }
    throw new UnsupportedOperationException("TODO: implement 43. 字符串相乘");
  }

  public static void main(String[] args) {
    StringSimulationQuestion2 stringSimulationQuestion2 = new StringSimulationQuestion2();
//    System.out.println(stringSimulationQuestion2.myAtoi(" -4193 with words"));
    System.out.println(stringSimulationQuestion2.simplifyPath("/a/./b/../../c/"));
  }
}
