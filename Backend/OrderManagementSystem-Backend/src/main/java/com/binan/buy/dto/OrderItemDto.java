package com.binan.buy.dto;

import com.binan.buy.model.Business;
import com.binan.buy.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {
    // 一个订单项对应的相关信息
    private Business business;
    //
    private Order order;
}
