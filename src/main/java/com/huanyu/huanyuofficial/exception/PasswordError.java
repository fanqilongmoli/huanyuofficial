package com.huanyu.huanyuofficial.exception;

public class PasswordError extends BaseRuntimeException {
    public PasswordError() {
        setCode("password.error");
        setStatus(400);
    }
}
