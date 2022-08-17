package com.binan.buy.dao;

import com.binan.buy.model.Order;
import com.binan.buy.model.OrderOutput;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderFoodMapper {
    public List<OrderOutput> selectOrderById(Integer id);

    public Integer insertOrder(Order order);

    public void insertFoodNum(Integer order_id,Integer food_id,Integer food_num);

    public OrderOutput selectOrderByOrderId(Integer id);

    public Boolean finishPay(Integer oid);
}
