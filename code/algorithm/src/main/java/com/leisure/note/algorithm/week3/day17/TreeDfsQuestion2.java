package com.leisure.note.algorithm.week3.day17;

/**
 * 题目：543. 二叉树的直径
 *
 * <p>题目描述：
 *
 * <p>给定一棵二叉树，你需要计算它的直径长度。二叉树的直径是任意两个节点路径长度中的最大值。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int diameterOfBinaryTree(TreeNode root)
 * </pre>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练后序 DFS</li>
 * <li>重点说清局部返回值和全局答案的区别</li>
 * </ul>
 */
public class TreeDfsQuestion2 {

  public int diameterOfBinaryTree(TreeNode root) {
    throw new UnsupportedOperationException("TODO: implement diameterOfBinaryTree");
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
