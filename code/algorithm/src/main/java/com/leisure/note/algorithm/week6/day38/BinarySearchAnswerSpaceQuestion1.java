package com.leisure.note.algorithm.week6.day38;

/**
 * Day38 二分模式题：3.4 答案空间二分。
 *
 * <p>这组题对应二分查找专题里的“在值域上二分可行解”模式，重点训练先定答案范围，再判断候选答案是否可行。
 *
 * <p>本文件只初始化题目骨架，不提供提示和具体实现。
 */
public class BinarySearchAnswerSpaceQuestion1 {

  /**
   * 1011. 在 D 天内送达包裹的能力
   *
   * <p>题目描述：
   *
   * <p>传送带上的包裹必须在 {@code days} 天内从一个港口运送到另一个港口。
   *
   * <p>传送带上的第 {@code i} 个包裹的重量为 {@code weights[i]}。每天都会按传送带上包裹的顺序往船上装载包裹，
   * 装载的总重量不能超过船的最大运载能力。
   *
   * <p>返回能在 {@code days} 天内将传送带上的所有包裹送达的船的最低运载能力。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int shipWithinDays(int[] weights, int days)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：weights = [1,2,3,4,5,6,7,8,9,10], days = 5
   * 输出：15
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：weights = [3,2,2,4,1,4], days = 3
   * 输出：6
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度优先考虑 {@code O(n log S)}，其中 {@code S} 为答案值域大小</li>
   * <li>额外空间复杂度为 {@code O(1)}</li>
   * <li>必须保持包裹原有顺序，不能重排</li>
   * </ul>
   */
  public int shipWithinDays(int[] weights, int days) {
    int maxWeight = 0;
    int sum = 0;
    for (int i = 0; i < weights.length; i++) {
      maxWeight = Math.max(maxWeight, weights[i]);
      sum += weights[i];
    }

    if (days >= weights.length) {
      return maxWeight;
    }

    if (days == 1) {
      return sum;
    }

    int min = maxWeight;
    int max = sum;
    int ans = max;
    while (min <= max) {
      int mid = min + (max - min) / 2;
      if (calDays(weights, mid) <= days) {
        ans = mid;
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }

    return ans;
  }

  private int calDays(int[] weights, int capacity) {
    int currentCapacity = 0;
    int days = 1;
    for (int i = 0; i < weights.length; i++) {
      if (capacity - currentCapacity >= weights[i]) {
        currentCapacity += weights[i];
      } else {
        days++;
        currentCapacity = weights[i];
      }
    }
    return days;
  }

  /**
   * 410. 分割数组的最大值
   *
   * <p>题目描述：
   *
   * <p>给定一个非负整数数组 {@code nums} 和一个整数 {@code k}，你需要将这个数组分成 {@code k} 个非空的连续子数组。
   *
   * <p>设计一个算法使得这 {@code k} 个子数组各自和的最大值最小。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int splitArray(int[] nums, int k)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums = [7,2,5,10,8], k = 2
   * 输出：18
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums = [1,2,3,4,5], k = 2
   * 输出：9
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度优先考虑 {@code O(n log S)}</li>
   * <li>额外空间复杂度为 {@code O(1)}</li>
   * <li>数组必须按原顺序切分，子数组需要连续</li>
   * </ul>
   */
  public int splitArray(int[] nums, int k) {
    int maxValue = 0;
    int sum = 0;
    for (int num : nums) {
      maxValue = Math.max(num, maxValue);
      sum += num;
    }

    if (k == 1) {
      return sum;
    }

    if (k == nums.length) {
      return maxValue;
    }

    int min = maxValue;
    int max = sum;
    int ans = max;
    while (min <= max) {
      int mid = min + (max - min) / 2;
      int arraySize = calArrayNum(nums, mid);
      if (arraySize <= k) {
        ans = mid;
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }

    return ans;
  }

  private int calArrayNum(int[] nums, int maxSum) {
    int size = 1;
    int currentSum = 0;
    for (int num : nums) {
      if (maxSum - currentSum >= num) {
        currentSum += num;
      } else {
        size++;
        currentSum = num;
      }
    }
    return size;
  }


  /**
   * 1482. 制作 m 束花所需的最少天数
   *
   * <p>题目描述：
   *
   * <p>给你一个整数数组 {@code bloomDay}，以及两个整数 {@code m} 和 {@code k}。
   *
   * <p>现需要制作 {@code m} 束花。制作花束时，需要使用花园中相邻的 {@code k} 朵花。
   *
   * <p>花园中第 {@code i} 朵花会在 {@code bloomDay[i]} 时盛开，且恰好可以用于一束花中的一个位置。
   *
   * <p>返回从花园中摘 {@code m} 束花需要等待的最少天数。如果不能摘到 {@code m} 束花则返回 {@code -1}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int minDays(int[] bloomDay, int m, int k)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：bloomDay = [1,10,3,10,2], m = 3, k = 1
   * 输出：3
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：bloomDay = [1,10,3,10,2], m = 3, k = 2
   * 输出：-1
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度优先考虑 {@code O(n log S)}</li>
   * <li>额外空间复杂度为 {@code O(1)}</li>
   * <li>每束花必须使用相邻的 {@code k} 朵花，且每朵花只能使用一次</li>
   * </ul>
   */
  public int minDays(int[] bloomDay, int m, int k) {
    int total = m * k;
    if (bloomDay.length < total) {
      return -1;
    }

    int left = bloomDay[0];
    int right = -1;
    for (int i = 0; i < bloomDay.length; i++) {
      left = Math.min(left, bloomDay[i]);
      right = Math.max(right, bloomDay[i]);
    }

    int ans = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int flowerNum = calFlowerNum(bloomDay, mid, k);
      if (flowerNum >= m) {
        ans = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return ans;
  }

  private int calFlowerNum(int[] bloomDay, int day, int size) {
    int flowerNum = 0;
    int needSize = size;
    for (int i = 0; i < bloomDay.length; i++) {
      if (bloomDay[i] > day) {
        needSize = size;
      } else {
        needSize--;
        if (needSize == 0) {
          flowerNum++;
          needSize = size;
        }
      }
    }
    return flowerNum;
  }

  public static void main(String[] args) {
    BinarySearchAnswerSpaceQuestion1 question1 = new BinarySearchAnswerSpaceQuestion1();
    System.out.println(question1.splitArray(new int[] {5, 5, 5, 5}, 3));
  }
}
