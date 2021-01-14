### 一、搭建Zookeeper环境

(1)：拉取zookeeper镜像

```java
192:~ duansg$ docker pull zookeeper
```

(2)：运行zookeeper

```java
docker run --privileged=true -d --name zookeeper -p 2181:2181 -d zookeeper:latest
```

(3)：查看运行状态

```java
192:~ duansg$ docker ps 
59e15af08bce        zookeeper:latest     "/docker-entrypoint.…"   5 seconds ago       Up 4 seconds                    2888/tcp, 3888/tcp, 0.0.0.0:2181->2181/tcp, 8080/tcp   zookeeper
```

### 二、搭建Kafka环境

(1)：查看是否安装了docker-compose

```java
192:~ duansg$ docker-compose -v
docker-compose version 1.23.0-rc3, build ea3d406e
```

(2)：创建临时目录

```java
mkdir /Users/duansg/app/kafka
vim dokcer-compose.yml
```

(3)：查询宿主机ip

```java
192:kafka duansg$ ifconfig en0
en0: flags=8863<UP,BROADCAST,SMART,RUNNING,SIMPLEX,MULTICAST> mtu 1500
	options=400<CHANNEL_IO>
	ether f8:ff:c2:03:a8:19
	inet6 fe80::815:4603:ce06:23bc%en0 prefixlen 64 secured scopeid 0x6
	inet 192.168.0.23 netmask 0xfffffc00 broadcast 192.168.0.1
	nd6 options=201<PERFORMNUD,DAD>
	media: autoselect
	status: active
```

(4)：编写docker-compose.yml

```java
version: '2'
services:
  kafka1:
    image: wurstmeister/kafka
    ports:
      - "9092:9092"
    environment:
      KAFKA_ADVERTISED_HOST_NAME: 192.168.0.23                 ## 修改:宿主机IP
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://192.168.0.23:9092    ## 修改:宿主机IP
      KAFKA_ZOOKEEPER_CONNECT: 192.168.0.23:2181 #刚刚搭建的zookeeper宿主机IP以及端口
      KAFKA_ADVERTISED_PORT: 9092
    container_name: kafka1
  kafka2:
    image: wurstmeister/kafka
    ports:
      - "9093:9092"
    environment:
      KAFKA_ADVERTISED_HOST_NAME: 192.168.0.23                ## 修改:宿主机IP
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://192.168.0.23:9093        ## 修改:宿主机IP
      KAFKA_ZOOKEEPER_CONNECT: 192.168.0.23:2181 #刚刚搭建的zookeeper宿主机IP以及端口
      KAFKA_ADVERTISED_PORT: 9093
    container_name: kafka2
```

(5)：运行

```java
docker-compose -f /Users/duansg/app/kafka/dokcer-compose.yml up -d
Starting kafka2                             ... done
Starting kafka1                             ... done
```

(6)：查看运行状态

````java
192:kafka duansg$ docker-compose -f /Users/duansg/app/kafka/dokcer-compose.yml ps
 Name       Command       State           Ports
--------------------------------------------------------
kafka1   start-kafka.sh   Up      0.0.0.0:9092->9092/tcp
kafka2   start-kafka.sh   Up      0.0.0.0:9093->9092/tcp
````

### 三、测试Kafka

(1)：进入kafka容器

````java
192:kafka duansg$ docker exec -it af565bdc264b /bin/bash
````

(2)：进入bin目录

```java
cd opt/kafka_2.13-2.7.0/bin/
```

(3)：创建拥有3个副本的topic

```java
bash-4.4# ./kafka-topics.sh --create --zookeeper 192.168.0.23:2181 --replication-factor 2 --partitions 1 --topic my-replication-topic
Created topic my-replication-topic.
```

(4)：测试生产消费

```java
./kafka-console-producer.sh --broker-list 192.168.0.23:9092 --topic my-replication-topic
./kafka-console-consumer.sh --bootstrap-server 192.168.0.23:9092 --from-beginning --topic my-replication-topic
```

(5)：测试性能

````java
bash-4.4# ./kafka-producer-perf-test.sh --topic test32 --num-records 100000 --record-size 1000 --throughput 2000 --producer-props bootstrap.servers=192.168.0.23:9092
[2021-01-13 14:49:41,996] WARN [Producer clientId=producer-1] Error while fetching metadata with correlation id 1 : {test32=LEADER_NOT_AVAILABLE} (org.apache.kafka.clients.NetworkClient)
9998 records sent, 1999.2 records/sec (1.91 MB/sec), 66.3 ms avg latency, 926.0 ms max latency.
10018 records sent, 2003.2 records/sec (1.91 MB/sec), 3.3 ms avg latency, 16.0 ms max latency.
10004 records sent, 2000.8 records/sec (1.91 MB/sec), 3.0 ms avg latency, 37.0 ms max latency.
10002 records sent, 2000.4 records/sec (1.91 MB/sec), 5.1 ms avg latency, 33.0 ms max latency.
10004 records sent, 2000.8 records/sec (1.91 MB/sec), 3.1 ms avg latency, 21.0 ms max latency.
10002 records sent, 2000.4 records/sec (1.91 MB/sec), 3.0 ms avg latency, 55.0 ms max latency.
10001 records sent, 2000.2 records/sec (1.91 MB/sec), 2.9 ms avg latency, 26.0 ms max latency.
9989 records sent, 1996.2 records/sec (1.90 MB/sec), 2.4 ms avg latency, 26.0 ms max latency.
10034 records sent, 2006.4 records/sec (1.91 MB/sec), 2.4 ms avg latency, 24.0 ms max latency.
100000 records sent, 1999.320231 records/sec (1.91 MB/sec), 9.40 ms avg latency, 926.00 ms max latency, 2 ms 50th, 12 ms 95th, 276 ms 99th, 348 ms 99.9th.
````

````java
bash-4.4# ./kafka-producer-perf-test.sh --topic test32 --num-records 100000 --record-size 1000 --throughput 2000 --producer-props bootstrap.servers=192.168.0.23:9093
9996 records sent, 1999.2 records/sec (1.91 MB/sec), 24.5 ms avg latency, 774.0 ms max latency.
10012 records sent, 2002.0 records/sec (1.91 MB/sec), 2.5 ms avg latency, 22.0 ms max latency.
10004 records sent, 2000.8 records/sec (1.91 MB/sec), 2.4 ms avg latency, 22.0 ms max latency.
10004 records sent, 2000.4 records/sec (1.91 MB/sec), 2.3 ms avg latency, 20.0 ms max latency.
10004 records sent, 2000.4 records/sec (1.91 MB/sec), 2.1 ms avg latency, 11.0 ms max latency.
10004 records sent, 2000.8 records/sec (1.91 MB/sec), 2.2 ms avg latency, 20.0 ms max latency.
10004 records sent, 2000.4 records/sec (1.91 MB/sec), 2.2 ms avg latency, 20.0 ms max latency.
10004 records sent, 2000.4 records/sec (1.91 MB/sec), 2.1 ms avg latency, 10.0 ms max latency.
10004 records sent, 2000.4 records/sec (1.91 MB/sec), 2.1 ms avg latency, 14.0 ms max latency.
100000 records sent, 1999.280259 records/sec (1.91 MB/sec), 4.45 ms avg latency, 774.00 ms max latency, 2 ms 50th, 5 ms 95th, 109 ms 99th, 149 ms 99.9th.
````


