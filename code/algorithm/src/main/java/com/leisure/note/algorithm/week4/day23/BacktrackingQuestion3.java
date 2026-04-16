package com.leisure.note.algorithm.week4.day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：39. 组合总和
 *
 * <p>题目描述：
 *
 * <p>给你一个无重复元素的整数数组 {@code candidates} 和一个目标整数 {@code target}，找出所有和为 {@code target} 的组合。
 *
 * <p>方法签名：
 *
 * <pre>
 * public List<List<Integer>> combinationSum(int[] candidates, int target)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：candidates = [2,3,5], target = 8
 * 输出：[[2,2,2,2],[2,3,3],[3,5]]
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>{@code candidates} 中元素互不相同，且每个元素可以被重复选择多次</li>
 * <li>返回结果顺序不作要求，同一组合内元素顺序也不作为判题依据</li>
 * <li>允许使用额外空间，例如路径列表</li>
 * <li>需要结合排序或下标控制来避免生成重复组合，并尽量做剪枝</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练带剪枝的回溯</li>
 * <li>重点说清重复选择同一元素时下标如何处理</li>
 * </ul>
 */
public class BacktrackingQuestion3 {

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    // 这题是组合型回溯：顺序不重要，所以用 startIndex 保证后续只往后选。
    // 易错点：
    // 1. 这题允许重复使用当前数字，所以递归下一层时要继续传 i，而不是 i + 1。
    // 2. 我这里用 cur 表示当前路径和，达到 target 收答案，超过 target 直接返回。
    // 3. 排序后可以用“cur + candidates[i] > target 就 break”做前置剪枝，比递归后再失败返回更直接。
    if (candidates == null || candidates.length == 0) {
      return new ArrayList<>();
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    Arrays.sort(candidates);
    backTrace(candidates, res, path, 0, 0, target);
    return res;
  }

  private void backTrace(int[] candidates, List<List<Integer>> res, List<Integer> path, int startIndex, int cur,
    int target) {
    if (cur == target) {
      res.add(new ArrayList<>(path));
      return;
    }

    if (cur > target) {
      return;
    }

    for (int i = startIndex; i < candidates.length; i++) {
      // 数组已排序，当前值一旦超出剩余目标，后面更大的值也不用再试。
      if (cur + candidates[i] > target) {
        break;
      }
      path.add(candidates[i]);
      // 组合总和允许重复使用当前数字，所以递归仍然从 i 开始。
      backTrace(candidates, res, path, i, cur + candidates[i], target);
      // 回溯：撤销当前选择，尝试同层下一个候选数。
      path.remove(path.size() - 1);
    }
  }

  public static void main(String[] args) {
    BacktrackingQuestion3 backtrackingQuestion3 = new BacktrackingQuestion3();
    int[] nums = {1, 2, 3};
    List<List<Integer>> res = backtrackingQuestion3.combinationSum(nums, 3);
    System.out.println(res);
  }
}
