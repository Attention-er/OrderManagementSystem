package com.binan.buy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/*
食物表
 */
public class Food {
    private Integer id;
    private String name;
    private String img;
    private String explain;
    private Double price;
    private Integer businessId;
}
