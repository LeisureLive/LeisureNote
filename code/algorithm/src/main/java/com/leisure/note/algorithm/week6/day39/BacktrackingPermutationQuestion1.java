package com.leisure.note.algorithm.week6.day39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Day39 回溯模式题：3.3 排列型。
 *
 * <p>对应 {@code 09_backtracking.md} 的 3.3 小节。
 * 本文件只保留题目描述和方法骨架，不写提示和具体实现。
 */
public class BacktrackingPermutationQuestion1 {

  /**
   * 47. 全排列 II
   *
   * <p>题目描述：
   *
   * <p>给定一个可包含重复数字的整数数组 {@code nums}，返回所有不重复的全排列。
   * 结果中不要求顺序。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<List<Integer>> permuteUnique(int[] nums)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums = [1,1,2]
   * 输出：[[1,1,2],[1,2,1],[2,1,1]]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums = [1,2,3]
   * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>{@code nums} 可能包含重复数字</li>
   * <li>同一个数字值在结果中不能因不同下标来源而重复出现相同排列</li>
   * <li>每个元素在每个排列中只能使用一次</li>
   * </ul>
   */
  public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] visited = new boolean[nums.length];
    backTrack(nums, visited, list, ans);
    return ans;
  }

  private void backTrack(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> ans) {
    if (list.size() == nums.length) {
      ans.add(new ArrayList<>(list));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (visited[i]) {
        continue;
      }
      if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
        continue;
      }
      list.add(nums[i]);
      visited[i] = true;
      backTrack(nums, visited, list, ans);
      list.remove(list.size() - 1);
      visited[i] = false;
    }
  }

  public static void main(String[] args) {
    BacktrackingPermutationQuestion1 question1 = new BacktrackingPermutationQuestion1();
    System.out.println(question1.permuteUnique(new int[] {1, 1, 1, 2}));
  }
}
