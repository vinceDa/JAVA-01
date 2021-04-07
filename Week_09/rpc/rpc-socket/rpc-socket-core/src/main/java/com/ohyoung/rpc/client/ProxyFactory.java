package com.ohyoung.rpc.client;

import com.ohyoung.rpc.LoadBalancer;
import com.ohyoung.rpc.RpcRequest;
import com.ohyoung.rpc.URL;
import com.ohyoung.rpc.exception.RpcException;
import com.ohyoung.rpc.register.RegisterCenter;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.util.List;

public class ProxyFactory<T> {

    public static <T> T getProxy(Class clazz, LoadBalancer loadBalancer) throws RpcException {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, (proxy, method, args) -> {
            String className = clazz.getName();

            List<URL> urls = RegisterCenter.getUrls(className);
            URL url = loadBalancer.select(urls);
            if (url == null) {
                return new RpcException("CREATE_SERVICE_000", String.format("Create service %s failed.", className));
            }

            try (Socket socket = new Socket(url.getHost(), url.getPort());
                 ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                 ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
                out.writeObject(new RpcRequest()
                        .setClassName(clazz.getName())
                        .setMethodName(method.getName())
                        .setParameterTypes(method.getParameterTypes())
                        .setParameters(args));
                out.flush();
                return in.readObject();
            } catch (Exception e) {
                return new RpcException("CREATE_SERVICE_001", "Create service failed.");
            }
        });
    }
}
