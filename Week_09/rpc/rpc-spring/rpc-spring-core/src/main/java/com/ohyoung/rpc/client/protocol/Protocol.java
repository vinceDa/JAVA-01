package com.ohyoung.rpc.client.protocol;

import com.ohyoung.rpc.RpcRequest;
import com.ohyoung.rpc.URL;

public interface Protocol {
    Object doRequest(RpcRequest request, URL url);
}
