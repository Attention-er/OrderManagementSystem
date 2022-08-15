package com.binan.buy.service;

import com.binan.buy.model.User;

import java.util.List;

public interface IUserService {

    //通过账号密码查询是否有用户存在
    boolean hasUser(User user);

    //向用户表中添加注册数据
    boolean save(User user);
}
