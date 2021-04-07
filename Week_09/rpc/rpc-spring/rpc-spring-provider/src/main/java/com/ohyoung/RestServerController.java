package com.ohyoung;

import com.ohyoung.rpc.RpcRequest;
import com.ohyoung.rpc.RpcResponse;
import com.ohyoung.rpc.server.ServerSkeleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestServerController {

    @Autowired
    private ServerSkeleton serverSkeleton;

    @PostMapping("/")
    public RpcResponse invokeService(@RequestBody RpcRequest rpcRequest) {
        return serverSkeleton.process(rpcRequest);
    }

}
