# 算法已做题台账与去重索引

最后更新：`2026-05-06`

## 1. 这份文档解决什么问题

这份文档不是算法专题正文，也不是当天刷题记录，而是给后续出题和排练提供一个稳定索引。

它主要解决 3 个问题：

- 当前到底已经做过哪些题
- 这些题分别覆盖了哪些核心模式
- 后续出题时，哪些题不要再重复，哪些题更适合接着补

一句话定位：

- 这是“当前练习进度 + 已覆盖模式 + 去重门禁”的统一台账

## 2. 状态定义

- `已完成`
  - 已经有本地实现，且可以视为已经实际练过
- `已完成（复刷）`
  - 这题此前已经做过，并且已按当前计划再次完成复刷
- `已初始化待做`
  - 已经建好题目骨架，但还没有完成实现
- `计划复刷`
  - 这题以前做过，但因为是薄弱点或模板题，需要按计划再做一遍
- `未开始`
  - 还没有本地题目文件，也还没有进入当前阶段的练习优先队列

## 3. 当前进度总览

| 专题 | 已完成 | 待做 / 复刷 | 当前说明 |
| --- | --- | --- | --- |
| 数组 | 17 | 0 | 已覆盖有序数组双指针、原地覆盖、稳定搬移、遍历与模拟、前后缀最大值，以及固定长度、种类数约束、容错型、统计型滑动窗口代表题 |
| 哈希表 | 17 | 2 | 补数查找、映射关系、分组归类、计数统计、前缀和主线已覆盖，Day32 仅剩结构设计题待做 |
| 链表 | 14 | 0 | 已覆盖 `dummy node`、快慢指针、中点/环入口、区间/分组反转、重排、奇偶拆分，以及链表 + 哈希表的高频代表题 |
| 栈 / 队列 / 单调栈 | 9 | 0 | 基础栈、辅助状态栈、表达式求值、调用栈模拟、单调栈边界题和贪心构造题已覆盖 |
| 字符串 | 6 | 12 | 已覆盖基础滑动窗口、模拟、固定长度窗口和复杂窗口题，Day34 已补出双指针 / 回文、字符串哈希、进阶窗口、解析模拟等 12 道代表题骨架 |
| 二分查找 | 3 | 0 | 已覆盖边界二分、变体二分、答案空间二分 |
| 二叉树 / DFS / BFS | 8 | 0 | 已完成 BFS、基础 DFS、前中后序遍历、树递归和信息归并题 |
| 堆 / 优先队列 | 3 | 0 | TopK、哈希 + 堆和堆合并链表已覆盖 |
| 回溯 | 4 | 0 | 模板题、剪枝回溯和状态约束题已覆盖 |
| 图 | 4 | 0 | DFS / BFS、多源 BFS、拓扑排序和 BFS 扩展题已覆盖 |
| 动态规划 | 4 | 0 | 入门模板、一维最值、完全背包和 LIS 已覆盖 |
| 贪心 | 4 | 0 | 覆盖范围、最少跳数、历史最优和区间贪心已覆盖 |

说明：

- 这里按“题目核心模式”计入专题，不强求一题只属于一个专题。
- 例如 `3. 无重复字符的最长子串`，虽然是字符串题，也可以视为滑动窗口题。

## 4. 已完成题目台账

