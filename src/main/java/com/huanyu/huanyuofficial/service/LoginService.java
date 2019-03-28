package com.huanyu.huanyuofficial.service;

import com.huanyu.huanyuofficial.bean.base.BaseResponse;
import com.huanyu.huanyuofficial.bean.base.User;
import com.huanyu.huanyuofficial.param.LoginParam;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public BaseResponse<User> login(LoginParam loginParam) {
        if ("admin".equals(loginParam.getUsername()) && "123456".equals(loginParam.getPassword())){
            return new BaseResponse<>(200,"success",new User("系统管理员"));
        }
        return new BaseResponse<>(200,"用户名密码错误");
    }
}
