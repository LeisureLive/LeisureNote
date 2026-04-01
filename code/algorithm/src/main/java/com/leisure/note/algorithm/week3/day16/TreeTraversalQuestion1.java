package com.leisure.note.algorithm.week3.day16;

import java.util.List;

/**
 * 题目：94. 二叉树的中序遍历
 *
 * <p>题目描述：
 *
 * <p>给定一个二叉树的根节点 {@code root}，返回它的中序遍历。
 *
 * <p>方法签名：
 *
 * <pre>
 * public List<Integer> inorderTraversal(TreeNode root)
 * </pre>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练树遍历模板</li>
 * <li>重点区分递归写法和栈模拟写法</li>
 * </ul>
 */
public class TreeTraversalQuestion1 {

  public List<Integer> inorderTraversal(TreeNode root) {
    throw new UnsupportedOperationException("TODO: implement inorderTraversal");
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
