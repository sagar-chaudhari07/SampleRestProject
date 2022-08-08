package com.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.employee.Constants.*;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(path = URI_GET_EMPLOYEES, produces = APPLICATION_JSON)
    public List getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping(path = URI_ADD_EMPLOYEE, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

}
