# Week2 RPC、Dubbo、Spring Cloud 与 gRPC 治理主线专题系统复习

对应计划：

- `prepare/2026/tracks/xiaomi_java_data_service/01_1month_plan.md`
- `prepare/2026/tracks/xiaomi_java_data_service/00_high_frequency_knowledge_map.md`

## 1. 这一块在解决什么问题

RPC / 服务治理这块不是在考你背组件名，而是在考你能不能把下面五件事讲清楚：

1. 为什么服务拆分后，系统需要一套比“手工调 HTTP”更稳定、更可治理的远程调用模型。
2. 一次 RPC 调用从调用方发起，到服务方执行，再到结果返回，中间到底经过了哪些关键环节。
3. 注册发现、负载均衡、超时、重试、熔断、降级、序列化、连接管理为什么总会一起出现。
4. Dubbo、Spring Cloud、gRPC 为什么总被放在一起比较，但它们其实不是同一层面的东西。
5. 做框架选型时，应该按什么维度判断：性能、跨语言、治理生态、团队栈、运维复杂度到底谁优先。

把这些点串起来，主线其实很稳定：

- 服务一旦拆开，调用就从本地方法调用变成了跨进程、跨机器、跨网络调用。
- 远程调用天然比本地调用多出地址发现、连接建立、序列化、网络传输、失败处理这些问题。
- 所以系统不能只解决“调通”，还要解决“如何稳定地调、如何治理、如何观测、如何演进”。
- Dubbo、Spring Cloud、gRPC 都在处理分布式调用问题，但关注的抽象层次和侧重点并不一样。
- 真正高质量的回答，重点不是“组件列表”，而是把远程调用主线、治理主线和选型逻辑讲成一套完整工程判断。

所以这块真正要建立的是三种能力：

- 能把一次 RPC 调用链讲清，而不是只说“代理 + 注册中心 + 负载均衡”。
- 能把治理能力讲成一套组合拳，而不是零散术语清单。
- 能把 Dubbo、Spring Cloud、gRPC 放回不同抽象层和适用场景里做比较。

## 2. 先把主线串起来，再看知识树

### 2.1 先用一条因果链把全文串起来

如果你觉得 RPC 容易散，通常不是术语没记住，而是没有先抓住下面这条主线：

1. 先看为什么需要 RPC：服务拆分后，方法调用不再是同进程内存访问，而是跨网络调用。
2. 再看一次调用怎么完成：代理接管调用，定位服务实例，选择节点，编码请求，网络传输，服务端执行，再编码返回。
3. 再看为什么治理能力一定会跟上：网络会抖动、节点会挂、延迟会飘、调用会失败。
4. 再看 Dubbo、Spring Cloud、gRPC 为什么会被一起比较：它们都能参与服务间通信，但解决问题的层次不同。
5. 最后看如何选型：内部 Java 高性能调用、Spring 微服务生态整合、跨语言契约通信，本来就不是一把尺子能量完的。

所以这篇文档不是在讲几个并列组件，而是在回答一条连续问题链：

- 为什么需要 RPC。
- 一次调用怎么跑。
- 治理能力为什么必须成体系。
- 三种常见体系到底怎么分层比较。
- 选型时到底看什么。

### 2.2 知识树

- RPC 基础定位
  - 本地调用 vs 远程调用
  - 服务拆分后的通信问题
  - 远程调用新增成本
- RPC 调用主线
  - 本地代理
  - 服务发现
  - 负载均衡
  - 序列化
  - 网络传输
  - 服务端反序列化与执行
  - 结果返回
- 治理能力
  - 超时
  - 重试
  - 连接管理
  - 容错与熔断
  - 降级
  - 监控与追踪
- 体系对比
  - Dubbo
  - Spring Cloud
  - gRPC
- 选型维度
  - 语言栈
  - 协议与性能
  - 治理生态
  - 运维复杂度
  - 团队经验

## 3. 核心重点展开

### 3.1 为什么系统需要 RPC，而不是服务之间都手工调 HTTP 就够了

这一节在回答什么问题：

- RPC 在分布式系统里到底在解决什么。
- 为什么它不是“换个协议名词”，也不是“HTTP 不行”。

这个问题是怎么解决的：

服务拆分之后，最大的变化不是接口从 Java 方法变成了 URL，而是调用从“进程内、低失败率、低成本”的本地调用，变成了“跨网络、会失败、会超时、会抖动”的远程调用。RPC 的价值，不是简单把 HTTP 包起来，而是把这些分布式调用必然带来的工程问题统一抽象出来。

如果完全手工调 HTTP，当然也能完成通信。但系统一旦变复杂，下面这些问题很快就会散落在业务代码里：

- 服务地址从哪来。
- 节点变更时怎么更新。
- 多实例怎么选一个。
- 超时怎么配。
- 失败后要不要重试。
- 重试会不会破坏幂等性。
- 调用链路怎么监控。
- 某个下游抖动时如何避免雪崩。

所以 RPC 不是在解决“能不能把请求发出去”，而是在解决：

- 如何把远程调用抽象成统一模型。
- 如何把服务发现、路由、超时、重试、监控这些公共能力收口。
- 如何让业务代码尽量只表达“我要调哪个服务、哪个方法”，而不是自己管理整套分布式通信细节。

