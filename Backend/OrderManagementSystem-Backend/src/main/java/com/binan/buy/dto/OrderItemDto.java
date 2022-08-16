package com.binan.buy.dto;

import com.binan.buy.model.Business;
import com.binan.buy.model.Food_order;
import com.binan.buy.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {
    // 一个订单项对应的相关信息
    private Business business;
    private Food_order food_order;
    private Map<String,Integer> foodInfoMap;
}
