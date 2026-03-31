# Week1 复习总纲导航

对应计划：

- `prepare/2026/tracks/xiaomi_java_data_service/01_1month_plan.md`
- `prepare/2026/tracks/xiaomi_java_data_service/00_high_frequency_knowledge_map.md`
- `prepare/2026/tracks/xiaomi_java_data_service/reviews/rules/00_review_doc_writing_rules.md`

## 1. 文档定位

这份文件位于 `week1/hubs/00_week1_review_hub.md`，角色是 Week1 导航文档。

使用原则：

- 这份文件只负责导航、每日映射、复盘要求
- 具体知识正文全部拆到专题文档里
- 后续 Week2 及之后的复习文档，都按 `prepare/2026/tracks/xiaomi_java_data_service/reviews/rules/00_review_doc_writing_rules.md` 执行

## 2. Week1 专题文档入口

| 模块 | 专题文档 | 对应计划 | 日文档 |
| --- | --- | --- | --- |
| 并发 | `topics/01_1_threadpool_lock_system_review.md`、`topics/01_2_jmm_and_lockfree_system_review.md` | Day1-Day2 | 对应 `daily/` 日复盘文档 |
| JVM | `topics/02_1_jvm_runtime_classloading_system_review.md`、`topics/02_2_jvm_gc_troubleshooting_system_review.md` | Day3-Day4 | Day3 对应 `daily/day3_jvm_memory_classloading_review.md`，Day4 对应 `daily/day4_jvm_gc_troubleshooting_review.md` |
| MySQL | `topics/03_mysql_system_review.md` | Day5 | 无单独日文档，直接看专题文档 |
| Redis | `topics/04_redis_system_review.md` | Day6 | 无单独日文档，直接看专题文档 |
| Kafka | `topics/05_kafka_system_review.md` | Day6 | 无单独日文档，直接看专题文档 |

## 3. 每日映射

| Day | 模块 | 重点目标 | 对应文档 |
| --- | --- | --- | --- |
| Day1 | 线程池、锁 | 建立并发控制的资源视角和锁选型视角 | `topics/01_1_threadpool_lock_system_review.md` + `daily/day1_threadpool_lock_review.md` |
| Day2 | JMM、`volatile`、CAS、AQS、并发容器 | 建立并发语义视角，理解有锁和无锁两类方案 | `topics/01_2_jmm_and_lockfree_system_review.md` + `daily/day2_jmm_cas_aqs_review.md` |
| Day3 | JVM 内存结构、对象创建、类加载 | 区分 JVM 和 JMM，打通对象创建与类加载主线 | `topics/02_1_jvm_runtime_classloading_system_review.md` + `daily/day3_jvm_memory_classloading_review.md` |
| Day4 | GC、收集器、线上排障 | 建立 GC、停顿和线上排障的稳定分析链路 | `topics/02_2_jvm_gc_troubleshooting_system_review.md` + `daily/day4_jvm_gc_troubleshooting_review.md` |
| Day5 | MySQL 索引、事务、MVCC、慢 SQL | 建立 SQL 执行、事务并发和排查思维 | `topics/03_mysql_system_review.md` |
| Day6 | Redis、Kafka | 建立缓存与消息队列的工程化认知 | `topics/04_redis_system_review.md` + `topics/05_kafka_system_review.md` |
| Day7 | 周复盘 | 只复盘主线和薄弱点，不回炉全量笔记 | 本文件 + 各专题文档自测清单 |

## 4. 使用方式

### 4.1 每天如何用

1. 先看当日对应专题文档的“这一块在解决什么问题”
2. 再过知识树，建立整体地图
3. 再看核心重点展开，把机制和边界讲顺
4. 再用自测清单检查自己是否只会背标签
5. 最后回到日文档或口头输出做复盘

### 4.2 掌握度标准

- `L1`：
  - 能说清这块知识解决什么问题、有哪些核心概念
- `L2`：
  - 能说清核心机制、关键流程、常见对比和适用场景
- `L3`：
  - 能承接边界、线上问题、调优思路和项目落地

Week1 建议目标：

- 并发、JVM、MySQL、Redis、Kafka 至少达到 `L2`
- 你的强项模块尽量往 `L3` 靠
- 如果某块只能背定义、讲不出机制，就不算过关

## 5. 算法恢复线

如果你希望第一周复习更完整，算法部分可以按下面这条线同步恢复：

- 数组 / 哈希：
  - 建立“下标、频次、映射”视角
- 双指针：
  - 明确左右指针移动的单调性依据
- 滑动窗口：
  - 先定义窗口，再定义扩张 / 收缩条件
- 前缀和 + 哈希：
  - 把区间问题转成前缀关系问题
- 二分：
  - 明确答案空间和单调性

Week1 算法不要求刷很多题，而要求你恢复这四件事：

- 能识别题型
- 能说明为什么用这个模板
- 能口头讲清核心不变量
- 能写出不容易越界的代码
## 6. Week1 周复盘方法

### 6.1 每天复盘只做四件事

1. 今天这一块的知识树能不能脱稿说出来
2. 今天至少 1 个机制能不能按因果链讲清
3. 今天最容易被追问散掉的点是什么
4. 今天这块能不能和项目或线上场景挂上钩
### 6.2 周末复盘不要从头重看

周末建议只做下面几件事：

- 抽查并发、JVM、MySQL、Redis、Kafka 各 1 题
- 每题先讲 1 分钟版本，再补 3 分钟版本
- 只重看自己讲散的模块
- 记录本周最弱的 3 个点
### 6.3 第一周最小达标标准

如果 Week1 结束时，下面这些你都能稳定讲出来，就算本周节奏是对的：

- 线程池为什么是资源管理问题，不只是线程数量问题
- `volatile`、锁、CAS 分别解决什么问题
- JVM 内存结构和 JMM 的区别
- 对象创建、类加载、DCL 为什么会被连在一起问
- MySQL 索引、MVCC、慢 SQL 排查主线
- Redis 的快、缓存问题和一致性边界
- Kafka 的吞吐、可靠性、顺序性和重复消费边界
## 7. 与日复盘文档关系

建议这样配合使用：

- 本文档：
  - 负责系统复习和知识结构搭建
- `daily/day1_threadpool_lock_review.md`：
  - 负责 Day1 并发资源控制和锁的展开
- `daily/day2_jmm_cas_aqs_review.md`：
  - 负责 Day2 并发语义和无锁并发的展开
- `daily/day3_jvm_memory_classloading_review.md`：
  - 负责 Day3 JVM 基础主线的展开
- `daily/day4_jvm_gc_troubleshooting_review.md`：
  - 负责 Day4 GC 主线、线上排障和前缀和 + 哈希题型复盘

如果你后面愿意继续细化，最适合的下一步不是再堆“标准答案”，而是继续补：

- Day4 JVM GC / 排障专项
- Day5 MySQL 系统复习文档
- Day6 Redis / Kafka 系统复习文档

这样 Week1 的知识层会更完整，后面再回到面试答题，表达会稳很多。
