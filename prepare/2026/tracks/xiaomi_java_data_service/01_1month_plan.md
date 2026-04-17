# 小米 Java 研发工程师（数据服务）1 个月冲刺计划

## 1. 目标与约束

### 目标岗位

- 岗位：小米 Java 研发工程师（数据服务）
- 目标级别：资深
- 准备周期：4 周

### 当前背景摘要

- 工作年限：10 年
- 最近 5 年主要从事基础数据平台后端研发
- 熟悉技术栈：Java、Nginx、MySQL、Flink、Redis、Kafka、Impala、Hive、gRPC、HTTP
- 重点项目：
  - 实时数据订阅 + 实时查询
  - id-mapping

### 当前短板判断

- 面试节奏生疏，尚未形成稳定答题框架
- Spring / Spring MVC / Spring Boot / MyBatis / Dubbo / Spring Cloud 与 JD 绑定较强，但当前储备偏弱
- 分布式基础还不够成体系：
  - RPC
  - 缓存
  - MQ
  - 负载均衡
  - 分布式事务
- 系统设计能力需要专项补强
- 数据平台相关的大数据引擎、数据库选型和平台化设计表达还不够完整
- Flink / Spark / HDFS / Hive / Impala 这条大数据开发常用技术线还缺少系统化面试表达
- Linux / Java Web / 设计模式 / 沟通表达还需要补齐
- 算法手感不足，但算法练习现已转入独立专项计划推进

### 时间预算

- 工作日：每天 2.5-3 小时
- 周末：每天 5-6 小时
- 周总投入：约 22.5-27 小时

说明：

- 这里统计的是技术主线（知识点、问答、项目表达、系统设计）投入
- 算法练习现在按独立专项计划推进，不再占用这份主计划的日程预算
- 如果工作周压力临时升高，技术主线也尽量不要低于每周 20 小时

### 基于已收集小米相关岗位要求的统一提炼

这些岗位虽然名称不同，但共性要求基本一致，可以合并成一条准备主线：

- Java 核心能力：
  - Java 语言
  - 多线程
  - JVM
  - 设计模式
  - Java Web
- Java 框架链：
  - Spring
  - Spring MVC
  - Spring Boot
  - MyBatis
  - Dubbo / Spring Cloud
- 分布式与高可用：
  - RPC
  - 缓存
  - 消息队列
  - 负载均衡
  - 分布式事务
  - 高性能 / 高并发 / 高可用设计与调优
- 数据服务 / 数据平台能力：
  - SQL
  - MySQL
  - Redis
  - Doris / Holo / MongoDB / SQLServer 的场景理解
  - Flink / Spark / Hadoop / Presto / Kafka / ElasticSearch 的角色理解
- 工程与协作要求：
  - Linux / Unix
  - 算法和数据结构
  - 独立分析问题
  - 沟通协作
  - 代码质量和测试意识

执行上建议这样理解：

- 先拿稳共性硬要求
- 再补数据平台相关广度
- BI / 前端 / DMP / AB 实验平台这类内容作为加分项处理，不抢核心主线时间

## 2. 总体策略

- 优先把已有经验面试化，而不是平均补所有知识点
- 先补高频核心题，再补 JD 强相关短板
- 技术准备与项目准备并行推进，但以技术主线为主
- 每周至少做 1 次复盘，至少做 1 次模拟问答

### 基于当前执行反馈的调整

当前计划本身没有大问题，问题主要出在“缺少知识导航层”：

- 现有计划更偏“每日执行层”，适合安排当天学什么
- 但在进入问答和输出前，缺少一份稳定的“高频知识地图”
- 这会导致每天都在临时补背景，问答和输出成本偏高

因此建议补一份独立文档：

- 高频知识地图：`prepare/2026/tracks/xiaomi_java_data_service/00_high_frequency_knowledge_map.md`

调整后的执行方式：

- 不推翻现有 4 周计划，仍按当前周次推进
- 每天先看知识地图里对应模块的框架和高频题，再进入当天任务
- 输出要求从“每题都写完整答案”调整为“优先口头回答 + 提纲沉淀”
- 每周只挑 2-3 个最关键问题写成长答案，其余先做到能讲清主线

