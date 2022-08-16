package com.binan.buy.controller;

import com.binan.buy.dto.OrderItemDto;
import com.binan.buy.dto.OrderListDto;
import com.binan.buy.model.Food_order;
import com.binan.buy.model.User;
import com.binan.buy.service.IBusinessService;
import com.binan.buy.service.IOrderService;
import com.binan.buy.service.IOrder_foodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Component
@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService iOrderService;

    @Autowired
    private IOrder_foodService iOrderFoodService;

    @Autowired
    private IBusinessService iBusinessService;

    // 前端向后端发送订单信息
    @PostMapping("/saveOrder")
    public boolean saveOrder(@RequestBody Food_order foodOrder){
        return iOrderService.saveOrderAndFoodInfo(foodOrder);
    }

    // 前端向后端请求用户的所有订单信息
    @PostMapping("/showOrderList")
    public OrderListDto getOrderList(@RequestBody User user){
        OrderListDto orderListDto = new OrderListDto();
        List<OrderItemDto> orderItemDtoList = new ArrayList<OrderItemDto>();
        List<Food_order> foodOrderList = iOrderService.findAllByUserId(user);
        for(Food_order food_order:foodOrderList){
            OrderItemDto orderItemDto = new OrderItemDto();
            orderItemDto.setFood_order(food_order);
            orderItemDto.setBusiness(iBusinessService.findBusinessById(food_order.getBusinessId()));
            orderItemDto.setFoodInfoMap(iOrderFoodService.findFoodInfoByOrderId(food_order));
            orderItemDtoList.add(orderItemDto);
        }
        orderListDto.setOrderItemDtoList(orderItemDtoList);
        return orderListDto;
    }
}
