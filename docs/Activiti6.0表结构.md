# Activiti工作流6.0表结构介绍

## 数据库设计规则

ACT_GE_*  通用数据表（GE 代表 General）

ACT_RE_*  流程定义存储表 （RE 代表 Repository）保存一些 ‘静态’信息，如流程定义和流程资源（如图片、规则等）；

ACT_ID_* 身份信息表 (ID 代表 Identity)

ACT_RU_*运行时记录表 （RU 代表 Runtime）并且当流程结束后会立即移除这些数据，这是为了保证运行时表尽量的小并运行的足够快；

ACT_HI_*历史数据表 （HI 代表 History）

**1.通用数据表（ACT_GE_*）**

1.1 ACT_EVT_LOG (act_evt_log) > 事件日志表
1.2 ACT_GE_PROPERTY > 属性表
1.3 ACT_GE_BYTEARRAY >  资源表

**2.流程定义存储表（ACT_RE_*）**

2.1 ACT_RE_DEPLOYMENT >  部署数据表
2.2 ACT_RE_MODEL >  模型信息表
2.3 ACT_RE_PROCDEF >  流程定义表
2.4 ACT_PROCDEF_INFO >  流程定义扩展表

**3.身份数据表**

3.1 ACT_ID_USER > 用户信息表
3.2 ACT_ID_INFO > 用户扩展信息表
3.3 ACT_ID_GROUP > 用户组表
3.4 ACT_ID_MEMBERSHIP > 用户与组关系表

**4.运行时流程数据表**

4.1 ACT_RU_EXECUTION > 运行时流程实例执行实例表
4.2 ACT_RU_TASK > 用户任务表
4.3 ACT_RU_VARIABLE > 流程参数数据表
4.4 ACT_RU_IDENTITYLINK > 参与者信息表
4.5 ACT_RU_EVENT_SUBSCR > 运行时事件表
4.6 ACT_RU_JOB > 运行作业信息表
4.7 ACT_RU_DEADLETTER_JOB > 无法执行工作表
4.8 ACT_RU_SUSPENDED_JOB > 暂停表
4.9 ACT_RU_TIMER_JOB > 定时器表

**5. 历史数据表**

5.1 ACT_HI_PROCINST 历史流程实例信息表
5.2 ACT_HI_DETAIL 流程明细表
5.3 ACT_HI_ACTINS 历史节点表
5.4 ACT_HI_TASKINST 历史任务流程实例信息
5.5 ACT_HI_IDENTITYLINK > 历史流程人员表
5.6 ACT_HI_COMMENT > 历史审批意见表 
5.7 ACT_HI_VARINST > 历史变量信息

https://blog.csdn.net/qq_38011415/article/details/101127222