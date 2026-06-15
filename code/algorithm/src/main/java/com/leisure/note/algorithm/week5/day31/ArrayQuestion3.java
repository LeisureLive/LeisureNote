package com.leisure.note.algorithm.week5.day31;

import java.util.HashMap;
import java.util.Map;

/**
 * Day31 数组滑动窗口复习题。
 *
 * <p>这组题是结合 `01_arrays.md` 里 `3.3 滑动窗口` 的分类补出来的，
 * 目标不是继续堆同构题，而是把几种最常见的窗口思路并排放在一起对照：
 *
 * <ul>
 * <li>固定长度窗口</li>
 * <li>变长窗口：最长合法区间</li>
 * <li>容错型窗口</li>
 * <li>统计型窗口</li>
 * </ul>
 *
 * <p>选题时刻意避开了当前台账里已经做过的滑动窗口题：
 *
 * <ul>
 * <li>{@code 3}</li>
 * <li>{@code 209}</li>
 * <li>{@code 438}</li>
 * <li>{@code 76}</li>
 * <li>{@code 485}</li>
 * </ul>
 *
 * <p>这份复习默认统一采用右开区间 {@code [left, right)}，方便把几类模板统一起来。
 */
public class ArrayQuestion3 {

  /**
   * 485. 最大连续 1 的个数
   *
   * <p>题目描述：
   *
   * <p>给定一个二进制数组 {@code nums}，计算其中最大连续 {@code 1} 的个数。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int findMaxConsecutiveOnes(int[] nums)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums = [1,1,0,1,1,1]
   * 输出：3
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums = [1,0,1,1,0,1]
   * 输出：2
   * </pre>
   *
   * <p>专题定位：
   *
   * <ul>
   * <li>变长窗口：最长合法区间</li>
   * <li>合法条件：窗口内 {@code 0} 的个数必须为 {@code 0}</li>
   * </ul>
   *
   * <p>复习重点：
   *
   * <ul>
   * <li>把“数连续 1”翻译成“求窗口内 0 个数为 0 的最长子数组”</li>
   * <li>窗口采用右开区间 {@code [left, right)}，长度统一写成 {@code right - left}</li>
   * <li>先入窗、再推进 {@code right}、再修复窗口，这个顺序不能乱</li>
   * </ul>
   */
  public int findMaxConsecutiveOnes(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int left = 0;
    int right = 0;
    int zeroCount = 0;
    int maxCount = 0;
    while (right < nums.length) {
      // 第一步：把 nums[right] 纳入当前窗口状态。
      // 这题的合法条件是“窗口内 0 的个数必须为 0”，所以只需要维护 zeroCount。
      if (nums[right] == 0) {
        zeroCount++;
      }

      // 第二步：无论当前是 0 还是 1，right 都要推进。
      // 因为当前实现采用的是右开区间 [left, right)，
      // 一旦 nums[right] 已经被统计进窗口状态，就应该让 right 指向下一个待进入位置。
      //
      // 你前一版的核心错误就在这里：
      // 只在遇到 1 时推进 right，遇到 0 不推进，
      // 会导致同一个 0 被重复处理，窗口状态和指针位置脱节。
      right++;

      // 第三步：如果窗口不合法（包含 0），就收缩左边界，直到窗口重新合法。
      // 这里的 while 不是“遇到问题就重开一段”，而是标准滑窗的“修复窗口”动作。
      while (zeroCount > 0) {
        if (nums[left] == 0) {
          zeroCount--;
        }
        left++;
      }

      // 第四步：窗口重新合法后更新答案。
      // 当前窗口是 [left, right)，所以长度是 right - left。
      // 如果你采用的是闭区间 [left, right]，这里才会写成 right - left + 1，
      // 但那种写法要求 right 的推进顺序和更新时机也一起对应调整。
      maxCount = Math.max(maxCount, right - left);
    }

    return maxCount;
  }

  /**
   * 643. 子数组最大平均数 I
   *
   * <p>题目描述：
   *
   * <p>给你一个由 {@code n} 个元素组成的整数数组 {@code nums} 和一个整数 {@code k}，
   * 请你找出平均数最大且长度为 {@code k} 的连续子数组，并输出该最大平均数。
   *
   * <p>方法签名：
   *
   * <pre>
   * public double findMaxAverage(int[] nums, int k)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：nums = [1,12,-5,-6,50,3], k = 4
   * 输出：12.75
   * </pre>
   *
   * <p>专题定位：
   *
   * <ul>
   * <li>固定长度窗口</li>
   * <li>代表“进一个、出一个、窗口长度恰好等于 k 时更新答案”的标准写法</li>
   * </ul>
   *
   * <p>为什么选这题：
   *
   * <ul>
   * <li>你台账里已经做过固定长度窗口代表题 {@code 438}，但那题更偏字符频次匹配</li>
   * <li>这题更适合把固定长度窗口的机械动作单独拎出来讲清楚</li>
   * </ul>
   */
  public double findMaxAverage(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k <= 0 || nums.length < k) {
      return 0;
    }

