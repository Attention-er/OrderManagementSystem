package com.binan.buy.dto;

import com.binan.buy.model.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {
    private List<Food> foodList;
}
