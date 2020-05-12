#### 01 Activiti介绍与搭建开发环境

idea插件安装


#### 02 运行官方例子
流程创建地址
http://localhost:8080/activiti-app admin/test
流程管理
http://localhost:8080/activiti-admin admin/admin
流程服务接口
http://localhost:8080/activiti-rest



#### 03 编写第一个Activiti程序

1设计流程
2配置流程引擎
3加载流程文件
4启动流程
```scala

public class First {
	public static void main(String[] args)  {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务组件
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 获取流程任务组件
		TaskService taskService = engine.getTaskService();
		// 部署流程文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/First.bpmn").deploy();
		// 启动流程
		runtimeService.startProcessInstanceByKey("process1");
		// 查询第一个任务
		Task task = taskService.createTaskQuery().singleResult();
		System.out.println("第一个任务完成前，当前任务名称：" + task.getName());
		// 完成第一个任务
		taskService.complete(task.getId());
		// 查询第二个任务
		task = taskService.createTaskQuery().singleResult();
		System.out.println("第二个任务完成前，当前任务名称：" + task.getName());
		// 完成第二个任务（流程结束）
		taskService.complete(task.getId());
		task = taskService.createTaskQuery().singleResult();
		System.out.println("流程结束后，查找任务：" + task);
		// 退出
		System.exit(0);
	}
}

```


#### 04 流程引擎配置与服务组件

默认配置文件activiti.cfg.xml

指定配置文件

```java
// 指定配置文件创建ProcessEngineConfiguration
ProcessEngineConfiguration config = ProcessEngineConfiguration
	.createProcessEngineConfigurationFromResource("my-activiti1.xml");
```

指定配置文件和配置bean

```java
ProcessEngineConfiguration config = ProcessEngineConfiguration
		.createProcessEngineConfigurationFromResource(
				"my-activiti2.xml", "test");
```

数据源配置

dbcp
c3p0

数据库策略配置

false
true 默认
create-drop
drop-create

其他属性配置

history：请看history-config项目
asyncExecutorActivate 异步执行器
邮件服务器



服务组件

RepositoryService：提供一系列管理流程定义和流程部署的API。
RuntimeService：在流程运行时对流程实例进行管理与控制。
TaskService：对流程任务进行管理，例如任务提醒、任务完成和创建任务分本任务等。
IdentityService：提供对流程角色数据进行管理的API，这些角色数据包括用户组、用户以及它们之间的关系。
ManagementService：提供对流程引擎进行管理和维护的服务。
HistoryService：对流程的历史数据进行操作，包括查询、删除这些历史数据。
DynamicBpmnService：使用该服务，可以不需要重新部署流程模型，就可以实现对流程模型的部分修改。




#### 05 Activiti数据库介绍

数据表概述

ACT_GE: general
ACT_RE: repository
ACT_ID: identity
ACT_RU: runtime
ACT_HI: history
ACT_DMN

==Activiti6.0表结构.md==


#### 06 API（1）Activiti数据查询Query

```java

ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        IdentityService is = engine.getIdentityService();
//保存用户组
Group group = is.newGroup("1");
group.setName("Group_1");
group.setType("TYPE_1");
is.saveGroup(group);
//获取一个List
List<Group> groups = is.createGroupQuery().list();
//分页查询List
List<Group> groups = is.createGroupQuery().listPage(1, 5);
//获取一个count
long size = is.createGroupQuery().count();
//设置排序
List<Group> groups = is.createGroupQuery().orderByGroupId().desc().orderByGroupName().asc().list();
//单一记录
Group g = is.createGroupQuery().groupName("Group_0").singleResult();
//本地化查询
List<Group> groups = is.createNativeGroupQuery()
                .sql("SELECT * FROM ACT_ID_GROUP where NAME_ = #{name}")
                .parameter("name", "Group_2").list();
//给定字段查询
List<Group> groups = is.createGroupQuery().groupName("Group_1").groupType("TYPE_1").list();
        engine.close();
```

#### 07 API（2）流程文件部署DeploymentBuilder
addClasspathResource
addInputStream
addString
addZipInputStream
addBpmnModel
addBytes
deploy

```java
ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
// 存储服务
RepositoryService rs = engine.getRepositoryService();

DeploymentBuilder builder = rs.createDeployment();

FileInputStream fis = new FileInputStream(new File("resource/datas.zip"));
ZipInputStream zis = new ZipInputStream(fis);
//1添加一个压缩文件
builder.addZipInputStream(zis);

//2添加一个Bpmn模型
builder.addBpmnModel("My Process", createProcessModel());

//部署文件
builder.deploy();
```

