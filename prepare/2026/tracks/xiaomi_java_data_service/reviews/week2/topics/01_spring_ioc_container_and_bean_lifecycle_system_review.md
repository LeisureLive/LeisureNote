# Week2 Spring IOC、容器与 Bean 生命周期专题系统复习

对应计划：

- `prepare/2026/tracks/xiaomi_java_data_service/01_1month_plan.md`
- `prepare/2026/tracks/xiaomi_java_data_service/00_high_frequency_knowledge_map.md`

## 1. 这一块在解决什么问题

Spring IOC 这块不是在考你记住了几个接口名，而是在考你能不能把下面四件事讲清楚：

1. 为什么业务系统需要一个容器来统一管理对象，而不是到处 `new`。
2. IOC 和 DI 到底在解决什么问题，它们和“解耦”之间是什么关系。
3. BeanFactory 和 ApplicationContext 为什么会同时存在，它们的定位差异是什么。
4. Bean 生命周期为什么重要，它为什么会和 AOP、事务、扩展点这些问题连在一起。

把这四个问题串起来，主线其实很稳定：

- 业务系统里的对象越来越多，依赖关系也越来越复杂。
- 如果对象创建、依赖装配、配置和扩展都散落在业务代码里，系统会很快变成硬编码耦合。
- Spring 通过 IOC 容器接管对象管理，DI 则把这种接管落到具体注入动作上。
- 容器接管对象之后，就不只是“把对象造出来”，还要继续管理对象的创建时机、初始化阶段和扩展挂点。
- 所以后面 Bean 生命周期、AOP、事务、循环依赖这些问题，本质上都建立在“容器如何管理对象”这条主线上。

## 2. 先把主线串起来，再看知识树

### 2.1 先用一条因果链把全文串起来

如果你觉得 Spring IOC 容易散，通常不是接口名没记住，而是没有先抓住下面这条因果链：

1. 先看为什么需要容器：对象太多、依赖太复杂，不能再靠手工管理。
2. 再看 IOC 在解决什么：把对象控制权从业务代码转交给容器。
3. 再看 DI 为什么是 IOC 的关键落地方式：对象不再自己创建依赖，而是由容器注入依赖。
4. 再看 BeanFactory 和 ApplicationContext 为什么会被一起问：它们都属于容器体系，但能力边界不一样。
5. 最后看 Bean 生命周期为什么重要：Spring 后续很多增强和扩展能力，都挂在这些阶段上。

所以这篇文档不是在讲几个并列概念，而是在回答一条连续问题链：

- 为什么要有容器。
- IOC / DI 在解决什么。
- 容器到底怎么组织对象。
- 两类核心容器怎么分工。
- Bean 生命周期为什么会成为后续机制的基础。

### 2.2 知识树

- Spring 容器定位
  - 对象管理
  - 依赖管理
  - 配置管理
  - 扩展管理
- IOC 与 DI
  - 控制反转
  - 依赖注入
  - 解耦关系
- 容器体系
  - BeanFactory
  - ApplicationContext
- Bean 定义与创建
  - BeanDefinition
  - 实例化
  - 属性填充
  - 初始化
- Bean 生命周期与扩展点
  - Aware 接口
  - BeanPostProcessor
  - 初始化回调
  - 销毁回调

## 3. 核心重点展开

### 3.1 为什么系统需要 Spring 容器，而不是到处手工 `new` 对象

这一节在回答什么问题：

- Spring 容器到底在解决什么工程问题。
- 为什么它不是“帮你少写几个 `new`”这么简单。

这个问题是怎么解决的：

Spring 容器的核心价值，是把对象的创建、装配、配置和扩展统一收口。真实业务里对象数量多、依赖关系复杂、配置来源也分散，如果每个类都自己 `new` 依赖对象，结果通常会变成依赖关系硬编码、实现替换困难、单测隔离成本高、公共配置和扩展点无法统一治理。

把这个问题放回一个最小业务场景里更容易理解。比如订单系统里，`OrderService` 依赖 `OrderRepository`，`OrderRepository` 又依赖数据源，同时系统里还会挂着缓存、消息、配置、监控相关对象。如果这些对象都靠业务类自己创建，那么对象什么时候创建、依赖从哪里来、以后换实现怎么换，都会落回业务代码本身。Spring 容器做的事情，就是把这些对象都纳入统一托管，让业务代码只表达职责，不再顺手承担对象装配工作。

