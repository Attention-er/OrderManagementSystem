package com.binan.buy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/*
订单表（包括食物，购买者，商家，金额和地址）
 */
public class Food_order {
    private int id;
    private int foodId;
    private int businessId;
    private int userId;
    private String address;
    private double price;
}