```java
//创建Bpmn模型的方法
private static BpmnModel createProcessModel() {
        // 创建BPMN模型对象
        BpmnModel model = new BpmnModel();
        // 创建一个流程定义
        org.activiti.bpmn.model.Process process = new org.activiti.bpmn.model.Process();
        model.addProcess(process);
        process.setId("myProcess");
        process.setName("My Process");
        // 开始事件
        StartEvent startEvent = new StartEvent();
        startEvent.setId("startEvent");
        process.addFlowElement(startEvent);
        // 用户任务
        UserTask userTask = new UserTask();
        userTask.setName("User Task");
        userTask.setId("userTask");
        process.addFlowElement(userTask);
        // 结束事件
        EndEvent endEvent = new EndEvent();
        endEvent.setId("endEvent");
        process.addFlowElement(endEvent);
        // 添加流程顺序
        process.addFlowElement(new SequenceFlow("startEvent", "userTask"));
        process.addFlowElement(new SequenceFlow("userTask", "endEvent"));
        return model;
    }
```

```java

ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
// 存储服务
RepositoryService rs = engine.getRepositoryService();
DeploymentBuilder builder = rs.createDeployment();
//格式错误文件处理
builder.addClasspathResource("error/schema_error.bpmn");
//格式错误流程关闭验证
builder.disableSchemaValidation();
//流程错误文件处理
builder.addClasspathResource("error/bpmn_error.bpmn");
//关闭验证流程是否错误
builder.disableBpmnValidation();
builder.deploy();
```

查询部署资源

```java
ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
// 存储服务
RepositoryService rs = engine.getRepositoryService();

DeploymentBuilder builder = rs.createDeployment();
builder.addClasspathResource("my_text.txt");
Deployment dep = builder.deploy();
// 查询文件 begin
InputStream is = rs.getResourceAsStream(dep.getId(), "my_text.txt");
int count = is.available();
byte[] contents = new byte[count];
is.read(contents);
String result = new String(contents);
//查询文件 end

// 部署一份流程文件 查询流程文件
Deployment dep = repositoryService.createDeployment()
    .addClasspathResource("gen.bpmn").deploy();
// 查询流程定义
//查询流程定义实体
ProcessDefinition def = repositoryService.createProcessDefinitionQuery()
    .deploymentId(dep.getId()).singleResult();
// 查询资源文件
InputStream is = repositoryService.getProcessModel(def.getId());
// 读取输入流
int count = is.available();
byte[] contents = new byte[count];
is.read(contents);
String result = new String(contents);
//输入输出结果 查询流程文件
//
//查询流程图

//bpmn文件转流程图文件
// 部署一份流程文件与相应的流程图文件
Deployment dep = repositoryService.createDeployment()
    .addClasspathResource("gen.bpmn").deploy();
// 查询流程定义
ProcessDefinition def = repositoryService.createProcessDefinitionQuery()
    .deploymentId(dep.getId()).singleResult();
// 查询资源文件
InputStream is = repositoryService.getProcessDiagram(def.getId());
// 将输入流转换为图片对象  
BufferedImage image = ImageIO.read(is);
// 保存为图片文件
File file = new File("resource/result.png");
if (!file.exists()) file.createNewFile();
FileOutputStream fos = new FileOutputStream(file);
ImageIO.write(image, "png", fos);
fos.close();
is.close();
```

**删除部署数据**

1. 不管是否指定级联，都会删除部署相关的身份数据、流程定义数据、流程资源与部署数据。
2. 如果设置为级联删除，则会将运行的流程实例、流程任务以及流程实例的历史数据删除。
3. 如果不级联删除，但是存在运行时数据，例如还有流程实例，就会删除失败。


#### 08 API（3）流程定义

```java
ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
// 存储服务
RepositoryService rs = engine.getRepositoryService();

DeploymentBuilder builder = rs.createDeployment();
//设置流程的所在位置
builder.addClasspathResource("test1.bpmn");
//指定流程图的位置 以及图片
builder.addClasspathResource("test2.bpmn").addClasspathResource("test2.png");
//中止与激活流程定义
ProcessDefinition def = rs.createProcessDefinitionQuery()
    .deploymentId(dep.getId()).singleResult();  

System.out.println("id: " + def.getId());
rs.suspendProcessDefinitionByKey(def.getKey());
// 将会抛出异常，因为流程定义被中止了
RuntimeService runService = engine.getRuntimeService();
runService.startProcessInstanceByKey(def.getKey());
//流程部署
builder.deploy();
//
```

```java
//流程定义权限

ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
// 存储服务
RepositoryService rs = engine.getRepositoryService();
IdentityService is = engine.getIdentityService();

User user = is.newUser(UUID.randomUUID().toString());
user.setFirstName("Angus");
is.saveUser(user);

DeploymentBuilder builder = rs.createDeployment();
builder.addClasspathResource("test3.bpmn");
Deployment dep = builder.deploy();


ProcessDefinition def = rs.createProcessDefinitionQuery()
    .deploymentId(dep.getId()).singleResult();
rs.addCandidateStarterUser(def.getId(), user.getId());


List<ProcessDefinition> defs = rs.createProcessDefinitionQuery().startableByUser(user.getId()).list();
for(ProcessDefinition de : defs) {
    System.out.println(de.getId());
}
```


