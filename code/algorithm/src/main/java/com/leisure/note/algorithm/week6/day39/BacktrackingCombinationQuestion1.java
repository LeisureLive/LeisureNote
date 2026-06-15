package com.leisure.note.algorithm.week6.day39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Day39 回溯模式题：3.2 组合型。
 *
 * <p>对应 {@code 09_backtracking.md} 的 3.2 小节。
 * 本文件只保留题目描述和方法骨架，不写提示和具体实现。
 */
public class BacktrackingCombinationQuestion1 {

  /**
   * 77. 组合
   *
   * <p>题目描述：
   *
   * <p>给定两个整数 {@code n} 和 {@code k}，返回范围 {@code [1, n]} 中所有可能的 {@code k} 个数的组合。
   * 结果中不要求顺序。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<List<Integer>> combine(int n, int k)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：n = 4, k = 2
   * 输出：[[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：n = 1, k = 1
   * 输出：[[1]]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>组合中的数字必须来自 {@code [1, n]}</li>
   * <li>每个数字最多使用一次</li>
   * <li>结果中不要求按字典序输出</li>
   * </ul>
   */
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    backTrack1(1, n, k, list, ans);
    return ans;
  }

  private void backTrack1(int start, int n, int k, List<Integer> list, List<List<Integer>> ans) {
    if (list.size() == k) {
      ans.add(new ArrayList<>(list));
      return;
    }

    if (start > n) {
      return;
    }

    list.add(start);
    backTrack1(start + 1, n, k, list, ans);
    list.remove(list.size() - 1);
    backTrack1(start + 1, n, k, list, ans);
  }

  /**
   * 40. 组合总和 II
   *
   * <p>题目描述：
   *
   * <p>给定一个可能包含重复元素的整数数组 {@code candidates} 和一个目标值 {@code target}，
   * 找出 {@code candidates} 中所有和为 {@code target} 的组合。
   * 每个数字在每个组合中只能使用一次，结果中不能包含重复组合。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<List<Integer>> combinationSum2(int[] candidates, int target)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：candidates = [10,1,2,7,6,1,5], target = 8
   * 输出：[[1,1,6],[1,2,5],[1,7],[2,6]]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：candidates = [2,5,2,1,2], target = 5
   * 输出：[[1,2,2],[5]]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>{@code candidates} 可能包含重复元素</li>
   * <li>同一个元素在同一个组合中最多使用一次</li>
   * <li>结果中不能包含重复组合</li>
   * </ul>
   */
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    backTrack2(candidates, 0, 0, target, list, ans);
    return ans;
  }

  private void backTrack2(int[] candidates, int startIndex, int sum, int target, List<Integer> list,
    List<List<Integer>> ans) {
    if (sum == target) {
      ans.add(new ArrayList<>(list));
      return;
    }

    if (sum > target || startIndex == candidates.length) {
      return;
    }

    list.add(candidates[startIndex]);
    backTrack2(candidates, startIndex + 1, sum + candidates[startIndex], target, list, ans);
    list.remove(list.size() - 1);
    while (startIndex + 1 < candidates.length && candidates[startIndex] == candidates[startIndex + 1]) {
      startIndex++;
    }
    backTrack2(candidates, startIndex + 1, sum, target, list, ans);
  }

  /**
   * 216. 组合总和 III
   *
   * <p>题目描述：
   *
   * <p>找出所有由 {@code k} 个不同整数组成的组合，这些数字都来自 {@code 1} 到 {@code 9}，
   * 且组合中所有数字的和等于 {@code n}。
   * 结果中不要求顺序。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<List<Integer>> combinationSum3(int k, int n)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：k = 3, n = 7
   * 输出：[[1,2,4]]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：k = 3, n = 9
   * 输出：[[1,2,6],[1,3,5],[2,3,4]]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>只能使用 {@code 1} 到 {@code 9} 之间的数字</li>
   * <li>每个数字最多使用一次</li>
   * <li>必须恰好选 {@code k} 个数字</li>
   * </ul>
   */
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    backTrack3(1, 0, k, n, list, ans);
    return ans;
  }

  private void backTrack3(int cur, int sum, int k, int target, List<Integer> list, List<List<Integer>> ans) {
    if (sum == target) {
      if (list.size() == k) {
        ans.add(new ArrayList<>(list));
      }
      return;
    }

    if (sum > target) {
      return;
    }

    if (list.size() >= k) {
      return;
    }

    if (cur > 9) {
      return;
    }

    list.add(cur);
    backTrack3(cur + 1, sum + cur, k, target, list, ans);
    list.remove(list.size() - 1);
    backTrack3(cur + 1, sum, k, target, list, ans);
  }

  public static void main(String[] args) {
    BacktrackingCombinationQuestion1 question1 = new BacktrackingCombinationQuestion1();
    System.out.println(question1.combinationSum3(3, 9));
  }
}
