package com.ohyoung.order.domain.entity;

/**
 * @author ohYoung
 * @date 2021/4/8 0:09
 */

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 订单实体
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单标识
     */
    private int id;

    /**
     * 订单编号
     */
    private String orderNo;

    public Order(int id, String orderNo) {
        this.id = id;
        this.orderNo = orderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }
}
