package com.binan.buy.dao;

import com.binan.buy.model.Types;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITypesMapper {
    //查询所有类型
  List<Types> findAll();
}
