package com.binan.buy.dao;

import com.binan.buy.model.FoodOrder;
import com.binan.buy.model.FoodOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface IOrderMapper {

    // 查询所有订单
    List<FoodOrder> findAll();

    // 根据订单id查询订单信息
    FoodOrder findOrderById(int id);

    // 根据用户id查询订单信息
    List<FoodOrder> findAllByUserId(int userId);

    // 保存订单信息
    int insertOrder(FoodOrder food_order);

    // 更新订单支付信息
    int updateOrder(FoodOrder food_order);
}