这也是为什么面试里不要把 RPC 答成“像本地调用一样调远程服务”。更准确的说法应该是：

- RPC 试图给业务层提供接近本地调用的使用体验
- 但底层依然是远程调用，它只是把远程调用的复杂性统一托管了

所以 RPC 的价值是：

1. 统一服务间调用模型。
2. 统一远程调用治理入口。
3. 让业务层不必重复处理服务地址、失败策略、连接管理等基础设施问题。

收益是调用方式更统一、治理能力更集中；边界是网络不确定性不会因为用了 RPC 就消失，框架只是把它们显性化、模型化、可治理化。

### 3.2 一次 RPC 调用到底是怎么从调用方走到服务方再返回的

这一节在回答什么问题：

- RPC 调用链到底怎么跑。
- 为什么代理、注册发现、负载均衡、序列化总被放在同一条主线上。

这个问题是怎么解决的：

一次 RPC 调用的主流程，本质上是：

- 本地代码调用接口方法
- 代理对象接住调用
- 定位服务和方法元数据
- 选择服务实例
- 把请求编码后通过网络发出去
- 服务端反解请求并执行
- 把结果再编码返回
- 调用方解码结果并返回给业务线程

这里最容易被忽略的是：

- 业务代码看到的是“方法调用”
- 但底层实际做的是“一次完整的分布式请求-响应过程”

可以把这条链展开成下面几步：

1. 调用方本地代理接管调用

- 业务代码通常写的是：
  - `inventoryService.deduct(...)`
- 但这个 `inventoryService` 往往不是本地真实实现，而是一个代理对象。
- 代理对象会把：
  - 接口名
  - 方法名
  - 参数类型
  - 参数值
  这些信息整理成一次远程调用请求。

这一层解决的是：

- 把“本地方法调用”翻译成“可远程传输的调用描述”

2. 服务发现与服务实例列表获取

- 调用方不能把地址硬编码在业务代码里，因为服务实例会扩缩容、上线下线、迁移。
- 所以通常要通过注册中心或服务发现机制拿到某个服务当前可用的实例列表。

这一层解决的是：

- “我要调 `inventory-service`，它现在有哪些可用节点？”

3. 负载均衡选择目标节点

- 当服务有多个实例时，调用方要选择其中一个发请求。
- 常见策略可能包括：
  - 随机
  - 轮询
  - 最少活跃
  - 一致性哈希
  - 基于响应时间或权重的策略

这一层解决的是：

- 同一个服务多个实例时，本次流量该打给谁

4. 序列化与协议编码

- 本地参数对象不能直接通过网络传输，必须先编码。
- 不同体系在这里会有不同偏好：
  - Dubbo 可支持多种序列化与协议组合
  - gRPC 默认更强调 protobuf + HTTP/2
  - Spring Cloud 常见服务间调用很多时候基于 HTTP/JSON 风格组件

这一层解决的是：

- 如何把方法调用数据转成可传输字节流

5. 网络传输与连接管理

- 请求会通过 TCP / HTTP/2 / 长连接等方式传到服务端。
- 这里又会引入：
  - 连接复用
  - 连接池
  - keepalive
  - 粘包拆包
  - 半连接 / 断连 / 慢网络等问题

这一层解决的是：

- 远程请求如何稳定送达

6. 服务端反序列化与方法执行

- 服务端收到请求后，要先把字节流还原成调用信息。
- 再根据服务接口和方法元数据找到目标实现。
- 执行目标方法，得到结果或异常。

这一层解决的是：

- 请求怎么在服务端重新变成一次真实方法调用

7. 结果编码、返回与调用方解码

- 服务端把执行结果编码回响应报文。
- 调用方收到响应，再解码成业务代码可理解的结果。
- 如果中间有超时、异常、节点失败，也要在这里统一转换成调用异常语义。

这一层解决的是：

- 如何把远程执行结果安全地交还给业务线程

所以一条 RPC 调用真正的主线可以压成一句话：

- 本地代理把方法调用转成远程请求，服务发现与负载均衡决定调谁，协议与序列化决定怎么传，服务端再把请求还原成方法执行，最后把结果返回给调用方。

面试里如果你能把这条链讲顺，后面再挂超时、重试、熔断、监控就会很自然，因为这些治理能力本来就是围绕这条链设计的。

### 3.3 为什么超时、重试、负载均衡、熔断、降级这些治理能力不能零散地讲

这一节在回答什么问题：

- 为什么远程调用题最后一定会落到治理。
- 为什么治理能力必须按组合拳理解，而不是背清单。

这个问题是怎么解决的：

治理能力之所以总要成体系出现，是因为它们都在回答同一个问题：

- 远程调用天然不稳定，系统如何把失败控制在可接受范围内。

它们各自解决的问题其实不同：

- 超时
  - 定义“等多久算失败”
- 重试
  - 定义“失败后要不要再试，以及怎么试”
- 负载均衡
  - 定义“流量优先打到谁”
- 熔断
  - 定义“什么时候不该继续打下游了”
- 降级
  - 定义“打不通时，系统还能返回什么”
- 监控和追踪
  - 定义“问题发生后，怎么定位和量化”

