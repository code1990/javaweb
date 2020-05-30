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

### SWT 的复杂组件

---

#### 8.1 刻度条(Scale 类) 

addSelectionListener(SelectionListener listener)窗口小部件 被选中时通知监听器集合
getMinimum()获得接收者（这里指刻度条）所允许的最小值。   
getMaximum()获得接收者（这里指刻度条）所允许的最大值。  
getSelection()获得接收者（这里指刻度条）当前的值。  setIncrement()设置对刻度条进行一次调节时，刻度条中的值增加或减少的量。  setMinimum()设置接收者（这里指刻度条）的最小值。  
setMaximum()设置接收者（这里指刻度条）的最大值。  
setSelection()设置接收者（这里指刻度条）当前值。 

----

#### 8.2 滑动条(Slider 类) 

addSelectionListener(SelectionListener listener)窗口小部件 被选中时通知监听器集合  
getSelection()获得 Slider 的当前值。  
getMaximum()获得 Slider 的最大值。  
getMinimum()获得 Slider 的最小值。  
getEnabled()返回 Slider 是否可用。  
getThumb()获得滑动条滑块的大小。  
getIncrement()获得滑动条滑块滑动时的增加值（滑动的增量大小）。  
setSelection(int value)设置 Slider 的当前值。  
setEnabled(boolean enabled)将滑动条设置为不可用状态。  
setMaximum(int value)设置滑动条最大值。  
setMinimum(int value)设置滑动条的最小值。  
setThumb(int value)设置滑动条的滑块大小。 

---------

#### 8.3 进度条(ProgressBar 类) 

getMaximum()获得进度条的最大值。  
getMinimum()获得进度条的最小值。  
getSelection()获得进度条的当前值。  
setMaximum(int value)设置进度条的最大值。  
setMinimum(int value)设置进度条的最小值。  
setSelection(int value)设置进度条的当前值。 

-----

#### 8.4 扩展栏(ExpandBar 类、ExpandItem 类) 

**1．ExpandBar 常用 API**  
addExpandListener(ExpandListener listener) 扩展栏项 （Item）被展开或者闭合时通知监听器集合  
getItemCount()获得 ExapndItem 数量。  
getSpacing()获得接收者的空间。  
getItem(int index)获得定义的扩展栏项（ExandItem）定义的对象名称，参数从 0 开始。
indexOf(ExpandItem item)按参数查询扩展栏项，从头到尾直到查到为止，并返回扩 展项所在的位置索引。  
setSpacing(int spacing)设置接收者的空间。 
**2．ExpandItem 常用 API**  
getExpanded()如果扩展项被展开时，返回 true；否则返回 false。  
getHeight()获得扩展栏项的高度。  
setHeight(int height)设置扩展栏项的高度。  
setImage(Image image)在扩展栏项上设置图像。 
setText(String string)设置扩展栏项的标题文字。  
setExpanded(boolean expanded)设置扩展栏的状态，当参数为 false 时扩展栏处于闭合 状态；否则扩展栏处于展开状态。  setControl(Control control)当扩展栏展开时，使可控制组件显示。  
getParent()获得接收者的父类，这里是 ExpandBar

---------------

#### 8.5 选项卡(TabFolder 类、TabItem 类) 

**1．TabFolder 常用 API**  
addSelectionListener (SelectionListener listener) 当选项卡 选项被选中时
getItemCount()获得选项卡中包含的选项数。  
getItems()返回选项卡中项的 TableItem 数组。  getSelection()获得接收者中当前选中的 TabItem 数组。  
getSelectionIndex()获得接收者中当前选中选项相对于 0 的索引，若没有选中项则返 回?1。  
indexOf(TabItem item) 按参数查询选项卡选项，从头到尾直到查到为止，并返回选 项卡选项所在的位置索引（索引从 0 开始）。  
setSelection(int index)将给定索引对应的项设置为当前选项。 
**2．TabItem 常用 API**  
getControl()当用户选择选项卡选项时，返回填充在选项卡上客户区域的控件。  
getText()获得选项卡选项的标签文字。  
setToolTipText(String string)设置提示性的信息。 
setImage(Image image)在选项卡上设置图像。  
setText(String text)设置选项卡选项的标签文字。  
setControl(Control control)当用户选择选项卡选项时，设置用于填充在选项卡客户区 域的控件

-------------

