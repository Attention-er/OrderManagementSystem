package com.binan.buy.controller;

import com.binan.buy.model.Order;
import com.binan.buy.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("pay")
public class PayController {
    PayService payService;
    @Autowired
    private void setPayService(PayService payService){
        this.payService = payService;
    }
    @ResponseBody
    @PostMapping("payOrder")
    public String payOrder(@RequestBody Order orderId){
        return payService.payOrder(orderId.getId());
    }
    @PostMapping("/notifyUrl")
    public void notifyUrl(HttpServletRequest request, HttpServletResponse response) {
        String out_trade_no = null;
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (String s : parameterMap.keySet()) {
            String[] strings = parameterMap.get(s);
            for (int i = 0; i < strings.length; i++) {
                if (s.equals("out_trade_no")) {
                    out_trade_no = strings[i];
                    break;
                }
            }
        }
        payService.finishPayment(out_trade_no);
    }
    @RequestMapping("/returnUrl")
    public String returnUrl(HttpServletRequest request, HttpServletResponse response) {
        return "<script>" +
                "window.opener = null;" +
                "window.open(\"\", \"_self\");" +
                "window.close();" +
                "</script>";
    }
}
