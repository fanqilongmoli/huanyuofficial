package com.huanyu.huanyuofficial.exception;

public class ResetPasswordError extends BaseRuntimeException {
    public ResetPasswordError() {
        setCode("password.reset.error");
        setStatus(400);
    }
}
