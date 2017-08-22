package com.ikcrm.api.common;

import java.io.Serializable;

/**
 * Created by likun(li.k@ikcrm.com) on 2017/6/30.
 */
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