| 题号 | 题目 | 归属专题 | 核心模式 | 状态 | 代码文件 |
| --- | --- | --- | --- | --- | --- |
| `238` | 除自身以外数组的乘积 | 数组 | 前后缀分解 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week1/day1/ArrayQuestion.java` |
| `128` | 最长连续序列 | 哈希表 | `HashSet` + 起点枚举 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week1/day1/ArrayQuestion.java` |
| `167` | 两数之和 II - 输入有序数组 | 数组 | 有序数组双指针 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week1/day2/ArrayQuestion2.java` |
| `11` | 盛最多水的容器 | 数组 | 左右夹逼双指针 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week1/day2/ArrayQuestion2.java` |
| `3` | 无重复字符的最长子串 | 字符串 / 滑动窗口 | 变长窗口 + 去重 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week1/day3/SlidingWindowQuestion1.java` |
| `209` | 长度最小的子数组 | 数组 / 滑动窗口 | 变长窗口 + 正数约束 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week1/day3/SlidingWindowQuestion2.java` |
| `560` | 和为 K 的子数组 | 哈希表 / 前缀和 | 前缀和 + 哈希计数 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week1/day4/PrefixSumHashQuestion1.java` |
| `525` | 连续数组 | 哈希表 / 前缀和 | 前缀和 + 最早位置 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week1/day4/PrefixSumHashQuestion2.java` |
| `34` | 在排序数组中查找元素的第一个和最后一个位置 | 二分查找 | 边界二分 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week1/day5/BinarySearchQuestion1.java` |
| `1` | 两数之和 | 哈希表 | 补数查找 + `HashMap` | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week1/day6/ArrayHashQuestion1.java` |
| `219` | 存在重复元素 II | 数组 / 哈希表 | 固定范围内存在性判断 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week1/day6/ArrayHashQuestion2.java` |
| `49` | 字母异位词分组 | 哈希表 / 字符串 | 分组归类 + 稳定 key | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day8/HashGroupingQuestion1.java` |
| `242` | 有效的字母异位词 | 哈希表 / 字符串 | 计数统计 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day8/HashCountingQuestion1.java` |
| `206` | 反转链表 | 链表 | 原地反转 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day9/LinkedListQuestion1.java` |
| `21` | 合并两个有序链表 | 链表 | `dummy node` + 拼接 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day9/LinkedListQuestion2.java` |
| `141` | 环形链表 | 链表 | 快慢指针判环 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day10/FastSlowPointerQuestion1.java` |
| `19` | 删除链表的倒数第 N 个结点 | 链表 | 快慢指针 + `dummy node` | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day10/FastSlowPointerQuestion2.java` |
| `20` | 有效的括号 | 栈 | 普通栈匹配 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day11/StackQueueQuestion1.java` |
| `155` | 最小栈 | 栈 | 辅助状态栈 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day11/StackQueueQuestion2.java` |
| `739` | 每日温度 | 单调栈 | 最近更大元素 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day12/MonotonicStackQuestion1.java` |
| `496` | 下一个更大元素 I | 单调栈 | 最近更大元素 + 哈希映射 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day12/MonotonicStackQuestion2.java` |
| `33` | 搜索旋转排序数组 | 二分查找 | 变体二分 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day13/BinarySearchQuestion1.java` |
| `875` | 爱吃香蕉的珂珂 | 二分查找 | 答案空间二分 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day13/BinarySearchQuestion2.java` |
| `102` | 二叉树的层序遍历 | 二叉树 / BFS | BFS 模板 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day15/TreeBfsQuestion1.java` |
| `104` | 二叉树的最大深度 | 二叉树 / DFS | DFS 模板 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day15/TreeDfsQuestion1.java` |
| `94` | 二叉树的中序遍历 | 二叉树 | 遍历模板 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day16/TreeTraversalQuestion1.java` |
| `144` | 二叉树的前序遍历 | 二叉树 | 遍历模板 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day16/TreeTraversalQuestion2.java` |
| `145` | 二叉树的后序遍历 | 二叉树 | 遍历模板 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day16/TreeTraversalQuestion3.java` |
| `226` | 翻转二叉树 | 二叉树 | 树递归基础 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day16/TreeRecursionQuestion1.java` |
| `543` | 二叉树的直径 | 二叉树 / DFS | 后序 DFS | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day17/TreeDfsQuestion2.java` |
| `236` | 二叉树的最近公共祖先 | 二叉树 | 递归信息归并 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day17/TreeRecursionQuestion2.java` |
| `215` | 数组中的第 K 个最大元素 | 堆 | TopK 小顶堆 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day18/HeapQuestion1.java` |
| `347` | 前 K 个高频元素 | 哈希表 / 堆 | 哈希统计 + 堆 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day18/HeapQuestion2.java` |
| `23` | 合并 K 个升序链表 | 链表 / 堆 | 堆和链表结合 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day19/HeapLinkedListQuestion1.java` |
| `415` | 字符串相加 | 字符串 | 从后往前模拟 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day19/StringSimulationQuestion1.java` |
| `438` | 找到字符串中所有字母异位词 | 字符串 / 滑动窗口 | 固定长度窗口 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day20/StringWindowQuestion1.java` |
| `76` | 最小覆盖子串 | 字符串 / 滑动窗口 | 复杂窗口题 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day20/StringWindowQuestion2.java` |
| `46` | 全排列 | 回溯 | 回溯模板 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day22/BacktrackingQuestion1.java` |
| `78` | 子集 | 回溯 | 回溯树展开 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day22/BacktrackingQuestion2.java` |
| `39` | 组合总和 | 回溯 | 剪枝回溯 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day23/BacktrackingQuestion3.java` |
| `22` | 括号生成 | 回溯 | 状态约束回溯 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day23/BacktrackingQuestion4.java` |
| `200` | 岛屿数量 | 图 | DFS / BFS | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day24/GraphTraversalQuestion1.java` |
| `994` | 腐烂的橘子 | 图 | 多源 BFS | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day24/GraphTraversalQuestion2.java` |
| `207` | 课程表 | 图 | 拓扑排序 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day25/GraphQuestion1.java` |
| `127` | 单词接龙 | 图 | BFS 扩展 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day25/GraphQuestion2.java` |
| `70` | 爬楼梯 | 动态规划 | DP 入门模板 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day26/DpQuestion1.java` |
| `198` | 打家劫舍 | 动态规划 | 一维 DP | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day26/DpQuestion2.java` |
| `322` | 零钱兑换 | 动态规划 | 完全背包 / DP 进阶 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day27/DpQuestion3.java` |
| `300` | 最长递增子序列 | 动态规划 | DP 高频题 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day27/DpQuestion4.java` |
| `55` | 跳跃游戏 | 贪心 | 覆盖范围 / 可达性 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day29/GreedyQuestion1.java` |
| `121` | 买卖股票的最佳时机 | 贪心 | 历史最优状态 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day29/GreedyQuestion2.java` |
| `45` | 跳跃游戏 II | 贪心 | 覆盖范围 / 最少跳数 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day30/GreedyQuestion1.java` |
| `435` | 无重叠区间 | 贪心 | 区间选择 / 按结束排序 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day30/GreedyQuestion2.java` |
| `485` | 最大连续 1 的个数 | 数组 / 滑动窗口 | 窗口内 0 个数约束 / 右开区间窗口复习 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/SlidingWindowReviewQuestion1.java` |
| `643` | 子数组最大平均数 I | 数组 / 滑动窗口 | 固定长度窗口 / 区间和维护 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/SlidingWindowReviewQuestion1.java` |
| `904` | 水果成篮 | 数组 / 滑动窗口 | 变长窗口 / 最长合法区间 / 种类数约束 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/SlidingWindowReviewQuestion1.java` |
| `1004` | 最大连续 1 的个数 III | 数组 / 滑动窗口 | 容错型窗口 / 坏元素计数 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/SlidingWindowReviewQuestion1.java` |
| `713` | 乘积小于 K 的子数组 | 数组 / 滑动窗口 | 统计型窗口 / 正数乘积约束 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/SlidingWindowReviewQuestion1.java` |
| `217` | 存在重复元素 | 哈希表 | `HashSet` 存在性判断 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashExistenceQuestion1.java` |
| `205` | 同构字符串 | 哈希表 | 双向映射关系 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashMappingQuestion1.java` |
| `169` | 多数元素 | 哈希表 | 计数统计 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashCountingQuestion1.java` |
| `249` | 移位字符串分组 | 哈希表 / 字符串 | 分组归类 / 稳定 key 设计 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashGroupingQuestion1.java` |
| `974` | 和可被 K 整除的子数组 | 哈希表 / 前缀和 | 前缀和 + 余数计数 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/PrefixSumHashQuestion1.java` |
| `290` | 单词规律 | 哈希表 / 字符串 | 双向映射关系 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashMappingQuestion2.java` |
| `523` | 连续的子数组和 | 哈希表 / 前缀和 | 前缀和 + 最早位置 / 余数位置映射 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/PrefixSumHashQuestion2.java` |
| `930` | 和相同的二元子数组 | 哈希表 / 前缀和 | 前缀和 + 哈希计数 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/PrefixSumHashQuestion3.java` |
| `325` | 和等于 k 的最长子数组长度 | 哈希表 / 前缀和 | 前缀和 + 最早位置 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/PrefixSumHashQuestion4.java` |
| `146` | LRU 缓存 | 哈希表 / 设计 | 哈希表 + 双向链表 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashStructureDesignQuestion1.java` |
| `380` | O(1) 时间插入、删除和获取随机元素 | 哈希表 / 设计 | 哈希表 + 动态数组 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashStructureDesignQuestion2.java` |
| `203` | 移除链表元素 | 链表 | `dummy node` / 删除节点 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day33/LinkedListDummyNodeQuestion1.java` |
| `24` | 两两交换链表中的节点 | 链表 | `dummy node` / 局部交换拼接 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day33/LinkedListDummyNodeQuestion1.java` |
| `876` | 链表的中间结点 | 链表 | 快慢指针 / 中点定位 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day33/LinkedListFastSlowPointerQuestion1.java` |
| `142` | 环形链表 II | 链表 | 快慢指针 / 找环入口 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day33/LinkedListFastSlowPointerQuestion1.java` |
| `92` | 反转链表 II | 链表 | 原地反转 / 区间反转 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day33/LinkedListReverseQuestion1.java` |
| `25` | K 个一组翻转链表 | 链表 | 原地反转 / 分组反转 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day33/LinkedListReverseQuestion1.java` |
| `143` | 重排链表 | 链表 | 找中点 + 反转后半段 + 交替合并 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day33/LinkedListReorderQuestion1.java` |
| `328` | 奇偶链表 | 链表 | 分段拆分 + 拼接 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day33/LinkedListReorderQuestion1.java` |
| `138` | 随机链表的复制 | 链表 | 链表 + 哈希表 / 节点映射 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day33/LinkedListHashQuestion1.java` |
| `567` | 字符串的排列 | 字符串 / 滑动窗口 | 固定长度窗口 / 频次匹配 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringWindowQuestion2.java` |
| `424` | 替换后的最长重复字符 | 字符串 / 滑动窗口 | 容错型窗口 / 最高频字符约束 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringWindowQuestion2.java` |
| `30` | 串联所有单词的子串 | 字符串 / 滑动窗口 | 分组滑动窗口 / 固定单词长度 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringWindowQuestion2.java` |
| `344` | 反转字符串 | 字符串 | 双指针 / 左右夹逼 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringTwoPointerQuestion1.java` |
| `125` | 验证回文串 | 字符串 | 双指针 / 回文判断 + 字符过滤 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringTwoPointerQuestion1.java` |
| `680` | 验证回文串 II | 字符串 | 双指针 / 一次容错回文 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringTwoPointerQuestion1.java` |
| `383` | 赎金信 | 字符串 / 哈希表 | 字符计数统计 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringHashQuestion1.java` |
| `387` | 字符串中的第一个唯一字符 | 字符串 / 哈希表 | 计数后按原顺序找答案 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringHashQuestion1.java` |
| `890` | 查找和替换模式 | 字符串 / 哈希表 | 双向映射关系 / 模式匹配 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringHashQuestion1.java` |
| `8` | 字符串转换整数 (atoi) | 字符串 | 模拟与解析 / 边界控制 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringSimulationQuestion2.java` |
| `71` | 简化路径 | 字符串 | 模拟与解析 / 路径语义 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringSimulationQuestion2.java` |
| `43` | 字符串相乘 | 字符串 | 模拟与解析 / 大数运算 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringSimulationQuestion2.java` |
| `88` | 合并两个有序数组 | 数组 | 遍历与模拟 / 原地合并 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion.java` |
| `54` | 螺旋矩阵 | 数组 | 遍历与模拟 / 边界收缩 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion.java` |
| `59` | 螺旋矩阵 II | 数组 | 遍历与模拟 / 边界收缩 + 按序填充 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion.java` |
| `26` | 删除有序数组中的重复项 | 数组 | 快慢指针 / 原地去重覆盖 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion2.java` |
| `27` | 移除元素 | 数组 | 快慢指针 / 原地过滤覆盖 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion2.java` |
| `283` | 移动零 | 数组 | 快慢指针 / 稳定搬移 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion2.java` |
| `42` | 接雨水 | 数组 / 前后缀 / 双指针 | 前后缀最大值 + 左右夹逼逐步结算 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion2.java` |
| `1475` | 商品折扣后的最终价格 | 单调栈 | 右侧第一个小于等于元素 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/MonotonicStackQuestion1.java` |
| `84` | 柱状图中最大的矩形 | 单调栈 | 左右最近更小元素 / 边界扩展 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/MonotonicStackQuestion1.java` |
| `316` | 去除重复字母 | 单调栈 | 单调栈 + 贪心构造最小子序列 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/MonotonicStackQuestion1.java` |
| `150` | 逆波兰表达式求值 | 栈 | 表达式求值栈 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/StackQuestion.java` |
| `636` | 函数的独占时间 | 栈 | 调用栈模拟 + 时间切片结算 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/StackQuestion.java` |

