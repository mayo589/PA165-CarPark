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
import javax.persistence.PersistenceContext;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marek Mihalech
 */
@Repository
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
