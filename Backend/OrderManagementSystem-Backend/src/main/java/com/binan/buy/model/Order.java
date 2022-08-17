package com.binan.buy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
/*
订单表（包括食物，购买者，商家，金额和地址）
 */
public class Order {
    // 订单id
    private Integer id;
    // 店铺id
    private Integer businessId;
    // 购买者id
    private Integer userId;
    // 订单地址
    private String address;
    // 订单价格
    private Double price;
    // 支付状态 0：未支付，1：已支付
    private Integer pay;
    // 存储食品及对应信息的map
    private List<FoodIdNum> foodIdNums; // 接收前端返回的订单中所有商品id,num键值对
}
