### 01 后端的login接口的开发

创建Admin类，执行MVC的三步操作

实现Admin的信息的查询

测试url：http://localhost/login 

返回login字符串说明执行ok

----------

### 04 后端token的获取和设置

```xml
<!-- JWT -->
        <dependency>
            <groupId>com.auth0</groupId>
            <artifactId>java-jwt</artifactId>
            <version>3.2.0</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt</artifactId>
            <version>0.7.0</version>
        </dependency>
```
设置一个checkResult
设置一个SystemConstant
设置一个JwtUtils用于设置jwt相关的内容

--------------------------
### 05 前后端接口对接token

后端的关键点在于使用webMvcConfigurer 来控制跨域请求

然后返回正确的的token到前台

--------
### 06后端完成登录请求的拦截处理

后端添加拦截器 注册拦截器到WebAppConfigure配置类中

后台启动，如果前端页面跳转到信息薄出现token说明拦截业务处理正常
---------

### 07整合logback

添加logback-spring.xml配置文件

对于拦截器的所有请求 全部输入到日志文件中

----------------

### 08后端接受前端请求生成token信息

刷新token的业务逻辑属于比较麻烦的 需要开发注意细节

测试：后台实时刷新token 设置10s 正常返回到前端 前端无报错 ok
-------------

### 10后端查询通讯录接口的实现

后端PhoneBook的MVC三层开发ok

打开前端页面可以获取查询的数据打印到控制台上面
---------------
### 11 后端配置图像请求路径

在配置类当中配置有关的路径信息

测试：配置图片 可以再前台页面动态查看 功能ok
-------------

### 19 后端接受用户上传的图片 报错并改名字

测试：后台成功保存文件
------------
### 21通讯录前端添加信息 后台保存数据

添加pinyin4j 把中文的转英文 实现排序

可以把数据正常保存到数据库当中
----------

## 23 前端点击用户图标可以获取用户的详细信息

用户详情页面的开发

测试：点击用户头像 可以查询获取用户的信息 控制台 没有任何的报错

-------

### 24用户修改信息的保存

用户修改信息 正常保存到数据库当中

----------------------

### 25 点击用户信息 可以实现删除用户信息

后台删除用户信息的事件的处理
-------------

### 26 整合web项目

使用idea 整合添加srcc/main/webapp骨架

复制前端打包文件到该目录下

然后运行后端环境

浏览器访问localhost 可以正常访问前端

注意IP地址先修改为localhost 然后修改为IP
sys.js注释原来的代码 添加ip地址

-----
### 27 部署到centos7上去

1.安装jdk
2.安装mysql
3.安装tomcat9
4.上传代码 修改conf/server.xml　添加如下的内容
<host>
<Context path="" docBase="/home/apache-tomcat-9.0.31/webapps/phonebook-0.0.1-SNAPSHOT" debug="0" reloadable="true"/>
</host>
5.进入bin目录下方 启动如下的命令
sh startup.sh

----

