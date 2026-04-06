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
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：root = [1,2,3,4,5]
 * 输出：3
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：root = [1,2]
 * 输出：1
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标时间复杂度为 {@code O(n)}</li>
 * <li>树的直径长度按路径上的边数计算</li>
 * <li>直径不一定经过根节点</li>
 * <li>需要区分“递归返回给父节点的信息”和“全局最优答案”</li>
 * </ul>
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
