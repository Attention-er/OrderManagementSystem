package com.binan.buy.service.impl;

import com.binan.buy.dao.IOrderMapper;
import com.binan.buy.model.FoodOrder;
import com.binan.buy.model.FoodOrder;
import com.binan.buy.model.User;
import com.binan.buy.service.IOrderService;
import com.binan.buy.service.IOrder_foodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IOrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderMapper iOrderMapper;

    @Autowired
    private IOrder_foodService iOrderFoodService;

    @Override
    public boolean saveOrderAndFoodInfo(FoodOrder foodOrder) {
        boolean ret;
        if(iOrderMapper.insertOrder(foodOrder)>0 && iOrderFoodService.saveFoodInfoOfOrder(foodOrder)){
            ret = true;
        }else{
            ret =  false;
        }
        return ret;
    }

    @Override
    public List<FoodOrder> findAllByUserId(User user) {
        return iOrderMapper.findAllByUserId(user.getId());
    }
}
