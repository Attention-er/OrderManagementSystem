package com.binan.buy;

import com.binan.buy.dao.OrderFoodMapper;
import com.binan.buy.model.Order;
import com.binan.buy.model.OrderOutput;
import io.swagger.models.auth.In;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class OrderManagementSystemApplicationTests {

    @Autowired
    OrderFoodMapper orderFoodMapper;

    @Test
    void contextLoads() {
        List<OrderOutput> orderOutput = orderFoodMapper.selectOrderById(1);
        for (OrderOutput orderOutput1 : orderOutput) {
            System.out.println(orderOutput1);
        }
    }

    @Test
    void test01() {
        Order order = new Order();
        order.setBusinessId(10010);
        order.setUserId(1);
        order.setAddress("1998");
        order.setPrice(19.98);
        order.setPay(1);
        Map<Integer, Integer> foodInfoMap = new HashMap<>();
        foodInfoMap.put(1, 3);
        foodInfoMap.put(2, 5);
        order.setFoodInfoMap(foodInfoMap);
        orderFoodMapper.insertOrder(order);
        Set<Map.Entry<Integer, Integer>> entrySet = foodInfoMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            orderFoodMapper.insertFoodNum(order.getId(),entry.getKey(),entry.getValue());
        }
        System.out.println(order.getId());
    }

}
