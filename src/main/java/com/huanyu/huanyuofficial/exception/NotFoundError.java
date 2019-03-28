package com.huanyu.huanyuofficial.exception;

public class NotFoundError extends BaseRuntimeException {
    public NotFoundError() {
        setCode("not.found");
        setStatus(404);
    }
}
