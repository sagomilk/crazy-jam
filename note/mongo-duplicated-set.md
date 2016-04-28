#Mongo复制集

##2种风格
1. 副本集
2. 主从（很少用，超过11个从节点时使用，duplicated Set不能超过12个？？？待确认）

##使用场景
  1.冗余
  2.高可用
  3.故障转移
  4.简化维护(大索引构建)
  5.均衡读负载

##不适用场景
  1.硬件性能无法满足给定负载
  2.读写比超过参考
  3.一致性要求强(CAP)

##MongoDB副本集
###mini推荐
3个结点：

	2个持久化mongod实例，拥有完整数据
	1个仲裁结点

实际: 最好是3个持久化mongod实例，要不在挂掉一个实例的时候就存在地点故障的问题


###创建
mongod --replSet "REPLICA_SET_INSTANCE_NAME" --dbpath "DB_DATA_PATH" --port "PORT"  --fork

在Mongo客户端使用命令rs.initiate()来启动一个新的副本集。

我们可以使用rs.conf()来查看副本集的配置
查看副本集姿态使用 rs.status() 命令

##复制原理
oplog 依靠oplog来复制
hearbeat 监控监控和故障转移

###oplog
固定collection，位于local DB里

###步骤

###rs.add源码

###参数

###状态维护（与上面重复）

###故障恢复图解


###添加成员

	rs.add(HOST_NAME:PORT)
arbiter成员
	rs.add("HOST_NAME:PORT", {arbiterOnly: true})

##维护
MongoDB中你只能通过主节点将Mongo服务添加到副本集中，
 判断当前运行的Mongo服务是否为主节点可以使用命令db.isMaster() 


##REFERENCE
http://www.runoob.com/mongodb/mongodb-replication.html
