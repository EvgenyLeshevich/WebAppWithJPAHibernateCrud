package com.evgeniy.web.jpa.hibernate.crud.service;

import com.evgeniy.web.jpa.hibernate.crud.dao.ObjectDAO;

import java.util.List;

public class ObjectService implements Services<Object,Long>{
    private ObjectDAO objectDAO = new ObjectDAO();

    public ObjectService() {
    }

    @Override
    public void add(Object entity) {
        objectDAO.add(entity);
    }

    @Override
    public void update(Object entity) {
        objectDAO.update(entity);
    }

    @Override
    public Object searchById(Long id) {
        Object obj = objectDAO.searchById(id);
        return obj;
    }

    @Override
    public void deleteById(Long id) {
        objectDAO.deleteById(id);
    }

    @Override
    public List<Object> searchAll(Class c) {
        List<Object> objects = objectDAO.searchAll(c);
        return objects;
    }

    @Override
    public void deleteAll(Class c) {
        objectDAO.deleteAll(c);
    }
}
