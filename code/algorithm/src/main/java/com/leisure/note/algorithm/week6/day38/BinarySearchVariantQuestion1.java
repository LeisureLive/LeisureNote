package com.leisure.note.algorithm.week6.day38;

/**
 * Day38 二分模式题：3.3 变体二分。
 *
 * <p>这组题对应二分查找专题里的“局部有序或结构变化下的查找”模式，重点训练在非普通整体有序结构中识别可二分性质。
 *
 * <p>本文件只初始化题目骨架，不提供提示和具体实现。
 */
public class BinarySearchVariantQuestion1 {

  /**
   * 153. 寻找旋转排序数组中的最小值
   *
   * <p>题目描述：
   *
   * <p>已知长度为 {@code n} 的数组 {@code nums} 预先按照升序排列，经由 {@code 1} 到 {@code n} 次旋转后，
   * 得到输入数组。
   *
   * <p>给你一个元素值互不相同的数组 {@code nums}，它原来是一个升序排列的数组，并按上述情形进行了一次或多次旋转。
   * 请你找出并返回数组中的最小元素。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int findMin(int[] nums)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums = [3,4,5,1,2]
   * 输出：1
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums = [4,5,6,7,0,1,2]
   * 输出：0
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(log n)}</li>
   * <li>额外空间复杂度为 {@code O(1)}</li>
   * <li>数组中不存在重复元素</li>
   * </ul>
   */
  public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      // 左半段有序，右半段无序，最小值在右半段
      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        // 右半段有序，最小值在左半段且有可能就是 mid
        right = mid;
      }
    }

    // 最终 left = right = 最小值索引
    return nums[left];
  }

  /**
   * 162. 寻找峰值
   *
   * <p>题目描述：
   *
   * <p>峰值元素是指其值严格大于左右相邻值的元素。
   *
   * <p>给你一个整数数组 {@code nums}，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回任意一个峰值所在位置即可。
   *
   * <p>你可以假设 {@code nums[-1] = nums[n] = -∞}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int findPeakElement(int[] nums)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums = [1,2,3,1]
   * 输出：2
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums = [1,2,1,3,5,6,4]
   * 输出：1
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(log n)}</li>
   * <li>额外空间复杂度为 {@code O(1)}</li>
   * <li>如果存在多个峰值，返回任意一个即可</li>
   * </ul>
   */
  public int findPeakElement(int[] nums) {
    if (nums.length <= 1) {
      return 0;
    }

    int left = 0;
    int right = nums.length - 1;
    int ans = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (compare(nums, mid - 1, mid) < 0 && compare(nums, mid, mid + 1) > 0) {
        ans = mid;
        break;
      } else if (compare(nums, mid - 1, mid) > 0) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return ans;
  }

  public int[] get(int[] nums, int idx) {
    if (idx == -1 || idx == nums.length) {
      return new int[] {0, 0};
    }
    return new int[] {1, nums[idx]};
  }

  public int compare(int[] nums, int idx1, int idx2) {
    int[] num1 = get(nums, idx1);
    int[] num2 = get(nums, idx2);
    if (num1[0] != num2[0]) {
      return num1[0] > num2[0] ? 1 : -1;
    }
    if (num1[1] == num2[1]) {
      return 0;
    }
    return num1[1] > num2[1] ? 1 : -1;
  }

  /**
   * 540. 有序数组中的单一元素
   *
   * <p>题目描述：
   *
   * <p>给你一个仅由整数组成的有序数组 {@code nums}，其中除某个元素仅出现一次外，其余每个元素都恰好出现两次。
   *
   * <p>请你找出并返回只出现一次的那个元素。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int singleNonDuplicate(int[] nums)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums = [1,1,2,3,3,4,4,8,8]
   * 输出：2
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums = [3,3,7,7,10,11,11]
   * 输出：10
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(log n)}</li>
   * <li>额外空间复杂度为 {@code O(1)}</li>
   * <li>不接受使用额外哈希结构的线性解法作为主解</li>
   * </ul>
   */
  public int singleNonDuplicate(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }

    int left = 0;
    int n = nums.length;
    int right = n - 1;
    int ans = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (mid == 0) {
        if (nums[mid] != nums[mid + 1]) {
          ans = nums[mid];
          break;
        } else {
          left = mid + 1;
        }
      } else if (mid == n - 1) {
        if (nums[mid - 1] != nums[mid]) {
          ans = nums[mid];
          break;
        } else {
          right = mid - 1;
        }
      } else if (nums[mid - 1] != nums[mid] && nums[mid] != nums[mid] + 1) {
        ans = nums[mid];
        break;
      } else if (nums[mid - 1] == nums[mid]) {
        if (mid % 2 != 0) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      } else {
        if (mid % 2 == 0) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }

    return ans;
  }
}
