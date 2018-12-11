package com.huanyu.huanyuofficial.bean.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "服务响应结果", description = "响应结果")
public class BaseResponse<T> implements Serializable {
    @ApiModelProperty(name = "responseCode", value = "状态码", example = "200", required = true)
    private Integer responseCode;
    @ApiModelProperty(name = "responseMsg", value = "响应详细信息", example = "成功", required = true)
    private String responseMsg;
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public BaseResponse(Integer responseCode, String responseMsg) {
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
    }

    public BaseResponse(Integer responseCode, String responseMsg, T data) {
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
        this.data = data;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
