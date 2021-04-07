package com.ohyoung.order.domain.service;


import com.ohyoung.order.domain.entity.Order;

/**
 * @author ohYoung
 * @date 2021/4/8 0:09
 */
public interface OrderService {

    /**
     * 根据订单编号获取订单信息
     *
     * @param orderNo 订单编号
     * @return 订单信息
     */
    Order getByOrderNo(String orderNo);
}
