package com.ohyoung;

import com.ohyoung.impl.RpcRequestResolver;
import com.ohyoung.order.OrderServiceImpl;
import com.ohyoung.order.domain.service.OrderService;
import com.ohyoung.rpc.register.RegisterCenter;
import com.ohyoung.rpc.RequestResolver;
import com.ohyoung.rpc.URL;
import com.ohyoung.rpc.register.ServiceRegister;
import com.ohyoung.rpc.server.ServerSkeleton;
import com.ohyoung.user.UserServiceImpl;
import com.ohyoung.user.domain.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于Socket编程接口的服务器实现
 */
public class Server {

    private static Logger logger = LoggerFactory.getLogger(Server.class);

    private static int port = 9010;

    public static void main(String[] args) {
        RequestResolver requestResolver = new RpcRequestResolver();
        ServerSkeleton serverSkeleton = new ServerSkeleton(requestResolver);

        logger.warn("start register services...");
        RegisterCenter.registerService(UserService.class.getName(), new URL("localhost", port));
        RegisterCenter.registerService(OrderService.class.getName(), new URL("localhost", port));

        logger.warn("start register classes...");
        ServiceRegister.registerService(UserService.class.getName(), UserServiceImpl.class);
        ServiceRegister.registerService(OrderService.class.getName(), OrderServiceImpl.class);

        logger.warn("start server...");
        while (true) {
            logger.warn("server running...");
            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket socket = serverSocket.accept()) {
                serverSkeleton.process(socket);
                logger.warn("process client");
            } catch (IOException e) {
                logger.error("server error...");
            }
        }

    }
}
