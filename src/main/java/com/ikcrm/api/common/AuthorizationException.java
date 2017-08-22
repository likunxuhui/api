package com.ikcrm.api.common;

/**
 * Created by likun(li.k@ikcrm.com) on 2017/7/5.
 */
public class AuthorizationException extends RuntimeException {
    private int code;
    private String message;

    public AuthorizationException() {
    }

    public AuthorizationException(int code) {
        this.code = code;
    }

    public AuthorizationException(String message) {
        this.message = message;
    }

    public AuthorizationException(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public AuthorizationException(ErrorsEnum errorsEnum) {
        this.code = errorsEnum.getCode();
        this.message = errorsEnum.getMessage();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
