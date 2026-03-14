## 一、概念

`SpringBoot` 的本质是构建在 `SpringFramework` 基础上的、简化基于 `SpringFramework` 的应用搭建和开发的脚手架。

- 基于原生 `SpringFramework` ，扩展而不破坏原有
- 可以直接创建一个单体应用jar包，并可以直接运行
- 可以使用嵌入式Web容器，也可以部署在外部Web容器中
- 提供starter依赖，可以快速集成组件和第三方库
- 支持自动配置Spring和第三方库
- 提供生产级别的特性（监控、健康检查、外部化配置等）



## 二、原理

主类上必须标注@SpringbootApplication，由三个注解组成

- @ComponentScan
- @SpringBootConfiguration
- @EnableAutoConfiguration

### 1、@ComponentScan

作用：注解在主类上，默认扫描主类所在包及其子包下的组件。包含以下两种属性

- TypeExcludeFilter：扩展组件的过滤
- AutoConfigurationExcludeFilter



### 2、@SpringBootConfiguration

1、本身包含了@Configuration，把主类标记为配置类。没有实质性的扩展

2、@SpringBootConfiguration 通常只用在主类上，包含测试的主类，会被 Spring测试框架 的搜索算法找到。



### 3、@EnableAutoConfiguration

#### 1、组件装配

传统Spring可以比较方便配置自己定义的组件，通过@Component @Bean等注解即可。但无法装配jar报中的组件。

一般装配外部组件采用模块装配功能。通过给配置类标注 `@EnableXXX` 注解，再在注解上标注 `@Import` 注解，即可完成组件装配的效果。

#### 2、@Import

用于把类引入并注册为bean。可以导入普通类、配置类、`ImportSelector` 的实现类，`ImportBeanDefinitionRegistrar` 的实现类。

#### 3、Springboot的自动装配

通过@EnableAutoConfiguration开启，包含了

- @AutoConfigurationPackage
- @Import(AutoConfigurationImportSelector.class)

**@AutoConfigurationPackage**

包含了注解@Import(AutoConfigurationPackages.Registrar.class)，作用是获取主类所在的包名，用于后续的组件扫描

**AutoConfigurationImportSelector.class**

会将**META-INF/spring.factories** 路径下定义的类扫描并Import进来