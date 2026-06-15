# 算法已做题台账与去重索引

最后更新：`2026-06-10`

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
| 数组 | 17 | 4 | 已覆盖有序数组双指针、原地覆盖、稳定搬移、遍历与模拟、前后缀最大值，以及固定长度、种类数约束、容错型、统计型滑动窗口代表题；Day31 额外收口了前缀和 / 前后缀复盘，并补了原地交换 / 原地标记骨架 |
| 哈希表 | 17 | 2 | 补数查找、映射关系、分组归类、计数统计、前缀和主线已覆盖，Day32 已按 `3.1-3.5` 模式收口，结构设计题待做 |
| 链表 | 14 | 0 | 已覆盖 `dummy node`、快慢指针、中点/环入口、区间/分组反转、重排、奇偶拆分，以及链表 + 哈希表的高频代表题 |
| 栈 / 队列 / 单调栈 | 12 | 1 | 已覆盖普通栈、辅助状态栈、队列语义转换、单调队列窗口最值、最近更大 / 更小元素和区间边界主线；Day35 已按 `3.1-3.4` 四种常考模式重组，当前仅剩 `85` 待补实现内注释与状态收口 |
| 字符串 | 6 | 12 | 已覆盖基础滑动窗口、模拟、固定长度窗口和复杂窗口题，Day34 已补出双指针 / 回文、字符串哈希、进阶窗口、解析模拟等 12 道代表题骨架 |
| 二分查找 | 3 | 12 | 已覆盖边界二分、变体二分、答案空间二分，Day31 补了基础命中二分骨架；Day38 已按 `3.1-3.4` 补出 11 道待做骨架，覆盖基础命中、边界定位、结构变体和答案空间四类主战题 |
| 二叉树 / DFS / BFS | 8 | 16 | 已完成 BFS、基础 DFS、前中后序遍历、树递归和信息归并题；Day36 已按 `3.1-3.5` 五种常考模式补出 16 道待做骨架，覆盖按层处理、递归遍历、后序归并、路径状态和 BST 有序性剪枝 |
| 堆 / 优先队列 | 3 | 8 | 已完成 TopK、哈希 + 堆和堆合并链表入门题；Day37 已按 `3.1-3.5` 五种常考模式补出 8 道待做骨架，覆盖固定容量堆、频次比较器、多路归并、数据流双堆 / 单堆和优先级调度 |
| 回溯 | 4 | 10 | 模板题、剪枝回溯和状态约束题已覆盖，并已补出 Day39 的 5 类常考模式骨架 |
| 图 | 4 | 9 | DFS / BFS、多源 BFS、拓扑排序和 BFS 扩展题已覆盖；Day40 已按 `3.1-3.4` 补出 9 道待做骨架，覆盖连通块、最短步数 / 多源 BFS、拓扑排序 / 先修关系，以及状态建模搜索 |
| 动态规划 | 4 | 11 | 入门模板、一维最值、完全背包和 LIS 已覆盖；Day41 已按 `3.1-3.3` 拆成线性递推、选或不选、完全背包和序列型 4 类模式，并补出 11 道待做骨架 |
| 贪心 | 4 | 0 | 覆盖范围、最少跳数、历史最优和区间贪心已覆盖 |

说明：

- 这里按“题目核心模式”计入专题，不强求一题只属于一个专题。
- 例如 `3. 无重复字符的最长子串`，虽然是字符串题，也可以视为滑动窗口题。

## 4. 已完成题目台账

