一、sql
    1.三大范式（三大范式有五个不是很正常的吗）
        第一范式（1NF）：关系 R 属于第一范式，当且仅当R中的每一个属性A的值域只包含原
        子项
        第二范式（2NF）：在满足 1NF 的基础上，消除非主属性对码的部分函数依赖
        第三范式（3NF）：在满足 2NF 的基础上，消除非主属性对码的传递函数依赖
        BC 范式（BCNF）：在满足 3NF 的基础上，消除主属性对码的部分和传递函数依赖
        第四范式（4NF）：消除非平凡的多值依赖
        第五范式（5NF）：消除一些不合适的连接依赖
        
     2.结构化查询语言包含 6 个部分：
        1、数据查询语言（DQL: Data Query Language）：其语句，也称为“数据检索语句”，用以从表
        中获得数据，确定数据怎样在应用程序给出。保留字 SELECT 是 DQL（也是所有 SQL）用得最多
        的动词，其他 DQL 常用的保留字有 WHERE，ORDER BY，GROUP BY 和 HAVING。这些 DQL 保
        留字常与其它类型的 SQL 语句一起使用。
        2、数据操作语言（DML：Data Manipulation Language）：其语句包括动词 INSERT、
        UPDATE 和 DELETE。它们分别用于添加、修改和删除。
        3、事务控制语言（TCL）：它的语句能确保被 DML 语句影响的表的所有行及时得以更新。包括
        COMMIT（提交）命令、SAVEPOINT（保存点）命令、ROLLBACK（回滚）命令。
        4、数据控制语言（DCL）：它的语句通过 GRANT 或 REVOKE 实现权限控制，确定单个用户和用
        户组对数据库对象的访问。某些 RDBMS 可用 GRANT 或 REVOKE 控制对表单个列的访问。
        5、数据定义语言（DDL）：其语句包括动词 CREATE,ALTER 和 DROP。在数据库中创建新表或修
        改、删除表（CREAT TABLE 或 DROP TABLE）；为表加入索引等。
        6、指针控制语言（CCL）：它的语句，像 DECLARE CURSOR，FETCH INTO 和 UPDATE WHERE 
        CURRENT 用于对一个或多个表单独行的操作
        
二、mysql 
    1.5.7和8.0的新特性
    2.mysql架构（图1）
    3.mysql执行流程（图2）
        3.1SQL的执行顺序：
             from on join where groupby having聚合函数 select orderby limit
        3.2mysql的配置参数优化
            1） 连接请求的变量 max_connections back_log** **wait_timeout和interative_timeout
            2）缓冲区的变量 key_buffer_size query_cache_size max_connect_errors sort_buffer_size max_allowed_packet join_buffer_size thread_cache_size
            3）innodb的几个变量 innodb_buffer_pool_size innodb_flush_log_at_trx_commit innodb_thread_concurrency innodb_log_buffer_size innodb_log_file_size innodb_log_files_in_group read_buffer_size read_rnd_buffer_size bulk_insert_buffer_size binary log
    4.mysql事务与锁
     4.1事务可靠性模型acid
      原子性： 原子性, 一次事务中的操作要么全部成功, 要么全部失败。
      一致性： 一致性, 跨表、跨行、跨事务, 数据库始终保持一致状态。
      隔离性： 隔离性, 可见性, 保护事务不会互相干扰, 包含4种隔离级别。
      持久性： 持久性, 事务提交成功后,不会丢数据。如电源故障, 系统崩溃。

      4.2 mysql事务
      读未提交: READ UNCOMMITTED （很少使用、容易造成脏读）
      读已提交: READ COMMITTED 每次查询都会设置和读取自己的新快照 容易造成幻读（ 加锁后, 不锁定间隙, 其他事务可以 INSERT）
      可重复读: REPEATABLE READ （InnoDB 的默认隔离级别）使用事务第一次读取时创建的快照
      串行化: SERIALIZABLE 最严格的级别，事务串行执行，资源消耗最大
      4.3 undolog 与 redolog
      undolog 一条 INSERT 语句，对应一条 DELETE 的 undo log 每个 UPDATE 语句，对应一条相反 UPDATE 的 undo log 用于回滚
      redolog 确保事务的持久性，防止事务提交后数据未刷新到磁盘就掉电或崩溃
      4.4 多版本并发控制
      查询正在被其他事务更新的数据时，会读取更新之前的版本，让查询不被阻塞、无需等待被其他事务持有的锁，这种技术手段可以增加并发性能
      
  5.db与sql优化
      5.1 常见的db设计与sql书写注意事项
      注意数据类型的选择
      设计表之前、通读dba的指导手册
      简单的sql可能带来更大的问题，where条件中注意数据类型，避免类型转换

      5.2 数据写入常见优化
      preparedStatement 减少sql解析
      Multiple Values/add batch 减少交互
      load data 直接导入
      索引和约束 问题

      5.3数据更新常见优化
      数据更新的范围尽量小
      注意gap lock
      导致锁的范围扩大

      5.4模糊查询
      like的问题
      前缀匹配
      尽量走索引然后进行关联查询
      全文检索时建议上es

      5.5连接查询问题优化
      连接查询的驱动表选择适当
      避免笛卡尔积

      5.6索引失效问题汇总
      NULL，not，not in，函数等
      减少使用 or，可以用 union
      大数据量时，直接考虑es
      必要时可以使用force index

      5.7sql设计的指导建议
      查询数据量和查询次数的平衡
      避免不必须的大量重复数据传输
      避免使用临时文件排序或临时表
      分析类需求，可以用汇总表
    
    
