package com.binan.buy.service;

import com.binan.buy.model.Business;
import com.binan.buy.model.Types;

import java.util.List;

public interface IBusinessService {
    //查询商家列表
    List<Business> findAllBusiness();

    //查询商家类型
    List<Types> findAllTypes();

 /*   //添加商家
    boolean insert(Business business);

    //删除商家
    boolean delete(Business business);

    //更新商家信息
    boolean update(Business business);

    //根据id寻找商家信息
    Business findById(int id);*/
}
