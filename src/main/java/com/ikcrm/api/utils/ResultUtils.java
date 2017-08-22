package com.ikcrm.api.utils;

import com.ikcrm.api.common.Result;
import com.ikcrm.api.common.ErrorsEnum;

/**
 * Created by likun(li.k@ikcrm.com) on 2017/6/30.
 */
public class ResultUtils {
    public static Result successDefault(){
        return successObject(null);
    }

    public static Result successObject(Object data){
        Result result = new Result();
        result.setCode(0);
        result.setData(data);
        return result;
    }

    public static Result errorDefault(){
        return erroe(ErrorsEnum.UNKNOWN_ERROR);
    }

    public static Result erroe(ErrorsEnum errorEnums){
        Result result = new Result();
        result.setCode(errorEnums.getCode());
        result.setMessage(errorEnums.getMessage());
        return result;
    }

    public static Result errorMsg(int code ,String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
