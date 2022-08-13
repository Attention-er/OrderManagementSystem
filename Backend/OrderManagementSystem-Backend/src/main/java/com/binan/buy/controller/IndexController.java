package com.binan.buy.controller;

import com.binan.buy.model.Business;
import com.binan.buy.model.Types;
import com.binan.buy.dto.IndexDto;
import com.binan.buy.service.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
@CrossOrigin
public class IndexController {

    @Autowired
    private IBusinessService iBusinessService;

    @GetMapping("/index")
    public IndexDto index() {
        List<Business> bss = iBusinessService.findAllBusiness();
        List<Types> bts = iBusinessService.findAllTypes();
        IndexDto indexDto=new IndexDto();
        indexDto.setBss(bss);
        indexDto.setBts(bts);
        return  indexDto;
    }
}