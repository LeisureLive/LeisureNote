# 算法已做题台账与去重索引

最后更新：`2026-04-01`

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
- `已初始化待做`
  - 已经建好题目骨架，但还没有完成实现
- `计划复刷`
  - 这题以前做过，但因为是薄弱点或模板题，需要按计划再做一遍
- `未开始`
  - 还没有本地题目文件，也还没有进入当前阶段的练习优先队列

## 3. 当前进度总览

| 专题 | 已完成 | 待做 / 复刷 | 当前说明 |
| --- | --- | --- | --- |
| 数组 | 5 | 0 | 双指针、滑动窗口、前后缀已有覆盖 |
| 哈希表 | 5 | 4 | 补数查找、窗口内存在性已补齐，前缀和 + 哈希待复刷，分组归类和哈希统计已预生成 |
| 链表 | 0 | 5 | Week2-Week3 已预生成基础题、快慢指针和堆结合链表题 |
| 栈 / 队列 / 单调栈 | 0 | 4 | Week2 已预生成基础栈题和单调栈题 |
| 字符串 | 1 | 5 | 已覆盖基础滑动窗口，分组归类、统计、模拟和窗口进阶已预生成 |
| 二分查找 | 1 | 2 | 已覆盖边界二分，标准变体与答案二分待补 |
| 二叉树 / DFS / BFS | 0 | 6 | Week3 已预生成树遍历、递归、后序 DFS 题 |
| 堆 / 优先队列 | 0 | 3 | Week3 已预生成 TopK、哈希 + 堆、堆和链表结合题 |
| 回溯 | 0 | 4 | Week4 已预生成模板题和剪枝 / 状态约束题 |
| 图 | 0 | 4 | Week4 已预生成 DFS / BFS / 拓扑排序相关题 |
| 动态规划 | 0 | 4 | Week4 已预生成入门模板和进阶高频题 |

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

## 5. 当前待做 / 复刷题目

