### Redis主从复制

一、获取配置文件

```
1：mkdir /docker/redis
2：wget http://download.redis.io/redis-stable/redis.conf
3：vim  /docker/redis/redis.conf 
	#bind 127.0.0.1        
  protected-mode no      
  appendonly yes         
```

二、新建Master的conf文件

```java
1:mkdir /docker/redis/redis6379
2:cp /docker/redis/redis.conf /docker/redis/redis6379/
```

三、启动Master

```
docker run --restart always --name redis-6379 -p 6379:6379 -v /docker/redis/redis6379:/data -d redis redis-server /data/redis.conf
```

四、查看Master容器IP

```java
root@iZ282zj76jqZ: docker inspect --format='{{.NetworkSettings.IPAddress}}' ba5b186de2de
172.17.0.2
```

五、创建 Salve 文件夹

```java
1:mkdir /docker/redis/redis6380
2:mkdir /docker/redis/redis6381
3:cp /docker/redis/redis.conf /docker/redis/redis6380/
4:cp /docker/redis/redis.conf /docker/redis/redis6381/
5:分别修改两个文件为
	#bind 127.0.0.1        
	protected-mode no      
	appendonly yes         
	replicaof 172.17.0.2 6379 
```

六、启动Salve

```java
docker run --restart always --name redis-6380 -p 6380:6379 -v /docker/redis/redis6380:/data -d redis redis-server /data/redis.conf
docker run --restart always --name redis-6381 -p 6381:6379 -v /docker/redis/redis6381:/data -d redis redis-server /data/redis.conf
```

七、查看容器服务

```java
root@iZ282zj76jqZ:/docker/redis# docker ps -a
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                               NAMES
ca3caaa77f4a        redis               "docker-entrypoint.s…"   2 hours ago         Up About an hour    0.0.0.0:6381->6379/tcp              redis-6381
ba5b186de2de        redis               "docker-entrypoint.s…"   2 hours ago         Up 2 hours          0.0.0.0:6379->6379/tcp              redis-6379
979318c633be        redis               "docker-entrypoint.s…"   2 hours ago         Up About an hour    0.0.0.0:6380->6379/tcp              redis-6380

```

```java
root@iZ282zj76jqZ:/docker/redis# docker exec -it redis-6379 redis-cli info replication
# Replication
role:master
connected_slaves:2
slave0:ip=192.168.0.4,port=6379,state=online,offset=812,lag=0
slave1:ip=192.168.0.5,port=6379,state=online,offset=812,lag=0
slave2:ip=192.168.0.6,port=6379,state=online,offset=812,lag=0
master_replid:97bf611eb2ac66774c98f9e1d6303906de0e72ca
master_replid2:0000000000000000000000000000000000000000
master_repl_offset:812
second_repl_offset:-1
repl_backlog_active:1
repl_backlog_size:1048576
repl_backlog_first_byte_offset:1
repl_backlog_histlen:812
```

```java
root@iZ282zj76jqZ:/docker/redis# docker exec -it redis-6380 redis-cli info replication
# Replication
role:slave
master_host:172.17.0.2
master_port:6379
master_link_status:up
master_last_io_seconds_ago:2
master_sync_in_progress:0
slave_repl_offset:742
slave_priority:100
slave_read_only:1
connected_slaves:0
master_replid:97bf611eb2ac66774c98f9e1d6303906de0e72ca
master_replid2:0000000000000000000000000000000000000000
master_repl_offset:742
second_repl_offset:-1
repl_backlog_active:1
repl_backlog_size:1048576
repl_backlog_first_byte_offset:1
repl_backlog_histlen:742
```

### 哨兵

一、创建 sentinel.conf 配置文件

```
sentinel monitor mygroup 172.17.0.2 6379 1
port 26379
```

二、启动监听容器

```jvav
docker run --restart always --name sentinel-0 -p 26379:26379 -v /docker/redis/sentinel0:/data -d redis redis-sentinel /data/sentinel.conf
```


