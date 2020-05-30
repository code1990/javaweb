#### 4.1 标签(Label 类) 

new Label(shell,SWT.NONE)：Label 实例化。参数 SWT.NONE 为 Label的默认样
setBounds(int x ,int y ,int width ,int height)：组件在窗体的绝对定位
setText(String string)设置组件的标签文字。

-----

getText()获取标签文字，
getImage()获取标签的图像。  
getAlignment()获取文本或图像显示方式(SWT.LEFT、SWT.CENTER、SWT.RIGHT)。
setText(String string)设置标签文字。  
setImage(Image image)设置标签的图像。  
setAlignment(int alignment)设置文本或图像如何显示。对齐方式为 SWT.LEFT、SWT.CENTER、SWT.RIGHT。

-----------------

#### 4.2 按钮(Button 类)

getText(String string)获取按钮文字
getAlignment()获取按钮如何显示
getImage()返回按钮上的图像
getSelecton()按钮被选中，返回 true；否则，返回 false
getText()获取按钮文字，当按钮没有设置标签文字或按钮样式为 SWT.ARROW 时 为空。  
setText(String string)设置按钮文字。  
setSelecton(Boolean selected)设置它的选择状态。  
addSelectionListener(SelectionListener listener )当某个 窗口部件被选中时通知监听集合
setAlignment(int alignment)设置按钮上定位方式。对 齐方式为：SWT.LEFT、SWT.CENTER、SWT.RIGHT。  
setImage(Image imaget)设置按钮图像。

----

#### 4.3 文本框(Text 类)

addSelectionListener(SelectonListener listener) 当某个窗口部件被选中时通知监听集合。
addModifyListener(ModifyListener listener) 当接收的文 本被修改时通知监听集合，
addVerifyListener(VerifyListener listener) 当接收的文 本检验无误时通知监听集合，
append(String string)添加字符串。  
insert(String string)插入字符串。  
copy()复制选中的文本。  
cut()剪切选中的文本。  
paste()从剪贴板上粘贴文本。  
getLineCount()返回文本中的行数。  
getLineHeight()返回文本中一行的高度（以像素为单位）。  
getOrientation()返回文本行的定位  
getText()获得文本内容。  
getSelectionText()获取选中的文本。  
getText(int start, int end)获取指定文本范围内的文本内容 
getTextLimit()获取限制文本字符串的位数。  
setEditable(boolean editable)设置状态不可用（此处为文本不可编辑）。  
setTextLimit(int limit)设置文本框最多能输入的字符数。  
setText(String string)设置接受者（这里指文本框）内的字符串。  
setEchoChar(char echo)设置为密码样式字符，如“*”。  
setOrientation(int orientation) 设置文本行的定位

---

#### 4.4 微调控制(Spinner 类)

addSelectionListener(SelectonListener listener) 当某个 窗口部件被选中时通知监听集合。
addModifyListener(ModifyListener listener) 当接收的文 本被修改时通知监听集合
copy()复制选中的文本。  
cut()剪切选中的文本。  
paste()从剪贴板上粘贴文本。  
getDigits()微调的小数值。  
getIncrement()获得对微调控制进行一次调节时，微调控制中的值增加或减少的量。  
getMinimum()微调所允许的最小值。
getMaximum()微调所允许的最大值。  
getSelection()微调当前的值。  
setDigits()设置微调的小数值。  
setIncrement()设置对微调控制进行一次调节时，微调控制中的值增加或减少的量。 
setMinimum()设置微调的最小值。 
setMaximum()设置微调的最大值。  
setSelection()设置微调当前值。 

----

#### 4.5 下拉框(Combo 类) 

