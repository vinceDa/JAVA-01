一、spring组成模块：
spring-core、spring-beans、spring-context、spring-jdbc、spring-aop、spring-web、spring-test

核心模块： 1.1spring IOC容器
把本该有程序员自己操控对象的事情交给容器来完成，
IOC容器负责创建对象，管理对象（依赖注入DI），装配对象，配置对象，以及整个对象的生命周期；
1.2AOP：在不影响业务的情况下，进行横向拓展，实现方式就通过代理的方式

二、SpringBoot
特点：提供各种starter，开箱即用，简化了参数配置提供默认配置，再也不用担心各种版本间的搭配问题
约定大于配置

核心模块 1、自动化配置：简化配置核心基于
Configuration，EnableXX，Condition 2、spring-boot-starter：脚手架核心
整合各种第三方类库，协同工具

Bean的生命周期（图）

三、ORM 3.1 JPA ORM遵循的java规范 Spring Data JPA spring的

3.2数据库连接池 C3P0 DBCP Druid Hikari

3.3 MyBatis 与 Hibernate Mybatis 优点：原生 SQL（XML 语法），直观，对
DBA 友好 Hibernate 优点：简单场景不用写 SQL（HQL、Cretiria、SQL）
Mybatis 缺点：繁琐，可以用 MyBatis-generator、MyBatis-Plus 之类的插件
Hibernate 缺点：对 DBA 不友好