package com.bug.itoken.common.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BaseResult implements Serializable {
    public static final String RESULT_OK = "ok";
    public static final String RESULT_NOT_OK="not_ok";
    public static final String SUCCESS="成功操作";

    private String result;
    private Object data;
    private String success;
    private Cursor cursor;
    private List<Error> errors;

    public static BaseResult ok(){
        return createResult(RESULT_OK,null,SUCCESS,null,null);
    }
    public static BaseResult ok(Object data){
        return createResult(RESULT_OK,data,SUCCESS,null,null);
    }
    public static BaseResult notOk(List<Error> errors){
        return createResult(RESULT_OK,null,"",null,errors);
    }



    public static BaseResult createResult(String result,Object data,String success,Cursor cursor,List<BaseResult.Error> errors){
        BaseResult baseResult = new BaseResult();
        baseResult.setResult(result);
        baseResult.setData(data);
        baseResult.setSuccess(success);
        baseResult.setCursor(cursor);
        baseResult.setErrors(errors);
        return baseResult;
    }

    @Data
    public static class Cursor{
        private int total;
        private int offset;
        private int limit;
    }

    @Data
    @AllArgsConstructor
    public static class Error{
        private String fieId;
        private String message;
    }
}
