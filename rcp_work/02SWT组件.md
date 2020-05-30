## SWT 组件

### 第 4 章 SWT 组件和容器

标签（Label）、按钮（Button）、微调 控制（Spinner）、分组框（Group）、面板（Composite）

--------------

#### 4.1 标签(Label 类) 标签不接受焦点输入与交互

文本标签、分栏符标签和图像标签的实际效果，以及添加标签的方法 LabelExample.java 4.2.png

----------------

#### 4.2 按钮(Button 类)用户在指示进行某项操作

常用的按钮样式效果 ButtonExample.java 4.4.png

----------------

#### 4.3 文本框(Text 类)接收键盘的输入信息

Text 综合实例  TextExample.java  4.6.png

-------------

#### 4.4 微调控制(Spinner 类)对数字进行微小的 调整

微调控制实例  SpinnerExample.java 4.8.png

------------

#### 4.5 下拉框(Combo 类) 从下拉项中 选择选项，用户也可以在下拉框中键入选项值。

下拉框实例  ComboExample.java 4.10.png

-------------------

#### 4.6 列表框(List 类) 列表框类似与下拉框和文本框。它的使用与 下拉框类

列表框实例 ListExample.java 4.12.png

--------------

#### 4.7分组框(Group 类) 分组框是一种特殊的窗口小部件，在分组框上能够容纳其他组件

分组框实例 GroupExample.java 4.14.png

-----------------

#### 4.8 面板(Composite)Composite 类和 Group 类一样都是容器类，在面板上同样也可以容纳窗口组件

面板实例 CompositeExample.java 4.17.png

------------

#### 4.9 滚动面板(ScrolledComposite)通过滚动条的滚动以显示所不 能显示的区域

SrcolledCompositeExample.java 4.20.png

---------------------

#### 4.10 ViewForm 容器 设置可控制组件在 ViewForm 顶端的显示，常用来设置工具栏显现

ViewFormExample1.java 4.22.png

ViewFormExample2.java

ViewFormExample3.java

---------------

### 第 5 章 事件

SWT 是通过display 管理事件循环。一旦启动SWT 应用程序，SWT 使用readAndDispath()方法从系统平台的事件队列中读取事件，并把读取的事件分配给适当的接收者。

每种事件有与之对应的Listener类，如果一个事件为X，那么对应的监听器（Listener）类就是XListener，它的添加监听方法为addXListener，

-------

#### 5.1 基本事件机制

##### 5.1.1 监听器

SelectionEvent 事件当某个GUI 元素被选中时发生

````java
button.addSelectionListener(new SelectionListener() {
    public void widgetSelected(SelectionEvent e) {
    MessageDialog.openInformation(shell, null, "HelloWorld!!");
    }
    public void widgetDefaultSelected(SelectionEvent e) {
    }
});
````

##### 5.1.2 适配器

适配器是包含若干个在接口中定义的空方法，它是某种接口的标准实现。使用适配器的总体思想是为了方便程序员编写事件处理程序

```java
button.addSelectionListener(new SelectionAdapter() {
public void widgetSelected(SelectionEvent e) {
MessageDialog.openInformation(shell, null, "HelloWorld!!");
}
});
```



#### 5.2 无类型事件机制

##### 5.2.1 无类型监听器概述

SWT 提供了无类型（UnType）监听器，它通过调用它的handleEvent()方法来获知事件（HandleEvent()为Listener 类的方法），该方法能够处理任何的事件

```java
Listener listener = new Listener() {
public void handleEvent(Event e) {
switch (e.type) {
case SWT.MouseDown:
MessageDialog.openInformation(shell, null, "MouseDown!!");
break;
case SWT.Resize:
MessageDialog.openInformation(shell, null, "Shell Resize!!");
break;
}
}
};
shell.addListener(SWT.MouseDown, listener);
shell.addListener(SWT.Resize, listener);
```

```java
widget.addListener(int eventType, new Listener() {
public void handleEvent(Event event) {
．．．
}
});
```

#### 5.3 键盘和鼠标事件

##### 5.3.1 键盘事件

