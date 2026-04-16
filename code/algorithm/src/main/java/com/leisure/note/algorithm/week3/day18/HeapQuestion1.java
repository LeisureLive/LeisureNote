package com.leisure.note.algorithm.week3.day18;

import java.util.Arrays;

/**
 * 题目：215. 数组中的第 K 个最大元素
 *
 * <p>题目描述：
 *
 * <p>给定整数数组 {@code nums} 和整数 {@code k}，请返回数组中第 {@code k} 个最大的元素。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int findKthLargest(int[] nums, int k)
 * </pre>
 *
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums = [3,2,1,5,6,4], k = 2
 * 输出：5
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：nums = [3,2,3,1,2,4,5,5,6], k = 4
 * 输出：4
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标思路是维护大小为 {@code k} 的小顶堆，复杂度尽量做到 {@code O(n log k)}</li>
 * <li>返回的是第 {@code k} 个最大的元素，不是第 {@code k} 个不同的元素</li>
 * <li>允许使用额外空间，例如优先队列</li>
 * <li>不要先整体排序再取第 {@code k} 个作为唯一思路</li>
 * </ul>
 *
 * <p>答题重点：
 *
 * <ul>
 * <li>训练堆的 TopK 模板</li>
 * <li>重点说清为什么维护大小为 k 的小顶堆即可</li>
 * </ul>
 */
public class HeapQuestion1 {

  public int findKthLargest(int[] nums, int k) {
    // 这题是 TopK 模板：维护一个大小固定为 k 的小顶堆，堆顶就是当前第 k 大。
    // 易错点：
    // 1. 这里要维护的是“小顶堆”，不是大顶堆；这样堆顶才能表示当前 TopK 里最小的那个。
    // 2. 参数校验不能漏掉 k == 0，我这次一开始就把 k < 0 写成了边界，后面会导致空堆访问 res[0]。
    if (nums == null || nums.length == 0) {
      throw new IllegalArgumentException("nums must not be null or empty");
    }
    if (k <= 0 || k > nums.length) {
      throw new IllegalArgumentException("k must be between 1 and nums.length");
    }
    if (nums.length == 1) {
      return nums[0];
    }

    int[] res = Arrays.copyOfRange(nums, 0, k);
    // 先用前 k 个元素建堆，表示“当前看到的前 k 大候选集”。
    for (int i = (res.length) / 2 - 1; i >= 0; i--) {
      siftDown(res, i);
    }

    // 只有比堆顶更大的元素，才有资格进入 TopK。
    for (int i = k; i < nums.length; i++) {
      if (nums[i] > res[0]) {
        res[0] = nums[i];
        siftDown(res, 0);
      }
    }

    // 小顶堆第一个元素即为 nums 数组第 k 大的元素
    return res[0];
  }


  private void siftDown(int[] res, int i) {
    int cur = i;
    while (cur <= (res.length) / 2 - 1) {
      int left = 2 * cur + 1;
      int right = 2 * cur + 2;
      int minIndex;
      if (left < res.length && right < res.length) {
        minIndex = res[left] <= res[right] ? left : right;
      } else if (left < res.length) {
        minIndex = left;
      } else {
        break;
      }

      // 小顶堆下沉：当前节点比更小的孩子大，就继续交换。
      if (res[cur] > res[minIndex]) {
        swap(res, minIndex, cur);
        cur = minIndex;
      } else {
        break;
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    HeapQuestion1 heapQuestion1 = new HeapQuestion1();
    int[] nums = new int[] {1, 2, 3, 4, 5, 9, 6, 7};
    int k = 2;
    System.out.println(heapQuestion1.findKthLargest(nums, k));
  }

}