这些能力如果单独看，都像配置项；但放回一次真实调用，就会发现它们强耦合。

比如某个下游实例开始抖动：

- 没有超时：调用线程可能一直被卡住
- 有超时但没负载均衡调整：流量仍然持续打向坏节点
- 有重试但没幂等设计：可能把写请求放大成重复副作用
- 有重试但没熔断：系统可能在失败时进一步放大流量和线程压力
- 有熔断但没降级：用户看到的仍然可能是直接失败

所以治理能力真正的重点不是“都支持哪些”，而是：

- 这些策略组合起来是否符合业务语义
- 尤其是幂等性、延迟目标、可用性目标、流量模型是否匹配

这一节最值得你在面试里强调的一句是：

- 治理不是越多越好，配置不当本身也会制造新的故障

典型例子：

- 下游超时 500ms
- 上游配置重试 3 次
- 整条调用链本来就接近超时边缘

这时所谓“提高成功率”的重试，可能会让单次调用时延翻倍，还可能把本来只是轻微抖动的下游直接打崩。

所以治理能力应该按下面这条顺序理解：

1. 先定义失败边界：超时
2. 再定义失败后的补救：重试 / 容错
3. 再定义失败持续时的止损：熔断 / 降级
4. 再通过负载均衡和流量治理优化整体分配
5. 最后用监控和追踪验证这些策略是否真的有效

只要你把治理放回调用链来讲，面试官继续追问“重试为什么不能乱开”“为什么超时和重试要一起调”“为什么内部写操作常常重试要谨慎”时，你就不会答成碎片。

### 3.4 Dubbo、Spring Cloud、gRPC 为什么总被放在一起比较，它们到底该怎么分层理解和选型

这一节在回答什么问题：

- 三种常见体系的定位差异是什么。
- 为什么它们不是简单的谁替代谁，而是解决问题的抽象层不同。

这个问题是怎么解决的：

Dubbo、Spring Cloud、gRPC 总被一起比较，是因为它们都能参与服务间通信和治理，但它们不是同一个抽象层的产品。

最容易答错的地方是把它们都说成“RPC 框架”。更准确的说法应该是：

- Dubbo：更接近一套以 Java 内部服务调用和治理为核心的 RPC 框架/生态
- Spring Cloud：更接近一套围绕 Spring 微服务体系的基础设施组合
- gRPC：更接近一个跨语言、高性能、强契约的 RPC 协议与框架体系

如果这一题要答稳，最好的方式不是背一个粗糙对比表，而是按下面三层来讲：

1. 各自怎么定义和发起一次调用
2. 各自擅长解决什么问题
3. 场景里到底该怎么选

#### 3.4.1 先看 Dubbo：怎么用、强项是什么、边界在哪里

Dubbo 最适合先理解成：

- 以接口为中心的 RPC + 服务治理框架

它最典型的使用模型是：

1. 先定义公共服务接口
2. Provider 实现接口并暴露服务
3. Consumer 引用这个接口生成远程代理
4. 通过注册中心完成服务发现
5. 在调用链上挂负载均衡、超时、重试、路由、监控等治理能力

最小使用形态通常是这样：

```java
public interface UserService {
    UserDTO getUserById(Long userId);
}
```

Provider：

```java
@DubboService(timeout = 3000, retries = 0)
public class UserServiceImpl implements UserService {
    @Override
    public UserDTO getUserById(Long userId) {
        return new UserDTO(userId, "alice");
    }
}
```

Consumer：

```java
@Service
public class OrderAppService {

    @DubboReference(timeout = 2000, check = false)
    private UserService userService;

    public String queryUserName(Long userId) {
        return userService.getUserById(userId).getName();
    }
}
```

如果把这套最小示例再往前补一层，配置文件通常至少要让你看见三件事：

- 这个应用是谁
- 注册中心连到哪里
- 用什么协议暴露或消费服务

一个常见的 Spring Boot + Dubbo 配置示例可以先记成这样：

Provider 侧：

```yaml
dubbo:
  application:
    name: user-service
  registry:
    address: zookeeper://127.0.0.1:2181
  protocol:
    name: dubbo
    port: 20880
  provider:
    timeout: 3000
    retries: 0

spring:
  application:
    name: user-service
```

Consumer 侧：

```yaml
dubbo:
  application:
    name: order-service
  registry:
    address: zookeeper://127.0.0.1:2181
  consumer:
    timeout: 2000
    retries: 0
    check: false

spring:
  application:
    name: order-service
```

这组配置最值得先理解的是：

- `dubbo.application.name`
  - 当前 Dubbo 应用名
- `dubbo.registry.address`
  - 注册中心地址，比如 Zookeeper / Nacos
- `dubbo.protocol`
  - Provider 对外暴露服务的协议和端口
- `dubbo.provider`
  - Provider 侧默认治理配置
- `dubbo.consumer`
  - Consumer 侧默认治理配置

如果注册中心换成 Nacos，常见写法会变成类似：

```yaml
dubbo:
  registry:
    address: nacos://127.0.0.1:8848
```

这里要注意两点：

- 不同 Dubbo 版本、starter 和注册中心类型，配置项细节可能有差异
- 面试里不用死背所有配置项，先记住“应用名、注册中心、协议端口、消费端/提供端治理参数”这四组核心信息就够了

