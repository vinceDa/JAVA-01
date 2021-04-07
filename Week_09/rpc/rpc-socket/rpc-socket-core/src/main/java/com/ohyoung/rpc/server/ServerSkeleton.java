package com.ohyoung.rpc.server;

import cn.hutool.core.util.StrUtil;
import com.ohyoung.rpc.RequestResolver;
import com.ohyoung.rpc.RpcRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

@Slf4j
public class ServerSkeleton {

    private RequestResolver requestResolver;

    public ServerSkeleton(RequestResolver requestResolver) {
        this.requestResolver = requestResolver;
    }

    public void process(Socket socket) {
        try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

            RpcRequest request = (RpcRequest) in.readObject();
            if (request == null) {
                return;
            }
            String className = request.getClassName();
            String methodName = request.getMethodName();
            if (StrUtil.isAllBlank(className, methodName)) {
                return;
            }

            Class<?>[] parameterTypes = request.getParameterTypes();
            Object[] parameters = request.getParameters();
            Class clazz = requestResolver.resolve(className);
            Method method = clazz.getMethod(methodName, parameterTypes);
            if (method == null) {
                return;
            }
            Object result = method.invoke(clazz.getDeclaredConstructor().newInstance(), parameters);
            out.writeObject(result);
        } catch (Exception e) {
        }
    }
}
