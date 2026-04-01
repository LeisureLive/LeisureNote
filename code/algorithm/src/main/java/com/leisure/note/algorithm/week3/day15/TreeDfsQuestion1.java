package com.leisure.note.algorithm.week3.day15;

/**
 * 题目：104. 二叉树的最大深度
 *
 * <p>题目描述：
 *
 * <p>给定一个二叉树 {@code root}，返回其最大深度。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int maxDepth(TreeNode root)
 * </pre>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练树上的 DFS 模板</li>
 * <li>重点说清递归函数的定义和返回值含义</li>
 * </ul>
 */
public class TreeDfsQuestion1 {

  public int maxDepth(TreeNode root) {
    throw new UnsupportedOperationException("TODO: implement maxDepth");
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
