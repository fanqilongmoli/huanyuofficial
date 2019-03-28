package com.huanyu.huanyuofficial.exception;

public class LoginError extends BaseRuntimeException {
    public LoginError() {
        setCode("login.error");
        setStatus(400);
    }
}
