package com.fi.muni.carparkapp.facade;

import com.fi.muni.carparkapp.dto.OfficeDTO;
import com.fi.muni.carparkapp.entity.Office;
import com.fi.muni.carparkapp.service.OfficeService;
import com.fi.muni.carparkapp.service.config.ServiceConfiguration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Jan Hellar
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class OfficeFacadeTest extends AbstractTransactionalTestNGSpringContextTests {
    
    @Mock
    private OfficeService officeService;
    
    @Autowired
    @InjectMocks
    private OfficeFacade officeFacade;
    
    @BeforeClass
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void getOfficeByIdTest() {
        Office o = new Office(1L);
        OfficeDTO od = new OfficeDTO();
        od.setId(1L);
        
        when(officeService.findOfficeById(1L)).thenReturn(o);
        
        OfficeDTO of = officeFacade.findOfficeById(1L);
        //Assert.assertEquals(of, od);
    }
    
    @Test
    public void getAllOfficesTest() {
        Office o = new Office(1L);
        OfficeDTO od = new OfficeDTO();
        od.setId(1L);
        
        List<Office> lo = new ArrayList<>();
        lo.add(o);
        List<OfficeDTO> lod = new ArrayList<>();
        lod.add(od);
        
        when(officeService.getAllOffices()).thenReturn(lo);
        
        Collection<OfficeDTO> of = officeFacade.getAllOffices();
        Assert.assertEquals(of.size(), lod.size());
    }
    
    @Test
    public void addOfficeTest() {
        Office o = new Office(1L);
        OfficeDTO od = new OfficeDTO();
        od.setId(1L);
        
        officeFacade.AddOffice(od);
        //verify(officeService).AddOffice(o);
    }
    
}
