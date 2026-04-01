package com.leisure.note.algorithm.week3.day17;

/**
 * 题目：236. 二叉树的最近公共祖先
 *
 * <p>题目描述：
 *
 * <p>给定一个二叉树，找到该树中两个指定节点的最近公共祖先。
 *
 * <p>方法签名：
 *
 * <pre>
 * public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
 * </pre>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练树上的递归信息归并</li>
 * <li>重点说清递归返回值在父节点处如何组合</li>
 * </ul>
 */
public class TreeRecursionQuestion2 {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    throw new UnsupportedOperationException("TODO: implement lowestCommonAncestor");
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
