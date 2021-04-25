package com.arobs.internship.library.repository.jdbc;

import com.arobs.internship.library.model_jdbc.BaseEntity;

import java.util.List;

public interface GenericRepository<T extends BaseEntity> {

    int save(T t);

    int update(int id, T t);

    int deleteById(int id);

    List<T> getAll();

    T getById(int id);
}
