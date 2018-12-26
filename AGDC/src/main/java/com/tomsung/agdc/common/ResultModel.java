package com.tomsung.agdc.common;


import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 自定义返回结果
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultModel<T> {

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回结果描述
     */
    private String message;

    /**
     * 返回内容
     */
    private T content;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getContent() {
        return content;
    }

    public ResultModel(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultModel(int code, String message, T content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public ResultModel(ResultStatus status) {
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public ResultModel(ResultStatus status, T content) {
        this.code = status.getCode();
        this.message = status.getMessage();
        this.content = content;
    }

    public static <T> ResultModel<T> ok(T content) {
        return new ResultModel<T>(ResultStatus.SUCCESS, content);
    }

    public static ResultModel<Object> ok() {
        return new ResultModel<Object>(ResultStatus.SUCCESS);
    }

    public static ResultModel<Object> error(ResultStatus error) {
        return new ResultModel<Object>(error);
    }

    public static ResultModel<Object> error(ResultStatus error, Object content) {
        return new ResultModel<Object>(error, content);
    }
}
