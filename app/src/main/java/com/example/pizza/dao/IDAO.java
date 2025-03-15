package com.example.pizza.dao;

import java.util.List;

public interface IDAO<T> {
    public boolean create(T o);
    public boolean update(T o);
    public boolean delete(T o);
    public List<T> findAll();
    public T findById(int id );
}
