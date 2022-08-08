package com.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Employee> getAllEmployees(){
        String sql = "SELECT * FROM EMPLOYEE";
        List<Employee> employeeList =
                jdbcTemplate.query(sql, new EmployeeRowMapper());
        return employeeList;
    }

    public void addEmployee(Employee employee){
        String sql = "INSERT INTO EMPLOYEE(fname,lname,mob) VALUES(?,?,?)";
        jdbcTemplate.update(sql, employee.getFname(), employee.getLname(), employee.getMob());
    }
}