补充说明：

- 这份计划当前只能视为 `v1`
- 后续如果补充到更完整的岗位要求，这份计划的优先级、模块顺序、每周目标都可以调整
- 也就是说，岗位要求优先于当前计划，不要求为了“保持原计划”而死守旧安排

### 当前执行位置下的调整约束

- 技术主线当前已执行到 `Week1 Day6`
- 算法主线当前也已独立推进到 `Week1 Day6`，后续不再以本文为准
- 因此后续这份计划只调整：
  - 技术主线的模块优先级
  - `Week1 Day7` 之后的安排
  - `Week2-Week4` 的周目标和每日任务
- 不回改 `Day1-Day6`，避免打断当前节奏

### 基于岗位要求复核的补充结论

本次结合 `03_gap_review_and_adjustments.md` 复核后，补充几个明确结论：

- 当前主计划的大方向可以保留，不需要整体推翻
- 真正需要前置的，不是更多知识点，而是：
  - 项目表达
  - 系统设计
  - 排障 / Linux / 网络
  - 工程质量 / 测试意识 / 协作表达
- 从 Week2 开始，这几类内容不再只放到最后一周集中处理，而应每周至少安排 1 次输出或模拟
- 算法主线当前主要风险不在专题数量，而在面试化验收和口头表达闭环，因此后续不再盲目扩专题

## 3. 准备优先级

### P0：必须拿稳

- Java 并发
- JVM
- MySQL / SQL
- Redis
- Kafka
- Spring 核心
- Spring Boot / Spring MVC
- MyBatis
- Dubbo / Spring Cloud / RPC
- 系统设计 / 分布式基础：
  - 高性能 / 高并发 / 高可用
  - RPC
  - 缓存
  - 消息队列
  - 负载均衡
  - 分布式事务

### P1：岗位强相关增量（当前需要额外强化）

- 数据平台 / 大数据开发：
  - Flink
  - Spark
  - HDFS
  - Hive
  - Impala
  - Doris
  - Holo
  - Presto
  - ElasticSearch
- 数据库选型：
  - MongoDB
  - SQLServer
  - Doris / Holo
- 排障 / Linux / 网络：
  - Linux 常用排查命令
  - TCP / HTTP / 连接管理 / 超时重试
  - 慢 SQL / MQ 积压 / 热 key / 线程池打满 / Full GC 的排查路径
- 设计模式 / 工程能力：
  - 常用设计模式
  - 代码质量
  - 重构意识
  - 测试用例与质量保障

### P2：持续恢复

- 算法（已独立专项推进）
- Java Web
- 项目面中的技术表达
- 行为面中的技术表达

### P3：加分项

- BI / 报表平台：
  - Tableau
  - Power BI
  - 神策
  - Superset
  - Metabase
- DMP / AB 实验平台经验
- Vue 等前端协作能力
- 测试用例、代码质量和重构经验

## 4. 每周目标

### 第 1 周：保持当前节奏，完成 Java 核心与存储中间件收口

- 目标：
  - 保持 Day1-Day4 已有进度，不回改执行顺序
  - 完成 MySQL、Redis、Kafka 这三个 P0 存储 / 中间件模块
  - 算法从 Week1 Day7 起切换到独立专项计划推进
- 输出物：
  - 高频题答案草稿 10-15 个
  - 本周薄弱点清单
  - 第 1 次 30 分钟技术模拟问答

### 第 2 周：强补框架链 + RPC / Java Web / 设计模式

- 目标：
  - 补齐 Spring / Spring Boot / Spring MVC / MyBatis / Dubbo / Spring Cloud 这条框架链
  - 把 RPC、注册发现、超时、重试、负载均衡、治理能力补成体系
  - 补一轮 Java Web、设计模式、代码质量意识，避免框架题答得过窄
  - 用新增时间并行补一轮大数据开发基础链路：
    - HDFS
    - Hive / Impala / Presto
    - Flink / Spark 的角色差异
- 输出物：
  - 框架链高频题答案草稿
  - RPC / 服务治理回答提纲
  - 1 版大数据链路组件分工对比表
  - 1 版工程质量 / 测试意识 / 协作表达提纲
  - 1 版排障 / Linux / 网络问答提纲
  - 1 版简历技术栈描述
  - 第 2 次 30-45 分钟技术模拟问答