从机制上看，这件事至少分四层：

1. 容器先知道系统里有哪些 Bean，以及这些 Bean 的定义和依赖元数据。
2. 容器负责在合适的时机创建对象，而不是让业务类自己决定创建流程。
3. 容器在创建过程中把依赖关系注入进去，让对象拿到自己需要的协作者。
4. 容器还能在对象创建前后插入扩展点，继续挂接配置、代理和后置处理逻辑。

所以容器真正解决的不是语法层面的 `new`，而是对象管理权统一之后带来的工程收益：降低耦合、统一治理、提升替换能力和测试友好性。代价则是系统运行时会更依赖容器语义，如果离开容器环境去理解对象关系，就容易漏掉很多运行时行为。

### 3.2 IOC 和 DI 到底在解决什么问题，它们之间是什么关系

这一节在回答什么问题：

- IOC 和 DI 为什么不应该被混成一句口号。
- 为什么面试里这题应该从“控制权变化”去回答，而不是只背术语定义。

这个问题是怎么解决的：

IOC 的核心是对象控制权发生了反转：对象不再自己掌控依赖和创建流程，而是由容器统一接管。DI 则是 IOC 的常见落地方式之一，也就是容器在创建对象时，把对象所需依赖注入进来，而不是让对象自己主动去查找依赖。

所以这两个概念的关系可以压缩成一句话：IOC 是设计思想，DI 是主要实现方式。以前你可能会在 `OrderService` 里直接 `new OrderRepository()`，这时对象自己既承担业务职责，又承担依赖选择和创建职责。用了 Spring 之后，`OrderService` 只需要声明“我需要一个 `OrderRepository`”，真正的依赖解析和注入由容器完成，这就是控制权从业务代码转移到容器的过程。

把它继续拆开看，IOC / DI 在工程上解决的是三类问题：

1. 让业务对象不再和具体实现强绑定，替换实现更自然。
2. 让依赖关系的解析和注入逻辑从业务代码里抽出去，减少对象自管理带来的耦合。
3. 让测试隔离、统一配置和运行时扩展建立在同一套对象管理模型之上。

这也是为什么面试里如果只回答“IOC 就是控制反转，DI 就是依赖注入”，通常是不够的。真正要讲清的是：控制权到底从哪里转移到了哪里，这个转移为什么能降低耦合，以及容器注入为什么比对象自己找依赖更适合复杂系统。

### 3.3 BeanFactory 和 ApplicationContext 为什么会同时存在

这一节在回答什么问题：

- 两类核心容器在定位上到底有什么差异。
- 为什么 Spring 不只保留一个统一容器接口，而要保留“基础容器”和“完整上下文”两层能力。

这个问题是怎么解决的：

BeanFactory 和 ApplicationContext 都属于 Spring 容器体系，但它们承担的层次不同。BeanFactory 更偏基础容器能力，核心是“管理 Bean”；ApplicationContext 则是在它之上补足完整的应用运行时上下文能力，比如事件、国际化、资源加载、环境抽象、自动注册后置处理器等。面试里这两个概念总被一起问，不是为了听你背继承关系，而是为了看你是否知道 Spring 容器既有“最小对象工厂”一层，也有“完整应用上下文”一层。

这层差异放回日常开发场景其实很容易理解。你平时接触到的大多数 Spring 高级能力，比如 AOP、事务、事件、自动装配，并不是只靠一个最小的 Bean 工厂就能舒适使用的，它们更依赖完整上下文能力。因此 Spring 保留 BeanFactory，是为了保留基础对象管理抽象；保留 ApplicationContext，则是为了把对象管理继续扩展成企业级运行环境。

从能力边界上可以这样看：

1. BeanFactory 先解决最基础的 Bean 定义读取、对象创建和依赖管理。
2. ApplicationContext 在此基础上继续叠加事件、资源、国际化、环境、自动化扩展这些应用级能力。
3. 所以后面生命周期、AOP、事务这些问题，通常都不会脱离 ApplicationContext 单独讨论，因为它们本来就更多依赖完整上下文环境。

这一节真正要记住的，不是“哪个接口继承哪个接口”，而是为什么 Spring 既保留最小对象管理层，又保留完整应用上下文层，以及为什么日常开发里你更常站在 ApplicationContext 这一侧看问题。

