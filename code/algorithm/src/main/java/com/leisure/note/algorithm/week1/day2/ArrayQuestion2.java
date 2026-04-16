package com.leisure.note.algorithm.week1.day2;

import java.util.Arrays;

/**
 * @author jie.he
 * @version 1.0.0
 * @since 2026/03/24 00:07
 */
public class ArrayQuestion2 {

  /**
   * `167. 两数之和 II - 输入有序数组`
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
   * `11. 盛最多水的容器`
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
