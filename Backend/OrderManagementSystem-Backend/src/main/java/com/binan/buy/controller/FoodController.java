package com.binan.buy.controller;

import com.binan.buy.dto.FoodDto;
import com.binan.buy.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@CrossOrigin
public class FoodController {

    @Autowired
    private IFoodService iFoodService;

    //根据前端返回商户id 查询并获取相应的售货食物
    @GetMapping("/foodList")
    public FoodDto selFoodById(@RequestParam(value = "businessId", required = true, defaultValue = "0") int id) {
        FoodDto fdt = new FoodDto();
        fdt.setFoodList(iFoodService.selFoodById(id));
        return fdt;
    }
}
