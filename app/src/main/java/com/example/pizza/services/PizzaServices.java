package com.example.pizza.services;

import com.example.pizza.beans.Pizza;
import com.example.pizza.dao.IDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PizzaServices implements IDAO<Pizza> {
    List<Pizza> lp = new ArrayList<>();
    private static PizzaServices instance;

    public static PizzaServices getInstance() {
        if (instance == null) {
            instance = new PizzaServices();
        }
        return instance;
    }

    @Override
    public boolean create(Pizza o) {
        lp.add(o);
        return true;
    }

    @Override
    public boolean update(Pizza o) {
        for (int i = 0; i < lp.size(); i++) {
            if (lp.get(i).getId() == o.getId()) {
                lp.set(i, o);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Pizza o) {
        lp.remove(o);
        return true;
    }

    public List<Pizza> findAll() {
        return new ArrayList<>(lp);
    }

    @Override
    public Pizza findById(int id) {
        for (Pizza p : lp) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
