package com.huanyu.huanyuofficial.exception;

public class GainNotEnoughError extends BaseRuntimeException {
    public GainNotEnoughError() {
        setCode("gain.not.enough");
        setStatus(400);
    }
}