    int left = 0;
    int right = 0;
    long windowSum = 0;
    // 注意：这里不能初始化成 0。
    // 如果数组全是负数，初始化为 0 会把真实答案“压掉”。
    double maxAverage = Double.NEGATIVE_INFINITY;
    while (right < nums.length) {
      // 固定长度窗口标准写法：
      // 1. 先把 nums[right] 入窗
      // 2. 如果窗口长度超过 k，就把最左元素移出
      // 3. 当窗口长度刚好等于 k 时，立刻更新答案
      //
      // 你前一版的问题就在第 3 步的时机：
      // 是“等下一轮循环开始再更新答案”，这样最后一个窗口形成后，
      // right 已经到 nums.length，循环直接结束，最后一窗就被漏掉了。
      windowSum += nums[right];
      right++;

      if (right - left > k) {
        windowSum -= nums[left];
        left++;
      }

      if (right - left == k) {
        maxAverage = Math.max(maxAverage, (double) windowSum / k);
      }
    }

    return maxAverage;
  }

  /**
   * 904. 水果成篮
   *
   * <p>题目描述：
   *
   * <p>你正在探访一排果树，数组 {@code fruits} 中的每个位置表示该树上的水果种类。
   * 你只有两个篮子，每个篮子只能装一种水果，且每种水果数量不限。
   * 你可以选择任意起点，但从起点开始必须连续向右采摘，直到遇到第三种水果为止。
   * 请返回你最多可以采摘的水果数目。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int totalFruit(int[] fruits)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：fruits = [1,2,1]
   * 输出：3
   * </pre>
   *
   * <p>专题定位：
   *
   * <ul>
   * <li>变长窗口：最长合法区间</li>
   * <li>合法条件：窗口内不同种类数不能超过 {@code 2}</li>
   * </ul>
   *
   * <p>为什么选这题：
   *
   * <ul>
   * <li>它能补上“窗口状态不是简单和/计数，而是种类数”的典型写法</li>
   * <li>适合训练 `Map + while (不合法就收缩)` 这种最通用的最长合法窗口模板</li>
   * </ul>
   */
  public int totalFruit(int[] fruits) {
    if (fruits == null || fruits.length == 0) {
      return 0;
    }

    int left = 0;
    int right = 0;
    int maxCount = 0;
    // map 维护当前窗口 [left, right) 内每种水果出现的次数。
    // 它的核心作用不是简单计数，而是帮助我们判断“窗口里当前有几种水果”。
    Map<Integer, Integer> map = new HashMap<>();
    while (right < fruits.length) {
      // 第一步：把 fruits[right] 入窗，并更新该水果在窗口中的出现次数。
      map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
      right++;

      // 第二步：如果窗口里水果种类超过 2，就持续收缩左边界，直到重新合法。
      // 这题的“不变量”是：退出这个 while 后，窗口内水果种类数一定 <= 2。
      while (map.size() > 2) {
        // fruits[left] 即将出窗，所以先把它的出现次数减 1。
        int tempCount = map.getOrDefault(fruits[left], 0) - 1;
        if (tempCount > 0) {
          map.put(fruits[left], tempCount);
        } else {
          // 如果某种水果次数减到 0，说明它已经完全离开窗口，要从 map 中删除。
          map.remove(fruits[left]);
        }
        left++;
      }

      // 第三步：窗口重新合法后更新答案。
      // 这里 right 已经指向“下一个待进入位置”，所以当前窗口长度是 right - left。
      maxCount = Math.max(maxCount, right - left);
    }

    return maxCount;
  }

  /**
   * 1004. 最大连续 1 的个数 III
   *
   * <p>题目描述：
   *
   * <p>给定一个二进制数组 {@code nums} 和一个整数 {@code k}，
   * 如果可以翻转最多 {@code k} 个 {@code 0}，请返回数组中连续 {@code 1} 的最大个数。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int longestOnes(int[] nums, int k)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
   * 输出：6
   * </pre>
   *
   * <p>专题定位：
   *
   * <ul>
   * <li>容错型窗口</li>
   * <li>合法条件：窗口内坏元素数（这里是 0 的个数）不超过 {@code k}</li>
   * </ul>
   *
   * <p>为什么选这题：
   *
   * <ul>
   * <li>`01_arrays.md` 里明确把它作为容错型窗口代表题</li>
   * <li>它和当前文件里的 {@code 485} 形成非常好的对照：
   *   `485` 是“坏元素必须为 0”，这题是“坏元素最多为 k”</li>
   * </ul>
   */
  public int longestOnes(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int left = 0;
    int right = 0;
    // zeroCount 表示当前窗口 [left, right) 内 0 的个数。
    // 这题的合法条件就是：zeroCount <= k。
    int zeroCount = 0;
    int maxCount = 0;
    while (right < nums.length) {
      // 第一步：把 nums[right] 入窗。
      // 只有遇到 0 时，才会改变窗口的“坏元素计数”。
      if (nums[right] == 0) {
        zeroCount++;
      }
      right++;

      // 第二步：如果窗口内 0 的个数超过 k，就持续收缩左边界，直到重新合法。
      // 这题和 485 的关系可以这样记：
      // 485 是“zeroCount 必须等于 0”，1004 是“zeroCount 最多等于 k”。
      while (zeroCount > k) {
        // nums[left] 出窗前，如果它是 0，就要同步把坏元素计数减回来。
        if (nums[left] == 0) {
          zeroCount--;
        }
        left++;
      }

      // 第三步：窗口合法后更新最长长度。
      // 当前采用右开区间 [left, right)，所以长度统一写成 right - left。
      maxCount = Math.max(maxCount, right - left);
    }

    return maxCount;
  }

  /**
   * 713. 乘积小于 K 的子数组
   *
   * <p>题目描述：
   *
   * <p>给定一个正整数数组 {@code nums} 和整数 {@code k}，
   * 请返回乘积严格小于 {@code k} 的连续子数组的个数。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int numSubarrayProductLessThanK(int[] nums, int k)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：nums = [10,5,2,6], k = 100
   * 输出：8
   * </pre>
   *
   * <p>专题定位：
   *
   * <ul>
   * <li>统计型滑动窗口</li>
   * <li>前提：数组元素都是正数，因此窗口乘积随右扩是可维护、可收缩的</li>
   * </ul>
   *
   * <p>为什么选这题：
   *
   * <ul>
   * <li>`3.3` 里提到滑动窗口不只求最长/最短，也可能统计满足条件的连续区间</li>
   * <li>这题能训练一个很关键的思维：当右端点固定时，以它结尾的所有合法子数组个数就是 {@code right - left}</li>
   * </ul>
   */
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    // 这题的前提是 nums[i] 都是正整数，所以任意非空子数组的乘积至少是 1。
    // 因此当 k <= 1 时，不可能存在乘积严格小于 k 的非空子数组，必须直接返回 0。
    //
    // 你前一版这里如果没有提前返回，后面 while (plusCount >= k) 会一直收缩 left，
    // 即使窗口已经空了也停不下来，最终就会把 left 推到越界。
    if (k <= 1) {
      return 0;
    }

    int left = 0;
    int right = 0;
    int count = 0;
    // plusCount 始终表示当前窗口 [left, right) 内所有元素的乘积。
    // 这个“不变量”必须一直成立，否则后面的比较和收缩都会失真。
    int plusCount = 1;
    while (right < nums.length) {
      // 第一步：先把 nums[right] 入窗。
      // 这里必须先乘上当前元素，再让 right++，这样 plusCount 才能和窗口 [left, right) 对齐。
      //
      // 你之前出错的本质，就是窗口乘积和窗口边界脱节了：
      // 会出现“right 还没进窗口，但 left 已经开始把它当成窗口里的元素往外除”的情况。
      plusCount = plusCount * nums[right];
      right++;

      // 第二步：如果当前窗口乘积不合法（>= k），就持续收缩左边界，直到重新合法。
      // 注意这里必须是 while，不是 if。
      // 因为新元素入窗后，可能需要连续移出多个左侧元素，窗口才能恢复合法。
      while (plusCount >= k) {
        plusCount = plusCount / nums[left];
        left++;
      }

      // 第三步：窗口恢复合法后，再统计答案。
      //
      // 这时 right 已经固定，窗口是合法的 [left, right)。
      // 所有“以 right - 1 结尾”的合法子数组，左端点都可以从 left 一直到 right - 1：
      // [left, right), [left + 1, right), ..., [right - 1, right)
      // 一共有 right - left 个。
      //
      // 这也是这题最关键的一步：
      // 不是每次只加 1，而是固定右端点后，一次性加上整段合法起点的数量。
      count += right - left;
    }

    return count;
  }

  public static void main(String[] args) {
    ArrayQuestion3 arrayQuestion3 = new ArrayQuestion3();
//    System.out.println(arrayQuestion3.findMaxConsecutiveOnes(new int[] {1, 0, 1, 1, 0, 1}));
//    System.out.println(arrayQuestion3.findMaxAverage(new int[] {1, 12, -5, -6, 50, 3}, 4));
//    System.out.println(arrayQuestion3.totalFruit(new int[] {1, 2, 1}));
    System.out.println(arrayQuestion3.longestOnes(new int[] {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
//    System.out.println(arrayQuestion3.numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100));
  }
}
