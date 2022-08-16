package com.binan.buy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
/*
订单表（包括食物，购买者，商家，金额和地址）
 */
public class Food_order {
    private Integer id;
    private Integer businessId;
    private Integer userId;
    private String address;
    private Double price;
    private Integer pay;
    private Map<Integer,Integer> foodInfoMap; // 接收前端返回的订单中所有商品id,num键值对
}
