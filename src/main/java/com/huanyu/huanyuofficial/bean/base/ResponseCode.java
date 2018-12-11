package com.huanyu.huanyuofficial.bean.base;

public enum ResponseCode {

    OK(200, "成功"),
    SERVER_FAILED(500, "失败"),
    PARAMETER_VALIDATION_FAILED(2001, "参数不合法"),
    PARAMETER_ISNULL(2002, "参数为空"),

    SESSION_TIME_OUT(3000,"session过期,请重新登录！！！"),
    USERNAME_OR_PWD_WRONG(3001,"用户名或者密码错误"),
    CONSUMER_NOT_HAVE(3002,"请先确定所要查询的用户"),
    PLEASE_LOGIN(3003,"请先登录"),
    PHONE_CANT_BE_NULL(3004,"请输入手机号"),
    PWD_CANT_NULL(3005,"请输入密码"),
    CONSUMER_HAVE_FUNDS(3006,"账户余额不为零，不能删除该用户"),
    CONSUMER_TEAM_NOT_HAVE_MEMBER(3007,"该用户无此团队人员"),


    TOKEN_TIME_OUT(4000,"token失效"),
    CHCEK_CODE_WRONG(4001,"验证码输入错误"),
    PHONE_HAS_REGIST(4002,"手机号已被注册"),
    PLEASE_REGISTE(4003,"手机号未注册，请先注册"),
    PASSWORD_WRONG(4004,"密码错误"),
    TWO_DIMENSIONCODE_WRONG(4005,"二维码错误"),
    CHECK_CODE_TIME_OUT(4006,"检验码失效，请重新发送！！！"),
    MESSAGE_SEND_WRONG(4007,"短信发送失败"),
    PHONR_NO_WRONG(4008,"手机号输入错误！！！"),
    FLOATFUNDS_NOT_ENOUGH(4009,"现有资金数量不足！！！"),
    PHONE_NOT_REGIST(4010,"该手机号未注册！！！"),
    NOT_HAVE_FUNDS_PWD(4011,"未设置资金密码！！！"),
    OLD_PWD_WRONG(4012,"旧密码不正确！！！"),
    NOT_HAVE_TOKEN(4013,"无token，请重新登录"),
    CONSUMER_DONOT_HAVE(4014,"用户不存在，请重新登录"),
    NEW_PASSWORD_WRONG(4015,"新密码与旧密码相同，请重新设置！！！"),
    NOT_HAVE_PUBDATE(4016,"上线日期不存在"),
    PWD_CANT_BE_NULL(4017,"密码不能为空！！！"),
    ACCONUT_NOT_HAVE(4018,"当前用户账户不存在！！！"),
    SETTING_NOT_HAVE(4019,"当前用户设置信息不存在！！！"),
    ADDRESS_NOT_INVALID(4020,"转账地址无效！！！"),
    PHONE_CANTNULL(4021,"请输入手机号"),
    REFEREE_CANTNULL(4022,"请输入邀请码"),
    SMS_SOURCE_NOT_KNOW(4023,"短信来源未知"),
    CONSUMER_DELETED(4024,"对不起，该手机号的用户已失效！！！"),
    INTERACCOUNT_NOT_HAVE(4025,"内部账地址不存在！！！")
    ;

    private int code;
    private String message;
    private ResponseCode(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
