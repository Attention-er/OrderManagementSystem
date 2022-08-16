package com.binan.buy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*
商家信息表
 */
public class Business {
    private Integer id;
    private String name;
    private String img;
    private Double rate;
    private Double startPrice;
    private Double deliveryPrice;
    private String explain;

}