### 3.4 Bean 生命周期为什么重要，它为什么会成为 AOP、事务、循环依赖的基础

这一节在回答什么问题：

- Bean 生命周期为什么不是单纯背顺序。
- 为什么生命周期阶段会直接影响后续增强能力和依赖处理结果。

这个问题是怎么解决的：

Bean 生命周期重要，是因为 Spring 很多高级能力都不是“对象一创建就自动有”，而是挂在 Bean 从定义、实例化、属性填充、初始化到销毁的不同阶段上。如果你不知道 Bean 现在处在哪个阶段，就很难理解为什么有时代理已经生效、有时循环依赖可以提前暴露、有时事务增强要等后置处理器介入后才成立。

所以生命周期真正回答的不是“背出一长串回调名字”，而是 Spring 在对象管理过程中到底在哪些阶段开放扩展挂点。更实用的理解方式，不是背一条直线，而是先按三层看：

- 容器启动期：先处理 BeanDefinition 和容器规则，还没有正式创建大部分业务 Bean。
- Bean 创建期：实例化、依赖注入、Aware 回调、初始化、代理增强，这一层是面试核心。
- 容器关闭期：处理销毁回调和资源释放。

如果要做到能讲清原理、能接住追问，Bean 创建期最好再细拆成下面这些阶段。

#### 3.4.1 Bean 生命周期主流程、为什么这样分阶段，以及每个阶段的具体例子

1. BeanDefinition / 容器规则阶段

   这一阶段在做什么：

   - Spring 先把系统里有哪些 Bean、Bean 的 class、scope、依赖、初始化方法、销毁方法这些元数据收集起来。
   - 这一步处理的是“对象规则”，还不是“对象实例”。

   为什么放在最前面：

   - 因为很多扩展能力要先改定义，再谈创建；如果 Bean 已经创建好了，再改定义就太晚了。

   常见扩展点：

   - `BeanDefinitionRegistryPostProcessor`
   - `BeanFactoryPostProcessor`
   - `ImportBeanDefinitionRegistrar`

   具体例子：

   - `@Configuration` 类里定义了 `@Bean dataSource()`，Spring 会先通过 `ConfigurationClassPostProcessor` 解析配置类、扫描组件、注册 `BeanDefinition`，这时 `DataSource` 还没有真正创建出来。

2. 实例化前阶段

   这一阶段在做什么：

   - Spring 会先决定这个 Bean 应该怎么创建，比如用哪个构造器、是否需要特殊处理、是否要提前预测类型。

   为什么要单独拆出来：

   - 因为“怎么创建对象”本身就是一个扩展点，有些 Bean 在真正实例化前就需要决定构造方式，少数场景下甚至可以直接短路返回代理对象。

   常见扩展点：

   - `InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation`
   - `SmartInstantiationAwareBeanPostProcessor#determineCandidateConstructors`
   - `SmartInstantiationAwareBeanPostProcessor#predictBeanType`

   具体例子：

   - 一个 `ReportService` 同时有无参构造器和带 `DataSource` 参数的构造器，Spring 需要先判断应该选哪个构造器，再真正去创建对象；构造器选择就发生在这一段。
   - 更精确地说，Spring 选构造器主要看两件事：这个构造器是不是候选构造器，以及它的参数能不能从容器里解析出来。常见规则可以先记成：
     - 只有一个构造器时，通常直接用它。
     - 多个构造器里如果某一个标了 `@Autowired`，优先把它当成候选。
     - 多个候选都能满足时，通常选“参数最多且都能成功解析”的那个。
     - 如果同类型参数有多个 Bean，`@Primary`、`@Qualifier` 这类规则影响的是“参数注入到哪个 Bean”，本质上属于参数解析，不是第一步的构造器筛选。
     - 如果没有明确标注、同时又存在无参构造器，常规场景下通常会直接走无参构造器。

3. 实例化阶段

   这一阶段在做什么：

   - Spring 真正创建出一个原始对象，但这时它通常还是“半成品”。

   为什么不能把它当成最终可用对象：

   - 因为依赖还没注入，初始化逻辑也还没执行，AOP 代理通常也还没包上去。

   常见入口：

   - 构造器实例化
   - 工厂方法实例化
   - `Supplier` 实例化

   具体例子：

   - `UserService` 通过默认构造器被创建出来时，只是一个裸对象；这时候它里面的 `orderRepository`、`redisTemplate` 等字段还没有值。

