### 02搭建vue.js项目

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
修改config/index.js文件localhost为0.0.0.0 便于使用ip地址访问（开发环境不建议修改）

设置自动打开浏览器

--------------------

测试：http://localhost:8080/#/

ok:成功返回login标识ok