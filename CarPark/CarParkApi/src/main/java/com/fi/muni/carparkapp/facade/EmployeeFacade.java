package com.fi.muni.carparkapp.facade;

import com.fi.muni.carparkapp.dto.EmployeeAuthenticateDTO;
import com.fi.muni.carparkapp.dto.EmployeeDTO;
import java.util.Collection;

/**
 *
 * @author Jan Hellar
 */
public interface EmployeeFacade {
    
    /**
     * Find employee by ID
     * @param employeeId
     * @return employee
     */
    EmployeeDTO findEmployeeById(Long employeeId);
    
    /**
     * Find employee by name (lastName)
     * @param employeeName
     * @return employee
     */
    EmployeeDTO findEmployeeByName(String employeeName);
    
    /**
     * Add employee
     * @param employee
     * @param unencryptedPassword 
     */
    void addEmployee(EmployeeDTO employee, String unencryptedPassword);
    
    public void updateEmployee(EmployeeDTO employeeDTO);
    
    /**
     * Get all employees
     * @return employees
     */
    Collection<EmployeeDTO> getAllEmployees();
    
    /**
     * Authenticate employee
     * @param employee
     * @return true if employee is authenticated
     */
    boolean authenticate(EmployeeAuthenticateDTO employee);
    
    /**
     * Find out if employee is admin
     * @param employee
     * @return true if employee is admin
     */
    boolean isAdmin(EmployeeDTO employee);
            
}
