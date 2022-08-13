package com.binan.buy.controller;

import com.binan.buy.model.User;
import com.binan.buy.service.IUserService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
@Component
@CrossOrigin
public class UserController {
    private IUserService userService;

    //注册接口根据返回的user信息判断用户是否存在
    @PostMapping("/register")
    public int register(@RequestBody User user) {

        int flag;
        if (userService.hasUser(user)) {
            flag = -1;
        } else {
            if (userService.save(user)) {
                flag = 1;
            } else {
                flag = 0;
            }
        }
        return flag;
    }

    //登录功能，根据返回的user对象查询数据表，若返回true用户存在登录跳转
    @PostMapping("/login")
    public boolean login(@RequestBody User user, HttpServletRequest request,
                         HttpServletResponse response) {
        boolean flag = false;
        HttpSession session = null;
        if (userService.hasUser(user)) {
            //前端可以根据用户点击登录按钮后，判断session中是否有user属性来判断用户登录是否成功
            session = request.getSession();
            session.setAttribute("user", user);
            flag = true;
        }
        return flag;
    }
}
