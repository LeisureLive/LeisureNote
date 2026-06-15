package com.leisure.note.algorithm.week6.day38;

/**
 * Day38 二分模式题：3.2 边界二分。
 *
 * <p>这组题对应二分查找专题里的“第一个 / 最后一个满足条件的位置”模式，重点训练命中后继续收缩边界。
 *
 * <p>本文件只初始化题目骨架，不提供提示和具体实现。
 */
public class BinarySearchBoundaryQuestion1 {

  /**
   * 278. 第一个错误的版本
   *
   * <p>题目描述：
   *
   * <p>你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
   * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错误的。
   *
   * <p>假设你有 {@code n} 个版本 {@code [1, 2, ..., n]}，你想找出导致之后所有版本出错的第一个错误版本。
   *
   * <p>你可以通过调用 {@code isBadVersion(version)} 接口来判断版本号 {@code version} 是否在单元测试中出错。
   * 实现函数来查找第一个错误的版本。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int firstBadVersion(int n)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：n = 5, bad = 4
   * 输出：4
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：n = 1, bad = 1
   * 输出：1
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(log n)}</li>
   * <li>额外空间复杂度为 {@code O(1)}</li>
   * <li>尽量减少对 {@code isBadVersion} 的调用次数</li>
   * </ul>
   */
  public int firstBadVersion(int n) {
    if (n <= 1) {
      return n;
    }
    int left = 1;
    int right = n;
    int ans = n + 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (isBadVersion(mid)) {
        ans = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return ans;
  }

  /**
   * 744. 寻找比目标字母大的最小字母
   *
   * <p>题目描述：
   *
   * <p>给你一个按非递减顺序排序的字符数组 {@code letters} 和一个字符 {@code target}。
   * 返回 {@code letters} 中大于 {@code target} 的最小字符。
   * 如果不存在这样的字符，则返回 {@code letters} 的第一个字符。
   *
   * <p>方法签名：
   *
   * <pre>
   * public char nextGreatestLetter(char[] letters, char target)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：letters = ["c","f","j"], target = "a"
   * 输出："c"
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：letters = ["c","f","j"], target = "j"
   * 输出："c"
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(log n)}</li>
   * <li>额外空间复杂度为 {@code O(1)}</li>
   * <li>结果具有循环语义，必要时需要回到数组开头</li>
   * </ul>
   */
  public char nextGreatestLetter(char[] letters, char target) {
    int left = 0;
    int right = letters.length - 1;
    int ans = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (letters[mid] > target) {
        ans = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return ans == -1 ? letters[0] : letters[ans];
  }

  /**
   * 275. H 指数 II
   *
   * <p>题目描述：
   *
   * <p>给你一个整数数组 {@code citations}，其中 {@code citations[i]} 表示研究者的第 {@code i} 篇论文被引用的次数，
   * 并且 {@code citations} 已经按照升序排列。
   * <p>
   * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （n 篇论文中）至少 有 h 篇论文分别被引用了至少 h 次。
   *
   * <p>计算并返回该研究者的 h 指数。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int hIndex(int[] citations)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：citations = [0,1,3,5,6]
   * 输出：3
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：citations = [1,2,100]
   * 输出：2
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(log n)}</li>
   * <li>额外空间复杂度为 {@code O(1)}</li>
   * <li>输入数组已经有序，不接受退化成线性扫描的主解法</li>
   * </ul>
   */
  public int hIndex(int[] citations) {
    if (citations == null || citations.length == 0) {
      return 0;
    }

    int left = 0;
    int right = citations.length - 1;
    int ans = 0;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int size = citations.length - mid;
      if (citations[mid] >= size) {
        ans = size;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return ans;
  }

  protected boolean isBadVersion(int version) {
    throw new UnsupportedOperationException("Not implemented yet");
  }
}