#### 8.6 自定义选项卡(CTabFolder 类、CTabItem 类) 

1．CTabFolder 常用 API  
addCTabFolder2Listener(CTabFolder2Listener listener) 将监听器添加到监听集合，当 自定义选项卡选项被关闭、最大化、最小化、恢复时通知给监听器。  
addSelectionListener(SelectionListener listener)添加监听器给接收事件。  
getBorderVisible()如果接收者边框可见，则返回 true。  
getClientArea()获得 CTabFolder 上用矩形描述的客户区域。  getItem(int inde)获得按照相对于零的给定索引对应选项。  
getItemCount()获得自定义选项卡中包含的选项数。  
getItems()返回接收者中项的 CTabItem 数组。  
getSelection()获得当前选中的 CTablItem 数组，如果没有选中项，则返回 null。  
getSelectionIndex()返回接收者中当前选中项相对于 0 的索引，如果没有选中，则返 回?1。  
getTabHeight()获得选项卡的高度。  
getMaximized()如果接收者被最大化，则返回 true。  
getMaximizeVisible()如果最大化按钮可见，则返回 true。  
getMinimized()如果接收者被最小化，则返回 true。  
getMinimizeVisible()如果最小化按钮可见，则返回 true。 
indexOf(CTabItem item) 按参数查询自定义选项卡选项，从头到尾直到查到为止，并 返回选项卡选项所在的位置索引（索引从 0 开始）。  
setBackground(Color color)设置接收者的背景颜色。  
setBorderVisible(boolean show)如果参数为 true 时，则选项卡的边界可见；否则不 可见。  
setForeground(Color color)设置接收者的前景颜色。  
setLayout(Layout layout)设置布局方式。  
setMaximized(boolean maximize)设置接收者的最大化状态。  
setMaximizeVisible(boolean visible)如果参数为 true 时，则标志着接收者的最大化按 钮可见；否则不可见。  
setMinimized(boolean minimize)设置接收者的最小化状态。  
setMinimizeVisible(boolean visible) 如果参数为 true 时，则标志着接收者的最小化按 钮可见；否则不可见。  
setTabHeight(int height)设置 CTabitem 固定的高度。  
showItem(CTabItem item)显示 Item。 

2．CTabItem 常用 API  getControl()当用户选择选项卡选项时，返回用于填充选项卡客户区域的控件。  
getToolTipText()获得接收者的提示性的标签，如果没有设置提示性标签，则返回 null。
setToolTipText(String string)设置提示性的标签文字。  
setText(String string)设置接收者文本（标签文字）。  
setImage(Image image)设置接收者的图像。  
setControl(Control control)当用户选择选项卡选项时，设置用于填充选项卡客户区域 的控件。 

--------------

#### 8.7 分割框格(Sash 类) 

addSelectionListener(SelectionListener listener) 将监听器添加到监听集合，当控件 被选中时，
removeSelectionListener(SelectionListener listener)当控件被选中时，通知监听集合将 监听器从监听器集合中移除

----

#### 8.8 分割窗(SashForm 类) 

getStyle()获得分割窗样式信息。  
getOrientation()获得分割窗的分割方式。  
getMaxmimizedControl()获得当前最大化组件。  
setLayout(Layout layout)设置布局方式。  
setOrientation(int orientation)设置 SashForm 的定位。可用值为 SWT.HORIZONTAL、 SWT.VERTICAL。  
setMaximizedControl(Control control)设置 SashForm 上组件的最大化  
setBackground(Color color)设置 SashForm 的背景颜色。  
setForeground(Color color)设置 SashForm 的前景颜色。  
setWeights()方法用来设置分割窗被分割的部分之间宽度或高度的比例。 

---------------

#### 8.9 画布(Canvas 类) 

drawBackground(GC gc, int x, int y, int width, int height)给接收者设置背景，按照参数 在矩形内部填充。 
getCaret()获得接收者的光标。  
setCaret(Caret caret)设置接收者的光标。

----

#### 8.10 菜单（Menu 类、MenuItem 类） 

