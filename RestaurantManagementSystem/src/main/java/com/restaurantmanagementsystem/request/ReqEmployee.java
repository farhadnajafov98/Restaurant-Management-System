package com.restaurantmanagementsystem.request;

import lombok.Data;

import java.util.Date;

@Data
public class ReqEmployee {

    private Long id;
    private String name;
    private String surname;
    private Date dob;
    private String address;
    private Long contact;
    private String position;
    private Long salary;
}
