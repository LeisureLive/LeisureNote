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

  private int maxLength = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    // 这题的最终答案是全局最大直径，不是 dfs(root) 的返回值。
    // 易错点：
    // 1. 直径按“边数”算，不是按节点数算。
    // 2. 直径不一定经过根节点，所以必须在遍历过程中维护全局最优值。
    // 3. 如果对象被复用，多次调用前要先重置全局状态。
    maxLength = 0;
    dfs(root);
    return maxLength;
  }

  private int dfs(TreeNode node) {
    if (node == null) {
      // 空节点不能继续向下延伸，返回 0。
      return 0;
    }

    // 后序 DFS：先拿左右子树“返回给父节点的单边长度”。
    int left = dfs(node.left);
    int right = dfs(node.right);

    // 当前节点处的直径 = 左边最长单边长度 + 右边最长单边长度。
    // 易错点：这里是“更新全局答案”，不能把 left + right 直接返回给父节点。
    maxLength = Math.max(maxLength, left + right);

    // 返回给父节点的只能是一条单边路径长度。
    // 易错点：父节点不可能同时沿左右两边继续往上接，所以这里只能取 max(left, right) + 1。
    return Math.max(left, right) + 1;
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
