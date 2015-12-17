/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fi.muni.carparkapp.dao;

import com.fi.muni.carparkapp.entity.Employee;
import java.util.List;

/**
 *
 * @author Marek Mihalech
 */
public interface EmployeeDao {

    /**
     *Finds employee by id
     * @param id employee id
     * @return Employee object
     */
    public Employee findById(Long id);
    
    /**
     *Finds employee by name (lastName)
     * @param name employee last name
     * @return Employee object
     */
    public Employee findByName(String name);

    /**
     * Persists employee
     * @param e Employee object to persist
     */
    public void create(Employee e);

    /**
     * Removes Employee object
     * @param e Employee object to b removed
     */
    public void delete(Employee e);

    /**
     * Returns all employee objects
     * @return list of Employee objects
     */
    public List<Employee> findAll();

    /**
     * Updates employee record
     * @param e updated Employee object
     */
    public void update(Employee e);
}