1．Menu 常用 API  
addHelpListener(HelpListener listener)当控件产生帮 助事件时通知监听器集合
addMenuListener(MenuListener listener)当菜单隐藏 或者显示时通知监听器集合
getDefaultItem()获得默认的菜单项，如果没有设置则为 null。  
getEnabled()如果接收者可用，则返回 true；否则，返回 false。  
getItem(int index)获得接收者相对于 0 给定索引对应的项。  
getItemCount()获得接收者包括的项数量。  
getItems()返回接收者中菜单项的数组。  
getVisible()如果接收者可见，则返回 true；否则返回 false。  
indexOf(MenuItem item) 按参数查询菜单选项，从头到尾直到查到为止，并返回菜 单选项所在的位置索引（索引从 0 开始）。  
isEnabled()如果接收者和接收者祖先均可用，则返回 true；否则，返回 false。  
isVisible()如果接收者和接收者祖先均可见，则返回 true；否则，返回 false。  
setEnabled(boolean enabled)如果参数为 true，则接收者可用；否则，不可用。  
setVisible(boolean visible)如果参数为 true，则接收者可见；否则，不可见。 
2．MenuItem 常用 API  
addArmListener(ArmListener listener)当菜单被选中 时通知监听器接口集合 
addHelpListener(Help Listener listener) 当控件产生帮助事件时通知监听器集合
addSelectionListener(SelectionListener listener) 当菜单项被选中时通知监听器集合  
getAccelerator()获得菜单的快捷键。  
getEnabled()如果菜单项可用，则返回 true；否则，返回 false。  
getImage()返回菜单项上的图像。  
getParent()返回接收者（菜单项）的父控件，它一定是菜单。  
getSelection()如果选中接收者（菜单项），则返回 true；否则，返回 false。  
getText()返回菜单项的标签文字。  
setText(String text)设置菜单项的标签文字。  
setSelection(boolean selected)设置接收者的状态，参数为 true，则选中。  
setImage(Image image)为菜单项设置显示的图像。  
setEnabled(boolean enabled)如果参数为 true，则菜单项可用；否则，不可用。  
setAccelerator(int accelerator)设置快捷键。  
isEnabled()如果菜单项和它的所用祖先处于可用状态，则返回 true；否则，不可用。

-----------------

#### 8.11 工具栏(ToolBar 类、ToolItem 类) 

（1）ToolBar 常用 API  
getItem(int index)获得工具栏项中相对于 0 给定的索引对应的工具项。  
getItemCount()获得工具栏上的工具项数。  
getItems()获得工具栏中项的 ToolItem 数组。  
indexOf(ToolItem item)按参数查询工具栏项，从头到尾直到查到为止，并返回工具 栏项所在的位置索引（索引从 0 开始）。 
（2）ToolItem 常用 API  
addSelectionListener (SelectionListener listener) 当工具栏 项被选中时  
getBounds()返回一个相对于它的父项用矩形描述接收者的大小和位置。  
getEnabled()如果接收者可用，则返回 true；否则，返回 false。  
getParent()获得接收者的父项，这里一定是 ToolBar。  
getSelection()如果接收者被选中，则返回 true；否则，返回 false。  
getText()获得工具栏项（ToolItem）的标签文字，如果没设置则返回 null。  
getToolTipText()获得工具栏项（ToolItem）的提示性文字。  
getWidth()获得接收者（工具栏项）的宽度。  
isEnabled()如果接收者和它的祖先均可用，则返回 true；否则，返回 false。  
setEnabled(boolean enabled)当参数为 true 时，工具栏项可用；否则，不可用。  
setImage(Image image)设置工具栏上显示的图像。  
setText(String text)设置工具栏工具项的标签文字。  
setToolTipText(String toolTipText)设置提示性的文字。  
setWidth(int width)设置工具项的宽度。 

---------------

#### 8.12 动态工具栏（CoolBar 类、CoolItem 类） 

（1）CToolBar 常用 API  
getItem(int index) 获得动态工具栏项中相对于 0 给定的索引对应的工具项。  
getItemCount()获得动态工具栏上的工具项数。  
getLocked()返回工具栏是否被锁定。 
indexOf(CoolItem item) 按参数查询动态工具栏项，从头到尾直到查到为止，并返回 动态工具栏项所在的位置索引（索引从 0 开始）。  
setLocked(boolean locked)设置是否锁定动态工具栏。 
（2）CoolBarItem 常用 API  
addSelectionListener (SelectionListener listener) 当动态工 具栏项被选中时
getBounds()返回一个相对于它的父项用矩形图形描述接收者的大小和位置。  
getControl()返回与 CoolItem 关联的组件。  
getParent()获得接收者的父项，这里一定是 CoolBar。  
setSize(int width, int height) 用给定的参数设置接收者的大小。  
setControl(Control control)设置与接收者关联的控件。 

