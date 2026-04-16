package com.leisure.note.algorithm.week1.day5;

import java.util.Arrays;

/**
 * 题目：34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * <p>题目描述：
 *
 * <p>给定一个按非递减顺序排列的整数数组 {@code nums}，和一个目标值 {@code target}，
 * 请你找出 {@code target} 在数组中的起始位置和结束位置。
 * 如果数组中不存在 {@code target}，返回 {@code [-1, -1]}。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int[] searchRange(int[] nums, int target)
 * </pre>
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * </pre>
 *
 * <p>示例 3：
 *
 * <pre>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标时间复杂度必须达到 {@code O(log n)}</li>
 * <li>额外空间复杂度尽量为 {@code O(1)}</li>
 * <li>不接受先找到一个命中位置后再线性向两边扩散的解法</li>
 * <li>返回下标按 {@code 0-based} 处理</li>
 * </ul>
 *
 * <p>答题顺序要求：
 *
 * <ol>
 * <li>先复述题目要求和限制条件</li>
 * <li>说明为什么这是二分类题，而不是线性扫描题</li>
 * <li>先口头说明为什么需要做两次二分：一次找左边界，一次找右边界</li>
 * <li>再补代码实现</li>
 * <li>最后说明复杂度、边界和易错点</li>
 * </ol>
 *
 * <p>答题框架：
 *
 * <ol>
 * <li>先说明数组有序，且目标是找边界位置，所以核心是边界二分</li>
 * <li>左边界二分：命中 target 后继续向左收缩，尝试找第一个位置</li>
 * <li>右边界二分：命中 target 后继续向右收缩，尝试找最后一个位置</li>
 * <li>如果左边界不存在，直接返回 {@code [-1, -1]}</li>
 * <li>最后返回左右边界组成的结果数组</li>
 * </ol>
 *
 * <p>注意：
 *
 * <ul>
 * <li>这是练习骨架文件，当前只初始化方法框架，不直接给完整实现</li>
 * <li>做题时先口头说明边界收缩规则，再补代码</li>
 * </ul>
 */
public class BinarySearchQuestion1 {

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>数组专题：二分查找</li>
   * <li>特征：有序数组 + 查找边界位置，而不是单次命中即可结束</li>
   * </ul>
   *
   * <p>思路：
   *
   * <ol>
   * <li>分别做两次二分，一次找左边界，一次找右边界。</li>
   * <li>命中目标值后，左边界继续向左收缩，右边界继续向右收缩。</li>
   * <li>最后把两次二分的结果组合起来。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>时间复杂度满足 {@code O(log n)} 的要求。</li>
   * <li>很适合训练“边界二分”和“命中后不立刻返回”的意识。</li>
   * </ul>
   *
   * <p>缺点：
   *
   * <ul>
   * <li>边界和区间定义容易写乱。</li>
   * <li>如果没有统一二分模板，左右边界很容易一边对一边错。</li>
   * </ul>
   *
   * <p>变体应对：
   *
   * <ul>
   * <li>如果只求第一个大于等于目标的位置，本质上是 lower bound 问题。</li>
   * <li>如果数组无序，二分查找就不成立，必须先排序或改用别的结构。</li>
   * </ul>
   */
  public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return new int[] {-1, -1};
    }
    int leftBoundary = findLeftBorder(nums, target);
    if (leftBoundary == -1) {
      return new int[] {-1, -1};
    }

    int rightBoundary = findRightBorder(nums, target);
    return new int[] {leftBoundary, rightBoundary};
  }

  private int findLeftBorder(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int answer = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        answer = mid;
        right = mid - 1;
      }
    }
    return answer;
  }

  private int findRightBorder(int[] nums, int target) {
     int left = 0;
    int right = nums.length - 1;
    int answer = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        answer = mid;
        left = mid + 1;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    BinarySearchQuestion1 question1 = new BinarySearchQuestion1();
    int[] nums = new int[] {5, 7, 7, 8, 8, 10};
    System.out.println(Arrays.toString(question1.searchRange(nums, 8)));
  }
}
