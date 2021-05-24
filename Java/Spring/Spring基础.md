# Spring基础



## 一、什么是SpringFramework

**SpringFramework 是一个开源的、松耦合的、分层的、可配置的一站式企业级 Java 开发框架，它的核心是 IOC 与 AOP ，它可以更容易的构建出企业级 Java 应用，并且它可以根据应用开发的组件需要，整合对应的技术。**

IOC：控制反转，相当于一个静态工厂来管理Bean，再需要使用的地方调用工厂方法来获取，优点是组件之间的解耦

AOP：面向切面编程，实现应用业务和增强逻辑的解耦



# 二、IOC

两种使用到IOC思想的实现方式

## 1、依赖查找

### 1.1 byName

```java
BeanFactory factory = new ClassPathXmlApplicationContext("classpath:*application.xml");
Person person = (Person) factory.getBean("person");
```

### 1.2 byType

```java
BeanFactory factory = new ClassPathXmlApplicationContext("classpath:*application.xml");
Person person = factory.getBean(Person.class);
System.out.println(person);
```

### 1.3 ofType

```xml
<bean id="mysqlDao" class="com.leisure.be.dao.MysqlDao"/>
<bean id="oracleDao" class="com.leisure.be.dao.OracleDao"/>
```

```java
ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:*application.xml");
Map<String, BaseDao> beans = ctx.getBeansOfType(BaseDao.class);
beans.forEach((beanName, bean) -> System.out.println(beanName + ":" + bean));
```

> `BeanFactory` 接口提供了一种高级配置机制，能够管理任何类型的对象。`ApplicationContext` 是 `BeanFactory` 的子接口。它增加了：
>
> - AOP 的支持（ `AnnotationAwareAspectJAutoProxyCreator` 作用于 Bean 的初始化之后 ）
> - 配置元信息（ `BeanDefinition` 、`Environment` 、注解等 ）
> - 资源管理（ `Resource` 抽象 ）
> - 事件驱动机制（ `ApplicationEvent` 、`ApplicationListener` ）
> - 消息与国际化（ `LocaleResolver` ）
> - `Environment` 抽象

### 1.4 withAnnotation

```java
ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:*application.xml");
Map<String, Object> beans = ctx.getBeansWithAnnotation(Color.class);
beans.forEach((beanName, bean) -> System.out.println(beanName + ":" + bean));
```

### 1.5 获取所有bean

```java
ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:*application.xml");
// 获取所有bean id，然后根据id获取bean
String[] beanNames = ctx.getBeanDefinitionNames();
Stream.of(beanNames).forEach(System.out::println);
```

### 1.6 延迟查找

```java
ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:*application.xml");
ObjectProvider<Cat> catProvider = ctx.getBeanProvider(Cat.class);
catProvider.getIfAvailable(() -> new Cat());
```



## 2、依赖注入

```xml
<bean id="person" class="com.leisure.be.beans.Person">
    <property name="name" value="7+"/>
    <property name="age" value="18"/>
</bean>

<bean id="cat" class="com.leisure.be.beans.Cat">
    <property name="name" value="mimi"/>
    <property name="master" ref="person"/>
</bean>
```

