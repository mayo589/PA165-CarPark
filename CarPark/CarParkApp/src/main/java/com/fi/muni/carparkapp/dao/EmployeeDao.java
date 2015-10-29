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
    public Employee findById(Long id);
    public void create(Employee e);
    public void delete(Employee e);
    public List<Employee> findAll();
    public void update(Employee e);
}
