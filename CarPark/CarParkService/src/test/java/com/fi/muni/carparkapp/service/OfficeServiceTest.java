package com.fi.muni.carparkapp.service;

import com.fi.muni.carparkapp.entity.Office;
import com.fi.muni.carparkapp.service.config.ServiceConfiguration;
import java.util.ArrayList;
import java.util.List;
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
public class OfficeServiceTest extends AbstractTransactionalTestNGSpringContextTests {
    
    /*@Autowired
    @InjectMocks*/
    @Mock
    private OfficeService officeService;
    
    private Office testOffice;
    
    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }
    
    @BeforeMethod
    public void prepareTestOffice() {
        testOffice = new Office(1L);
        testOffice.setName("name1");
        testOffice.setAddress("address1");
    }
    
    @Test
    public void findOfficeByIdTest() {
        officeService.AddOffice(testOffice);
        Long id = testOffice.getId();
        
        when(officeService.findOfficeById(id)).thenReturn(testOffice);
        
        Office o = officeService.findOfficeById(id);
        Assert.assertNotNull(id);
        Assert.assertNotNull(testOffice);
        Assert.assertNotNull(o);
        Assert.assertEquals(o, testOffice);
    }
    
    @Test
    public void getAllOfficesTest() {
        List<Office> offices = new ArrayList<>();
        offices.add(testOffice);
        
        when(officeService.getAllOffices()).thenReturn(offices);
        
        List<Office> f = officeService.getAllOffices();
        Assert.assertNotNull(f);
        Assert.assertEquals(f, offices);
    }
    
    
}
