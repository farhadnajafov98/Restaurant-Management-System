package com.restaurantmanagementsystem.exception;

public class RestaurantException extends RuntimeException {
    private Integer statusCode;

    public RestaurantException() {

    }

    public RestaurantException(Integer statusCode, String statusMessage) {

            super(statusMessage);
            this.statusCode = statusCode;
        }
        public Integer getCode () {
            return statusCode;
        }
    }