## 5. 当前阶段题目进度

| Day | 题号 | 题目 | 归属专题 | 核心模式 | 状态 | 代码文件 |
| --- | --- | --- | --- | --- | --- | --- |
| Day7 | `560` | 和为 K 的子数组 | 哈希表 / 前缀和 | 前缀和 + 哈希计数 | 已完成（复刷） | `code/algorithm/src/main/java/com/leisure/note/algorithm/week1/day7/PrefixSumHashReviewQuestion1.java` |
| Day8 | `49` | 字母异位词分组 | 哈希表 / 字符串 | 分组归类 + 稳定 key | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day8/HashGroupingQuestion1.java` |
| Day8 | `242` | 有效的字母异位词 | 哈希表 / 字符串 | 计数统计 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day8/HashCountingQuestion1.java` |
| Day9 | `206` | 反转链表 | 链表 | 原地反转 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day9/LinkedListQuestion1.java` |
| Day9 | `21` | 合并两个有序链表 | 链表 | `dummy node` + 拼接 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day9/LinkedListQuestion2.java` |
| Day10 | `141` | 环形链表 | 链表 | 快慢指针判环 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day10/FastSlowPointerQuestion1.java` |
| Day10 | `19` | 删除链表的倒数第 N 个结点 | 链表 | 快慢指针 + `dummy node` | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day10/FastSlowPointerQuestion2.java` |
| Day11 | `20` | 有效的括号 | 栈 | 普通栈匹配 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day11/StackQueueQuestion1.java` |
| Day11 | `155` | 最小栈 | 栈 | 辅助状态栈 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day11/StackQueueQuestion2.java` |
| Day12 | `739` | 每日温度 | 单调栈 | 最近更大元素 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day12/MonotonicStackQuestion1.java` |
| Day12 | `496` | 下一个更大元素 I | 单调栈 | 最近更大元素 + 哈希映射 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day12/MonotonicStackQuestion2.java` |
| Day13 | `33` | 搜索旋转排序数组 | 二分查找 | 变体二分 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day13/BinarySearchQuestion1.java` |
| Day13 | `875` | 爱吃香蕉的珂珂 | 二分查找 | 答案空间二分 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day13/BinarySearchQuestion2.java` |
| Day14 | 专题验收 | Week2 Day14 算法专题验收清单 | 综合复盘 | 哈希 / 链表 / 单调栈 / 二分专题验收 | 已初始化待做 | `prepare/2026/tracks/xiaomi_java_data_service/algorithms/week2_day14_review_checklist.md` |
| Day15 | `102` | 二叉树的层序遍历 | 二叉树 / BFS | BFS 模板 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day15/TreeBfsQuestion1.java` |
| Day15 | `104` | 二叉树的最大深度 | 二叉树 / DFS | DFS 模板 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day15/TreeDfsQuestion1.java` |
| Day16 | `94` | 二叉树的中序遍历 | 二叉树 | 遍历模板 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day16/TreeTraversalQuestion1.java` |
| Day16 | `144` | 二叉树的前序遍历 | 二叉树 | 遍历模板 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day16/TreeTraversalQuestion2.java` |
| Day16 | `145` | 二叉树的后序遍历 | 二叉树 | 遍历模板 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day16/TreeTraversalQuestion3.java` |
| Day16 | `226` | 翻转二叉树 | 二叉树 | 树递归基础 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day16/TreeRecursionQuestion1.java` |
| Day17 | `543` | 二叉树的直径 | 二叉树 / DFS | 后序 DFS | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day17/TreeDfsQuestion2.java` |
| Day17 | `236` | 二叉树的最近公共祖先 | 二叉树 | 递归信息归并 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day17/TreeRecursionQuestion2.java` |
| Day18 | `215` | 数组中的第 K 个最大元素 | 堆 | TopK 小顶堆 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day18/HeapQuestion1.java` |
| Day18 | `347` | 前 K 个高频元素 | 哈希表 / 堆 | 哈希统计 + 堆 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day18/HeapQuestion2.java` |
| Day19 | `23` | 合并 K 个升序链表 | 链表 / 堆 | 堆和链表结合 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day19/HeapLinkedListQuestion1.java` |
| Day19 | `415` | 字符串相加 | 字符串 | 从后往前模拟 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day19/StringSimulationQuestion1.java` |
| Day20 | `438` | 找到字符串中所有字母异位词 | 字符串 / 滑动窗口 | 固定长度窗口 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day20/StringWindowQuestion1.java` |
| Day20 | `76` | 最小覆盖子串 | 字符串 / 滑动窗口 | 复杂窗口题 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day20/StringWindowQuestion2.java` |
| Day22 | `46` | 全排列 | 回溯 | 回溯模板 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day22/BacktrackingQuestion1.java` |
| Day22 | `78` | 子集 | 回溯 | 回溯树展开 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day22/BacktrackingQuestion2.java` |
| Day23 | `39` | 组合总和 | 回溯 | 剪枝回溯 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day23/BacktrackingQuestion3.java` |
| Day23 | `22` | 括号生成 | 回溯 | 状态约束回溯 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day23/BacktrackingQuestion4.java` |
| Day24 | `200` | 岛屿数量 | 图 | DFS / BFS | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day24/GraphTraversalQuestion1.java` |
| Day24 | `994` | 腐烂的橘子 | 图 | 多源 BFS | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day24/GraphTraversalQuestion2.java` |
| Day25 | `207` | 课程表 | 图 | 拓扑排序 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day25/GraphQuestion1.java` |
| Day25 | `127` | 单词接龙 | 图 | BFS 扩展 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day25/GraphQuestion2.java` |
| Day26 | `70` | 爬楼梯 | 动态规划 | DP 入门模板 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day26/DpQuestion1.java` |
| Day26 | `198` | 打家劫舍 | 动态规划 | 一维 DP | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day26/DpQuestion2.java` |
| Day27 | `322` | 零钱兑换 | 动态规划 | 完全背包 / DP 进阶 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day27/DpQuestion3.java` |
| Day27 | `300` | 最长递增子序列 | 动态规划 | DP 高频题 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day27/DpQuestion4.java` |
| Day29 | `55` | 跳跃游戏 | 贪心 | 覆盖范围 / 可达性 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day29/GreedyQuestion1.java` |
| Day29 | `121` | 买卖股票的最佳时机 | 贪心 | 历史最优状态 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day29/GreedyQuestion2.java` |
| Day30 | `45` | 跳跃游戏 II | 贪心 | 覆盖范围 / 最少跳数 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day30/GreedyQuestion1.java` |
| Day30 | `435` | 无重叠区间 | 贪心 | 区间选择 / 按结束排序 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day30/GreedyQuestion2.java` |
| Day31 | `485` | 最大连续 1 的个数 | 数组 / 滑动窗口 | 窗口内 0 个数约束 / 右开区间窗口复习 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/SlidingWindowReviewQuestion1.java` |
| Day31 | `643` | 子数组最大平均数 I | 数组 / 滑动窗口 | 固定长度窗口 / 区间和维护 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/SlidingWindowReviewQuestion1.java` |
| Day31 | `904` | 水果成篮 | 数组 / 滑动窗口 | 变长窗口 / 最长合法区间 / 种类数约束 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/SlidingWindowReviewQuestion1.java` |
| Day31 | `1004` | 最大连续 1 的个数 III | 数组 / 滑动窗口 | 容错型窗口 / 坏元素计数 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/SlidingWindowReviewQuestion1.java` |
| Day31 | `713` | 乘积小于 K 的子数组 | 数组 / 滑动窗口 | 统计型窗口 / 正数乘积约束 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/SlidingWindowReviewQuestion1.java` |
| Day32 | `217` | 存在重复元素 | 哈希表 | `HashSet` 存在性判断 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashExistenceQuestion1.java` |
| Day32 | `205` | 同构字符串 | 哈希表 | 双向映射关系 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashMappingQuestion1.java` |
| Day32 | `169` | 多数元素 | 哈希表 | 计数统计 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashCountingQuestion1.java` |
| Day32 | `249` | 移位字符串分组 | 哈希表 / 字符串 | 分组归类 / 稳定 key 设计 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashGroupingQuestion1.java` |
| Day32 | `974` | 和可被 K 整除的子数组 | 哈希表 / 前缀和 | 前缀和 + 余数计数 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/PrefixSumHashQuestion1.java` |
| Day32 | `290` | 单词规律 | 哈希表 / 字符串 | 双向映射关系 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashMappingQuestion2.java` |
| Day32 | `523` | 连续的子数组和 | 哈希表 / 前缀和 | 前缀和 + 最早位置 / 余数位置映射 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/PrefixSumHashQuestion2.java` |
| Day32 | `930` | 和相同的二元子数组 | 哈希表 / 前缀和 | 前缀和 + 哈希计数 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/PrefixSumHashQuestion3.java` |
| Day32 | `325` | 和等于 k 的最长子数组长度 | 哈希表 / 前缀和 | 前缀和 + 最早位置 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/PrefixSumHashQuestion4.java` |
| Day32 | `146` | LRU 缓存 | 哈希表 / 设计 | 哈希表 + 双向链表 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashStructureDesignQuestion1.java` |
| Day32 | `380` | O(1) 时间插入、删除和获取随机元素 | 哈希表 / 设计 | 哈希表 + 动态数组 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashStructureDesignQuestion2.java` |
| Day33 | `203` | 移除链表元素 | 链表 | `dummy node` / 删除节点 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day33/LinkedListDummyNodeQuestion1.java` |
| Day33 | `24` | 两两交换链表中的节点 | 链表 | `dummy node` / 局部交换拼接 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day33/LinkedListDummyNodeQuestion1.java` |
| Day33 | `876` | 链表的中间结点 | 链表 | 快慢指针 / 中点定位 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day33/LinkedListFastSlowPointerQuestion1.java` |
| Day33 | `142` | 环形链表 II | 链表 | 快慢指针 / 找环入口 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day33/LinkedListFastSlowPointerQuestion1.java` |
| Day33 | `92` | 反转链表 II | 链表 | 原地反转 / 区间反转 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day33/LinkedListReverseQuestion1.java` |
| Day33 | `25` | K 个一组翻转链表 | 链表 | 原地反转 / 分组反转 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day33/LinkedListReverseQuestion1.java` |
| Day33 | `143` | 重排链表 | 链表 | 找中点 + 反转后半段 + 交替合并 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day33/LinkedListReorderQuestion1.java` |
| Day33 | `328` | 奇偶链表 | 链表 | 分段拆分 + 拼接 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day33/LinkedListReorderQuestion1.java` |
| Day33 | `138` | 随机链表的复制 | 链表 | 链表 + 哈希表 / 节点映射 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day33/LinkedListHashQuestion1.java` |
| Day34 | `567` | 字符串的排列 | 字符串 / 滑动窗口 | 固定长度窗口 / 频次匹配 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringWindowQuestion2.java` |
| Day34 | `424` | 替换后的最长重复字符 | 字符串 / 滑动窗口 | 容错型窗口 / 最高频字符约束 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringWindowQuestion2.java` |
| Day34 | `30` | 串联所有单词的子串 | 字符串 / 滑动窗口 | 分组滑动窗口 / 固定单词长度 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringWindowQuestion2.java` |
| Day34 | `344` | 反转字符串 | 字符串 | 双指针 / 左右夹逼 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringTwoPointerQuestion1.java` |
| Day34 | `125` | 验证回文串 | 字符串 | 双指针 / 回文判断 + 字符过滤 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringTwoPointerQuestion1.java` |
| Day34 | `680` | 验证回文串 II | 字符串 | 双指针 / 一次容错回文 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringTwoPointerQuestion1.java` |
| Day34 | `383` | 赎金信 | 字符串 / 哈希表 | 字符计数统计 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringHashQuestion1.java` |
| Day34 | `387` | 字符串中的第一个唯一字符 | 字符串 / 哈希表 | 计数后按原顺序找答案 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringHashQuestion1.java` |
| Day34 | `890` | 查找和替换模式 | 字符串 / 哈希表 | 双向映射关系 / 模式匹配 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringHashQuestion1.java` |
| Day34 | `8` | 字符串转换整数 (atoi) | 字符串 | 模拟与解析 / 边界控制 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringSimulationQuestion2.java` |
| Day34 | `71` | 简化路径 | 字符串 | 模拟与解析 / 路径语义 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringSimulationQuestion2.java` |
| Day34 | `43` | 字符串相乘 | 字符串 | 模拟与解析 / 大数运算 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day34/StringSimulationQuestion2.java` |
| Day31 | `739` | 每日温度 | 单调栈 | 最近更大元素 | 已完成（复刷） | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/MonotonicStackQuestion1.java` |
| Day31 | `1475` | 商品折扣后的最终价格 | 单调栈 | 右侧第一个小于等于元素 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/MonotonicStackQuestion1.java` |
| Day31 | `84` | 柱状图中最大的矩形 | 单调栈 | 左右最近更小元素 / 边界扩展 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/MonotonicStackQuestion1.java` |
| Day31 | `316` | 去除重复字母 | 单调栈 | 单调栈 + 贪心构造最小子序列 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/MonotonicStackQuestion1.java` |
| Day31 | `150` | 逆波兰表达式求值 | 栈 | 表达式求值栈 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/StackQuestion.java` |
| Day31 | `636` | 函数的独占时间 | 栈 | 调用栈模拟 + 时间切片结算 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/StackQuestion.java` |
| Day31 | `88` | 合并两个有序数组 | 数组 | 遍历与模拟 / 原地合并 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion.java` |
| Day31 | `54` | 螺旋矩阵 | 数组 | 遍历与模拟 / 边界收缩 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion.java` |
| Day31 | `59` | 螺旋矩阵 II | 数组 | 遍历与模拟 / 边界收缩 + 按序填充 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion.java` |
| Day31 | `26` | 删除有序数组中的重复项 | 数组 | 快慢指针 / 原地去重覆盖 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion2.java` |
| Day31 | `27` | 移除元素 | 数组 | 快慢指针 / 原地过滤覆盖 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion2.java` |
| Day31 | `283` | 移动零 | 数组 | 快慢指针 / 稳定搬移 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion2.java` |
| Day31 | `42` | 接雨水 | 数组 / 前后缀 / 双指针 | 前后缀最大值 + 左右夹逼逐步结算 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion2.java` |

