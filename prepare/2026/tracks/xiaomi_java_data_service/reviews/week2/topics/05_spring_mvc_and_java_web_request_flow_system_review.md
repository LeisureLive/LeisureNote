# Week2 Spring MVC 与 Java Web 请求处理主线专题系统复习

对应计划：

- `prepare/2026/tracks/xiaomi_java_data_service/01_1month_plan.md`
- `prepare/2026/tracks/xiaomi_java_data_service/00_high_frequency_knowledge_map.md`

## 1. 这一块在解决什么问题

Spring MVC / Java Web 这块不是在考你背多少接口名，而是在考你能不能把下面五件事讲清楚：

1. 一个 HTTP 请求进入服务端后，为什么要先经过 Servlet 容器，而不是直接进 Controller。
2. 早期 Java Web 为什么总是依赖 Tomcat / Jetty 这类容器，而现在很多 Spring 应用却可以直接 `java -jar` 启动。
3. Spring MVC 为什么能在 Servlet 体系之上，把请求分发、参数绑定、返回值处理、异常处理统一起来。
4. `DispatcherServlet`、`HandlerMapping`、`HandlerAdapter`、Controller 在整条请求链里分别解决什么问题。
5. Filter、Interceptor、AOP 分别拦在哪一层，各自有哪些限制，适合做什么，不适合做什么。

把这些点串起来，主线其实很稳定：

- Web 应用先要有一个能监听端口、接收 HTTP 请求、创建 Servlet 请求对象的基础运行环境。
- 在 Servlet 体系里，请求先进入容器和 Filter 链，再进入作为前端控制器的 `DispatcherServlet`。
- `DispatcherServlet` 不直接写死控制器调用逻辑，而是把“找谁处理、怎么调用、怎么处理返回结果”拆成一组可扩展策略。
- 正因为请求被统一收口，参数解析、数据绑定、消息转换、异常处理、视图解析才能挂在同一条链路上。
- 而横切能力之所以总被放在一起问，是因为 Filter、Interceptor、AOP 虽然都能“拦”，但它们拦截的位置、能力边界和适用场景完全不同。

所以这块真正要建立的是三种能力：

- 能把“外部容器部署”和“Spring Boot 内嵌容器 + 可执行 Jar”这一层说清楚。
- 能把 Spring MVC 从请求进入到响应返回的主流程讲清楚，不停留在几个组件名的背诵层。
- 能把 Filter、Interceptor、AOP 的分工、限制和适用场景讲成一套有层级的判断框架。

## 2. 先把主线串起来，再看知识树

### 2.1 先用一条因果链把全文串起来

如果你觉得 Spring MVC 容易散，通常不是组件名没记住，而是没有先抓住下面这条主线：

1. 先看为什么 Web 请求一定先进入容器：因为总得有东西负责监听端口、解析协议、创建 `HttpServletRequest` / `HttpServletResponse`。
2. 再看为什么现在很多 Spring 应用能 `java -jar`：不是因为不需要容器了，而是因为容器被内嵌进应用进程里了。
3. 再看 Spring MVC 为什么能接住请求：因为它把 `DispatcherServlet` 挂在 Servlet 入口上，作为统一前端控制器。
4. 再看请求进入 `DispatcherServlet` 后如何被处理：先找处理器，再找适配器，再做参数解析、控制器调用、返回值处理和异常兜底。
5. 最后看 Filter、Interceptor、AOP 为什么总被一起问：它们都在做横切，但分别站在 Servlet 容器层、Spring MVC 层和 Spring Bean 方法层。

所以这篇文档不是在讲几个并列概念，而是在回答一条连续问题链：

- 请求先到哪里。
- 为什么 `java -jar` 也能跑 Web 应用。
- Spring MVC 怎么接住请求。
- 请求怎么一路走到 Controller 方法。
- 参数、返回值、异常为什么能统一治理。
- Filter、Interceptor、AOP 怎么分工。

### 2.2 知识树

- Java Web 基础入口
  - Servlet 容器
  - Servlet 规范
  - Request / Response