### 第 3 周：专项突破系统设计 + 数据平台 / 数据服务 / 大数据开发场景

- 目标：
  - 建立资深岗系统设计答题框架
  - 围绕“数据订阅、实时查询、缓存、MQ、扩展性、高可用、分布式事务、平台化设计”做专题训练
  - 把 Flink / Spark / Kafka / HDFS / Hive / Impala / Doris / Presto / ES 这些组件的角色讲清
  - 补齐大数据开发高频机制：
    - Flink 的 state / checkpoint / watermark / backpressure
    - Spark 的 DAG / shuffle / stage / task / 数据倾斜
    - HDFS / Hive / Impala 的存储与查询链路
  - 能把项目经验上升到架构层和数据平台层表达
- 输出物：
  - 系统设计答题模板
  - 2 道数据服务 / 数据平台设计题的答题提纲
  - 1 版大数据开发高频题提纲
  - 1 版项目故事主线和追问清单
  - 第 1 次系统设计 + 数据平台模拟

### 第 4 周：综合演练 + 项目表达 + 线上问题冲刺

- 目标：
  - 技术题、项目题、系统设计题串联演练
  - 把大数据开发高频题和数据链路题混合进综合问答
  - 把项目介绍、亮点、难点、追问和线上案例打磨成稳定表达
  - 查漏补缺，补齐最薄弱模块
  - 形成可执行的面试前最后一周清单
- 输出物：
  - 高频题最终版清单
  - 模拟面试复盘清单
  - 2 个核心项目的 1 分钟版 / 3 分钟版 / 追问展开版
  - 面试前 3 天复习清单

## 5. 每周执行模板

- 工作日：
  - 10-15 分钟：先看当日对应的高频知识地图
  - 60-70 分钟：主专题复习 / 面试式问答
  - 40-50 分钟：副专题强化：
    - Week2 以大数据开发基础链路或项目映射为主
    - Week3 以系统设计、大数据开发深挖或排障为主
    - Week4 以综合模拟和补漏为主
  - 20-30 分钟：整理回答提纲 / 口头输出 / 当天复盘
- 周末：
  - 20-30 分钟：先过本周模块的知识地图
  - 150-180 分钟：技术专题复习 / 问答 / 追问展开
  - 60-90 分钟：副专题强化 / 模拟面试 / 项目表达
  - 40-50 分钟：复盘 / 输出 / 查漏补缺

说明：

- 如果当天卡在“概念不成体系”，优先回知识地图，不要硬做问答
- 如果当天卡在“表达不顺”，优先做 1 分钟 / 3 分钟口头回答，不必强求长文
- 算法练习不再和这份主计划绑在一起，统一按下面文档执行：
  - `prepare/2026/tracks/xiaomi_java_data_service/algorithms/90_1month_algorithm_plan.md`
  - `prepare/2026/tracks/xiaomi_java_data_service/algorithms/problem_ledger_and_dedup_index.md`

### 新增时间的默认使用顺序

- 第一优先级：
  - 框架链、RPC、系统设计这些当前短板模块的二轮加深
- 第二优先级：
  - 大数据开发高频技术：
    - Flink
    - Spark
    - HDFS
    - Hive
    - Impala
- 第三优先级：
  - 项目表达、排障案例、多数据库 / 多引擎选型
- 不建议把新增时间优先投入到：
  - 加分项扩展
  - 低频冷门知识点
  - 大量长文整理

## 6. 每日计划（技术主线）

使用方式：

- 先看 `00_high_frequency_knowledge_map.md` 中对应模块
- 再进入下面的每日任务
- 每天只要求拿稳 1-2 个核心问题，不追求把当天所有点一次吃透
- 从 `Week1 Day7` 起，算法不再以本节为准，统一改按：
  - `prepare/2026/tracks/xiaomi_java_data_service/algorithms/90_1month_algorithm_plan.md`

### 第 1 周：Java 核心 + 存储中间件恢复

#### Day 1

