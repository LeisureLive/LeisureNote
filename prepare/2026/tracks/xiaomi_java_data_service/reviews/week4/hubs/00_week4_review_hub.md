# Week4 复习总纲导航

对应计划：

- `prepare/2026/tracks/xiaomi_java_data_service/01_1month_plan.md`
- `prepare/2026/tracks/xiaomi_java_data_service/00_high_frequency_knowledge_map.md`
- `prepare/2026/tracks/xiaomi_java_data_service/reviews/rules/00_review_doc_writing_rules.md`

## 1. 文档定位

这份文件位于 `week4/hubs/00_week4_review_hub.md`，角色是 Week4 导航文档。

使用原则：

- 这份文件只负责导航、每日映射、复盘要求。
- Week4 的核心不是再扩新知识，而是把前 3 周的主线做综合收口，并把项目表达、系统设计、排障案例压成稳定输出。
- 具体知识正文继续拆到 `topics/` 目录里；混合复习时优先回看 Week1-Week3 已有专题，不再重复造新总纲。
- Week4 只对“当前还缺、且直接影响面试上限”的内容新增专题正文。
- 其中 `topics/02_project_story_highlights_and_followups_system_review.md` 的角色是“项目复盘 / 表达专题”，它依赖 Week3 的技术专题，不替代技术机制正文。

## 2. 本周目标

Week4 的主线不是“再学一轮”，而是完成下面四件事：

1. 把并发、JVM、MySQL、Redis、Kafka、框架链、大数据开发这些模块做混合抽查，验证主线是否已经稳定。
2. 把系统设计、项目表达和平台化演进表达串起来，不再各讲各的。
3. 把故障排查、性能优化、Linux / 网络、监控指标这些资深岗高频题补成可直接复用的排障主线。
4. 形成最后一周可执行的复习材料：高频题清单、项目追问清单、设计题清单、排障案例清单。

本周必须拿稳的模块：

- 并发 + JVM + 设计模式的高频题串讲。
- Spring / MyBatis / Dubbo / RPC / Java Web 的高频题串讲。
- MySQL / Redis / Kafka / Flink / Spark / HDFS / Hive / Impala / 多引擎选型的职责边界。
- 项目表达、系统设计、平台化升级表达的二轮收口。
- 故障排查与性能优化专题：
  - 监控指标
  - Linux 常用排查路径
  - 网络 / 超时 / 连接管理
  - 慢 SQL、热 key、MQ 积压、线程池打满、Full GC

本周输出物：

- 1 份 Week4 导航文档。
- 1 份故障排查与性能优化专题正文。
- 1 份高频题最终版清单。
- 1 份项目追问清单。
- 1 份设计题提纲清单。
- 1 份面试前 3 天复习清单。
- 至少 1 次全真综合模拟技术面。

## 3. Week4 专题文档入口

| 模块 | 专题文档 | 对应计划 | 状态 |
| --- | --- | --- | --- |
| 混合复习：并发 / JVM / 设计模式 | 回看 Week1、Week2 相关专题 | Day22 | 复用已有专题 |
| 混合复习：框架链 / RPC / Java Web | 回看 Week2 相关专题 | Day23 | 复用已有专题 |
| 混合复习：存储 / 中间件 / 大数据开发 / 选型 | 回看 Week1、Week3 相关专题 | Day24 | 复用已有专题 |
| 系统设计 + 项目表达二轮复盘 | 回看 Week3 相关专题 | Day25 | 复用已有专题 |
| 故障排查与性能优化 | `topics/01_troubleshooting_performance_linux_network_system_review.md` | Day26 | 当前已补 |
| 项目故事、亮点提炼与追问展开（项目复盘 / 表达专题） | `topics/02_project_story_highlights_and_followups_system_review.md` | Day25-Day28 穿插 | 当前已补 |
| 全真模拟 / 查漏补缺 | 本文件 + 各专题自测清单 | Day27-Day28 | 按执行推进 |

说明：

- Week4 的重点是综合收口，所以 Day22-Day25 主要复用已补好的专题正文。
- Week4 新增专题正文只保留真正缺口：故障排查与性能优化。
- `topics/02_project_story_highlights_and_followups_system_review.md` 虽然放在 `topics/` 下，但它的作用是把已有技术理解组织成稳定项目叙事，不替代 Week3 的系统设计、平台化和链路专题。

