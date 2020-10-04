package com.happy.common;

public enum  ResponseCode {

    SUCCESS(0,"成功"),
    ERROR(1,"失败"),
    ;


    private Integer status;
    private String msg;

    ResponseCode(Integer status,String msg){
        this.status=status;
        this.msg=msg;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