所以 Dubbo 的完整使用模型，最好是按下面顺序去记：

1. 公共接口
2. Provider 实现 + `@DubboService`
3. Consumer 引用 + `@DubboReference`
4. 配置文件里声明应用名、注册中心、协议和治理参数
5. 启动后由框架完成本地暴露、注册发现和调用链治理接入

这段代码表面上看像本地接口调用，但底层真正发生的是：

- `@DubboReference` 注入的不是本地实现，而是远程代理
- 代理把接口名、方法名、参数类型、参数值封装成 RPC 请求
- Consumer 从注册中心拿到 Provider 列表
- 根据负载均衡策略选择一个实例
- 再按协议和序列化方式发起远程调用
- 服务端执行后把结果返回

所以 Dubbo 的核心价值不只是“能调远程接口”，而是：

- 把服务发现、调用、治理这几件事统一到一套接口化模型里

Dubbo 最值得记住的功能特点有四个。

第一，接口化体验自然。

- 对 Java 团队来说，定义接口、实现接口、引用接口的方式很贴近本地开发习惯

第二，治理能力贴近调用层。

- 超时
- 重试
- 负载均衡
- 路由
- 权重
- 灰度
- 熔断降级
- 监控

这些能力都可以直接挂在 RPC 调用链上，而不是分散在业务代码里。

第三，内部高频服务调用通常比较顺手。

- 传统 Dubbo 常见是基于自定义二进制 RPC 协议
- Dubbo 3 也支持 Triple 等新协议
- 它通常比很多 `HTTP/JSON` 风格的内部调用更偏性能导向

第四，Java 内部微服务场景成熟度高。

- 如果团队主体是 Java
- 服务间同步调用很多
- 又很重视注册发现和流量治理

Dubbo 往往会比较自然。

但 Dubbo 的边界也要讲清。

第一，它传统上更适合 Java-to-Java。

- 传统 Dubbo 的主模型是共享 Java 接口
- 非 Java 并不会直接“理解 Java interface”

所以 Dubbo 做跨语言时，真正共享的不是 Java 接口本身，而是：

- 服务名
- 方法名
- 参数结构
- 返回值结构
- 协议与序列化契约

这也是为什么 Dubbo 要做跨语言，通常要靠：

- Triple
- Protobuf / 语言无关契约
- 泛化调用
- 网关转换

而不是只靠共享一份 Java 接口 jar。

第二，它整套治理体系会带来复杂度。

- 注册中心
- 配置中心
- 路由规则
- 权重和超时重试

这些能力很强，但也意味着排障时链路更长。

所以 Dubbo 最适合的场景通常是：

- 主要是 Java 服务
- 内部同步 RPC 调用多
- 更重视 RPC 层治理
- 希望把服务发现、流量治理、超时重试等能力集中在一套体系里

再往下一层，如果面试官继续追问：

- “Dubbo 难道不也需要 Zookeeper / Nacos 这类注册中心吗？”
- “那为什么还说它在注册发现和治理上比 gRPC 更强？”

更稳的回答应该是：

- 是的，Dubbo 通常也需要外部注册中心
- 它的优势不在于“没有外部组件”
- 而在于它把“服务注册、服务订阅、地址变更通知、实例列表维护、路由、负载均衡、动态治理”做成了框架主干能力

也就是说，在 Dubbo 里，Provider 启动后通常会做两件事：

1. 本地暴露服务
2. 把服务元数据注册到注册中心

Consumer 侧通常也会自动完成：

1. 订阅服务
2. 拉取或监听 Provider 列表
3. 在本地维护可用实例视图
4. 调用时基于本地视图做路由和负载均衡

所以 Dubbo 真正更强的地方，不是“它不需要注册中心”，而是：

- 它把注册发现和 RPC 调用、流量治理打通成了一套统一模型

相比之下，gRPC 的核心更偏：

- proto
- stub
- channel
- `HTTP/2 + Protobuf`

服务注册发现当然也能做，但往往要再结合：

- DNS
- Kubernetes Service
- service mesh
- 自定义 name resolver
- Nacos / Consul / Zookeeper 的额外集成

所以如果要把这个差异压成一句话，就是：

- Dubbo 更像“RPC + 注册发现 + 治理框架”
- gRPC 更像“RPC 通信内核 + 契约体系”，注册发现和治理通常要靠外围基础设施补齐

#### 3.4.2 再看 gRPC：怎么用、强项是什么、为什么和 Dubbo 不一样

gRPC 最适合先理解成：

- 契约优先、跨语言友好、基于 HTTP/2 + Protobuf 的 RPC 体系

它和 Dubbo 最大的区别不是“谁也能远程调用”，而是：

- Dubbo 更像接口优先
- gRPC 更像 IDL 优先

gRPC 的典型使用模型不是先写 Java 接口，而是先写 `.proto`：

```proto
syntax = "proto3";

service UserService {
  rpc GetUserById(GetUserByIdRequest) returns (GetUserByIdResponse);
}

message GetUserByIdRequest {
  int64 user_id = 1;
}

message GetUserByIdResponse {
  int64 id = 1;
  string name = 2;
}
```

