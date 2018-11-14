package com.shuang.girl.enums;

public enum ResultEnum {
    PRIMARY_SCHOOL(100,"小学"),
    MIDDLE_SCHOOL(101,"中学"),
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}