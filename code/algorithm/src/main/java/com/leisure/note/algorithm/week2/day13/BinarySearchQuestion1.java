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

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>二分专题：变体二分</li>
   * <li>核心信号：整体不是完全有序，但每次二分后一定有一半区间仍然有序</li>
   * <li>关键判断是“哪一半有序”以及“目标值是否落在这半边”</li>
   * </ul>
   *
   * <p>思路：
   *
   * <ol>
   * <li>每次取中点 {@code mid}，如果直接命中目标值就返回。</li>
   * <li>先判断左半边 {@code [left, mid]} 是否有序：如果 {@code nums[left] <= nums[mid]}，说明左半边有序。</li>
   * <li>若左半边有序，再判断目标值是否落在 {@code [nums[left], nums[mid])} 范围内；如果是，就继续去左边，否则去右边。</li>
   * <li>如果左半边无序，那右半边一定有序；同理判断目标值是否落在右半边有序区间里。</li>
   * </ol>
   *
   * <p>易错点：
   *
   * <ul>
   * <li>右半边有序时，区间判断要写成 {@code nums[mid] < target && target <= nums[right]}，方向很容易写反。</li>
   * <li>这题默认数组元素互不相同，所以用 {@code nums[left] <= nums[mid]} 判断左半边有序是成立的。</li>
   * <li>二分边界仍然要用标准模板维护：命中即返回，否则只保留可能包含答案的一侧。</li>
   * </ul>
   */
  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[left] <= nums[mid]) {
        if (nums[left] <= target && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[mid] < target && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    BinarySearchQuestion1 binarySearchQuestion1 = new BinarySearchQuestion1();
    int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
    System.out.println(binarySearchQuestion1.search(nums1, 0));
  }
}
