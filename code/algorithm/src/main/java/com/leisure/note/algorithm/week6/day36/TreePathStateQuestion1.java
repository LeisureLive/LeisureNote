package com.leisure.note.algorithm.week6.day36;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Day36 树模式题：3.4 路径问题与递归路径状态维护。
 *
 * <p>这组题对应 `06_trees_dfs_bfs.md` 里的 `3.4 路径问题：沿递归路径维护状态`。
 * 这里按“存在性判断、收集全部路径、路径数值累积”三个方向补题：
 *
 * <ul>
 * <li>`112`：根到叶路径存在性判断。</li>
 * <li>`113`：收集所有满足条件的根到叶路径。</li>
 * <li>`129`：把路径当作数字做累积。</li>
 * </ul>
 *
 * <p>这组三题都属于“DFS 沿递归路径传递状态”，但状态形态并不一样：
 *
 * <ul>
 * <li>`112` 维护的是“剩余目标值”，属于值状态。</li>
 * <li>`113` 维护的是“当前路径列表”，属于共享可变状态，需要回溯恢复现场。</li>
 * <li>`129` 维护的是“当前路径形成的数字”，也属于值状态，不需要显式回溯。</li>
 * </ul>
 */
public class TreePathStateQuestion1 {

  /**
   * 112. 路径总和
   *
   * <p>题目描述：
   *
   * <p>给你二叉树的根节点 {@code root} 和一个表示目标和的整数 {@code targetSum}。
   * 判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和 {@code targetSum}。
   *
   * <p>叶子节点是指没有子节点的节点。
   *
   * <p>方法签名：
   *
   * <pre>
   * public boolean hasPathSum(TreeNode root, int targetSum)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
   * 输出：true
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：root = [1,2,3], targetSum = 5
   * 输出：false
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>必须是从根节点到叶子节点的完整路径</li>
   * <li>空树返回 {@code false}</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>树上路径状态题的入门题。</li>
   * <li>重点不是“把所有路径都求出来”，而是学会把 {@code targetSum} 沿递归一路扣减。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先确认必须是“根到叶”的完整路径，不是任意向下路径。</li>
   * <li>再把问题转成：走到当前节点时，还剩多少目标值没有匹配。</li>
   * <li>到叶子节点时，直接检查“剩余目标值是否恰好等于当前节点值”。</li>
   * <li>最后检查空树、单节点树这些边界。</li>
   * </ol>
   */
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }

    if (root.left == null && root.right == null) {
      return targetSum == root.val;
    }

    return hasPathSum(root.left, targetSum - root.val)
      || hasPathSum(root.right, targetSum - root.val);
  }


  /**
   * 113. 路径总和 II
   *
   * <p>题目描述：
   *
   * <p>给你二叉树的根节点 {@code root} 和一个整数目标和 {@code targetSum}，
   * 找出所有从根节点到叶子节点路径总和等于给定目标和的路径。
   *
   * <p>叶子节点是指没有子节点的节点。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<List<Integer>> pathSum(TreeNode root, int targetSum)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
   * 输出：[[5,4,11,2],[5,8,4,5]]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：root = [1,2,3], targetSum = 5
   * 输出：[]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度按遍历整棵树考虑</li>
   * <li>返回所有满足条件的根到叶路径</li>
   * <li>结果中的每条路径都应按从根到叶的顺序保存</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>树上路径状态题的标准回溯题。</li>
   * <li>重点训练“路径内容需要保留下来时，为什么必须恢复递归现场”。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先确认输出是“所有路径”，不是只判断是否存在。</li>
   * <li>再明确需要同时维护两类状态：当前路径 {@code path} 和剩余目标值。</li>
   * <li>到叶子节点时，如果剩余值恰好为 0，就把当前路径拷贝进结果集。</li>
   * <li>最后检查为什么 {@code path} 必须回溯删除尾节点，否则兄弟分支会被污染。</li>
   * </ol>
   *
   * <p>易错点：
   *
   * <ul>
   * <li>{@code path} 是共享可变对象，不是值拷贝；进入节点时添加，离开节点时必须删除。</li>
   * <li>加入结果集时必须 {@code new ArrayList<>(path)}，不能直接把原始 {@code path} 放进去。</li>
   * </ul>
   */

  private List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return Collections.emptyList();
    }

    // path 记录“当前这条递归链路”上的节点值，后续左右子树会共享它，所以必须配合回溯使用。
    List<Integer> path = new ArrayList<>();
    backTrack(root, targetSum, path);
    return res;
  }

  private void backTrack(TreeNode root, int targetSum, List<Integer> path) {
    if (root == null) {
      return;
    }

    int target = targetSum - root.val;
    // 进入当前节点：把它加入当前路径。
    path.add(root.val);

    if (root.left == null && root.right == null) {
      if (target == 0) {
        // 结果集里要放路径快照，而不是复用同一个 path 引用。
        res.add(new ArrayList<>(path));
      }
    } else {
      if (root.left != null) {
        backTrack(root.left, target, path);
      }
      if (root.right != null) {
        backTrack(root.right, target, path);
      }
    }

    // 离开当前节点：恢复现场。
    // 这是本题最容易漏掉的地方；如果不删除，兄弟分支会错误继承当前节点路径。
    path.remove(path.size() - 1);
  }

  /**
   * 129. 求根节点到叶节点数字之和
   *
   * <p>题目描述：
   *
   * <p>给你一个二叉树的根节点 {@code root}，树中每个节点都存放有一个 {@code 0} 到 {@code 9} 之间的数字。
   *
   * <p>每条从根节点到叶节点的路径都代表一个数字：
   * 例如，从根节点到叶节点的路径 {@code 1 -> 2 -> 3} 表示数字 {@code 123}。
   *
   * <p>计算从根节点到叶节点生成的所有数字之和。
   *
   * <p>叶子节点是指没有子节点的节点。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int sumNumbers(TreeNode root)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：root = [1,2,3]
   * 输出：25
   * 解释：从根到叶的路径 1->2 表示数字 12，路径 1->3 表示数字 13，因此总和为 25。
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：root = [4,9,0,5,1]
   * 输出：1026
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>节点值保证在 {@code 0} 到 {@code 9} 之间</li>
   * <li>空树时返回 {@code 0}</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>树上路径状态题里“状态可压缩”的代表题。</li>
   * <li>重点训练：当路径最终只关心一个数值结果时，没必要真的把整条路径存下来。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先把根到当前节点的路径理解成一个十进制数字前缀。</li>
   * <li>再定义递归状态：{@code prevSum} 表示“到父节点为止形成的数字”。</li>
   * <li>到当前节点时更新成 {@code prevSum * 10 + root.val}。</li>
   * <li>到叶子时直接返回这个完整数字；否则返回左右子树结果之和。</li>
   * </ol>
   *
   * <p>易错点：
   *
   * <ul>
   * <li>不要收集整条 {@code path} 再到叶子节点重新扫描，这会把复杂度从 {@code O(n)} 拉高。</li>
   * <li>这里维护的是整数值状态，不是共享路径容器，所以不需要像 `113` 那样显式回溯。</li>
   * </ul>
   */
  public int sumNumbers(TreeNode root) {
    return dfs(root, 0);
  }

  private int dfs(TreeNode root, int prevSum) {
    if (root == null) {
      return 0;
    }

    // prevSum 表示“到父节点为止形成的数字”；
    // 当前节点到来后，直接在十进制尾部拼上 root.val。
    int sum = prevSum * 10 + root.val;
    if (root.left == null && root.right == null) {
      // 到叶子时，这条路径对应的完整数字已经构造完成。
      return sum;
    }
    // 这里传递的是值状态，每个递归分支拿到的是自己的 sum，
    // 不共享可变容器，因此不需要显式回溯删除。
    return dfs(root.left, sum) + dfs(root.right, sum);
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