4. 早期暴露阶段

   这一阶段在做什么：

   - 对单例 Bean，Spring 会在实例化之后、初始化完成之前，先把一个早期引用暴露出去，供别的 Bean 在循环依赖场景下使用。

   为什么会有这条支线：

   - 因为 A 依赖 B、B 又依赖 A 时，如果非要等 A 完全初始化后再暴露，B 永远拿不到 A。

   常见扩展点：

   - `SmartInstantiationAwareBeanPostProcessor#getEarlyBeanReference`

   具体例子：

   - `AService` 字段注入 `BService`，`BService` 又字段注入 `AService`。Spring 创建 `AService` 后，会先暴露一个早期引用，`BService` 才能先拿到 `AService`，这也是循环依赖和三级缓存经常连在一起问的原因。

5. 属性填充 / 依赖注入阶段

   这一阶段在做什么：

   - Spring 在对象已经创建出来之后，开始解析依赖并把值注入进去，比如 `@Autowired`、`@Resource`、`@Value`。

   为什么放在实例化之后：

   - 因为总得先有对象壳子，才能往对象里填协作者和配置。

   常见扩展点：

   - `InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation`
   - `InstantiationAwareBeanPostProcessor#postProcessProperties`
   - `MergedBeanDefinitionPostProcessor#postProcessMergedBeanDefinition`

   具体例子：

   - `OrderService` 上有 `@Autowired private OrderRepository orderRepository;`，Spring 会在这一阶段把 `OrderRepository` 注入进去。也就是说，`@Autowired` 的核心执行阶段不在初始化，而在属性填充。

6. Aware 回调阶段

   这一阶段在做什么：

   - Spring 不再注入业务依赖，而是把“容器层面的信息和能力”交给 Bean，比如 Bean 名称、`BeanFactory`、`ApplicationContext`、`Environment`。

   为什么要放在初始化前：

   - 因为很多初始化逻辑本身就需要这些容器信息；如果初始化时还拿不到容器上下文，后面的 init 逻辑就做不了。

   常见扩展点：

   - `BeanNameAware`
   - `BeanFactoryAware`
   - `ApplicationContextAware`
   - `EnvironmentAware`
   - `ApplicationContextAwareProcessor`

   具体例子：

   - `PluginManager implements ApplicationContextAware, InitializingBean`，Spring 会先回调 `setApplicationContext(...)`，然后 `PluginManager` 才能在 `afterPropertiesSet()` 里通过 `applicationContext.getBeansOfType(Plugin.class)` 一次性拿到所有插件 Bean，完成插件注册。

7. 初始化阶段

   这一阶段在做什么：

   - 业务依赖和容器信息都齐了，Spring 开始执行初始化回调，让 Bean 从“装配完成”变成“可用状态”。

   为什么必须等依赖注入和 Aware 之后再执行：

   - 因为初始化逻辑经常要校验依赖、读取配置、做预热，如果对象状态还不完整，就容易出现空指针或初始化不完整。

   常见扩展点：

   - `BeanPostProcessor#postProcessBeforeInitialization`
   - `@PostConstruct`
   - `InitializingBean#afterPropertiesSet()`
   - 自定义 `init-method`

   具体例子：

   - `CacheClient` 在 `@PostConstruct` 里校验地址配置、初始化连接池、预热本地缓存。它之所以放在这里做，是因为这时候 `@Value` 配置和依赖对象都已经准备好了。

8. 初始化后增强阶段

   这一阶段在做什么：

   - Spring 判断这个 Bean 要不要被包装、代理或增强，很多 AOP 能力都挂在这一段。

   为什么通常放在初始化后：

   - 因为代理最好包裹的是一个依赖完整、初始化完成的目标对象，而不是一个半成品对象。

   常见扩展点：

   - `BeanPostProcessor#postProcessAfterInitialization`

   具体例子：

   - `OrderService` 标了 `@Transactional`，容器最后放出去的通常不是原始 `OrderService`，而是一个事务代理对象。也正因为事务能力来自代理，所以自调用时 `this.createOrder()` 不会走代理链，事务可能失效。