## 6. 已覆盖模式索引

这一节不是按题号看，而是按“核心解法模式”看，方便后续出题查重。

### 6.1 数组 / 双指针

- `遍历与模拟`
  - 已覆盖题：`88`、`54`、`59`
  - 已掌握内容：
    - `88`：从后往前原地合并，避免覆盖 `nums1` 里还没处理的有效元素
    - `54`：螺旋读取时要同时控制方向切换和“是否访问过”
    - `59`：螺旋填充时核心是按方向推进，并在越界或遇到已填位置时转向
  - 近期不优先再出：
    - 纯同构的基础螺旋遍历 / 螺旋填充题

- `原地覆盖 / 快慢指针`
  - 已覆盖题：`26`、`27`、`283`
  - 已掌握内容：
    - `26`：有序数组里，`slow` 维护去重结果尾部，`fast` 扫描新值
    - `27`：只把需要保留的元素连续写回前缀，后缀内容无需关心
    - `283`：先稳定压缩非零元素，再统一补零，和“可乱序删除”类题不同
  - 近期不优先再出：
    - 与 `26`、`27`、`283` 高度同构的基础原地覆盖题
  - 后续更适合补：
    - 带重复上限控制的快慢指针题，例如“删除有序数组中的重复项 II”

- `有序数组配对`
  - 已覆盖题：`167`
  - 已掌握内容：
    - 左右指针为什么不会漏解
    - 有序数组上如何利用单调性
  - 近期不优先再出：
    - 同类“有序数组 + 配对求和”双指针题

