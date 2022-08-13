package com.binan.buy.service.impl;

import com.binan.buy.dao.IUserMapper;
import com.binan.buy.model.User;
import com.binan.buy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    private IUserMapper userMapper;
    @Override
    public boolean hasUser(User user) {
        return userMapper.findByUser(user).size()>0;
    }

    @Override
    public boolean save(User user) {
        return userMapper.insert(user)>0;
    }
}
