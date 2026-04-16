# 算法准备总览

适用目标：

- 面试准备阶段，系统建立算法知识框架
- 不平均刷题，优先拿稳高频数据结构和算法模式
- 作为后续各专题文档的总入口

专题导航：

- `prepare/2026/tracks/xiaomi_java_data_service/algorithms/01_arrays.md`
- `prepare/2026/tracks/xiaomi_java_data_service/algorithms/02_hashing.md`
- `prepare/2026/tracks/xiaomi_java_data_service/algorithms/03_linked_list.md`
- `prepare/2026/tracks/xiaomi_java_data_service/algorithms/04_stack_queue_monotonic_stack.md`
- `prepare/2026/tracks/xiaomi_java_data_service/algorithms/05_strings.md`
- `prepare/2026/tracks/xiaomi_java_data_service/algorithms/06_trees_dfs_bfs.md`
- `prepare/2026/tracks/xiaomi_java_data_service/algorithms/07_heap_priority_queue.md`
- `prepare/2026/tracks/xiaomi_java_data_service/algorithms/08_binary_search.md`
- `prepare/2026/tracks/xiaomi_java_data_service/algorithms/09_backtracking.md`
- `prepare/2026/tracks/xiaomi_java_data_service/algorithms/10_graphs.md`
- `prepare/2026/tracks/xiaomi_java_data_service/algorithms/11_dynamic_programming.md`
- `prepare/2026/tracks/xiaomi_java_data_service/algorithms/12_greedy.md`

训练规则入口：

- `prepare/2026/tracks/xiaomi_java_data_service/algorithms/rules/00_algorithm_problem_rules.md`

进度与去重索引入口：

- `prepare/2026/tracks/xiaomi_java_data_service/algorithms/problem_ledger_and_dedup_index.md`

算法专项月计划入口：

- `prepare/2026/tracks/xiaomi_java_data_service/algorithms/90_1month_algorithm_plan.md`

## 1. 为什么要按专题准备

如果是 Java 后端 / 数据服务岗位，算法准备不建议一上来平均刷题，更适合按“数据结构 / 算法模式”建立知识树。

这样做的好处：

- 更容易识别题型
- 更容易复用解题套路
- 更容易沉淀自己的答题表达
- 后续查漏补缺时不容易混乱

## 2. 建议优先级

如果从面试性价比看，建议优先顺序如下：

1. 数组 / 哈希表
2. 链表
3. 栈 / 队列 / 单调栈
4. 字符串
5. 二叉树 / DFS / BFS
6. 堆 / 优先队列
7. 二分查找
8. 回溯
9. 图
10. 动态规划

为什么先学数组和哈希表：

- 它们是最基础、最常见的两类题
- 很多更复杂的题，本质上还是数组 + 哈希思维
- 这两类题最能帮助你恢复“识别题型 -> 选数据结构 -> 写复杂度 -> 说边界”的面试节奏

## 3. 高频算法模式

准备算法时，不能只按数据结构分，还要按模式去识别：

- 双指针
- 滑动窗口
- 前缀和
- 差分
- 二分答案
- DFS / BFS
- 回溯
- 贪心
- 动态规划

常见关系：

- 数组题常和双指针、滑动窗口、前缀和一起出现
- 哈希表题常和计数、映射、分组、前缀和一起出现
- 树和图常和 DFS / BFS 绑定

## 4. 复习时应该掌握到什么程度

不是每道题都要秒出最优解，但至少要做到：

### 4.1 识别题型

- 能看出题目更像哪一类数据结构题
- 能识别典型信号，比如“连续区间”“存在性判断”“分组归类”“层序遍历”

### 4.2 说清思路

- 为什么想到这个数据结构
- 核心状态怎么定义
- 为什么复杂度能降下来
- 边界和坑点在哪里

### 4.3 做到可复用

- 每个专题至少掌握几类常见套路
- 不是只记某一道题的答案，而是记“这一类题怎么解”

## 5. 推荐复习顺序

### 第一轮：建立认知

- 先看每类数据结构的特点
- 每类题型各选 1-2 题
- 重点是识别模式，不追求刷很多题

### 第二轮：按模式训练

- 数组：双指针、滑动窗口、前缀和、前后缀
- 哈希表：`Set` 存在性判断、`Map` 计数 / 索引映射、前缀和 + 哈希
- 链表：`dummy node`、快慢指针、反转、合并
- 栈 / 队列：普通栈、单调栈、单调队列
- 字符串：滑动窗口、双指针、哈希统计、字符串模拟
- 树：前中后序、DFS、BFS

补充要求：

- 每道题在完成实现并复盘后，默认要回写“解后注释”
- 注释至少补：
  - 专题定位
  - 题型特征
  - 解题思路
  - 优缺点
  - 变体 / 注意事项
- 这一步的目标不是增加文档负担，而是保证后续回看本地代码时能快速恢复题型和思路

### 第三轮：做面试化输出

- 每类题型能说出：
  - 适用场景
  - 典型信号
  - 常见坑点
  - 代表题

### 每个专题内部默认按三步推进

- 第一步：先做 1-2 道模板题
  - 目标是识别题型、建立基础写法
- 第二步：再做 2-3 道高频主战题
  - 目标是覆盖这个专题最常见、最值得面试展开的问题
- 第三步：最后做 1 道变体或验收题
  - 目标是验证自己是不是只会背模板

默认不建议：

- 一个专题里连续刷很多道思路几乎一样的题
- 只追求题量，不说明每题训练重点
- 还没讲顺模板题就急着扩展进阶题

## 6. 当前最适合你的起步顺序

结合你当前状态，建议这样推进：

### 第一步：数组

先拿稳：

- 双指针
- 滑动窗口
- 前缀和
- 前后缀分解

### 第二步：哈希表

先拿稳：

- `HashSet` 做存在性判断
- `HashMap` 做索引映射、计数统计
- 前缀和 + 哈希表

### 第三步：再进入链表、栈 / 队列、字符串和树

这时算法感觉会顺很多，因为前两步已经把最基础的表达能力找回来了。

## 7. 当前专题补充进度

目前已经补出的专题：

- `01_arrays.md`
- `02_hashing.md`
- `03_linked_list.md`
- `04_stack_queue_monotonic_stack.md`
- `05_strings.md`
- `06_trees_dfs_bfs.md`
- `07_heap_priority_queue.md`
- `08_binary_search.md`
- `09_backtracking.md`
- `10_graphs.md`
- `11_dynamic_programming.md`
- `12_greedy.md`

当前算法主线专题已经覆盖到：

1. 数组 / 哈希 / 链表
2. 栈 / 队列 / 单调栈
3. 字符串
4. 树 / DFS / BFS
5. 堆 / 优先队列
6. 二分查找
7. 回溯
8. 图
9. 动态规划
10. 贪心

后续更值得继续补的，不再是新增大类专题，而是：

1. 每个专题的验收题与错题回看
2. 高频题的口头表达模板
3. 结合月计划推进时的日复盘和专题总结
