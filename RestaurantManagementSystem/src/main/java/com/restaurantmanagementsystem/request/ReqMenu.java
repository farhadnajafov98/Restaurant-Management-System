package com.restaurantmanagementsystem.request;

import lombok.Data;

import javax.persistence.Column;
@Data
public class ReqMenu {

    private Long id;
    private String name;
    private String ingredient;
    private String catagory;
    private Integer price;
}
