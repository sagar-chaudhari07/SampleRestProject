package com.employee;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee emp = new Employee();
        emp.setFname(rs.getString("fname"));
        emp.setLname(rs.getString("lname"));
        emp.setMob(rs.getLong("mob"));
        return emp;
    }
}
