package com.lihao.diancaisystem.po;

public class SuccessResponse extends GenericResponse {
    private static final String RESPONSE_CODE = "SUCCESS";
    private static final String RESPONSE_MESSAGE = "The operation is successful.";

    public SuccessResponse() {
    }

    public String getCode() {
        return "SUCCESS";
    }

    public String getMessage() {
        return "The operation is successful.";
    }
}
