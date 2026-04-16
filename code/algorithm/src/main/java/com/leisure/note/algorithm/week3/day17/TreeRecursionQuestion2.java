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
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>默认 {@code p} 和 {@code q} 都存在于二叉树中</li>
 * <li>目标时间复杂度为 {@code O(n)}</li>
 * <li>如果一个节点本身就是另一个节点的祖先，那么它也可能是最近公共祖先</li>
 * <li>返回的是节点引用，而不是节点值</li>
 * </ul>
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
    if (root == null || p == null || q == null) {
      return null;
    }

    // 这题的核心不是返回 boolean，而是递归直接返回“当前子树里找到的有效节点引用”。
    // 易错点：
    // 1. 返回的是节点引用，不是节点值。
    // 2. 如果当前节点本身就是 p 或 q，它也可能就是答案的一部分，必须直接返回。
    // 3. 谁先同时接到左右两边的有效返回值，谁就是最近公共祖先。
    return dfs(root, p, q);
  }

  private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }

    if (root == p || root == q) {
      // 当前节点本身命中目标节点时，直接把它作为有效结果向上返回。
      return root;
    }

    // 后序归并：先分别看左右子树能返回什么节点引用。
    TreeNode left = dfs(root.left, p, q);
    TreeNode right = dfs(root.right, p, q);

    if (left != null && right != null) {
      // 左右两边都找到了有效结果，说明当前节点就是最近公共祖先。
      return root;
    }
    // 只有一边非空，说明 p 和 q 还都在同一侧，或者当前子树只命中了其中一个。
    return left == null ? right : left;
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
