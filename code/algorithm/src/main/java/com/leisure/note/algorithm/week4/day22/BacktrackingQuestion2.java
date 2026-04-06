package com.leisure.note.algorithm.week4.day22;

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
    throw new UnsupportedOperationException("TODO: implement subsets");
  }
}
