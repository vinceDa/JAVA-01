一、rpc 
  1.1定义：远程过程调用（像调用本地方法一样调用远程方法）
  1.2rpc的原理
    代理
    序列化
    网络传输
    查找实现类
二、dubbo
    2.1Apache Dubbo 是一款高性能、轻量级的开源 Java 服务框架
    2.2主要功能
      rpc调用 支持 多协议 服务的注册与发现 配置、元数据管理(
    2.3dubbo的技术原理
    （图）
      config配置层：对外配置接口，以 ServiceConfig, ReferenceConfig 为中心，可以直接初始化配置类，也可以通过 spring 解析配置生成配置类
      proxy 服务代理层：服务接口透明代理，生成服务的客户端 Stub 和服务器端 Skeleton, 以ServiceProxy 为中心，扩展接口为 ProxyFactory
      registry 注册中心层：封装服务地址的注册与发现，以服务 URL 为中心，扩展接口为RegistryFactory, Registry, RegistryService
      cluster路由层：封装多个提供者的路由及负载均衡，并桥接注册中心，以 Invoker 为中心，扩展接口为 Cluster, Directory, Router, LoadBalance
      monitor 监控层：RPC 调用次数和调用时间监控，以 Statistics 为中心，扩展接口为MonitorFactory, Monitor, MonitorService
      protocol 远程调用层：封装 RPC 调用，以 Invocation, Result 为中心，扩展接口为 Protocol,  Invoker, Exporter
      exchange 信息交换层：封装请求响应模式，同步转异步，以 Request, Response 为中心，扩展接口为 Exchanger, ExchangeChannel, ExchangeClient, ExchangeServer
      transport 网络传输层：抽象 mina 和 netty 为统一接口，以 Message 为中心，扩展接口为Channel, Transporter, Client, Server, Codec
      serialize 数据序列化层：可复用的一些工具，扩展接口为 Serialization, ObjectInput,  ObjectOutput, ThreadPool
      
三、分布式服务治理
  3.1分布式服务要素
    集群/分组/版本 => 分布式与集群
    注册中心/注册/发现
    路由/负载均衡
    过滤/流控
    心跳，重试等策略
    高可用、监控、性能等等
  3.2服务注册
    将自己注册到注册中心（比如zk实现）的临时节点
     停止或者宕机时，临时节点消失
  3.3服务发现
    根据router和loadbalance算法从其中的某一个执行调用
    如果可用的提供者集合发生变化时，注册中心通知消费者刷新本地缓存的列表
    
 四、微服务架构
   4.1springcloud
      注册中心
      配置中心
      网关
      rpc
      熔断
