## 一、概念

Spring是一个开源的、功能强大的一站式Java开发框架，核心是IOC和AOP

- **IOC**：组件之间的解耦（由强依赖降为弱依赖）
- **AOP**：切面编程可以将应用业务做统一或特定的功能增强，能实现应用业务与增强逻辑的解耦



## 二、IOC

### 1、概念

即控制反转，将创建对象控制权交给IOC容器统一管理，

**好处**

- 组件之间的解耦
- 解决对象之间的依赖关系
- 托管对象的大部分生命周期



### 2、IOC实现方式

- 依赖查找：主动搜索，通过BeanFactory/ApplicationContext getBean获取指定组件
  - getBean 、ofType
  - <u>getBeanProvider延迟查找，先获取 `ObjectProvider` 后获取实际的对象，如果不存在可使用缺省值代替</u>
- 依赖注入：被动接收，通过@Autowire  <Property>注解等接收组件
  - 通过xml配置文件
  - 通过注解<u>(`ObjectProvider` 修饰的属性可以实现组件延迟注入)</u>
  - <u>Aware系列接口实现回调注入</u> 可以获取ApplicationContext BeanName等



### 3、依赖注入方式、注解对比

![image-20210516141225845](/Users/bjhl/Library/Application Support/typora-user-images/image-20210516141225845.png)

![image-20210516141243620](/Users/bjhl/Library/Application Support/typora-user-images/image-20210516141243620.png)

1. @Autowire先查找指定类型的Bean，有多个再比对Bean名称
2. 多个相同类型的Bean可以用集合来一次全部接收



### 4、IOC容器相关

#### **概念**

- BeanFactory接口提供抽象的配置和对象管理机制
- ApplicationContext是BeanFactoty的子接口，扩展BeanFactory提供了简化的实现，并扩展了AOP、BeanDefinition等功能

#### **Enviroment**

- 包含了properties和profile信息，用于配置的统一管理

#### **BeanDefinitionRegistry**

- BeanDefinition的注册表，维护的是BeanDefinition，而BeanFactory维护的是Bean

#### **后置处理器对比**

- **BeanFactoryPostProcessor** 容器的扩展点，作用于容器的生命周期。所有的BeanDefinition加载到BeanFactory后起作用，用于访问/修改已有的Bean定义
- **BeanDefinitionRegistryPostProcessor**也是容器的扩展点，作用于容器的生命周期。所有的BeanDefinition准备好即将加载到BeanFactory时触发，用于新增Bean定义
- **BeanPostProcessor** 作用于Bean的生命周期。在Bean已经创建还未初始化阶段，用于给Bean属性赋值、创建代理对象



### 5、Bean相关

#### 类型

- 分为普通Bean和工厂Bean，工厂Bean实现了FactoryBean接口，实际起作用的是FactoryBean工厂创建的对象

#### 作用域

- 默认是singleton，一个IOC容器中只有一个
- prototype，每次获取创建一个
- request，每次web请求创建一个
- session，一个会话创建一个
- application，一个web应用创建一个

#### 实例化方式

- @Bean @Component <bean> 方式注册bean后实例化
- 借助FactoryBean实例化
- 配置文件 静态工厂方法指定factory-method 实例工厂方法指定factory-bean 和 factory-method
- 借助 `InstantiationAwareBeanPostProcessor` 实例化 bean （该法比较特殊，它实际上是拦截原有 bean 的创建流程而已）

#### Bean生命周期中初始化/销毁控制

![image-20210516153509051](/Users/bjhl/Library/Application Support/typora-user-images/image-20210516153509051.png)

#### BeanDefinition理解

- 描述了Bean的元信息，包含了Bean类型、属性、依赖关系、配置信息
- 可以在 IOC 容器初始化阶段被 BeanDefinitionRegistryPostProcessor 构造和注册，被 BeanFactoryPostProcessor 拦截修改等
- 抽取成一个统一的格式，是为了后续对bean的统一管理

#### BeanPostProcessor

- InstantiationAwareBeanPostProcessor ：作用于 bean 对象的实例化前后，以及属性赋值阶段
- MergedBeanDefinitionPostProcessor ：作用于 BeanDefinition 的合并阶段，借助它可以完成层级 bean 的定义信息汇总
  - 如 AutowiredAnnotationBeanPostProcessor 会收集 bean 所属类及 bean 所属类的父类中的自动注入信息
- DestructionAwareBeanPostProcessor ：作用于 bean 对象的销毁动作之前

#### 线程安全问题

- 默认Bean是单例的，如果存在可变动的属性，多个线程访问时不安全，此时需要定义为Prototype。

#### Bean的生命周期

总体分为两阶段：BeanDefinition阶段和Bean实例阶段。

**BeanDefinition阶段**

- 加载xml配置文件、解析注解配置类
- 编程式构造BeanDefinition
- BeanDefinition后置处理

**Bean实例阶段**

- Bean实例化阶段：初始化所有的BeanPostProcessor、合并BeanDefinition、通过构造器实例化Bean
- Bean初始化阶段：属性赋值、组件依赖注入、后置处理器回调、初始化方法回调
- ![image-20210516160640089](/Users/bjhl/Library/Application Support/typora-user-images/image-20210516160640089.png)
- Bean销毁阶段：BeanFactory取出所有单例Bean销毁，然后回调执行Bean定义的销毁方法

