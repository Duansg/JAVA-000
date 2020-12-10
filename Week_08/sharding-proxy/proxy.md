### 创建数据库

````java
1：docker run -p 3306:3306 --name mymysql0 -v $PWD/conf:/Users/duansg/app/docker_mysql/conf.d -v $PWD/logs:/Users/duansg/app/docker_mysql/logs -v $PWD/data:/Users/duansg/app/docker_mysql/data/ -e MYSQL_ROOT_PASSWORD=123456 -d mysql
  
2：docker run -p 3307:3306 --name mymysql1 -v $PWD/conf:/Users/duansg/app/docker_mysql/conf.d -v $PWD/logs:/Users/duansg/app/docker_mysql/logs -v $PWD/data:/Users/duansg/app/docker_mysql/data/ -e MYSQL_ROOT_PASSWORD=123456 -d mysql
````

### **config-sharding.yaml**

````java
schemaName: order_proxy

dataSources:
  demo_00:
    url: jdbc:mysql://127.0.0.1:3306/demo_00?serverTimezone=UTC&useSSL=false
    username: root
    password: 123456
    connectionTimeoutMilliseconds: 30000
    idleTimeoutMilliseconds: 60000
    maxLifetimeMilliseconds: 1800000
    maxPoolSize: 10
  demo_01:
    url: jdbc:mysql://127.0.0.1:3307/demo_01?serverTimezone=UTC&useSSL=false
    username: root
    password: 123456
    connectionTimeoutMilliseconds: 30000
    idleTimeoutMilliseconds: 60000
    maxLifetimeMilliseconds: 1800000
    maxPoolSize: 10

rules:
- !SHARDING
  tables:
    order_info:
      actualDataNodes: demo_0${0..1}.order_info_${0..15}
      tableStrategy:
        standard:
          shardingColumn: order_code
          shardingAlgorithmName: order_inline
      keyGenerateStrategy:
        column: order_id
        keyGeneratorName: snowflake
  defaultDatabaseStrategy:
    standard:
      shardingColumn: user_id
      shardingAlgorithmName: database_inline
  defaultTableStrategy:
    none:
  shardingAlgorithms:
    database_inline:
      type: INLINE
      props:
        algorithm-expression: demo_0${user_id % 2}
    order_inline:
      type: INLINE
      props:
        algorithm-expression: order_info_${order_code.hashCode() % 16}
  keyGenerators:
    snowflake:
      type: SNOWFLAKE
      props:
        worker-id: 123
````

### **server.yaml**

````java
authentication:
  users:
    root:
      password: 123456
props:
  max-connections-size-per-query: 1
  acceptor-size: 16  
  executor-size: 16  
  proxy-frontend-flush-threshold: 128  
  proxy-transaction-type: LOCAL
  proxy-opentracing-enabled: false
  proxy-hint-enabled: false
  query-with-cipher-column: true
  sql-show: true
  check-table-metadata-enabled: false
````

### 启动

sh start.sh 3308

````java
[INFO ] 10:50:37.183 [main] ShardingSphere-metadata - Loading 0 tables' meta data for unconfigured tables.
[INFO ] 10:50:37.190 [main] ShardingSphere-metadata - Loading 0 tables' meta data for unconfigured tables.
[INFO ] 10:50:37.196 [main] ShardingSphere-metadata - Loading 16 tables' meta data for unconfigured tables.
[INFO ] 10:50:37.200 [main] ShardingSphere-metadata - Loading 16 tables' meta data for unconfigured tables.
[INFO ] 10:50:37.207 [main] o.a.s.i.c.s.SchemaContextsBuilder - Load meta data for schema order_proxy finished, cost 106 milliseconds.
Thanks for using Atomikos! Evaluate http://www.atomikos.com/Main/ExtremeTransactions for advanced features and professional support
or register at http://www.atomikos.com/Main/RegisterYourDownload to disable this message and receive FREE tips & advice
[INFO ] 10:50:37.289 [main] o.a.s.p.i.i.AbstractBootstrapInitializer - Database name is `MySQL`, version is `8.0.22`
[INFO ] 10:50:37.400 [main] o.a.s.p.frontend.ShardingSphereProxy - ShardingSphere-Proxy start success.
````

### 连接

mysql -h127.0.0.1 **-P3308** -u root -p 123456 

### 插入

