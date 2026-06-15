package com.leisure.note.algorithm.week6.day39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Day39 回溯模式题：3.5 约束构造型。
 *
 * <p>对应 {@code 09_backtracking.md} 的 3.5 小节。
 * 本文件只保留题目描述和方法骨架，不写提示和具体实现。
 */
public class BacktrackingConstraintQuestion1 {

  /**
   * 17. 电话号码的字母组合
   *
   * <p>题目描述：
   *
   * <p>给定一个只包含数字 {@code 2} 到 {@code 9} 的字符串 {@code digits}，
   * 返回它能表示的所有字母组合。数字到字母的映射与手机键盘一致。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<String> letterCombinations(String digits)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：digits = "23"
   * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：digits = "7"
   * 输出：["p","q","r","s"]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>输入字符串只包含 {@code 2} 到 {@code 9}</li>
   * <li>返回结果中不要求顺序</li>
   * <li>如果输入为空字符串，结果应为空列表</li>
   * </ul>
   */
  public List<String> letterCombinations(String digits) {
    Map<Character, List<Character>> map = new HashMap<>();
    map.put('2', Arrays.asList('a', 'b', 'c'));
    map.put('3', Arrays.asList('d', 'e', 'f'));
    map.put('4', Arrays.asList('g', 'h', 'i'));
    map.put('5', Arrays.asList('j', 'k', 'l'));
    map.put('6', Arrays.asList('m', 'n', 'o'));
    map.put('7', Arrays.asList('p', 'q', 'r', 's'));
    map.put('8', Arrays.asList('t', 'u', 'v'));
    map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    char[] chars = digits.toCharArray();
    backTrack1(chars, 0, map, sb, ans);
    return ans;
  }

  private void backTrack1(char[] chars, int cur, Map<Character, List<Character>> map, StringBuilder sb,
    List<String> ans) {
    if (cur == chars.length) {
      ans.add(sb.toString());
      return;
    }

    List<Character> list = map.get(chars[cur]);
    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i));
      backTrack1(chars, cur + 1, map, sb, ans);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  /**
   * 51. N 皇后
   *
   * <p>题目描述：
   *
   * <p>给定一个整数 {@code n}，请你在 {@code n x n} 的棋盘上放置 {@code n} 个皇后，
   * 使得它们彼此之间不能互相攻击。皇后可以攻击同一行、同一列和同一对角线上的其他皇后。
   * 返回所有不同的摆法。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<List<String>> solveNQueens(int n)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：n = 4
   * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：n = 1
   * 输出：[["Q"]]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>每一行只能放 1 个皇后</li>
   * <li>每一列只能放 1 个皇后</li>
   * <li>同一条对角线上不能出现多个皇后</li>
   * </ul>
   */
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> ans = new ArrayList<>();
    int[][] positions = new int[n][n];
    backTrack2(positions, 0, ans);
    return ans;
  }

  private void backTrack2(int[][] positions, int row, List<List<String>> ans) {
    if (row == positions.length) {
      List<String> list = new ArrayList<>();
      for (int i = 0; i < positions.length; i++) {
        list.add(posToString(positions, i));
      }
      ans.add(new ArrayList<>(list));
      return;
    }

    for (int col = 0; col < positions.length; col++) {
      if (checkPos(positions, row, col)) {
        positions[row][col] = 1;
        backTrack2(positions, row + 1, ans);
        positions[row][col] = 0;
      }
    }

  }

  private boolean checkPos(int[][] positions, int row, int col) {
    // 对之前行、检测同列有没有皇后
    for (int i = row - 1; i >= 0; i--) {
      if (positions[i][col] == 1) {
        return false;
      }
    }

    // 对之前的行，检测对角线有没有皇后
    int i = row;
    int j = col;
    while (i > 0 && j > 0) {
      if (positions[--i][--j] == 1) {
        return false;
      }
    }

    i = row;
    j = col;
    while (j + 1 < positions.length && i - 1 >= 0) {
      if (positions[--i][++j] == 1) {
        return false;
      }
    }

    return true;
  }

  private String posToString(int[][] positions, int row) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < positions.length; i++) {
      if (positions[row][i] != 1) {
        sb.append(".");
      } else {
        sb.append("Q");
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    BacktrackingConstraintQuestion1 question1 = new BacktrackingConstraintQuestion1();
//    System.out.println(question1.letterCombinations("23"));
    System.out.println(question1.solveNQueens(4));
  }
}
