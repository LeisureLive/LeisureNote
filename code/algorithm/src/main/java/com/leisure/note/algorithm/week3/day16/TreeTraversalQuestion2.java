package com.leisure.note.algorithm.week3.day16;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 题目：144. 二叉树的前序遍历
 *
 * <p>题目描述：
 *
 * <p>给定一个二叉树的根节点 {@code root}，返回它的前序遍历。
 *
 * <p>方法签名：
 *
 * <pre>
 * public List<Integer> preorderTraversal(TreeNode root)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
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
 * <li>返回顺序必须是“根节点 -> 左子树 -> 右子树”</li>
 * <li>空树时返回空列表，不要返回 {@code null}</li>
 * </ul>
 */
public class TreeTraversalQuestion2 {

  public List<Integer> preorderTraversal(TreeNode root) {
    if (root == null) return new ArrayList<>();

    List<Integer> result = new ArrayList<>();
    dfs(root, result);
    return result;
  }

  private void dfs(TreeNode root, List<Integer> result) {
    if (root == null) return;
    // 前序遍历顺序固定为：当前节点 -> 左子树 -> 右子树。
    result.add(root.val);
    dfs(root.left, result);
    dfs(root.right, result);
  }

  public List<Integer> preorderTraversalIterative(TreeNode root) {
    if (root == null) return new ArrayList<>();

    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
      if (cur != null) {
        // 进入当前节点时立刻访问，再继续向左展开。
        result.add(cur.val);
        stack.push(cur);
        cur = cur.left;
      } else {
        // 左侧走到底后，回退到父节点，再切到右子树。
        cur = stack.pop();
        cur = cur.right;
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
