package com.binan.buy.dao;

import com.binan.buy.model.Business;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBusinessMapper {
    //查询商家列表
    List<Business> findAll();

    //根据id寻找商家信息
    Business findById(int id);

    //根据typeid查询商家列表
    List<Business> findAllByTypeId(int typeId);
}
