package com.leisure.note.algorithm.week5.day31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Day31 数组进阶模式复习题。
 *
 * <p>这一轮把 `01_arrays.md` 里 `3.4-3.7` 的模式统一收口到一个文件里，方便和
 * `ArrayQuestion` / `ArrayQuestion2` / `ArrayQuestion3` 对照复盘。
 *
 * <p>当前文件覆盖 4 组内容：
 *
 * <ul>
 * <li>前缀和</li>
 * <li>前后缀分解</li>
 * <li>原地交换 / 原地标记</li>
 * <li>二分查找</li>
 * </ul>
 *
 * <p>约定：
 *
 * <ul>
 * <li>已经做过的题保留可运行实现，便于统一复盘。</li>
 * <li>当前还缺的代表题只补题目描述和方法骨架，留作后续手写训练。</li>
 * </ul>
 */
public class ArrayQuestion4 {

  /**
   * 560. 和为 K 的子数组
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
   * <li>数组中可能包含负数、零和正数</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>数组 / 前缀和</li>
   * <li>代表“前缀和 + 哈希计数”</li>
   * </ul>
   *
   * <p>题型特征：
   *
   * <ul>
   * <li>题目对象是连续子数组</li>
   * <li>要求统计“满足条件的区间个数”，不是求某一个区间</li>
   * <li>数组里可能有负数，因此不能依赖滑动窗口的单调性</li>
   * </ul>
   *
   * <p>解题思路：
   *
   * <ol>
   * <li>把区间和改写成两个前缀和之差。</li>
   * <li>遍历到当前位置时，如果当前前缀和是 {@code prefixSum}，那么历史上每出现一次 {@code prefixSum - k}，就贡献一个答案。</li>
   * <li>因此哈希表存的是“某个前缀和出现过几次”。</li>
   * <li>初始化必须先放入 {@code 0 -> 1}，表示空前缀已经出现过一次。</li>
   * <li>更新顺序必须是“先统计答案，再记录当前前缀和次数”。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>时间复杂度是 {@code O(n)}，能稳定处理负数、零和正数混合场景。</li>
   * <li>模板迁移价值很高，是后续 `974`、`930` 这类计数型前缀和题的母模板。</li>
   * </ul>
   *
   * <p>缺点 / 适用前提：
   *
   * <ul>
   * <li>需要额外的哈希表空间。</li>
   * <li>如果没有想清“map 存次数”而误存位置，代码形式会完全不同。</li>
   * <li>最容易错的是初始化和更新时机。</li>
   * </ul>
   *
   * <p>变体应对 / 注意事项：
   *
   * <ul>
   * <li>如果题目改成“求最长长度”，通常就要像 `525`、`325` 一样改存最早位置。</li>
   * <li>如果数组元素全为正数且目标改成最长 / 最短满足条件区间，才更适合考虑滑动窗口。</li>
   * </ul>
   */
  public int subarraySum(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    Map<Integer, Integer> prefixCount = new HashMap<>();
    prefixCount.put(0, 1);
    int prefixSum = 0;
    int count = 0;
    for (int num : nums) {
      prefixSum += num;
      count += prefixCount.getOrDefault(prefixSum - k, 0);
      prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
    }
    return count;
  }

  /**
   * 525. 连续数组
   *
   * <p>题目描述：
   *
   * <p>给定一个二进制数组 {@code nums}，请返回含有相同数量 {@code 0} 和 {@code 1} 的最长连续子数组的长度。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int findMaxLength(int[] nums)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums = [0,1]
   * 输出：2
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums = [0,1,0]
   * 输出：2
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用额外空间</li>
   * <li>不接受暴力枚举所有子数组的 {@code O(n^2)} 解法</li>
   * <li>返回的是最长长度，不是子数组个数</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>数组 / 前缀和</li>
   * <li>代表“前缀和 + 最早位置”</li>
   * </ul>
   *
   * <p>题型特征：
   *
   * <ul>
   * <li>题目对象是连续子数组</li>
   * <li>要求最长长度，不是统计个数</li>
   * <li>题面是 `0/1` 数组，但核心要先做等价转换</li>
   * </ul>
   *
   * <p>解题思路：
   *
   * <ol>
   * <li>先把 {@code 0} 看成 {@code -1}，把 {@code 1} 看成 {@code +1}。</li>
   * <li>这样题目就转成“求和为 0 的最长连续子数组长度”。</li>
   * <li>如果两个位置的前缀和相同，说明中间这段区间和为 0。</li>
   * <li>因为目标是最长长度，所以哈希表必须存“某个前缀和第一次出现的位置”。</li>
   * <li>后续再遇到同一个前缀和时，用当前下标减最早位置更新答案。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>时间复杂度是 {@code O(n)}，把二进制数组平衡问题稳定转成前缀和问题。</li>
   * <li>很适合和 `560` 对照理解“map 存次数”和“map 存最早位置”的区别。</li>
   * </ul>
   *
   * <p>缺点 / 适用前提：
   *
   * <ul>
   * <li>依赖“0 和 1 数量相同”这个条件可被等价成和为 0。</li>
   * <li>如果忘了只保留最早位置，而被后面的位置覆盖，会把最长答案算短。</li>
   * </ul>
   *
   * <p>变体应对 / 注意事项：
   *
   * <ul>
   * <li>如果题目改成“求有多少段满足条件”，状态就应改成存次数，而不是位置。</li>
   * <li>初始化时放入 {@code 0 -> 0}，本质上是在用“前 i 个元素”的前缀位置语义。</li>
   * </ul>
   */
  public int findMaxLength(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return 0;
    }

