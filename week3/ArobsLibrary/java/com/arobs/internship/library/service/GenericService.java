package com.arobs.internship.library.service;

import com.arobs.internship.library.utils.BaseEntity;

import java.util.List;

public interface GenericService<T extends BaseEntity> {

    T getById(int id);

    List<T> getAll();

    T save(T t);

    T update(int id, T t);

    int delete(int id);
}
