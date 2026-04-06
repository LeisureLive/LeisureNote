package com.leisure.note.algorithm.week4.day23;

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
    throw new UnsupportedOperationException("TODO: implement combinationSum");
  }
}