在本节中介绍键盘事件（KeyEvent），当键被按下或释放时触发键盘事件

KeyEvent 包含4 个属性，分别为character、doit、keyCode 和stateMask

character 按键对应字符（Unicode 值，如Tab 键为"\t"）
keyCode 键的代码(如SWT.ESC、SWT.SHIFT)
doit 表示操作是否被允许，当为false 时操作被取消
stateMask 检测Alt，Shift，Ctrl 键是否同时按下

```java
text.addKeyListener(new KeyAdapter() {
public void keyPressed(KeyEvent e) {
e.doit = false;
}
});

```

##### 5.3.2 鼠标事件

鼠标事件操作包括：鼠标键的按下、释放、双击和鼠标光标在GUI 上移动或位于其上方
而触发。

```java
Listener listener = new Listener() {
public void handleEvent(Event e) {
String string = "";
switch (e.type) {
case SWT.MouseDown:
string += "DOWN";
break;
}
};
shell.addListener(SWT.MouseDown, listener);        
```

### 第 6 章 SWT 的对话框

#### 6.1 Shell 类

SWT 支持两种不同Shell 类型：一是用于实现主窗口的顶级Shell；二是用于实现对话框的Shell

ShellDialogExample.java 6.2.png

----

#### 6.2 MessageBox 控件

MessageBox 类是Dialog 的子类

MessageBox 控件是用来请求用户选择信息处理方式的控件

MessageBoxExample.java 6.5.png

-----

#### 6.3 文件选择对话框

FileDialog 类是Dialog 类的子类，文件选择对话框为用户提供了对文件的操作功能（打开、保存

OpenFileDialogExample1.java

SaveFileDialogExample1.java

SaveFileDialogExample2.java 6.7

-----------------

#### 6.4 字体选择对话框

FontDialog 类与FileDialog 类同是Dialog 的子类，用户可以通过字体选择对话框从系统字体库中选择所需字体

FontDialogExample1.java

FontDialogExample2.java 6.11

-----------

#### 6.5 颜色选择对话框

ColorDialog 类与FileDialog 类、FontDialog 类同是Dialog 类的子类

ColorDialogExample1.java

ColorDialogExample2.java 6.14

----------

#### 6.6 打印设置对话框

PrintDialog 类继承Dialog 类

打印输出功能主要是由PrintDialog、PrintData、Printer 这三个类来完成的。
PrintDialog 类提供了本地操作系统的打印设置对话框，返回所有的用户在对话框中选择的信息，即PrintData 对象。
PrintData 类包含用户在打印设置对话框中所要设置的所有信息。
Printer 类在打印过程中，由PrintData 得到starJob()方法创建的打印任务

PrintDialogExample.java 6.17

-----------

#### 6.7 目录选择对话框

DirectoryDialog 类谱系图 目录选择对话框在实际软件开发中经常用到

DirectoryDialogExample1.java 

DirectoryDialogExample2.java 

-----------
### 第 7 章 布局管理器

采用了绝对定位的方式setBounds()

使用布局管理器可对窗体上的组件进行有效的管理。一方面使窗口界面更加友好美观；另一方面使用布局管理器提供的
程序跨平台性，在不同系统平台下都能保持界面的稳定性

AWT/Swing 中采用了布局管理器，主要有流式布局（FlowLayout）、边界布局（BorderLayout）、框式布局（BoxLayout）、网格布局（GridLayout）和网格包布局（GridBagLayout）等类型。

----

SWT/JFace 中也存在类似的布局，主要有充满式布局（FillLayout）、表格布局（FormLayout）、行列布局（RowLayout）、网格布局（GridLayout）、堆栈布局（StackLayout）



------

#### 7.1 充满式布局（FillLayout）

FillLayout 可以将组件充满整个窗体

FillLayout 支持的样式类型为SWT.HORIZONTAL、SWT.VERTICAL 两种

```java
shell.setLayout(new FillLayout(SWT.HORIZONTAL)); 
new Text(shell,SWT.BORDER); 
//====
FillLayout fillLayout = new FillLayout(); 
fillLayout.type = SWT.VERTICAL; 
shell.setLayout(fillLayout); 
```

