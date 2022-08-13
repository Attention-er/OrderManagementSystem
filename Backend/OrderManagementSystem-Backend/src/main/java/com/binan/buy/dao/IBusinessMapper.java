package com.binan.buy.dao;

import com.binan.buy.model.Business;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBusinessMapper {
    //查询商家列表
    List<Business> findAll();

    //添加商家
    int insert(Business business);

    //删除商家
    int delete(Business business);

    //更新商家信息
    int update(Business business);

    //根据id寻找商家信息
    Business findById(int id);

}
