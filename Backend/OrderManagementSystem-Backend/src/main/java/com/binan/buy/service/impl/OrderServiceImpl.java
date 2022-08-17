package com.binan.buy.service.impl;

import com.binan.buy.dao.OrderFoodMapper;
import com.binan.buy.model.FoodIdNum;
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
    public Integer insertOrder(Order order) {
        try {
            orderFoodMapper.insertOrder(order);
            for (FoodIdNum foodIdNum: order.getFoodIdNums()) {
                orderFoodMapper.insertFoodNum(order.getId(), foodIdNum.getFoodId(), foodIdNum.getFoodNum());
            }
            return order.getId();
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public OrderOutput selectOrderByOrderId(Integer orderId){
        return orderFoodMapper.selectOrderByOrderId(orderId);
    }
}
