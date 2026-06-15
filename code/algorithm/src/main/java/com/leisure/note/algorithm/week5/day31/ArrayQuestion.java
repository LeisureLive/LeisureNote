package com.leisure.note.algorithm.week5.day31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Day31 数组题复习。
 *
 * <p>这一轮是系统性第二次复习，所以把同一类模式的代表题放到一个文件里，方便连续回顾。
 *
 * <p>当前文件聚焦数组专题 `3.1 遍历与模拟`，重点不是复杂数据结构，而是：
 *
 * <ul>
 * <li>能把题目先翻译成一组机械动作。</li>
 * <li>能说清访问顺序、边界更新和停止条件。</li>
 * <li>能控制重复访问、漏访问和越界问题。</li>
 * </ul>
 *
 * <p>本文件当前收口的代表题：
 *
 * <ul>
 * <li>{@code 88. 合并两个有序数组}</li>
 * <li>{@code 54. 螺旋矩阵}</li>
 * <li>{@code 59. 螺旋矩阵 II}</li>
 * <li>{@code 2326. 螺旋矩阵 IV}</li>
 * </ul>
 *
 * @author jie.he
 * @version 1.0.0
 * @since 2026/04/26
 */
public class ArrayQuestion {

  /**
   * 88. 合并两个有序数组
   *
   * <p>题目描述：
   *
   * <p>给你两个按非递减顺序排列的整数数组 {@code nums1} 和 {@code nums2}，
   * 另有两个整数 {@code m} 和 {@code n}，分别表示 {@code nums1} 和 {@code nums2} 中的元素数目。
   *
   * <p>请你将 {@code nums2} 合并到 {@code nums1} 中，使合并后的数组同样按非递减顺序排列。
   *
   * <p>注意，最终合并后的数组不应由函数返回，而是存储在数组 {@code nums1} 中。
   * 为了应对这种情况，{@code nums1} 的初始长度为 {@code m + n}，其中前 {@code m} 个元素表示应合并的元素，
   * 后 {@code n} 个元素为 {@code 0}，应忽略。{@code nums2} 的长度为 {@code n}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public void merge(int[] nums1, int m, int[] nums2, int n)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
   * 输出：[1,2,2,3,5,6]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
   * 输出：[1]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(m + n)}</li>
   * <li>优先考虑原地合并，不额外新建完整结果数组</li>
   * <li>{@code nums1.length == m + n}</li>
   * </ul>
   */
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    if (nums1 == null || nums1.length == 0) {
      return;
    }

    if (nums2 == null || nums2.length == 0) {
      return;
    }