9. 销毁阶段

   这一阶段在做什么：

   - 容器关闭时，Spring 调用销毁回调，释放线程池、连接池、文件句柄等资源。

   为什么也需要扩展点：

   - 因为很多框架对象占用了外部资源，如果只靠 JVM 回收内存而不显式释放，资源可能长期不归还。

   常见扩展点：

   - `DestructionAwareBeanPostProcessor#postProcessBeforeDestruction`
   - `@PreDestroy`
   - `DisposableBean#destroy()`
   - 自定义 `destroy-method`

   具体例子：

   - 一个 `MetricsReporter` 内部维护了定时线程池，它可以在 `@PreDestroy` 或 `destroy()` 里执行 `executor.shutdown()`，避免应用关闭时线程还挂着。

#### 3.4.2 把高频问题重新挂回这些阶段

- `@Autowired` 为什么能生效：
  - 因为依赖注入主要发生在“属性填充阶段”，不是初始化阶段。
- `ApplicationContextAware` 这类接口在干什么：
  - 它们不是注入业务依赖，而是在“Aware 回调阶段”把容器能力交给 Bean。
- `@PostConstruct`、`afterPropertiesSet()` 为什么要放后面：
  - 因为它们依赖对象已经拿到完整依赖和容器信息。
- `@Transactional` 为什么不是对象天生自带的能力：
  - 因为事务通常是在“初始化后增强阶段”通过代理织入的。
- 循环依赖为什么和三级缓存、代理提前暴露一起问：
  - 因为它依赖“早期暴露阶段”；如果没有提前引用，很多单例循环依赖根本无法打通。

#### 3.4.3 这一节真正要记住什么

- 生命周期不是“实例化 -> 注入 -> 初始化 -> 销毁”这么粗的一条线，而是“定义规则 -> 创建半成品对象 -> 注入依赖 -> 注入容器能力 -> 初始化 -> 增强代理 -> 销毁资源”的分阶段流水线。
- 不同能力依赖的对象状态不同，所以扩展点必须拆开：
  - 改规则的，在实例化前。
  - 注业务依赖的，在属性填充阶段。
  - 注容器能力的，在 Aware 阶段。
  - 做初始化的，在依赖都齐之后。
  - 做 AOP / 事务增强的，通常在初始化后。
  - 处理循环依赖的，会走早期暴露这条支线。
- 所以 Bean 生命周期题本质上不是顺序题，而是在问：Spring 到底在哪些阶段开放了哪些挂点，这些挂点为什么会决定 AOP、事务、循环依赖这些机制的真实行为。

## 4. 边界、误区、常见追问

- 不要把 IOC 讲成“对象交给 Spring 管”就结束，重点要落到控制权变化和解耦收益。
- 不要把 DI 和 IOC 完全等同，前者更像后者的主要实现方式。
- BeanFactory 和 ApplicationContext 不要答成类名背诵题，重点是基础容器层和完整上下文层的差异。
- Bean 生命周期不是背步骤题，重点是“每个阶段在给后续机制提供什么挂点”。
- 不要把 `@Autowired` 和 Aware 回调混成一类，前者是业务依赖注入，后者是容器能力注入。
- 不要忽略“早期暴露”这条支线，不然很难解释循环依赖和代理提前暴露。
- 面试官经常会从生命周期继续追问到 AOP、事务、循环依赖，所以这一节不能和后面那些专题割裂开。

## 5. 自测清单

- 你能不能先不背术语，直接讲 Spring 容器在解决什么工程问题。
- 你能不能把 IOC 和 DI 用“控制权变化”讲清楚。
- 你能不能说明 BeanFactory 和 ApplicationContext 的定位差异，而不是只背接口名。
- 你能不能按“定义规则 -> 实例化 -> 早期暴露 -> 属性注入 -> Aware -> 初始化 -> 初始化后增强 -> 销毁”讲清 Bean 生命周期主流程。
- 你能不能分别指出 `@Autowired`、`ApplicationContextAware`、`@PostConstruct`、`@Transactional`、循环依赖各自落在哪个阶段。
- 你能不能解释 Bean 生命周期为什么会和 AOP、事务、循环依赖连在一起问。
- 你能不能用 1-2 分钟把“Spring IOC 是什么”讲顺。