| Day | 题号 | 题目 | 归属专题 | 核心模式 | 状态 | 代码文件 |
| --- | --- | --- | --- | --- | --- | --- |
| Day7 | `560` | 和为 K 的子数组 | 哈希表 / 前缀和 | 前缀和 + 哈希计数 | 计划复刷 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week1/day7/PrefixSumHashReviewQuestion1.java` |
| Day8 | `49` | 字母异位词分组 | 哈希表 / 字符串 | 分组归类 + 稳定 key | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day8/HashGroupingQuestion1.java` |
| Day8 | `242` | 有效的字母异位词 | 哈希表 / 字符串 | 计数统计 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day8/HashCountingQuestion1.java` |
| Day9 | `206` | 反转链表 | 链表 | 原地反转 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day9/LinkedListQuestion1.java` |
| Day9 | `21` | 合并两个有序链表 | 链表 | `dummy node` + 拼接 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day9/LinkedListQuestion2.java` |
| Day10 | `141` | 环形链表 | 链表 | 快慢指针判环 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day10/FastSlowPointerQuestion1.java` |
| Day10 | `19` | 删除链表的倒数第 N 个结点 | 链表 | 快慢指针 + `dummy node` | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day10/FastSlowPointerQuestion2.java` |
| Day11 | `20` | 有效的括号 | 栈 | 普通栈匹配 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day11/StackQueueQuestion1.java` |
| Day11 | `155` | 最小栈 | 栈 | 辅助状态栈 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day11/StackQueueQuestion2.java` |
| Day12 | `739` | 每日温度 | 单调栈 | 最近更大元素 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day12/MonotonicStackQuestion1.java` |
| Day12 | `496` | 下一个更大元素 I | 单调栈 | 最近更大元素 + 哈希映射 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day12/MonotonicStackQuestion2.java` |
| Day13 | `33` | 搜索旋转排序数组 | 二分查找 | 变体二分 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day13/BinarySearchQuestion1.java` |
| Day13 | `875` | 爱吃香蕉的珂珂 | 二分查找 | 答案空间二分 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day13/BinarySearchQuestion2.java` |
| Day14 | 专题验收 | Week2 Day14 算法专题验收清单 | 综合复盘 | 哈希 / 链表 / 单调栈 / 二分专题验收 | 已初始化待做 | `prepare/2026/tracks/xiaomi_java_data_service/algorithms/week2_day14_review_checklist.md` |
| Day15 | `102` | 二叉树的层序遍历 | 二叉树 / BFS | BFS 模板 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day15/TreeBfsQuestion1.java` |
| Day15 | `104` | 二叉树的最大深度 | 二叉树 / DFS | DFS 模板 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day15/TreeDfsQuestion1.java` |
| Day16 | `94` | 二叉树的中序遍历 | 二叉树 | 遍历模板 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day16/TreeTraversalQuestion1.java` |
| Day16 | `226` | 翻转二叉树 | 二叉树 | 树递归基础 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day16/TreeRecursionQuestion1.java` |
| Day17 | `543` | 二叉树的直径 | 二叉树 / DFS | 后序 DFS | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day17/TreeDfsQuestion2.java` |
| Day17 | `236` | 二叉树的最近公共祖先 | 二叉树 | 递归信息归并 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day17/TreeRecursionQuestion2.java` |
| Day18 | `215` | 数组中的第 K 个最大元素 | 堆 | TopK 小顶堆 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day18/HeapQuestion1.java` |
| Day18 | `347` | 前 K 个高频元素 | 哈希表 / 堆 | 哈希统计 + 堆 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day18/HeapQuestion2.java` |
| Day19 | `23` | 合并 K 个升序链表 | 链表 / 堆 | 堆和链表结合 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day19/HeapLinkedListQuestion1.java` |
| Day19 | `415` | 字符串相加 | 字符串 | 从后往前模拟 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day19/StringSimulationQuestion1.java` |
| Day20 | `438` | 找到字符串中所有字母异位词 | 字符串 / 滑动窗口 | 固定长度窗口 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day20/StringWindowQuestion1.java` |
| Day20 | `76` | 最小覆盖子串 | 字符串 / 滑动窗口 | 复杂窗口题 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day20/StringWindowQuestion2.java` |
| Day22 | `46` | 全排列 | 回溯 | 回溯模板 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day22/BacktrackingQuestion1.java` |
| Day22 | `78` | 子集 | 回溯 | 回溯树展开 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day22/BacktrackingQuestion2.java` |
| Day23 | `39` | 组合总和 | 回溯 | 剪枝回溯 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day23/BacktrackingQuestion3.java` |
| Day23 | `22` | 括号生成 | 回溯 | 状态约束回溯 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day23/BacktrackingQuestion4.java` |
| Day24 | `200` | 岛屿数量 | 图 | DFS / BFS | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day24/GraphTraversalQuestion1.java` |
| Day24 | `994` | 腐烂的橘子 | 图 | 多源 BFS | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day24/GraphTraversalQuestion2.java` |
| Day25 | `207` | 课程表 | 图 | 拓扑排序 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day25/GraphQuestion1.java` |
| Day25 | `127` | 单词接龙 | 图 | BFS 扩展 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day25/GraphQuestion2.java` |
| Day26 | `70` | 爬楼梯 | 动态规划 | DP 入门模板 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day26/DpQuestion1.java` |
| Day26 | `198` | 打家劫舍 | 动态规划 | 一维 DP | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day26/DpQuestion2.java` |
| Day27 | `322` | 零钱兑换 | 动态规划 | 完全背包 / DP 进阶 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day27/DpQuestion3.java` |
| Day27 | `300` | 最长递增子序列 | 动态规划 | DP 高频题 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day27/DpQuestion4.java` |

## 6. 已覆盖模式索引

这一节不是按题号看，而是按“核心解法模式”看，方便后续出题查重。

### 6.1 数组 / 双指针

- `有序数组配对`
  - 已覆盖题：`167`
  - 已掌握内容：
    - 左右指针为什么不会漏解
    - 有序数组上如何利用单调性
  - 近期不优先再出：
    - 同类“有序数组 + 配对求和”双指针题
  - 后续更适合补：
    - `26`、`27` 这类原地双指针
    - `42` 这种多解法对比题

- `左右夹逼`
  - 已覆盖题：`11`
  - 已掌握内容：
    - 双指针从两端向中间收缩
    - 为什么移动短板
  - 近期不优先再出：
    - 纯同构的左右夹逼容量题
  - 后续更适合补：
    - `42`
    - `41`

### 6.2 滑动窗口

- `变长窗口`
  - 已覆盖题：`3`、`209`
  - 已掌握内容：
    - 合法窗口定义
    - 何时扩张、何时收缩
  - 近期不优先再出：
    - 另一个基础变长窗口模板题
  - 后续更适合补：
    - `438` 固定长度窗口
    - `76` 复杂窗口题

### 6.3 前后缀 / 前缀和

- `前后缀分解`
  - 已覆盖题：`238`
  - 已掌握内容：
    - 左右信息拆分
    - 如何避免暴力枚举左右两边
  - 近期不优先再出：
    - 纯同构的前后缀乘积 / 前后缀数组题
  - 后续更适合补：
    - `42`

- `前缀和 + 哈希计数`
  - 已覆盖题：`560`
  - 已掌握内容：
    - 区间和转前缀差
    - map 存“次数”
  - 近期不优先再出：
    - 另一个基础“统计区间个数”的前缀和哈希题
  - 后续更适合补：
    - 结合 `525` 做对照复盘，而不是继续堆同类题

- `前缀和 + 最早位置`
  - 已覆盖题：`525`
  - 已掌握内容：
    - map 存“最早位置”
    - 和 `560` 的状态差异
  - 近期不优先再出：
    - 同构的“最长长度型前缀和”基础题
  - 后续更适合补：
    - 先把 `560` / `525` 讲透

### 6.4 哈希表

- `HashSet` 存在性判断 + 起点枚举
  - 已覆盖题：`128`
  - 已掌握内容：
    - set 做存在性判断
    - 为什么只从起点开始枚举
  - 近期不优先再出：
    - 过于简单的 set 存在性模板题
  - 后续更适合补：
    - `49`
    - `347`

- `HashMap` 补数查找
  - 已覆盖题：`1`
  - 已掌握内容：
    - 先查再放
    - 补数匹配
  - 近期不优先再出：
    - 纯基础的补数查找模板题

- `窗口内存在性判断`
  - 已覆盖题：`219`
  - 已掌握内容：
    - 只保留最近一次出现的位置
    - 判断是否满足索引距离约束
  - 近期不优先再出：
    - 与 `219` 高度同构的基础存在性判断题

- `HashMap` 分组归类
  - 已覆盖题：无
  - 当前状态：
    - `49` 更适合放到后续哈希计数 / 分组阶段再做

### 6.5 二分查找

- `边界二分`
  - 已覆盖题：`34`
  - 已掌握内容：
    - 左边界、右边界分别找
  - 近期不优先再出：
    - 另一个纯基础边界二分题
  - 后续更适合补：
    - `875` 这类答案空间二分

## 7. 当前最适合的出题优先池

如果后续按“当前进度 + 避免重复”继续出题，优先级建议如下：

### P0：立刻可做

1. `560. 和为 K 的子数组`
   - 原因：
     - 这是 Day7 计划里“重做错题或薄弱题 1 题”的最合适选择
     - Day4 复盘里，这题是前缀和 + 哈希里更基础、也更薄弱的模板题

### P1：下一轮适合补

1. `49. 字母异位词分组`
   - 原因：
     - 更贴合后续“哈希计数 / 分组”阶段
2. `438. 找到字符串中所有字母异位词`
   - 原因：
     - 可以接在 `3` 之后，补“固定长度窗口”
3. `26. 删除有序数组中的重复项`
   - 原因：
     - 可以补齐数组专题里“原地双指针模板”
4. `42. 接雨水`
   - 原因：
     - 能串起数组、双指针、前后缀、单调栈多个专题

### P2：暂不优先

- 与 `167`、`11`、`3`、`209`、`560`、`525` 核心思路高度相似的基础模板题
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

为了避免到当天再临时选题，当前已经按计划预生成到 Week4 Day27：

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