然后通过代码生成工具，生成各语言的：

- 请求响应类
- 客户端 stub
- 服务端基类

服务端实现通常像这样：

```java
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {
    @Override
    public void getUserById(GetUserByIdRequest request,
                            StreamObserver<GetUserByIdResponse> responseObserver) {
        GetUserByIdResponse response = GetUserByIdResponse.newBuilder()
                .setId(request.getUserId())
                .setName("alice")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
```

客户端调用通常像这样：

```java
ManagedChannel channel = ManagedChannelBuilder
        .forAddress("127.0.0.1", 9090)
        .usePlaintext()
        .build();

UserServiceGrpc.UserServiceBlockingStub stub =
        UserServiceGrpc.newBlockingStub(channel);

GetUserByIdResponse response = stub.getUserById(
        GetUserByIdRequest.newBuilder().setUserId(1L).build()
);
```

如果也按“最小可运行形态”把 gRPC 补完整，除了 proto、服务端实现、客户端调用之外，通常还要补两层：

- 服务端怎么启动监听
- 客户端 channel 怎么初始化

服务端启动示例：

```java
Server server = ServerBuilder.forPort(9090)
        .addService(new UserServiceImpl())
        .build()
        .start();

server.awaitTermination();
```

这里最值得先理解的是：

- `forPort(9090)`
  - 当前 gRPC Server 监听哪个端口
- `addService(...)`
  - 把服务实现注册到本地 gRPC Server 的方法路由表
- `build().start()`
  - 真正启动 server，开始接收请求

这一步要特别注意：

- `addService(...)` 不是注册到注册中心
- 它只是让本地 server 知道某个 `service/method` 请求该交给哪个 handler

客户端 channel 初始化示例：

```java
ManagedChannel channel = ManagedChannelBuilder
        .forAddress("127.0.0.1", 9090)
        .usePlaintext()
        .build();

UserServiceGrpc.UserServiceBlockingStub stub =
        UserServiceGrpc.newBlockingStub(channel)
                .withDeadlineAfter(200, TimeUnit.MILLISECONDS);
```

如果把 keepalive 和 retry 也放进去，可以先记成这种形态：

```java
ManagedChannel channel = ManagedChannelBuilder
        .forAddress("127.0.0.1", 9090)
        .usePlaintext()
        .keepAliveTime(30, TimeUnit.SECONDS)
        .keepAliveTimeout(10, TimeUnit.SECONDS)
        .keepAliveWithoutCalls(true)
        .enableRetry()
        .build();

UserServiceGrpc.UserServiceBlockingStub stub =
        UserServiceGrpc.newBlockingStub(channel)
                .withDeadlineAfter(300, TimeUnit.MILLISECONDS);
```

这组初始化代码最值得先理解的是：

- `ManagedChannel`
  - 是客户端到目标服务的一层通信抽象，不是单纯一条连接
- `keepAliveTime / keepAliveTimeout / keepAliveWithoutCalls`
  - 是连接级保活配置，更贴近 channel / transport 层
- `withDeadlineAfter(...)`
  - 是调用级截止时间配置，更贴近 call / `CallOptions`
- `enableRetry()`
  - 表示允许 gRPC runtime 按策略做 retry，但真正的重试规则通常还要配合 service config 等能力

如果把 gRPC 的“配置层”也压成一句话，它不像 Dubbo 那样天然围绕 `application.yml` 把注册中心、协议、治理参数统一声明出来，而更常见的是下面几种方式组合：

1. Java 代码里通过 `ServerBuilder` / `ManagedChannelBuilder` 配置
2. 通过 Spring Boot 配置项映射到 builder
3. 通过 Kubernetes / DNS / service mesh 提供服务发现和路由
4. 通过 service config / xDS / 平台配置补齐 retry、LB 等策略

所以 Dubbo 和 gRPC 在“配置体验”上的一个很大区别是：

- Dubbo 更像“框架主导配置”
- gRPC 更像“通信内核 + builder API + 外围基础设施组合”

所以 gRPC 的主线是：

- 先定义 proto 契约
- 再生成 stub
- 再通过 stub 发起调用

它最值得记住的功能特点有四个。

第一，跨语言友好。

- Java、Go、Python、Node.js 都可以基于同一份 proto 生成代码
- 所以它天然适合多语言微服务体系

第二，强契约。

- 服务名、方法名、请求响应结构都在 proto 里显式定义
- 这让接口协作和协议演进更规范

第三，性能通常不错。

- 默认是 `HTTP/2 + Protobuf`
- 二进制编码更紧凑
- 传输和编解码成本通常比很多 `HTTP/JSON` 更低

第四，支持四种调用模式。

- unary：单请求单响应
- server streaming：单请求多响应
- client streaming：多请求单响应
- bidirectional streaming：双向流

这意味着 gRPC 不只是普通同步 RPC，它还很适合：

- 流式返回
- 批量上传
- 实时双向交互

但 gRPC 的边界也要讲清。

第一，它不是以“治理框架”见长。

- gRPC 很强的是协议、契约、跨语言和流式能力
- 但服务发现、路由、流量治理、配置治理这些能力，往往还要配合外围基础设施一起补齐

第二，它更偏受控内部通信。