add（String string）在下拉选项最后添加一项。  
add(String string, int index)在下拉选项的指定位置添加一项。  
addModifyListener(ModifyListener listener) 当接收的文 本被修改时通知监听集合
addSelectionListener(SelectonListener listener) 当接收者的选择改变时通知监听集合。
clearSelection()将下拉框文本域中的选择设置为空。  
copy()复制选中的文本。  
cut()剪切选中的文本。  
paste()从剪贴板上粘贴文本。  
deselect(int index)将下拉框中所指定的选项清除，index 为下拉框的下拉项索引。  
deselectAll()清除在下拉项中所选的选项（当前选项）。 
getItem(int index)获取接收者（这里是 Combo）下拉项中相对于零给定的索引选项。
getItemCount()获取下拉框的下拉选项的数量。  
getItems()获取下拉框的下拉选项的字符串数组。  
select(int index)将下拉框的第 index+1 项设置为当前项。  
setItem(int index, String string)在下拉框的下拉项的指定位置设置选项。  
setText(String string)设置当前选项。  
setItems(String[] items)用数组为下拉框设置下拉项。  
remove(int index)将下拉框中清除相对于零的给定索引对应的选项。  
removeAll()将下拉框中的所有下拉选项清除。 

------

#### 4.6 列表框(List 类) 

add（String string）在列表选项最后添加一项。  
add(String string, int index)在接收者（这里指 Combo）列表选项的指定位置添加一项。
addSelectionListener(SelectonListener listener) 当接收 者的选择改变时通知监听集合
deselect(int index)将接收者（这里是 List）中所指定的选项清除，index 为列表框的 列表项索引。  
deselectAll()清除接收者
deselect(int start, int end)将接收者（这里是 List）中所指定的选项范围清除
deselectAll()清除接收者。  
getItem(int index)获取接收者（这里是 List）列表项中相对于零给定的索引选项。  
getItemCount()获取接收者（这里是 List）列表选项的数量。  
getItems()获取接收者（这里是 List）列表选项的字符串数组。  
getSelection()获取接收者（这里是 List）当前所选中的列表项。  
getSelectionCount()获取接收者（这里是 List）当前所选中的列表项数量。  
remove(int index)将接收者（这里是 List）中清除相对于零的给定索引对应的选项。  
removeAll()将接收者（这里是 List）中的所有列表选项清除。  
remove(int start, int end)将指定范围内的列表项清除。  
setSelection(int index)设置接收者（这里是 List）相对于零的给定索引对应的选项。  
setSelection(String[] items)用数组设置列表框中的列表项。  
setSelection(int start, int end)在指定的列表项范围内设置列表项。 

---------------------

#### 4.7分组框(Group 类)

getClientArea() 返回 Group 的边界区域。  
getText() 获得分组框的标题。  
setText(String string) 设置分组框的标题

-----------

#### 4.8 面板(Composite)

getLayout() 得到容器的布局方式。  
layout() 将容器上的组件重新布局。  
getParent() 获得容纳 Composite 的容器。  
layout(boolean changed) 当参数为 true 时作用和 layout()相同。  
getShell() 获得容纳 Composite 的 Shell。  
setLayout(Layout layout) 设置 Composite 的布局方式。 

-----------------

#### 4.9 滚动面板(ScrolledComposite)

getContent() 获得 ScrolledComposite 上的内容。
getOrigin() 返回 ScrolledComposite 左上角当前显现内容的坐标点。  
setContent(Control content) 设置将要被滚动的内容。  
setLayout(Layout layout) 设置布局管理方式。  
setExpandHorizontal(boolean expand) 当expand 为true时，使ScrolledComposite上内容 在水平方向改变大小
setExpandVertical(boolean expand) 当 expand 为 true 时，使 ScrolledComposite 上内 容在垂直方向改变大小

----------------

#### 4.10 ViewForm

