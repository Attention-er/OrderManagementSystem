package com.binan.buy.dao;

import com.binan.buy.model.Food_order;

import java.util.List;

public interface IOrderMapper {

    // 查询所有订单
    List<Food_order> findAll();

    // 根据订单id查询订单信息
    Food_order findOrderById(int id);

    // 根据用户id查询订单信息
    List<Food_order> findAllByUserId(int userId);

    // 保存订单信息
    int insertOrder(Food_order food_order);

    // 更新订单支付信息
    int updateOrder(Food_order food_order);
}
