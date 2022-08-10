package com.restaurantmanagementsystem.service.impl;

import com.restaurantmanagementsystem.entity.Employee;
import com.restaurantmanagementsystem.enums.EnumAvaliableStatus;
import com.restaurantmanagementsystem.exception.ExceptionConstant;
import com.restaurantmanagementsystem.exception.RestaurantException;
import com.restaurantmanagementsystem.repository.EmployeeRepository;
import com.restaurantmanagementsystem.request.ReqEmployee;
import com.restaurantmanagementsystem.response.RespEmployee;
import com.restaurantmanagementsystem.response.Response;
import com.restaurantmanagementsystem.response.ResponseStatus;
import com.restaurantmanagementsystem.response.ResponseStatusList;
import com.restaurantmanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Response<List<RespEmployee>> getEmployeeList() {
        Response<List<RespEmployee>> response = new Response<>();
        try {
            List<Employee> employees = employeeRepository.findAllByActive(EnumAvaliableStatus.ACTIVE.getValue());
            if (employees == null) {
                throw new RestaurantException(ExceptionConstant.EMPLOYEE_NOT_FOUND, "EMPLOYEE NOT FOUND");
            }
            List<RespEmployee> respEmployeeList = new ArrayList<>();
            for (Employee employee : employees) {
                RespEmployee respEmployee = new RespEmployee();
                respEmployee.setId(employee.getId());
                respEmployee.setName(employee.getName());
                respEmployee.setSurname(employee.getSurname());
                respEmployee.setDob(employee.getDob());
                respEmployee.setAddress(employee.getAddress());
                respEmployee.setContact(employee.getContact());
                respEmployee.setPosition(employee.getPosition());
                respEmployee.setSalary(employee.getSalary());
                respEmployeeList.add(respEmployee);
                response.setT(respEmployeeList);
                response.setStatus(ResponseStatus.getSuccessMessage());
            }
        } catch (RestaurantException exx) {
            response.setStatus(new ResponseStatus(exx.getCode(), exx.getMessage()));
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(new ResponseStatus(ExceptionConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }
        return response;
    }

    @Override
    public Response<RespEmployee> getEmployeeById(Long employeeId) {
        Response<RespEmployee> response = new Response<>();
        try {
            if (employeeId == null) {
                throw new RestaurantException(ExceptionConstant.INVALID_REQUEST_DATA, "INVALID REQUEST DATA");
            }
            Employee employee = employeeRepository.findEmployeeByIdAndActive(employeeId, EnumAvaliableStatus.ACTIVE.getValue());
            if (employee == null) {
                throw new RestaurantException(ExceptionConstant.EMPLOYEE_NOT_FOUND, "EMPLOYEE NOT FOUND");
            }
            RespEmployee respEmployee = new RespEmployee();
            respEmployee.setId(employeeId);
            respEmployee.setName(employee.getName());
            respEmployee.setSurname(employee.getSurname());
            respEmployee.setDob(employee.getDob());
            respEmployee.setAddress(employee.getAddress());
            respEmployee.setContact(employee.getContact());
            respEmployee.setPosition(employee.getPosition());
            respEmployee.setSalary(employee.getSalary());
            response.setT(respEmployee);
            response.setStatus(ResponseStatus.getSuccessMessage());
        } catch (RestaurantException exx) {
            response.setStatus(new ResponseStatus(exx.getCode(), exx.getMessage()));
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(new ResponseStatus(ExceptionConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }
        return response;
    }

    @Override
    public ResponseStatusList addEmployee(ReqEmployee reqEmployee) {
        ResponseStatusList response = new ResponseStatusList();
        try {
            Long Id = reqEmployee.getId();
            String name = reqEmployee.getName();
            String surname = reqEmployee.getSurname();
            Date dob = reqEmployee.getDob();
            String address = reqEmployee.getAddress();
            Long contact = reqEmployee.getContact();
            String position = reqEmployee.getPosition();
            Long salary = reqEmployee.getSalary();

            if (Id == null || name == null || surname == null || dob == null || address == null || contact == null || position == null || salary == null) {
                throw new RestaurantException(ExceptionConstant.INVALID_REQUEST_DATA, "INVALID REQUEST DATA");
            }
            Employee employee = new Employee();
            employee.setName(name);
            employee.setSurname(surname);
            employee.setDob(dob);
            employee.setAddress(address);
            employee.setContact(contact);
            employee.setPosition(position);
            employee.setSalary(salary);
            employeeRepository.save(employee);
            response.setStatus(ResponseStatus.getSuccessMessage());
        } catch (RestaurantException exx) {
            response.setStatus(new ResponseStatus(exx.getCode(), exx.getMessage()));
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(new ResponseStatus(ExceptionConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }

        return response;
    }

    @Override
    public ResponseStatusList updateEmployee(ReqEmployee reqEmployee) {
        ResponseStatusList response = new ResponseStatusList();
        try {
            Long Id = reqEmployee.getId();
            String name = reqEmployee.getName();
            String surname = reqEmployee.getSurname();
            Date dob = reqEmployee.getDob();
            String address = reqEmployee.getAddress();
            Long contact = reqEmployee.getContact();
            String position = reqEmployee.getPosition();
            Long salary = reqEmployee.getSalary();

            if (Id == null || name == null || surname == null || dob == null || address == null || contact == null || position == null || salary == null) {
                throw new RestaurantException(ExceptionConstant.INVALID_REQUEST_DATA, "INVALID REQUEST DATA");
            }
            Employee employee = employeeRepository.findEmployeeByIdAndActive(reqEmployee.getId(), EnumAvaliableStatus.ACTIVE.getValue());
            if (employee == null) {
                throw new RestaurantException(ExceptionConstant.EMPLOYEE_NOT_FOUND, "EMPLOYEE NOT FOUND");
            }
            employee.setName(name);
            employee.setSurname(surname);
            employee.setDob(dob);
            employee.setAddress(address);
            employee.setContact(contact);
            employee.setPosition(position);
            employee.setSalary(salary);
            employeeRepository.save(employee);
            response.setStatus(ResponseStatus.getSuccessMessage());

        } catch (RestaurantException exx) {
            response.setStatus(new ResponseStatus(exx.getCode(), exx.getMessage()));
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(new ResponseStatus(ExceptionConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }
        return response;
    }

    @Override
    public ResponseStatusList deleteEmployee(Long employeeId) {
        ResponseStatusList response = new ResponseStatusList();
        try {
            if (employeeId == null) {
                throw new RestaurantException(ExceptionConstant.INVALID_REQUEST_DATA, "INVALID REQUEST DATA");
            }
            Employee employee = employeeRepository.findEmployeeByIdAndActive(employeeId, EnumAvaliableStatus.ACTIVE.getValue());
            if (employee == null) {
                throw new RestaurantException(ExceptionConstant.EMPLOYEE_NOT_FOUND, "EMPLOYEE NOT FOUND");
            }
            employee.setActive(EnumAvaliableStatus.DEACTIVE.getValue());
            employeeRepository.save(employee);
            response.setStatus(ResponseStatus.getSuccessMessage());
        } catch (RestaurantException exx) {
            response.setStatus(new ResponseStatus(exx.getCode(), exx.getMessage()));

        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(new ResponseStatus(ExceptionConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }
        return null;
    }
}
