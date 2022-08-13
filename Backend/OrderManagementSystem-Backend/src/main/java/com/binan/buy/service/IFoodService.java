package com.binan.buy.service;

import com.binan.buy.model.Food;

import java.util.List;

public interface IFoodService {
    List<Food> selFoodById(int id);
}
