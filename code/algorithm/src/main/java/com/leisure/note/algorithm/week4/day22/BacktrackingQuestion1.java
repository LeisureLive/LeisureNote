package com.leisure.note.algorithm.week4.day22;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：46. 全排列
 *
 * <p>题目描述：
 *
 * <p>给定一个不含重复数字的数组 {@code nums}，返回其所有可能的全排列。
 *
 * <p>方法签名：
 *
 * <pre>
 * public List<List<Integer>> permute(int[] nums)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>数组中的元素互不相同</li>
 * <li>返回结果顺序不作要求</li>
 * <li>允许使用额外空间，例如 {@code used[]} 或路径列表</li>
 * <li>目标是训练回溯模板，不要求额外去重逻辑</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练回溯模板</li>
 * <li>重点说清路径、选择列表、结束条件</li>
 * </ul>
 */
public class BacktrackingQuestion1 {

  public List<List<Integer>> permute(int[] nums) {
    // 这题是排列型回溯：顺序不同算不同结果，所以要用 visited[] 记录哪些元素已经被选过。
    // 易错点：
    // 1. 排列题不能只靠 startIndex，核心是“每层都能从所有未使用元素里继续选”。
    // 2. 收集答案时必须拷贝 path，不能直接把 path 本身放进结果。
    // 3. 递归返回时要同时撤销“路径”和“访问状态”两个动作。
    if (nums == null || nums.length == 0) return new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    List<Integer> path = new ArrayList<>();
    boolean[] visited = new boolean[nums.length];
    backTrace(nums, path, visited, res);
    return res;
  }

  private void backTrace(int[] nums, List<Integer> path, boolean[] visited, List<List<Integer>> res) {
    if (path.size() == nums.length) {
      res.add(new ArrayList<>(path));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      // visited[i] 表示 nums[i] 已经在当前排列路径里，不能重复使用。
      if (!visited[i]) {
        path.add(nums[i]);
        visited[i] = true;
        backTrace(nums, path, visited, res);
        // 回溯：撤销本层选择，恢复现场。
        path.remove(path.size() - 1);
        visited[i] = false;
      }
    }
  }

  public static void main(String[] args) {
    BacktrackingQuestion1 backtrackingQuestion1 = new BacktrackingQuestion1();
    int[] nums = {1, 2, 3};
    List<List<Integer>> res = backtrackingQuestion1.permute(nums);
    System.out.println(res);
  }
}
