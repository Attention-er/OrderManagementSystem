package com.binan.buy.controller;

import com.binan.buy.model.Business;
import com.binan.buy.model.Types;
import com.binan.buy.dto.IndexDto;
import com.binan.buy.service.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@CrossOrigin
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IBusinessService iBusinessService;

    @GetMapping("/fullPage")
    public IndexDto fullpage() {
        List<Business> bss = iBusinessService.findAllBusiness();
        List<Types> bts = iBusinessService.findAllTypes();
        IndexDto indexDto=new IndexDto();
        indexDto.setBss(bss);
        indexDto.setBts(bts);
        return  indexDto;
    }

    @GetMapping("/businessesByType")
    public List<Business> selBusinessesByType(@RequestParam(value = "typeId", required = true, defaultValue = "0") Integer typeId){
        List<Business> bss = iBusinessService.findByTypeId(typeId);
        return bss;
    }
}
