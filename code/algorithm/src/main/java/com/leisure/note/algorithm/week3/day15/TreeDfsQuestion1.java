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
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：root = [1,null,2]
 * 输出：2
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标时间复杂度为 {@code O(n)}</li>
 * <li>允许使用递归或显式栈</li>
 * <li>空树的最大深度定义为 {@code 0}</li>
 * <li>返回的是从根节点到最深叶子节点的节点数，不是边数</li>
 * </ul>
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
    // 递归函数定义：返回以当前节点为根的子树最大深度。
    if (root == null) return 0;
    if (root.left == null && root.right == null) return 1;
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    return Math.max(left, right) + 1;
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
