package com.happy.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;


@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable{

    /**
     * z状态码
     */
    private int status;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回实体数据
     */
    private T data;

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {

        return data;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    private ServerResponse(int status){
        this.status = status;
    }
    private ServerResponse(int status,T data){
        this.status = status;
        this.data=data;
    }

    private ServerResponse(int status, String msg){
        this.status = status;
        this.msg=msg;
    }
    private ServerResponse(int status,String msg,T data){
        this.status = status;
        this.msg=msg;
        this.data=data;
    }

    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<>(ResponseCode.SUCCESS.getStatus());
    }

    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<>(ResponseCode.SUCCESS.getStatus(),data);
    }
    public static <T> ServerResponse<T> createBySuccessMsg(String msg){
        return new ServerResponse<>(ResponseCode.SUCCESS.getStatus(),msg);
    }
    public static <T> ServerResponse<T> createBySuccess(String msg,T data){
        return new ServerResponse<>(ResponseCode.SUCCESS.getStatus(),msg,data);
    }
    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<>(ResponseCode.ERROR.getStatus());
    }

    public static <T> ServerResponse<T> createByErrorMsg(String msg){
        return new ServerResponse<>(ResponseCode.ERROR.getStatus(),msg);
    }
    public static <T> ServerResponse<T> createByErrorMsg(int errorCode,String msg){
        return new ServerResponse<>(errorCode,msg);
    }

    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess(){
        return this.status==ResponseCode.SUCCESS.getStatus();
    }
}
