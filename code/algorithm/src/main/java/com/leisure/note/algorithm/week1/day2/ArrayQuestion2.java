package com.leisure.note.algorithm.week1.day2;

import java.util.Arrays;

/**
 * Week1 Day2 已完成题。
 *
 * <p>这里放的是：
 *
 * <ul>
 * <li>`167. 两数之和 II - 输入有序数组`</li>
 * <li>`11. 盛最多水的容器`</li>
 * </ul>
 *
 * <p>这两个方法已经补齐题号、题目描述、方法签名、样例和额外要求，便于按统一算法规则复盘。
 *
 * @author jie.he
 * @version 1.0.0
 * @since 2026/03/24 00:07
 */
public class ArrayQuestion2 {

  /**
   * 题目：167. 两数之和 II - 输入有序数组
   *
   * <p>题目描述：
   *
   * <p>给定一个已按照非递减顺序排列的整数数组 {@code arr} 和一个目标值 {@code target}，
   * 请你从数组中找出两个数，使它们的和等于 {@code target}，并返回这两个数的下标。
   *
   * <p>返回的下标按 {@code 1-based} 处理，要求满足 {@code 1 <= index1 < index2 <= arr.length}。
   * 题目保证恰好存在一个有效答案，且同一个元素不能重复使用。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int[] sumTwoNumber(int[] arr, int target)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：arr = [2,7,11,15], target = 9
   * 输出：[1,2]
   * 解释：arr[0] + arr[1] == 9，因此返回 [1,2]。
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：arr = [2,3,4], target = 6
   * 输出：[1,3]
   * </pre>
   *
   * <p>示例 3：
   *
   * <pre>
   * 输入：arr = [-1,0], target = -1
   * 输出：[1,2]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>目标额外空间复杂度为 {@code O(1)}</li>
   * <li>输入数组已经有序，优先利用有序性，不接受双重循环的 {@code O(n^2)} 解法</li>
   * <li>返回结果按 {@code 1-based} 下标处理</li>
   * <li>题目保证恰好存在一个有效答案</li>
   * </ul>
   *
   * <p>答题顺序要求：
   *
   * <ol>
   * <li>先复述输入是“有序数组 + 目标和”，输出是两个 {@code 1-based} 下标</li>
   * <li>先判断题型，并说明为什么这题优先考虑利用有序性的双指针</li>
   * <li>先口头说明左右指针分别代表什么，以及为什么移动后不会漏解</li>
   * <li>再补代码实现</li>
   * <li>最后说明复杂度、下标约定和“题目保证有解”这个前提</li>
   * </ol>
   *
   * <p>专题定位：
   *
   * <ul>
   * <li>数组专题：双指针</li>
   * <li>特征：输入数组有序，要找两个数之和，并希望优于 {@code O(n^2)}</li>
   * </ul>
   *
   * <p>思路：
   *
   * <ol>
   * <li>左指针指向最小值，右指针指向最大值。</li>
   * <li>如果当前和偏大，就只能右指针左移；如果偏小，就只能左指针右移。</li>
   * <li>依靠有序性，每次移动都不会漏解。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>时间复杂度 {@code O(n)}，额外空间 {@code O(1)}。</li>
   * <li>很适合训练“为什么双指针不会漏解”的表达。</li>
   * </ul>
   *
   * <p>缺点：
   *
   * <ul>
   * <li>依赖数组有序这一前提，不适用于无序数组。</li>
   * <li>当前实现用 {@code while (true)}，虽然题目保证有解时成立，但泛化性一般。</li>
   * </ul>
   *
   * <p>变体应对：
   *
   * <ul>
   * <li>如果输入无序，通常改用哈希表做补数查找。</li>
   * <li>如果题目不保证有解，更稳的写法通常是 {@code while (i < j)}。</li>
   * <li>如果是三数之和 / 四数之和，通常是在排序基础上固定若干个数后继续用双指针。</li>
   * </ul>
   */
  public int[] sumTwoNumber(int[] arr, int target) {
    int i = 1;
    int j = arr.length;
    while (true) {
      if (arr[i - 1] + arr[j - 1] > target) {
        j--;
      } else if (arr[i - 1] + arr[j - 1] < target) {
        i++;
      } else {
        break;
      }
    }

    return new int[] {i, j};
  }