---------

#### 8.13 表(Table 类、TableItem 类、TableColumn 类) 

1．Table 常用 API  
addSelectionListener (SelectionListener listener)当接 收者选择改变时通知监听器集合 
clear(int index)清除接收者中相对于 0 的给定索引对应的项。  clearAll()清除接收者中所有的项。  
deselectAll()取消接收者中所选中的项。  
getColumnCount()获得接收者包括的所有列的数量。  
getSelectionCount()获得接收者中包括的选中项数量。  
deselect(int index)取消接收者中相对于 0 的给定索引对应的项。  
getColumns()  getColumn(int index)获得接收者相对于 0 的给定索引对应的项。  
setHeaderVisible(boolean show)设置接收者的标题标记是否可见，当参数为 true 时， 则可见；否则，不可见。  
setLinesVisible(boolean show) 设置接收者的行标记是否可见，当参数为 true 时，则 可见；否则，不可见。  
setTopIndex(int index)设置接收者中当前最顶层项相对于 0 的索引。  
selectAll()选择接收者的所有项。  
select(int index)选择接收者中相对于 0 的给定索引对应的项。  
removeAll()移除所有项。  
remove(int index)移除接收者中相对于 0 的给定索引对应的项。  
setSelection(TableItem[] items)将接收者的选择设置为给定项的数组。  
setSelection(TableItem item) 将接收者的选择设置为给定项。 
2．TableItem 常用 API  
getBackground()获得接收者的背景颜色。  
getBackground(int index)获得接收者中按照给定列索引的背景颜色。  
getForeground()获得接收者的前景颜色。  
getForeground(int index) 获得接收者中按照给定列索引的前景颜色。  
getImage()获得接收者的图像。  
getParent()获得接收者的父项，这里一定是 Table。  
getText(int index)获得接收者中按照给定列索引的文本。  
setBackground(Color color)设置接收者的背景颜色。  
setForeground(Color color)设置接收者的前景颜色。  
setGrayed(boolean grayed)如果表项是 Checkbox 样式，则设置为灰度。 
setImage(Image image)设置接收者的图像，设置在第一列。  
setImage(Image[] images)为表的多个列设置图像。  
setText(String string)设置接收者的标签文字。  
setText(String[] strings)为表的多个列设置标签文字。 
3．TableColumn 常用 API  
addControlListener (ControlListener listener)当控件被移动 或改变时通知给监听集合
addSelectionListener (SelectionListener listener) 当控件被 选中时通知给监听集合
getAlignment()获得列的对齐方式：SWT.LEFT、SWT.CENTER、SWT.RIGHT。  
setAlignment(int alignment)设置列的对齐方式：SWT.LEFT、SWT.CENTER、 SWT.RIGHT。  
setText(String string)设置列的标签文本。  
setWidth(int width)设置列宽度。  
setToolTipText(String string)设置提示性的信息。 

#### 8.14  树（Tree 类） 

1．Tree 常用 API  
addSelectionListener (SelectionListener listener)当接 收者选择改变时通知监听器集合 
addTreeListener (TreeListener listener) 当接收者一项 被展开或者收缩时通知监听器集合
clearAll(boolean all)清除接收者的所有项。  
clear(int index, boolean all)从接收者中清除相对于 0 的给定索引对应的项。  
deselectAll()取消接收者中的所有选中项。  
showItem(TreeItem item)在 tree 中显示 TreeItem 项。  
showSelection()在 tree 中显示选中的 TreeItem 项。  
getItemCount()获得 tree 的所有项的数量。  
selectAll()选中接收者的所有项。  
setTopItem(TreeItem item)设置接收者当前位于顶层的项。 
2．TreeItem 常用 API  clearAll(boolean all)清除接收者的所有项。  
clear(int index, boolean all)从接收者中清除相对于 0 给定索引对应的项。  
getBackground()获得接收者的背景颜色。  
getForeground()获得接收者的前景颜色。  
getExpanded()如果接收者处于展开状态，则返回 true；否则，返回 false。  
getItemCount()获得接收者包含的直接子项的数量。  
getGrayed()如果接收者处于灰度状态，则返回 true；否则，返回 false。  
getItem(int index)从接收者中获得相对于 0 给定索引对应的项。  
getParentItem()获得接收者的父项，这里一定是 Tree。 
setText(String text)设置接收者的标签文字。  
setGrayed (boolean grayed)设置接收者的灰度状态。  
setForeground (Color color)设置接收者的背景颜色。  
setExpanded (boolean expanded)设置接收者的展开状态。  
setImage(Image image)设置接收者的图像。 

