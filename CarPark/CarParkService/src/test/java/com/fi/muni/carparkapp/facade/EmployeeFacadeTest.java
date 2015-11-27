package com.fi.muni.carparkapp.facade;

import com.fi.muni.carparkapp.dto.EmployeeAuthenticateDTO;
import com.fi.muni.carparkapp.dto.EmployeeDTO;
import com.fi.muni.carparkapp.entity.Car;
import com.fi.muni.carparkapp.entity.Reservation;
import com.fi.muni.carparkapp.service.EmployeeService;
import com.fi.muni.carparkapp.service.config.ServiceConfiguration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.GregorianCalendar;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Jan Starka
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class EmployeeFacadeTest extends AbstractTransactionalTestNGSpringContextTests {
    
    @Mock
    private EmployeeService employeeService;
    
    /*@Autowired
    @InjectMocks*/
    @Mock
    private EmployeeFacade employeeFacade;
    
    private EmployeeDTO testEmployee;
    private EmployeeAuthenticateDTO testEmployeeAuthenticate;
    
    Calendar c1 = GregorianCalendar.getInstance();
    Date sDate;
    
    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }
    
    @BeforeMethod
    public void prepareTestEmployee() {
        c1.set(1962, 1, 30);  //January 30th 2000
        sDate = c1.getTime();
        testEmployee = new EmployeeDTO();
        testEmployee.setId(1L);
        testEmployee.setAddress("Boženy Němcové");
        testEmployee.setFirstName("Jaroslav");
        testEmployee.setLastName("Novák");
        testEmployee.setDateOfBirth(sDate);
        testEmployee.setTelephone("999000000");
        
        testEmployeeAuthenticate = new EmployeeAuthenticateDTO();
        testEmployeeAuthenticate.setEmployeeId(testEmployee.getId());
    }
    
    @Test
    public void findEmployeeByIdTest() {
        employeeFacade.addEmployee(testEmployee, "heslo123");
        Long id = testEmployee.getId();
        
        when(employeeFacade.findEmployeeById(id)).thenReturn(testEmployee);
        
        EmployeeDTO e = employeeFacade.findEmployeeById(id);
        Assert.assertNotNull(id);
        Assert.assertNotNull(testEmployee);
        Assert.assertNotNull(e);
        Assert.assertEquals(e, testEmployee);
    }
    
    @Test
    public void getAllEmployeesTest() {
        List<EmployeeDTO> employees = new ArrayList<>();
        employees.add(testEmployee);
        
        when(employeeFacade.getAllEmployees()).thenReturn(employees);
        
        Collection<EmployeeDTO> f = employeeFacade.getAllEmployees();
        Assert.assertNotNull(f);
        Assert.assertEquals(f, employees);
    }
    
    @Test
    public void authenticateTest() {
        testEmployeeAuthenticate.setPassword("heslo123");
        boolean result = employeeFacade.authenticate(testEmployeeAuthenticate);
        
        Assert.assertNotNull(result);
        Assert.assertEquals(result, true);
    }
    
    @Test
    public void isAdminTest() {
        employeeFacade.addEmployee(testEmployee, "heslo123");
        
        boolean result = employeeFacade.isAdmin(testEmployee);
        
        when(employeeFacade.isAdmin(testEmployee)).thenReturn(Boolean.FALSE);
        
        Assert.assertNotNull(result);
        Assert.assertEquals(result, false);
    }
    
}
