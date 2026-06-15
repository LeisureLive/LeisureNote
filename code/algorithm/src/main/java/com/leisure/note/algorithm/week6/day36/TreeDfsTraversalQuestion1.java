package com.leisure.note.algorithm.week6.day36;

/**
 * Day36 树模式题：3.2 DFS 递归遍历和子树问题拆解。
 *
 * <p>这组题对应 `06_trees_dfs_bfs.md` 里的 `3.2 DFS：递归遍历和子树问题拆解`。
 * 台账里 `104`、`94`、`226` 已完成，因此这里补三道更适合继续训练“子树递归定义”和“结构改造 / 判断”的题：
 *
 * <ul>
 * <li>`100`：两棵树结构和值同步判断。</li>
 * <li>`101`：镜像对子树递归判断。</li>
 * <li>`617`：按节点位置递归合并两棵树。</li>
 * </ul>
 *
 * <p>本文件只初始化题目骨架，不直接给标准实现。
 */
public class TreeDfsTraversalQuestion1 {

  /**
   * 100. 相同的树
   *
   * <p>题目描述：
   *
   * <p>给你两棵二叉树的根节点 {@code p} 和 {@code q}，编写一个函数来检验这两棵树是否相同。
   *
   * <p>如果两棵树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
   *
   * <p>方法签名：
   *
   * <pre>
   * public boolean isSameTree(TreeNode p, TreeNode q)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：p = [1,2,3], q = [1,2,3]
   * 输出：true
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：p = [1,2], q = [1,null,2]
   * 输出：false
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用递归或显式栈</li>
   * <li>需要同时比较结构和节点值</li>
   * </ul>
   */
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }

    if (p == null || q == null) {
      return false;
    }

    if (p.val != q.val) {
      return false;
    }

    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

  /**
   * 101. 对称二叉树
   *
   * <p>题目描述：
   *
   * <p>给你一个二叉树的根节点 {@code root}，检查它是否轴对称。
   *
   * <p>方法签名：
   *
   * <pre>
   * public boolean isSymmetric(TreeNode root)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：root = [1,2,2,3,4,4,3]
   * 输出：true
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：root = [1,2,2,null,3,null,3]
   * 输出：false
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用递归或队列</li>
   * <li>空树视为对称</li>
   * </ul>
   */
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }

    return isSymmetric(root.left, root.right);
  }

  private boolean isSymmetric(TreeNode tree1, TreeNode tree2) {
    if (tree1 == null && tree2 == null) {
      return true;
    }
    if (tree1 == null || tree2 == null) {
      return false;
    }

    if (tree1.val != tree2.val) {
      return false;
    }

    return isSymmetric(tree1.left, tree2.right) && isSymmetric(tree1.right, tree2.left);
  }

  /**
   * 617. 合并二叉树
   *
   * <p>题目描述：
   *
   * <p>给你两棵二叉树：{@code root1} 和 {@code root2}。
   *
   * <p>想象一下，当你将其中一棵覆盖到另一棵之上时，两个二叉树中的一些节点会重叠，
   * 而另一些不会。你需要将这两棵树合并成一棵新二叉树。合并的规则是：
   * 如果两个节点重叠，那么将这两个节点的值相加作为新节点的值；否则，不为 {@code null}
   * 的节点将直接作为新二叉树的节点。
   *
   * <p>方法签名：
   *
   * <pre>
   * public TreeNode mergeTrees(TreeNode root1, TreeNode root2)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
   * 输出：[3,4,5,5,4,null,7]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：root1 = [1], root2 = [1,2]
   * 输出：[2,2]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许返回新树或在原树上修改，按方法签名返回根节点</li>
   * <li>空树与非空树合并时，结果应保留非空节点</li>
   * </ul>
   */
  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return null;
    }

    if (root1 == null) {
      return root2;
    }

    if (root2 == null) {
      return root1;
    }
    root1.val = root1.val + root2.val;
    root1.left = mergeTrees(root1.left, root2.left);
    root1.right = mergeTrees(root1.right, root2.right);
    return root1;
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
