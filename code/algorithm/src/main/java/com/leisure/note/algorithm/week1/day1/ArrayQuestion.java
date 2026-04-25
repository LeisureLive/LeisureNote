package com.leisure.note.algorithm.week1.day1;

import java.util.HashSet;
import java.util.Set;

/**
 * Week1 Day1 已完成题。
 *
 * <p>这里放的是：
 *
 * <ul>
 * <li>`238. 除自身以外数组的乘积`</li>
 * <li>`128. 最长连续序列`</li>
 * </ul>
 *
 * <p>这两个方法都已经补齐题号、题目描述、方法签名、样例和额外要求，便于按统一算法规则复盘。
 */
public class ArrayQuestion {

  /**
   * 题目：238. 除自身以外数组的乘积
   *
   * <p>题目描述：
   *
   * <p>给定一个整数数组 {@code arr}，返回一个数组 {@code answer}，其中 {@code answer[i]}
   * 等于 {@code arr} 中除 {@code arr[i]} 之外其余各元素的乘积。
   *
   * <p>题目数据保证数组中任意位置左侧元素和右侧元素乘积都在 32 位整数范围内。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int[] productExceptSelf(int[] arr)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：arr = [1,2,3,4]
   * 输出：[24,12,8,6]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：arr = [-1,1,0,-3,3]
   * 输出：[0,0,9,0,0]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>不能使用除法</li>
   * <li>允许使用额外空间；如果继续优化，可压缩到结果数组加一个滚动后缀变量</li>
   * </ul>
   *
   * <p>专题定位：
   *
   * <ul>
   * <li>数组专题：前后缀分解</li>
   * <li>特征：每个位置的答案同时依赖左边信息和右边信息</li>
   * </ul>
   *
   * <p>思路：
   *
   * <ol>
   * <li>先分别计算每个位置左边的乘积和右边的乘积。</li>
   * <li>当前下标 {@code i} 的答案，就是左侧乘积乘以右侧乘积。</li>
   * <li>这样可以避免对每个位置都重新扫描左右两侧。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>时间复杂度 {@code O(n)}，不需要使用除法。</li>
   * <li>很适合训练“答案依赖左右两侧信息”的前后缀分解思维。</li>
   * </ul>
   *
   * <p>缺点：
   *
   * <ul>
   * <li>当前实现使用了两个辅助数组，额外空间是 {@code O(n)}。</li>
   * <li>还可以继续优化成结果数组加一个滚动后缀变量的写法。</li>
   * </ul>
   *
   * <p>变体应对：
   *
   * <ul>
   * <li>如果题目要求更低额外空间，通常把前缀结果先写入答案数组，再逆序补后缀。</li>
   * <li>如果题目允许除法且没有 0，可以有更简单写法，但面试里一般不优先讲。</li>
   * </ul>
   */
  public int[] productExceptSelf(int[] arr) {
    // arr1[i] 表示 arr[0..i] 的乘积（包含 arr[i]）
    // arr2[j] 表示 arr[j..n-1] 的乘积（包含 arr[j]）
    int[] arr1 = new int[arr.length];
    int[] arr2 = new int[arr.length];

    arr1[0] = arr[0];
    arr2[arr.length - 1] = arr[arr.length - 1];
    for (int i = 1; i < arr.length; i++) {
      arr1[i] = arr1[i - 1] * arr[i];
    }

    for (int j = arr.length - 2; j >= 0; j--) {
      arr2[j] = arr2[j + 1] * arr[j];
    }

    int[] result = new int[arr.length];
    for (int k = 0; k < arr.length; k++) {
      if (k - 1 < 0) {
        result[k] = arr2[k + 1];
      } else if (k + 1 >= arr.length) {
        result[k] = arr1[k - 1];
      } else {
        result[k] = arr1[k - 1] * arr2[k + 1];
      }
    }
    return result;
  }

  /**
   * 题目：128. 最长连续序列
   *
   * <p>题目描述：
   *
   * <p>给定一个未排序的整数数组 {@code arr}，找出数字连续的最长序列（不要求元素在原数组中连续）的长度。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int maxContinuousSequence(int[] arr)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：arr = [100,4,200,1,3,2]
   * 输出：4
   * 解释：最长连续序列是 [1,2,3,4]，所以长度为 4。
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：arr = [0,3,7,2,5,8,4,6,0,1]
   * 输出：9
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用额外空间</li>
   * <li>如果先排序再扫描，虽然能做出来，但不是这题优先训练的线性解法</li>
   * </ul>
   *
   * <p>专题定位：
   *
   * <ul>
   * <li>哈希专题：存在性判断</li>
   * <li>特征：要快速判断某个数是否存在，并希望把暴力枚举降到线性</li>
   * </ul>
   *
   * <p>思路：
   *
   * <ol>
   * <li>先把所有元素放进 {@code HashSet}，把存在性判断降到平均 {@code O(1)}。</li>
   * <li>遍历每个数时，只从“连续序列起点”开始扩展，也就是它的前一个数不存在时才继续往后找。</li>
   * <li>这样每段连续序列只会被真正统计一次。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>平均时间复杂度可以做到 {@code O(n)}。</li>
   * <li>“只从起点开始”这个技巧很适合训练哈希题里的去重扫描意识。</li>
   * </ul>
   *
   * <p>缺点：
   *
   * <ul>
   * <li>需要额外的 {@code HashSet} 空间。</li>
   * <li>如果只记住“用 set”，但忘了“只从起点开始”，复杂度就容易退化。</li>
   * </ul>
   *
   * <p>变体应对：
   *
   * <ul>
   * <li>如果题目要求返回具体序列，可以在记录最大长度的同时保存起点。</li>
   * <li>如果题目不允许额外空间，通常要换成排序后线性扫描的思路。</li>
   * </ul>
   */
  public int maxContinuousSequence(int[] arr) {
    if (arr.length <= 1) {
      return arr.length;
    }

    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      set.add(arr[i]);
    }

    int maxSequenceLength = 1;
    for (int j = 0; j < arr.length; j++) {
      int base = arr[j];
      if (set.contains(base - 1)) {
        continue;
      }

      int tempSequenceLength = 1;
      while (set.contains(base + 1)) {
        base = base + 1;
        tempSequenceLength++;
      }
      if (tempSequenceLength > maxSequenceLength) {
        maxSequenceLength = tempSequenceLength;
      }
    }

    return maxSequenceLength;
  }

  public static void main(String[] args) {
    ArrayQuestion question = new ArrayQuestion();
    int[] arr2 = {100, 4, 200, 1, 3, 2};
    System.out.println(question.maxContinuousSequence(arr2));
  }


}
