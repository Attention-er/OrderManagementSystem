package com.binan.buy.service;

import com.binan.buy.model.Food_order;
import com.binan.buy.model.User;

import java.util.List;

public interface IOrderService {

    // 保存订单信息
    boolean saveOrderAndFoodInfo(Food_order foodOrder);

    // 查询订单信息
    List<Food_order> findAllByUserId(User user);
}