- Web 应用启动形态
  - 传统外部容器部署
  - Spring Boot 内嵌容器
  - 可执行 Jar 启动链路
- Spring MVC 请求主线
  - `DispatcherServlet`
  - `HandlerMapping`
  - `HandlerExecutionChain`
  - `HandlerAdapter`
  - Controller
- Controller 调用前后扩展点
  - 参数解析
  - 数据绑定与类型转换
  - 校验
  - 返回值处理
  - 视图解析 / JSON 序列化
  - 异常解析
- 三类横切能力
  - Filter
  - Interceptor
  - AOP

## 3. 核心重点展开

### 3.1 早期 Web 应用为什么依赖 Tomcat / Jetty，为什么现在很多 Spring 应用又能直接 `java -jar` 启动

这一节在回答什么问题：

- Web 应用为什么天然离不开容器。
- Spring 应用为什么看起来不依赖外部 Tomcat，却仍然能处理 HTTP 请求。

这个问题是怎么解决的：

先把最关键的一句话记住：

- Spring MVC 从来不是绕开 Servlet 容器独立处理 HTTP 请求的。
- `java -jar` 能启动 Web 应用，不是因为不需要 Tomcat / Jetty 了，而是因为容器被嵌入到应用本身里了。

早期 Java Web 的典型形态是：

- 你把应用打成 `war`
- 部署到外部 Tomcat / Jetty
- 容器负责监听端口、接收请求、管理 Servlet 生命周期
- 你的应用只是运行在这个容器里的一个 Web 应用

这种模式下，容器和业务应用是分离的：

- 容器先启动
- 再把你的应用加载进去

Spring MVC 本身就建立在这套体系上。`DispatcherServlet` 本质上也是一个 Servlet，请求必须先进入 Servlet 容器，才能再进入 Spring MVC。也就是说，Spring MVC 解决的是“请求怎么优雅分发到 Controller 方法”，不是“怎么直接从 socket 收 HTTP 包”。

那为什么现在很多 Spring 应用又可以直接 `java -jar`？核心原因是 Spring Boot 把两件事一起做了：

1. 把 Web 容器作为依赖打进应用里。
2. 把应用打成可执行 Jar，并在启动时把这个内嵌容器拉起来。

对 Servlet 栈应用来说，Spring Boot 官方文档说明：

- `spring-boot-starter-web` 默认会带上内嵌 Tomcat
- 也可以切换成 Jetty 或 Undertow
- Spring Boot 在底层使用 `ServletWebServerApplicationContext`，它会查找一个 `ServletWebServerFactory` Bean，通常是自动配置好的 `TomcatServletWebServerFactory` 或 `JettyServletWebServerFactory`

所以启动链路不再是“外部 Tomcat 先起，再部署应用”，而是：

1. 执行 `java -jar app.jar`
2. Spring Boot 可执行 Jar 的 `Launcher` 作为 `Main-Class` 启动，加载 `BOOT-INF/classes` 和 `BOOT-INF/lib` 里的内容
3. 调用你的 `Start-Class`，也就是应用自己的 `main()` 方法
4. `SpringApplication.run(...)` 启动 Spring 容器
5. 对于 Web 应用，Spring Boot 创建 `ServletWebServerApplicationContext`
6. 它找到内嵌容器工厂，创建并启动 Tomcat / Jetty / Undertow
7. 容器启动后，`DispatcherServlet`、Filter、Listener 等再被注册进这个内嵌容器
8. 之后请求处理流程和传统 Servlet Web 应用本质上就一致了

所以 `java -jar` 模式真正改变的是“部署和启动方式”，不是“Web 基础运行模型”。

把这件事压成一句面试回答，就是：

- 传统 Spring MVC Web 应用通常把 `war` 部署到外部 Tomcat；Spring Boot Web 应用则把容器内嵌到进程里，再通过可执行 Jar 启动它。
- 它并不是不要 Servlet 容器，而是把“容器部署在外部”变成了“容器随应用一起启动”。

这一节真正要讲清的，不是 `java -jar` 这个命令本身，而是三层角色分工：

