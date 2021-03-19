package com.arobs.internship.library.repository;

import com.arobs.internship.library.utils.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface GenericRepository<T extends BaseEntity> {

    int save(T t);

    int update(int id, T t);

    int deleteById(int id);

    List<T> getAll();

    T getById(int id);
}
