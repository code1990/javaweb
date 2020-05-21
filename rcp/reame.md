开发工具

eclipse-SDK-4.2-win32-x86_64.zip

----

rcp00

org.salever.rcp.tech.helloworld

----

rcp01

2.5配置 run as product 出现异常

----

rcp02 

3.2 通过编码添加

org.salever.rcp.tech.chapter3

actions来描述菜单及工具栏的

方法2种：

1．编写代码
2．扩展（Extensions

----------

```java
//打开ApplicationActionBarAdvisor.java做如下更改

```

----------

rcp03 

3.3 “扩展”方式添加菜单和工具栏

org.salever.rcp.tech.chapter3.ex

下面讲解一下Action set个元素的作用：
 Menu，定义菜单栏，也就是菜单显示的位置，示例里面新建了一个Sample Menu菜单；
 Action，定义菜单项，菜单项包含许多属性，其中比较重要的是id、label、menubar path、toolbar path、class等。label是显示在用户接口上的文字，要使action可见在菜单或者工具栏可见，menubarPath和toolbarPath是必须的

-------------

rcp04

3.4 添加全局快捷键

org.salever.rcp.tech.chapter3.keybinding

如果想使用快捷键，必须新建一个Command，用于对应Action，这里并没有新建Action，而是采用了一种新的菜单扩展方法，handler

M1在windows系统里代表Ctrl，详细参考api文档

3.4.2 Action+Command+Binding绑定

修改org.salever.rcp.tech.chapter3.ex

添加command组件

将Action与Command连接起来

----------

rcp05

4 系统托盘

-----------------

