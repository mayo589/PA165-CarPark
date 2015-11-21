package com.fi.muni.carparkapp.facade;

import com.fi.muni.carparkapp.dto.EmployeeAuthenticateDTO;
import com.fi.muni.carparkapp.dto.EmployeeDTO;
import java.util.Collection;

/**
 *
 * @author Jan Hellar
 */
public interface EmployeeFacade {
    
    EmployeeDTO findEmployeeById(Long employeeId);
    
    void addEmployee(EmployeeDTO employee, String unencryptedPassword);
    
    Collection<EmployeeDTO> getAllEmployees();
    
    boolean authenticate(EmployeeAuthenticateDTO employee);
    
    boolean isAdmin(EmployeeDTO employee);
            
}
