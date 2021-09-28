package com.evgeniy.web.jpa.hibernate.crud.dao;

import com.evgeniy.web.jpa.hibernate.crud.entity.PersonTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

public class ObjectDAO implements JpaDAO<Object,Long>{
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
    private EntityManager entityManager;

    public ObjectDAO() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void add(Object entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Object entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public Object searchById(Long id) {
        Object obj = entityManager.find(Object.class, id);
        if(obj!=null){
            return obj;
        } else {
            System.out.println("Object doesn't exist with provided Id..");
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Object obj = searchById(id);
        if(obj!=null){
            entityManager.getTransaction().begin();
            entityManager.remove(obj);
            entityManager.getTransaction().commit();
        } else{
            System.out.println("Object doesn't exist with provided Id..");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Object> searchAll(Class c) {
        return entityManager.createQuery("FROM " + c.getName(), c).getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deleteAll(Class c) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from " + c.getName()).executeUpdate();
        entityManager.getTransaction().commit();
    }

    public void close() {
        entityManagerFactory.close();
    }
}