  /**
   * 题目：11. 盛最多水的容器
   *
   * <p>题目描述：
   *
   * <p>给定一个长度为 {@code n} 的整数数组 {@code height}。有 {@code n} 条垂线，
   * 第 {@code i} 条线的两个端点是 {@code (i, 0)} 和 {@code (i, height[i])}。
   * 找出其中两条线，使它们与 {@code x} 轴共同构成的容器可以容纳最多的水，并返回最大容积。
   *
   * <p>说明：你不能倾斜容器。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int maxArea(int[] height)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：height = [1,8,6,2,5,4,8,3,7]
   * 输出：49
   * 解释：选择下标 1 和 8 的两条线时，面积最大，为 7 * 7 = 49。
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：height = [1,1]
   * 输出：1
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>目标额外空间复杂度为 {@code O(1)}</li>
   * <li>不接受双重循环枚举所有边界的 {@code O(n^2)} 解法</li>
   * <li>只需要返回最大容积，不需要返回具体下标</li>
   * <li>数组元素表示高度，默认是非负整数</li>
   * </ul>
   *
   * <p>答题顺序要求：
   *
   * <ol>
   * <li>先复述输入是高度数组，输出是最大容积，不需要返回边界位置</li>
   * <li>先判断题型，并说明为什么这是“两端夹逼”的双指针题</li>
   * <li>先口头说明面积公式，以及为什么每次只移动较短的一侧</li>
   * <li>再补代码实现</li>
   * <li>最后说明复杂度、短板原理和边界情况</li>
   * </ol>
   *
   * <p>专题定位：
   *
   * <ul>
   * <li>数组专题：左右夹逼双指针</li>
   * <li>特征：答案由左右边界共同决定，而且移动方向需要证明不会漏解</li>
   * </ul>
   *
   * <p>思路：
   *
   * <ol>
   * <li>左右指针从两端向中间收缩，每次计算当前容器面积。</li>
   * <li>面积由短板决定，所以只移动较短的一侧，才有机会让高度上限变大。</li>
   * <li>移动较高的一侧不会带来更优结果，因为宽度变小而短板仍然没有改善。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>时间复杂度 {@code O(n)}，显著优于暴力双重循环。</li>
   * <li>适合训练“移动短板为什么成立”的证明能力。</li>
   * </ul>
   *
   * <p>缺点：
   *
   * <ul>
   * <li>正确性证明不如普通有序双指针直观。</li>
   * <li>如果只会背“移动短板”，但说不出原因，面试里容易被追问卡住。</li>
   * </ul>
   *
   * <p>变体应对：
   *
   * <ul>
   * <li>如果题目改成返回具体下标，在更新最大面积时顺手记录左右边界即可。</li>
   * <li>如果题目结构不再满足“两端围成面积”，就不能机械套这个模板。</li>
   * </ul>
   */
  public int maxArea(int[] height) {
    if (height.length <= 1) {
      return 0;
    }
    int i = 0;
    int j = height.length - 1;
    int maxArea = 0;
    while (i < j) {
      maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
     if (height[i] >= height[j]) {
       j--;
     } else {
       i++;
     }
    }
    return maxArea;
  }

  public static void main(String[] args) {
    ArrayQuestion2 arrayQuestion2 = new ArrayQuestion2();
//    int[] numbers = new int[] {2, 7, 11, 15};
//    int[] result = arrayQuestion2.sumTwoNumber(numbers, 9);
//    System.out.println(Arrays.toString(result));
    int[] heights = new int[]{1,8,6,2,5,4,8,3,7};
    System.out.println(arrayQuestion2.maxArea(heights));
  }

}
