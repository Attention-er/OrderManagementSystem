package com.binan.buy.dto;

import com.binan.buy.model.Business;
import com.binan.buy.model.Business_type;
import com.binan.buy.model.Types;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndexDto {
    private List<Business> bss;
    private List<Types> bts;
}
