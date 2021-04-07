package com.ohyoung.rpc.client.proxy;

import com.ohyoung.rpc.exception.RpcException;

public interface ProxyFactory {

    <T> T getProxy(Class serviceClass) throws RpcException;
}
