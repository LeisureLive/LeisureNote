package com.leisure.note.algorithm.week6.day38;

/**
 * Day38 二分模式题：3.1 基础二分。
 *
 * <p>这组题对应二分查找专题里的“基础命中二分”模式，重点训练在有序区间内直接定位目标，
 * 或把二维结构映射成一维有序区间后再查找。
 *
 * <p>本文件只初始化题目骨架，不提供提示和具体实现。
 */
public class BinarySearchBasicQuestion1 {

  /**
   * 35. 搜索插入位置
   *
   * <p>题目描述：
   *
   * <p>给定一个按照非递减顺序排列的整数数组 {@code nums} 和一个整数 {@code target}，
   * 请返回目标值在数组中的下标；如果目标值不存在，请返回它应该插入的位置。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int searchInsert(int[] nums, int target)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums = [1,3,5,6], target = 5
   * 输出：2
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums = [1,3,5,6], target = 2
   * 输出：1
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(log n)}</li>
   * <li>额外空间复杂度为 {@code O(1)}</li>
   * <li>数组可能为空，但题目语义仍需返回合法插入位置</li>
   * </ul>
   */
  public int searchInsert(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int left = 0;
    int right = nums.length - 1;
    int ans = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        // 考虑到有多个目标值的情况，找左边界
        ans = mid;
        right = mid - 1;
      }
    }

    // 未找到目标值时，left 指向的是比目标值大的第一个值，插入此位置
    return ans == -1 ? left : ans;
  }

  /**
   * 74. 搜索二维矩阵
   *
   * <p>题目描述：
   *
   * <p>给定一个 {@code m x n} 的整数矩阵 {@code matrix}，满足：
   *
   * <ul>
   * <li>每行从左到右按非递减顺序排列。</li>
   * <li>每行的第一个元素都大于前一行的最后一个元素。</li>
   * </ul>
   *
   * <p>再给定一个整数 {@code target}，请判断 {@code target} 是否存在于矩阵中。
   *
   * <p>方法签名：
   *
   * <pre>
   * public boolean searchMatrix(int[][] matrix, int target)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
   * 输出：true
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
   * 输出：false
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(log(m * n))}</li>
   * <li>额外空间复杂度为 {@code O(1)}</li>
   * <li>需要把二维矩阵视作一个连续有序搜索空间来处理</li>
   * </ul>
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    int m = matrix.length;
    int n = matrix[0].length;
    int left = 0;
    int right = m * n - 1;
    while (left <= right) {
      int midValue = left + (right - left) / 2;
      int x = midValue / n;
      int y = midValue % n;
      if (matrix[x][y] == target) {
        return true;
      } else if (matrix[x][y] > target) {
        right = midValue - 1;
      } else {
        left = midValue + 1;
      }
    }

    return false;
  }
}
