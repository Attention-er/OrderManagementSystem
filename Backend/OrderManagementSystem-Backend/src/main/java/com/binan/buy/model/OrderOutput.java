package com.binan.buy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderOutput {
    private Integer id;
    private Integer userId;
    private Business business;
    private String address;
    private Double price;
    private Integer payState;
    private List<FoodNum> foodNum;
}
