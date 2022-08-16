package com.binan.buy.service;

import com.binan.buy.model.Food;
import com.binan.buy.model.FoodOrder;
import com.binan.buy.model.User;

import java.util.List;

public interface IOrderService {

    // 保存订单信息
    boolean saveOrderAndFoodInfo(FoodOrder foodOrder);

    // 查询订单信息
    List<FoodOrder> findAllByUserId(User user);
}