````java
[INFO ] 11:01:40.117 [ShardingSphere-Command-15] ShardingSphere-SQL - Logic SQL: INSERT INTO `order_proxy`.`order_info`(`id`, `order_code`, `user_id`) VALUES (1, '2323', 232)
[INFO ] 11:01:40.117 [ShardingSphere-Command-15] ShardingSphere-SQL - SQLStatement: MySQLInsertStatement(setAssignment=Optional.empty, onDuplicateKeyColumns=Optional.empty)
[INFO ] 11:01:40.117 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_00 ::: INSERT INTO `order_info_2`(`id`, `order_code`, `user_id`) VALUES (1, '2323', 232)
[INFO ] 11:01:40.157 [ShardingSphere-Command-0] ShardingSphere-SQL - Logic SQL: SELECT * FROM `order_proxy`.`order_info` WHERE `id` = 1
[INFO ] 11:01:40.158 [ShardingSphere-Command-0] ShardingSphere-SQL - SQLStatement: MySQLSelectStatement(limit=Optional.empty, lock=Optional.empty)
````

### 查询

````java
FO ] 11:03:29.997 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * from order_info_0
[INFO ] 11:03:29.997 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * from order_info_1
[INFO ] 11:03:29.997 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * from order_info_2
[INFO ] 11:03:29.997 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * from order_info_3
[INFO ] 11:03:29.997 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * from order_info_4
[INFO ] 11:03:29.997 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * from order_info_5
[INFO ] 11:03:29.997 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * from order_info_6
[INFO ] 11:03:29.997 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * from order_info_7
[INFO ] 11:03:29.997 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * from order_info_8
[INFO ] 11:03:29.997 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * from order_info_9
[INFO ] 11:03:29.997 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * from order_info_10
[INFO ] 11:03:29.997 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * from order_info_11
[INFO ] 11:03:29.997 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * from order_info_12
[INFO ] 11:03:29.997 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * from order_info_13
[INFO ] 11:03:29.997 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * from order_info_14
[INFO ] 11:03:29.997 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * from order_info_15
[INFO ] 11:03:29.997 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * from order_info_0
[INFO ] 11:03:29.997 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * from order_info_1
[INFO ] 11:03:29.998 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * from order_info_2
[INFO ] 11:03:29.998 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * from order_info_3
[INFO ] 11:03:29.998 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * from order_info_4
[INFO ] 11:03:29.998 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * from order_info_5
[INFO ] 11:03:29.998 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * from order_info_6
[INFO ] 11:03:29.998 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * from order_info_7
[INFO ] 11:03:29.998 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * from order_info_8
[INFO ] 11:03:29.998 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * from order_info_9
[INFO ] 11:03:29.998 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * from order_info_10
[INFO ] 11:03:29.998 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * from order_info_11
[INFO ] 11:03:29.998 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * from order_info_12
[INFO ] 11:03:29.998 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * from order_info_13
[INFO ] 11:03:29.998 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * from order_info_14
[INFO ] 11:03:29.998 [ShardingSphere-Command-15] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * from order_info_15
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Logic SQL: SELECT * FROM `order_proxy`.`order_info` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - SQLStatement: MySQLSelectStatement(limit=Optional[org.apache.shardingsphere.sql.parser.sql.common.segment.dml.pagination.limit.LimitSegment@49f9dfa3], lock=Optional.empty)
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * FROM `order_info_0` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * FROM `order_info_1` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * FROM `order_info_2` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * FROM `order_info_3` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * FROM `order_info_4` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * FROM `order_info_5` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * FROM `order_info_6` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * FROM `order_info_7` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * FROM `order_info_8` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * FROM `order_info_9` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * FROM `order_info_10` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * FROM `order_info_11` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * FROM `order_info_12` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * FROM `order_info_13` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * FROM `order_info_14` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_00 ::: SELECT * FROM `order_info_15` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * FROM `order_info_0` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * FROM `order_info_1` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * FROM `order_info_2` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * FROM `order_info_3` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * FROM `order_info_4` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * FROM `order_info_5` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * FROM `order_info_6` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * FROM `order_info_7` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * FROM `order_info_8` LIMIT 0
[INFO ] 11:03:30.044 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * FROM `order_info_9` LIMIT 0
[INFO ] 11:03:30.045 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * FROM `order_info_10` LIMIT 0
[INFO ] 11:03:30.045 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * FROM `order_info_11` LIMIT 0
[INFO ] 11:03:30.045 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * FROM `order_info_12` LIMIT 0
[INFO ] 11:03:30.045 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * FROM `order_info_13` LIMIT 0
[INFO ] 11:03:30.045 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * FROM `order_info_14` LIMIT 0
[INFO ] 11:03:30.045 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: demo_01 ::: SELECT * FROM `order_info_15` LIMIT 0
````

