package com.ohyoung.rpc.client.protocol.impl;

import com.alibaba.fastjson.JSONObject;
import com.ohyoung.rpc.RpcRequest;
import com.ohyoung.rpc.RpcResponse;
import com.ohyoung.rpc.URL;
import com.ohyoung.rpc.client.protocol.Protocol;
import com.ohyoung.rpc.exception.RpcException;
import org.springframework.web.client.RestOperations;

public class SpringRestOperationsProtocol implements Protocol {

    private RestOperations restOperations;

    public SpringRestOperationsProtocol(RestOperations restOperations) {
        this.restOperations = restOperations;
    }

    @Override
    public Object doRequest(RpcRequest request, URL url) {
        try {
            RpcResponse result = restOperations.postForObject(url.getUrl(), request, RpcResponse.class);
            return JSONObject.parse(result.getData().toString());
        } catch (Exception e) {
            return new RpcException("CREATE_SERVICE_001", "Create service failed.");
        }
    }
}
