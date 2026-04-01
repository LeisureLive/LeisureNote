package com.leisure.note.algorithm.week3.day15;

import java.util.List;

/**
 * 题目：102. 二叉树的层序遍历
 *
 * <p>题目描述：
 *
 * <p>给你二叉树的根节点 {@code root}，返回其节点值的层序遍历结果。
 *
 * <p>方法签名：
 *
 * <pre>
 * public List<List<Integer>> levelOrder(TreeNode root)
 * </pre>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练树上的 BFS 模板</li>
 * <li>重点说清“按层处理”时队列大小的意义</li>
 * </ul>
 */
public class TreeBfsQuestion1 {

  public List<List<Integer>> levelOrder(TreeNode root) {
    throw new UnsupportedOperationException("TODO: implement levelOrder");
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