### 删除

````java

[INFO ] 11:14:42.936 [ShardingSphere-Command-13] ShardingSphere-SQL - Logic SQL: DELETE FROM `order_proxy`.`order_info` WHERE `id` = 1
[INFO ] 11:14:42.936 [ShardingSphere-Command-13] ShardingSphere-SQL - SQLStatement: MySQLDeleteStatement(orderBy=Optional.empty, limit=Optional.empty)
[INFO ] 11:14:42.936 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_00 ::: DELETE FROM `order_info_0` WHERE `id` = 1
[INFO ] 11:14:42.936 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_00 ::: DELETE FROM `order_info_1` WHERE `id` = 1
[INFO ] 11:14:42.936 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_00 ::: DELETE FROM `order_info_2` WHERE `id` = 1
[INFO ] 11:14:42.936 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_00 ::: DELETE FROM `order_info_3` WHERE `id` = 1
[INFO ] 11:14:42.936 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_00 ::: DELETE FROM `order_info_4` WHERE `id` = 1
[INFO ] 11:14:42.936 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_00 ::: DELETE FROM `order_info_5` WHERE `id` = 1
[INFO ] 11:14:42.936 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_00 ::: DELETE FROM `order_info_6` WHERE `id` = 1
[INFO ] 11:14:42.936 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_00 ::: DELETE FROM `order_info_7` WHERE `id` = 1
[INFO ] 11:14:42.936 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_00 ::: DELETE FROM `order_info_8` WHERE `id` = 1
[INFO ] 11:14:42.936 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_00 ::: DELETE FROM `order_info_9` WHERE `id` = 1
[INFO ] 11:14:42.936 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_00 ::: DELETE FROM `order_info_10` WHERE `id` = 1
[INFO ] 11:14:42.936 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_00 ::: DELETE FROM `order_info_11` WHERE `id` = 1
[INFO ] 11:14:42.937 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_00 ::: DELETE FROM `order_info_12` WHERE `id` = 1
[INFO ] 11:14:42.937 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_00 ::: DELETE FROM `order_info_13` WHERE `id` = 1
[INFO ] 11:14:42.937 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_00 ::: DELETE FROM `order_info_14` WHERE `id` = 1
[INFO ] 11:14:42.937 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_00 ::: DELETE FROM `order_info_15` WHERE `id` = 1
[INFO ] 11:14:42.937 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_01 ::: DELETE FROM `order_info_0` WHERE `id` = 1
[INFO ] 11:14:42.937 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_01 ::: DELETE FROM `order_info_1` WHERE `id` = 1
[INFO ] 11:14:42.937 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_01 ::: DELETE FROM `order_info_2` WHERE `id` = 1
[INFO ] 11:14:42.937 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_01 ::: DELETE FROM `order_info_3` WHERE `id` = 1
[INFO ] 11:14:42.937 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_01 ::: DELETE FROM `order_info_4` WHERE `id` = 1
[INFO ] 11:14:42.937 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_01 ::: DELETE FROM `order_info_5` WHERE `id` = 1
[INFO ] 11:14:42.937 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_01 ::: DELETE FROM `order_info_6` WHERE `id` = 1
[INFO ] 11:14:42.937 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_01 ::: DELETE FROM `order_info_7` WHERE `id` = 1
[INFO ] 11:14:42.937 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_01 ::: DELETE FROM `order_info_8` WHERE `id` = 1
[INFO ] 11:14:42.937 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_01 ::: DELETE FROM `order_info_9` WHERE `id` = 1
[INFO ] 11:14:42.937 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_01 ::: DELETE FROM `order_info_10` WHERE `id` = 1
[INFO ] 11:14:42.937 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_01 ::: DELETE FROM `order_info_11` WHERE `id` = 1
[INFO ] 11:14:42.937 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_01 ::: DELETE FROM `order_info_12` WHERE `id` = 1
[INFO ] 11:14:42.937 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_01 ::: DELETE FROM `order_info_13` WHERE `id` = 1
[INFO ] 11:14:42.937 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_01 ::: DELETE FROM `order_info_14` WHERE `id` = 1
[INFO ] 11:14:42.937 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: demo_01 ::: DELETE FROM `order_info_15` WHERE `id` = 1

````


