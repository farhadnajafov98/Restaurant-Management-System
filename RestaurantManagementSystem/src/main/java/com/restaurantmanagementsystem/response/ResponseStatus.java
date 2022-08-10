package com.restaurantmanagementsystem.response;

public class ResponseStatus {
    private Integer statusCode;
    private String statusMessage;

    private static final Integer  Success_Code=1;
    private static final String  Success_Message ="Success";

    public ResponseStatus(Integer statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
    public static ResponseStatus getSuccessMessage() {
        return new ResponseStatus(Success_Code, Success_Message);
    }
    public Integer getStatusCode() {
        return statusCode;
    }
}