- Spring Boot 解决启动和装配问题。
- 内嵌 Tomcat / Jetty 解决 Web 容器问题。
- Spring MVC 解决请求分发和控制器调用问题。

如果把这三层混成一句“Spring 可以直接启动 Web 应用”，面试官一追问就容易散。

### 3.2 Spring MVC 请求主流程为什么能把 HTTP 请求稳定分发到 Controller 方法

这一节在回答什么问题：

- `DispatcherServlet` 到底在整条链路里做了什么。
- 请求为什么能从 URL 一路稳定走到某个 Controller 方法，而不是靠手写 `if-else`。

这个问题是怎么解决的：

Spring MVC 主流程的关键不是某一个类，而是一条标准化请求链：

- 容器和 Filter 先把请求接住
- `DispatcherServlet` 再把“找处理器、调用处理器、处理结果”统一收口
- 各类策略组件负责链路里不同阶段的工作

先把请求进入服务端后的大图景建起来：

1. 浏览器或客户端发起 HTTP 请求。
2. Tomcat / Jetty 这类 Servlet 容器监听端口并接收请求。
3. 请求先经过 Servlet Filter 链。
4. 请求被分发给 `DispatcherServlet`。
5. `DispatcherServlet` 调用 `HandlerMapping` 找到当前请求应该交给谁处理。
6. 找到的不是单独一个 Controller 方法，而是一个 `HandlerExecutionChain`：
   - 里面包含 handler 本身
   - 也包含这次请求命中的 `HandlerInterceptor`
7. `DispatcherServlet` 再找一个能调用这个 handler 的 `HandlerAdapter`。
8. `HandlerAdapter` 负责真正完成参数解析、方法调用、返回值处理。
9. 如果是视图返回，后面还会走 `ViewResolver`；如果是 `@ResponseBody` / `ResponseEntity`，通常会直接通过消息转换器写回响应。
10. 如果中间抛异常，`HandlerExceptionResolver` 会尝试把异常转成统一响应。
11. 请求结束后，再回调拦截器的收尾逻辑。

这里面最容易被问散的 3 个组件是：

- `DispatcherServlet`
  - 前端控制器，负责统一收口整条 Web 请求链
- `HandlerMapping`
  - 负责回答“这个请求应该交给哪个 handler”
- `HandlerAdapter`
  - 负责回答“找到 handler 之后，具体该怎么调用它”

`HandlerAdapter` 这层特别重要，因为它解释了 Spring MVC 为什么不用把调用逻辑写死在 `DispatcherServlet` 里。

如果没有 `HandlerAdapter`，`DispatcherServlet` 就得自己知道：

- 这是注解控制器该怎么调
- 那是旧式 `Controller` 接口该怎么调
- 另一个自定义 handler 该怎么调

这样前端控制器就会越来越臃肿。Spring MVC 把“怎么调”抽成适配器之后，`DispatcherServlet` 只需要做两件事：

- 找到 handler
- 找到支持这个 handler 的 adapter

这就是典型的“分发”和“执行”解耦。

如果你要把主流程讲得更像面试答案，可以按下面顺序说：

1. 请求先到 Servlet 容器，再进入 Filter 链。
2. `DispatcherServlet` 作为前端控制器接管请求。
3. `HandlerMapping` 负责根据 URL、HTTP 方法等信息找到处理器。
4. 找到的结果会包装成 `HandlerExecutionChain`，把拦截器也带上。
5. `HandlerAdapter` 负责以统一方式调用目标 Controller 方法。
6. 在调用过程中完成参数解析、数据绑定、校验。
7. 返回结果后，继续做视图解析或 JSON 序列化。
8. 抛异常则交给异常解析器统一兜底。

这一节真正要讲清的是：

- Spring MVC 的核心设计不是“有个 `DispatcherServlet` 就完了”
- 而是通过前端控制器 + 映射器 + 适配器 + 执行链，把请求处理标准化了

这样后面参数绑定、返回值处理、异常治理才有统一挂点。

### 3.3 参数绑定、返回值处理、异常处理为什么都能挂在同一条请求链路上

这一节在回答什么问题：

