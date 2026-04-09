package com.leisure.note.algorithm.week3.day15;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 题目：102. 二叉树的层序遍历
 *
 * <p>题目描述：
 *
 * <p>给你二叉树的根节点 {@code root}，返回其节点值的层序遍历结果。
 *
 * <p>方法签名：
 *
 * <pre>
 * public List<List<Integer>> levelOrder(TreeNode root)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
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
 * <li>允许使用额外空间，例如队列保存当前层节点</li>
 * <li>返回结果需要按层组织，每层节点从左到右输出</li>
 * <li>空树时返回空列表，不要返回 {@code null}</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练树上的 BFS 模板</li>
 * <li>重点说清“按层处理”时队列大小的意义</li>
 * </ul>
 */
public class TreeBfsQuestion1 {

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) return new ArrayList<>();

    List<List<Integer>> result = new ArrayList<>();
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      // 先固定当前层的节点数，避免把下一层节点也一起处理掉。
      int size = queue.size();
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node == null) continue;

        list.add(node.val);
        // 按从左到右的顺序扩展下一层节点。
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }
      result.add(list);
    }

    return result;
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