- `左右夹逼`
  - 已覆盖题：`11`、`42`
  - 已掌握内容：
    - `11`：容器题里为什么移动短板才可能变优
    - `42`：当 `leftMax <= rightMax` 时，可以先结算左侧当前位置，不必等右边全部扫完
  - 近期不优先再出：
    - 纯基础的左右夹逼容量题
  - 后续更适合补：
    - `41`

### 6.2 滑动窗口

- `基础变长窗口`
  - 已覆盖题：`3`、`209`、`485`、`904`
  - 已掌握内容：
    - 合法窗口定义
    - 何时扩张、何时收缩
    - `[left, right]` 和 `[left, right)` 两种边界语义的区别
    - 右边界是否已经入窗，决定了 `right` 能不能暂时不推进
    - 窗口状态不一定只是和或坏元素计数，也可能是“窗口内不同元素种类数”
  - 近期不优先再出：
    - 另一个纯基础变长窗口模板题

- `固定长度窗口`
  - 已覆盖题：`438`、`643`
  - 已掌握内容：
    - 固定窗口大小时，进入 / 离开窗口的更新顺序
    - 频次统计和窗口匹配判断
    - 当窗口长度恰好达到目标值时，答案必须当场更新，不能拖到下一轮
  - 已初始化题：
    - `567`
  - 近期不优先再出：
    - 纯同构的基础固定窗口题

