package com.ohyoung.rpc;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class URL implements Serializable {
    private String host;
    private Integer port;
    private String version;

    public URL(String host, Integer port) {
        this.host = host;
        this.port = port;
    }
}
