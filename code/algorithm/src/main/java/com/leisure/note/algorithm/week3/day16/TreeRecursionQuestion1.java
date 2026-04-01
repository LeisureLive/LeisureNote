package com.leisure.note.algorithm.week3.day16;

/**
 * 题目：226. 翻转二叉树
 *
 * <p>题目描述：
 *
 * <p>给你一棵二叉树的根节点 {@code root}，翻转这棵二叉树，并返回其根节点。
 *
 * <p>方法签名：
 *
 * <pre>
 * public TreeNode invertTree(TreeNode root)
 * </pre>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练树递归基础</li>
 * <li>重点说清“当前节点该做什么、子问题是什么”</li>
 * </ul>
 */
public class TreeRecursionQuestion1 {

  public TreeNode invertTree(TreeNode root) {
    throw new UnsupportedOperationException("TODO: implement invertTree");
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
