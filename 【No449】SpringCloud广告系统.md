
### 第1章 课程简介
#### 1-1 课程导学

主要介绍项目的基本开发环境


### 第2章 广告系统概览与准备工作
#### 2-1 广告系统概览

介绍广告主的投放 与媒体的投放


#### 2-2 广告系统架构

springcloud+mysql+kafka


#### 2-3 准备工作与系统目录结构

jdk1.8+idea+maven3+mysql5.5

主要包括如下的模块

==Eureka:实现服务注册与服务发现
gateway：利用Zuu|组件实现路由转发与请求信息记录(自定义过滤器)
广告系统服务实现子模块:
ad-common:通用代码，通用配置
ad-dashboard: Hystrix监控
ad-search:广告检索子系统
ad-sponsor:广告投放子系统。==


### 第3章 广告系统骨架开发
#### 3-1 Maven 基础知识

简单介绍maven相关的知识内容


#### 3-2 Maven 相关特性

依赖排除
短路优先
声明优先
多个模块聚合
父类统一管理dependencyManagement

#### 3-3 广告系统主工程

--------

新建一个空的module ad 并且整合如何的依赖

```xml-dtd
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.ad</groupId>
    <artifactId>ad</artifactId>
    <version>1.0-SNAPSHOT</version>

    <packaging>pom</packaging>

    <name>ad</name>
    <description>parent empty module</description>
    <!--定义父类工程的版本-->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.2.RELEASE</version>
    </parent>

    <properties>
        <spring-cloud.version>Finchley.RELEASE</spring-cloud.version>
    </properties>
    <!--定义公共的依赖-->
    <dependencies>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.16.18</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
    <!--定义子类的工程的依赖版本-->
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
    <!--定义远程仓库-->
    <repositories>
        <repository>
            <id>spring-milestones</id>
            <name>Spring Milestones</name>
            <url>https://repo.spring.io/milestone</url>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
    </repositories>
</project>
```
#### 3-4 单节点 Eureka Server 的开发

```properties
#注册中心单节点的配置指南
#启动eurekaapplication.java

#浏览器访问 127.0.0.1:8000 查看注册情况


##设置应用名称
#spring.application.name=ad-eureka
##设置端口号
#server.port=8000
##设置访问地址
#eureka.instance.hostname=localhost
## 是否注册其他的组件 这里设置false单一的注册中心
#eureka.client.fetch-registry=false
## 是否把自己注册到注册中心 选择否 不注册自己
#eureka.client.register-with-eureka=false
##设置默认的访问地址
#eureka.client.service-url.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/
#

```

```java
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}

```



#### 3-5 多节点Eureka Server 的部署配置

```properties
# 注册中心多节点配置
# 修改hosts文件 设置三个ip地址
#127.0.0.1 server1
#127.0.0.1 server2
#127.0.0.1 server3
# 项目打包如下所示 一个项目分别启动三次 实现多节点的注册集群
# 使用java -jar ad_eureka.jar -spring.active.profiles=server1
# 使用java -jar ad_eureka.jar -spring.active.profiles=server2
# 使用java -jar ad_eureka.jar -spring.active.profiles=server3

#访问127.0.0.1:8000 可以查看具体的注册情况

spring:
  application:
    name: ad-eureka
  profiles: server1
server:
  port: 8000
eureka:
  instance:
    hostname: server1
    prefer-ip-address: false
  client:
    service-url:
      defaultZone: http://server2:8001/eureka/,http://server3:8002/eureka/

---
spring:
  application:
    name: ad-eureka
  profiles: server2
server:
  port: 8001
eureka:
  instance:
    hostname: server2
    prefer-ip-address: false
  client:
    service-url:
      defaultZone: http://server1:8000/eureka/,http://server3:8002/eureka/

---
spring:
  application:
    name: ad-eureka
  profiles: server3
server:
  port: 8002
eureka:
  instance:
    hostname: server3
    prefer-ip-address: false
  client:
    service-url:
      defaultZone: http://server1:8000/eureka/,http://server2:8001/eureka/
```

```java
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}

```




#### 3-6 微服务架构及网关组件介绍




#### 3-7 网关启动程序的开发




#### 3-8 自定义网关过滤器的开发




### 第4章 微服务通用模块开发
#### 4-1 关于通用模块功能的介绍




#### 4-2 统一响应处理的开发




#### 4-3 统一异常处理的开发




#### 4-4 统一配置的开发




### 第5章 广告投放系统的开发
#### 5-1 Spring IOC和MVC基础知识




#### 5-10 数据表Dao接口的定义（2）




#### 5-11 用户账户服务功能实现




#### 5-12 推广计划服务功能实现（1）




#### 5-13 推广计划服务功能实现（2）




#### 5-14 推广单元服务功能实现




