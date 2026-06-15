package com.leisure.note.algorithm.week6.day36;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 * Day36 树模式题：3.1 BFS 层序遍历和按层处理。
 *
 * <p>这组题对应 `06_trees_dfs_bfs.md` 里的 `3.1 BFS：层序遍历和按层处理`。
 * 题目选择尽量避开台账里已完成的 `102`，改用更能覆盖“按层聚合、按层变形、最短层数判断”的代表题：
 *
 * <ul>
 * <li>`199`：按层取视角结果。</li>
 * <li>`111`：按层寻找最早满足条件的答案。</li>
 * <li>`103`：按层遍历 + 输出顺序变形。</li>
 * </ul>
 *
 * <p>本文件只初始化题目骨架，不直接给标准实现。
 */
public class TreeBfsLayerQuestion1 {

  /**
   * 199. 二叉树的右视图
   *
   * <p>题目描述：
   *
   * <p>给定一个二叉树的根节点 {@code root}，想象自己站在它的右侧，按照从顶部到底部的顺序，
   * 返回从右侧所能看到的节点值。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<Integer> rightSideView(TreeNode root)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：root = [1,2,3,null,5,null,4]
   * 输出：[1,3,4]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：root = [1,null,3]
   * 输出：[1,3]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用额外队列空间</li>
   * <li>空树时返回空列表，不要返回 {@code null}</li>
   * </ul>
   */
  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    List<Integer> ans = new ArrayList<>();
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 1; i <= size; i++) {
        TreeNode node = queue.poll();
        if (i == size) {
          ans.add(node.val);
        }
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
    }

    return ans;
  }

  /**
   * 111. 二叉树的最小深度
   *
   * <p>题目描述：
   *
   * <p>给定一个二叉树，找出其最小深度。
   *
   * <p>最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
   *
   * <p>说明：叶子节点是指没有子节点的节点。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int minDepth(TreeNode root)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：root = [3,9,20,null,null,15,7]
   * 输出：2
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：root = [2,null,3,null,4,null,5,null,6]
   * 输出：5
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用额外队列空间</li>
   * <li>需要按节点数量返回深度</li>
   * </ul>
   */
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }

    if (root.right == null) {
      return minDepth(root.left) + 1;
    } else if (root.left == null) {
      return minDepth(root.right) + 1;
    } else {
      int left = minDepth(root.left);
      int right = minDepth(root.right);
      return Math.min(left, right) + 1;
    }
  }

  public int minDepth2(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int level = 1;
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 1; i <= size; i++) {
        TreeNode node = queue.poll();
        if (node.left == null && node.right == null) {
          return level;
        }

        if (node.left != null) {
          queue.offer(node.left);
        }

        if (node.right != null) {
          queue.offer(node.right);
        }
      }

      level++;
    }

    return level;
  }

  /**
   * 103. 二叉树的锯齿形层序遍历
   *
   * <p>题目描述：
   *
   * <p>给你二叉树的根节点 {@code root}，返回其节点值的锯齿形层序遍历。
   *
   * <p>即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<List<Integer>> zigzagLevelOrder(TreeNode root)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：root = [3,9,20,null,null,15,7]
   * 输出：[[3],[20,9],[15,7]]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：root = [1]
   * 输出：[[1]]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用额外队列空间</li>
   * <li>返回结果需要按层组织，且每层输出方向交替变化</li>
   * </ul>
   */
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }

    Deque<TreeNode> stack1 = new ArrayDeque<>();
    Deque<TreeNode> stack2 = new ArrayDeque<>();
    stack1.push(root);
    List<List<Integer>> ans = new ArrayList<>();
    while (!stack1.isEmpty() || !stack2.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      if (!stack1.isEmpty()) {
        while (!stack1.isEmpty()) {
          TreeNode node = stack1.pop();
          list.add(node.val);
          if (node.left != null) {
            stack2.push(node.left);
          }

          if (node.right != null) {
            stack2.push(node.right);
          }
        }
      } else {
        while (!stack2.isEmpty()) {
          TreeNode node = stack2.pop();
          list.add(node.val);
          if (node.right != null) {
            stack1.push(node.right);
          }
          if (node.left != null) {
            stack1.push(node.left);
          }
        }
      }
      ans.add(list);
    }

    return ans;
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
