# Week2 Day14 算法专题验收清单

适用位置：

- 对应 `prepare/2026/tracks/xiaomi_java_data_service/algorithms/90_1month_algorithm_plan.md` 中的 `Week2 Day14`
- 这是专题验收日，不是新增代码题日

## 1. 这一天做什么

这一天的目标不是继续开新题，而是检查 `Week2 Day8-Day13` 这些专题是否真正吃透：

- 哈希分组 / 计数
- 链表基础
- 快慢指针
- 栈
- 单调栈
- 二分查找

## 2. 重讲题

先脱稿口头讲下面 4 题，每题控制在 `2-3` 分钟：

1. `49. 字母异位词分组`
   - 路径：`code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day8/HashGroupingQuestion1.java`
2. `206. 反转链表`
   - 路径：`code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day9/LinkedListQuestion1.java`
3. `739. 每日温度`
   - 路径：`code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day12/MonotonicStackQuestion1.java`
4. `875. 爱吃香蕉的珂珂`
   - 路径：`code/algorithm/src/main/java/com/leisure/note/algorithm/week2/day13/BinarySearchQuestion2.java`

重讲时至少要包含：

- 为什么想到这个专题模板
- 核心状态怎么定义
- 复杂度为什么成立
- 1 个最容易错的点

## 3. 抽查题

如果当天状态正常，再从下面每类里各抽 1 题做快速检查：

### 3.1 哈希

- `242. 有效的字母异位词`
- `49. 字母异位词分组`

### 3.2 链表

- `21. 合并两个有序链表`
- `19. 删除链表的倒数第 N 个结点`

### 3.3 单调栈

- `496. 下一个更大元素 I`
- `739. 每日温度`

### 3.4 二分

- `33. 搜索旋转排序数组`
- `875. 爱吃香蕉的珂珂`

要求：

- 不一定都重新写完整代码
- 但至少要口头说出：
  - 题型
  - 状态 / 指针 / 栈 / 单调性
  - 为什么不会漏解

## 4. 错题回看

把本周最不稳的 2 题重新做一遍。

判断“不稳”的标准：

- 会写，但讲不清
- 会结论，但不知道为什么
- 经常写错边界
- 一离开提示就想不起来模板

## 5. 当天输出

当天至少输出下面 3 份小结：

1. 链表题 3 条主线
   - 反转
   - 快慢指针
   - 拼接 / `dummy node`
2. 单调栈题 2 个模板
   - 最近更大 / 更小元素
   - 区间边界
3. 二分题 2 种类型
   - 变体二分
   - 答案空间二分

## 6. 达标标准

如果这一天结束时，下面这些能做到，就算通过：

- 能脱稿讲清 `49`、`206`、`739`、`875`
- 能区分：
  - 哈希计数 vs 分组归类
  - 链表反转 vs 快慢指针
  - 普通栈 vs 单调栈
  - 变体二分 vs 答案空间二分
- 能明确说出本周最弱的 2 题，并知道下周是否还需要回刷