- 并发：线程、线程池、核心参数、拒绝策略
- 并发：`synchronized` 和 `ReentrantLock` 的区别
- 算法：数组 / 哈希 1 题
- 输出：写出“线程池参数如何配置”的 3 分钟回答

#### Day 2

- 并发：CAS、`volatile`、JMM、AQS
- 并发：原子类、`ConcurrentHashMap`
- 算法：双指针 1 题
- 输出：写出“`volatile` 能保证什么”的 2 分钟回答

#### Day 3

- JVM：内存结构、对象创建、类加载
- JVM：栈、堆、方法区、直接内存的区别
- 算法：滑动窗口 1 题
- 输出：写出“JVM 内存结构”的 3 分钟回答

#### Day 4

- JVM：GC 基础、常见收集器、Full GC 排查路径
- JVM：OOM、CPU 飙高、频繁 GC 的排查思路
- 算法：前缀和 + 哈希 1 题
- 输出：整理 1 个线上排查案例模板

#### Day 5

- MySQL：索引、联合索引、回表、覆盖索引、`explain`
- MySQL：事务隔离、MVCC、慢 SQL 排查
- 算法：二分 1 题
- 输出：写出“慢 SQL 怎么排查”的 3 分钟回答

#### Day 6

- Redis：数据结构、缓存三大问题、持久化、主从/哨兵/集群
- Kafka：分区、副本、消费组、顺序性、重复消费、消息丢失
- 算法：数组 + 哈希综合 2 题
- 输出：分别写出“Redis 为什么快”和“Kafka 如何保证不丢消息”的要点

#### Day 7

- 复盘本周全部高频题
- 算法：按独立算法专项计划中的 `Week1 Day7` 执行
- 做 30 分钟技术模拟问答
- 整理：
  - 本周最弱的 3 个点
  - 下周需要重点补的 3 个点：
    - 框架链
    - RPC / 服务治理
    - Java Web / 设计模式表达

### 第 2 周：框架链 + RPC / Java Web / 设计模式补强

#### Day 8

- Spring：IOC、DI、BeanFactory、ApplicationContext
- Spring：Bean 生命周期
- 算法：按独立算法专项计划中的 `Week2 Day8` 执行
- 输出：写出“Spring IOC 是什么”的 2 分钟回答

#### Day 9

- Spring：AOP、动态代理、JDK Proxy 和 CGLIB
- Spring：循环依赖与三级缓存
- Spring：事务传播、隔离级别、`@Transactional` 失效场景
- 算法：按独立算法专项计划中的 `Week2 Day9` 执行
- 输出：写出“循环依赖怎么解决”或“事务为什么会失效”的 3 分钟回答

#### Day 10

- Spring MVC：请求处理主流程
- Java Web：Servlet 容器、请求生命周期、过滤器 / 拦截器 / AOP 的区别
- 算法：按独立算法专项计划中的 `Week2 Day10` 执行
- 输出：写出“Spring MVC 请求处理主流程”的回答提纲

#### Day 11

- Spring Boot：自动配置机制、`starter`、条件装配
- Spring Boot：配置加载、常见启动流程
- 算法：按独立算法专项计划中的 `Week2 Day11` 执行
- 输出：写出“Spring Boot 自动配置原理”的 3 分钟回答

#### Day 12

- MyBatis：执行流程、`Mapper` 代理、动态 SQL
- MyBatis：一级缓存、二级缓存、分页与性能问题
- 设计模式：策略、工厂、模板方法在后端系统里的典型应用
- 算法：按独立算法专项计划中的 `Week2 Day12` 执行
- 输出：写出“MyBatis 执行一条 SQL 的流程”或“我项目里常用的设计模式”的回答提纲

#### Day 13

- Dubbo：架构角色、服务注册发现、调用流程
- Dubbo / RPC：负载均衡、超时、重试、容错、序列化
- Spring Cloud：注册发现、配置、熔断降级、网关的治理能力地图
- 对比：Dubbo、Spring Cloud 和 gRPC
- 算法：按独立算法专项计划中的 `Week2 Day13` 执行
- 输出：写出“Dubbo / Spring Cloud / gRPC 的异同”回答提纲

#### Day 14

