/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fi.muni.carparkapp.dao;

import com.fi.muni.carparkapp.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        return em.find(Employee.class, id);
    }

    @Override
    public void create(Employee e) {
        em.persist(e);
    }

    @Override
    public void delete(Employee e) {
        em.remove(e);
    }

    @Override
    public List<Employee> findAll() {
        return em.createQuery("select e from Employee e", Employee.class).getResultList();
    }

    @Override
    public void update(Employee e) {
        em.merge(e);
    }
    
}