- 二进制报文可读性不如 JSON
- 浏览器直接调用也不如 HTTP API 自然
- 对临时调试、抓包分析不如 `HTTP/JSON` 直观

所以 gRPC 最适合的场景通常是：

- 多语言服务协作
- 需要强契约
- 关注高性能和低延迟
- 有流式调用需求

这里还要补一个非常容易混淆的点：

- gRPC 服务端的 `ServerBuilder.addService(...)`
- 并不等于“注册到注册中心”

它真正做的事情是：

- 把服务实现注册到本地 gRPC Server 的方法路由表

也就是让这台 server 知道：

- 收到某个 `service/method` 请求时
- 应该把请求交给哪个本地 handler 去处理

你可以把它理解成：

- `addService(...)` 解决的是“请求已经到这台机器后，怎么路由到本地实现”
- 服务发现解决的是“客户端怎么先找到这台机器”

这两个问题不是一层事。

所以 gRPC 服务端启动时，通常要分开理解两类动作：

第一类：本地服务注册。

- `addService(...)`
- `build().start()`

这一类动作解决的是：

- 监听端口
- 接收请求
- 匹配本地 service / method
- 调用本地实现

第二类：外部服务发现接入。

如果你用了：

- DNS
- Kubernetes Service
- service mesh
- Nacos / Consul / Zookeeper 集成

那服务实例信息的注册和暴露，通常是由这些外围能力或额外启动逻辑完成的，而不是 `addService(...)` 自动完成的。

#### 3.4.3 再往下一层：gRPC 的调用链到底怎么跑，channel、stub、call 分别在干什么

如果只会说“proto + stub + HTTP/2”，gRPC 这一题还是偏浅。更稳的说法是把一次调用链拆出来。

先看客户端最表面的调用代码：

```java
ManagedChannel channel = ManagedChannelBuilder
        .forAddress("127.0.0.1", 9090)
        .usePlaintext()
        .build();

UserServiceGrpc.UserServiceBlockingStub stub =
        UserServiceGrpc.newBlockingStub(channel);

GetUserByIdResponse response = stub.getUserById(
        GetUserByIdRequest.newBuilder().setUserId(1L).build()
);
```

这段代码里最容易混淆的是：

- `stub` 是不是连接
- `channel` 是不是一次调用
- 各种超时、重试、拦截器到底挂在哪里

更准确的理解是：

- `stub`
  - 是面向业务代码的调用入口
  - 负责把某个 proto 方法暴露成 Java 可调用方法
- `channel`
  - 是客户端到目标服务的一层通信抽象
  - 它不是单纯一个 socket，而是承接名字解析、连接管理、负载均衡、传输能力的底座
- `call`
  - 是一次具体 RPC 调用实例
  - 每次 `stub.getUserById(...)` 最终都会创建一个新的 call

所以一次典型 gRPC 调用链，可以压成下面这条：

1. 业务代码调用 stub 方法
2. stub 基于当前 `CallOptions` 创建一次新的 call
3. 调用链依次经过客户端 interceptor
4. channel 负责把这次 call 往下分发
5. 如果目标不是固定单地址，先经过名字解析和负载均衡
6. 选择底层连接或子连接
7. 按 `HTTP/2 + Protobuf` 发起请求
8. 服务端收到后路由到对应的 service / method
9. 服务端执行后返回响应
10. 客户端解码并返回给业务线程

这条链里最值得记住的一点是：

- stub 更像“调用入口”
- channel 更像“通信底座”
- call 才是“这一次具体请求”

#### 3.4.4 gRPC 的 channel 到底是什么，为什么它不是单纯一条连接

很多人第一次看 gRPC 都会把 `ManagedChannel` 理解成：

- “一条 TCP 连接”

这个理解不够准确。更稳的理解是：

- channel 是客户端到某个远程目标服务的一层通信抽象

它通常负责的事情不只是发字节，还包括：

- 名字解析
- 负载均衡
- 建立和复用底层连接
- TLS / 认证
- keepalive
- 把一次次 call 送到底层 transport

所以：

- `channel` 的生命周期通常比较长
- `call` 的生命周期通常比较短

这也是为什么 gRPC 一般建议：

- 复用 channel
- 不要每次调用都临时 new 一个 channel

再进一步讲，channel 背后也不一定只对应一条实际连接。

如果目标服务只有一个地址，可以近似理解成：

- 一个 channel 维护一条主要连接

如果目标服务经过名字解析得到多个地址，那么一个 channel 底下可能还会管理多个底层连接单元，只是这些复杂度对业务代码隐藏了。

所以最短记忆可以压成：

- `channel` 是通信抽象，不是一次调用
- `channel` 通常复用长连接，但不等于永远只有一条底层连接

#### 3.4.5 deadline、keepalive、retry 分别挂在调用链的哪个环节

这一块如果讲不清，gRPC 的工程理解就不算完整。最稳的方式是先把三者按层级拆开：

- `deadline`
  - 调用级
  - 定义“这次 RPC 最多等多久”
- `keepalive`
  - 连接级
  - 定义“这条连接是不是还活着、还能不能继续复用”
- `retry`
  - 调用 attempt 级
  - 定义“一次调用失败后要不要再发起新的尝试”

