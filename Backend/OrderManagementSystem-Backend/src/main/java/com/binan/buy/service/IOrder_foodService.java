package com.binan.buy.service;

import com.binan.buy.model.Food_order;

import java.util.Map;

public interface IOrder_foodService {

    // 保存订单中的商品信息
    boolean saveFoodInfoOfOrder(Food_order foodOrder);

    // 查询指定订单的商品信息
    Map<String,Integer> findFoodInfoByOrderId(Food_order foodOrder);
}
