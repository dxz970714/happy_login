package com.happy.common;


public class GeneralException extends RuntimeException{

    private ErrorCode errorCode;
    private String errorMsg;


    public GeneralException(String msg){
        super(msg);

    }
    public GeneralException(ErrorCode errorCode){
        this.errorCode = errorCode;
        this.errorMsg = errorCode.getErrorMsg();
    }
}