#### 5-15 推广单元限制服务功能实现（1）




#### 5-16 推广单元限制服务功能实现（2）




#### 5-17 创意服务功能实现




#### 5-18 创意与推广单元关联服务功能实现




#### 5-19 服务Controller的编写（1）




#### 5-2 SpringBoot 常用功能特性介绍




#### 5-20 服务Controller的编写（2）




#### 5-21 投放系统在网关中的配置




#### 5-22 数据库与数据表的创建




#### 5-3 广告投放系统数据表设计




#### 5-4 创建广告投放系统子模块




#### 5-5 数据表实体类定义（1）




#### 5-6 数据表实体类定义（2）




#### 5-7 数据表实体类定义（3）




#### 5-8 数据表实体类定义（4）




#### 5-9 数据表Dao接口的定义（1）




### 第6章 广告检索系统 - 微服务调用
#### 6-1 创建广告检索系统子模块




#### 6-2 基于 Ribbon 实现微服务调用




#### 6-3 基于 Feign 实现微服务调用




### 第7章 广告检索系统 - 广告数据索引的设计与实现
#### 7-1 广告数据索引设计介绍




#### 7-10 索引服务类缓存的实现




#### 7-2 广告数据索引维护介绍




#### 7-3 推广计划索引对象定义与服务实现




#### 7-4 推广单元索引对象定义与服务实现




#### 7-5 关键词索引对象定义与服务实现




#### 7-6 兴趣索引对象定义与服务实现




#### 7-7 地域索引对象定义与服务实现




#### 7-8 创意索引对象定义与服务实现




#### 7-9 创意与推广单元关联索引对象定义与服务实现




### 第8章 广告检索系统 - 加载全量索引
#### 8-1 导出表数据字段定义（1）(1)




#### 8-10 全量索引加载的实现（1）




#### 8-11 全量索引加载的实现（2）




#### 8-2 导出表数据字段定义（2）




#### 8-3 表数据导出到文件功能实现（1）




#### 8-4 表数据导出到文件功能实现（2）




#### 8-5 表数据导出到文件功能实现（3）




#### 8-6 索引操作Handler的定义与说明




#### 8-7 第二层级索引操作的实现




#### 8-8 第三层级索引操作的实现




#### 8-9 第四层级索引操作的实现




### 第9章 广告检索系统-监听Binlog构造增量数据
#### 9-1 MySQL Binlog 的介绍




#### 9-10 根据 Binlog 对象构造增量数据的实现




#### 9-11 启动对 Binlog 的监听




#### 9-2 使用开源工具监听 Binlog 的演示




#### 9-3 构造解析 Binlog 使用到的模板文件




#### 9-4 实现对模板对象的解析




#### 9-5 载入模板文件并实现列索引到列名的映射




#### 9-6 关于 Binlog 监听与解析的说明




#### 9-7 Binlog 监听与解析的实现（1）




#### 9-8 Binlog 监听与解析的实现（2）




#### 9-9 根据 Binlog 对象构造增量数据的准备工作



### 第10章 广告检索系统 - Binlog增量数据的投递

#### 10-1 增量数据投递前的准备工作



#### 10-2 第二层级增量数据的投递



#### 10-3 第三层级增量数据的投递



#### 10-4 第四层级增量数据的投递



#### 10-5 将增量数据投递到Kafka



### 第11章 广告检索系统-广告检索服务

#### 11-1 广告检索服务功能的介绍



#### 11-2 媒体方请求对象的定义



#### 11-3 检索服务响应对象的定义



#### 11-4 根据流量类型实现对推广单元的预筛选



#### 11-5 根据匹配信息实现对推广单元的再筛选



#### 11-6 通过推广单元获取关联的创意实现



#### 11-7 填充检索服务响应对象



#### 11-8 完善广告检索服务



### 第12章 Kafka的安装与使用

#### 12-1 Kafka 基础知识的介绍



#### 12-2 Kafka 的安装与使用



#### 12-3 使用原生API发送消息（1）



#### 12-4 使用原生API发送消息（2）



#### 12-5 自定义分区分配器



#### 12-6 消费者与消费者组的概念



#### 12-7 使用原生API消费消息（1）



#### 12-8 使用原生API消费消息（2）



#### 12-9 使用原生API消费消息（3）



### 第13章 熔断监控Hystrix Dashboard

#### 13-1 Hystrix Dashboard 的介绍



#### 13-2 Dashboard 模块的实现



### 第14章 广告系统的可用性测试

#### 14-1 广告系统测试前的准备工作



#### 14-2 编写广告投放系统的测试用例



#### 14-3 编写广告检索系统的测试用例（上）



#### 14-4 编写广告检索系统的测试用例（下）



#### 14-5 投放系统的 HTTP 接口测试



### 第15章 课程总结

#### 15-1 课程总结