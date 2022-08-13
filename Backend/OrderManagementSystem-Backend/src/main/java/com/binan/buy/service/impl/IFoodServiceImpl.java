package com.binan.buy.service.impl;

import com.binan.buy.dao.IFoodMapper;
import com.binan.buy.model.Food;
import com.binan.buy.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IFoodServiceImpl implements IFoodService {
    @Autowired
    private IFoodMapper iFoodMapper;
    @Override
    public List<Food> selFoodById(int id) {
        return iFoodMapper.selFoodById(id);
    }
}