#### 8.15 表格树(TableTree 类、TableTreeItem 类） 

（1）TableTree 常用 API  
addSelectionListener (SelectionListener listener)当接 收者选择改变时通知监听器集合  
addTreeListener (TreeListener listener) 当接收者的一
项展开或者收缩时通知监听器集合  
deselectAll()取消接收者的所有项。  
getBackground()获得接收者的背景颜色。  
getEnabled()如果接收者可用，则返回 true；否则，返回 false。  
getForeground()获得接收者的背景颜色。  
getItemCount()获得 TableTree 包含项的数量。  
getItemHeight()获得 TableTree 包含一项的高度。  
getStyle()获得 TableTree 的样式风格。  
getTable()获得下层的表。  
removeAll()移除 TableTree 中所有的项。  
selectAll()选中接收者的所有项。  
setBackground(Color color)设置接收者的背景颜色。  
setEnabled(boolean enabled)将接收者设置为是否可用，当参数为 true 时则可用；否 则将不可用。  
setForeground(Color color) 设置接收者的前景颜色。  
setMenu(Menu menu)设置接收者的 pop-up 式菜单。  
showItem(TreeItem item)在 Tabletree 中显示 TableTreeItem 项。  
showSelection()在中 Tabletree 显示选中的 TableTreeItem 项。 
（2）TableTreeItem 常用 API  
getBackground()获得接收者的背景颜色。  
getExpanded()如果接收者展开，则返回 true；否则，则返回 false。  
getForeground()获得接收者的前景颜色。  
getImage()获得第一个图像。  
getImage(int index)从接收者中获得相对于 0 的给定索引对应的图像。  
getText()获得接收者的标签文字。  
setForeground(Color color)设置接收者的前景颜色。  
setBackground(Color color)设置接收者的背景颜色。  
setImage(Image image)设置图像。  
setExpanded(boolean expanded)设置展开状态。 

----------------------------

#### 9.1 浏览器部件(Browser 类)

stop()停止载入当前页。 
setUrl(String url)装载一个 URL。  
refresh()刷新当前页。  
back()返回到先前的历史页。  
getUrl()获得浏览器当前的 URL。  
forward()返回下一个历史页。  
refresh()刷新当前页。  
isBackEnabled()如果返回 true 说明 back 功能可用，否则不可用。  
isForwardEnabled()如果返回 true 说明 forward 功能可用，否则不可用。 

----

#### 9.2 链接控件(Link 类) 

addSelectionListener (SelectionListener listener)当接 收者选择改变时通知监听器集合  
getText()获得接收者文本。  
computeSize(int wHint, int hHint, boolean changed)返回接收者的首选大小。  
setText(String string)设置接收者文本

-----

#### 9.3 Tracker 控件

addControlListener(ControlListener listener)当控件被 移动或改变大小时通知监听器集合
addKeyListener(KeyListener listener) 当系统键盘按 下或释放时通知监听器集合  
close()停止显示矩形轨迹。  
open()显示矩形轨迹。  
getRectangles()返回被画矩形的边框。  
setCursor(Cursor newCursor)设置 Tracker 的鼠标游标。  
setRectangles(Rectangle[] rectangles)设置矩形轨迹。

----

#### 9.4 剪贴板(Clipboard 类)

clearContents()如果剪贴板上的数据在系统剪贴板上，则清除其内容。  
clearContents(int clipboards) 如果剪贴板上的数据在指定剪贴板上，则清除其内容。
dispose()释放与剪贴板相关联的操作系统资源。  
getAvailableTypes()在系统剪贴板上获得当前可用的数组类型。  
getAvailableTypes(int clipboards) 在指定的剪贴板上获得当前可用的数组类型。   
isDisposed()如果剪贴板被释放，则返回 true；否则返回 false。  
setContents(Object[] data, Transfer[] dataTypes)在系统剪贴板上放置指定类型数据。  
setContents(Object[] data, Transfer[] dataTypes, int clipboards) 在指定剪贴板上放置指 定类型数据。 