- 为什么 Spring MVC 不只是“根据 URL 找到方法”这么简单。
- 为什么它能把参数解析、JSON 转换、异常兜底、校验这些能力统一治理。

这个问题是怎么解决的：

Spring MVC 真正强的地方，不在于“路由到 Controller 方法”，而在于：它把 Controller 方法调用前后的通用工作都框进了一套固定执行模型里。

也就是说，Controller 方法的执行不是裸调用，而是大致遵循这样一条模型：

- 先准备参数
- 再调用方法
- 再处理返回值
- 如果报错，再走异常解析

这条模型之所以能成立，核心在 `RequestMappingHandlerAdapter` 这一层。它不是简单反射调用方法，而是围绕“方法参数”和“返回值”各维护了一组策略。

可以把它拆成四类能力来看。

1. 参数解析：方法参数为什么能自动拿到值

Controller 方法里经常会出现很多不同来源的参数：

- `@PathVariable`
- `@RequestParam`
- `@RequestHeader`
- `@CookieValue`
- `@RequestBody`
- `HttpServletRequest`
- `Model`
- `Principal`

Spring MVC 之所以能自动把这些值塞进方法参数，是因为它不是按“参数位置”硬编码，而是按“参数类型 + 注解语义”去找对应的 `HandlerMethodArgumentResolver`。

这层设计解决的是：

- 控制器方法不必自己手工从 request 里取值
- 参数来源和业务逻辑分离
- 新参数类型也可以通过扩展解析器接入

所以 `@RequestBody UserCreateReq req` 能生效，不是因为 Controller 有魔法，而是因为参数解析器识别到：

- 这个参数需要从请求体读取
- 再交给 `HttpMessageConverter` 做反序列化

2. 数据绑定、类型转换、校验：为什么字符串请求参数能变成复杂 Java 对象

光有参数来源还不够，请求里的数据大多是字符串，但方法参数可能是：

- `Long`
- `LocalDateTime`
- 枚举
- 复杂表单对象

Spring MVC 在参数绑定阶段还会结合：

- `WebDataBinder`
- 类型转换器 / 格式化器
- 校验器

把原始请求数据转成你方法里真正声明的 Java 类型。

所以这层解决的是：

- 参数不只是“拿到”，还要“转成正确类型”
- 转换失败、校验失败要能进入统一错误处理链

这也是为什么 `@Valid` / `@Validated`、类型转换异常、绑定异常这些问题，本质上都属于“Controller 方法真正执行前的准备阶段”。

3. 返回值处理：为什么同一个 Controller 方法既可以返回视图名，也可以返回 JSON

Spring MVC 不要求所有 Controller 只能返回一种类型，是因为返回值处理同样被抽成了一组 `HandlerMethodReturnValueHandler`。

这层大致会做两类分流：

- 视图分支
  - 返回 `String`、`ModelAndView` 等，通常走视图解析
- 响应体分支
  - 返回对象且方法带 `@ResponseBody`，或者类是 `@RestController`
  - 这时通常走消息转换器，把对象序列化成 JSON / XML 等内容直接写回响应

所以你需要把下面这件事讲清：

- “返回对象就自动变成 JSON”不是 Controller 自己做的
- 而是返回值处理器识别出这是响应体语义，再调用消息转换器写回 HTTP 响应

这也是为什么 `@RestController` 能极大简化接口开发：

- 它本质上是在告诉 Spring MVC：这个 Controller 大部分返回值都按响应体处理，而不是按视图名处理

4. 异常处理：为什么异常能统一转成错误响应，而不是每个方法都写 `try-catch`

请求处理过程中，异常可能来自：

- 参数绑定失败
- 校验失败
- 业务逻辑抛错
- 底层系统异常

Spring MVC 不希望每个 Controller 方法都手工 `try-catch`，所以它在主流程后面放了 `HandlerExceptionResolver` 体系，用来把异常转成统一响应。

常见落点包括：

- `@ExceptionHandler`
- `@ControllerAdvice`
- 默认异常解析器

这层设计解决的是：

- 错误处理从业务方法里抽离
- 响应格式统一
- Web 层异常语义更稳定

