package com.leisure.note.algorithm.week1.day7;

/**
 * 题目：560. 和为 K 的子数组（Day7 复刷题）
 *
 * <p>题目描述：
 *
 * <p>给定一个整数数组 {@code nums} 和一个整数 {@code k}，请你返回和为 {@code k} 的连续子数组的个数。
 *
 * <p>方法签名：
 *
 * <pre>
 * public int subarraySum(int[] nums, int k)
 * </pre>
 *
 * <p>示例 1：
 *
 * <pre>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * </pre>
 *
 * <p>示例 2：
 *
 * <pre>
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * </pre>
 *
 * <p>额外要求：
 *
 * <ul>
 * <li>目标时间复杂度为 {@code O(n)}</li>
 * <li>允许使用额外空间</li>
 * <li>不接受暴力枚举所有子数组的 {@code O(n^2)} 解法</li>
 * <li>数组元素可能包含负数、零和正数</li>
 * <li>返回的是满足条件的连续子数组个数，不是任意一个区间</li>
 * </ul>
 *
 * <p>这道题为什么放在 Day7：
 *
 * <ul>
 * <li>Day7 的目标是“复盘数组 / 哈希专题，重做错题或薄弱题 1 题”</li>
 * <li>这题是前缀和 + 哈希的基础模板题，值得刻意复刷一次</li>
 * <li>重点不是再看结论，而是检查自己能不能脱稿讲清：
 *   <ul>
 *   <li>为什么普通滑动窗口不适用</li>
 *   <li>为什么查的是 {@code prefixSum - k}</li>
 *   <li>为什么这里 map 存的是“出现次数”</li>
 *   </ul>
 * </li>
 * </ul>
 *
 * <p>答题顺序要求：
 *
 * <ol>
 * <li>先复述题目要求和限制条件</li>
 * <li>先判断题型，并说明为什么这是“前缀和 + 哈希计数”题</li>
 * <li>先口头说明为什么普通滑动窗口不适合</li>
 * <li>再补代码实现</li>
 * <li>最后说明复杂度、边界和初始化含义</li>
 * </ol>
 *
 * <p>答题框架：
 *
 * <ol>
 * <li>连续子数组求和，本质上可以转成两个前缀和之差</li>
 * <li>如果当前位置前缀和为 {@code prefixSum}，那么只要历史上出现过 {@code prefixSum - k}，就说明存在若干个区间和为 {@code k}</li>
 * <li>因此哈希表要记录“某个前缀和出现过几次”</li>
 * <li>初始化时放入 {@code 0 -> 1}，表示空前缀出现过一次</li>
 * <li>遍历时先统计答案，再更新当前前缀和出现次数</li>
 * </ol>
 *
 * <p>注意：
 *
 * <ul>
 * <li>这是 Day7 复刷骨架文件，不直接给标准实现</li>
 * <li>这次重点不是第一次做出，而是看你是否真正吃透模板</li>
 * </ul>
 */
public class PrefixSumHashReviewQuestion1 {

  public int subarraySum(int[] nums, int k) {
    throw new UnsupportedOperationException("TODO: implement subarraySum");
  }
}
