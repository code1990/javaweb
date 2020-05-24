一个Eclipse应用需要：

 主程序 – RCP主应用类实现Iapplication接口，Eclipse要求是通过org.eclipse .core.runtime.application扩展点定义这个类。
 透视图 – 此透视图扩展自org.eclipse.ui.perspective

所有的插件都必须提供一份名为“plugin.xml”的说明文档。

创建、运行Eclipse RCP应用至少需要两个插件，即“org.eclipse.core.runtime”与“org.eclipse.ui”

插件的配置包含于如下两个文件中：
 MANIFEST.MF – OSGi包的说明保存在MANIFEST.MF文件中；
 Plugin.xml – 附加的 Eclipse 配置文件（非标准OSGi要求），例如扩展点。

。.project文件包含了项目的有关描述

----------------

在Eclipse RCP 应用启动期间，Eclipse运行时将寻找通过扩展点“org.eclipse.core.runtime. application”所定义的类。

然后加载这个类。此类会创建并运行工作台。工作台通过WorkbanchAdvisor进行配置，工作台将启动一个WorkbenchWindow，此窗口通过WorkbenchWindowAdvisor配置。WorkbenchWindow将创建工具条，此工具条可以通过ActionBarAdvisor在启动时配置。

每个Advisor（顾问）都负责应用的一个配置方面，例如，WorkbenchAdvisor可以通过重载preStartup()方法与preShutdown()方法而允许在启动或关闭前执行某些动作。

------------------

命令是组件的说明性描述，它独立于其实现细节。可以对命令进行分类并为命令分配一个热键。命令可以用于菜单、工具条或者弹出菜单中。





----------------------

org.eclipse.jface.fieldassist包以两种方式提供帮助。Decorations控件允许用户放置一个图像说明以显示字段状态，而内容建议则提供了一个弹出消息告诉用户那些可能的选项

-------

Eclipse通过类WizardDialog实现了向导功能。WizardDialog控件控制着进程（导航、进程条、错误及消息区）。向导的内容是由Wizard类所提供，页面则是通过类WizardPages提供。

-----------

**注意新增的menuContribution中的locationURI必须为menu:org.eclipse.ui.main.menu，否则菜单无法显示！**

------------------

通过共享消息区，可以使得应用的所有单元将消息写到该区域。下面我们来介绍如何为应用添加状态行。在此还将介绍如何在视图或编辑器中填充状态行。

-------------

真正的Eclipse，是一个提供了完善插件机制的RCP 平台，它以SWT/JFace 座位界面元素组件，提供给用户一个名为
Workbench 的UI 平台

工作台为 Eclipse 提供用户界面。它是使用标准窗口工具包（SWT）和一个更高级的
API（JFace）来构建的；SWT 是 Java 的 Swing/AWT GUI API 的非标准替代者，JFace
则建立在 SWT 基础上，提供用户界面组件。

工作区是负责管理用户资源的插件。这包括用户创建的项目、那些项目中的文件，以及
文件变更和其他资源

帮助组件具有与 Eclipse 平台本身相当的可扩展能力。与插件向 Eclipse 添加功
能相同，帮助提供一个附加的导航结构，允许工具以 HTML 文件的形式添加文档

平台运行库是内核，它在启动时检查已安装了哪些插件，并创建关于它们的注册表信息。
为降低启动时间和资源使用，它在实际需要任何插件时才加载该插件

-----------------

plugin.xml 的配置文件，该文件是描述该插件项目具体扩展了哪些Eclipse 的扩展

Eclipse3.1 开始，大部分信息比如classpath、依赖插件项等信息，都储存在了manifest.mf

其中有两个扩展点：一个是 Application，一个是Product。

Application 扩展点定义了一个applcation 类，这个类可以说是一个RCP 应用的
入口，它实现了IPlatformRunnable 接口类，在RCP 启动的时候将会执行这个接口的
run 方法

Product 扩展点则是一个RCP 应用的引导入

---------------

Perspective 其实并不是一个实在的东西，它是对一个界面布局的说明，比如上面的界面安排

工作台只是一个可以提供各种可视部件的框架。这些部件属于两个主要类别：**视图和编辑器**。

**编辑器**允许用户在工作台中编辑某些内容

**视图**提供了关于用户正在工作台中使用的一些对象的信息



-----------------------

扩展点 org.eclipse.ui.views 允许插件将视图添加到工作台中

视图的接口是在 IViewPart 中定义的，但是插件可以选择扩展ViewPart 类而不是根据暂存区来实现IViewPart

构成UI 元素的是由SWT/JFace 提供的UI 部件，

-------------------------

ContentProvider，这个内容提供者其实就相当于MVC 模式
中的M（模型），可是JFace 中并没有完全依赖模型，而是提出了Provider 来提供给Viewer 模







----------------

