package com.huanyu.huanyuofficial.exception;

public class UnLoggedException extends BaseRuntimeException {
    public UnLoggedException() {
        setCode("not.logged.in");
        setStatus(401);
    }
}
