package com.ohyoung.order;

import com.ohyoung.order.domain.entity.Order;
import com.ohyoung.order.domain.service.OrderService;

public class OrderServiceImpl implements OrderService {

    @Override
    public Order getByOrderNo(String orderNo) {
        return new Order(1, orderNo);
    }
}
