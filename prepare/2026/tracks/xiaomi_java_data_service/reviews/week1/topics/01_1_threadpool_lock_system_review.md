# Week1 线程池与锁专题系统复习

对应计划：

- `prepare/2026/tracks/xiaomi_java_data_service/01_1month_plan.md`
- `prepare/2026/tracks/xiaomi_java_data_service/00_high_frequency_knowledge_map.md`
- `prepare/2026/tracks/xiaomi_java_data_service/reviews/week1/daily/daily/day1_threadpool_lock_review.md`

使用方式：

- 先建立“资源控制 -> 锁选型 -> 工程边界”的主线
- 不要只背参数和 API，要能解释为什么这样设计、什么时候这样选

## 1. 这一块在解决什么问题

这块专题主要回答两类问题：

1. 任务执行资源怎么控制，才能既有吞吐又不把机器和下游打爆
2. 多线程进入临界区时，怎么用锁保证正确性，并在能力和复杂度之间做选型

## 2. 知识树

- 线程池：
  - 本质
  - 执行流程
  - 参数职责
  - 容量配置
  - 队列和拒绝策略
  - 监控与调参
- 锁：
  - `synchronized`
  - `ReentrantLock`
  - 选型边界
  - 公平锁 / 非公平锁
  - `Condition`

## 3. 核心重点展开

### 3.1 线程池

#### 1）先理解线程池的本质

线程池不是“让程序更快的开关”，而是任务执行资源的管理器。

它至少同时承担四个职责：

- 复用线程，减少频繁创建和销毁开销
- 限制并发度，避免线程无限增长
- 通过队列做短时削峰
- 在系统超载时，通过拒绝策略做过载保护

#### 2）线程池执行流程要形成稳定画面

提交一个任务后，核心流程是：

1. 当前线程数小于 `corePoolSize`：
   - 直接创建核心线程执行
2. 否则尝试入队：
   - 放进 `workQueue`
3. 队列满且线程数小于 `maximumPoolSize`：
   - 创建非核心线程执行
4. 队列也满、线程数也到上限：
   - 执行拒绝策略

你可以用一句话把它固定下来：

- `corePoolSize` 扛常态
- `workQueue` 做削峰
- `maximumPoolSize` 兜波峰
- 拒绝策略负责系统保护

#### 3）参数不要分散背，要按职责背

- `corePoolSize`：
  - 常态承载能力
- `maximumPoolSize`：
  - 波峰兜底能力
- `workQueue`：
  - 短时缓冲和削峰手段
- `keepAliveTime`：
  - 非核心线程的回收策略
- `threadFactory`：
  - 线程命名、优先级、异常处理入口
- `RejectedExecutionHandler`：
  - 满载时的失败策略

#### 4）线程池配置思路必须从容量视角讲

不要上来背 `N+1`、`2N`，而要按这条线说：

1. 先区分任务是 CPU 密集型还是 IO 密集型
2. 再估算平均并发：
   - `平均并发 ≈ TPS x RT`
3. 再估算 CPU 需求：
   - `CPU 核需求 ≈ TPS x 单请求 CPU 时间`
4. 再看下游稳定承载能力
5. 最后再决定：
   - `corePoolSize`
   - `maximumPoolSize`
   - `workQueue`
   - 拒绝策略

这题的关键不是给一个神奇数字，而是证明你知道：

- 线程池不能解决算力不足
- 线程池不能解决下游扛不住
- 线程池只能让过载行为变得可控

#### 5）队列和拒绝策略要会结合场景

队列选择的核心不是背名字，而是知道“你到底要优先保护什么”：

- 查询类接口：
  - 更关注延迟，倾向有界队列 + 快速失败
- 批处理 / 异步任务：
  - 能接受一定排队，但也不能无界堆积

拒绝策略常见理解：

- `AbortPolicy`：
  - 显式失败，适合必须感知过载的场景
- `CallerRunsPolicy`：
  - 用调用方线程做反压，但会拖慢上游线程
- `DiscardPolicy`：
  - 只有任务允许丢失时才考虑
- `DiscardOldestPolicy`：
  - 更关注新任务，但要非常清楚业务影响

#### 6）为什么不建议直接使用 `Executors`

这题本质上是在考“默认配置失控风险”：

- `newFixedThreadPool` / `newSingleThreadExecutor`：
  - 无界队列，容易把问题拖成高延迟和内存风险
- `newCachedThreadPool`：
  - 线程数膨胀太快，容易把 CPU 和上下文切换打爆

所以生产环境更推荐显式创建 `ThreadPoolExecutor`。

#### 7）线程池深挖时应该怎么展开

面试官如果问“线程池参数怎么配”，推荐按这条顺序讲：

1. 先说任务类型和目标保护对象
2. 再说流量、RT、CPU 和下游承载估算
3. 再给一个保护性的初始配置
4. 再说上线后重点观察哪些指标
5. 最后补调参原则，而不是把配置说成绝对正确

#### 8）线程池必须会补的监控指标

- 活跃线程数
- 队列长度
- 拒绝次数
- 任务执行耗时
- 下游 RT / 错误率
- CPU / Load / GC
### 3.2 `synchronized` 和 `ReentrantLock`

#### 1）这题不要只背“关键字和类”

两者都是用来做互斥同步的，但能力边界不同。

共同点：

- 都能保证临界区互斥
- 都能建立可见性语义
- 都是可重入的

差异点：

- `synchronized`：
  - JVM 层面的内置锁
  - 语法简单
  - 退出同步块会自动释放锁
- `ReentrantLock`：
  - JUC 显式锁
  - 支持可中断获取锁
  - 支持超时获取锁
  - 支持公平锁
  - 支持多个 `Condition`
  - 必须手动 `unlock()`

#### 2）选型逻辑要会说

- 简单互斥、结构清晰：
  - 优先 `synchronized`
- 需要超时控制、可中断、多个条件队列：
  - 选 `ReentrantLock`

#### 3）继续深挖时怎么答

如果被追问，不要立刻进源码，先按“能力差异 -> 适用场景 -> 风险点”展开：

- 公平锁为什么吞吐更低
- 为什么 `unlock()` 必须放 `finally`
- `Condition` 为什么比 `wait/notify` 更灵活
## 4. 推荐表达顺序

如果面试官问线程池或锁，推荐按下面顺序讲：

1. 先说它在解决什么问题：
   - 控制资源，还是保证临界区互斥
2. 再说核心机制：
   - 线程池执行流程、参数职责，或者锁的能力边界
3. 再说选型：
   - 为什么选这套方案，而不是另一套
4. 最后补工程点：
   - 监控、调参、拒绝策略、误区

## 5. 自测清单

- 线程池为什么不是“线程越多越好”
- `corePoolSize`、`maximumPoolSize`、`workQueue` 分别在承担什么职责
- 为什么不建议直接使用 `Executors`
- 线程池参数为什么必须结合流量、RT、CPU 和下游承载一起算
- `synchronized` 和 `ReentrantLock` 的共同点和差异是什么
- 什么时候优先选 `synchronized`，什么时候选 `ReentrantLock`
- 公平锁为什么通常吞吐更低
- 为什么 `unlock()` 必须放进 `finally`