---

#### 9.5 拖放（DragSource 类、DropTarget 类）

1．DragSource 常用 API  
addDragListener(DragSourceListener listener) 当进行 拖放时通知监听器集合
getControl()获得注册在拖放源（DragSource）上的控件。  
setTransfer(Transfer[] transferAgents)设置能用 DragSource 转移的指定数据类型的清单。 
2．DragTarget 常用 API  
addDropListener(DropTargetListener listener) 当进行 拖放时通知监听器集合
getControl()获得注册在拖放目标（DragTarget）上的控件。  
setTransfer(Transfer[] transferAgents) 设置能用 DragTarget 转移的指定数据类型的清单

------------

#### 9.6 图形上下文(GC 类) 

getStyle()获得接收者的样式信息。  
isDisposed()如果 GC 被释放，则返回 true；否则，返回 false。  
setBackground(Color color)设置接收者背景颜色。  
setBackgroundPattern(Pattern pattern)设置背景模式。  
setForeground(Color color)设置接收者背景颜色。  
setForegroundPattern(Pattern pattern)设置前景颜色。  
drawImage(Image image, int x, int y)在接收者中按给定的坐标画一个给定的图像。  
drawLine(int x1, int y1, int x2, int y2)画一条线。参数为所画线起点的横纵坐标和终点 的横纵坐标。  
drawOval(int x, int y, int width, int height)画一个椭圆。参数为所画椭圆的圆心坐标及 宽和高的数值。  drawPath(Path path)按参数画一个路径。  
drawString(String string, int x, int y)画一个字符串。  
drawPoint(int x, int y)画个点。参数为该点的坐标。  
drawRectangle(int x, int y, int width, int height)画一个矩形。  
fillOval(int x, int y, int width, int height)在椭圆内部填充。 
fillPath(Path path)填充路径。  
fillRectangle(int x, int y, int width, int height)在矩形内部填充。 

-----

#### 9.7 颜色(Color 类)

dispose()释放与 Color 相关联的操作系统资源。  
getBlue()获得蓝颜色值（颜色值在 0-255 之间）。  
getGreen()获得绿颜色值（颜色值在 0-255 之间）。  
getRed()获得红颜色值（颜色值在 0-255 之间）。  
isDisposed()如果颜色值被释放，则返回 true；否则，返回 false。 

------

#### 9.8 字体(Font 类) 

1．Font 常用 API  
dispose()释放与 Font 相关联的操作系统资源。  
isDisposed()如果字体被释放，则返回 true；否则，返回 false。  
getFontData()获得表示接收者的 FontData 数组。 
2．FontData 常用 API  
getHeight()获得接收者的高度。  
getLocale()获得接收者的位置。  
getName()获得接收者的名字。  
getStyle()获得接收者的样式。  
setHeight(int height)设置接收者的高度。  
setLocale(String locale)设置接收者的位置。  
setName(String name)设置接收者的名字。  
setStyle(int style)设置接收者的样式。 

-----

#### 9.9 图像(Image 类)

dispose()释放与 Image 相关联的操作系统资源。  
getBackground()获得背景颜色。  
getBounds()获得接收者的边框。  
isDisposed()如果 Image 被释放，则返回 true；否则，返回 false。  
setBackground(Color color)设置背景颜色。  

---

#### 9.10 文本风格(StyledText 类) 

append(String string)显示文本信息。  
copy()拷贝被选择的文本到剪贴板。  
copy(int clipboardType)拷贝被选择的文本到指定的剪贴板。  
cut()移动被选择的文本到剪贴板。 
getBackground()获得接收者的背景颜色。  
getEditable()返回接收者的内容是否可编辑。  
getForeground()获得接收者的前景颜色。  
setTextLimit(int limit)设置文本限制的字符数。  
setText(String text)设置文本内容。  
setSelectionRange(int start, int length)设置选择范围。  
setStyleRange(StyleRange range)设置指定的样式。  
setSelectionForeground(Color color)设置选择的前景颜色。  
setSelectionBackground(Color color) 设置选择的背景颜色。  
setCaret(Caret caret)设置接收者的光标。  
setFont(Font font)设置给定文本的字体。  
setLineBackground(int startLine, int lineCount, Color background)设置制定线段的背景 颜色。  
setOrientation(int orientation) 设 置 接 收 者 的 定 位 （ SWT.LEFT_TO_RIGHT 、 SWT.RIGHT_TO_LEFT）。  
setTopIndex(int topIndex)设置顶部索引。  
setWordWrap(boolean wrap)设置是否可以折行。  
setDoubleClickEnabled(boolean enable)设置是否窗口控件执行鼠标双击行为。  
setEditable(boolean editable)设置窗口内容可以被编辑。 

