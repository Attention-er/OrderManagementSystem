package com.binan.buy.service;

import com.binan.buy.model.FoodOrder;

import java.util.Map;

public interface IOrder_foodService {

    // 保存订单中的商品信息
    boolean saveFoodInfoOfOrder(FoodOrder foodOrder);

    // 查询指定订单的商品信息
    Map<String,Integer> findFoodInfoByOrderId(FoodOrder foodOrder);
}
