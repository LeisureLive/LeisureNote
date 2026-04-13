# Week3 复习总纲导航

对应计划：

- `prepare/2026/tracks/xiaomi_java_data_service/01_1month_plan.md`
- `prepare/2026/tracks/xiaomi_java_data_service/00_high_frequency_knowledge_map.md`
- `prepare/2026/tracks/xiaomi_java_data_service/reviews/rules/00_review_doc_writing_rules.md`

## 1. 文档定位

这份文件位于 `week3/hubs/00_week3_review_hub.md`，角色是 Week3 导航文档。

使用原则：

- 这份文件只负责导航、每日映射、复盘要求。
- 具体知识正文全部拆到 `topics/` 目录里。
- Week3 的核心不是把更多组件名词过一遍，而是把系统设计、数据服务链路、数据平台能力和大数据开发机制压成几条稳定主线。
- 本周专题正文继续严格按“问题驱动、先回答问题、再展开机制和边界”的规则写。

## 2. 本周目标

Week3 的主线不是“做几道系统设计题”，而是把下面四条能力真正接起来：

1. 先建立一套稳定的系统设计答题骨架：需求、规模、链路、瓶颈、治理、监控。
2. 再把这套骨架落到两个最贴近目标岗位的场景：实时数据订阅、实时查询。
3. 再把高可用、幂等、一致性、分布式事务这些分布式问题，放回真实链路里理解，而不是单点背概念。
4. 最后把 Flink、Spark、HDFS、Hive、Impala、Presto、Doris 这些组件，放到“数据链路和平台能力”里讲清角色边界。

本周必须拿稳的模块：

- 系统设计方法论与分布式基础统一骨架。
- 实时数据订阅系统设计。
- 实时查询系统设计与多引擎选型。
- 高可用、幂等、一致性、分布式事务边界。
- 数据平台能力：元数据、调度、监控、权限、多租户。
- 大数据开发主线：
  - Flink 的状态、checkpoint、时间语义、背压。
  - Spark 的 DAG、shuffle、数据倾斜。
  - HDFS / Hive / Impala / Presto / Doris 的链路和选型边界。
- 项目从功能系统升级到平台化能力的表达。

本周输出物：

- 1 份 Week3 导航文档。
- 6-8 份 Week3 专题正文。
- 1 份系统设计统一答题模板。
- 至少 2 份设计题提纲：
  - 实时数据订阅系统
  - 实时查询系统
- 至少 2 份大数据链路类提纲：
  - Flink / Kafka / HDFS / Hive / Impala / Doris 的分工
  - Flink 与 Spark 的差异与边界
- 1 次 45-60 分钟系统设计 / 数据平台模拟问答。

## 3. Week3 专题文档入口

| 模块 | 专题文档 | 对应计划 | 状态 |
| --- | --- | --- | --- |
| 系统设计方法论与分布式基础 | `topics/00_system_design_methodology_and_distributed_basics_system_review.md` | Day15 | 当前已补 |
| Flink 主线 | `topics/01_flink_state_checkpoint_watermark_and_backpressure_system_review.md` | Day18 穿插 | 当前已补 |
| Spark 主线 | `topics/02_spark_dag_shuffle_and_data_skew_system_review.md` | Day20 穿插 | 当前已补 |
| HDFS / Hive / Impala / 查询引擎选型 | `topics/03_hdfs_hive_impala_and_query_engine_selection_system_review.md` | Day19 穿插 | 当前已补 |
| 实时数据订阅系统设计 | `topics/04_realtime_subscription_system_design_system_review.md` | Day16 | 当前已补 |
| 实时查询系统设计与多引擎选型 | `topics/05_realtime_query_system_design_and_multi_engine_selection_system_review.md` | Day17 | 当前已补 |
| 高可用 / 幂等 / 一致性 / 分布式事务 | `topics/06_high_availability_idempotency_consistency_and_distributed_transaction_system_review.md` | Day18 | 当前已补 |
| 数据平台能力抽象 | `topics/07_data_platform_metadata_scheduling_monitoring_permission_multitenancy_system_review.md` | Day19 | 当前已补 |
| 项目升级为平台化能力 | `topics/08_project_architecture_upgrade_from_function_to_platform_system_review.md` | Day20 | 当前已补 |
| Week3 大数据链路与组件分工总摘要 | `topics/09_bigdata_pipeline_component_roles_summary_system_review.md` | Day19-Day21 复盘收口 | 当前已补 |

说明：

- 当前 Week3 已经先补了系统设计总纲、实时数据订阅、实时查询和大数据开发主线文档。
- 当前 Week3 专题文档已经闭环，新增的组件分工总摘要用于把 `Kafka / Flink / Spark / HDFS / Hive / Impala / Presto / Doris / ES` 放回同一条链路里收口。
- 后续重点转到真实口头输出、模拟追问和按需补日复盘。

## 4. 每日映射

