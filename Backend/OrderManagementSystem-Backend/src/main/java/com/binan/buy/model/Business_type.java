package com.binan.buy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*
商家-类型中间表
 */
public class Business_type {
    private Integer id;
    private Integer businessId;
    private Integer typeId;
}