所以这一节真正要讲清的是：

- Spring MVC 之所以“看起来很智能”，不是因为 Controller 方法有魔法
- 而是因为在 Controller 前后，Spring MVC 预埋了一整套参数解析、绑定转换、返回值处理、异常解析的统一扩展链

只要这条链讲顺了，`@PathVariable`、`@RequestBody`、`@RestController`、`@ControllerAdvice` 这些碎知识点就能自然挂回主线，而不是散着背。

### 3.4 Filter 和 Interceptor 区别有哪些，各自有哪些限制，适用于哪些场景

这一节在回答什么问题：

- Filter 和 Interceptor 到底分别拦在哪一层。
- 它们各自能做什么、不能做什么，为什么不能互相完全替代。

这个问题是怎么解决的：

先给一个最重要的判断框架：

- Filter 站在 Servlet 容器层。
- Interceptor 站在 Spring MVC 层。
- AOP 站在 Spring Bean 方法调用层。

这三者不是“功能谁更强”的关系，而是“作用位置不同，所以适合解决的问题不同”。

如果只比较 Filter 和 Interceptor，可以先按下面 6 个维度理解。

1. 所属层级不同

- Filter
  - 属于 Servlet 规范能力，核心接口是 `jakarta.servlet.Filter`
  - 请求进入 Spring MVC 之前就能拦到
- Interceptor
  - 属于 Spring MVC 能力，核心接口是 `HandlerInterceptor`
  - 发生在 `DispatcherServlet` 已经接住请求之后，且通常要在选出 handler 的语义里工作

这一点决定了它们最大的边界差异：

- Filter 更靠前，更接近容器
- Interceptor 更靠后，更接近 Controller

2. 拦截范围不同

- Filter
  - 理论上能覆盖进入当前 Servlet 容器链路的请求
  - 包括一些不一定最终命中 Spring MVC Controller 的请求
  - 更适合放容器级、协议级、通用级处理
- Interceptor
  - 主要针对进入 Spring MVC 处理链、并被 `HandlerMapping` 选中的 handler
  - 更适合做控制器语义明确的处理

所以如果你的需求是：

- “只对 Controller 层请求做点事”
  - Interceptor 往往更自然
- “请求一进 Web 应用就要先处理”
  - Filter 往往更合适

3. 能拿到的信息不同

- Filter
  - 主要面对 `ServletRequest` / `ServletResponse`
  - 它并不知道后面会落到哪个 Controller 方法
- Interceptor
  - 除了 `HttpServletRequest` / `HttpServletResponse`，还可以拿到 handler
  - 也就是它更知道“这次具体会调用哪个处理器”

所以如果你要做：

- 基于 handler 的鉴权、接口审计、接口级埋点
  - Interceptor 更方便
- 基于原始请求做包装、解码、统一预处理
  - Filter 更合适

4. 对 request / response 的控制能力不同

- Filter
  - 可以包装 request / response
  - 比如自定义 `HttpServletRequestWrapper`、缓存请求体、统一加 header、做编码/CORS/转发头处理
- Interceptor
  - 更偏“前后回调”
  - 不适合做底层 request / response 包装替换

这点特别重要，因为它解释了为什么很多通用 Web 基础设施能力天然更适合 Filter。

比如：

- 字符编码
- CORS
- 请求体包装
- traceId 注入
- forwarded headers 处理

这些通常更适合放 Filter，而不是 Interceptor。

5. 生命周期和回调点不同

- Filter
  - 在 Filter 链里围绕整个后续处理过程执行
  - 更像“容器级 before / after”
- Interceptor
  - 常见回调有：
    - `preHandle`
    - `postHandle`
    - `afterCompletion`
  - 它围绕的是 Spring MVC handler 执行链，而不是整个 Servlet 容器链

这里有一个很容易忽略的限制，Spring 官方文档明确提到：

- 对于 `@ResponseBody` 和 `ResponseEntity` 这类响应体方法，响应通常会在 `HandlerAdapter` 内部写出并提交
- 这意味着到了 `postHandle` 阶段，很多时候已经太晚，不能再指望修改响应体或额外加 header

