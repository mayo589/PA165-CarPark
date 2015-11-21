package com.fi.muni.carparkapp.service;

import java.util.Collection;
import com.fi.muni.carparkapp.entity.Employee;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jan Hellar
 */
@Service
public interface EmployeeService {
    
    Employee findEmployeeById(Long employeeId);
    
    void addEmployee(Employee employee, String unencryptedPassword);
    
    List<Employee> getAllEmployees();
    
    boolean authenticate(Employee employee, String password);
    
    boolean isAdmin(Employee employee);
    
}