    Map<Integer, Integer> earliestIndex = new HashMap<>();
    earliestIndex.put(0, 0);
    int prefixSum = 0;
    int maxLength = 0;
    for (int i = 1; i <= nums.length; i++) {
      prefixSum += nums[i - 1] == 0 ? -1 : 1;
      if (!earliestIndex.containsKey(prefixSum)) {
        earliestIndex.put(prefixSum, i);
      } else {
        maxLength = Math.max(maxLength, i - earliestIndex.get(prefixSum));
      }
    }
    return maxLength;
  }

  /**
   * 974. 和可被 K 整除的子数组
   *
   * <p>题目描述：
   *
   * <p>给定一个整数数组 {@code nums} 和一个整数 {@code k}，返回其中和可被 {@code k} 整除的非空子数组的个数。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int subarraysDivByK(int[] nums, int k)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：nums = [4,5,0,-2,-3,1], k = 5
   * 输出：7
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用额外空间</li>
   * <li>需要注意负数取模后的归一化处理</li>
   * <li>返回的是满足条件的子数组个数</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>数组 / 前缀和</li>
   * <li>前缀和 + 余数计数</li>
   * </ul>
   *
   * <p>题型特征：
   *
   * <ul>
   * <li>题目要求统计区间个数</li>
   * <li>条件不是“区间和等于某值”，而是“区间和可被 k 整除”</li>
   * <li>关键转换是把区间和关系改写成前缀和的同余关系</li>
   * </ul>
   *
   * <p>解题思路：
   *
   * <ol>
   * <li>如果两个前缀和对 {@code k} 的余数相同，那么它们的差就能被 {@code k} 整除。</li>
   * <li>因此遍历时只要统计“当前余数之前出现过几次”，就能一次性增加对应数量的答案。</li>
   * <li>哈希表存的是“某个余数出现过几次”，而不是位置。</li>
   * <li>Java 里负数取模可能为负，所以要先把余数归一化到 {@code [0, k)}。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>时间复杂度是 {@code O(n)}，能稳定处理带负数的情况。</li>
   * <li>是把 `560` 模板迁移到“模运算约束”场景的代表题。</li>
   * </ul>
   *
   * <p>缺点 / 适用前提：
   *
   * <ul>
   * <li>需要额外哈希表空间。</li>
   * <li>如果没有归一化负余数，答案会直接算错。</li>
   * </ul>
   *
   * <p>变体应对 / 注意事项：
   *
   * <ul>
   * <li>如果题目改成“判断是否存在”或“求最长长度”，map 的 value 通常要改成位置而不是次数。</li>
   * <li>初始化的 {@code 0 -> 1} 仍然代表空前缀的余数已经出现过一次。</li>
   * </ul>
   */
  public int subarraysDivByK(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k == 0) {
      return 0;
    }

    Map<Integer, Integer> modCount = new HashMap<>();
    modCount.put(0, 1);
    int prefixSum = 0;
    int count = 0;
    for (int num : nums) {
      prefixSum += num;
      int mod = prefixSum % k;
      if (mod < 0) {
        mod += k;
      }
      count += modCount.getOrDefault(mod, 0);
      modCount.put(mod, modCount.getOrDefault(mod, 0) + 1);
    }
    return count;
  }

  /**
   * 523. 连续的子数组和
   *
   * <p>题目描述：
   *
   * <p>给你一个整数数组 {@code nums} 和一个整数 {@code k}，如果 {@code nums} 有一个长度至少为 2 的连续子数组，
   * 其元素总和为 {@code k} 的倍数，返回 {@code true}；否则返回 {@code false}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public boolean checkSubarraySum(int[] nums, int k)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：nums = [23,2,4,6,7], k = 6
   * 输出：true
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用额外空间</li>
   * <li>子数组长度至少为 2</li>
   * <li>需要区分“存次数”和“存最早位置”两种前缀和写法</li>
   * <li>当前题面约束里 {@code k >= 1}，可以直接维护前缀和对 {@code k} 的余数</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>数组 / 前缀和</li>
   * <li>前缀和 + 最早位置 / 余数位置映射</li>
   * </ul>
   *
   * <p>题型特征：
   *
   * <ul>
   * <li>题目要求判断存在性，不是统计个数</li>
   * <li>还有“长度至少为 2”这个额外约束</li>
   * <li>条件本质仍然是前缀和同余，但 value 要存位置</li>
   * </ul>
   *
   * <p>解题思路：
   *
   * <ol>
   * <li>把“区间和是 {@code k} 的倍数”改写成“两个前缀和对 {@code k} 的余数相同”。</li>
   * <li>为了尽量早地满足长度约束，哈希表要保留某个余数最早出现的位置。</li>
   * <li>再次遇到同一个余数时，只要当前位置和最早位置的距离至少为 2，就能返回 {@code true}。</li>
   * <li>当前题面里 {@code k >= 1}，因此遍历时可以直接维护滚动余数而不必额外分支。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>时间复杂度是 {@code O(n)}，把“倍数 + 长度约束”稳定翻译成前缀和位置问题。</li>
   * <li>很适合和 `974`、`325` 对照，看“存次数 / 存最早位置 / 求存在性”三种状态差异。</li>
   * </ul>
   *
   * <p>缺点 / 适用前提：
   *
   * <ul>
   * <li>需要额外空间存余数最早出现位置。</li>
   * <li>如果把最早位置覆盖成最近位置，存在性判断虽然有时仍对，但长度约束很容易出问题。</li>
   * </ul>
   *
   * <p>变体应对 / 注意事项：
   *
   * <ul>
   * <li>当前题面约束下不需要单独处理 {@code k == 0}。</li>
   * <li>如果你把它抽成更通用的模板，而题目允许 {@code k == 0}，再退化成“前缀和重复 + 长度约束”的判断。</li>
   * <li>如果题目改成“统计有多少段”，就应回到 `560` / `974` 这种计数型写法。</li>
   * </ul>
   */
  public boolean checkSubarraySum(int[] nums, int k) {
    if (nums == null || nums.length < 2) {
      return false;
    }

    Map<Integer, Integer> earliestModIndex = new HashMap<>();
    earliestModIndex.put(0, 0);
    int prefixMod = 0;
    for (int i = 1; i <= nums.length; i++) {
      prefixMod = (prefixMod + nums[i - 1]) % k;
      if (earliestModIndex.containsKey(prefixMod) && i - earliestModIndex.get(prefixMod) >= 2) {
        return true;
      }
      if (!earliestModIndex.containsKey(prefixMod)) {
        earliestModIndex.put(prefixMod, i);
      }
    }
    return false;
  }

  /**
   * 930. 和相同的二元子数组
   *
   * <p>题目描述：
   *
   * <p>给你一个二元数组 {@code nums} 和一个整数 {@code goal}，请返回有多少个非空子数组的元素和等于 {@code goal}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int numSubarraysWithSum(int[] nums, int goal)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：nums = [1,0,1,0,1], goal = 2
   * 输出：4
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用额外空间</li>
   * <li>重点训练“计数型前缀和”模板迁移</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>数组 / 前缀和</li>
   * <li>前缀和 + 哈希计数</li>
   * </ul>
   *
   * <p>题型特征：
   *
   * <ul>
   * <li>题目对象是连续子数组</li>
   * <li>要求统计个数</li>
   * <li>虽然是二元数组，但核心仍然是标准的“前缀差 = goal”</li>
   * </ul>
   *
   * <p>解题思路：
   *
   * <ol>
   * <li>遍历时维护滚动前缀和 {@code prefixSum}。</li>
   * <li>如果历史上出现过 {@code prefixSum - goal}，就说明以当前位置结尾新增了对应数量的合法子数组。</li>
   * <li>因此哈希表存的是“某个前缀和出现次数”。</li>
   * <li>和 `560` 一样，顺序必须是先统计答案，再更新当前前缀和次数。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>时间复杂度是 {@code O(n)}，模板非常直接。</li>
   * <li>很适合训练你能不能不看答案，直接把 `560` 的骨架迁移过来。</li>
   * </ul>
   *
   * <p>缺点 / 适用前提：
   *
   * <ul>
   * <li>需要额外哈希表空间。</li>
   * <li>如果题目目标改成最长长度或存在性，这个“存次数”的状态就不再合适。</li>
   * </ul>
   *
   * <p>变体应对 / 注意事项：
   *
   * <ul>
   * <li>这题和 `560` 本质同构，复习时重点不是重新背题，而是确认自己能识别这是同一模板。</li>
   * <li>如果 goal 改成别的固定值，代码主体不变，仍然只是查 {@code prefixSum - goal}。</li>
   * </ul>
   */
  public int numSubarraysWithSum(int[] nums, int goal) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    Map<Integer, Integer> prefixCount = new HashMap<>();
    prefixCount.put(0, 1);
    int prefixSum = 0;
    int count = 0;
    for (int num : nums) {
      prefixSum += num;
      count += prefixCount.getOrDefault(prefixSum - goal, 0);
      prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
    }
    return count;
  }

  /**
   * 325. 和等于 k 的最长子数组长度
   *
   * <p>题目描述：
   *
   * <p>给定一个整数数组 {@code nums} 和一个整数 {@code k}，返回和等于 {@code k} 的最长连续子数组的长度。
   * 如果不存在任意一个符合要求的子数组，则返回 {@code 0}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int maxSubArrayLen(int[] nums, int k)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：nums = [1,-1,5,-2,3], k = 3
   * 输出：4
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用额外空间</li>
   * <li>重点说清为什么必须存“最早位置”</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>数组 / 前缀和</li>
   * <li>前缀和 + 最早位置</li>
   * </ul>
   *
   * <p>题型特征：
   *
   * <ul>
   * <li>题目对象是连续子数组</li>
   * <li>要求最长长度，不是区间个数</li>
   * <li>数组里可能有负数，因此不能靠滑动窗口处理</li>
   * </ul>
   *
   * <p>解题思路：
   *
   * <ol>
   * <li>把区间和等于 {@code k} 改写成“当前前缀和 - 历史前缀和 = k”。</li>
   * <li>如果历史上出现过 {@code prefixSum - k}，就能形成一个合法区间。</li>
   * <li>因为目标是最长长度，所以哈希表必须保留某个前缀和第一次出现的位置。</li>
   * <li>后续同样的前缀和再出现时，不应该覆盖最早位置。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>时间复杂度是 {@code O(n)}，而且能处理带负数的数组。</li>
   * <li>和 `560`、`525` 一起很适合做“次数 / 最早位置 / 最长长度”的模板对照。</li>
   * </ul>
   *
   * <p>缺点 / 适用前提：
   *
   * <ul>
   * <li>需要额外哈希表空间。</li>
   * <li>如果误把最早位置覆盖成最近位置，答案通常会被算短。</li>
   * </ul>
   *
   * <p>变体应对 / 注意事项：
   *
   * <ul>
   * <li>如果题目改成“求个数”，状态要改成次数，回到 `560` 模板。</li>
   * <li>初始化放入 {@code 0 -> 0}，本质上是在表达“前 0 个元素的前缀和为 0”。</li>
   * </ul>
   */
  public int maxSubArrayLen(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    Map<Integer, Integer> earliestIndex = new HashMap<>();
    earliestIndex.put(0, 0);
    int prefixSum = 0;
    int maxLength = 0;
    for (int i = 1; i <= nums.length; i++) {
      prefixSum += nums[i - 1];
      if (earliestIndex.containsKey(prefixSum - k)) {
        maxLength = Math.max(maxLength, i - earliestIndex.get(prefixSum - k));
      }
      if (!earliestIndex.containsKey(prefixSum)) {
        earliestIndex.put(prefixSum, i);
      }
    }
    return maxLength;
  }

  /**
   * 303. 区域和检索 - 数组不可变
   *
   * <p>题目描述：
   *
   * <p>给定一个整数数组 {@code nums}，处理以下类型的多个查询：
   * 计算索引 {@code left} 和 {@code right} 之间元素的总和，包含 {@code left} 和 {@code right} 两点。
   *
   * <p>方法签名：
   *
   * <pre>
   * public NumArray(int[] nums)
   * public int sumRange(int left, int right)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：
   * ["NumArray", "sumRange", "sumRange", "sumRange"]
   * [[[-2,0,3,-5,2,-1]], [0,2], [2,5], [0,5]]
   * 输出：
   * [null, 1, -1, -3]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>查询会被多次调用，重点不是单次现算，而是预处理</li>
   * <li>目标时间复杂度通常是构造 {@code O(n)}，查询 {@code O(1)}</li>
   * <li>当前保留可运行实现，便于复盘“预处理一次，多次查询复用”的前缀和模式</li>
   * </ul>
   */
  public static class NumArray {
    private int[] nums;
    private int[] prefixSum;

    public NumArray(int[] nums) {
      this.nums = nums;
      this.prefixSum = new int[nums.length + 1];
      this.prefixSum[0] = 0;
      int sum = 0;
      for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        this.prefixSum[i + 1] = sum;
      }

    }

    public int sumRange(int left, int right) {
      return prefixSum[right + 1] - prefixSum[left];
    }
  }

  /**
   * 724. 寻找数组的中心下标
   *
   * <p>题目描述：
   *
   * <p>给你一个整数数组 {@code nums}，请计算数组的中心下标。
   * 数组中心下标是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
   * 如果中心下标位于数组最左端，那么左侧数之和视为 {@code 0}；如果中心下标位于数组最右端，那么右侧数之和视为 {@code 0}。
   * 如果数组有多个中心下标，应该返回最靠近左边的那一个；如果数组不存在中心下标，返回 {@code -1}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int pivotIndex(int[] nums)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums = [1,7,3,6,5,6]
   * 输出：3
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums = [1,2,3]
   * 输出：-1
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许使用额外空间，也可以继续思考 {@code O(1)} 额外空间写法</li>
   * <li>当前保留前后缀数组实现，便于和更省空间的写法对照复盘</li>
   * </ul>
   */
  public int pivotIndex(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    if (nums.length == 1) {
      return 0;
    }

    int[] leftPrefixSum = new int[nums.length];
    int[] rightPrefixSum = new int[nums.length];
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      leftPrefixSum[i] = sum;
    }

    sum = 0;
    for (int i = nums.length - 1; i >= 0; i--) {
      sum += nums[i];
      rightPrefixSum[i] = sum;
    }

    for (int i = 0; i < nums.length; i++) {
      if (i == 0) {
        if (rightPrefixSum[i + 1] == 0) {
          return i;
        } else {
          continue;
        }
      }

      if (i == nums.length - 1) {
        if (leftPrefixSum[i - 1] == 0) {
          return i;
        } else {
          continue;
        }
      }
      if (leftPrefixSum[i - 1] == rightPrefixSum[i + 1]) {
        return i;
      }
    }
    return -1;
  }

  /**
   * 238. 除自身以外数组的乘积
   *
   * <p>题目描述：
   *
   * <p>给你一个整数数组 {@code nums}，返回数组 {@code answer}，
   * 其中 {@code answer[i]} 等于 {@code nums} 中除 {@code nums[i]} 之外其余各元素的乘积。
   *
   * <p>题目数据保证数组中任意位置左侧元素和右侧元素乘积都在 32 位整数范围内。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int[] productExceptSelf(int[] nums)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums = [1,2,3,4]
   * 输出：[24,12,8,6]
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums = [-1,1,0,-3,3]
   * 输出：[0,0,9,0,0]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>不能使用除法</li>
   * <li>可以先用前后缀数组，也可以继续优化到结果数组 + 滚动后缀变量</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>数组 / 前后缀分解</li>
   * <li>代表“每个位置的答案同时依赖左侧信息和右侧信息”</li>
   * </ul>
   *
   * <p>题型特征：
   *
   * <ul>
   * <li>答案数组的每个位置都和当前位置本身有关，但不能直接用当前位置参与计算</li>
   * <li>本质不是“区间查询”，而是“左右信息拆开算，再在当前位置汇总”</li>
   * <li>题目禁止使用除法，因此不能偷换成“总乘积 / 当前值”</li>
   * </ul>
   *
   * <p>解题思路：
   *
   * <ol>
   * <li>先让 {@code answer[i]} 记录位置 {@code i} 左侧所有元素的乘积。</li>
   * <li>再用一个滚动变量 {@code suffixProduct} 维护当前位置右侧所有元素的乘积。</li>
   * <li>逆序遍历时，把左乘积和右乘积相乘，就得到最终答案。</li>
   * <li>这样不需要两份完整辅助数组，也不需要使用除法。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>时间复杂度是 {@code O(n)}，空间上也只额外用了一个滚动后缀变量。</li>
   * <li>很适合训练“先存左信息，再滚动补右信息”的前后缀压缩写法。</li>
   * </ul>
   *
   * <p>缺点 / 适用前提：
   *
   * <ul>
   * <li>依赖乘法关系能被自然拆成“左积 * 右积”。</li>
   * <li>如果题目换成别的不可逆聚合关系，不一定还能直接复用这个模板。</li>
   * </ul>
   *
   * <p>变体应对 / 注意事项：
   *
   * <ul>
   * <li>如果你一开始只想清楚了“两份数组法”，可以先那样写通，再压缩到当前版本。</li>
   * <li>这题和 `42` 一样，都属于“答案依赖左右两侧信息”的前后缀主线。</li>
   * </ul>
   */
  public int[] productExceptSelf(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new int[0];
    }

    int[] answer = new int[nums.length];
    answer[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      answer[i] = answer[i - 1] * nums[i - 1];
    }

    int suffixProduct = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      answer[i] = answer[i] * suffixProduct;
      suffixProduct *= nums[i];
    }
    return answer;
  }

  /**
   * 42. 接雨水
   *
   * <p>题目描述：
   *
   * <p>给定 {@code n} 个非负整数表示每个宽度为 {@code 1} 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
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
   * <li>可以思考前后缀数组、双指针、单调栈等多种写法</li>
   * <li>这里保留前后缀数组法，方便和 `ArrayQuestion2` 里的双指针对照</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>数组 / 前后缀分解</li>
   * <li>前后缀最大值</li>
   * </ul>
   *
   * <p>题型特征：
   *
   * <ul>
   * <li>某个位置的答案既依赖左边最高墙，也依赖右边最高墙</li>
   * <li>如果每个位置都回头向左、向右扫，会退化成暴力</li>
   * <li>这类题最适合先把左右信息独立预处理出来</li>
   * </ul>
   *
   * <p>解题思路：
   *
   * <ol>
   * <li>先预处理 {@code leftMax[i]}，表示位置 {@code i} 左侧含自身的最高柱子。</li>
   * <li>再预处理 {@code rightMax[i]}，表示位置 {@code i} 右侧含自身的最高柱子。</li>
   * <li>位置 {@code i} 的积水量就是 {@code min(leftMax[i], rightMax[i]) - height[i]}。</li>
   * <li>最后线性累加所有位置的积水量。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>公式直观，最适合第一次把这题讲清楚。</li>
   * <li>有助于你先建立“每个位置答案依赖左右两侧”的前后缀意识，再过渡到双指针优化。</li>
   * </ul>
   *
   * <p>缺点 / 适用前提：
   *
   * <ul>
   * <li>额外空间复杂度是 {@code O(n)}。</li>
   * <li>如果已经能稳定证明双指针正确性，这个版本在空间上就不是最优。</li>
   * </ul>
   *
   * <p>变体应对 / 注意事项：
   *
   * <ul>
   * <li>同一题还可以继续切到 `ArrayQuestion2` 里的双指针写法，训练“为什么可以先结算较弱一侧”。</li>
   * <li>这里的核心不是记公式，而是明确每个位置的水位上界由左右最高墙中的较小者决定。</li>
   * </ul>
   */
  public int trap(int[] height) {
    if (height == null || height.length <= 1) {
      return 0;
    }

    int[] leftMax = new int[height.length];
    int[] rightMax = new int[height.length];
    leftMax[0] = height[0];
    for (int i = 1; i < height.length; i++) {
      leftMax[i] = Math.max(leftMax[i - 1], height[i]);
    }

    rightMax[height.length - 1] = height[height.length - 1];
    for (int i = height.length - 2; i >= 0; i--) {
      rightMax[i] = Math.max(rightMax[i + 1], height[i]);
    }

    int water = 0;
    for (int i = 0; i < height.length; i++) {
      water += Math.min(leftMax[i], rightMax[i]) - height[i];
    }
    return water;
  }

  /**
   * 41. 缺失的第一个正数
   *
   * <p>题目描述：
   *
   * <p>给你一个未排序的整数数组 {@code nums}，请你找出其中没有出现的最小正整数。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int firstMissingPositive(int[] nums)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums = [1,2,0]
   * 输出：3
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums = [3,4,-1,1]
   * 输出：2
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>额外空间复杂度要求为 {@code O(1)}</li>
   * <li>当前保留原地标记实现，便于复盘“值和下标绑定”的核心思路</li>
   * </ul>
   */
  public int firstMissingPositive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 1;
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= 0) {
        nums[i] = nums.length + 1;
      }
    }

    for (int i = 0; i < nums.length; i++) {
      int val = Math.abs(nums[i]) - 1;
      if (val >= nums.length) {
        continue;
      }
      if (nums[val] > 0) {
        nums[val] = nums[val] * -1;
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        return i + 1;
      }
    }
    return nums.length + 1;
  }

  /**
   * 448. 找到所有数组中消失的数字
   *
   * <p>题目描述：
   *
   * <p>给你一个含有 {@code n} 个整数的数组 {@code nums}，其中 {@code nums[i]} 在区间 {@code [1, n]} 内。
   * 请你找出所有在 {@code [1, n]} 范围内但没有出现在 {@code nums} 中的数字，并以数组形式返回结果。
   *
   * <p>方法签名：
   *
   * <pre>
   * public List<Integer> findDisappearedNumbers(int[] nums)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：nums = [4,3,2,7,8,2,3,1]
   * 输出：[5,6]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(n)}</li>
   * <li>允许返回结果数组，但额外辅助空间尽量控制在 {@code O(1)}</li>
   * <li>当前保留原地标记实现，便于和 `41` 对照理解同类模式</li>
   * </ul>
   */
  public List<Integer> findDisappearedNumbers(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }

    for (int i = 0; i < nums.length; i++) {
      int val = Math.abs(nums[i]) - 1;
      if (nums[val] > 0) {
        nums[val] = -1 * nums[val];
      }
    }

    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        ans.add(i + 1);
      }
    }

    return ans;
  }

  /**
   * 34. 在排序数组中查找元素的第一个和最后一个位置
   *
   * <p>题目描述：
   *
   * <p>给定一个按非递减顺序排列的整数数组 {@code nums}，和一个目标值 {@code target}，
   * 请你找出 {@code target} 在数组中的起始位置和结束位置。
   * 如果数组中不存在 {@code target}，返回 {@code [-1, -1]}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int[] searchRange(int[] nums, int target)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：nums = [5,7,7,8,8,10], target = 8
   * 输出：[3,4]
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度必须达到 {@code O(log n)}</li>
   * <li>不接受命中后再线性向两边扩散的 {@code O(n)} 解法</li>
   * <li>返回下标按 {@code 0-based} 处理</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>二分查找 / 边界二分</li>
   * <li>代表“命中后不能直接返回，而要继续收缩边界”</li>
   * </ul>
   *
   * <p>题型特征：
   *
   * <ul>
   * <li>数组有序</li>
   * <li>不是找“某个命中位置”，而是找目标值出现区间的左右边界</li>
   * <li>边界问题通常要拆成两次二分，而不是在一次循环里硬塞所有逻辑</li>
   * </ul>
   *
   * <p>解题思路：
   *
   * <ol>
   * <li>第一次二分专门找左边界：命中后继续向左收缩。</li>
   * <li>如果左边界都不存在，说明目标值根本不在数组里，可以直接返回 {@code [-1, -1]}。</li>
   * <li>第二次二分专门找右边界：命中后继续向右收缩。</li>
   * <li>最后把左右边界拼成结果返回。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>模板清晰，边界二分的意图非常明确。</li>
   * <li>是 `704` 基础命中二分向“边界目标”扩展的最典型题。</li>
   * </ul>
   *
   * <p>缺点 / 适用前提：
   *
   * <ul>
   * <li>依赖数组有序。</li>
   * <li>如果没有统一好区间语义和收缩规则，左边界和右边界很容易一边对一边错。</li>
   * </ul>
   *
   * <p>变体应对 / 注意事项：
   *
   * <ul>
   * <li>如果只求第一个大于等于目标的位置，本质就是 lower bound。</li>
   * <li>如果只求任意命中位置，复杂度同样是 {@code O(log n)}，但不需要做两次边界二分。</li>
   * </ul>
   */
  public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return new int[] {-1, -1};
    }

    int leftBoundary = findLeftBoundary(nums, target);
    if (leftBoundary == -1) {
      return new int[] {-1, -1};
    }
    int rightBoundary = findRightBoundary(nums, target);
    return new int[] {leftBoundary, rightBoundary};
  }

  private int findLeftBoundary(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int answer = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        answer = mid;
        right = mid - 1;
      }
    }
    return answer;
  }

  private int findRightBoundary(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int answer = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        answer = mid;
        left = mid + 1;
      }
    }
    return answer;
  }

  /**
   * 33. 搜索旋转排序数组
   *
   * <p>题目描述：
   *
   * <p>整数数组 {@code nums} 按升序排列，数组中的值互不相同。
   * 在传递给函数之前，{@code nums} 在预先未知的某个下标上进行了旋转。
   * 给你旋转后的数组 {@code nums} 和一个整数 {@code target}，
   * 如果 {@code nums} 中存在这个目标值，则返回它的下标，否则返回 {@code -1}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int search(int[] nums, int target)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：nums = [4,5,6,7,0,1,2], target = 0
   * 输出：4
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(log n)}</li>
   * <li>数组中的值互不相同</li>
   * <li>不接受线性扫描解法</li>
   * </ul>
   *
   * <p>说明：
   *
   * <ul>
   * <li>为了避免和 `704` 的标准签名冲突，这里方法名写成 {@code searchRotated}</li>
   * <li>LeetCode 单独提交时仍使用题目原始方法名 {@code search}</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>二分查找 / 变体二分</li>
   * <li>代表“整体无序，但每轮总有一半区间保持有序”</li>
   * </ul>
   *
   * <p>题型特征：
   *
   * <ul>
   * <li>数组整体不是完全有序，但来自一个升序数组的旋转</li>
   * <li>每次二分后，左右两半一定有一半是单调有序的</li>
   * <li>关键不是普通比较，而是先判断“哪一半有序”</li>
   * </ul>
   *
   * <p>解题思路：
   *
   * <ol>
   * <li>每轮先取中点，如果直接命中就返回。</li>
   * <li>判断左半边是否有序：如果 {@code nums[left] <= nums[mid]}，说明左半边有序。</li>
   * <li>如果左半边有序，再判断目标值是否落在左半边有序区间里；如果是就收缩右边，否则收缩左边。</li>
   * <li>如果左半边无序，那右半边一定有序，对称处理即可。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>时间复杂度仍然是 {@code O(log n)}。</li>
   * <li>很适合作为“标准二分模板”向“条件判断型二分”过渡的代表题。</li>
   * </ul>
   *
   * <p>缺点 / 适用前提：
   *
   * <ul>
   * <li>当前实现依赖“数组元素互不相同”这个前提。</li>
   * <li>如果存在大量重复值，哪一半有序的判断会变得更麻烦，甚至最坏退化。</li>
   * </ul>
   *
   * <p>变体应对 / 注意事项：
   *
   * <ul>
   * <li>这题最容易错的是“右半边有序时”的区间比较方向。</li>
   * <li>如果后续补“含重复元素的旋转数组搜索”，重点就不再是模板，而是处理无法明确判断哪边有序的分支。</li>
   * </ul>
   */
  public int searchRotated(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[left] <= nums[mid]) {
        if (nums[left] <= target && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[mid] < target && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }

  /**
   * 704. 二分查找
   *
   * <p>题目描述：
   *
   * <p>给定一个 {@code n} 个元素有序的（升序）整型数组 {@code nums} 和一个目标值 {@code target}，
   * 写一个函数搜索 {@code nums} 中的 {@code target}，如果目标值存在返回下标，否则返回 {@code -1}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int search(int[] nums, int target)
   * </pre>
   *
   * <p>示例 1：
   *
   * <pre>
   * 输入：nums = [-1,0,3,5,9,12], target = 9
   * 输出：4
   * </pre>
   *
   * <p>示例 2：
   *
   * <pre>
   * 输入：nums = [-1,0,3,5,9,12], target = 2
   * 输出：-1
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度为 {@code O(log n)}</li>
   * <li>重点训练最基础的命中二分模板</li>
   * <li>当前保留可运行实现，便于和边界二分、答案空间二分统一对照</li>
   * </ul>
   *
   * <p>说明：
   *
   * <ul>
   * <li>为了避免和 `33` 的标准签名冲突，这里方法名写成 {@code binarySearchBasic}</li>
   * <li>LeetCode 单独提交时仍使用题目原始方法名 {@code search}</li>
   * </ul>
   */
  public int binarySearchBasic(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    if (target < nums[0] || target > nums[nums.length - 1]) {
      return -1;
    }

    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }

  /**
   * 875. 爱吃香蕉的珂珂
   *
   * <p>题目描述：
   *
   * <p>这里有 {@code n} 堆香蕉，第 {@code i} 堆中有 {@code piles[i]} 根香蕉。
   * 警卫将在 {@code h} 小时后回来。珂珂可以决定她吃香蕉的速度 {@code k}（单位：根 / 小时），
   * 每小时会选择一堆香蕉吃掉最多 {@code k} 根。返回她可以在 {@code h} 小时内吃掉所有香蕉的最小速度 {@code k}。
   *
   * <p>方法签名：
   *
   * <pre>
   * public int minEatingSpeed(int[] piles, int h)
   * </pre>
   *
   * <p>示例：
   *
   * <pre>
   * 输入：piles = [3,6,7,11], h = 8
   * 输出：4
   * </pre>
   *
   * <p>额外要求：
   *
   * <ul>
   * <li>目标时间复杂度尽量做到 {@code O(n log maxPile)}</li>
   * <li>返回的是满足条件的最小速度，而不是任意可行速度</li>
   * <li>重点说清“速度越大，总耗时越小”的单调性</li>
   * </ul>
   *
   * <p>本题在专题中的定位：
   *
   * <ul>
   * <li>二分查找 / 答案空间二分</li>
   * <li>代表“不是在数组里找值，而是在一段可能答案里找最小可行解”</li>
   * </ul>
   *
   * <p>题型特征：
   *
   * <ul>
   * <li>题目要找的是一个最小速度，而不是某个数组下标</li>
   * <li>存在明显单调性：速度越大，总耗时越小</li>
   * <li>很适合抽象成“某个答案是否可行”的判定函数</li>
   * </ul>
   *
   * <p>解题思路：
   *
   * <ol>
   * <li>先确定答案空间，速度最小是 {@code 1}，最大不会超过最大那一堆香蕉数。</li>
   * <li>对速度做二分，并用 {@code canFinish} 判断当前速度能否在 {@code h} 小时内吃完。</li>
   * <li>如果当前速度可行，就继续向左收缩，尝试更小速度。</li>
   * <li>如果当前速度不可行，就向右找更大的速度。</li>
   * </ol>
   *
   * <p>优点：
   *
   * <ul>
   * <li>时间复杂度是 {@code O(n log maxPile)}，远优于线性枚举所有速度。</li>
   * <li>是“最小可行值”类二分题的标准模板，迁移价值很高。</li>
   * </ul>
   *
   * <p>缺点 / 适用前提：
   *
   * <ul>
   * <li>依赖可行性函数具备单调性。</li>
   * <li>如果题目没有单调的“可行 / 不可行”边界，这个模板就不能直接套。</li>
   * </ul>
   *
   * <p>变体应对 / 注意事项：
   *
   * <ul>
   * <li>单堆耗时要做向上取整，这里用的是 {@code (pile + speed - 1) / speed}。</li>
   * <li>如果题目改成“最大化最小值”或“最小化最大值”，通常也值得先检查能否抽象成答案空间二分。</li>
   * </ul>
   */
  public int minEatingSpeed(int[] piles, int h) {
    if (piles == null || piles.length == 0 || piles.length > h) {
      return -1;
    }

    int maxPile = 0;
    for (int pile : piles) {
      maxPile = Math.max(maxPile, pile);
    }

    int left = 1;
    int right = maxPile;
    int answer = maxPile;
    while (left <= right) {
      int speed = left + (right - left) / 2;
      if (canFinish(piles, h, speed)) {
        answer = speed;
        right = speed - 1;
      } else {
        left = speed + 1;
      }
    }
    return answer;
  }

  private boolean canFinish(int[] piles, int h, int speed) {
    long totalHours = 0;
    for (int pile : piles) {
      totalHours += (pile + speed - 1) / speed;
      if (totalHours > h) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    ArrayQuestion4 arrayQuestion4 = new ArrayQuestion4();
//    System.out.println(Arrays.toString(arrayQuestion4.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8)));
//    System.out.println(arrayQuestion4.minEatingSpeed(new int[] {30, 11, 23, 4, 20}, 6));
    arrayQuestion4.firstMissingPositive(new int[] {1, 2, 0});
  }
}