- `复杂窗口`
  - 已覆盖题：`76`
  - 已掌握内容：
    - 先满足覆盖条件，再尽量收缩窗口
    - 多状态计数和“何时窗口重新不合法”的判断
  - 已初始化题：
    - `30`
  - 近期不优先再出：
    - 纯同构的最小覆盖类窗口题

- `容错型窗口`
  - 已覆盖题：
    - `1004`
  - 已掌握内容：
    - 合法条件从“坏元素必须为 0”放宽到“坏元素最多为 k”
    - 和 `485` 对照着看，最容易建立窗口修复直觉
  - 已初始化题：
    - `424`

- `统计型窗口`
  - 已覆盖题：
    - `713`
  - 已掌握内容：
    - 不只是求最长/最短，而是统计满足条件的连续区间个数
    - 当右端点固定时，为什么可以一次性加上 `right - left`

### 6.3 前后缀 / 前缀和

- `前后缀分解`
  - 已覆盖题：`238`
  - 已掌握内容：
    - 左右信息拆分
    - 如何避免暴力枚举左右两边
  - 近期不优先再出：
    - 纯同构的前后缀乘积 / 前后缀数组题

- `前后缀最大值`
  - 已覆盖题：`42`
  - 已掌握内容：
    - 位置 `i` 的积水量由 `min(leftMax[i], rightMax[i]) - height[i]` 决定
    - 前后缀数组法更适合先把全局公式和每个位置的结算逻辑讲清楚
    - 同一题还能继续切到双指针写法，做空间优化和正确性证明
  - 近期不优先再出：
    - 纯同构的基础接水题

- `前缀和 + 哈希计数`
  - 已覆盖题：`560`、`974`、`930`
  - 已掌握内容：
    - 区间和转前缀差
    - map 存“次数”
  - 近期不优先再出：
    - 另一个基础“统计区间个数”的前缀和哈希题
  - 后续更适合补：
    - 结合 `525` 做对照复盘，而不是继续堆同类题

- `前缀和 + 最早位置`
  - 已覆盖题：`525`、`523`、`325`
  - 已掌握内容：
    - map 存“最早位置”
    - 和 `560` 的状态差异
  - 近期不优先再出：
    - 同构的“最长长度型前缀和”基础题
  - 后续更适合补：
    - 先把 `560` / `525` 讲透

### 6.4 哈希表

- `HashSet` 存在性判断 + 起点枚举
  - 已覆盖题：`128`、`217`
  - 已掌握内容：
    - set 做存在性判断
    - 为什么只从起点开始枚举
  - 近期不优先再出：
    - 过于简单的 set 存在性模板题
  - 后续更适合补：
    - `49`
    - `347`

- `HashMap` 补数查找 / 映射关系
  - 已覆盖题：`1`、`205`、`290`
  - 已掌握内容：
    - 先查再放
    - 补数匹配
  - 近期不优先再出：
    - 纯基础的补数查找模板题

- `HashMap` 计数统计
  - 已覆盖题：`242`、`347`、`169`
  - 已掌握内容：
    - 固定字符集时优先数组计数
    - 统计频次后再做筛选或 TopK
  - 近期不优先再出：
    - 与 `242` 高度同构的基础计数题

- `窗口内存在性判断`
  - 已覆盖题：`219`
  - 已掌握内容：
    - 只保留最近一次出现的位置
    - 判断是否满足索引距离约束
  - 近期不优先再出：
    - 与 `219` 高度同构的基础存在性判断题

- `HashMap` 分组归类
  - 已覆盖题：`49`、`249`
  - 已掌握内容：
    - 用稳定 key 做分桶
    - 排序 key 和计数签名 key 的取舍
  - 近期不优先再出：
    - 与 `49` 高度同构的基础分组归类题

- `哈希结构设计`
  - 已初始化题：
    - `146`
    - `380`
  - 当前关注点：
    - 不再只是调用 `HashMap` / `HashSet`，而是思考哈希结构如何和链表、数组配合
    - 面试里非常容易作为“会不会只做模板题”的区分题

### 6.4.1 字符串补充模式

- `双指针 / 回文判断`
  - 已初始化题：
    - `344`
    - `125`
    - `680`
  - 当前关注点：
    - 先区分“纯双指针反转”“回文判断”“带一次容错的回文判断”三种写法
    - 先把字符过滤、大小写归一化和主体比较逻辑拆开，再编码

- `字符串哈希统计 / 映射`
  - 已初始化题：
    - `383`
    - `387`
    - `890`
  - 当前关注点：
    - `383` 和 `387` 继续练字符计数，但一个是“能否构成”，一个是“按原顺序找答案”
    - `890` 属于字符串里的双向映射关系题，和 `205`、`290` 是一条主线

- `字符串模拟与解析`
  - 已初始化题：
    - `8`
    - `71`
    - `43`
  - 当前关注点：
    - `8` 重点在多条件解析和溢出边界
    - `71` 重点在路径片段语义和分段处理
    - `43` 重点在多位乘积累积位置和进位管理

### 6.5 二分查找

- `边界二分`
  - 已覆盖题：`34`
  - 已掌握内容：
    - 左边界、右边界分别找
  - 近期不优先再出：
    - 另一个纯基础边界二分题
  - 后续更适合补：
    - `875` 这类答案空间二分

- `变体二分`
  - 已覆盖题：`33`
  - 已掌握内容：
    - 旋转数组里每轮判断哪一半有序
    - 根据目标值是否落在有序区间里决定收缩方向
  - 近期不优先再出：
    - 纯同构的旋转数组搜索题
  - 后续更适合补：
    - 含重复元素的旋转数组二分题

