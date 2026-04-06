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
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：root = []
 * 输出：[]
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>允许使用递归或显式栈实现</li>
 * <li>目标时间复杂度为 {@code O(n)}</li>
 * <li>返回顺序必须是“左子树 -> 根节点 -> 右子树”</li>
 * <li>空树时返回空列表，不要返回 {@code null}</li>
 * </ul>
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
