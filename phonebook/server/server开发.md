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


