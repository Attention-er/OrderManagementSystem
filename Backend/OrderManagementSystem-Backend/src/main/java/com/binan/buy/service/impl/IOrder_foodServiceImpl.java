package com.binan.buy.service.impl;

import com.binan.buy.dao.IOrder_foodMapper;
import com.binan.buy.handler.FoodInfoMapResultHandler;
import com.binan.buy.model.Food_order;
import com.binan.buy.service.IOrder_foodService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class IOrder_foodServiceImpl implements IOrder_foodService {

    @Autowired
    private IOrder_foodMapper iOrderFoodMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public boolean saveFoodInfoOfOrder(Food_order foodOrder) {
        boolean ret = true;
        int orderId = foodOrder.getId();
        Map<Integer, Integer> foodInfoMap = foodOrder.getFoodInfoMap();
        for(Map.Entry<Integer,Integer> entry:foodInfoMap.entrySet()){
            Integer foodId = entry.getKey();
            Integer foodNum = entry.getValue();
            if(iOrderFoodMapper.insertFoodInfo(orderId,foodId,foodNum)<=0){
                ret = false;
                break;
            }
        }
        return ret;
    }

    @Override
    public Map<String, Integer> findFoodInfoByOrderId(Food_order foodOrder) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        FoodInfoMapResultHandler mapResultHandler = new FoodInfoMapResultHandler();
        sqlSession.select("com.binan.buy.dao.IOrder_foodMapper.findFoodInfoByOrderId",foodOrder.getId(),mapResultHandler);
        return mapResultHandler.getMapResult();
    }
}
