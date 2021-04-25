package com.arobs.internship.library.mapper.jdbc;

import com.arobs.internship.library.model_jdbc.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    private static final Logger log = LoggerFactory.getLogger(EmployeeMapper.class);

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employeeDto = new Employee();
        employeeDto.setId(resultSet.getInt("id"));
        employeeDto.setName(resultSet.getString("name"));
        employeeDto.setPassword(resultSet.getString("password"));
        employeeDto.setEmail(resultSet.getString("email"));
        employeeDto.setRole(resultSet.getString("role"));

        return employeeDto;
    }
}
