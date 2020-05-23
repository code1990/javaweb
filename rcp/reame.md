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

org.salever.rcp.tech.chapter4

-----------------

rcp06

视图（View）可以为任务提供信息，查看通常为信息层次提供导航，打开编辑器，或者浏览属性

org.salever.rcp.tech.chapter5.perspective

org.salever.rcp.tech.chapter5

------------

rcp07

5.2 添加自定义视图

org.salever.rcp.tech.chapter5.view

==无法浮现业务逻辑==

-----

rcp08

编辑器（Editor）的使用是RCP开发中非常重要的一个环节

org.salever.rcp.tech.chapter6

------

rcp09

isDirty() ：在ISaveablePart中定义，用来表示编辑器是需要保存，返回true表明需要保存，否则不需要。与Eclipse内置的Save菜单绑定，当isDirty()返回true时候，Save菜单可用，否则不可用。
 doSave(...) ：在ISaveablePart中定义，进行编辑器内容保存的方法，点击Save菜单将触发此方法。
 doSaveAs()：在ISaveablePart中定义，用于另存文件，点击Save As菜单时触发此方法。
 isSaveAsAllowed() ：在ISaveablePart中定义，用于启用或者禁用Save As菜单。
 promptToSaveOnClose()：在ISaveablePart2定义，用于在关闭编辑器时候提示操作，这里在内容未保存的时候提示操作



org.salever.rcp.tech.chapter6.txtedit

----

rcp10

7 对话框

对话框（Dialog），是Eclipse平台提供的最为灵活的组件之一

FileDialog
ColorDialog
DirectoryDialog
FontDialog
PrintDialog
ErrorDialog
InputDialog
MessageDialog

org.salever.rcp.tech.chapter7

----

rcp11

7.3 用户自定义对话框

**笔者一般先用SWT Designer进行布局，然后再改写它自动生成的代码，这样可以提高开发效率。**

org.salever.rcp.tech.chapter7.dialog

------

rcp12

org.salever.rcp.tech.chapter8

向导框提供一个灵活的方法收集软件使用者系统的输入并且准确的执行输入

WizardDialog类实现了一个向导框。
Wizard类可以提供向导内容，WizardPages类提供向导页面的设计。

-----

rcp13

Eclipse首选项和java.utils.prefs.Preferences非常相似。首选项对一些类似查找、存储的附加特征提供支持

org.salever.rcp.tech.chapter9



==无法重现业务逻辑==

----

rcp14

状态栏（StatusLine），指的是RCP主界面下方的信息提示栏，这里可以提示一些正在运行的操作，系统状态等信息

org.salever.rcp.tech.chapter10

==无法重现业务逻辑==

----

rcp15

透视图（Perspective）将相关的UI元素集合并组织起来，更适合特殊的任务及工作流程。

org.salever.rcp.tech.chapter11

----

rcp16

12 进度条

org.salever.rcp.tech.chapter12



-----



