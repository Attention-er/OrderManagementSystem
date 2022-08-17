package com.binan.buy.service;

import com.binan.buy.model.Order;
import com.binan.buy.model.OrderOutput;

import java.util.List;

public interface OrderService {
    /**
     * 按用户id返回order列表
     *
     * @param userId 用户id
     * @return order列表
     */
    List<OrderOutput> selectOrderById(Integer userId);

    Integer insertOrder(Order order);

    OrderOutput selectOrderByOrderId(Integer orderId);
}
