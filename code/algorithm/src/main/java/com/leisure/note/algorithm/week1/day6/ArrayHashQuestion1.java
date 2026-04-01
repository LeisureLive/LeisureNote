package com.leisure.note.algorithm.week1.day6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目：1. 两数之和
 *
 * <p>题目描述：
 *
 * <p>给定一个整数数组 {@code nums} 和一个整数目标值 {@code target}，
 * 请你在该数组中找出和为目标值 {@code target} 的那两个整数，并返回它们的数组下标。
 *
 * <p>你可以假设每种输入只会对应一个答案，并且同一个元素不能被重复使用。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int[] twoSum(int[] nums, int target)
 * </pre>
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9，所以返回 [0,1]。
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * </pre>
 *
 * <p>示例 3：
 *
 * <pre>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标时间复杂度为 {@code O(n)}</li>
 * <li>允许使用额外空间</li>
 * <li>不接受双重循环暴力枚举的 {@code O(n^2)} 解法</li>
 * <li>返回下标按 {@code 0-based} 处理</li>
 * <li>题目保证恰好存在一个有效答案</li>
 * </ul>
 *
 * <p>答题顺序要求：
 *
 * <ol>
 * <li>先复述题目要求和限制条件</li>
 * <li>先判断题型，并说明为什么这是“补数 + 哈希映射”题</li>
 * <li>先口头说明为什么可以把复杂度从 {@code O(n^2)} 降到 {@code O(n)}</li>
 * <li>再补代码实现</li>
 * <li>最后说明复杂度、边界和更新顺序</li>
 * </ol>
 *
 * <p>答题框架：
 *
 * <ol>
 * <li>核心目标不是排序，也不是双指针，而是在遍历过程中快速查“补数”是否已经出现</li>
 * <li>定义哈希表：key 是数组元素值，value 是该值对应的下标</li>
 * <li>遍历当前元素 {@code nums[i]} 时，先计算补数 {@code target - nums[i]}</li>
 * <li>如果哈希表里已经存在这个补数，说明已经找到答案，可以直接返回</li>
 * <li>如果不存在，再把当前元素和下标放入哈希表</li>
 * <li>注意顺序要“先查再放”，否则像 {@code [3,3]} 这种用例容易把同一个元素重复使用</li>
 * </ol>
 *
 * <p>注意：
 *
 * <ul>
 * <li>这是练习骨架文件，只初始化题面和方法签名，不直接给标准实现</li>
 * <li>做题时先口头讲清“为什么想到哈希表”，再开始写代码</li>
 * </ul>
 */
public class ArrayHashQuestion1 {

  public int[] twoSum(int[] nums, int target) {
    if (nums == null || nums.length <= 1) {
      return new int[] {-1, -1};
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int expect = target - nums[i];
      if (map.containsKey(expect)) {
        return new int[] {map.get(expect), i};
      }
      map.put(nums[i], i);
    }

    return new int[] {-1, -1};
  }


  public static void main(String[] args) {
    ArrayHashQuestion1 arrayHashQuestion1 = new ArrayHashQuestion1();
    int[] nums = new int[] {2, 7, 11, 15};
    System.out.println(Arrays.toString(arrayHashQuestion1.twoSum(nums, 9)));
  }

}
