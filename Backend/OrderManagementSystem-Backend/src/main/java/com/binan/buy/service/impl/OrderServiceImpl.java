package com.binan.buy.service.impl;

import com.binan.buy.dao.OrderFoodMapper;
import com.binan.buy.model.Order;
import com.binan.buy.model.OrderOutput;
import com.binan.buy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    OrderFoodMapper orderFoodMapper;

    @Autowired
    public void setOrderFoodMapper(OrderFoodMapper orderFoodMapper) {
        this.orderFoodMapper = orderFoodMapper;
    }

    @Override
    public List<OrderOutput> selectOrderById(Integer userId) {
        return orderFoodMapper.selectOrderById(userId);
    }

    @Override
    public Boolean insertOrder(Order order) {
        try {
            Set<Map.Entry<Integer, Integer>> entrySet = order.getFoodInfoMap().entrySet();
            orderFoodMapper.insertOrder(order);
            for (Map.Entry<Integer, Integer> entry : entrySet) {
                orderFoodMapper.insertFoodNum(order.getId(), entry.getKey(), entry.getValue());
            }
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }
}
