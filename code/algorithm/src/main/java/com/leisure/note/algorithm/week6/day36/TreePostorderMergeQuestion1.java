package com.leisure.note.algorithm.week6.day36;

import java.util.HashMap;
import java.util.Map;

/**
 * Day36 树模式题：3.3 后序 DFS 信息归并。
 *
 * <p>这组题对应 `06_trees_dfs_bfs.md` 里的 `3.3 后序 DFS：信息归并题`。
 * 台账里 `543`、`236` 已完成，因此这里补三道最常见、区分度也最高的后序归并题：
 *
 * <ul>
 * <li>`110`：子树高度与平衡状态同时判断。</li>
 * <li>`124`：单边贡献与全局路径和分离。</li>
 * <li>`337`：子树返回多状态结果供父节点选择。</li>
 * </ul>
 *
 * <p>本文件只初始化题目骨架，不直接给标准实现。
 */
public class TreePostorderMergeQuestion1 {

  /**
   * 110. 平衡二叉树
   *
   * <p>题目描述：
   *
   * <p>给定一个二叉树，判断它是否是高度平衡的二叉树。
   *
   * <p>本题中，一棵高度平衡二叉树定义为：
   * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
   *
   * <p>方法签名：
   *
   * <pre>
   * public boolean isBalanced(TreeNode root)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：root = [3,9,20,null,null,15,7]
   * 输出：true
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：root = [1,2,2,3,3,null,null,4,4]
   * 输出：false
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>不接受对每个节点重复计算子树高度的 {@code O(n^2)} 写法</li>
   * <li>空树视为平衡二叉树</li>
   * </ul>
   */
  public boolean isBalanced(TreeNode root) {
    return height(root) >= 0;
  }

  private int height(TreeNode node) {
    if (node == null) {
      return 0;
    }
    if (node.left == null && node.right == null) {
      return 1;
    }

    int left = height(node.left);
    int right = height(node.right);
    if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
      return -1;
    }

    return Math.max(left, right) + 1;
  }


  private int maxPathSum = Integer.MIN_VALUE;

  /**
   * 124. 二叉树中的最大路径和
   *
   * <p>题目描述：
   *
   * <p>二叉树中的路径被定义为一条从树中任意节点出发，沿父子节点连接，达到任意节点的序列。
   * 同一个节点在一条路径序列中至多出现一次。该路径至少包含一个节点，且不一定经过根节点。
   *
   * <p>路径和是路径中各节点值的总和。
   *
   * <p>给你一个二叉树的根节点 {@code root}，返回其最大路径和。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int maxPathSum(TreeNode root)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：root = [1,2,3]
   * 输出：6
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：root = [-10,9,20,null,null,15,7]
   * 输出：42
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>节点值可能为负数</li>
   * <li>路径不一定经过根节点，也不要求到叶子节点结束</li>
   * </ul>
   */
  public int maxPathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return root.val;
    }

    maxPath(root);
    return maxPathSum;
  }

  // 计算以 root 节点为起点的路径和最大值
  private int maxPath(TreeNode root) {
    if (root == null) {
      return 0;
    }

    // 只有当左右子树的路径和大于 0 时，才考虑将其纳入路径
    int left = Math.max(maxPath(root.left), 0);
    int right = Math.max(maxPath(root.right), 0);
    maxPathSum = Math.max(maxPathSum, root.val + left + right);
    return Math.max(left, right) + root.val;
  }

  /**
   * 337. 打家劫舍 III
   *
   * <p>题目描述：
   *
   * <p>在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
   * 这个地区只有一个入口，我们称之为 {@code root}。
   *
   * <p>除了 {@code root} 之外，每栋房子有且只有一个“父”房子与之相连。
   * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
   * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
   *
   * <p>给定二叉树的 {@code root}，返回在不触动警报的情况下，小偷能够盗取的最高金额。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int rob(TreeNode root)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：root = [3,2,3,null,3,null,1]
   * 输出：7
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：root = [3,4,5,1,3,null,1]
   * 输出：9
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度尽量做到 {@code O(n)}</li>
   * <li>不允许选择直接相连的父子节点</li>
   * <li>允许使用递归和额外状态空间</li>
   * </ul>
   */

  // 指定 node 选中，能获取的最大金额
  Map<TreeNode, Integer> fMap = new HashMap<>();
  // 指定 node 不选中， 能获取的最大金额
  Map<TreeNode, Integer> gMap = new HashMap<>();

  public int rob(TreeNode root) {
    dfs(root);
    return Math.max(fMap.getOrDefault(root, 0), gMap.getOrDefault(root, 0));
  }

  private void dfs(TreeNode node) {
    if (node == null) {
      return;
    }

    dfs(node.left);
    dfs(node.right);

    // 选中当前节点，最大金额 = 不选中左节点 + 不选中右节点 + 当前节点值
    fMap.put(node, gMap.getOrDefault(node.left, 0) + gMap.getOrDefault(node.right, 0) + node.val);
    // 不选中当前节点, 最大金额 = max(选中左节点, 不选中左节点) + max(选中有节点, ,不选中有节点)
    gMap.put(node,
      Math.max(fMap.getOrDefault(node.left, 0), gMap.getOrDefault(node.left, 0))
        + Math.max(fMap.getOrDefault(node.right, 0), gMap.getOrDefault(node.right, 0)));
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
