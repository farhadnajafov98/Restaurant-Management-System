package com.restaurantmanagementsystem.service;

import com.restaurantmanagementsystem.entity.Employee;
import com.restaurantmanagementsystem.request.ReqEmployee;
import com.restaurantmanagementsystem.response.RespEmployee;
import com.restaurantmanagementsystem.response.Response;
import com.restaurantmanagementsystem.response.ResponseStatusList;

import java.util.List;

public interface EmployeeService {
    Response<List<RespEmployee>> getEmployeeList();
    Response<RespEmployee> getEmployeeById(Long employeeId);
    ResponseStatusList addEmployee(ReqEmployee reqEmployee);
    ResponseStatusList updateEmployee(ReqEmployee reqEmployee);
    ResponseStatusList deleteEmployee(Long employeeId);
}