| Day | 模块 | 重点目标 | 对应文档 |
| --- | --- | --- | --- |
| Day15 | 系统设计方法论、分布式基础统一骨架 | 建立“先约束、再链路、再瓶颈、再治理”的系统设计主线 | `topics/00_system_design_methodology_and_distributed_basics_system_review.md` |
| Day16 | 实时数据订阅系统设计 | 建立“接入 -> 处理 -> 投递 -> 幂等重试 -> 扩展治理”的主线 | `topics/04_realtime_subscription_system_design_system_review.md` |
| Day17 | 实时查询系统设计 | 建立“查询模型 -> 缓存索引 -> 分层存储 -> 选型治理”的主线 | `topics/05_realtime_query_system_design_and_multi_engine_selection_system_review.md` |
| Day18 | 高可用、幂等、一致性、分布式事务 + Flink 主线 | 把分布式问题放回链路里，再补 Flink 的状态和容错主线 | `topics/06_high_availability_idempotency_consistency_and_distributed_transaction_system_review.md` + `topics/01_flink_state_checkpoint_watermark_and_backpressure_system_review.md` |
| Day19 | 数据平台能力抽象 + HDFS / Hive / Impala / 查询链路 | 建立“存储 -> 元数据 -> 调度监控 -> 权限治理 -> 查询引擎”的主线 | `topics/03_hdfs_hive_impala_and_query_engine_selection_system_review.md` + `topics/07_data_platform_metadata_scheduling_monitoring_permission_multitenancy_system_review.md` |
| Day20 | 项目升级表达 + Spark 主线 | 把项目从功能系统提升到平台化能力，再补 Spark 的执行代价和调优主线 | `topics/08_project_architecture_upgrade_from_function_to_platform_system_review.md` + `topics/02_spark_dag_shuffle_and_data_skew_system_review.md` |
| Day21 | 周复盘 / 模拟问答 | 只复盘主线和薄弱点，不回炉全量笔记 | 本文件 + 各专题文档自测清单 |

## 5. 使用方式

### 5.1 每天如何用

1. 先看知识地图中对应模块的“核心框架”和“高频题”。
2. 再看当日专题文档的“这一块在回答什么问题”，确认今天到底要解决哪一个判断题。
3. 再过专题主线，先把问题链串起来，不急着堆细节。
4. 再看核心问题展开，把机制、收益、代价、边界连起来。
5. 最后做自测和口头输出，只记录今天最容易讲散的点。

### 5.2 Week3 的重点提醒

- 系统设计题不要一上来画图，先把需求、数据规模、读写特点、时延目标和一致性要求钉住。
- 不要把 RPC、缓存、MQ、负载均衡、分布式事务答成并列名词，而要讲成一条系统链路里的职责分工。
- 大数据开发这周不要只停留在“Flink 偏流、Spark 偏批、Hive 做数仓”这种标签层；必须继续往运行模型、代价和边界下压。
- 数据平台题的重点不是“列很多组件”，而是说明元数据、调度、监控、权限、多租户为什么会变成平台能力。
- 这周要开始把你的项目经验往“平台化能力”和“架构升级”上抬，不然后面项目面和设计面会脱节。

## 6. Week3 周复盘方法

### 6.1 每天复盘只做四件事

1. 今天这一块能不能先回答问题，再展开机制。
2. 今天至少 1 个关键机制能不能讲清它具体带来的收益和代价。
3. 今天最容易被追问散掉的边界是什么。
4. 今天这块能不能和你的实时订阅、实时查询或数据平台经验挂起来。

### 6.2 周末复盘不要从头重看

周末建议只做下面几件事：

- 抽查系统设计、数据订阅、实时查询、Flink、Spark、查询引擎选型各 1 题。
- 每题先讲 1 分钟主结论，再补 3 分钟机制和边界。
- 只回看自己讲散的专题，不重抄整份正文。
- 记录本周最弱的 3 个点：
  - 1 个系统设计类
  - 1 个分布式边界类
  - 1 个大数据开发类

### 6.3 第 3 周最小达标标准

如果 Week3 结束时，下面这些你都能稳定讲出来，就算本周节奏是对的：

- 系统设计为什么必须先讲约束、规模和核心链路，而不是直接堆方案。
- 实时数据订阅系统里，接入、投递、幂等、重试、隔离、扩展分别落在哪。
- 实时查询系统里，缓存、索引、冷热分层、多引擎选型为什么会一起出现。
- 高可用、幂等、一致性、分布式事务为什么不能拆开零散地讲。
- Flink 的状态、checkpoint、watermark、背压分别在控制什么风险或成本。
- Spark 的 DAG、stage、shuffle、数据倾斜为什么会直接决定执行代价。
- HDFS、Hive、Impala、Presto、Doris 在一条存储和查询链路里各自承担什么职责。
- 能把自己的项目经验上升到“平台化能力”和“量级增长后的架构升级”表达。

## 7. 与日复盘文档关系

建议这样配合使用：

- 本文档：
  - 负责 Week3 导航、每日映射和达标标准。
- `topics/*.md`：
  - 负责系统设计、数据平台和大数据开发的专题知识正文。
- `daily/*.md`：
  - 暂时不用预置。
  - 等你本周真实做完系统设计问答或项目升级表达后，再按需补当天复盘。

当前 Week3 最值得优先做的是：

- 先把系统设计总纲、实时数据订阅、实时查询和大数据三篇专题读顺。
- 再把高可用、数据平台能力、项目升级三篇专题串起来，检查自己能否讲成一条完整演进主线。
- 然后进入模拟问答和真实项目表达打磨。
