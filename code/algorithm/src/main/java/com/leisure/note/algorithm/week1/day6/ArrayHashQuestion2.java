package com.leisure.note.algorithm.week1.day6;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：219. 存在重复元素 II
 *
 * <p>题目描述：
 *
 * <p>给你一个整数数组 {@code nums} 和一个整数 {@code k}，
 * 判断数组中是否存在两个不同下标 {@code i} 和 {@code j}，
 * 满足 {@code nums[i] == nums[j]} 且 {@code abs(i - j) <= k}。
 *
 * <p>如果存在，返回 {@code true}；否则返回 {@code false}。
 *
 * <p>方法签名：
 *
 * <pre>
 * public boolean containsNearbyDuplicate(int[] nums, int k)
 * </pre>
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 解释：下标 0 和 3 对应的元素都为 1，且距离为 3。
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * </pre>
 *
 * <p>示例 3：
 *
 * <pre>
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标时间复杂度为 {@code O(n)}</li>
 * <li>允许使用额外空间</li>
 * <li>不接受双重循环暴力枚举的 {@code O(n^2)} 解法</li>
 * <li>返回结果是布尔值，不是重复元素本身</li>
 * <li>注意区分“存在重复值”和“重复值之间距离不超过 k”这两个条件</li>
 * </ul>
 *
 * <p>答题顺序要求：
 *
 * <ol>
 * <li>先复述题目要求和限制条件</li>
 * <li>先判断题型，并说明为什么这是“数组 + 哈希 + 固定范围约束”题</li>
 * <li>先口头说明为什么可以只关注当前位置前面最近的 {@code k} 个元素</li>
 * <li>再补代码实现</li>
 * <li>最后说明复杂度、边界和窗口维护方式</li>
 * </ol>
 *
 * <p>答题框架：
 *
 * <ol>
 * <li>题目的关键不是“有没有重复元素”，而是“重复元素之间距离不能超过 {@code k}”</li>
 * <li>因此可以维护一个“最近 {@code k} 个元素”的哈希窗口，而不必保留所有历史元素</li>
 * <li>遍历到 {@code nums[i]} 时，先判断当前值是否已经出现在窗口里</li>
 * <li>如果已经存在，说明找到了满足条件的一对下标，可以直接返回 {@code true}</li>
 * <li>如果不存在，就把当前元素加入窗口</li>
 * <li>当窗口大小超过 {@code k} 时，移除距离当前位置超过 {@code k} 的旧元素</li>
 * <li>这样整体只需线性遍历一次，哈希结构负责把存在性判断优化到平均 {@code O(1)}</li>
 * </ol>
 *
 * <p>注意：
 *
 * <ul>
 * <li>这是练习骨架文件，只初始化题面和方法签名，不直接给标准实现</li>
 * <li>这题适合训练“窗口内存在性判断”，和 `1. 两数之和` 的补数查找不是同一类哈希模式</li>
 * </ul>
 */
public class ArrayHashQuestion2 {

  /**
   * 本题在专题中的定位：
   *
   * <ul>
   * <li>哈希专题：窗口内存在性判断 / 最近位置</li>
   * <li>特征：不仅要判断重复值，还要判断重复值之间的距离约束</li>
   * </ul>
   *
   * <p>思路：
   *
   * <ol>
   * <li>用哈希表记录某个值最近一次出现的位置。</li>
   * <li>遍历到当前位置时，如果当前值之前出现过，且距离不超过 {@code k}，就直接返回 {@code true}。</li>
   * <li>否则更新这个值的最近位置。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>比显式维护一个窗口集合更简洁。</li>
   * <li>时间复杂度 {@code O(n)}，适合训练“哈希表里存最近位置”的思路。</li>
   * </ul>
   *
   * <p>缺点：
   *
   * <ul>
   * <li>如果只会背代码，容易忽略题目的核心是“距离约束”，不是单纯判断重复元素。</li>
   * <li>当前写法记录的是最近位置，而不是显式窗口内容，不适合所有窗口类变体。</li>
   * </ul>
   *
   * <p>变体应对：
   *
   * <ul>
   * <li>如果题目更强调“最近 {@code k} 个元素里是否存在某值”，也可以用 `HashSet` 显式维护大小为 {@code k} 的滑动窗口。</li>
   * <li>如果改成求最大 / 最小距离，就要把最近位置和历史最优值一起维护。</li>
   * </ul>
   */
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    if (nums == null || nums.length <= 1) {
      return false;
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
        return true;
      }
      map.put(nums[i], i);
    }
    return false;
  }

  public static void main(String[] args) {
    ArrayHashQuestion2 arrayHashQuestion2 = new ArrayHashQuestion2();
    int[] nums = new int[]{1,0,1,1};
    System.out.println(arrayHashQuestion2.containsNearbyDuplicate(nums, 1));
  }
}