## 4. 每日映射

| Day | 模块 | 重点目标 | 对应文档 |
| --- | --- | --- | --- |
| Day22 | 并发 + JVM + 设计模式混合复习 | 验证基础硬核模块是否能做 1 分钟 / 3 分钟 / 深挖版切换 | 回看 `prepare/2026/tracks/xiaomi_java_data_service/reviews/week1/topics/01_1_threadpool_lock_system_review.md` + `prepare/2026/tracks/xiaomi_java_data_service/reviews/week1/topics/01_2_jmm_and_lockfree_system_review.md` + `prepare/2026/tracks/xiaomi_java_data_service/reviews/week1/topics/02_1_jvm_runtime_classloading_system_review.md` + `prepare/2026/tracks/xiaomi_java_data_service/reviews/week1/topics/02_2_jvm_gc_troubleshooting_system_review.md` + `prepare/2026/tracks/xiaomi_java_data_service/reviews/week2/topics/09_backend_design_patterns_for_service_system_review.md` |
| Day23 | Spring + MyBatis + Dubbo / RPC + Java Web 混合复习 | 验证框架链是否已经能讲成主流程和治理链 | 回看 `prepare/2026/tracks/xiaomi_java_data_service/reviews/week2/topics/01_spring_ioc_container_and_bean_lifecycle_system_review.md` + `prepare/2026/tracks/xiaomi_java_data_service/reviews/week2/topics/02_spring_aop_and_dynamic_proxy_system_review.md` + `prepare/2026/tracks/xiaomi_java_data_service/reviews/week2/topics/03_spring_circular_dependency_and_three_level_cache_system_review.md` + `prepare/2026/tracks/xiaomi_java_data_service/reviews/week2/topics/04_spring_transaction_and_transactional_failure_system_review.md` + `prepare/2026/tracks/xiaomi_java_data_service/reviews/week2/topics/05_spring_mvc_and_java_web_request_flow_system_review.md` + `prepare/2026/tracks/xiaomi_java_data_service/reviews/week2/topics/06_spring_boot_auto_configuration_and_startup_system_review.md` + `prepare/2026/tracks/xiaomi_java_data_service/reviews/week2/topics/07_mybatis_execution_cache_and_paging_system_review.md` + `prepare/2026/tracks/xiaomi_java_data_service/reviews/week2/topics/08_rpc_dubbo_springcloud_and_grpc_system_review.md` |
| Day24 | MySQL + Redis + Kafka + Flink / Spark / HDFS / Hive / Impala + 多引擎选型 | 验证存储、中间件和大数据开发边界是否已经打通 | 回看 `prepare/2026/tracks/xiaomi_java_data_service/reviews/week1/topics/03_mysql_system_review.md` + `prepare/2026/tracks/xiaomi_java_data_service/reviews/week1/topics/04_redis_system_review.md` + `prepare/2026/tracks/xiaomi_java_data_service/reviews/week1/topics/05_kafka_system_review.md` + `prepare/2026/tracks/xiaomi_java_data_service/reviews/week3/topics/01_flink_state_checkpoint_watermark_and_backpressure_system_review.md` + `prepare/2026/tracks/xiaomi_java_data_service/reviews/week3/topics/02_spark_dag_shuffle_and_data_skew_system_review.md` + `prepare/2026/tracks/xiaomi_java_data_service/reviews/week3/topics/03_hdfs_hive_impala_and_query_engine_selection_system_review.md` |
| Day25 | 系统设计 + 项目表达二轮复盘 | 把数据服务、实时链路、查询、平台化表达串成完整叙事 | 回看 `prepare/2026/tracks/xiaomi_java_data_service/reviews/week3/topics/00_system_design_methodology_and_distributed_basics_system_review.md` + `prepare/2026/tracks/xiaomi_java_data_service/reviews/week3/topics/04_realtime_subscription_system_design_system_review.md` + `prepare/2026/tracks/xiaomi_java_data_service/reviews/week3/topics/05_realtime_query_system_design_and_multi_engine_selection_system_review.md` + `prepare/2026/tracks/xiaomi_java_data_service/reviews/week3/topics/06_high_availability_idempotency_consistency_and_distributed_transaction_system_review.md` + `prepare/2026/tracks/xiaomi_java_data_service/reviews/week3/topics/07_data_platform_metadata_scheduling_monitoring_permission_multitenancy_system_review.md` + `prepare/2026/tracks/xiaomi_java_data_service/reviews/week3/topics/08_project_architecture_upgrade_from_function_to_platform_system_review.md` + `prepare/2026/tracks/xiaomi_java_data_service/reviews/week4/topics/02_project_story_highlights_and_followups_system_review.md` |
| Day26 | 故障排查与性能优化 | 建立“先现象、再范围、再根因、再止损”的稳定排障主线 | `topics/01_troubleshooting_performance_linux_network_system_review.md` |
| Day27 | 全真模拟技术面 | 检查基础技术、框架、中间件、系统设计和项目表达是否形成闭环 | 本文件 + 已有专题自测清单 |
| Day28 | 最终查漏补缺 | 只看高频题、错题、薄弱点，不再扩新知识 | 本文件 + 自己整理的最终清单 |