#### Bean的循环依赖问题

bean实例化过程中使用三个map记录bean实例

- singletonObjects 记录实例化完整的bean
- earlySingletonObjects 存放的是提前曝光的单例对象
- singletonFactories 保存要被实例化的对象工厂

引用的对象在前两个map找不到时，会将bean放到第三个map并提前设置依赖的bean的引用，当依赖的bean实例化成功时三级map中的bean也就实例化成功了



prototype的bean，构造器注入的bean不能处理循环依赖问题



## 三、AOP

### 1、概念

面向切面编程，是OOP的补充。在不修改代码的前提下，通过运行时动态代理实现对已有逻辑的增强。

### 2、设计原理

#### 总述

- 由运行时动态代理支撑，在 bean 的初始化流程中，借助 BeanPostProcessor 将原始的目标对象织入通知，生成代理对象。
- postProcessAfterInitialization 方法中将目标对象包装为代理对象。这里面涉及到几个核心步骤：
  1. 检查当前初始化的 bean 是否可以被 AOP 代理（检查是否有匹配的增强器）
  2. 如果存在，则根据当前初始化的 bean 所属类有无实现接口，以及 AOP 的全局配置，决定使用哪种代理方案
  3. 将目标对象包装为 TargetSource ，并以此为原型生成代理对象

#### jdk动态代理和Cglib动态代理

- jdk 动态代理要求被代理的对象所属类至少实现一个接口，它是 jdk 内置的机制
- Cglib 动态代理无此限制，使用字节码增强技术实现，需要依赖第三方 Cglib 包
- jdk 动态代理的代理对象创建速度快，执行速度慢；Cglib 动态代理的代理对象创建速度慢，执行速度快

#### 术语

- Target 目标对象：被代理的原始对象
- Proxy 代理对象：目标对象被织入通知后的产物就是代理对象
- JoinPoint 连接点：目标对象的所属类中，定义的所有方法均为连接点
- Pointcut 切入点：被切面拦截 / 增强的连接点（切入点一定是连接点，连接点不一定是切入点）
- Advice 通知：增强的逻辑 / 代码，也即拦截到目标对象的连接点之后要做的事情
- Aspect 切面：切入点 + 通知

#### 通知类型

- **Before 前置通知**：目标对象的方法调用之前触发

- **After 后置通知**：目标对象的方法调用之后触发

- **AfterReturning 返回通知**：目标对象的方法调用完成，在返回结果值之后触发

- AfterThrowing 异常通知

  ：目标对象的方法运行中抛出 / 触发异常后触发

  - 注意一点，**AfterReturning 与 AfterThrowing 两者是互斥的**！如果方法调用成功无异常，则会有返回值；如果方法抛出了异常，则不会有返回值。

- **Around 环绕通知**：编程式控制目标对象的方法调用。环绕通知是所有通知类型中可操作范围最大的一种，因为它可以直接拿到目标对象，以及要执行的方法，所以环绕通知可以任意的在目标对象的方法调用前后搞事，甚至不调用目标对象的方法

### 3、AOP使用

#### 场景

- 日志打印
- 数据缓存
- 权限验证

#### 顺序

- 通过Order指定，默认Integer.MaxValue，越小越先执行

#### 失效场景

- **代理对象调用自身的方法**时，AOP 通知会失效，即通过this.xxx()



## 四、WebMVC

### 1、WebMvc父子容器

<img src="/Users/bjhl/Library/Application Support/typora-user-images/image-20210516165353608.png" alt="image-20210516165353608" style="zoom:50%;" />

#### 核心组件

- DispatcherServlet ：**核心的中央处理器**，负责接收请求、分发，并给予客户端响应
- HandlerMapping ：**处理器映射器**，根据 uri ，去匹配查找能处理的 Handler ，并会将请求涉及到的拦截器，和 Handler 一起封装
  - **`RequestMappingHandlerMapping`** ：支持 `@RequestMapping` 注解的处理器映射器
- HandlerAdapter ：**处理器适配器**，根据 `HandlerMapping` 找到的 Handler ，适配执行对应的 Handler
  - Handler 的编写不止 `@Controller` + `@RequestMapping` 的方式，例如还有实现Controller接口，适配器根据handler类型调用对应Adapter的handle方法处理请求
- Handler ：处理实际请求的处理器
- ViewResolver ：**视图解析器**，根据 Handler 返回的逻辑视图 / 视图，解析并渲染真正的视图，并传递给 `DispatcherServlet` 响应客户端

### 2、拦截器和过滤器

- 拦截器是框架的概念，而过滤器是 Servlet 的概念。
- 拦截器只能拦截到被DispatcherServet处理的请求，而过滤器几乎可以拦截所有请求
- 拦截器可以借助依赖注入获取所需要的 bean ，而过滤器无法使用正常手段获取。
  - 过滤器可以通过WebApplicationContextUtil 获取WebApplicationContext然后依赖查找bean

### 3、跨域问题

#### 发生

- http 访问 https ，或者 https 访问 http
- 不同域名 / 服务器主机之间的访问
- 不同端口之间的访问

#### 解决

- @CrossOrigin 注解的核心底层，是给响应头中添加了一个 Access-Control-Allow-Origin: * 

