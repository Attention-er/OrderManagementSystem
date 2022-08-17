package com.binan.buy.service.impl;

import com.binan.buy.dao.OrderFoodMapper;
import com.binan.buy.model.Order;
import com.binan.buy.model.OrderOutput;
import com.binan.buy.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayServiceDemo implements PayService {
    OrderFoodMapper orderFoodMapper;

    @Autowired
    public void setOrderFoodMapper(OrderFoodMapper orderFoodMapper) {
        this.orderFoodMapper = orderFoodMapper;
    }

    @Override
    public String payOrder(Integer oid) {
        OrderOutput orderOutput = orderFoodMapper.selectOrderByOrderId(oid);
        finishPayment(orderOutput.getId().toString());
        return "支付成功";
    }

    @Override
    public void finishPayment(String out_tar_no) {
        Integer oid = Integer.valueOf(out_tar_no);
        orderFoodMapper.finishPay(oid);
    }
}
