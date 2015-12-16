package com.fi.muni.carparkapp.facade;

import com.fi.muni.carparkapp.dto.EmployeeAuthenticateDTO;
import com.fi.muni.carparkapp.dao.EmployeeDao;
import com.fi.muni.carparkapp.dto.EmployeeDTO;
import com.fi.muni.carparkapp.entity.Employee;
import com.fi.muni.carparkapp.entity.Reservation;
import com.fi.muni.carparkapp.service.BeanMappingService;
import com.fi.muni.carparkapp.service.EmployeeService;
import com.fi.muni.carparkapp.service.config.ServiceConfiguration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.GregorianCalendar;
import javax.inject.Inject;
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
    
    @Inject
    private BeanMappingService beanMappingService;
    
    @Autowired
    @InjectMocks
    private EmployeeFacade employeeFacade;
    
    private EmployeeDTO testEmployeeDTO;
    private Employee testEmployee;
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
        testEmployeeDTO = new EmployeeDTO();
        testEmployeeDTO.setId(1L);
        testEmployeeDTO.setAddress("Boženy Němcové");
        testEmployeeDTO.setFirstName("Jaroslav");
        testEmployeeDTO.setLastName("Novák");
        testEmployeeDTO.setDateOfBirth(sDate);
        testEmployeeDTO.setTelephone("999000000");
        
        testEmployee = new Employee();
        testEmployee.setId(1L);
        testEmployee.setAddress("Boženy Němcové");
        testEmployee.setFirstName("Jaroslav");
        testEmployee.setLastName("Novák");
        testEmployee.setDateOfBirth(sDate);
        testEmployee.setTelephone("999000000");
        
        testEmployeeAuthenticate = new EmployeeAuthenticateDTO();
        testEmployeeAuthenticate.setEmployeeId(testEmployeeDTO.getId());
        //testEmployeeAuthenticate.setPassword("heslo123");
    }
    
    @Test
    public void findEmployeeByIdTest() {
        employeeFacade.addEmployee(testEmployeeDTO, "heslo123");
        Long id = testEmployeeDTO.getId();
        
        when(employeeService.findEmployeeById(id)).thenReturn(testEmployee);
        
        EmployeeDTO e = employeeFacade.findEmployeeById(id);
        Assert.assertNotNull(id);
        Assert.assertNotNull(testEmployeeDTO);
        Assert.assertNotNull(e);
        //Assert.assertEquals(e, testEmployeeDTO);
    }
    
    @Test
    public void getAllEmployeesTest() {
        List<EmployeeDTO> employeesDTO = new ArrayList<>();
        employeesDTO.add(testEmployeeDTO);
        
        List<Employee> employees = new ArrayList<>();
        employees.add(testEmployee);
        
        when(employeeService.getAllEmployees()).thenReturn(employees);
        
        Collection<EmployeeDTO> f = employeeFacade.getAllEmployees();
        Assert.assertNotNull(f);
        //Assert.assertEquals(f, employeesDTO);
    }
    
    @Test
    public void authenticateTest() {
        testEmployeeAuthenticate.setPassword("heslo123");
        testEmployeeAuthenticate.setEmployeeId(testEmployee.getId());
        
        when(employeeService.findEmployeeById(testEmployeeAuthenticate.getEmployeeId())).thenReturn(testEmployee);
        when(employeeService.authenticate(testEmployee, "heslo123")).thenReturn(Boolean.TRUE);
        when(employeeService.authenticate(testEmployee, "spatneheslo")).thenReturn(Boolean.FALSE);
        
        boolean result = employeeFacade.authenticate(testEmployeeAuthenticate);
        
        Assert.assertNotNull(result);
        Assert.assertEquals(result, true);
        
        testEmployeeAuthenticate.setPassword("spatneheslo");
        
        boolean badResult = employeeFacade.authenticate(testEmployeeAuthenticate);
        
        Assert.assertNotNull(badResult);
        Assert.assertEquals(badResult, false);
    }
    
    @Test
    public void isAdminTest() {
        employeeFacade.addEmployee(testEmployeeDTO, "heslo123");
        
        boolean result = employeeFacade.isAdmin(testEmployeeDTO);
        
        when(employeeService.isAdmin(testEmployee)).thenReturn(Boolean.FALSE);
        
        Assert.assertNotNull(result);
        Assert.assertEquals(result, false);
    }
    
}
