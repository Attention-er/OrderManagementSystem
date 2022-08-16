package com.binan.buy.service.impl;

import com.binan.buy.dao.IBusinessMapper;
import com.binan.buy.dao.ITypesMapper;
import com.binan.buy.model.Business;
import com.binan.buy.model.Types;
import com.binan.buy.service.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IBusinessServiceImpl implements IBusinessService {

    @Autowired
    private IBusinessMapper iBusinessMapper;

    @Autowired
    private ITypesMapper iTypesMapper;

    @Override
    public List<Business> findAllBusiness() {
        return iBusinessMapper.findAll();
    }

    @Override
    public List<Types> findAllTypes() {
        return iTypesMapper.findAll();
    }

    @Override
    public List<Business> findByTypeId(Integer typeId) {
        return iBusinessMapper.findAllByTypeId(typeId);
    }

    @Override
    public Business findBusinessById(Integer id) {
        return iBusinessMapper.findById(id);
    }

}
