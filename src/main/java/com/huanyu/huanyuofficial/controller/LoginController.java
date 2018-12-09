package com.huanyu.huanyuofficial.controller;

import com.huanyu.huanyuofficial.service.LoginService;
import com.huanyu.huanyuofficial.vo.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping
    public void login(@RequestBody LoginParam loginParam){
        loginService.login(loginParam);
    }
}
