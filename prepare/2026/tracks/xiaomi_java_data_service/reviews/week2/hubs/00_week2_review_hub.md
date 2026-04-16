# Week2 复习总纲导航

对应计划：

- `prepare/2026/tracks/xiaomi_java_data_service/01_1month_plan.md`
- `prepare/2026/tracks/xiaomi_java_data_service/00_high_frequency_knowledge_map.md`
- `prepare/2026/tracks/xiaomi_java_data_service/reviews/rules/00_review_doc_writing_rules.md`

## 1. 文档定位

这份文件位于 `week2/hubs/00_week2_review_hub.md`，角色是 Week2 导航文档。

使用原则：

- 这份文件只负责导航、每日映射、复盘要求。
- 具体知识正文全部拆到专题文档里。
- Week2 开始严格按“问题驱动、先回答标题问题、再展开机制和边界”的规则写专题正文。

## 2. 本周目标

Week2 的主线不是“把 Spring 全家桶过一遍”，而是建立一条稳定的框架链表达：

1. Spring 容器到底怎么管理对象。
2. Spring 怎么在容器之上提供增强能力和事务能力。
3. Web 请求进入系统后，Spring MVC 和 Java Web 各自做什么。
4. Spring Boot 为什么能把配置和装配成本压下来。
5. MyBatis、Dubbo、Spring Cloud 分别在数据访问和服务治理链路里承担什么角色。

本周必须拿稳的模块：

- Spring IOC、DI、Bean 生命周期。
- AOP、动态代理、循环依赖、事务机制与失效场景。
- Spring MVC 请求处理主流程。
- Spring Boot 自动配置、条件装配、启动流程。
- MyBatis 主流程、缓存与分页边界。
- Dubbo / Spring Cloud / gRPC 的角色分工与 RPC 治理主线。

本周输出物：

- 1 份 Week2 导航文档。
- 8-9 份框架链专题正文。
- 至少 3 份重点问题回答提纲：
  - `Spring IOC 是什么`
  - `循环依赖怎么解决`
  - `Spring Boot 自动配置原理`
- 1 次 30-45 分钟框架专题模拟问答。

## 3. Week2 专题文档入口

| 模块 | 专题文档 | 对应计划 | 日复盘状态 |
| --- | --- | --- | --- |
| Spring 容器 | `topics/01_spring_ioc_container_and_bean_lifecycle_system_review.md` | Day8 | 当前无预置日文档，按需补到 `daily/` |
| Spring AOP | `topics/02_spring_aop_and_dynamic_proxy_system_review.md` | Day9 | 当前无预置日文档，按需补到 `daily/` |
| Spring 循环依赖 | `topics/03_spring_circular_dependency_and_three_level_cache_system_review.md` | Day9 | 当前无预置日文档，按需补到 `daily/` |
| Spring 事务 | `topics/04_spring_transaction_and_transactional_failure_system_review.md` | Day9 | 当前无预置日文档，按需补到 `daily/` |
| Spring MVC / Java Web | `topics/05_spring_mvc_and_java_web_request_flow_system_review.md` | Day10 | 当前无预置日文档，按需补到 `daily/` |
| Spring Boot | `topics/06_spring_boot_auto_configuration_and_startup_system_review.md` | Day11 | 当前无预置日文档，按需补到 `daily/` |
| MyBatis | `topics/07_mybatis_execution_cache_and_paging_system_review.md` | Day12 | 当前无预置日文档，按需补到 `daily/` |
| RPC / Dubbo / Spring Cloud / gRPC | `topics/08_rpc_dubbo_springcloud_and_grpc_system_review.md` | Day13 | 当前无预置日文档，按需补到 `daily/` |
| 后端常用设计模式 | `topics/09_backend_design_patterns_for_service_system_review.md` | Day12 穿插 | 当前无预置日文档，按需补到 `daily/` |

## 4. 每日映射

