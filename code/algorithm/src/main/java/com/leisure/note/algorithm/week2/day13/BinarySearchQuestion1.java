package com.leisure.note.algorithm.week2.day13;

/**
 * 题目：33. 搜索旋转排序数组
 *
 * <p>题目描述：
 *
 * <p>整数数组 {@code nums} 按升序排列，数组中的值互不相同。传递给函数之前，{@code nums} 在预先未知的某个下标上进行了旋转。
 * 给你旋转后的数组 {@code nums} 和一个整数 {@code target}，如果 {@code nums} 中存在这个目标值，则返回它的下标，否则返回 {@code -1}。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int search(int[] nums, int target)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标时间复杂度为 {@code O(log n)}</li>
 * <li>数组中的值互不相同</li>
 * <li>不接受先线性找旋转点、再线性查找目标值的 {@code O(n)} 解法</li>
 * <li>返回的是目标值下标；如果不存在，返回 {@code -1}</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练变体二分</li>
 * <li>重点说清每次二分时哪一半一定有序，以及目标值落在哪一半</li>
 * </ul>
 */
public class BinarySearchQuestion1 {

  public int search(int[] nums, int target) {
    throw new UnsupportedOperationException("TODO: implement search");
  }
}
