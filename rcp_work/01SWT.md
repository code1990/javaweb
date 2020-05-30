## 第 3 章 SWT/JFace 开发过程 

#### 3.1 SWT 概述

SWT 与 Java 的 AWT 类似，都是基于一个对等体实现。但 SWT 克服了 AWT 的最 小公分母（LCD）的问题，用 SWT 编写的 UI 无论在响应速度，还是在美观程度上都大大超 越了 SUN 公司提供的 AWT 和 Swing。这主要是因为 AWT 只是单纯模拟本地操作系统窗口 组件，而 SWT 最大化了操作系统的图形构件 API，也就是说只要操作系统提供了相应图形的 构件，SWT 就可以利用 Java Native Interface（JNI）调用它们，只有操作系统中不提供的组 件，SWT 才去模拟的实现。 

SWT 编写 的 UI 效果与本地系统窗口几乎没有区别

采用 JFace 库作为 SWT 的增强库，只是 SWT 的扩展，JFace 库中的组件不会与本地操作系统交互

SWT 性能上的稳定多是取决于相应操作系统图形组件的稳定性。



##### 3.1.1 SWT 类库包 

org.eclipse.swt 包含所有的 SWT 常量和异常声明 

org.eclipse.swt.widgets 包含所有的窗口小部件类。例如：Button、Text、Combo 等 
org.eclipse.swt.events 包含所有的 SWT 的事件类和监听器接口。
org.eclipse.swt.layout 包含 SWT 组件的各种布局方式。

org.eclipse.swt.custom 包含自定义小部件。

org.eclipse.swt.graphics 包含了所有的图形。例如：图片（Image）、字体（Font）等 

org.eclipse.swt.awt 包含所有的用于将 AWT 嵌入 SWT 的 SWT-AWT 组件 

org.eclipse.swt.ole.win32 包含支持 32 位 Windows 平台的对象链接嵌入控件。

org.eclipse.swt.browser 包含所有实现浏览器功能的小部件 

org.eclipse.swt.printing 包含实现打印的功能 

org.eclipse.swt.dnd 包含如剪贴板、数据传输、拖放等功能部件 

org.eclipse.swt.internal 包含所有的内部 SWT 类 

org.eclipse.swt.program 包含 Program 类，该类的实例表示文件关联 



##### 3.1.2 窗口小部件（Widget） 

所有 UI 组件基本上都来自 Widget 类









