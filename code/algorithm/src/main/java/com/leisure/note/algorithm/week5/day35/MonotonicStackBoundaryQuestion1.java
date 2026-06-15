package com.leisure.note.algorithm.week5.day35;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Day35 单调栈模式题：区间边界扩展。
 *
 * <p>这组题对应 `04_stack_queue_monotonic_stack.md` 里的 `3.4 单调栈求区间边界`。
 * 关键不是“找某个点右边更大 / 更小是谁”，而是“当前元素作为最小值或最大值时，向左右最远能扩到哪里”：
 *
 * <ul>
 * <li>`84`：一维边界扩展基础题。</li>
 * <li>`85`：把二维问题压成多次一维边界扩展的进阶题。</li>
 * </ul>
 *
 * <p>本文件中新增的 `85` 只保留题面和方法骨架，不写具体实现。
 */
public class MonotonicStackBoundaryQuestion1 {

  /**
   * 84. 柱状图中最大的矩形
   *
   * <p>题目描述：
   *
   * <p>给定 {@code n} 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1。
   * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int largestRectangleArea(int[] heights)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：heights = [2,1,5,6,2,3]
   * 输出：10
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：heights = [2,4]
   * 输出：4
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>不接受枚举左右边界的 {@code O(n^2)} 写法</li>
   * <li>重点说清为什么这里找的是“左右第一个更小元素”</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>单调栈边界题的主战模板。</li>
   * <li>它训练的是“以当前位置为最低高度时，矩形最大宽度如何由边界反推”。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先把每个柱子都视作“当前矩形的最低高度”。</li>
   * <li>再分别求它左边第一个更小元素和右边第一个更小元素。</li>
   * <li>宽度确定后，套用 {@code heights[i] * (right[i] - left[i] - 1)} 计算面积。</li>
   * <li>最后检查相等高度时为什么要用 {@code >=} 弹栈，避免边界重复和宽度不稳。</li>
   * </ol>
   */
  public int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }

    // left[i] 表示第 i 根柱子左侧第一个严格更小元素下标；不存在时记为 -1。
    int[] left = new int[heights.length];
    // right[i] 表示第 i 根柱子右侧第一个严格更小元素下标；不存在时先记为 n。
    int[] right = new int[heights.length];
    Arrays.fill(right, heights.length);

    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();
    for (int i = 0; i < heights.length; i++) {
      // 维护递增栈：弹掉所有大于等于当前高度的柱子，栈顶剩下的才可能是左侧第一个更小元素。
      while (!stack1.isEmpty() && heights[stack1.peek()] >= heights[i]) {
        stack1.pop();
      }
      left[i] = stack1.isEmpty() ? -1 : stack1.peek();
      stack1.push(i);

      // 当前柱子一旦更小，就成为被弹出柱子的“右侧第一个更小元素”。
      while (!stack2.isEmpty() && heights[stack2.peek()] >= heights[i]) {
        int index = stack2.pop();
        right[index] = i;
      }
      stack2.push(i);
    }

    int largestArea = 0;
    for (int i = 0; i < heights.length; i++) {
      // 以 heights[i] 为最低高度时，矩形宽度就是开区间 (left[i], right[i]) 的长度。
      largestArea = Math.max(largestArea, (right[i] - left[i] - 1) * heights[i]);
    }

    return largestArea;
  }

  /**
   * 85. 最大矩形
   *
   * <p>题目描述：
   *
   * <p>给定一个仅包含 {@code 0} 和 {@code 1}、大小为 {@code rows x cols} 的二维二进制矩阵
   * {@code matrix}，找出只包含 {@code 1} 的最大矩形，并返回其面积。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int maximalRectangle(char[][] matrix)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：
   * matrix = [
   *   ["1","0","1","0","0"],
   *   ["1","0","1","1","1"],
   *   ["1","1","1","1","1"],
   *   ["1","0","0","1","0"]
   * ]
   * 输出：6
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：matrix = [["0"]]
   * 输出：0
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度尽量做到 {@code O(rows * cols)}</li>
   * <li>重点说明如何把二维问题转化成“每一行对应一张柱状图”</li>
   * <li>本地先只保留题面和方法骨架，不直接写实现</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>单调栈边界题的二维验收题。</li>
   * <li>核心不是另背一套新模板，而是能否把 `84` 迁移到二维矩阵场景。</li>
   * </ul>
   *
   * <p>答题顺序建议：
   *
   * <ol>
   * <li>先把每一行看成“以当前行为底”的柱状图高度数组。</li>
   * <li>每处理完一行，就复用一次 `84` 的边界扩展逻辑。</li>
   * <li>全局维护最大面积，而不是只看最后一行。</li>
   * <li>最后检查空矩阵、全 0、单行单列这些边界。</li>
   * </ol>
   */
  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    //  计算每个位置，其左边的连续 1 的个数
    int[][] left = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == '0') {
          left[i][j] = 0;
        } else if (j - 1 >= 0) {
          left[i][j] = left[i][j - 1] + 1;
        } else {
          left[i][j] = 1;
        }
      }
    }

    // 对于 left 每一列，退化为求柱状图的最大面积
    int[] top = new int[left.length];
    int[] bottom = new int[left.length];
    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();
    int maxArea = 0;
    for (int j = 0; j < left[0].length; j++) {
      Arrays.fill(top, -1);
      Arrays.fill(bottom, left.length);
      stack1.clear();
      stack2.clear();
      for (int i = 0; i < left.length; i++) {
        // 对每个元素，找其下方小于他的第一个元素
        while (!stack1.isEmpty() && left[stack1.peek()][j] > left[i][j]) {
          int index = stack1.pop();
          bottom[index] = i;
        }
        stack1.push(i);

        // 对于每个元素，找其上方小于他的第一个元素
        while (!stack2.isEmpty() && left[stack2.peek()][j] >= left[i][j]) {
          stack2.pop();
        }
        if (!stack2.isEmpty()) {
          top[i] = stack2.peek();
        }
        stack2.push(i);
      }

      for (int i = 0; i < left.length; i++) {
        if (left[i][j] != 0) {
          maxArea = Math.max(left[i][j] * (bottom[i] - top[i] - 1), maxArea);
        }
      }
    }

    return maxArea;
  }

  public static void main(String[] args) {
    MonotonicStackBoundaryQuestion1 monotonicStackBoundaryQuestion1 = new MonotonicStackBoundaryQuestion1();
    System.out.println(monotonicStackBoundaryQuestion1.maximalRectangle(
      new char[][] {{'1', '1'}}
    ));
  }

}
