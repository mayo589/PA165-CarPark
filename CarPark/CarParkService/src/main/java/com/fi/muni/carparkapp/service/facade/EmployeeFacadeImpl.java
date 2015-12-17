package com.fi.muni.carparkapp.service.facade;

import com.fi.muni.carparkapp.dto.EmployeeAuthenticateDTO;
import com.fi.muni.carparkapp.dto.EmployeeDTO;
import com.fi.muni.carparkapp.entity.Employee;
import com.fi.muni.carparkapp.facade.EmployeeFacade;
import com.fi.muni.carparkapp.service.BeanMappingService;
import com.fi.muni.carparkapp.service.EmployeeService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jan Hellar
 */
@Service
//@Transactional
public class EmployeeFacadeImpl implements EmployeeFacade {

    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private BeanMappingService beanMappingService;
    
    @Override
    public EmployeeDTO findEmployeeById(Long employeeId) {
        Employee employee = employeeService.findEmployeeById(employeeId);
        return (employee == null) ? null : beanMappingService.mapTo(employee, EmployeeDTO.class);
    }
    
    @Override
    public EmployeeDTO findEmployeeByName(String employeeName) {
        Employee employee = employeeService.findEmployeeByName(employeeName);
        return (employee == null) ? null : beanMappingService.mapTo(employee, EmployeeDTO.class);
    }

    @Override
    public void addEmployee(EmployeeDTO employee, String unencryptedPassword) {
        Employee employeeEntity = beanMappingService.mapTo(employee, Employee.class);
        employeeService.addEmployee(employeeEntity, unencryptedPassword);
        employee.setId(employeeEntity.getId());
    }

    @Override
    public Collection<EmployeeDTO> getAllEmployees() {
        return beanMappingService.mapTo(employeeService.getAllEmployees(), EmployeeDTO.class);
    }

    @Override
    public boolean authenticate(EmployeeAuthenticateDTO employee) {
        return employeeService.authenticate(
                employeeService.findEmployeeById(employee.getEmployeeId()), 
                employee.getPassword());
    }

    @Override
    public boolean isAdmin(EmployeeDTO employee) {
        return employeeService.isAdmin(beanMappingService.mapTo(employee, Employee.class));
    }
    
}
