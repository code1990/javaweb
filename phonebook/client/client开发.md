### 02搭建vue.js项目初始化

-------------

vue init webpack phonebook

---------

? Project name phonebook
? Project description A Vue.js project
? Author
? Vue build (Use arrow keys)
? Vue build standalone
? Install vue-router? Yes
? Use ESLint to lint your code? No
? Set up unit tests No
? Setup e2e tests with Nightwatch? No
? Should we run `npm install` for you after the project has been created? (recom
? Should we run `npm install` for you after the project has been created? (recom

mended) npm

   vue-cli · Generated "phonebook".

---------------

不要使用单元测试 不要使用ESLint  后期修改



移动端设置如下的属性
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
width:可视区域的宽度，值可为数字或关键词device-width

 intial-scale:页面首次被显示是可视区域的缩放级别，取值1.0则页面按实际尺寸显示，无任何缩放

 maximum-scale=1.0, minimum-scale=1.0;可视区域的缩放级别，

maximum-scale用户可将页面放大的程序，1.0将禁止用户放大到实际尺寸之上。

 user-scalable:是否可对页面进行缩放，no 禁止缩放

修改config/index.js文件localhost为0.0.0.0 便于使用ip地址访问（开发环境不建议修改）

设置自动打开浏览器

--------------------

测试：http://localhost:8080/#/

ok:成功返回login标识ok

-----------------------

### 03前端登陆页面的开发

----------------------------------

为了更好的适配移动端加入border.css，Reset.css
这些样式 是全局样式 所以需要加入到main.js文件中

stylus安装：执行css的预处理

npm install stylus --save

npm install stylus-loader --save

 Axios安装:便于Ajax请求

npm install axios



开发Login.vue页面的开发


可以看到正确的登陆效果说明本功能正常
----

### 05 前后端接口对接token

前段输入错误的用户名和密码 则提示错误

输入正确的用户名和密码 java1234 123456 提示 token is not defined 说明前端开发环境 在当前位置开发ok

-----------------------

###06 前端完成登录后的电话薄页面的请求
router.js重新注册一个PhoneBook的组件
前端登录页面以后输入正确的用户名和密码 java1234 123456 

正常跳转到电话薄页面，并且前端控制台可以获取到后端给予的token信息，说明前端功能开发ok

--------------------

### 08前端实时请求后台刷新token

前端开发过程中 容易出现跨域请求报错的问题 注意仔细查看

测试：后台实时刷新token 设置10s 正常返回到前端 前端无报错 ok
-------------------
### 09前端 通讯录的基本展示逻辑的开发

页面没有报错
---------------------------------
### 11前端 实现数据的遍历

通过把数据传递到前台，然后保存到list.vue页面上 然后遍历该数据信息

实现动态列表的实现 然后配置图片的请求路径

测试：前台可以正常展示列表信息 说明列表的内容正常
-----------
### 12 better-scroll实现区域滚动
安装：npm install --save better-scroll
 https://github.com/ustbhuangyi/better-scroll
测试：添加该依赖以后 修改list.vue页面 可以实现页面的上下滚动
--------------

### 13 通讯录列表右侧字母表显示实现

遍历前台传递过来的字母，然后展示在前端页面上去

测试：字母正常展示在前端列表之上 控制台没有任何的报错 同时打印出所有的字母信息
--------

### 14  根据字母表点击以及滚动实现列表滑动

在父类组件当中定义一个变量 实现兄弟元素之间的相互传递

测试：点击指定的元素值 即可实现滑动到指定的位置 控制台打印指定的参数字母 控制台无错误信息

---------------------------

### 15 点击字母 实现滚动到指定的列表页面


给定字母实现 列表页面的指定位置的滚动

测试：控制台没有报错 可以正确输出信息 正常滚动

-------------

### 16 前端搜索功能页面开发

search.vue组件的开发

前端开发简单 关键是需要找到开发的思路 有了思路简单
测试：输入字母 可以实现相关功能的实现 控制台无任何报错
----------------

### 17 设置头部矢量图标

测试：添加字体CSS文件 设置header css文件
--------------

### 18 页面添加列表页面的展示盒显示

点击添加跳转到列表页面 可以跳转到Add.vue界面

该页面的样式 图片显示正常

控制台无任何的报错
-----------------

### 19 前台上传头像到后台

前台主要开发页面的逻辑

测试：前端发送ajax请求道后台 后台接受参数 根据这些内容 获取保存文件 控制台无报错信息
-----------------
### 20 前端主要开发点击头像 实现头像的放大功能

头像点击放大功能的实现

-----------------

### 21通讯录前端添加功能的实现

前端主要对于增加列表页面执行有关 的添加操作



根据这些操作 添加对应的数据校验行为

前端保证这些校验行为的合法性

前端测试 数据可以成功保存到数据库当中

---------------------

### 22 性能优化

1.引入keep-alive组件 实现数据缓存到内存当中

2.引入pubsub.js 实现子类与父类之间的消息传递
pubsub.js消息的发布订阅

npm install --save pubsub-js

------------

### 23 后端 给定用户的id

根据用户的id查询用户信息


------------

### 24 修改用户信息的保存

用户修改信息的保存

前端修改用户信息可以保存到后台 同时再次点击可以再次查询该数据
------------

### 25 删除用户信息

点击用户信息 可以删除用户的信息 

-----------------

### 26 整合web项目
sys.js注释原来的代码 添加ip地址

npm run build

copy dist下面的所有的内容 然后整合到javaweb项目当中

### 26 前端开发完成以后 修改localhost为ip地址

sys.js注释原来的代码 添加ip地址

npm run build

copy dist下面的所有的内容 然后整合到javaweb项目当中
---------------





