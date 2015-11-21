package com.fi.muni.carparkapp.service;

import com.fi.muni.carparkapp.dao.EmployeeDao;
import com.fi.muni.carparkapp.entity.Employee;
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
        employee.setPasswordHash(createHash(unencryptedPassword));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    @Override
    public boolean authenticate(Employee employee, String password) {
        return validatePassword(password, employee.getPasswordHash());
    }

    @Override
    public boolean isAdmin(Employee employee) {
        return findEmployeeById(employee.getId()).isAdmin();
    }
    
    private static String createHash(String password) {
        return password;
    }
    
    private static boolean validatePassword(String password, String correctHash) {
        return (password == null ? correctHash == null : password.equals(correctHash));
    }
    
}