- 复盘第 2 周高频题
- 算法：按独立算法专项计划中的 `Week2 Day14` 执行
- 做 30-45 分钟框架专题模拟问答
- 补齐：
  - 最薄弱的 2 个框架 / RPC 点
  - 最容易讲乱的 2 个问题
  - 1 个设计模式或 Java Web 基础点
  - 1 个大数据开发基础点：
    - HDFS / Hive / Impala / Flink / Spark 五选一

### 第 3 周：系统设计 + 数据平台 / 数据服务 / 大数据开发专题

#### Day 15

- 系统设计方法论：需求澄清、规模估算、模块拆分、瓶颈定位
- 分布式基础统一答题骨架：RPC、缓存、MQ、负载均衡、分布式事务
- 建立统一答题框架
- 算法：按独立算法专项计划中的 `Week3 Day15` 执行
- 输出：沉淀一版“系统设计答题模板”

#### Day 16

- 设计题：实时数据订阅系统
- 重点：接入、处理、投递、幂等、重试、扩展性
- 算法：按独立算法专项计划中的 `Week3 Day16` 执行
- 输出：画出核心链路草图

#### Day 17

- 设计题：实时查询系统
- 重点：查询模型、缓存、索引、冷热分层、限流降级、多数据库 / 多引擎选型
- 算法：按独立算法专项计划中的 `Week3 Day17` 执行
- 输出：整理查询系统的瓶颈和优化点

#### Day 18

- 高可用：隔离、限流、熔断、降级、重试、超时
- 分布式：一致性、幂等、重入、顺序性、分布式事务边界
- 大数据开发：Flink 的状态、checkpoint / savepoint、水位线、背压
- 算法：按独立算法专项计划中的 `Week3 Day18` 执行
- 输出：写出“高可用设计清单”

#### Day 19

- 数据平台专项：实时链路、离线链路、元数据、调度、监控、权限、多租户
- 大数据开发：HDFS、Hive、Impala、Presto、Doris 的存储 / 查询链路和适用边界
- 组件分工：Flink / Spark / Kafka / HDFS / Hive / Impala / Doris / Presto / ElasticSearch 在典型链路中的角色
- 算法：按独立算法专项计划中的 `Week3 Day19` 执行
- 输出：写出“数据平台核心能力地图”或“数据服务系统最关键的 5 个设计点”

#### Day 20

- 设计题：结合自身项目做系统设计升级回答
- 主题：如果量级涨 10 倍如何扩展，如何从功能系统升级成平台化能力
- 大数据开发：Spark 的 DAG、shuffle、stage / task、数据倾斜和常见调优思路
- 算法：按独立算法专项计划中的 `Week3 Day20` 执行
- 输出：整理“扩容、稳定性、容灾、监控”的升级方案

#### Day 21

- 做 1 次 45-60 分钟系统设计 / 数据平台模拟
- 算法：按独立算法专项计划中的 `Week3 Day21` 执行
- 复盘第 3 周
- 整理：
  - 设计题常用话术
  - 自己最弱的设计维度
  - 自己最弱的数据平台维度

### 第 4 周：综合演练 + 项目表达 + 线上问题冲刺

#### Day 22

- 混合复习：并发 + JVM + 设计模式高频题
- 算法：按独立算法专项计划中的 `Week4 Day22` 执行
- 输出：按“1 分钟 / 3 分钟 / 深挖版”整理答案

#### Day 23

- 混合复习：Spring + MyBatis + Dubbo / RPC + Java Web 高频题
- 算法：按独立算法专项计划中的 `Week4 Day23` 执行
- 输出：整理框架 / RPC / Java Web 易错点清单

#### Day 24

- 混合复习：MySQL + Redis + Kafka + HDFS / Hive / Impala / Spark / Flink + 多数据库 / 多引擎选型
- 算法：按独立算法专项计划中的 `Week4 Day24` 执行
- 输出：整理存储与中间件对比表

#### Day 25

- 系统设计 + 项目表达二轮复盘
- 重点：数据服务、实时链路、查询、稳定性、平台化表达
- 算法：按独立算法专项计划中的 `Week4 Day25` 执行
- 输出：整理 2 道最可能出现的设计题提纲 + 2 个项目追问清单

