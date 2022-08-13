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
    private int id;
    private String name;
    private String img;
    private double rate;
    private double startPrice;
    private double deliveryPrice;
    private String explain;

}
