一、环境准备

```java
系统：centos7.7
IP地址：192.168.33.14
IP地址：192.168.33.15
IP地址：192.168.33.16
端口号：6381，6382
```

二、搭建redis集群（以下步骤在每台服务器上都要执行）

```java
1:wget http://download.redis.io/redis-stable/redis.conf
2:对下载的redis.conf进行配置(因为是三主三从模式，每台服务器主端口是6381，备端口是6382)
  # bind 127.0.0.1 
	protected\-mode no 
	port 6381 
	# daemonize yes 
	pidfile /var/run/redis\_6381.pid
	cluster\-enabled yes 
	cluster-config-file nodes\_6381.conf
3:三台主机分别新建目录并将redis.conf放入
	mkdir -p /app/redis/cluster/6381/data
	mkdir -p /app/redis/cluster/6382/data
4:把redis.conf配置文件分别复制到刚才创建的两个文件夹下
  cp redis.conf /app/redis/cluster/6381/data
	cp redis.conf /app/redis/cluster/6382/data
5:三台主机启动Redis
  docker run -v /app/redis/cluster/6381/data/:/data --privileged=true --net host --name redis-6381 -d redis:latest redis-server /data/redis.conf
	docker run -v /app/redis/cluster/6382/data/:/data --privileged=true --net host --name redis-6382 -d redis:latest redis-server /data/redis.conf
    
```

三、连接集群(任选一个redis使用redis-cli创建集群)

```java
docker exec -it redis-6381 /bin/sh
redis-cli --cluster create 192.168.33.14:6381 192.168.33.14:6382 192.168.33.15:6381 192.168.33.15:6382 192.168.33.16:6381 192.168.33.16:6382 --cluster-replicas 1
```

四、查看集群状态

```jav
docker exec -it redis-6381 /bin/sh

redis\-cli -c -h 192.168.33.14 -p 6381 cluster info
```





