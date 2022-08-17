package com.binan.buy.controller;

import com.binan.buy.dao.OrderFoodMapper;
import com.binan.buy.dto.OrderItemDto;
import com.binan.buy.dto.OrderListDto;
import com.binan.buy.model.FoodOrder;
import com.binan.buy.model.Order;
import com.binan.buy.model.OrderOutput;
import com.binan.buy.model.User;
import com.binan.buy.service.IBusinessService;
import com.binan.buy.service.IOrderService;
import com.binan.buy.service.IOrder_foodService;
import com.binan.buy.service.OrderService;
import io.swagger.models.auth.In;
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

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getOrder")
    public OrderOutput getOrder(Integer orderId){
        return orderService.selectOrderByOrderId(orderId);
    }
    // 前端向后端发送订单信息
    @PostMapping("/saveOrder")
    public Integer saveOrder(@RequestBody Order order) {
        return orderService.insertOrder(order);
    }

    // 前端向后端请求用户的所有订单信息
    @GetMapping("/showOrderList")
    public List<OrderOutput> getOrderList(Integer userId) {
        return orderService.selectOrderById(userId);
    }
}
