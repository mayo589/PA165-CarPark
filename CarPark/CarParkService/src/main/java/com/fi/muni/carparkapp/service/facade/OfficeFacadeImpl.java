package com.fi.muni.carparkapp.service.facade;

import com.fi.muni.carparkapp.dto.OfficeDTO;
import com.fi.muni.carparkapp.facade.OfficeFacade;
import com.fi.muni.carparkapp.service.BeanMappingService;
import com.fi.muni.carparkapp.service.OfficeService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fi.muni.carparkapp.entity.Office;

/**
 *
 * @author Jan Hellar
 */
@Service
//@Transactional
public class OfficeFacadeImpl implements OfficeFacade {
    
    @Autowired
    private OfficeService officeService;
    
    @Autowired
    private BeanMappingService beanMappingService;

    @Override
    public OfficeDTO findOfficeById(Long officeId) {
        return beanMappingService.mapTo(officeService.findOfficeById(officeId), OfficeDTO.class);
    }

    @Override
    public Collection<OfficeDTO> getAllOffices() {
        return beanMappingService.mapTo(officeService.getAllOffices(), OfficeDTO.class);
    }

    @Override
    public void AddOffice(OfficeDTO office) {
        Office o = new Office();
        o.setName(office.getName());
        o.setAddress(office.getAddress());
        officeService.AddOffice(o);
    }
    
}
