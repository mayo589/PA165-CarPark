/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fi.muni.carparkapp.dao;

import com.fi.muni.carparkapp.entity.Employee;
import com.fi.muni.carparkapp.exceptions.SimpleDataAccessException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Marek Mihalech
 */
@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Employee findById(Long id) {
        if(id <= 0)
            throw new SimpleDataAccessException("id cannot be < 0");
        return em.find(Employee.class, id);
    }
    
    @Override
    public Employee findByName(String name) {
        if (name == null) {
            throw new SimpleDataAccessException("name cannot be null");
        }
        if ("".equals(name)) {
            throw new SimpleDataAccessException("name cannot be empty");
        }
        try {
            return em.createQuery("select e from Employee e where lastName = :name",
                    Employee.class).setParameter("name", name).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public void create(Employee e) {
        if(e == null)
            throw new SimpleDataAccessException("employee cannot be null");
        em.persist(e);
    }

    @Override
    public void delete(Employee e) {
        if(e == null)
            throw new SimpleDataAccessException("employee cannot be null");
        em.remove(e);
    }

    @Override
    public List<Employee> findAll() {
        return em.createQuery("select e from Employee e", Employee.class).getResultList();
    }

    @Override
    public void update(Employee e) {
        if(e == null)
            throw new SimpleDataAccessException("employee cannot be null");
        em.merge(e);
    }
    
}
