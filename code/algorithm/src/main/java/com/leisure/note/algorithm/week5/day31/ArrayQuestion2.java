package com.leisure.note.algorithm.week5.day31;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Day31 数组双指针复习题。
 *
 * <p>这一轮是系统性第二次复习，所以把数组专题 `3.2 双指针` 的代表题集中到一个文件里，方便连续练习和横向对比。
 *
 * <p>本文件刻意避开当前台账里已经做过的：
 *
 * <ul>
 * <li>{@code 167. 两数之和 II - 输入有序数组}</li>
 * <li>{@code 11. 盛最多水的容器}</li>
 * </ul>
 *
 * <p>改为补这几类当前更值得收口的双指针模式：
 *
 * <ul>
 * <li>原地去重：{@code 26. 删除有序数组中的重复项}</li>
 * <li>限次去重：{@code 80. 删除有序数组中的重复项 II}</li>
 * <li>原地删除：{@code 27. 移除元素}</li>
 * <li>稳定搬移：{@code 283. 移动零}</li>
 * <li>双指针进阶：{@code 42. 接雨水}</li>
 * </ul>
 *
 * <p>这一组题连着练的目标不是只会写两个指针，而是能分清：
 *
 * <ul>
 * <li>什么时候是快慢指针做原地覆盖。</li>
 * <li>什么时候是左右夹逼做范围收缩。</li>
 * <li>为什么这样移动不会漏解，或者不会破坏结果顺序。</li>
 * </ul>
 *
 * @author jie.he
 * @version 1.0.0
 * @since 2026/04/26
 */
public class ArrayQuestion2 {

  /**
   * 26. 删除有序数组中的重复项
   *
   * <p>题目描述：
   *
   * <p>给你一个按非严格递增顺序排列的数组 {@code nums}，请你原地删除重复出现的元素，
   * 使每个元素只出现一次，返回删除后数组的新长度。
   *
   * <p>元素的相对顺序应该保持一致。然后返回 {@code nums} 中唯一元素的个数。
   *
   * <p>考虑 {@code nums} 的唯一元素的数量为 {@code k}，你需要做以下事情确保你的题解可以被通过：
   *
   * <ul>
   * <li>更改数组 {@code nums}，使 {@code nums} 的前 {@code k} 个元素包含唯一元素，并按照它们最初在 {@code nums} 中出现的顺序排列。</li>
   * <li>{@code nums} 的其余元素与 {@code nums} 的大小不重要。</li>
   * <li>返回 {@code k}。</li>
   * </ul>
   *
   * <p>方法签名：
   *
   * <pre>
   * public int removeDuplicates(int[] nums)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums = [1,1,2]
   * 输出：2, nums = [1,2,_]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
   * 输出：5, nums = [0,1,2,3,4,_,_,_,_,_]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>目标额外空间复杂度为 {@code O(1)}</li>
   * <li>必须原地修改，不能新建结果数组</li>
   * </ul>
   *
   * <p>专题定位：
   *
   * <ul>
   * <li>数组专题：快慢指针原地覆盖</li>
   * <li>特征：输入有序，重复元素天然聚在一起，可以只保留“每段重复块的第一个值”</li>
   * </ul>
   *
   * <p>回顾重点：
   *
   * <ul>
   * <li>{@code slow} 始终指向“当前已保留结果的最后一个位置”</li>
   * <li>{@code fast} 负责扫描新元素，遇到和 {@code nums[slow]} 不同的值才写入下一格</li>
   * <li>因为数组有序，所以只需要和结果尾部比，不需要回头检查整段前缀</li>
   * </ul>
   */
  public int removeDuplicates(int[] nums) {
    if (nums == null) {
      return 0;
    }

    if (nums.length <= 1) {
      return nums.length;
    }

    int fast = 1;
    int slow = 0;
    while (fast < nums.length) {
      // 有序数组里，只要当前值和结果尾部不同，就说明遇到了一个新的唯一值。
      if (nums[fast] != nums[slow]) {
        // 先移动 slow 再写入，表示把这个新值接到“去重结果”的下一格。
        nums[++slow] = nums[fast];
      }
      fast++;
    }
    // slow 指向结果尾部，下标转长度要 +1。
    return slow + 1;
  }

