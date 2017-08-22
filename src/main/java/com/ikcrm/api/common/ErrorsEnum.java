package com.ikcrm.api.common;

/**
 * Created by likun(li.k@ikcrm.com) on 2017/6/30.
 */
public enum ErrorsEnum {
    UNKNOWN_ERROR(-1,"未知异常"),
    USER_NOT_LOGGED_IN(401,"用户未登陆"),
    DEVICE_NOT_AVAILABLE(100000,"device参数错误"),
    LOGIN_EXPIRED(100401,"您的登录已经过期，请重新登录！"),
    REQUEST_SERVICE_ERROR(-101,"请求服务发生错误"),
    USER_NOT_EXIST(-102,"用户不存在"),
    NO_OPERATION_AUTHORITY(-103,"没有%s的权限哦！");
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ErrorsEnum(int code, String message){
        this.code=code;
        this.message=message;
    }

}