----

#### 9.11 系统托盘(Tray 类、TrayItem 类) 

1．Tray 常用 API  
getItem(int index)获得接收者中相对于 0 的给定索引对应的项。  
getItemCount()获得接收者中包含项的数量。  
getItems()返回 TrayItem 数组。 
2．TrayItem 常用 API  
addSelectionListener(SelectionListener listener) 当接 收者被选中时通知监听器集合  
getToolTipText()获得提示性的标签文字。  
getVisible()如果接收者可见，则返回 true；否则，返回 false。  
setImage(Image image)设置接收者的图像。  
setToolTipText(String value)设置接收者的提示性标签。  
setVisible(boolean visible)设置接收者是否可见，如果参数为 true，则可见；否则， 不可见。

----

#### 9.12 鼠标游标(Cursor 类) 

dispose()释放与 Cursor 相关联的操作系统资源。 

 isDisposed()如果 Cursor 对象被释放，则返回 true；否则，返回 false。 

 win32_new(Device device, int handle)执行平台指定功能部署的鼠标游标。 

----------------

#### 12.1  TextViewer 类、SourceViewer 类 

1．TextViewer 常用 API  
addTextInputListener(ITextInputListener listener)添加输入文本监听器。  
addTextListener(ITextListener listener) 添加文本监听器。  
canDoOperation(int operation)返回由给定的操作代码是否能执行指定操作。  
copyMarkedRegion(boolean delete)拷贝/粘贴标记区域。  
disableRedrawing()不能重绘 TextViewer。  
doOperation(int operation)操作代码在目标上执行指定的操作。  
enabledRedrawing()使 TextViewer 能重绘。  
enableOperation(int operation, boolean enable)使给定的文本能够被操作或不能被操 作。参数 enabel 为 true 表示能够被操作；否则不能被操作。  
getDocument()获得 TextViewer 的输入文档。  
getSelectedRange()获得在查看器的文档坐标中的当前选择范围。  
getSelection()获得提供者的当前选择。  
getUndoManager()获得查看器的 Undo 管理器。  
getVisibleDocument()获得查看器的可见文档。  
setDocument(IDocument document)将给定的文档设置为文本查看器模型，并更新相 应的表达式。  
setEditable(boolean editable)设置可编辑状态。  
setInput(Object input)设置或清除查看器。  
setRedraw(boolean redraw)启用/禁用文本查看器的重绘。  
setSelectedRange(int selectionOffset, int selectionLength)设置选择的指定范围。  
setSelection(ISelection selection, boolean reveal)为查看器设置新的选择，并选择性的 使它可见。  
setTextColor(Color color)将给定颜色作为前景色应用到查看器的选择。  
setUndoManager(IUndoManager undoManager)设置查看器的 undo 管理器。 
 setVisibleDocument(IDocument document)设置查看器的文档可见。 
2．SourceViewer 常用 API  
createControl(Composite parent, int styles)建立查看器的窗口部件。  
doOperation(int operation) 操作代码在目标上执行指定的操作。  
enableOperation(int operation, boolean enable)启用/禁止给定文本操作。  
getVerticalRuler()获得垂直标尺。  
handleDispose()释放在查看器上部署的所有资源。  
rememberSelection()记住并且返回当前选择。  
setDocument(IDocument document)将给定的文档设置为文本查看器模型，并更新相 应的表达式。 

-----------------------

#### 12.2  TableViewer 类 

