package com.restaurantmanagementsystem.controller;

import com.restaurantmanagementsystem.request.ReqEmployee;
import com.restaurantmanagementsystem.response.RespEmployee;
import com.restaurantmanagementsystem.response.Response;
import com.restaurantmanagementsystem.response.ResponseStatusList;
import com.restaurantmanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/getEmployeeList")
    public Response<List<RespEmployee>> getEmployeeList() {
        return employeeService.getEmployeeList();
    }

    @GetMapping(value = "/getEmployeeById")
    public Response<RespEmployee> getEmployeeById(@RequestParam Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping(value = "/addEmployee")
    public ResponseStatusList addEmployee(@RequestBody ReqEmployee reqEmployee) {
        return employeeService.addEmployee(reqEmployee);
    }

    @PutMapping(value = "/updateEmployee")
    public ResponseStatusList updateEmployee(@RequestBody ReqEmployee reqEmployee) {
        return employeeService.updateEmployee(reqEmployee);
    }

    @PutMapping(value = "/deleteEmployee/{employeeId}")
    public ResponseStatusList deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }
}