  /**
   * 80. 删除有序数组中的重复项 II
   *
   * <p>题目描述：
   *
   * <p>给你一个有序数组 {@code nums}，请你原地删除重复出现的元素，使得每个元素最多只出现两次，
   * 返回删除后数组的新长度。
   *
   * <p>不要使用额外的数组空间，你必须在原地修改输入数组，并在使用 {@code O(1)} 额外空间的条件下完成。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int removeDuplicates(int[] nums)
   * </pre>
   *
   * <p>说明：
   *
   * <p>本地复习文件中为了和 {@code 26. 删除有序数组中的重复项} 共存在同一个类里，
   * 这里将实现方法命名为 {@code removeDuplicates2}，但 LeetCode 提交时仍使用题目原始签名。
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums = [1,1,1,2,2,3]
   * 输出：5, nums = [1,1,2,2,3,_]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums = [0,0,1,1,1,1,2,3,3]
   * 输出：7, nums = [0,0,1,1,2,3,3,_,_]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>目标额外空间复杂度为 {@code O(1)}</li>
   * <li>必须原地修改，且保留数组前缀中的相对顺序</li>
   * </ul>
   *
   * <p>专题定位：
   *
   * <ul>
   * <li>数组专题：快慢指针原地覆盖</li>
   * <li>特征：和 26 的区别不是“是否去重”，而是“每个值允许保留到几次”</li>
   * </ul>
   *
   * <p>回顾重点：
   *
   * <ul>
   * <li>{@code right} 负责扫描整个有序数组，{@code left} 负责维护保留结果的尾部</li>
   * <li>{@code showTime} 记录当前这段重复值已经保留了几次，超过 2 次就跳过</li>
   * <li>一旦遇到新值，要同步做两件事：写入新值，并把计数重置为 1</li>
   * </ul>
   */
  public int removeDuplicates2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return 1;
    }

    int showTime = 1;
    int left = 0;
    int right = 1;
    while (right < nums.length) {
      if (nums[right] != nums[left]) {
        // 遇到新值时，直接接到结果尾部，并重置当前值的保留次数。
        nums[++left] = nums[right++];
        showTime = 1;
      } else {
        if (showTime < 2) {
          // 当前值还没达到“最多保留两次”的上限，可以继续写入。
          showTime++;
          nums[++left] = nums[right++];
        } else {
          // 已经保留了两次，后续重复值直接跳过，只移动扫描指针。
          right++;
        }
      }
    }

    return left + 1;
  }

  /**
   * 27. 移除元素
   *
   * <p>题目描述：
   *
   * <p>给你一个数组 {@code nums} 和一个值 {@code val}，你需要原地移除所有数值等于 {@code val} 的元素，
   * 并返回移除后数组的新长度。
   *
   * <p>不要使用额外的数组空间，你必须仅使用 {@code O(1)} 额外空间并原地修改输入数组。
   * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int removeElement(int[] nums, int val)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums = [3,2,2,3], val = 3
   * 输出：2, nums = [2,2,_,_]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
   * 输出：5, nums = [0,1,4,0,3,_,_,_]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>目标额外空间复杂度为 {@code O(1)}</li>
   * <li>重点训练“保留什么、跳过什么、慢指针写到哪里”的原地覆盖思维</li>
   * </ul>
   *
   * <p>专题定位：
   *
   * <ul>
   * <li>数组专题：快慢指针原地过滤</li>
   * <li>特征：不需要保持被删除元素，只需要把“保留元素”连续写回前缀</li>
   * </ul>
   *
   * <p>回顾重点：
   *
   * <ul>
   * <li>{@code fast} 负责看当前元素要不要保留</li>
   * <li>{@code slow} 负责维护“保留区间”的写入位置</li>
   * <li>这题和 26 的区别是：26 借助有序性判断“是否重复”，这里直接判断“是否等于 val”</li>
   * </ul>
   */
  public int removeElement(int[] nums, int val) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int fast = 0;
    int slow = 0;
    while (fast < nums.length) {
      if (nums[fast] != val) {
        // 只把需要保留的元素往前覆盖，slow 之后的内容题目不关心。
        nums[slow++] = nums[fast];
      }
      fast++;
    }

    // slow 本身就是保留区间长度。
    return slow;
  }

  /**
   * 283. 移动零
   *
   * <p>题目描述：
   *
   * <p>给定一个数组 {@code nums}，编写一个函数将所有 {@code 0} 移动到数组的末尾，
   * 同时保持非零元素的相对顺序。
   *
   * <p>请注意，必须在不复制数组的情况下原地对数组进行操作。
   *
   * <p>方法签名：
   *
   * <pre>
   * public void moveZeroes(int[] nums)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums = [0,1,0,3,12]
   * 输出：[1,3,12,0,0]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums = [0]
   * 输出：[0]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>目标额外空间复杂度为 {@code O(1)}</li>
   * <li>需要保持非零元素的相对顺序不变</li>
   * </ul>
   *
   * <p>专题定位：
   *
   * <ul>
   * <li>数组专题：稳定搬移 / 快慢指针</li>
   * <li>特征：要保留非零元素顺序，所以不能像“移除元素”那样随便和尾部交换</li>
   * </ul>
   *
   * <p>回顾重点：
   *
   * <ul>
   * <li>第一遍先把所有非零元素稳定压缩到前面</li>
   * <li>第二遍再把剩余位置统一补 0</li>
   * <li>核心不是“看到 0 就处理”，而是“先构造非零前缀，再收尾补零”</li>
   * </ul>
   */
  public void moveZeroes(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }

    int slow = 0;
    int fast = 0;
    while (fast < nums.length) {
      if (nums[fast] != 0) {
        // 按扫描顺序写入非零元素，因此天然保持原相对顺序。
        nums[slow++] = nums[fast];
      }
      fast++;
    }
    // slow 之后都是“应补零区域”，统一填 0 即可。
    for (int i = slow; i < nums.length; i++) {
      nums[i] = 0;
    }
  }

  /**
   * 42. 接雨水 (hard)
   *
   * <p>题目描述：
   *
   * <p>给定 {@code n} 个非负整数表示每个宽度为 {@code 1} 的柱子的高度图，
   * 计算按此排列的柱子，下雨之后能接多少雨水。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int trap(int[] height)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
   * 输出：6
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：height = [4,2,0,3,2,5]
   * 输出：9
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度优先考虑 {@code O(n)}</li>
   * <li>可以思考多种解法：双指针、前后缀最大值、单调栈</li>
   * <li>本轮优先用双指针视角理解“为什么移动较低一侧不会漏解”</li>
   * </ul>
   *
   * <p>专题定位：
   *
   * <ul>
   * <li>数组专题：前后缀最大值</li>
   * <li>特征：某个位置的答案取决于“左侧最高墙”和“右侧最高墙”这两个全局信息</li>
   * </ul>
   *
   * <p>回顾重点：
   *
   * <ul>
   * <li>位置 {@code i} 能接的水，只由 {@code min(leftMax[i], rightMax[i]) - height[i]} 决定</li>
   * <li>前后缀数组法更直观，适合第一次把公式和整体结构讲清楚</li>
   * <li>代价是用了两个辅助数组，空间复杂度是 {@code O(n)}</li>
   * </ul>
   */
  public int trap(int[] height) {
    if (height == null || height.length <= 1) {
      return 0;
    }

    // left[i] 表示位置 i 左侧（含自身）最高的柱子。
    // 把“左边最高墙”先预处理出来，后面就不用每个位置再向左扫一遍。
    int[] left = new int[height.length];
    left[0] = height[0];
    for (int i = 1; i < height.length; i++) {
      left[i] = Math.max(left[i - 1], height[i]);
    }

    // right[i] 表示位置 i 右侧（含自身）最高的柱子。
    // 和 left[] 对称，目的是拿到“右边最高墙”。
    int[] right = new int[height.length];
    right[height.length - 1] = height[height.length - 1];
    for (int i = height.length - 2; i >= 0; i--) {
      right[i] = Math.max(right[i + 1], height[i]);
    }

    // 对于每个位置，真正能形成水位的是左右最高墙中的较短板。
    // 因为木桶效应决定了水位不可能超过较低那一侧。
    int ans = 0;
    for (int i = 0; i < height.length; i++) {
      // 这里不需要额外判断负数：
      // left[i] 和 right[i] 都包含自身，所以 min(left[i], right[i]) 至少是 height[i]。
      ans += Math.min(left[i], right[i]) - height[i];
    }
    return ans;
  }

  /**
   * 42. 接雨水的双指针解法
   *
   * <p>专题定位：
   *
   * <ul>
   * <li>数组专题：左右夹逼双指针</li>
   * <li>特征：当前答案依赖左右边界，但可以在扫描过程中逐步确定较低一侧的位置答案</li>
   * </ul>
   *
   * <p>回顾重点：
   *
   * <ul>
   * <li>{@code leftMax} / {@code rightMax} 分别表示当前扫描区间两侧已知的最高墙</li>
   * <li>谁的最大高度更小，谁这一侧当前位置的接水量就已经可以确定</li>
   * <li>这是因为另一侧至少还有一个不低于“较小最大值”的挡板存在，不会让当前计算失真</li>
   * </ul>
   *
   * <p>和前后缀数组法对比：
   *
   * <ul>
   * <li>时间复杂度同样是 {@code O(n)}</li>
   * <li>额外空间从 {@code O(n)} 降到 {@code O(1)}</li>
   * <li>但正确性理解门槛更高，核心要讲清“为什么可以先结算较低一侧”</li>
   * </ul>
   */
  public int trap2(int[] height) {
    if (height == null || height.length <= 1) {
      return 0;
    }

    // left / right 是当前尚未结算区间的左右边界。
    // leftMax / rightMax 记录从两边扫到当前位置时，各自见过的最高柱子。
    int left = 0, right = height.length - 1;
    int leftMax = 0, rightMax = 0, ans = 0;
    while (left < right) {
      // 先更新两边当前可见的最高墙，后面判断当前位置能否结算就靠它们。
      leftMax = Math.max(leftMax, height[left]);
      rightMax = Math.max(rightMax, height[right]);

      // 如果 leftMax <= rightMax，说明 left 位置右边一定存在一个“至少和 leftMax 一样高”的挡板，
      // 因为当前 rightMax 就已经满足这个条件。
      // 所以 left 位置最终水位只会由 leftMax 决定，可以立即结算，不必等右边全部遍历完。
      if (leftMax <= rightMax) {
        // leftMax - height[left] 就是当前位置的积水量。
        // 因为 leftMax 已经包含了 height[left]，所以这里不会出现负数。
        ans += leftMax - height[left];
        // left 已经结算完成，向中间推进，去处理下一个位置。
        left++;
      } else {
        // 对称地，如果 rightMax 更小，就优先结算右侧。
        ans += rightMax - height[right];
        right--;
      }
    }
    return ans;
  }



  public static void main(String[] args) {
    ArrayQuestion2 arrayQuestion2 = new ArrayQuestion2();
//    int[] nums = new int[] {0, 1, 0, 3, 12};
//    arrayQuestion2.moveZeroes(nums);
//    System.out.println(Arrays.toString(nums));

    System.out.println(arrayQuestion2.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    System.out.println(arrayQuestion2.trap2(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
  }
}
