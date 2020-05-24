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

