package com.binan.buy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/*
用户注册表
 */
public class User {
    private int id;
    private String userName;
    private String passWord;
    private String phoneNumber;
    private String address;
}