## 5. 使用方式

### 5.1 每天如何用

1. 先看知识地图里当天对应模块的高频问题和目标深度。
2. 再按当日映射回看对应专题正文，不重读全部细节，只抓主线和边界。
3. 再做 1 分钟版本、3 分钟版本和被追问后的展开版口头输出。
4. 如果当天是混合复习，只记录自己最容易串错或边界不稳的点。
5. 如果当天是 Day26、Day27，优先做完整链路输出，而不是再补新概念。

### 5.2 Week4 的重点提醒

- Week4 不要再新增大块陌生知识，除非它直接影响即将面试的题型。
- 这周的核心不是“学更多”，而是“把已有内容收成稳定表达”。
- 混合复习时不要重新抄专题笔记，重点是跨模块串联：
  - 并发和线程池怎么接线上排障
  - 缓存和 MySQL 怎么接查询系统设计
  - MQ 和幂等怎么接订阅系统设计
  - Flink / Spark / Hive / Impala 怎么接平台化链路
- Day26 的排障专题要尽量结合你自己的线上案例，不要只背命令。
- 如果某天明显发现某一篇旧专题仍然讲不顺，优先回到对应专题重新读主线和边界，不要急着继续往下混合抽查。

## 6. Week4 周复盘方法

### 6.1 每天复盘只做四件事

1. 今天抽查的模块能不能在没有提示的情况下先给结论。
2. 今天有没有某个点一被跨模块追问就开始散。
3. 今天有没有哪个问题仍然停留在“知道概念但不会落到链路”。
4. 今天整理出的薄弱点，是否已经进入最后补漏清单。

### 6.2 周末复盘不要继续扩专题

周末建议只做下面几件事：

- 抽查 2 道基础技术题、2 道框架题、2 道系统设计题、2 道项目追问题。
- 每题都先讲结论，再补机制、边界和项目结合。
- 只看自己最后仍然不稳的模块。
- 形成最后的“必看 20 题”或“必看 30 题”清单。

### 6.3 第 4 周最小达标标准

如果 Week4 结束时，下面这些你都能稳定讲出来，就算本周节奏是对的：

- 基础技术、框架链、存储中间件、大数据开发不再是孤立回答，而能互相串联。
- 项目题不再停留在职责描述，而能讲清边界、取舍、平台化升级和新引入的治理成本。
- 系统设计题、排障题和项目题之间能自然切换，不会一换题型就丢主线。
- 至少有 2 个真实案例能稳定讲成“现象 -> 判断 -> 根因 -> 止损 -> 修复”。
- 已形成面试前 3 天可执行的复习材料。

## 7. 与日复盘文档关系

建议这样配合使用：

- 本文档：
  - 负责 Week4 导航、每日映射和达标标准。
- `topics/*.md`：
  - 负责少量新增的专题正文，和前面几周专题的回看入口。
  - 如果是项目复盘 / 表达专题，只负责组织已有理解，不替代前面几周的技术正文。
- `daily/*.md`：
  - 仍然按需补，不预置。
  - 只有在模拟面试明显暴露出稳定薄弱点时，再补详细日复盘。

当前 Week4 最值得优先做的是：

- 先用 Day22-Day25 把 Week1-Week3 主线全部串起来。
- 再把 Day26 的排障专题练成稳定输出。
- 最后通过 Day27-Day28 的模拟和补漏，把全链路表达收口。
