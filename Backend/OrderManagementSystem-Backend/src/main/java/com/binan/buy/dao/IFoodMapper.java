package com.binan.buy.dao;

import com.binan.buy.model.Food;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface IFoodMapper {
    //通过商家id查询商家售卖食物
    List<Food> selFoodById(int id);
}
