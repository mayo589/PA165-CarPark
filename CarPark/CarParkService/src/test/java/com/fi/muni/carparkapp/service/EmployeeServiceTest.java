package com.fi.muni.carparkapp.service;

import com.fi.muni.carparkapp.dao.EmployeeDao;
import com.fi.muni.carparkapp.entity.Employee;
import com.fi.muni.carparkapp.entity.Reservation;
import com.fi.muni.carparkapp.service.config.ServiceConfiguration;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.inject.Inject;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Jan Starka
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class EmployeeServiceTest extends AbstractTransactionalTestNGSpringContextTests {
    
    @Mock
    private EmployeeDao employeeDao;
    
    @Autowired
    @InjectMocks
    private EmployeeService employeeService;
    
    private Employee testEmployee;
    
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
        testEmployee = new Employee(1L);
        testEmployee.setAddress("Boženy Němcové");
        testEmployee.setFirstName("Jaroslav");
        testEmployee.setLastName("Novák");
        testEmployee.setDateOfBirth(sDate);
        testEmployee.setTelephone("999000000");
        
    }
    
    @Test
    public void findEmployeeByIdTest() {
        employeeService.addEmployee(testEmployee, "heslo123");
        Long id = testEmployee.getId();
        
        when(employeeService.findEmployeeById(id)).thenReturn(testEmployee);
        
        Employee e = employeeService.findEmployeeById(id);
        Assert.assertNotNull(id);
        Assert.assertNotNull(testEmployee);
        Assert.assertNotNull(e);
        Assert.assertEquals(e, testEmployee);
    }
    
    @Test
    public void authenticateTest() {
        employeeService.addEmployee(testEmployee, "heslo123");
        boolean result = employeeService.authenticate(testEmployee, "heslo123");
        Assert.assertEquals(result, true);
    }
    
}
