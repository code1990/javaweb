### RCP开发教程

基于 Eclipse 3.6

### 目录
### 1富客户端平台
#### 1.1概述
#### 1.2ECLIPSERCP建设风格——插件，扩展和扩展点
#### 1.3RCP与PLUGIN
### 2创建第一个RCP程序
#### 2.1创建一个RCP程序
#### 2.2启动RCP程序

rcp ---init--- ok

#### 2.3程序VS产品
#### 2.4维护LAUNCH配置
#### 2.5可能的APPLICATIONID错误：
#### 2.6应用程序的PLUGINID
### 3ACTIONS的用法（菜单栏和工具栏）
#### 3.1概述
#### 3.2通过编码添加
#### 3.3“扩展”方式添加菜单和工具栏
#### 3.4添加全局快捷键
#### 3.4.1Command+Handler+Binding绑定
#### 3.4.2Action+Command+Binding绑定
### 4系统托盘
### 5视图
#### 5.1添加示例视图
#### 5.2添加自定义视图
#### 5.3向VIEW里添加ACTION
### 6编辑器
#### 6.1概述
#### 6.2创建工程
#### 6.3添加编辑器
#### 6.4调用编辑器
#### 6.5实例：文本编辑器实现
#### 6.5.1新建工程
#### 6.5.2添加菜单栏和工具栏
#### 6.5.3添加编辑器
### 7对话框
#### 7.1概述
#### 7.2预定义的对话框
#### 7.2.1概述
#### 7.2.2创建工程
#### 7.2.3添加菜单
#### 7.2.4调用对话框
#### 7.3用户自定义对话框
#### 7.3.1概述
#### 7.3.2创建SWT/JFace工程
#### 7.3.3自定义Dialog
#### 7.3.4说明
### 8向导
#### 8.1概述
#### 8.2示例
### 9首选项
#### 9.1首选项
#### 9.2使用首选项
#### 9.3首选项页
### 10添加状态栏
#### 10.1简介
#### 10.2安装状态栏
#### 10.3初始化状态条
#### 10.4控制状态栏
### 11透视图
#### 11.1简介
#### 11.2添加透视图
#### 11.3显示透视图工具栏
#### 11.4显示透视图菜单
### 12进度条
#### 12.1简介
#### 12.2进度条对话框
#### 12.3JOB进度条
### 13使用第三方JAR
#### 13.1概述
#### 13.2向构建路径中添加JAR
#### 13.3使JAR在你的运行路径里有效
### 14提示和策略
#### 14.1控制台日志
#### 14.2保存用户的布局
#### 14.3获得DISPLAY
#### 14.4使用ECLIPSE的“保存”ACTION
#### 14.5向你的程序添加错误日志视图
### 15产品
#### 15.1概述
#### 15.2PRODUCT配置文件
#### 15.3测试你的产品
#### 15.4欢迎页面
#### 15.5商标
#### 15.6风格化LAUNCHING
#### 15.7发布你的产品
#### 15.8创建一个帮助插件工程
### 16专题一ECLIPSE的版本和发行包
#### 16.1版本VERSION
#### 16.1.1版本的理解
#### 16.1.2Eclipse的版本
#### 16.1.3版本的选择和下载
#### 16.2发行包EDITION
#### 16.2.1发行包的理解
#### 16.2.2Eclipse的发行包
### 17专题二ECLIPSE的国际化与语言包
#### 17.1国际化
#### 17.1.1ExternalizeStrings
#### 17.1.2中文属性文件
#### 17.1.3国际化文件
#### 17.1.4指定语言环境
#### 17.1.5Propedit工具
#### 17.2语言包
#### 17.2.1Babel小组
#### 17.2.2中文语言包的下载
### 18专题三DECORATOR与MARKER的使用
#### 18.1简介
#### 18.2扩展DECORATOR
#### 18.3扩展MARKER
### 19专题四RUN/DEBUGLAUNCHER实现
#### 19.1ECLIPSERUN/DEBUG实现流程
#### 19.2扩展CONFIGURATIONTYPE
#### 19.3扩展ILAUNCHSHORTCUT
#### 19.4创建RUN/DEBUGCONFIGURATION界面
#### 19.5指定RUN/DEBUG显示图片
#### 19.6说明
### 20专题五EQUINOXP2方式实现RCP自动更新
#### 20.1概述
#### 20.2示例
#### 20.2.1Feature概念
#### 20.2.2配置Product
#### 20.2.3配置Feature
#### 20.2.4product导出
#### 20.2.5配置EquinoxP2
#### 20.2.6配置UpdateSite
### 21专题六COMMONNAVIGATORFRAMEWORK初探