getClientArea() 获得 ViewForm 上添加的组件区域。 
getContent()获得控制的内容。  
getTopLeft()获取显示在 ViewForm 左上端的可控制组件在 ViewForm 位置（为 left）。
getTopRight()获取显示在 ViewForm 右上端的可控制组件在 ViewForm 位置（为 right）。  
getTopCenter()获取显示在 ViewForm 上端中间的可控制组件在 ViewForm 位置（为 center）。  
setContent(Control content)设置控制的内容。  
setLayout(Layout layout)设置布局方式。  
setBorderVisible(boolean show)设置边框是否可见，当为 true 时则可见。  
setTopLeft(Control control)设置 ViewForm 可控制的组件在 ViewForm 左上端显示。  
setTopRight(Control control)设置 ViewForm 可控制的组件在 ViewForm 右上端显示。
setTopCenter(Control control)设置 ViewForm 可控制的组件在 ViewForm 上端中间 显示。  
setTopCenterSeparate(boolean separate)当参数为 true 时，用 setTopCenter()方法设置 ViewForm 可控制的组件在ViewForm 上端分行显示

------------

### 对话框API

-----------

#### 6.1 Shell 类

addShellListener(ShellListener listener) shell 在接收者上进行操作时通知监听器集合
close()请求窗口管理器关闭
forceActive()强制窗口管理器激活Shell 窗口。
getBounds()返回用矩形表示窗体区域。
dispose()释放与接收者以及与其相关联的子类的操作系统资源。
getLocation()获取接收者（Shell 窗口）在显示器的位置。
getShell()获得接收者的shell。
getSize()获得接收者的大小。
isEnabled()如果接收者以及它的父类都处于可用状态，则返回true；
isVisible()如果接收者以及它的父类都处于可见（显示）状态，则返回true；
setActive()设置窗口管理器激活Shell 窗口。
setVisible(boolean visible)如果参数为true，标记接收者可见；否则为不可见。
setEnabled(boolean enabled)如果参数为true，接收者处于可用状态；
open()设置接收者的显示，将它标记为可见，并且请求窗口管理器激活Shell。

--------

#### 6.2 MessageBox 控件

getMessage() 获得对话框上的信息，如果对话框上没有设置信息则返回null。
open() 使对话框可见。
setMessage(String string) 设置对话框上提示信息。

----------------

#### 6.3 文件选择对话框

getFileName() 获取在对话框中选择的文件名。
getFilterPath() 获取过滤路径。
getText() 获得标题文字。
open() 打开对话框，使之可见。
setFilterPath(String string) 设置过滤路径。
setText(String text) 设置标题文字。
setFileName(String string) 当对话框打开时，设置初始的文件名。

setFilterExtensions (String[] extensions) 设置文件选择的限制类型。
setFilterNames (String[] names) 设置文件类型的说明性的文字。

----

#### 6.4 字体选择对话框

getFontData() 该方法笔者不赞成使用，用getFontList()方法代替。
getFontList() 返回FontData 对象数组，包括选择字体的信息。
getRGB() 获得当前在对话框中选择的颜色值。
getText() 获得对话框的标题信息。
setFontData(FontData fontData) 该方法笔者不赞成使用，用setFontList方法代替。
setRGB(RGB rgb) 设置对话框中字体颜色。
setText(String text) 设置对话框标题信息。
setFontList(FontData[] fontData) 在对话框中用fontData 对象设置被选择的字体信息。

---

#### 6.5 颜色选择对话框

getRGB() 获得当前选择的颜色值。
open() 打开对话框，使对话框可见。
setRGB(RGB rgb) 设置颜色对话框当前的颜色。

----------

#### 6.6 打印设置对话框

checkSubclass() 检查是否有子类。
getStartPage() 获得起始页。
getScope() 获得打印范围。
getEndPage() 获得打印的末页。
setScope(int scope) 设置打印的范围。
setStartPage(int startPage) 设置打印的起始页。
setEndPage(int endPage) 设置打印的末页。
open() 打开对话框，使之可见。

------------

#### 6.7 目录选择对话框

getFilterPath() 获得在目录选择对话框中选择的目录字符串。
getMessage() 获得以描述为目的在目录选择对话框上设置的描述信息。
open() 打开对话框，使之可见。
setFilterPath(String string) 在目录选择对话框中设置初始路径。
setMessage(String string) 在目录选择对话框上设置以描述为目的的信息。

----



