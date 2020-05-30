display 是 Display 的对象，它用来管理事件的循环

Display 类维护着注册的事件监听器，通过 readAndDispatch()方法从操作系统的事件队 列中读取事件，并将这些事件传递给相应的接受者（事件监听器）来完成具体的实现。

----

setToolTipText(String,string)设置组件提示性信息
setEnabled(boolen enable)设置组件是否可用状态

----

addSelectionListener(new SelectionAdapter())按钮被鼠标、键盘选中时，触发
addMouseListener(new MouseAdaper())鼠标双击 该组件时，触发
MessageDialog.openInformation()，它为 JFace 包中的信息提示对话框组件

-------------