| 题号 | 题目 | 归属专题 | 核心模式 | 状态 | 代码文件 |
| --- | --- | --- | --- | --- | --- |
| `238` | 除自身以外数组的乘积 | 数组 | 前后缀分解 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| `128` | 最长连续序列 | 哈希表 | `HashSet` + 起点枚举 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion1.java` |
| `167` | 两数之和 II - 输入有序数组 | 数组 | 有序数组双指针 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week1/day2/ArrayQuestion2.java` |
| `11` | 盛最多水的容器 | 数组 | 左右夹逼双指针 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week1/day2/ArrayQuestion2.java` |
| `3` | 无重复字符的最长子串 | 字符串 / 滑动窗口 | 变长窗口 + 去重 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week1/day3/SlidingWindowQuestion1.java` |
| `209` | 长度最小的子数组 | 数组 / 滑动窗口 | 变长窗口 + 正数约束 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week1/day3/SlidingWindowQuestion2.java` |
| `560` | 和为 K 的子数组 | 哈希表 / 前缀和 | 前缀和 + 哈希计数 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion5.java` |
| `525` | 连续数组 | 哈希表 / 前缀和 | 前缀和 + 最早位置 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| `303` | 区域和检索 - 数组不可变 | 数组 / 前缀和 | 区间和查询 / 前缀差 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| `724` | 寻找数组的中心下标 | 数组 / 前缀和 | 左右和相等 / 前缀差 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| `34` | 在排序数组中查找元素的第一个和最后一个位置 | 二分查找 | 边界二分 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| `1` | 两数之和 | 哈希表 | 补数查找 + `HashMap` | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion2.java` |
| `219` | 存在重复元素 II | 数组 / 哈希表 | 固定范围内存在性判断 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week1/day6/ArrayHashQuestion2.java` |
| `49` | 字母异位词分组 | 哈希表 / 字符串 | 分组归类 + 稳定 key | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion4.java` |
| `242` | 有效的字母异位词 | 哈希表 / 字符串 | 计数统计 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion3.java` |
| `206` | 反转链表 | 链表 | 原地反转 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day9/LinkedListQuestion1.java` |
| `21` | 合并两个有序链表 | 链表 | `dummy node` + 拼接 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day9/LinkedListQuestion2.java` |
| `141` | 环形链表 | 链表 | 快慢指针判环 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day10/FastSlowPointerQuestion1.java` |
| `19` | 删除链表的倒数第 N 个结点 | 链表 | 快慢指针 + `dummy node` | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day10/FastSlowPointerQuestion2.java` |
| `20` | 有效的括号 | 栈 | 普通栈匹配 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day11/StackQueueQuestion1.java` |
| `155` | 最小栈 | 栈 | 辅助状态栈 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day11/StackQueueQuestion2.java` |
| `739` | 每日温度 | 单调栈 | 最近更大元素 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day12/MonotonicStackQuestion1.java` |
| `496` | 下一个更大元素 I | 单调栈 | 最近更大元素 + 哈希映射 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day12/MonotonicStackQuestion2.java` |
| `33` | 搜索旋转排序数组 | 二分查找 | 变体二分 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| `875` | 爱吃香蕉的珂珂 | 二分查找 | 答案空间二分 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| `704` | 二分查找 | 二分查找 | 基础命中二分 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| `35` | 搜索插入位置 | 二分查找 | 基础二分 / 搜索或插入位置 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day38/BinarySearchBasicQuestion1.java` |
| `74` | 搜索二维矩阵 | 二分查找 | 基础二分 / 矩阵映射到一维有序区间 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day38/BinarySearchBasicQuestion1.java` |
| `278` | 第一个错误的版本 | 二分查找 | 边界二分 / 第一个满足条件的位置 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day38/BinarySearchBoundaryQuestion1.java` |
| `744` | 寻找比目标字母大的最小字母 | 二分查找 | 边界二分 / 第一个大于目标的位置 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day38/BinarySearchBoundaryQuestion1.java` |
| `275` | H 指数 II | 二分查找 | 边界二分 / 有序计数数组中的最大合法 h | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day38/BinarySearchBoundaryQuestion1.java` |
| `153` | 寻找旋转排序数组中的最小值 | 二分查找 | 变体二分 / 旋转数组最小值定位 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day38/BinarySearchVariantQuestion1.java` |
| `162` | 寻找峰值 | 二分查找 | 变体二分 / 峰值定位 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day38/BinarySearchVariantQuestion1.java` |
| `540` | 有序数组中的单一元素 | 二分查找 | 变体二分 / 成对结构错位定位 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day38/BinarySearchVariantQuestion1.java` |
| `1011` | 在 D 天内送达包裹的能力 | 二分查找 | 答案空间二分 / 最小可行运载能力 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day38/BinarySearchAnswerSpaceQuestion1.java` |
| `410` | 分割数组的最大值 | 二分查找 | 答案空间二分 / 最小化最大分段和 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day38/BinarySearchAnswerSpaceQuestion1.java` |
| `1482` | 制作 m 束花所需的最少天数 | 二分查找 | 答案空间二分 / 最小可行等待天数 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day38/BinarySearchAnswerSpaceQuestion1.java` |
| `102` | 二叉树的层序遍历 | 二叉树 / BFS | BFS 模板 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day15/TreeBfsQuestion1.java` |
| `104` | 二叉树的最大深度 | 二叉树 / DFS | DFS 模板 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day15/TreeDfsQuestion1.java` |
| `94` | 二叉树的中序遍历 | 二叉树 | 遍历模板 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day16/TreeTraversalQuestion1.java` |
| `144` | 二叉树的前序遍历 | 二叉树 | 遍历模板 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day16/TreeTraversalQuestion2.java` |
| `145` | 二叉树的后序遍历 | 二叉树 | 遍历模板 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day16/TreeTraversalQuestion3.java` |
| `226` | 翻转二叉树 | 二叉树 | 树递归基础 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day16/TreeRecursionQuestion1.java` |
| `543` | 二叉树的直径 | 二叉树 / DFS | 后序 DFS | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day17/TreeDfsQuestion2.java` |
| `236` | 二叉树的最近公共祖先 | 二叉树 | 递归信息归并 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day17/TreeRecursionQuestion2.java` |
| `199` | 二叉树的右视图 | 二叉树 / BFS | 按层聚合 / 右侧视角 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreeBfsLayerQuestion1.java` |
| `111` | 二叉树的最小深度 | 二叉树 / BFS | 按层最早到达叶子 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreeBfsLayerQuestion1.java` |
| `103` | 二叉树的锯齿形层序遍历 | 二叉树 / BFS | 按层遍历 / 交替输出 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreeBfsLayerQuestion1.java` |
| `100` | 相同的树 | 二叉树 / DFS | 递归结构判断 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreeDfsTraversalQuestion1.java` |
| `101` | 对称二叉树 | 二叉树 / DFS | 镜像递归判断 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreeDfsTraversalQuestion1.java` |
| `617` | 合并二叉树 | 二叉树 / DFS | 递归合并子树 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreeDfsTraversalQuestion1.java` |
| `110` | 平衡二叉树 | 二叉树 / DFS | 后序归并 / 高度与平衡性 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreePostorderMergeQuestion1.java` |
| `124` | 二叉树中的最大路径和 | 二叉树 / DFS | 后序归并 / 单边贡献 + 全局最优 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreePostorderMergeQuestion1.java` |
| `337` | 打家劫舍 III | 二叉树 / DFS | 后序归并 / 多状态返回 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreePostorderMergeQuestion1.java` |
| `112` | 路径总和 | 二叉树 / DFS | 根到叶路径存在性判断 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreePathStateQuestion1.java` |
| `113` | 路径总和 II | 二叉树 / DFS | 收集所有根到叶路径 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreePathStateQuestion1.java` |
| `129` | 求根节点到叶节点数字之和 | 二叉树 / DFS | 路径数值累积 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreePathStateQuestion1.java` |
| `98` | 验证二叉搜索树 | 二叉树 / BST | 上下界校验 / 全局有序性 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/BstOrderedPropertyQuestion1.java` |
| `230` | 二叉搜索树中第 K 小的元素 | 二叉树 / BST | 中序有序性 / 第 k 小 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/BstOrderedPropertyQuestion1.java` |
| `700` | 二叉搜索树中的搜索 | 二叉树 / BST | 有序性定向查找 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/BstOrderedPropertyQuestion1.java` |
| `235` | 二叉搜索树的最近公共祖先 | 二叉树 / BST | 大小关系剪枝定位 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/BstOrderedPropertyQuestion1.java` |
| `215` | 数组中的第 K 个最大元素 | 堆 | TopK 小顶堆 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day18/HeapQuestion1.java` |
| `347` | 前 K 个高频元素 | 哈希表 / 堆 | 哈希统计 + 堆 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion3.java` |
| `23` | 合并 K 个升序链表 | 链表 / 堆 | 堆和链表结合 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day19/HeapLinkedListQuestion1.java` |
| `973` | 最接近原点的 K 个点 | 堆 | TopK 固定容量堆 / 距离候选保留 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day37/HeapTopKQuestion1.java` |
| `692` | 前 K 个高频单词 | 哈希表 / 堆 | 哈希统计 + 堆 / 频次 + 字典序比较 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day37/HeapFrequencyQuestion1.java` |
| `373` | 查找和最小的 K 对数字 | 堆 | 多路归并 / 来源下标扩展 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day37/HeapMultiWayMergeQuestion1.java` |
| `378` | 有序矩阵中第 K 小的元素 | 堆 | 多路归并 / 有序矩阵头部扩展 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day37/HeapMultiWayMergeQuestion1.java` |
| `703` | 数据流中的第 K 大元素 | 堆 | 数据流维护 / 固定容量堆 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day37/HeapDataStreamQuestion1.java` |
| `295` | 数据流的中位数 | 堆 | 数据流维护 / 双堆平衡 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day37/HeapDataStreamQuestion1.java` |
| `253` | 会议室 II | 堆 | 优先级调度 / 最早结束资源复用 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day37/HeapSchedulingQuestion1.java` |
| `1167` | 连接棒材的最低费用 | 堆 / 贪心 | 优先级调度 / 最小代价合并 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day37/HeapSchedulingQuestion1.java` |
| `415` | 字符串相加 | 字符串 | 从后往前模拟 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day19/StringSimulationQuestion1.java` |
| `438` | 找到字符串中所有字母异位词 | 字符串 / 滑动窗口 | 固定长度窗口 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day20/StringWindowQuestion1.java` |
| `76` | 最小覆盖子串 | 字符串 / 滑动窗口 | 复杂窗口题 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week3/day20/StringWindowQuestion2.java` |
| `46` | 全排列 | 回溯 | 回溯模板 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day22/BacktrackingQuestion1.java` |
| `78` | 子集 | 回溯 | 回溯树展开 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day22/BacktrackingQuestion2.java` |
| `39` | 组合总和 | 回溯 | 剪枝回溯 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day23/BacktrackingQuestion3.java` |
| `22` | 括号生成 | 回溯 | 状态约束回溯 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day23/BacktrackingQuestion4.java` |
| `90` | 子集 II | 回溯 | 子集型 / 去重 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day39/BacktrackingSubsetQuestion1.java` |
| `491` | 非递减子序列 | 回溯 | 子集型 / 去重 + 保序 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day39/BacktrackingSubsetQuestion1.java` |
| `77` | 组合 | 回溯 | 组合型 / 固定选择数量 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day39/BacktrackingCombinationQuestion1.java` |
| `40` | 组合总和 II | 回溯 | 组合型 / 去重 + 单次使用 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day39/BacktrackingCombinationQuestion1.java` |
| `216` | 组合总和 III | 回溯 | 组合型 / 固定数量 + 固定取值范围 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day39/BacktrackingCombinationQuestion1.java` |
| `47` | 全排列 II | 回溯 | 排列型 / 去重 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day39/BacktrackingPermutationQuestion1.java` |
| `131` | 分割回文串 | 回溯 | 切割型 / 回文分段 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day39/BacktrackingPartitionQuestion1.java` |
| `93` | 复原 IP 地址 | 回溯 | 切割型 / 固定段数 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day39/BacktrackingPartitionQuestion1.java` |
| `17` | 电话号码的字母组合 | 回溯 | 约束构造型 / 字母映射 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day39/BacktrackingConstraintQuestion1.java` |
| `51` | N 皇后 | 回溯 | 约束构造型 / 皇后摆放 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day39/BacktrackingConstraintQuestion1.java` |
| `200` | 岛屿数量 | 图 | DFS / BFS | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day24/GraphTraversalQuestion1.java` |
| `994` | 腐烂的橘子 | 图 | 多源 BFS | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day24/GraphTraversalQuestion2.java` |
| `207` | 课程表 | 图 | 拓扑排序 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day25/GraphQuestion1.java` |
| `127` | 单词接龙 | 图 | BFS 扩展 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day25/GraphQuestion2.java` |
| `695` | 岛屿的最大面积 | 图 | 连通性 / 连通块面积统计 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day40/GraphConnectivityQuestion1.java` |
| `733` | 图像渲染 | 图 | 连通性 / 同值区域扩散 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day40/GraphConnectivityQuestion1.java` |
| `130` | 被围绕的区域 | 图 | 连通性 / 边界连通区域判断 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day40/GraphConnectivityQuestion1.java` |
| `1091` | 二进制矩阵中的最短路径 | 图 | 最短步数 / 分层 BFS | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day40/GraphShortestPathQuestion1.java` |
| `542` | 01 矩阵 | 图 | 最短步数 / 多源 BFS 距离扩散 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day40/GraphShortestPathQuestion1.java` |
| `210` | 课程表 II | 图 | 拓扑排序 / 合法顺序构造 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day40/GraphTopologicalSortQuestion1.java` |
| `1462` | 课程表 IV | 图 | 拓扑排序 / 先修关系传递判断 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day40/GraphTopologicalSortQuestion1.java` |
| `752` | 打开转盘锁 | 图 | 状态搜索 / 字符串状态变换 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day40/GraphStateSearchQuestion1.java` |
| `433` | 最小基因变化 | 图 | 状态搜索 / 基因状态变换 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day40/GraphStateSearchQuestion1.java` |
| `70` | 爬楼梯 | 动态规划 | DP 入门模板 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day26/DpQuestion1.java` |
| `198` | 打家劫舍 | 动态规划 | 一维 DP | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day26/DpQuestion2.java` |
| `322` | 零钱兑换 | 动态规划 | 完全背包 / DP 进阶 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day27/DpQuestion3.java` |
| `300` | 最长递增子序列 | 动态规划 | DP 高频题 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week4/day27/DpQuestion4.java` |
| `509` | 斐波那契数 | 动态规划 | 一维线性 DP / 基础递推 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day41/DpLinearRecurrenceQuestion1.java` |
| `746` | 使用最小花费爬楼梯 | 动态规划 | 一维线性 DP / 最小代价递推 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day41/DpLinearRecurrenceQuestion1.java` |
| `91` | 解码方法 | 动态规划 | 一维线性 DP / 前一位与前两位转移 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day41/DpLinearRecurrenceQuestion1.java` |
| `213` | 打家劫舍 II | 动态规划 | 选或不选 DP / 环形约束 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day41/DpDecisionQuestion1.java` |
| `740` | 删除并获得点数 | 动态规划 | 选或不选 DP / 值域聚合 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day41/DpDecisionQuestion1.java` |
| `279` | 完全平方数 | 动态规划 | 完全背包 / 最少物品数 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day41/DpCompleteKnapsackQuestion1.java` |
| `518` | 零钱兑换 II | 动态规划 | 完全背包 / 组合计数 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day41/DpCompleteKnapsackQuestion1.java` |
| `377` | 组合总和 IV | 动态规划 | 完全背包 / 排列计数 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day41/DpCompleteKnapsackQuestion1.java` |
| `1143` | 最长公共子序列 | 动态规划 | 序列型 DP / 二维匹配 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day41/DpSequenceQuestion1.java` |
| `72` | 编辑距离 | 动态规划 | 序列型 DP / 编辑操作代价 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day41/DpSequenceQuestion1.java` |
| `516` | 最长回文子序列 | 动态规划 | 序列型 DP / 回文子序列范围 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day41/DpSequenceQuestion1.java` |
| `55` | 跳跃游戏 | 贪心 | 覆盖范围 / 可达性 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day29/GreedyQuestion1.java` |
| `121` | 买卖股票的最佳时机 | 贪心 | 历史最优状态 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day29/GreedyQuestion2.java` |
| `45` | 跳跃游戏 II | 贪心 | 覆盖范围 / 最少跳数 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day30/GreedyQuestion1.java` |
| `435` | 无重叠区间 | 贪心 | 区间选择 / 按结束排序 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day30/GreedyQuestion2.java` |
| `485` | 最大连续 1 的个数 | 数组 / 滑动窗口 | 窗口内 0 个数约束 / 右开区间窗口复习 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion3.java` |
| `643` | 子数组最大平均数 I | 数组 / 滑动窗口 | 固定长度窗口 / 区间和维护 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion3.java` |
| `904` | 水果成篮 | 数组 / 滑动窗口 | 变长窗口 / 最长合法区间 / 种类数约束 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion3.java` |
| `1004` | 最大连续 1 的个数 III | 数组 / 滑动窗口 | 容错型窗口 / 坏元素计数 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion3.java` |
| `713` | 乘积小于 K 的子数组 | 数组 / 滑动窗口 | 统计型窗口 / 正数乘积约束 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion3.java` |
| `217` | 存在重复元素 | 哈希表 | `HashSet` 存在性判断 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion1.java` |
| `205` | 同构字符串 | 哈希表 | 双向映射关系 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion2.java` |
| `169` | 多数元素 | 哈希表 | 计数统计 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion3.java` |
| `249` | 移位字符串分组 | 哈希表 / 字符串 | 分组归类 / 稳定 key 设计 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion4.java` |
| `974` | 和可被 K 整除的子数组 | 哈希表 / 前缀和 | 前缀和 + 余数计数 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion5.java` |
| `290` | 单词规律 | 哈希表 / 字符串 | 双向映射关系 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion2.java` |
| `523` | 连续的子数组和 | 哈希表 / 前缀和 | 前缀和 + 最早位置 / 余数位置映射 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion5.java` |
| `930` | 和相同的二元子数组 | 哈希表 / 前缀和 | 前缀和 + 哈希计数 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion5.java` |
| `325` | 和等于 k 的最长子数组长度 | 哈希表 / 前缀和 | 前缀和 + 最早位置 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion5.java` |
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
| `42` | 接雨水 | 数组 / 前后缀 / 双指针 | 前后缀最大值 + 左右夹逼逐步结算 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| `41` | 缺失的第一个正数 | 数组 | 原地交换 / 下标映射 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| `448` | 找到所有数组中消失的数字 | 数组 | 原地标记 / 正负号标记 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| `1475` | 商品折扣后的最终价格 | 单调栈 | 右侧第一个小于等于元素 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day35/MonotonicStackNearestQuestion1.java` |
| `84` | 柱状图中最大的矩形 | 单调栈 | 左右最近更小元素 / 边界扩展 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day35/MonotonicStackBoundaryQuestion1.java` |
| `316` | 去除重复字母 | 栈 / 贪心 | 普通栈回退 + 最小去重子序列 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day35/StackDeferredProcessingQuestion1.java` |
| `150` | 逆波兰表达式求值 | 栈 | 表达式求值栈 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day35/StackDeferredProcessingQuestion1.java` |
| `636` | 函数的独占时间 | 栈 | 调用栈模拟 + 时间切片结算 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day35/StackDeferredProcessingQuestion1.java` |
| `232` | 用栈实现队列 | 栈 / 队列 | 双栈模拟队列 / FIFO 语义转换 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day35/QueueOrderedProcessingQuestion1.java` |
| `225` | 用队列实现栈 | 栈 / 队列 | 单队列轮转模拟栈 / LIFO 语义转换 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day35/QueueOrderedProcessingQuestion1.java` |
| `239` | 滑动窗口最大值 | 队列 / 单调队列 | 窗口推进 + 单调队列维护最值 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day35/QueueOrderedProcessingQuestion1.java` |
| `85` | 最大矩形 | 单调栈 | 二维转一维边界扩展 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day35/MonotonicStackBoundaryQuestion1.java` |

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
| Day36 | `199` | 二叉树的右视图 | 二叉树 / BFS | 按层聚合 / 右侧视角 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreeBfsLayerQuestion1.java` |
| Day36 | `111` | 二叉树的最小深度 | 二叉树 / BFS | 按层最早到达叶子 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreeBfsLayerQuestion1.java` |
| Day36 | `103` | 二叉树的锯齿形层序遍历 | 二叉树 / BFS | 按层遍历 / 交替输出 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreeBfsLayerQuestion1.java` |
| Day36 | `100` | 相同的树 | 二叉树 / DFS | 递归结构判断 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreeDfsTraversalQuestion1.java` |
| Day36 | `101` | 对称二叉树 | 二叉树 / DFS | 镜像递归判断 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreeDfsTraversalQuestion1.java` |
| Day36 | `617` | 合并二叉树 | 二叉树 / DFS | 递归合并子树 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreeDfsTraversalQuestion1.java` |
| Day36 | `110` | 平衡二叉树 | 二叉树 / DFS | 后序归并 / 高度与平衡性 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreePostorderMergeQuestion1.java` |
| Day36 | `124` | 二叉树中的最大路径和 | 二叉树 / DFS | 后序归并 / 单边贡献 + 全局最优 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreePostorderMergeQuestion1.java` |
| Day36 | `337` | 打家劫舍 III | 二叉树 / DFS | 后序归并 / 多状态返回 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreePostorderMergeQuestion1.java` |
| Day36 | `112` | 路径总和 | 二叉树 / DFS | 根到叶路径存在性判断 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreePathStateQuestion1.java` |
| Day36 | `113` | 路径总和 II | 二叉树 / DFS | 收集所有根到叶路径 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreePathStateQuestion1.java` |
| Day36 | `129` | 求根节点到叶节点数字之和 | 二叉树 / DFS | 路径数值累积 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/TreePathStateQuestion1.java` |
| Day36 | `98` | 验证二叉搜索树 | 二叉树 / BST | 上下界校验 / 全局有序性 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/BstOrderedPropertyQuestion1.java` |
| Day36 | `230` | 二叉搜索树中第 K 小的元素 | 二叉树 / BST | 中序有序性 / 第 k 小 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/BstOrderedPropertyQuestion1.java` |
| Day36 | `700` | 二叉搜索树中的搜索 | 二叉树 / BST | 有序性定向查找 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/BstOrderedPropertyQuestion1.java` |
| Day36 | `235` | 二叉搜索树的最近公共祖先 | 二叉树 / BST | 大小关系剪枝定位 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day36/BstOrderedPropertyQuestion1.java` |
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
| Day31 | `485` | 最大连续 1 的个数 | 数组 / 滑动窗口 | 窗口内 0 个数约束 / 右开区间窗口复习 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion3.java` |
| Day31 | `643` | 子数组最大平均数 I | 数组 / 滑动窗口 | 固定长度窗口 / 区间和维护 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion3.java` |
| Day31 | `904` | 水果成篮 | 数组 / 滑动窗口 | 变长窗口 / 最长合法区间 / 种类数约束 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion3.java` |
| Day31 | `1004` | 最大连续 1 的个数 III | 数组 / 滑动窗口 | 容错型窗口 / 坏元素计数 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion3.java` |
| Day31 | `713` | 乘积小于 K 的子数组 | 数组 / 滑动窗口 | 统计型窗口 / 正数乘积约束 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion3.java` |
| Day32 | `217` | 存在重复元素 | 哈希表 | `HashSet` 存在性判断 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion1.java` |
| Day32 | `128` | 最长连续序列 | 哈希表 | `HashSet` + 起点枚举 | 已完成（复刷） | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion1.java` |
| Day32 | `1` | 两数之和 | 哈希表 | 补数查找 + `HashMap` | 已完成（复刷） | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion2.java` |
| Day32 | `205` | 同构字符串 | 哈希表 | 双向映射关系 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion2.java` |
| Day32 | `290` | 单词规律 | 哈希表 / 字符串 | 双向映射关系 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion2.java` |
| Day32 | `242` | 有效的字母异位词 | 哈希表 / 字符串 | 计数统计 | 已完成（复刷） | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion3.java` |
| Day32 | `169` | 多数元素 | 哈希表 | 计数统计 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion3.java` |
| Day32 | `347` | 前 K 个高频元素 | 哈希表 / 堆 | 哈希统计 + 堆 | 已完成（复刷） | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion3.java` |
| Day32 | `49` | 字母异位词分组 | 哈希表 / 字符串 | 分组归类 + 稳定 key | 已完成（复刷） | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion4.java` |
| Day32 | `249` | 移位字符串分组 | 哈希表 / 字符串 | 分组归类 / 稳定 key 设计 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion4.java` |
| Day32 | `560` | 和为 K 的子数组 | 哈希表 / 前缀和 | 前缀和 + 哈希计数 | 已完成（复刷） | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion5.java` |
| Day32 | `974` | 和可被 K 整除的子数组 | 哈希表 / 前缀和 | 前缀和 + 余数计数 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion5.java` |
| Day32 | `523` | 连续的子数组和 | 哈希表 / 前缀和 | 前缀和 + 最早位置 / 余数位置映射 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion5.java` |
| Day32 | `930` | 和相同的二元子数组 | 哈希表 / 前缀和 | 前缀和 + 哈希计数 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion5.java` |
| Day32 | `325` | 和等于 k 的最长子数组长度 | 哈希表 / 前缀和 | 前缀和 + 最早位置 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day32/HashQuestion5.java` |
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
| Day35 | `150` | 逆波兰表达式求值 | 栈 | 普通栈 / 表达式求值 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day35/StackDeferredProcessingQuestion1.java` |
| Day35 | `636` | 函数的独占时间 | 栈 | 普通栈 / 调用栈模拟 + 时间切片结算 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day35/StackDeferredProcessingQuestion1.java` |
| Day35 | `316` | 去除重复字母 | 栈 / 贪心 | 普通栈回退 / 最小去重子序列 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day35/StackDeferredProcessingQuestion1.java` |
| Day35 | `232` | 用栈实现队列 | 栈 / 队列 | 队列语义转换 / 双栈模拟 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day35/QueueOrderedProcessingQuestion1.java` |
| Day35 | `225` | 用队列实现栈 | 栈 / 队列 | 栈语义转换 / 单队列轮转模拟 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day35/QueueOrderedProcessingQuestion1.java` |
| Day35 | `239` | 滑动窗口最大值 | 队列 / 单调队列 | 窗口推进 + 单调队列维护最值 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day35/QueueOrderedProcessingQuestion1.java` |
| Day35 | `739` | 每日温度 | 单调栈 | 最近更大元素 | 已完成（复刷） | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day35/MonotonicStackNearestQuestion1.java` |
| Day35 | `1475` | 商品折扣后的最终价格 | 单调栈 | 右侧第一个小于等于元素 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day35/MonotonicStackNearestQuestion1.java` |
| Day35 | `84` | 柱状图中最大的矩形 | 单调栈 | 左右最近更小元素 / 边界扩展 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day35/MonotonicStackBoundaryQuestion1.java` |
| Day35 | `85` | 最大矩形 | 单调栈 | 二维转一维边界扩展 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day35/MonotonicStackBoundaryQuestion1.java` |
| Day37 | `973` | 最接近原点的 K 个点 | 堆 | TopK 固定容量堆 / 距离候选保留 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day37/HeapTopKQuestion1.java` |
| Day37 | `692` | 前 K 个高频单词 | 哈希表 / 堆 | 哈希统计 + 堆 / 频次 + 字典序比较 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day37/HeapFrequencyQuestion1.java` |
| Day37 | `373` | 查找和最小的 K 对数字 | 堆 | 多路归并 / 来源下标扩展 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day37/HeapMultiWayMergeQuestion1.java` |
| Day37 | `378` | 有序矩阵中第 K 小的元素 | 堆 | 多路归并 / 有序矩阵头部扩展 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day37/HeapMultiWayMergeQuestion1.java` |
| Day37 | `703` | 数据流中的第 K 大元素 | 堆 | 数据流维护 / 固定容量堆 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day37/HeapDataStreamQuestion1.java` |
| Day37 | `295` | 数据流的中位数 | 堆 | 数据流维护 / 双堆平衡 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day37/HeapDataStreamQuestion1.java` |
| Day37 | `253` | 会议室 II | 堆 | 优先级调度 / 最早结束资源复用 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day37/HeapSchedulingQuestion1.java` |
| Day37 | `1167` | 连接棒材的最低费用 | 堆 / 贪心 | 优先级调度 / 最小代价合并 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day37/HeapSchedulingQuestion1.java` |
| Day38 | `35` | 搜索插入位置 | 二分查找 | 基础二分 / 搜索或插入位置 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day38/BinarySearchBasicQuestion1.java` |
| Day38 | `74` | 搜索二维矩阵 | 二分查找 | 基础二分 / 矩阵映射到一维有序区间 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day38/BinarySearchBasicQuestion1.java` |
| Day38 | `278` | 第一个错误的版本 | 二分查找 | 边界二分 / 第一个满足条件的位置 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day38/BinarySearchBoundaryQuestion1.java` |
| Day38 | `744` | 寻找比目标字母大的最小字母 | 二分查找 | 边界二分 / 第一个大于目标的位置 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day38/BinarySearchBoundaryQuestion1.java` |
| Day38 | `275` | H 指数 II | 二分查找 | 边界二分 / 有序计数数组中的最大合法 h | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day38/BinarySearchBoundaryQuestion1.java` |
| Day38 | `153` | 寻找旋转排序数组中的最小值 | 二分查找 | 变体二分 / 旋转数组最小值定位 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day38/BinarySearchVariantQuestion1.java` |
| Day38 | `162` | 寻找峰值 | 二分查找 | 变体二分 / 峰值定位 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day38/BinarySearchVariantQuestion1.java` |
| Day38 | `540` | 有序数组中的单一元素 | 二分查找 | 变体二分 / 成对结构错位定位 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day38/BinarySearchVariantQuestion1.java` |
| Day38 | `1011` | 在 D 天内送达包裹的能力 | 二分查找 | 答案空间二分 / 最小可行运载能力 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day38/BinarySearchAnswerSpaceQuestion1.java` |
| Day38 | `410` | 分割数组的最大值 | 二分查找 | 答案空间二分 / 最小化最大分段和 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day38/BinarySearchAnswerSpaceQuestion1.java` |
| Day38 | `1482` | 制作 m 束花所需的最少天数 | 二分查找 | 答案空间二分 / 最小可行等待天数 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day38/BinarySearchAnswerSpaceQuestion1.java` |
| Day39 | `90` | 子集 II | 回溯 | 子集型 / 去重 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day39/BacktrackingSubsetQuestion1.java` |
| Day39 | `491` | 非递减子序列 | 回溯 | 子集型 / 去重 + 保序 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day39/BacktrackingSubsetQuestion1.java` |
| Day39 | `77` | 组合 | 回溯 | 组合型 / 固定选择数量 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day39/BacktrackingCombinationQuestion1.java` |
| Day39 | `40` | 组合总和 II | 回溯 | 组合型 / 去重 + 单次使用 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day39/BacktrackingCombinationQuestion1.java` |
| Day39 | `216` | 组合总和 III | 回溯 | 组合型 / 固定数量 + 固定取值范围 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day39/BacktrackingCombinationQuestion1.java` |
| Day39 | `47` | 全排列 II | 回溯 | 排列型 / 去重 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day39/BacktrackingPermutationQuestion1.java` |
| Day39 | `131` | 分割回文串 | 回溯 | 切割型 / 回文分段 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day39/BacktrackingPartitionQuestion1.java` |
| Day39 | `93` | 复原 IP 地址 | 回溯 | 切割型 / 固定段数 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day39/BacktrackingPartitionQuestion1.java` |
| Day39 | `17` | 电话号码的字母组合 | 回溯 | 约束构造型 / 字母映射 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day39/BacktrackingConstraintQuestion1.java` |
| Day39 | `51` | N 皇后 | 回溯 | 约束构造型 / 皇后摆放 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day39/BacktrackingConstraintQuestion1.java` |
| Day40 | `695` | 岛屿的最大面积 | 图 | 连通性 / 连通块面积统计 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day40/GraphConnectivityQuestion1.java` |
| Day40 | `733` | 图像渲染 | 图 | 连通性 / 同值区域扩散 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day40/GraphConnectivityQuestion1.java` |
| Day40 | `130` | 被围绕的区域 | 图 | 连通性 / 边界连通区域判断 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day40/GraphConnectivityQuestion1.java` |
| Day40 | `1091` | 二进制矩阵中的最短路径 | 图 | 最短步数 / 分层 BFS | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day40/GraphShortestPathQuestion1.java` |
| Day40 | `542` | 01 矩阵 | 图 | 最短步数 / 多源 BFS 距离扩散 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day40/GraphShortestPathQuestion1.java` |
| Day40 | `210` | 课程表 II | 图 | 拓扑排序 / 合法顺序构造 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day40/GraphTopologicalSortQuestion1.java` |
| Day40 | `1462` | 课程表 IV | 图 | 拓扑排序 / 先修关系传递判断 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day40/GraphTopologicalSortQuestion1.java` |
| Day40 | `752` | 打开转盘锁 | 图 | 状态搜索 / 字符串状态变换 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day40/GraphStateSearchQuestion1.java` |
| Day40 | `433` | 最小基因变化 | 图 | 状态搜索 / 基因状态变换 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day40/GraphStateSearchQuestion1.java` |
| Day41 | `509` | 斐波那契数 | 动态规划 | 一维线性 DP / 基础递推 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day41/DpLinearRecurrenceQuestion1.java` |
| Day41 | `746` | 使用最小花费爬楼梯 | 动态规划 | 一维线性 DP / 最小代价递推 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day41/DpLinearRecurrenceQuestion1.java` |
| Day41 | `91` | 解码方法 | 动态规划 | 一维线性 DP / 前一位与前两位转移 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day41/DpLinearRecurrenceQuestion1.java` |
| Day41 | `213` | 打家劫舍 II | 动态规划 | 选或不选 DP / 环形约束 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day41/DpDecisionQuestion1.java` |
| Day41 | `740` | 删除并获得点数 | 动态规划 | 选或不选 DP / 值域聚合 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day41/DpDecisionQuestion1.java` |
| Day41 | `279` | 完全平方数 | 动态规划 | 完全背包 / 最少物品数 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day41/DpCompleteKnapsackQuestion1.java` |
| Day41 | `518` | 零钱兑换 II | 动态规划 | 完全背包 / 组合计数 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day41/DpCompleteKnapsackQuestion1.java` |
| Day41 | `377` | 组合总和 IV | 动态规划 | 完全背包 / 排列计数 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day41/DpCompleteKnapsackQuestion1.java` |
| Day41 | `1143` | 最长公共子序列 | 动态规划 | 序列型 DP / 二维匹配 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day41/DpSequenceQuestion1.java` |
| Day41 | `72` | 编辑距离 | 动态规划 | 序列型 DP / 编辑操作代价 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day41/DpSequenceQuestion1.java` |
| Day41 | `516` | 最长回文子序列 | 动态规划 | 序列型 DP / 回文子序列范围 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week6/day41/DpSequenceQuestion1.java` |
| Day31 | `88` | 合并两个有序数组 | 数组 | 遍历与模拟 / 原地合并 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion.java` |
| Day31 | `54` | 螺旋矩阵 | 数组 | 遍历与模拟 / 边界收缩 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion.java` |
| Day31 | `59` | 螺旋矩阵 II | 数组 | 遍历与模拟 / 边界收缩 + 按序填充 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion.java` |
| Day31 | `26` | 删除有序数组中的重复项 | 数组 | 快慢指针 / 原地去重覆盖 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion2.java` |
| Day31 | `27` | 移除元素 | 数组 | 快慢指针 / 原地过滤覆盖 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion2.java` |
| Day31 | `283` | 移动零 | 数组 | 快慢指针 / 稳定搬移 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion2.java` |
| Day31 | `42` | 接雨水 | 数组 / 前后缀 / 双指针 | 前后缀最大值 + 左右夹逼逐步结算 | 已完成 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| Day31 | `238` | 除自身以外数组的乘积 | 数组 | 前后缀分解 | 已完成（复刷） | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| Day31 | `560` | 和为 K 的子数组 | 数组 / 前缀和 | 前缀和 + 哈希计数 | 已完成（复刷） | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| Day31 | `525` | 连续数组 | 数组 / 前缀和 | 前缀和 + 最早位置 | 已完成（复刷） | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| Day31 | `974` | 和可被 K 整除的子数组 | 数组 / 前缀和 | 前缀和 + 余数计数 | 已完成（复刷） | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| Day31 | `523` | 连续的子数组和 | 数组 / 前缀和 | 前缀和 + 最早位置 / 余数位置映射 | 已完成（复刷） | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| Day31 | `930` | 和相同的二元子数组 | 数组 / 前缀和 | 前缀和 + 哈希计数 | 已完成（复刷） | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| Day31 | `325` | 和等于 k 的最长子数组长度 | 数组 / 前缀和 | 前缀和 + 最早位置 | 已完成（复刷） | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| Day31 | `34` | 在排序数组中查找元素的第一个和最后一个位置 | 二分查找 | 边界二分 | 已完成（复刷） | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| Day31 | `33` | 搜索旋转排序数组 | 二分查找 | 变体二分 | 已完成（复刷） | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| Day31 | `875` | 爱吃香蕉的珂珂 | 二分查找 | 答案空间二分 | 已完成（复刷） | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| Day31 | `303` | 区域和检索 - 数组不可变 | 数组 / 前缀和 | 区间和查询 / 前缀差 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| Day31 | `724` | 寻找数组的中心下标 | 数组 / 前缀和 | 左右和相等 / 前缀差 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| Day31 | `41` | 缺失的第一个正数 | 数组 | 原地交换 / 下标映射 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| Day31 | `448` | 找到所有数组中消失的数字 | 数组 | 原地标记 / 正负号标记 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |
| Day31 | `704` | 二分查找 | 二分查找 | 基础命中二分 | 已初始化待做 | `code/algorithm/src/main/java/com/leisure/note/algorithm/week5/day31/ArrayQuestion4.java` |

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

- `原地交换 / 原地标记`
  - 已初始化题：`41`、`448`
  - 当前关注点：
    - `41` 重点在“值应该去哪个下标”以及 while 交换的停止条件
    - `448` 重点在“如何借当前位置给目标数字做出现标记”
    - 两类题都要先防死循环、重复交换和越界访问

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

- `纯数组前缀和`
  - 已初始化题：`303`、`724`
  - 当前关注点：
    - `303` 重点在前缀数组定义和区间差公式
    - `724` 重点在总和、左侧和、右侧和之间的等式转换
    - 先把“纯前缀差”讲稳，再和哈希版前缀和区分开

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

- `基础命中二分`
  - 已初始化题：`704`、`35`、`74`
  - 当前关注点：
    - 先统一左闭右闭或左闭右开的区间语义
    - 命中即返回、未命中返回插入位置，这两类返回语义不要混淆
    - 能把二维矩阵映射成一个连续有序搜索空间

- `边界二分`
  - 已覆盖题：`34`
  - 已初始化题：`278`、`744`、`275`
  - 当前关注点：
    - 先把题目翻译成“第一个满足条件的位置”
    - 命中后继续收缩，直到边界稳定
    - 不同返回语义下要补合法性校验

- `变体二分`
  - 已覆盖题：`33`
  - 已初始化题：`153`、`162`、`540`
  - 当前关注点：
    - 每轮先识别哪一半仍然具备可利用结构
    - 旋转数组、峰值、成对结构三类判定条件不要混淆
    - 重点训练“为什么这一半可以被排除”

- `答案空间二分`
  - 已覆盖题：`875`
  - 已初始化题：`1011`、`410`、`1482`
  - 当前关注点：
    - 先定答案上下界，再写可行性检查
    - `check(mid)` 的单调性必须先说清
    - 训练“最小可行值”类题目的收缩方向

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

- `3.1 普通栈：匹配、回退、延迟处理`
  - 已覆盖题：`20`、`150`、`636`、`316`
  - 已掌握内容：
    - 栈保存的是“最近还没消化完的上下文”，不只是数字或括号本身
    - `150` 是操作数延迟结算，`636` 是调用过程延迟结算，`316` 是当前选择不优时的回退重构
    - `20` 和 `155` 这类基础题能帮助快速建立“栈顶就是最近状态”的直觉
  - 近期不优先再出：
    - 与 `20`、`150` 高度同构的基础括号匹配 / 后缀表达式题
  - 后续更适合补：
    - `71`

- `3.2 队列：顺序处理与窗口推进`
  - 已覆盖题：`232`、`225`、`239`
  - 已掌握内容：
    - 如何用双栈 / 双队列做结构语义转换
    - 窗口推进时，队头为什么代表“最早或最该出队的状态”
    - `239` 里为什么需要从普通队列升级成单调队列
    - `225` 里如何通过单队列轮转把“最新元素”提前到队头
  - 近期不优先再出：
    - 与 `232`、`225` 高度同构的基础结构模拟题

- `3.3 单调栈：找最近更大 / 更小元素`
  - 已覆盖题：`739`、`496`、`1475`
  - 已掌握内容：
    - 栈里通常保存“还没找到答案的位置”，当前元素出现时负责结算左边元素
    - “更大 / 更小”决定单调方向，“是否带等号”决定比较符号
    - `739` 和 `1475` 适合对照记忆严格更大与小于等于这两类模板差异
  - 近期不优先再出：
    - 纯基础的最近更大 / 更小模板题

- `3.4 单调栈求区间边界`
  - 已覆盖题：`84`
  - 已初始化待做：`85`
  - 已掌握内容：
    - 每个位置都能拆成“左边第一个更小 + 右边第一个更小”的边界模型
    - `84` 的核心不是求当前位置上方容量，而是求当前位置作为最短板时的最大可扩宽度
  - 当前应继续补：
    - `85`

### 6.8 二叉树 / DFS / BFS

- `3.1 BFS：层序遍历和按层处理`
  - 已覆盖题：`102`
  - 已初始化题：`199`、`111`、`103`
  - 已掌握内容：
    - `102` 已覆盖最基础的分层遍历模板
  - 当前关注点：
    - `199` 继续练“每层只取一个聚合结果”
    - `111` 继续练“最早到达目标层即可返回”
    - `103` 继续练“层序框架不变，但每层输出顺序发生变化”

- `3.2 DFS：递归遍历和子树问题拆解`
  - 已覆盖题：`104`、`94`、`144`、`145`、`226`
  - 已初始化题：`100`、`101`、`617`
  - 已掌握内容：
    - 基础遍历顺序、树递归和简单结构改造已经覆盖
  - 当前关注点：
    - `100`、`101` 继续练“两个子树如何同步递归比较”
    - `617` 继续练“当前节点结果如何由左右位置递归构造”

- `3.3 后序 DFS：信息归并题`
  - 已覆盖题：`543`、`236`
  - 已初始化题：`110`、`124`、`337`
  - 已掌握内容：
    - `543` 已覆盖“返回值”和“全局答案”分离
    - `236` 已覆盖“递归返回候选节点”这类归并方式
  - 当前关注点：
    - `110` 继续练“高度和状态一起归并”
    - `124` 继续练“单边返回值”和“当前节点结算值”分离
    - `337` 继续练“子树向上返回多个状态”

- `3.4 路径问题：沿递归路径维护状态`
  - 已初始化题：`112`、`113`、`129`
  - 当前关注点：
    - `112` 练“根到叶路径存在性判断”
    - `113` 练“收集所有路径时的路径保存”
    - `129` 练“路径状态从和扩展到数字构造”

- `3.5 BST：利用有序性剪枝和定位`
  - 已初始化题：`98`、`230`、`700`、`235`
  - 当前关注点：
    - `98` 练“全局上下界校验”，避免只看父子节点
    - `230` 练“利用 BST 中序有序性”
    - `700`、`235` 练“基于大小关系定向走树和剪枝”

### 6.9 回溯

- `3.1 子集型：每个元素选或不选`
  - 已覆盖题：`78`
  - 已初始化题：`90`、`491`
  - 当前关注点：
    - `90` 继续练“输入有重复元素时如何避免生成重复子集”
    - `491` 继续练“子序列必须保序，但结果又不能重复”

- `3.2 组合型：从候选里选若干个满足条件`
  - 已覆盖题：`39`
  - 已初始化题：`77`、`40`、`216`
  - 当前关注点：
    - `77` 练“固定选取数量”
    - `40` 练“有重复候选时的组合去重”
    - `216` 练“固定数量 + 固定取值范围 + 固定目标和”

- `3.3 排列型：顺序本身就是答案的一部分`
  - 已覆盖题：`46`
  - 已初始化题：`47`
  - 当前关注点：
    - `47` 继续练“输入带重复值时如何去重”

- `3.4 切割型：在字符串上切分合法片段`
  - 已初始化题：`131`、`93`
  - 当前关注点：
    - `131` 练“按切割位置枚举所有回文分段”
    - `93` 练“固定切 4 段且每段都有合法数值范围”

- `3.5 约束构造型：在生成过程中持续满足条件`
  - 已覆盖题：`22`
  - 已初始化题：`17`、`51`
  - 当前关注点：
    - `17` 练“按每一位的可选字符进行构造”
    - `51` 练“棋盘约束下的逐行构造与冲突判断”

### 6.10 动态规划

- `3.1 一维线性 DP：线性递推型`
  - 已覆盖题：`70`
  - 已初始化题：`509`、`746`、`91`
  - 当前关注点：
    - `509` 练最基础的单步递推和初始化
    - `746` 练“到达顶部”不等于“停在最后一个下标”的返回语义
    - `91` 练当前状态同时依赖前一位与前两位，并受编码合法性约束

- `3.1 一维线性 DP：选或不选型`
  - 已覆盖题：`198`
  - 已初始化题：`213`、`740`
  - 当前关注点：
    - `213` 练环形相邻约束下的区间拆分
    - `740` 练先做值域聚合，再处理相邻冲突决策

- `3.2 完全背包 / 容量 DP`
  - 已覆盖题：`322`
  - 已初始化题：`279`、`518`、`377`
  - 当前关注点：
    - `279` 练最值型完全背包
    - `518` 练组合计数和“顺序不同不算新方案”
    - `377` 练排列计数和“顺序不同算不同答案”

- `3.3 序列型 DP`
  - 已覆盖题：`300`
  - 已初始化题：`1143`、`72`、`516`
  - 当前关注点：
    - `1143` 练二维前缀范围上的匹配关系
    - `72` 练插入、删除、替换三种编辑操作
    - `516` 练回文子序列的范围状态

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

为了避免到当天再临时选题，当前已经按计划预生成到 Day41，并额外补出了 Day31 的数组模式、Day33 的链表模式、Day35 的栈 / 队列 / 单调栈模式题、Day36 的树专题模式题、Day37 的堆专题模式题、Day38 的二分专题模式题、Day39 的回溯专题模式题、Day40 的图专题模式题，以及 Day41 的动态规划模式题：

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
  - `ArrayQuestion3`：
    - `485`、`643`、`904`、`1004`、`713`
  - `ArrayQuestion`：
    - `88`、`54`、`59`
  - `ArrayQuestion2`：
    - `26`、`27`、`283`
  - `ArrayQuestion4`：
    - `238`、`560`、`525`、`974`、`523`、`930`、`325`
    - `42`、`34`、`33`、`875`
    - `303`、`724`、`41`、`448`、`704`
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
- Day35：
  - `StackDeferredProcessingQuestion1`：
    - `150`、`636`、`316`
  - `QueueOrderedProcessingQuestion1`：
    - `232`、`225`、`239`
  - `MonotonicStackNearestQuestion1`：
    - `739`、`1475`
  - `MonotonicStackBoundaryQuestion1`：
    - `84`、`85`
- Day36：
  - `TreeBfsLayerQuestion1`：
    - `199`、`111`、`103`
  - `TreeDfsTraversalQuestion1`：
    - `100`、`101`、`617`
  - `TreePostorderMergeQuestion1`：
    - `110`、`124`、`337`
  - `TreePathStateQuestion1`：
    - `112`、`113`、`129`
  - `BstOrderedPropertyQuestion1`：
    - `98`、`230`、`700`、`235`
- Day37：
  - `HeapTopKQuestion1`：
    - `973`
  - `HeapFrequencyQuestion1`：
    - `692`
  - `HeapMultiWayMergeQuestion1`：
    - `373`、`378`
  - `HeapDataStreamQuestion1`：
    - `703`、`295`
  - `HeapSchedulingQuestion1`：
    - `253`、`1167`
- Day38：
  - `BinarySearchBasicQuestion1`：
    - `35`、`74`
  - `BinarySearchBoundaryQuestion1`：
    - `278`、`744`、`275`
  - `BinarySearchVariantQuestion1`：
    - `153`、`162`、`540`
  - `BinarySearchAnswerSpaceQuestion1`：
    - `1011`、`410`、`1482`
- Day39：
  - `BacktrackingSubsetQuestion1`：
    - `90`、`491`
  - `BacktrackingCombinationQuestion1`：
    - `77`、`40`、`216`
  - `BacktrackingPermutationQuestion1`：
    - `47`
  - `BacktrackingPartitionQuestion1`：
    - `131`、`93`
  - `BacktrackingConstraintQuestion1`：
    - `17`、`51`
- Day40：
  - `GraphConnectivityQuestion1`：
    - `695`、`733`、`130`
  - `GraphShortestPathQuestion1`：
    - `1091`、`542`
  - `GraphTopologicalSortQuestion1`：
    - `210`、`1462`
  - `GraphStateSearchQuestion1`：
    - `752`、`433`
- Day41：
  - `DpLinearRecurrenceQuestion1`：
    - `509`、`746`、`91`
  - `DpDecisionQuestion1`：
    - `213`、`740`
  - `DpCompleteKnapsackQuestion1`：
    - `279`、`518`、`377`
  - `DpSequenceQuestion1`：
    - `1143`、`72`、`516`