所以如果你的需求是：

- “Controller 执行前做校验，执行后做日志”
  - Interceptor 很合适
- “想在响应真正写出前后统一包装底层响应”
  - 不能简单指望 `postHandle`
  - 这类需求常常更适合 Filter，或者 Spring MVC 的 `ResponseBodyAdvice`

6. 适用边界和限制不同

Filter 的限制：

- 它站在更底层，看不到明确的 Controller 语义
- 直接拿不到 handler 方法信息
- 代码容易偏“协议层 / 容器层”，如果把太多业务判断塞进去，会让 Filter 变脏

Interceptor 的限制：

- 它不是安全链的最佳承载层
- Spring 官方文档明确提醒：Interceptor 不太适合作为安全层，因为它和注解控制器路径匹配之间可能存在不一致，推荐尽量把安全控制放在更早的 Servlet filter chain，比如 Spring Security
- 它也不适合做 request / response 包装替换
- 它主要面向 Spring MVC 请求，不应该被误用成“所有 Web 横切问题的统一入口”

把它们压成一句话就是：

- Filter 适合做“更早、更通用、更底层”的 Web 处理。
- Interceptor 适合做“更靠近 Controller、更有 Spring MVC 语义”的处理。

如果放回常见场景，可以这样记：

更适合用 Filter 的场景：

- 字符编码处理
- CORS
- traceId 注入
- 请求/响应包装
- forwarded headers 处理
- 安全过滤链入口
- 非常靠前的统一日志/监控

更适合用 Interceptor 的场景：

- 登录态校验或接口权限校验的 MVC 层补充逻辑
- 基于 handler 的审计日志
- 统计某类 Controller 的执行耗时
- 多租户上下文准备
- locale、主题、接口级幂等 token 检查

这道题真正要建立的不是“定义列表”，而是一种层级判断能力：

- 先判断这个需求是容器层问题，还是 MVC 层问题
- 再决定放 Filter 还是 Interceptor

如果你能先把这一层级感讲出来，后面再补适用场景和限制，这题就会比只背定义稳很多。

## 4. 边界、误区、常见追问

- 不要把“Spring 应用可以 `java -jar` 启动”答成“Spring 不需要 Web 容器”，更准确的说法是“Spring Boot 把容器内嵌进应用里了”。
- 不要把 Spring MVC 主流程只背成 `DispatcherServlet -> HandlerMapping -> HandlerAdapter -> Controller`，要继续讲清参数解析、返回值处理、异常解析为什么能统一接上。
- `DispatcherServlet` 是前端控制器，但它不是孤立组件，它真正的价值在于把映射、适配、异常、视图等策略统一起来。
- 不要把 Filter 和 Interceptor 讲成“差不多，都是拦截请求”，重点是 Servlet 容器层和 Spring MVC 层的边界。
- Interceptor 不适合作为安全层的主承载点；安全通常更应该放在更早的 Filter 链，比如 Spring Security。
- 对 `@ResponseBody` / `ResponseEntity` 场景，不要误以为 `postHandle` 一定还能改响应体，很多时候响应已经提交了。
- Filter 能做 request / response 包装，Interceptor 通常不适合承担这类底层包装职责。

## 5. 自测清单

- 你能不能先不背组件名，直接讲清为什么 Spring MVC 仍然建立在 Servlet 容器之上。
- 你能不能解释为什么很多 Spring Boot Web 应用可以 `java -jar` 启动，但本质上仍然在用 Tomcat / Jetty 这类容器。
- 你能不能按“容器 -> Filter -> DispatcherServlet -> HandlerMapping -> HandlerAdapter -> Controller -> 返回值/异常处理”把主流程讲顺。
- 你能不能说明 `HandlerAdapter` 为什么存在，而不是让 `DispatcherServlet` 直接调用所有处理器。
- 你能不能解释参数绑定、消息转换、异常处理为什么都能挂在同一条调用链上。
- 你能不能系统区分 Filter 和 Interceptor 的层级、限制和适用场景。
- 你能不能用 2 分钟把“Spring MVC 请求是怎么处理的”讲顺。
