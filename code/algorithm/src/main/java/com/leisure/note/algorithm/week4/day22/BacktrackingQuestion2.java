package com.leisure.note.algorithm.week4.day22;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：78. 子集
 *
 * <p>题目描述：
 *
 * <p>给你一个整数数组 {@code nums}，数组中的元素互不相同，返回该数组所有可能的子集。
 *
 * <p>方法签名：
 *
 * <pre>
 * public List<List<Integer>> subsets(int[] nums)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]
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
 * <li>数组中的元素互不相同</li>
 * <li>返回结果顺序不作要求</li>
 * <li>允许使用额外空间，例如路径列表</li>
 * <li>这题的关键是理解“每个位置选或不选”的回溯树展开方式</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练回溯树展开</li>
 * <li>重点说清“子集类问题”的递归层和结果收集位置</li>
 * </ul>
 */
public class BacktrackingQuestion2 {

  public List<List<Integer>> subsets(int[] nums) {
    // 这题是子集型回溯：顺序不重要，所以用 startIndex 保证后续只往后选，避免重复。
    // 易错点：
    // 1. 子集题不是“选满才收答案”，而是每到一个节点，当前 path 就已经代表一个合法子集。
    // 2. 我前面检查时提过空数组边界，这里已经修成了 [[]]，比直接返回 [] 更符合子集语义。
    // 3. 子集题和排列题不一样，一般不需要 visited[]，核心控制变量是 startIndex。
    if (nums == null ) return null;
    List<List<Integer>> res = new ArrayList<>();
    if (nums.length == 0) {
      res.add(new ArrayList<>());
      return res;
    }

    List<Integer> path = new ArrayList<>();

    // 空路径本身就是一个合法子集。
    res.add(new ArrayList<>(path));
    backTrace(nums, path, 0, res);
    return res;
  }

  private void backTrace(int[] nums, List<Integer> path, int startIndex, List<List<Integer>> res) {
    if (path.size() == nums.length) {
      return;
    }

    for (int i = startIndex; i < nums.length; i++) {
      path.add(nums[i]);
      // 子集题是在“进入节点时”收集结果，不需要等到叶子节点。
      res.add(new ArrayList<>(path));
      backTrace(nums, path, i + 1, res);
      // 回溯：撤销当前选择，尝试同层下一个元素。
      path.remove(path.size() - 1);
    }
  }

  public static void main(String[] args) {
    BacktrackingQuestion2 backtrackingQuestion2 = new BacktrackingQuestion2();
    List<List<Integer>> res = backtrackingQuestion2.subsets(new int[] {1, 2, 3});
    System.out.println(res);
  }
}