你可以先把它们放进这条更细的链里：

- `stub -> CallOptions -> interceptor -> channel -> 负载均衡/连接管理 -> HTTP/2 transport`

其中：

- `deadline`
  - 更靠近 `stub / call / CallOptions`
- `keepalive`
  - 更靠近 `channel / transport`
- `retry`
  - 更靠近 call 执行框架，由 channel/runtime 按策略决定要不要重新发起 attempt

##### 3.4.5.1 deadline：为什么它是调用级，而不是连接级

`deadline` 的核心语义不是：

- “连接多久超时”

而是：

- “这次 RPC 到某个截止时间之前必须结束”

它通常通过 `CallOptions` 挂到本次调用上。常见写法是：

```java
UserServiceGrpc.UserServiceBlockingStub stub =
        UserServiceGrpc.newBlockingStub(channel)
                .withDeadlineAfter(200, TimeUnit.MILLISECONDS);
```

这里的意思是：

- 对这次调用设置一个 200ms 的截止时间

所以 deadline 更接近：

- 业务调用预算

而不是：

- 通道级连接属性

需要特别注意的一点是：你也可以在客户端 interceptor 里看到 `CallOptions`。这时候很容易误以为：

- “我把 interceptor 挂在 channel 上，所以 deadline 是配在 channel 上的”

更准确的说法应该是：

- interceptor 的挂载点在 channel
- 但它拦截的是经过这个 channel 的每一次 call
- `CallOptions` 仍然属于单次调用级别

也就是说：

- channel 上可以挂统一策略
- 但 deadline 生效的粒度仍然是 call

如果 interceptor 这么写：

```java
return next.newCall(method, callOptions.withDeadlineAfter(duration, timeUnit));
```

那它的语义不是“给 channel 配了 deadline”，而是：

- 对所有经过该 channel 的调用统一重写 deadline

这类写法更像：

- 统一超时策略注入

而不是：

- channel 固有属性

##### 3.4.5.2 keepalive：为什么它更接近连接级

`keepalive` 解决的问题不是某个方法调多久，而是：

- 底层长连接是不是还活着
- 空闲连接有没有被中间网络设备掐掉
- 下一个业务请求会不会踩到一条死连接

所以它通常挂在：

- `ManagedChannelBuilder`
- 底层 transport / HTTP/2 连接管理

常见写法像这样：

```java
ManagedChannel channel = ManagedChannelBuilder
        .forAddress("127.0.0.1", 9090)
        .usePlaintext()
        .keepAliveTime(30, TimeUnit.SECONDS)
        .keepAliveTimeout(10, TimeUnit.SECONDS)
        .keepAliveWithoutCalls(true)
        .build();
```

这里的含义是：

- 多久没数据就发一次 ping
- ping 发出去多久收不到响应就认为连接异常
- 即使当前没有活跃调用，也要不要继续做保活

所以 keepalive 的核心心智模型是：

- 它服务的是长连接复用
- 不是替代 deadline，也不是替代 retry

##### 3.4.5.3 retry：为什么它更接近“新的调用尝试”

`retry` 最容易被理解错成：

- “失败后在原地多等一会儿”

更准确的理解是：

- 一次 RPC 失败后，是否要重新发起一次新的 attempt

所以 retry 的本质是：

- 调用级补救策略

它通常依赖：

- 哪些错误码允许重试
- 最多重试几次
- 两次之间的 backoff
- 当前 deadline 是否还剩预算

在实现位置上，它更接近：

- channel/runtime 对 call 的执行控制

而不是：

- 单纯 transport 层

要特别强调的是：

- retry 只适合可安全重试的调用
- 如果写操作不是幂等的，重试就可能放大副作用

所以这三者的关系一定不要讲混：

- `deadline`
  - 给一次调用划失败边界
- `retry`
  - 在边界内做有限补救
- `keepalive`
  - 保证底层连接尽可能健康、可复用

#### 3.4.6 把 gRPC 的四种调用模式也放回这条链里理解

gRPC 不只是普通同步 RPC，它支持四种调用模式：

- unary：单请求单响应
- server streaming：单请求多响应
- client streaming：多请求单响应
- bidirectional streaming：双向流

最简单也最常见的是 unary，也就是最像普通同步 RPC 的模式。

server streaming 适合：

- 大结果集分批返回
- 订阅和实时推送

client streaming 适合：

- 文件分片上传
- 批量上报

bidirectional streaming 适合：

- 实时双向消息交互
- 长连接会话式通信

这里最值得补的一层理解是：

- 调用模式一旦从 unary 进入 streaming，连接占用、背压、流控、资源回收的复杂度都会明显上升

所以工程上不要因为 gRPC 支持 streaming，就默认所有场景都该用 streaming。

#### 3.4.7 用一句话把 Dubbo 和 gRPC 的差异重新压缩出来

如果只保留最重要的一层差异，可以这样说：

- Dubbo 更像 Java 内部服务治理型 RPC 框架，强项是接口化体验和调用层治理
- gRPC 更像契约优先、跨语言友好的通信体系，强项是 proto、HTTP/2、Protobuf、channel 抽象和 streaming 能力

#### 3.4.8 这一段最适合怎么记

