package com.ohyoung.rpc.client.loadbalance;

import com.ohyoung.rpc.URL;

import java.util.List;

/**
 * 负载均衡：根据规则选取服务的地址
 */
public interface LoadBalancer {

    URL select(List<URL> urls);

}
