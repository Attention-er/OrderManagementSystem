package com.binan.buy.dao;

import com.binan.buy.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface IUserMapper {

    //通过账号密码查询是否有用户存在
    List<User> findByUser(User user);

    //向用户表中添加注册数据
    int insert(User user);
}
