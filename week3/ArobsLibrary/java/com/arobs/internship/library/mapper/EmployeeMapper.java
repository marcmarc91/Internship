package com.arobs.internship.library.mapper;

import com.arobs.internship.library.model.EmployeeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<EmployeeEntity> {
    private static final Logger log = LoggerFactory.getLogger(EmployeeMapper.class);

    @Override
    public EmployeeEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setId(resultSet.getInt("id"));
        employee.setName(resultSet.getString("name"));
        employee.setPassword(resultSet.getString("password"));
        employee.setEmail(resultSet.getString("email"));
        employee.setRole(resultSet.getString("role"));

        return employee;
    }
}