如果你后面复习时只想记一张心智图，可以这样压缩：

- Dubbo
  - 接口优先
  - Java 主导
  - 治理强
- gRPC
  - proto 优先
  - 跨语言
  - `HTTP/2 + Protobuf`
  - channel 复用长连接
  - `deadline` 挂 call
  - `keepalive` 挂 transport
  - `retry` 挂 attempt 策略
- Spring Cloud
  - 微服务基础设施生态

#### 3.4.9 Spring Cloud 放在这里该怎么理解

Spring Cloud 最容易被答偏，因为它不该和 Dubbo、gRPC 用同一把尺子比较。

它更准确的定位是：

- 微服务基础设施生态

服务间调用只是其中一部分，常见组合通常是：

- DiscoveryClient / 注册发现
- OpenFeign 或 WebClient
- Spring Cloud LoadBalancer
- CircuitBreaker
- Gateway
- Config

所以 Spring Cloud 这一题最稳的说法不是：

- “它也是一个 RPC 框架”

而是：

- “它提供的是一整套 Spring 微服务基础设施，调用协议往往还是 HTTP 风格，重点在生态协同，而不只是 RPC 通信本身”

#### 3.4.10 把 Dubbo 和 gRPC 放在一张图里对比

如果只看最核心的差异，可以按下面几组维度记忆。

第一组：服务定义方式。

- Dubbo：更偏接口优先，Java 团队通常先写接口
- gRPC：更偏 IDL 优先，先写 `.proto`

第二组：语言栈。

- Dubbo：传统上更适合 Java 主导场景
- gRPC：天然更适合跨语言场景

第三组：主标签。

- Dubbo：RPC + 服务治理
- gRPC：契约 + 通信协议 + 跨语言

第四组：协议和传输。

- Dubbo：可支持多种协议与序列化组合，传统内部调用经常更偏自定义 RPC 协议
- gRPC：默认就是 `HTTP/2 + Protobuf`

第五组：调用模式。

- Dubbo：典型强项是普通同步服务调用和治理
- gRPC：除了普通 unary，还天然支持 streaming

第六组：排障和运维心智。

- Dubbo：要重点理解注册中心、路由、超时、重试、治理配置
- gRPC：要重点理解 proto 契约、stub、流式调用、协议兼容

#### 3.4.11 选型时到底怎么判断

真正的选型逻辑，不应该是背“谁更好”，而是先问下面这些问题：

1. 服务主要是 Java 内部调用，还是多语言协作？
2. 更重视 RPC 层治理，还是更重视契约统一和跨语言？
3. 是否需要 streaming？
4. 团队当前的技术栈和排障经验在哪边更强？
5. 能不能接受对应体系带来的工程复杂度？

更实用的结论通常是：

- 如果主体是 Java 内部服务，调用频繁，治理要求强，优先考虑 Dubbo
- 如果是多语言协作、协议契约要求强、需要 streaming，优先考虑 gRPC
- 如果团队整体深度绑定 Spring 微服务生态，而且更看重配置中心、网关、服务发现、熔断这些一体化基础设施，Spring Cloud 会更自然

把这一节压成最短回答，就是：

- Dubbo 更像 Java 内部服务治理型 RPC 框架，强项是接口化体验和调用层治理；gRPC 更像契约优先、跨语言友好的 RPC 体系，强项是 proto、HTTP/2、Protobuf 和流式调用；Spring Cloud 更像微服务基础设施生态，不应和前两者简单当成同类协议框架比较。

## 4. 边界、误区、常见追问

- 不要把 RPC 讲成“就是远程调接口”，重点一定要补网络不确定性和治理问题。
- 远程调用主流程不要只答成“代理 + 注册中心 + 负载均衡”，继续讲清序列化、网络传输、服务端执行、结果返回这几个环节。
- 治理能力不是越多越好，重试、超时、熔断、降级要结合幂等性、流量和时延目标一起看。
- 不要把 Dubbo、Spring Cloud、gRPC 都粗暴叫成“RPC 框架”，Spring Cloud 更准确的定位是微服务基础设施生态。
- Spring Cloud 的服务调用很多时候要结合 OpenFeign、LoadBalancer、CircuitBreaker 等一起理解，不要把它答成一个单独协议。
- gRPC 的优势不要只答“快”，还要补“强契约、跨语言、HTTP/2、流式能力”。
- Dubbo 的优势不要只答“Java 用得多”，还要补“服务治理贴近调用层”。
- 选型题不要只背对比表，先讲场景，再讲取舍。

## 5. 自测清单

- 你能不能先不背术语，直接讲为什么服务拆分后必须把远程调用和本地调用分开看。
- 你能不能按“代理 -> 发现 -> 负载均衡 -> 编码传输 -> 服务端执行 -> 结果返回”讲清一次 RPC 调用。
- 你能不能解释为什么超时、重试、熔断、降级必须放回治理主线里一起讲。
- 你能不能说明 Dubbo、Spring Cloud、gRPC 为什么不是一个层面的东西。
- 你能不能按“调用模型、治理生态、语言栈、协议效率”四个维度比较三者。
- 你能不能用 2 分钟把“Dubbo / Spring Cloud / gRPC 的异同和选型逻辑”讲顺。
