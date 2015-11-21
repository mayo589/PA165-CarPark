package com.fi.muni.carparkapp.service;

import com.fi.muni.carparkapp.dao.EmployeeDao;
import com.fi.muni.carparkapp.entity.Employee;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jan Hellar
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    
    @Override
    public Employee findEmployeeById(Long employeeId) {
        return employeeDao.findById(employeeId);
    }

    @Override
    public void addEmployee(Employee employee, String unencryptedPassword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    @Override
    public boolean authenticate(Employee employee, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAdmin(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
