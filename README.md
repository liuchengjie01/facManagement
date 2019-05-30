# facManagement
use for our Mysql class

# arcompany编写指南

## 代码介绍

```
jeeweb
├─src  根目录
│    ├─Java  源代码
│    │ 		├─controller	视图控制器
│    │ 		│
│    │ 		├─dao	动作控制器
│    │ 		│
│    │ 		├─pojo	数据库实体映射
│    │ 		│
│    │ 		├─service	服务类型
│    │ 		│
│    │ 		├─utils	功能文件
│    │
│    ├─resource 配置文件
│    │ 		├─mapper 映射文件
│    │ 		│
│    │ 		├─spring spring架构配置器
│    │ 		│
│    │ 		├─db.properties 数据库配置文件
│    │ 		│
│    │ 		├─log4j.properties 日志文件
│    │ 		│
│    │ 		├─mybatis-config.xml mybatis配置文件
│    │ 
│    ├─webapp  网络应用
│    │ 		├─WEB-INF
│    │ 	  │			├─jsp jsp文件
│    │ 
│    │ 		├─index.jsp 暂定首页
│    │ 
│
```



## 业务逻辑

1. 从页面开始：点开主页 $->$ 某个功能页面（e.g. 部门详情）
2. 页面Bumen.jsp 请求由controller中的控制器进行处理（在spring/spring-mvc.xml中指定），在controller中指定：Bumen/allBumen
3. 在BumenController中进行service注入，调用service中的Bumenservice
4. Bumenservice中的功能由impl中的Bumenserviceimpl实现
5. 在Bumenserviceimpl中通过dao注入，调用Bumendao
6. 根据spring/spring-dao.xml中指定，在Bumendao中的数据库操作根据id指定由mapper/Bumenmapper.xml中对应id的sql语句具体执行
7. 数据库操作后依次返回到jsp页面中

## 如何编写

1. 根据数据库对象在pojo中建立实体，对应数据库中的相关对象
2. 在service中编写对应的service接口（interface）
3. 在service/impl中实现对应service的实现类
4. 在dao中编写对应的dao文件
5. 在mapper下的文件下编写对应的sql代码
6. 编写jsp文件
7. 在controller写对应控制函数，并且注册jsp文件
8. 测试


