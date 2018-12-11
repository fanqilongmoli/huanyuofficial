package com.huanyu.huanyuofficial.controller;

import com.huanyu.huanyuofficial.bean.base.BaseResponse;
import com.huanyu.huanyuofficial.bean.base.User;
import com.huanyu.huanyuofficial.service.LoginService;
import com.huanyu.huanyuofficial.vo.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping
    public BaseResponse<User> login(@RequestBody LoginParam loginParam){
        return loginService.login(loginParam);
    }
}