-------

FillLayout 的属性有 marginWidth、marginHeight、Spacing 

FillLayoutExample4.java 7.3.png

----------------

#### 7.2 网格式布局（GridLayout）

网格布局（GridLayout）相对其他布局类型比较复杂，该布局的功能相当强大，并且应 用灵活

new GridLayout()构造方法为 GridLayout 的默认布局，即将容器设置成为一列，所有组件在 容器中从上至下均排成一列。
new GriLayout(int numColumns,boolean makeColumnsEqualWidth) 中的参数 numColumns 用来表示容器（一般为窗口）设置的列数，makeColumnsEqualWidth 为 boolean 型的参数，==**当设置为 true 时则组件以等宽度按照指定列数排列在容器中**==

-----------

GridLayout有很多重要属性，主要包括numColunms、 makeColumnsEqualWidth、marginWidth、marginHeight、 verticalSpacing、horizontalSpacing 等

numColumns 属性用来设置容器的列数目，此实例设置为 3 列。  
horizontalSpacing 属性用来控制各行组件之间横向的间距（以像素为单位）。  
verticalSpacing 属性用来控制各列组件之间纵向的距离（以像素为单位）。  
make ColumnsEqualWidth=true 使组件各列等距离分开。  
marginWidth属性用来控制最左边组件和最右边组件与边框的距离（以像素为单位）。
marginHeight 属性用来控制顶部组件和底部组件与边框的距离（以像素为单位）。 

-------------

GridLayoutExample3 7.3.png

**GridData 的对象只能应用在一个组件上**

----

GriData.GRAB_HORIZONTAL 设置组件布局时，被设组件所在列的横向空间距 离随着容器（窗体）大小而变化，

GridData.GRAB_VERTICAL 设置组件布局时，被设组件所在行的纵向空间距离 随着容器（窗体）大小而变化

public GridData(int width,int height) 方法用来指定组件的宽度和高度。

 griddata.horizontalSpan=3 设置组件占有 3 列，但组件本身大小不变，

verticalSpan 属性用来设置组件占 有的行数目

horizontalIndent属性设置组件向右移动的距离

verticalIndent 属性设置组件向下移动的距离

widthHint 属性用来设置组件的宽

GridDataExample5 7.15

----------------------

#### 7.3 行布局（RowLayout） 

RowLayout 布局支持自动换行。它的功能不如 GridLayout 布局强大。RowLayout 布局与 GridLayout 布局类似

当窗体宽度不 足时，窗体上的组件自动折行

---------

常用的属性 有 boolean justify、boolean pack、int spacing、int marginBottom、 int marginLeft、int marginRight、int marginTop、boolean warp

rowlayout.justify=true 使组件等距离的分配所在行 空间

rowlayout.pack=false 设置组件的大小相等

rowlayout.wrap=false 控制当窗口宽度不足时强制组件不自动折行

int spacing、int marginLeft、int marginTop 属性用来设置组件布局

**RowData** 类只是起 到控制组件大小的作用

RowDataExample 7.31

-----------

#### 7.4 表格式布局(FormLayout) 

FormLayout 布局允许用户相 对于其他控件来安排每个控件，允许将控件的任意一边（左边、顶部、右边或底部）附着到 另一个控件的（通常相对的）边上，或者附着到容器的某一边上

 FormLayout 与 **FormData** 配合可以对组件 大小进行设置

FormDataExample.java 7.36

-------------------

用 **FomAttachment** 与 FormData 配合使用来控制复杂的布局

FormAttachmentExample1.java 

----------------

#### 7.5 堆栈式布局(StackLayout)

StackLayout是一个类似 没有选项卡的 TabFolder
可以用它在一次只显示一个 GUI 的 TabFolder 的顶部放置多个 GUI

StackLayoutExample 7.47

------

#### 7.6 一个类似 Google Talk 设置对话框的综合布局



-----

### 第 8 章 SW T 的复杂组件



### 第 9 章 其他组件类用法





---