- `答案空间二分`
  - 已覆盖题：`875`
  - 已掌握内容：
    - “速度越大，总耗时越小”的单调性判断
    - 在最小可行解上继续向左收缩
  - 近期不优先再出：
    - 纯同构的最小可行值二分题
  - 后续更适合补：
    - 更多“最大最小化 / 最小最大化”类答案二分题

### 6.6 链表

- `原地反转`
  - 已覆盖题：`206`、`92`、`25`
  - 已掌握内容：
    - `prev-cur-next` 三指针推进
    - 改指针前先保存旧的 `next`
    - 区间反转时，必须先理清“第一段尾 / 第二段头 / 第二段尾 / 第三段头”的拼接关系
    - 分组反转时，`findEnd` 和 `reverse` 的区间语义必须保持一致
  - 近期不优先再出：
    - 纯同构的基础反转链表题
  - 后续更适合补：
    - 把反转模板和快慢指针、链表拼接题串起来讲

- `dummy node` + 拼接
  - 已覆盖题：`21`、`203`、`24`
  - 已掌握内容：
    - 用哑节点统一处理头节点
    - 结果链表尾指针如何稳定推进
    - 连续删除节点时，什么时候该移动前驱、什么时候不能移动前驱
    - 局部交换时如何稳定维护“前驱 - 第一节点 - 第二节点 - 后续片段”四段关系
  - 近期不优先再出：
    - 纯基础的两个有序链表合并题
  - 后续更适合补：
    - `23`

- `快慢指针定位 / 判环`
  - 已覆盖题：`141`、`876`、`142`
  - 已掌握内容：
    - `slow` 一次一步、`fast` 一次两步时，如何自然落到中点、相遇点、环入口这几类目标节点
    - 为什么有环时快慢指针最终会在环内相遇
    - 为什么一个指针回到头节点后，再和相遇点指针同速前进会在入口相遇
  - 近期不优先再出：
    - 纯基础的链表判环题

- `快慢指针 + dummy node`
  - 已覆盖题：`19`
  - 已掌握内容：
    - 先制造固定间距再同步前进
    - 删除倒数第 `n` 个节点时本质上是在找前驱
  - 近期不优先再出：
    - 纯同构的倒数第 `k` 个节点删除题
  - 后续更适合补：
    - `23`

- `合并与重排`
  - 已覆盖题：`21`、`23`、`143`、`328`
  - 已掌握内容：
    - 多段链表处理前，先拆成“找边界 / 局部处理 / 最终拼接”几个基础动作
    - 结果链表尾指针或各段头尾关系需要始终明确
    - `143` 这类题里，先断开前后两段再反转和交替合并，能避免链表接成环
    - `328` 这类题里，偶数位子链表要尾插，才能保持原有相对顺序
  - 近期不优先再出：
    - 纯基础的有序链表合并题

- `链表 + 哈希表`
  - 已覆盖题：
    - `138`
  - 已掌握内容：
    - 哈希表里通常存的是“原节点 -> 新节点”的映射，而不是节点值
    - 当链表题需要随机访问历史节点信息时，哈希表是在补链表的短板

### 6.7 栈 / 队列 / 单调栈

- `表达式求值栈`
  - 已覆盖题：`150`
  - 已掌握内容：
    - 操作数入栈、运算符出栈计算
    - 先弹出的是右操作数，后弹出的是左操作数
  - 近期不优先再出：
    - 与 `150` 高度同构的基础后缀表达式题

- `调用栈模拟`
  - 已覆盖题：`636`
  - 已掌握内容：
    - 用栈维护函数调用链
    - 子函数开始前先结算父函数一段时间
    - `end` 是闭区间，父函数从 `time + 1` 继续
  - 近期不优先再出：
    - 纯同构的单线程调用链时间统计题

- `普通栈匹配`
  - 已覆盖题：`20`
  - 已掌握内容：
    - 栈里保存“最近未匹配的左括号”
    - 右括号来了只能检查栈顶
  - 近期不优先再出：
    - 与 `20` 高度同构的基础括号匹配题
  - 后续更适合补：
    - 需要同时维护额外状态的栈题

- `辅助状态栈`
  - 已覆盖题：`155`
  - 已掌握内容：
    - 普通栈之外，还要同步维护“到当前为止的最小值”
    - 单栈节点扩展法如何做到 `getMin()` 为 `O(1)`
  - 近期不优先再出：
    - 纯同构的最小栈题
  - 后续更适合补：
    - `739`
    - `496`

- `最近更大元素 / 单调栈`
  - 已覆盖题：`739`、`496`
  - 已掌握内容：
    - 栈里保存“还没找到更大元素”的下标或元素
    - 当前元素更大时持续弹栈并结算答案
  - 近期不优先再出：
    - 纯基础的最近更大元素模板题
  - 后续更适合补：
    - `1475`
    - `84`
    - `316`

- `右侧第一个更小或相等元素 / 单调栈`
  - 已覆盖题：`1475`
  - 已掌握内容：
    - 当前元素一旦更小或相等，就能给左边等待中的元素结算折扣
    - 单调栈不只处理“更大”，也可以处理“更小 / 小于等于”
  - 近期不优先再出：
    - 与 `1475` 高度同构的基础折扣题

- `左右边界 / 最近更小元素`
  - 已覆盖题：`84`
  - 已掌握内容：
    - 每个位置都能拆成“左边第一个更小 + 右边第一个更小”
    - 以当前位置为最低高度时，宽度如何通过边界反推
  - 近期不优先再出：
    - 纯同构的基础左右最近更小元素题

- `单调栈 + 贪心构造`
  - 已覆盖题：`316`
  - 已掌握内容：
    - 单调栈不只是在找边界，也能维护当前最优答案
    - 当前字符更小且栈顶后面还会再出现时，可以弹栈重构答案
  - 近期不优先再出：
    - 与 `316` 高度同构的基础最小子序列题

## 7. 当前最适合的出题优先池

如果后续按“当前进度 + 避免重复”继续出题，优先级建议如下：

### P0：立刻可做

1. Day34 字符串专题第一轮模板题
   - 推荐顺序：
     - `344` -> `125` -> `383` -> `8`
   - 原因：
     - 能先把字符串专题里最基础的双指针、字符计数、解析模拟三条主线重新讲顺
2. Day34 字符串专题第二轮高频题
   - 推荐顺序：
     - `567` -> `424` -> `890` -> `71`
   - 原因：
     - 分别覆盖固定窗口、容错窗口、映射关系和路径模拟，足够把字符串专题的主战模式拉起来
3. Day33 链表专题口头验收
   - 推荐顺序：
     - `203` -> `876` -> `92` -> `142` -> `143` -> `138`
   - 原因：
     - `day33` 的 9 道链表题已经全部完成本地实现
     - 当前更值得做的是把 `dummy node`、快慢指针、区间/分组反转、重排、链表 + 哈希表这些主线讲顺