add(Object element)将指定元素添加到表格查看器（TableViewer）。  
add(Object[] elements)将指定元素添加到表格查看器（TableViewer）。  
cancelEditing()取消当前活动的单元格编辑器。  
clear(int index)清除指定索引的表项。  
editElement(Object element, int column)开始编辑指定元素。  
getCellEditors()返回表格查看器的单元格编辑器。  
getCellModifier()返回表格查看器的单元格修改器。  
getColumnProperties()返回表格查看器的列属性。  
getElementAt(int index)从表格查看器中获得给定索引的元素。  
getTable()获得表格查看器的表控件。  
insert(Object element, int position)将给定元素插入到表格查看器的给定位置。  
remove(Object element)从表格查看器中移除给定元素。  
remove(Object[] elements) 从表格查看器中移除给定元素。  
setCellEditors(CellEditor[] editors)设置表格查看器的单元格编辑器。  
setCellModifier(ICellModifier modifier)设置表格查看器的单元格修改器。  
setColumnProperties(String[] columnProperties)设置表格查看器的单元格列属性。 

------------------

getElements(Object inputElement)当查看器的输入设置为给定元素时，返回查看器显 示的元素。  
dispose()释放资源，即释放这个内容提供器。  
inputChanged(Viewer viewer, Object oldInput, Object newInput)通知这个内容提供器， 已给定的查看器的输入已经被切换到不同的元素
getColumnText(Object element, int columnIndex)返回给定元素的给定列的标签文本。  
getColumnImage(Object element, int columnIndex) 返回给定元素的给定列的图像文本。  
addListener(ILabelProviderListener listener)添加标签提供器的监听器。  
dispose()释放标签提供器。  
isLabelProperty(Object element, String property)返回给定元素的给定属性被改变时， 标签是否将被影响。  
removeListener(ILabelProviderListener listener)移除标签提供器的监听器
setColumnProperties(String[] columnProperties)设置 TableViewer 的列属性。  
setCellEditors(CellEditor[] editors)设置 TableViewer 的单元格编辑器。  
setCellModifier(ICellModifier modifier)设置 TableViewer 的单元格修改器
表格单元编辑器（CellEditor）通过数组来实现，并且数组的索引号与表格的列号一一对 应。TextCellEditor 类实现文本单元格编辑；ComboBoxCellEditor 类实现以列表框样式进行编 辑；ColorCellEditor 类实现颜色值的编辑。  
setColumnProperties(String[] columnProperties)设置 TableViewer 的列属性。  
setCellEditors(CellEditor[] editors)设置 TableViewer 的单元格编辑器。  
setCellModifier(ICellModifier modifier)设置 TableViewer 的单元格修改器。 
ICellModifier 用来检查模型元素是否可被修改；恢复一个模型元素的属性值；存储一个 单元编辑值返回模式元素的属性。  
canModify(Object element, String property)检查给定元素的给定属性是否能被修改。 如果能被修改，则返回 true；否则，返回 false。  
getValue(Object element, String property)返回给定元素的给定属性值。如果给定元素 没有给定属性，则返回 null。  
modify(Object element, String property, Object value)修改给定元素的给定属性值。
查看过滤器（ViewerFilter）用于显示内容提供器提供返回对象的子集。 
select(Viewer viewer, Object parent, Object element)返回给定元素是否可以通过过滤。 
查看排序器（ViewerSort）用来对内容提供器提供的内容元素进行排序。  
compare(Viewer viewer, Object e1, Object e2)比较第一个元素与第二个元素是小于还是等 于或大于，将对应返回负数、零或正数。 

-------------------

#### 12.3  ListViewer 类 

getList()获得列表查看器的下拉列表控件。  
reveal(Object element)确定给定元素是可见的，必要时可滚动查看器。  
getControl()获得与这个查看器相关的控件。  
listRemoveAll()移除所有的项。

---

12.4  TreeViewer 类 

editElement(Object element, int column)开始编辑给定元素。  
getCellEditors()获得这个树查看器的单元编辑器。  
getCellModifier()获得这个树查看器的单元修改器。  
getControl()获得与这个查看器相关的控件。  
getTree()获得树查看器的树控件。  
getExpanded(Item item)返回给定的 SWT 项是否展开或收缩。  
showItem(Item item)显示给定项。  
isExpandable(Object element)返回代表给定元素的树的节点是展开还是收缩。  
setSelection(List items)设置选择给定的列表项。  
setCellEditors(CellEditor[] editors)为树查看器设置单元格编辑器。  
removeAll(Control widget)从给定的控件中移除所有项。  
setCellModifier(ICellModifier modifier)为树查看器设置单元格修改器。  
setLabelProvider(IBaseLabelProvider labelProvider)设置标签提供器。  
setExpanded(Item node, boolean expand)设置给定项的展开状态。 

