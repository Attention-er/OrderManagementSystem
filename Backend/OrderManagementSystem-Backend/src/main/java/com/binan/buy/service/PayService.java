package com.binan.buy.service;

public interface PayService {
    public String payOrder(Integer oid);
    public void finishPayment(String out_tar_no);
}
