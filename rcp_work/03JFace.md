# JFace

JFace 是建立在 SWT 之上的 UI 部件，它是 SWT 的扩展。JFace 工具箱提供了一组功能 强大的用户界面组件

## 第 10 章 JFace 的独立使用

#### 10.1 JFace 窗体 

ApplicationWindow 类是 Window 类的子类

实例一 构造基本的 JFace 窗体 JFaceWindowsClass.java/10.1.png

实例二 在 JFace 窗口添加 SWT 基本组件 JFaceWindows1Class.java/10.2.png

##### 10.2  动作(Action 类) 

Action 通常被称为动作命令，它使事件处理更简单、更容易。在 JFace 里面，Action 可 以关联到菜单，工具条，以及按钮

StatusLineManager 类提供了设置状态条文字的方法，可以用来控制显示在状态栏的一个 进度条，也可以用来显示错误文字和图片等。 
下面的内容主要介绍一下ActionContributionItem类。Action 类似SWT 的事件，但
Contribution 的功能更复杂，它包括两个主要的Contribution 类：ContributionItem 类、ContributionManager 类。 ContributionItem 类提供个别的 GUI 组件的触发行为。
ActionContributionItem 类是 ContributionItem 的子类，该类执行应用程序关联的 GUI 行为(Action)。

##### 10.3  JFace 窗体添加菜单、工具栏 

MenuManger 类和 TooBarManger 类同为 ContributionManager 类的子类

## 第 11 章 JFace 对话框

JFace 对话框类扩展了抽象类Dialog，图 11.1 为 JFace 标准对话框之间的关系图。 
JFace 对话框除了这 4 种标准对话框外，还包括标题区域对话框(TileAreaDialog)、向导对 话框(WizardDialog)、自定义对话框(Custom Dialog)和首选项对话框（PreferenceDialog）

##### 11.1  信息提示对话框(MessageDialog 类) 

信息提示对话框用来向用户显示提示性的信息

##### 11.2  错误信息对话框（ErrorDialog 类） 

通过 IStatus 接口捕获了一些发生的严重错 误信息的细节，并将错误信息显示

##### 11.3  输入值对话框(InputDialog 类) 

##### 11.4  进度条对话框(ProgressMonitorDialog 类) 

##### 11.5  标题区域对话框(TitleAreaDialog 类) 

##### 11.6  自定义对话框(Custom Dialog) 

```java
public class CustomDialog extends Dialog { 
    
}    
```

##### 11.7  向导对话框(WizardDialog 类)

定制一个向导对话框需要 WizardDialog 类、Wizard 类和 WizardPage 类

向导对话框是一个按照特定的顺序来收集信息，WizardDialog 类提供了向导对话框的标 准按钮，Wizard 类来设置 WizardPage（向导页

WizardPage 类还包括。 
getImage()获得该对话框页的图像。 
getName()获得该对话框页的名字。 
getNextPage()获得下一页。 
getPreviousPage 获得前一页。 
isCurrentPage()如果当前页处于激活状态，则返回 true；否则，返回 false。 
isPageComplete()如果这一页完成，则返回 true；否则，返回 false。 
setErrorMessage(String newMessage)清除错误提示信息。 
setPageComplete(boolean complete)设置这一页是否完成。 

##### 11.8  首选项对话框(PreferenceDialog 类) 

首选项的定制有些类似向导对话框，都是创建一个个的页面，不同的是首选项的页面有 点类似经过 StackLayout 布局，使每个页面叠放在界面上

定制首选项需要用到 org.eclipse.jface.preferences 包中的类，PreferenceDialog 类、 PreferenceManager 类、PreferenceNode 类、PreferencePage 类、PreferenceStore 类等

PreferencePage 类用来实现自定义首选项页面。
PreferenceNode 类实现树结构
setPreferenceStore()和 getPreferenceStore()方法分 别用来设置和获取 PreferenceStore 的对象；
类 PreferenceManager 用来组织 PreferenceNode

## 第 12 章 JFace 查看器（Viewer类)

JFace 的视 图包括 TextViewer 类、SourceViewer 类、TableViewer 类、TreeViewer 类、ListViewer 类等

##### 12.1  TextViewer 类、SourceViewer 类 

TextViewer 实现了文本 处理功能的演示层，它封装了 SWT 中的 StyledText 控件

SourceViewer 类为 TextViewer 类的子类，除了继承 TextViewer 类的功能，SourceViewer 还提供了垂直标记功能，即垂直标尺

##### 12.2  TableViewer 类 

TableViewer 类是 Table 类的 扩展，并封装了 Table 窗口小部件

##### 12.3  ListViewer 类 

ListViewer 类是 AbstractListViewer 类的子类，它是 SWT 的 List 组件的一个扩展，并封 装了 List 的窗口小部件，列表查看器与表格查看器的用法基本相同，它也需要内容提供器和 标签提供器进行配置，不同的是列表查看器使用的是标签提供器 ILabelProvider

##### 12.4  TreeViewer 类 

TreeViewer 类和 TableViewer 类、ListViewer 类类似，都是 StructuredViewer 类的子类

TreeViewer 的功能实现几乎和 TableViewer、ListViewer 一样，都有标签器、内容器、排 序器等，可实现排序、过滤功能。所不同的是树查看器使用的标签提供器为 ILabelProvider， 与列表查看器相同；内容提供器使用 ITreeContentProvider