#### 09 API（4）任务操作

```java
//任务权限
ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
TaskService ts = engine.getTaskService();
IdentityService is = engine.getIdentityService();
// 创建任务
String taskId = UUID.randomUUID().toString();
Task task = ts.newTask(taskId);
task.setName("测试任务");
ts.saveTask(task);
//  创建用户
String userId = UUID.randomUUID().toString();
User user = is.newUser(userId);
user.setFirstName("angus");
is.saveUser(user);
//任务候选人（组）============================
//任务持有人
//任务代理人
// 设置任务的候选用户组
ts.addCandidateUser(taskId, userId);
List<Task> tasks = ts.createTaskQuery().taskCandidateUser(userId).list();
//====================================================
// 设置任务的候选用户组
ts.setOwner(taskId, userId);
// 根据用户来查询他所持有的任务
List<Task> tasks = ts.createTaskQuery().taskOwner(userId).list();
//==================================
is.saveUser(user);

ts.claim(taskId, userId);
ts.claim(taskId, "100");

List<Task> tasks = ts.createTaskQuery().taskAssignee(userId).list();
//==========================================
//这个用户有权限处理的任务
for(Task t : tasks) {
    System.out.println(t.getName());
}
```




#### 10 API（5）任务参数与附件

```java
//任务参数
//基本数据类型参数
Task task = ts.newTask(UUID.randomUUID().toString());
task.setName("测试任务");
ts.saveTask(task);

ts.setVariable(task.getId(), "var1", "hello");
//序列化参数
Task task = ts.newTask(UUID.randomUUID().toString());
task.setName("测试任务");
ts.saveTask(task);

Person p = new Person();
p.setId(1);
p.setName("angus");
ts.setVariable(task.getId(), "person1", p);

Person pr = ts.getVariable(task.getId(), "person1", Person.class);

```

```java
//参数作用域
//本地参数定义在var_local.bpmn
Deployment dep = rs.createDeployment().addClasspathResource("var_local.bpmn").deploy();
ProcessDefinition pd = rs.createProcessDefinitionQuery().deploymentId(dep.getId()).singleResult();

ProcessInstance pi = runService.startProcessInstanceById(pd.getId());

Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
taskService.setVariableLocal(task.getId(), "days", 3);
System.out.println("当前任务：" + task.getName() + ", days参数：" + taskService.getVariableLocal(task.getId(), "days"));

taskService.complete(task.getId());

task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
System.out.println("当前任务：" + task.getName() + ", days参数：" + taskService.getVariableLocal(task.getId(), "days"));
//全局参数定义在dataobject.bpmn
Deployment dep = rs.createDeployment().addClasspathResource("dataobject.bpmn").deploy();
ProcessDefinition pd = rs.createProcessDefinitionQuery().deploymentId(dep.getId()).singleResult();

ProcessInstance pi = runService.startProcessInstanceById(pd.getId());

Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
String var = taskService.getVariable(task.getId(), "personName", String.class);
System.out.println(var);

```




#### 11 API（6）启动流程




#### 12 API（7）流程操作与数据查询




#### 13 API（8）历史数据

#### 14 API（9）工作数据的产生

#### 15 API（10）管理服务的使用


#### 16 BPMN事件（1）事件的分类与定义

#### 17 BPMN事件（2）开始事件和结束事件

#### 18 BMPN事件（3）边界事件与中间事件

#### 19 BPMN事件（4）中间事件

#### 20 BPMN任务（1）用户任务

#### 21 BPMN任务（2）脚本任务

#### 22 BPMN任务（3）服务任务

#### 23 BPMN任务（4）任务监听器与流程监听器

#### 24 BPMN其他元素（1）子流程

#### 25 BPMN其他元素（2）顺序流与网关

#### 26 BPMN其他元素（3）流程活动的特性

#### 27 规则引擎Drools（1）Drools介绍与运行

#### 28 规则引擎Drools（2）类型声明

#### 29 规则引擎Drools（3）规则语法

#### 30 规则引擎Drools（4）Activiti整合Drools

#### 31 DMN（1）DMN规范

#### 32 DMN（2）运行第一个DMN应用

#### 33 DMN（3）规则匹配

#### 34 DMN（4）销售打折案例

#### 35 整合框架（1）整合Spring

#### 36 整合框架（2）web项目整合Activiti

#### 37 整合框架（3）整合Spring Boot

#### 38 整合框架（4）整合JPA

#### 39 REST的发布与调用

#### 40 部署Activiti REST服务

#### 41 调用流程存储REST服务

#### 42 Activiti进阶（1）流程控制逻辑

#### 43 Activiti进阶（2）Activiti表单

#### 44 Activiti进阶（3）流程图与流程操作

#### 45 综合案例
