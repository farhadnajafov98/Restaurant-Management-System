package com.restaurantmanagementsystem.response;

import lombok.Data;

@Data
public class RespMenu {

    private Long id;
    private String name;
    private String ingredient;
    private String catagory;
    private Integer price;
}
