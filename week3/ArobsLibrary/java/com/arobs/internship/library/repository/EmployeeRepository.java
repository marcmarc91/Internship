package com.arobs.internship.library.repository;

import com.arobs.internship.library.mapper.BookMapper;
import com.arobs.internship.library.mapper.EmployeeMapper;
import com.arobs.internship.library.model.EmployeeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@org.springframework.stereotype.Repository
public class EmployeeRepository implements GenericRepository<EmployeeEntity> {
    private static final Logger log = LoggerFactory.getLogger(EmployeeRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(EmployeeEntity employeeEntity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String insertQuery = "insert into employee (name,role,password,email) values (?,?,?,?)";

        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employeeEntity.getName());
            preparedStatement.setString(2, employeeEntity.getRole());
            preparedStatement.setString(3, employeeEntity.getPassword());
            preparedStatement.setString(4, employeeEntity.getEmail());
            return preparedStatement;

        }, keyHolder);
        if (keyHolder.getKey() != null) {
            log.info("Key for the new employee: {}", keyHolder.getKey().intValue());
            return keyHolder.getKey().intValue();
        } else {
            log.warn("KeyHolder is NULL");
            return 0;
        }
    }

    @Override
    public int update(int id, EmployeeEntity employeeEntity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String updateQuery = "update employee set name = ?, role = ?, password = ?, email = ? where id= ?";

        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employeeEntity.getName());
            preparedStatement.setString(2, employeeEntity.getRole());
            preparedStatement.setString(3, employeeEntity.getPassword());
            preparedStatement.setString(4, employeeEntity.getEmail());
            preparedStatement.setInt(5, id);
            return preparedStatement;

        }, keyHolder);

        if (keyHolder.getKey() != null) {
            log.info("Key for the modified: {}", keyHolder.getKey().intValue());
            return keyHolder.getKey().intValue();
        } else {
            log.warn("KeyHolder is NULL");
            return 0;
        }
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("delete from employee where id = ?",
                id);
    }

    @Override
    public List<EmployeeEntity> getAll() {
        return jdbcTemplate.query(
                "select * from employee",
                new EmployeeMapper()
        );
    }

    @Override
    public EmployeeEntity getById(int id) {
        try {
            return jdbcTemplate.queryForObject(
                    "select * from employee where id = ?",
                    new EmployeeMapper(),
                    id);
        } catch (EmptyResultDataAccessException exception) {
            log.debug("No record found in database for {}", id);
            return null;
        }
    }
}
