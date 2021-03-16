package com.example.demo.service;

import java.util.List;

public interface CrudService<T> {

    void create(T entity);
    T read(Integer id);
    List<T> index();
    boolean update(T entity, Integer id);
    boolean delete(Integer id);

}