4. Day31 数组 / 滑动窗口专题口头验收
   - 原因：
     - `485`、`643`、`904`、`1004`、`713` 已经全部完成本地实现
     - 当前更值得做的是把“固定长度 / 最长合法 / 容错型 / 统计型窗口”四类模板讲顺
5. `146. LRU 缓存`
   - 原因：
     - Day32 当前仅剩的结构设计题之一
     - 能补“哈希表 + 双向链表”这类高价值设计模式
6. `380. O(1) 时间插入、删除和获取随机元素`
   - 原因：
     - 和 `146` 一样属于高频结构设计题
     - 能补“哈希定位 + 数组随机访问 + 尾部交换删除”的组合思路

### P1：下一轮适合补

1. Day34 字符串专题进阶 / 验收题
   - 推荐顺序：
     - `30` -> `680` -> `387` -> `43`
   - 原因：
     - 这几题分别对应分组窗口、一次容错回文、计数后按顺序找答案、大数运算，最适合作为第二轮验收
2. Day33 链表错题 / 薄弱题回看
   - 原因：
     - `24`、`25`、`143`、`138` 这几题的链路比较长，最适合做第二轮脱稿讲解
     - 尤其要回看你前面做错过的 `92` 和 `25` 的边界语义
3. `Week2 Day14` 算法专题验收清单
   - 原因：
     - 文档和骨架已经在，但当前状态仍是 `已初始化待做`
     - 适合把哈希 / 链表 / 单调栈 / 二分这几个前序专题真正做一次口头验收

### P2：暂不优先

- 刚刚完成的 Day31 数组题同题号复刷：
  - `88`、`54`、`59`、`26`、`27`、`283`、`42`
- 刚刚完成的 Day31 滑动窗口题同题号复刷：
  - `485`、`643`、`904`、`1004`、`713`
- 刚刚完成的 Day33 链表题同题号复刷：
  - `203`、`24`、`876`、`142`、`92`、`25`、`143`、`328`、`138`
- Day34 新初始化字符串题里，暂时不建议一口气全开：
  - `567`、`424`、`30`、`344`、`125`、`680`、`383`、`387`、`890`、`8`、`71`、`43`
  - 更适合按“模板题 -> 高频题 -> 进阶 / 验收题”分两到三轮推进
- 与 `20`、`155`、`739`、`496`、`150`、`636`、`1475`、`84`、`316` 核心思路高度相似的基础栈 / 单调栈题
- 与 `3`、`209`、`438`、`76`、`485`、`643`、`904`、`1004`、`713` 高度同构的基础滑动窗口题
- 纯重复刷已经完成的题号

## 8. 后续使用规则

后续每次安排新题前，默认按下面顺序检查：

1. 先看这份台账，确认当前已完成和已初始化待做
   - 如果当天是复盘日，也要优先看“计划复刷题”
2. 再看对应专题文档里的“练习规划”和“验收标准”
3. 优先安排：
   - 当前模式还没补齐的题
   - 当前阶段的高频主战题
4. 避免安排：
   - 已完成题的重复题号
   - 与刚做过题核心思路几乎相同、又没有明确训练差异的题

## 9. 已预生成的后续题目

为了避免到当天再临时选题，当前已经按计划预生成到 Day34，并额外补出了 Day31 的数组 / 滑动窗口复习题：

- Day8：
  - `49. 字母异位词分组`
  - `242. 有效的字母异位词`
- Day9：
  - `206. 反转链表`
  - `21. 合并两个有序链表`
- Day10：
  - `141. 环形链表`
  - `19. 删除链表的倒数第 N 个结点`
- Day11：
  - `20. 有效的括号`
  - `155. 最小栈`
- Day12：
  - `739. 每日温度`
  - `496. 下一个更大元素 I`
- Day13：
  - `33. 搜索旋转排序数组`
  - `875. 爱吃香蕉的珂珂`
- Day14：
  - `Week2 Day14 算法专题验收清单`
- Day15：
  - `102. 二叉树的层序遍历`
  - `104. 二叉树的最大深度`
- Day16：
  - `94. 二叉树的中序遍历`
  - `226. 翻转二叉树`
- Day17：
  - `543. 二叉树的直径`
  - `236. 二叉树的最近公共祖先`
- Day18：
  - `215. 数组中的第 K 个最大元素`
  - `347. 前 K 个高频元素`
- Day19：
  - `23. 合并 K 个升序链表`
  - `415. 字符串相加`
- Day20：
  - `438. 找到字符串中所有字母异位词`
  - `76. 最小覆盖子串`
- Day22：
  - `46. 全排列`
  - `78. 子集`
- Day23：
  - `39. 组合总和`
  - `22. 括号生成`
- Day24：
  - `200. 岛屿数量`
  - `994. 腐烂的橘子`
- Day25：
  - `207. 课程表`
  - `127. 单词接龙`
- Day26：
  - `70. 爬楼梯`
  - `198. 打家劫舍`
- Day27：
  - `322. 零钱兑换`
  - `300. 最长递增子序列`
- Day29：
  - `55. 跳跃游戏`
  - `121. 买卖股票的最佳时机`
- Day30：
  - `45. 跳跃游戏 II`
  - `435. 无重叠区间`
- Day31：
  - `SlidingWindowReviewQuestion1`：
    - `485`、`643`、`904`、`1004`、`713`
  - `ArrayQuestion`：
    - `88`、`54`、`59`
  - `ArrayQuestion2`：
    - `26`、`27`、`283`、`42`
  - `StackQuestion`：
    - `150`、`636`
  - `MonotonicStackQuestion1`：
    - `739`、`1475`、`84`、`316`
- Day32：
  - `217. 存在重复元素`
  - `205. 同构字符串`
  - `169. 多数元素`
  - `249. 移位字符串分组`
  - `974. 和可被 K 整除的子数组`
  - `290. 单词规律`
  - `523. 连续的子数组和`
  - `930. 和相同的二元子数组`
  - `325. 和等于 k 的最长子数组长度`
  - `146. LRU 缓存`
  - `380. O(1) 时间插入、删除和获取随机元素`
- Day33：
  - `LinkedListDummyNodeQuestion1`：
    - `203`、`24`
  - `LinkedListFastSlowPointerQuestion1`：
    - `876`、`142`
  - `LinkedListReverseQuestion1`：
    - `92`、`25`
  - `LinkedListReorderQuestion1`：
    - `143`、`328`
  - `LinkedListHashQuestion1`：
    - `138`
- Day34：
  - `StringWindowQuestion2`：
    - `567`、`424`、`30`
  - `StringTwoPointerQuestion1`：
    - `344`、`125`、`680`
  - `StringHashQuestion1`：
    - `383`、`387`、`890`
  - `StringSimulationQuestion2`：
    - `8`、`71`、`43`