#### Day 26

- 故障排查与性能优化专题
- 重点：线上问题定位、监控指标、Linux / 网络、压测思路、性能瓶颈分析
- 算法：按独立算法专项计划中的 `Week4 Day26` 执行
- 输出：整理 2 个真实案例提纲

#### Day 27

- 全真模拟技术面试 1 次
- 算法：按独立算法专项计划中的 `Week4 Day27` 执行
- 覆盖：基础技术 + 框架 + 中间件 + 系统设计
- 输出：复盘弱点，形成最后补漏清单

#### Day 28

- 最终查漏补缺
- 算法：按独立算法专项计划中的 `Week4 Day28` 执行
- 只看高频题、错题、薄弱点
- 准备面试前 3 天复习清单
- 保持节奏，不再盲目扩展新知识

## 7. 每周验收标准

### 第 1 周验收

- 并发、JVM、MySQL、Redis、Kafka 高频题能答出 60%-70%
- 算法进度单独看：
  - `prepare/2026/tracks/xiaomi_java_data_service/algorithms/90_1month_algorithm_plan.md`
  - `prepare/2026/tracks/xiaomi_java_data_service/algorithms/problem_ledger_and_dedup_index.md`
- 能完成 1 次基础技术模拟问答

### 第 2 周验收

- Spring / Spring Boot / Spring MVC / MyBatis / Dubbo / RPC 能完成主流程级回答
- 至少输出 8-10 个框架 / RPC 类高频题答案提纲
- 能完成 1 次框架专题模拟
- Java Web、设计模式至少各能讲出 1-2 个稳定问题

### 第 3 周验收

- 至少能独立回答 2 道系统设计 / 数据平台题
- 能用统一框架讲“高并发 / 高可用 / 扩展性 / 平台化”
- 至少能稳定回答 3-5 个大数据开发高频问题：
  - Flink / Spark / HDFS / Hive / Impala / 查询引擎选型中的任意组合
- 能将项目经验上升到架构表达和数据平台表达

### 第 4 周验收

- 能完成 1 次综合模拟技术面
- 明确自己的最终薄弱点清单
- 形成面试前最后复习材料
- 项目题、系统设计题、排障题、大数据开发高频题都至少有一版稳定回答

## 8. 执行原则

- 每天学习结束后，用 5 分钟记录：
  - 今天学了什么
  - 哪个问题讲不顺
  - 明天优先补什么
- 每天开始前，先定位今天对应的知识地图模块
- 陌生知识点先做到“有框架”，再做“能展开”
- 每周至少做 1 次口头输出，避免只看不说
- 遇到不熟悉的知识点，优先做到“能理解、能表达、能追问展开”
- 不追求覆盖所有知识点，优先拿稳高频题和 JD 强相关模块

## 9. 后续配套文档建议

- 高频知识地图：`prepare/2026/tracks/xiaomi_java_data_service/00_high_frequency_knowledge_map.md`
- 算法专项月计划：`prepare/2026/tracks/xiaomi_java_data_service/algorithms/90_1month_algorithm_plan.md`
- 算法题目台账：`prepare/2026/tracks/xiaomi_java_data_service/algorithms/problem_ledger_and_dedup_index.md`
- 岗位 gap review：`prepare/2026/tracks/xiaomi_java_data_service/03_gap_review_and_adjustments.md`
- 项目故事稳定稿：`prepare/2026/tracks/xiaomi_java_data_service/04_project_story_stable_draft.md`
- 项目追问清单：`prepare/2026/tracks/xiaomi_java_data_service/05_project_followup_checklist.md`
- 排障问答提纲：`prepare/2026/tracks/xiaomi_java_data_service/06_troubleshooting_qa_outline.md`
- 工程质量与协作提纲：`prepare/2026/tracks/xiaomi_java_data_service/07_engineering_quality_and_collaboration_outline.md`
- 周进展记录：`prepare/2026/records/00_weekly_progress.md`
- 对话同步模板：`prepare/common/templates/00_chat_sync_template.md`
- 模拟/真实面试复盘：`prepare/2026/records/01_interview_log.md`
- 每日执行清单：`prepare/2026/records/02_daily_execution_checklist.md`
