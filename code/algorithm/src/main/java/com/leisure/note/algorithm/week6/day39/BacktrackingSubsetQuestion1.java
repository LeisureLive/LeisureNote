package com.leisure.note.algorithm.week6.day39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Day39 回溯模式题：3.1 子集型。
 *
 * <p>对应 {@code 09_backtracking.md} 的 3.1 小节。
 * 本文件只保留题目描述和方法骨架，不写提示和具体实现。
 */
public class BacktrackingSubsetQuestion1 {

  /**
   * 90. 子集 II
   *
   * <p>题目描述：
   *
   * <p>给定一个可能包含重复元素的整数数组 {@code nums}，返回该数组所有可能的子集。
   * 结果集中不能包含重复的子集，返回顺序不作要求。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<List<Integer>> subsetsWithDup(int[] nums)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums = [1,2,2]
   * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums = [0]
   * 输出：[[],[0]]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>{@code nums} 可能包含重复数字</li>
   * <li>每个子集中的元素顺序不作要求，结果顺序也不作要求</li>
   * <li>返回结果中不能出现重复子集</li>
   * </ul>
   */
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> subsets = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    subsets.add(new ArrayList<>(list));
    backTrackSubset(nums, 0, list, subsets);
    return subsets;
  }

  private void backTrackSubset(int[] nums, int startIndex, List<Integer> list,
    List<List<Integer>> subsets) {
    if (startIndex >= nums.length) {
      return;
    }

    list.add(nums[startIndex]);
    subsets.add(new ArrayList<>(list));
    backTrackSubset(nums, startIndex + 1, list, subsets);
    list.remove(list.size() - 1);
    // 不选就跳过后面一样的数
    while (startIndex + 1 < nums.length && nums[startIndex + 1] == nums[startIndex]) {
      startIndex++;
    }
    backTrackSubset(nums, startIndex + 1, list, subsets);
  }

  /**
   * 491. 非递减子序列
   *
   * <p>题目描述：
   *
   * <p>给定一个整数数组 {@code nums}，找出其中所有长度至少为 2 的非递减子序列。
   * 子序列中的元素顺序必须与原数组中的相对顺序一致，但不要求连续。
   * 结果中不能包含重复的子序列，返回顺序不作要求。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<List<Integer>> findSubsequences(int[] nums)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums = [4,6,7,7]
   * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
   * </pre>
   *
   * <p>示例说明：
   *
   * <pre>
   * [4,7] 可以由第 1 个 4 和第 1 个 7 组成，也可以由第 1 个 4 和第 2 个 7 组成，
   * 但结果里只能保留一次。
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums = [4,4,3,2,1]
   * 输出：[[4,4]]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>子序列长度必须至少为 2</li>
   * <li>子序列必须保持原数组的相对顺序</li>
   * <li>结果中不能出现重复子序列</li>
   * </ul>
   */
  public List<List<Integer>> findSubsequences(int[] nums) {
    if (nums.length < 2) {
      return Collections.emptyList();
    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    backTrackSequence(nums, 0, Integer.MIN_VALUE, path, ans);
    return ans;
  }

  /**
   * 491. 非递减子序列
   *
   * <p>这版采用“按层 {@code HashSet} 去重”的写法。
   *
   * <p>含义说明：
   *
   * <ul>
   * <li>同一层递归里，如果两个候选值相同，只展开第一次出现的那个值，后面的同值分支直接跳过。</li>
   * <li>这个去重只作用在“当前层”，不会影响下一层继续使用相同的数值，所以不会误杀像 {@code [7,7]} 这种合法结果。</li>
   * <li>{@code startIndex} 负责保证子序列的相对顺序；{@code path} 负责保存当前已经选出的序列。</li>
   * <li>非递减约束通过“当前候选值不能小于 path 最后一个值”来剪枝。</li>
   * </ul>
   */
  public List<List<Integer>> findSubsequences2(int[] nums) {
    if (nums == null || nums.length < 2) {
      return new ArrayList<>();
    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    backTrackSequence2(nums, 0, path, ans);
    return ans;
  }

  private void backTrackSequence2(int[] nums, int startIndex, List<Integer> path,
    List<List<Integer>> ans) {
    if (path.size() >= 2) {
      ans.add(new ArrayList<>(path));
    }

    Set<Integer> usedOnLevel = new HashSet<>();
    for (int i = startIndex; i < nums.length; i++) {
      // 保证序列非递减：当前数字不能比路径末尾更小。
      if (!path.isEmpty() && nums[i] < path.get(path.size() - 1)) {
        continue;
      }

      // 同层去重：同一层里相同的数只展开一次，避免生成重复子序列。
      if (!usedOnLevel.add(nums[i])) {
        continue;
      }

      path.add(nums[i]);
      backTrackSequence2(nums, i + 1, path, ans);
      path.remove(path.size() - 1);
    }
  }

  private void backTrackSequence(int[] nums, int startIndex,
    int prev, List<Integer> path, List<List<Integer>> ans) {
    if (startIndex == nums.length) {
      if (path.size() >= 2) {
        ans.add(new ArrayList<>(path));
      }
      return;
    }

    if (nums[startIndex] >= prev) {
      path.add(nums[startIndex]);
      backTrackSequence(nums, startIndex + 1, nums[startIndex], path, ans);
      path.remove(path.size() - 1);
    }

    if (prev != nums[startIndex]) {
      backTrackSequence(nums, startIndex + 1, prev, path, ans);
    }
  }

  public static void main(String[] args) {
    BacktrackingSubsetQuestion1 question1 = new BacktrackingSubsetQuestion1();
    System.out.println(question1.findSubsequences(new int[] {4, 6, 7, 7, 7}));
  }

}
