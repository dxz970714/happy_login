package com.happy.common;

public enum ErrorCode {
    ;

    private String code;
    private String errorMsg;


    // 枚举默认是单例的，构造方法必须是私有的
    private ErrorCode(String code,String errorMsg){
        this.code=code;
        this.errorMsg=errorMsg;
    }

    public String getCode() {
        return code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
