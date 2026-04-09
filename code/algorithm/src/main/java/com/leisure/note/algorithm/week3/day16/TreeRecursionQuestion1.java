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
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
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
 * <li>目标时间复杂度为 {@code O(n)}</li>
 * <li>允许原地修改二叉树指针</li>
 * <li>返回翻转后的根节点</li>
 * <li>空树时直接返回 {@code null}</li>
 * </ul>
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
    if (root == null) return null;
    // 先保存原左右子树，避免交换过程中覆盖掉还没处理的指针。
    TreeNode left = root.left;
    TreeNode right = root.right;
    // 递归翻转后，把原右子树挂到左边，原左子树挂到右边。
    root.left = invertTree(right);
    root.right = invertTree(left);
    return root;
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

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