| Day | 模块 | 重点目标 | 对应文档 |
| --- | --- | --- | --- |
| Day8 | Spring IOC、DI、BeanFactory、ApplicationContext、Bean 生命周期 | 建立“容器如何托管对象”的主线 | `topics/01_spring_ioc_container_and_bean_lifecycle_system_review.md` |
| Day9 | AOP、动态代理、循环依赖、三级缓存、事务传播、`@Transactional` 失效 | 建立“增强能力、对象创建冲突、事务边界”三条主线 | `topics/02_spring_aop_and_dynamic_proxy_system_review.md` + `topics/03_spring_circular_dependency_and_three_level_cache_system_review.md` + `topics/04_spring_transaction_and_transactional_failure_system_review.md` |
| Day10 | Spring MVC、Servlet 容器、请求生命周期、过滤器 / 拦截器 / AOP 区别 | 建立 Web 请求处理主线 | `topics/05_spring_mvc_and_java_web_request_flow_system_review.md` |
| Day11 | Spring Boot 自动配置、`starter`、条件装配、配置加载、启动流程 | 建立“自动配置为什么成立”的主线 | `topics/06_spring_boot_auto_configuration_and_startup_system_review.md` |
| Day12 | MyBatis、`Mapper` 代理、动态 SQL、缓存、分页、设计模式 | 建立数据访问层主流程和工程边界 | `topics/07_mybatis_execution_cache_and_paging_system_review.md` + `topics/09_backend_design_patterns_for_service_system_review.md` |
| Day13 | Dubbo、RPC、Spring Cloud、gRPC、注册发现、负载均衡、超时、重试、治理能力 | 建立 RPC 调用链和治理能力地图 | `topics/08_rpc_dubbo_springcloud_and_grpc_system_review.md` |
| Day14 | 周复盘 | 只复盘主线和薄弱点，不回炉全量笔记 | 本文件 + 各专题文档自测清单 |

## 5. 使用方式

### 5.1 每天如何用

1. 先看知识地图中对应模块的“核心框架”和“高频题”。
2. 再看当日专题文档的“这一块在解决什么问题”。
3. 再过知识树，先建立主线，不急着背类名和源码细节。
4. 再看重点展开，把机制、适用边界和常见失效场景接起来。
5. 最后做自测、口头输出和最小执行记录；如果当天明显暴露薄弱点，再补 `daily/` 日复盘。

### 5.2 Week2 的重点提醒

- Spring 这周最容易讲散的不是 IOC，而是：
  - AOP 和动态代理怎么接起来。
  - 三级缓存为什么是三级，不是二级。
  - 事务传播、代理边界和失效场景怎么接起来。
- Spring MVC 和 Spring Boot 不要掉进类名细节，先抓主流程。
- Dubbo / Spring Cloud / gRPC 不要讲成“组件列表”，要讲成一条 RPC 调用链和治理链。

## 6. Week2 周复盘方法

### 6.1 每天复盘只做四件事

1. 今天这块能不能先回答标题问题，再展开机制。
2. 今天至少 1 个机制能不能按因果链讲清。
3. 今天最容易被追问散掉的点是什么。
4. 今天这块能不能和项目、线上问题或治理经验挂上钩。

### 6.2 周末复盘不要从头重看

周末建议只做下面几件事：

- 抽查 Spring、Spring MVC / Boot、MyBatis、RPC 各 1 题。
- 每题先讲 1 分钟版本，再补 3 分钟版本。
- 只重看自己讲散的模块。
- 记录本周最弱的 3 个点。

### 6.3 第 2 周最小达标标准

如果 Week2 结束时，下面这些你都能稳定讲出来，就算本周节奏是对的：

- Spring IOC、DI、BeanFactory、ApplicationContext 和 Bean 生命周期主线。
- AOP 为什么能做横切增强，以及 JDK Proxy 和 CGLIB 的边界。
- Spring 为什么只能解决一部分循环依赖，三级缓存到底在做什么。
- `@Transactional` 为什么会失效，传播行为怎么选。
- Spring MVC 请求从进入容器到返回响应的主流程。
- Spring Boot 自动配置为什么成立，自动配置和手工配置边界是什么。
- MyBatis 执行一条 SQL 的流程，以及缓存、分页的风险边界。
- Dubbo / Spring Cloud / gRPC 在内部服务治理和接口边界上的分工。

## 7. 与日复盘文档关系

建议这样配合使用：

- 本文档：
  - 负责 Week2 导航、每日映射和达标标准。
- `topics/*.md`：
  - 负责框架链专题知识正文。
- `daily/*.md`：
  - 负责当天真实问答表现、薄弱点和修正动作。
  - 当前目录已预留，但默认按需新建，不假定已经有现成日文档。

当前 Week2 更值得优先做的是：

- 基于当天真实口头输出，把明显卡顿的模块补进 `daily/`。
- 结合真实追问，把最容易讲散的 2-3 个问题补成简短回答提纲。
- 用本导航 + `topics/*.md` 做周中推进，用 `daily/*.md` 承接真实表现，而不是把复盘内容再塞回导航文档。
