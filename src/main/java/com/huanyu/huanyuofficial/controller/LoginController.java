package com.huanyu.huanyuofficial.controller;

import com.huanyu.huanyuofficial.bean.base.BaseResponse;
import com.huanyu.huanyuofficial.bean.base.User;
import com.huanyu.huanyuofficial.service.LoginService;
import com.huanyu.huanyuofficial.param.LoginParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @ApiOperation("登陆")
    @PostMapping
    public BaseResponse<User> login(@RequestBody LoginParam loginParam){
        return loginService.login(loginParam);
    }
}
