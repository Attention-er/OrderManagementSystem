package com.binan.buy.dao;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.Map;

public interface IOrder_foodMapper {

    // 根据订单id查询所有商品信息（商品名，商品数量）
    Map<String,Integer> findFoodInfoByOrderId(int orderId);

    // 保存订单中的商品信息
    int insertFoodInfo(@Param("orderId") int orderId, @Param("foodId") int foodId,@Param("foodNum") int foodNum);
}
