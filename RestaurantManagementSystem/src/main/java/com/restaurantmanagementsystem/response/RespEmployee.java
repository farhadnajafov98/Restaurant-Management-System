package com.restaurantmanagementsystem.response;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class RespEmployee {

    private Long id;
    private String name;
    private String surname;
    private Date dob;
    private String address;
    private Long contact;
    private String position;
    private Long salary;
}