    int cur = nums1.length - 1;
    int cur1 = m - 1;
    int cur2 = n - 1;
    while (cur2 >= 0) {
      if (cur1 < 0) {
        nums1[cur--] = nums2[cur2--];
      } else if (nums1[cur1] > nums2[cur2]) {
        nums1[cur--] = nums1[cur1--];
      } else {
        nums1[cur--] = nums2[cur2--];
      }
    }

  }

  /**
   * 54. 螺旋矩阵
   *
   * <p>题目描述：
   *
   * <p>给你一个 {@code m x n} 矩阵 {@code matrix}，请按照顺时针螺旋顺序，返回矩阵中的所有元素。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<Integer> spiralOrder(int[][] matrix)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
   * 输出：[1,2,3,6,9,8,7,4,5]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
   * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(m * n)}</li>
   * <li>需要保证每个元素恰好访问一次</li>
   * <li>重点关注边界更新和停止条件，不要重复访问中心区域</li>
   * </ul>
   */
  public List<Integer> spiralOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return Collections.emptyList();
    }

    int[][] visited = new int[matrix.length][matrix[0].length];
    List<Integer> result = new ArrayList<>();
    int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int row = 0;
    int col = 0;
    int curDirIndex = 0;
    while (result.size() < matrix.length * matrix[0].length) {
      result.add(matrix[row][col]);
      visited[row][col] = 1;
      int[] dir = dirs[curDirIndex];
      if (row + dir[0] >= 0 && row + dir[0] < matrix.length
        && col + dir[1] >= 0 && col + dir[1] < matrix[0].length
        && visited[row + dir[0]][col + dir[1]] == 0) {
        row += dir[0];
        col += dir[1];
      } else {
        curDirIndex = (curDirIndex + 1) % 4;
        dir = dirs[curDirIndex];
        row += dir[0];
        col += dir[1];
      }
    }

    return result;
  }

  /**
   * 59. 螺旋矩阵 II
   *
   * <p>题目描述：
   *
   * <p>给你一个正整数 {@code n}，生成一个包含 {@code 1} 到 {@code n^2} 所有元素，
   * 且元素按顺时针顺序螺旋排列的 {@code n x n} 正方形矩阵 {@code matrix}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int[][] generateMatrix(int n)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：n = 3
   * 输出：[[1,2,3],[8,9,4],[7,6,5]]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：n = 1
   * 输出：[[1]]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n^2)}</li>
   * <li>需要原地填充结果矩阵</li>
   * <li>重点训练“按方向填充 + 每轮收缩边界”的模拟能力</li>
   * </ul>
   */
  public int[][] generateMatrix(int n) {
    if (n <= 0) {
      return new int[0][0];
    }

    int[][] res = new int[n][n];
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int row = 0;
    int col = 0;
    int num = 1;
    int curDirIndex = 0;
    while (num <= n * n) {
      res[row][col] = num;
      num++;
      int[] dir = dirs[curDirIndex % 4];
      // 注意这里的判断条件，除了不越界外，还需要下一个元素是没有生成过的
      if (row + dir[0] >= 0 && row + dir[0] < n
        && col + dir[1] >= 0 && col + dir[1] < n
        && res[row + dir[0]][col + dir[1]] == 0) {
        row += dir[0];
        col += dir[1];
      } else {
        curDirIndex = (curDirIndex + 1) % 4;
        dir = dirs[curDirIndex % 4];
        row += dir[0];
        col += dir[1];
      }
    }
    return res;
  }

  /**
   * 2326. 螺旋矩阵 IV
   *
   * <p>题目描述：
   *
   * <p>给你两个整数 {@code m} 和 {@code n}，以及一个链表的头节点 {@code head}。
   *
   * <p>请你生成一个大小为 {@code m x n} 的矩阵，并按照顺时针螺旋顺序，
   * 用链表中的节点值依次填充矩阵。
   *
   * <p>如果链表中的节点数目小于 {@code m * n}，则将矩阵中剩余没有填到的位置全部设为 {@code -1}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int[][] spiralMatrix(int m, int n, ListNode head)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
   * 输出：[[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：m = 1, n = 4, head = [0,1,2]
   * 输出：[[0,1,2,-1]]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(m * n)}</li>
   * <li>允许使用额外空间辅助判断访问状态</li>
   * <li>需要保证每个位置最多填充一次，转向时不能越界也不能重复访问</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>数组专题：遍历与模拟</li>
   * <li>特征：答案矩阵是固定大小，填充顺序由“方向数组 + 是否需要转向”共同决定</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先确认矩阵初始化值是 {@code -1}，因为链表可能提前结束。</li>
   * <li>再确认当前题的核心不是链表操作，而是“螺旋顺序填充 + 转向判断”。</li>
   * <li>先说清什么时候继续直走、什么时候顺时针切换方向，再写循环。</li>
   * <li>最后检查单行、单列、链表长度不足、刚好填满这几类边界。</li>
   * </ol>
   */
  public int[][] spiralMatrix(int m, int n, ListNode head) {
    if (m <= 0 || n <= 0) {
      return new int[0][0];
    }

    int[][] ans = new int[m][n];
    for (int row = 0; row < ans.length; row++) {
      // 先全部填成 -1，链表提前结束时剩余位置天然符合题意。
      Arrays.fill(ans[row], -1);
    }

    if (head == null) {
      return ans;
    }

    boolean[][] visited = new boolean[m][n];
    int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    ListNode cur = head;
    int dirIndex = 0;
    int row = 0;
    int col = 0;
    while (cur != null) {
      ans[row][col] = cur.val;
      visited[row][col] = true;
      cur = cur.next;

      int nextRow = row + dirs[dirIndex][0];
      int nextCol = col + dirs[dirIndex][1];
      // 下一个位置越界，或者已经访问过，就需要顺时针转向。
      if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) {
        dirIndex = (dirIndex + 1) % 4;
      }

      row += dirs[dirIndex][0];
      col += dirs[dirIndex][1];
    }

    return ans;
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }



  public static void main(String[] args) {
    ArrayQuestion arrayQuestion = new ArrayQuestion();
//    int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
//    int[] nums2 = new int[] {2, 5, 6};
//    arrayQuestion.merge(nums1, 3, nums2, 3);
//    System.out.println(Arrays.toString(nums1));

    int[][] matrix = new int[][] {{1}, {2}, {3}, {4}};
    System.out.println(arrayQuestion.spiralOrder(matrix));

//    int[][] ans = arrayQuestion.generateMatrix(3);
//    for (int i = 0; i < ans.length; i++) {
//      System.out.println(Arrays.toString(ans[i]));
//    }

  }
}
