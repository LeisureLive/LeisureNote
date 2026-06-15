package com.leisure.note.algorithm.week6.day36;

import java.util.ArrayList;
import java.util.List;

/**
 * Day36 树模式题：3.5 BST 有序性、剪枝和定位。
 *
 * <p>这组题对应 `06_trees_dfs_bfs.md` 里的 `3.5 BST：利用有序性剪枝和定位`。
 * 题目选择覆盖 BST 最核心的四类动作：校验、顺序访问、定向查找、基于大小关系找公共祖先。
 *
 * <ul>
 * <li>`98`：验证 BST 全局有序性。</li>
 * <li>`230`：利用中序有序性找第 k 小。</li>
 * <li>`700`：基于大小关系定向搜索。</li>
 * <li>`235`：基于大小关系剪枝找最近公共祖先。</li>
 * </ul>
 *
 * <p>本文件只初始化题目骨架，不直接给标准实现。
 */
public class BstOrderedPropertyQuestion1 {

  /**
   * 98. 验证二叉搜索树
   *
   * <p>题目描述：
   *
   * <p>给你一个二叉树的根节点 {@code root}，判断其是否是一个有效的二叉搜索树。
   *
   * <p>有效二叉搜索树定义如下：
   *
   * <ul>
   * <li>节点的左子树只包含严格小于当前节点的数</li>
   * <li>节点的右子树只包含严格大于当前节点的数</li>
   * <li>所有左子树和右子树自身也必须是二叉搜索树</li>
   * </ul>
   *
   * <p>方法签名：
   *
   * <pre>
   * public boolean isValidBST(TreeNode root)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：root = [2,1,3]
   * 输出：true
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：root = [5,1,4,null,null,3,6]
   * 输出：false
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>需要校验整棵子树范围约束，而不只是比较父子节点</li>
   * <li>节点值范围可能触及整型边界，注意边界处理</li>
   * </ul>
   */
  public boolean isValidBST(TreeNode root) {
    return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  public boolean validBST(TreeNode node, long minValue, long maxValue) {
    if (node == null) {
      return false;
    }

    if (node.val <= minValue || node.val >= maxValue) {
      return false;
    }

    boolean leftValid = true;
    if (node.left != null) {
      leftValid = validBST(node.left, minValue, node.val);
    }
    boolean rightValid = true;
    if (node.right != null) {
      rightValid = validBST(node.right, node.val, maxValue);
    }

    return leftValid && rightValid;
  }

  /**
   * 230. 二叉搜索树中第 K 小的元素
   *
   * <p>题目描述：
   *
   * <p>给定一个二叉搜索树的根节点 {@code root}，和一个整数 {@code k}，请你设计一个算法查找其中第
   * {@code k} 小的元素。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int kthSmallest(TreeNode root, int k)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：root = [3,1,4,null,2], k = 1
   * 输出：1
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：root = [5,3,6,2,4,null,null,1], k = 3
   * 输出：3
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>树保证是有效二叉搜索树</li>
   * <li>{@code 1 <= k <=} 树中的节点数</li>
   * <li>目标时间复杂度按遍历需要的节点数考虑</li>
   * </ul>
   */
  public int kthSmallest(TreeNode root, int k) {
    List<Integer> list = new ArrayList<>();
    dfs(root, list);

    return list.get(k - 1);
  }

  private void dfs(TreeNode node, List<Integer> list) {
    if (node == null) {
      return;
    }

    dfs(node.left, list);
    list.add(node.val);
    dfs(node.right, list);
  }

  /**
   * 700. 二叉搜索树中的搜索
   *
   * <p>题目描述：
   *
   * <p>给定二叉搜索树（BST）的根节点 {@code root} 和一个整数值 {@code val}。
   *
   * <p>你需要在 BST 中找到节点值等于 {@code val} 的节点。返回以该节点为根的子树。
   * 如果节点不存在，则返回 {@code null}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public TreeNode searchBST(TreeNode root, int val)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：root = [4,2,7,1,3], val = 2
   * 输出：[2,1,3]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：root = [4,2,7,1,3], val = 5
   * 输出：[]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>树保证满足 BST 性质</li>
   * <li>目标时间复杂度按树高考虑</li>
   * <li>如果不存在目标值，返回 {@code null}</li>
   * </ul>
   */
  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }

    if (root.val == val) {
      return root;
    } else if (root.val > val) {
      return searchBST(root.left, val);
    } else {
      return searchBST(root.right, val);
    }
  }

  /**
   * 235. 二叉搜索树的最近公共祖先
   *
   * <p>题目描述：
   *
   * <p>给定一个二叉搜索树，找到该树中两个指定节点的最近公共祖先。
   *
   * <p>百度百科中最近公共祖先的定义为：
   * “对于有根树 T 的两个节点 {@code p}、{@code q}，最近公共祖先表示为一个节点 {@code x}，
   * 满足 {@code x} 是 {@code p}、{@code q} 的祖先且 {@code x} 的深度尽可能大
   * （一个节点也可以是它自己的祖先）。”
   *
   * <p>方法签名：
   *
   * <pre>
   * public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
   * 输出：6
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
   * 输出：2
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>树保证是二叉搜索树</li>
   * <li>{@code p} 和 {@code q} 均存在于树中</li>
   * <li>目标时间复杂度按树高考虑</li>
   * </ul>
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val == q.val) {
      return p;
    }

    if (root.val >= p.val && root.val <= q.val) {
      return root;
    } else if (root.val >= q.val && root.val <= p.val) {
      return root;
    } else if (root.val >= p.val && root.val >= q.val) {
      return lowestCommonAncestor(root.left, p, q);
    } else {
      return lowestCommonAncestor(root.right, p, q);
    }
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
