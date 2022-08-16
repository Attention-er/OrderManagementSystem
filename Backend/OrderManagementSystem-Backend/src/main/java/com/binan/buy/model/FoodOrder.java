package com.binan.buy.model;

import io.swagger.models.auth.In;
import lombok.Data;

import java.util.Map;

@Data
public class FoodOrder {
    private Integer id;
    private Map<Integer,Integer> foodInfoMap;
}
