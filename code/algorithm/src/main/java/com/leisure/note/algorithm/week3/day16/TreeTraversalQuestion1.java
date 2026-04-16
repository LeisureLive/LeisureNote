package com.leisure.note.algorithm.week3.day16;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
    if (root == null) return new ArrayList<>();
    // 中序遍历顺序固定为：左子树 -> 当前节点 -> 右子树。
    List<Integer> result = new ArrayList<>();
    dfs(root, result);
    return result;
  }

  private void dfs(TreeNode root, List<Integer> result) {
    if (root == null) return;
    // 递归时先处理左子树，再访问当前节点，最后处理右子树。
    dfs(root.left, result);
    result.add(root.val);
    dfs(root.right, result);
  }

  public List<Integer> inorderTraversalIterative(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode current = root;

    while (!stack.isEmpty() || current != null) {
      if (current != null) {
        // 先一路向左，把沿途节点压栈。
        stack.push(current);
        current = current.left;
      } else {
        // 左子树处理完后，弹出栈顶节点访问，再切到右子树。
        current = stack.pop();
        result.add(current.val);
        current = current.right;
      }
    }

    return result;
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
