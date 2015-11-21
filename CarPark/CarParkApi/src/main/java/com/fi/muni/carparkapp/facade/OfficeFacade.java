package com.fi.muni.carparkapp.facade;

import com.fi.muni.carparkapp.dto.OfficeDTO;
import java.util.Collection;

/**
 *
 * @author jen
 */
public interface OfficeFacade {
    
    OfficeDTO findOfficeById(Long officeId);
    
    Collection<OfficeDTO> getAllOffices();
    
    void AddOffice(OfficeDTO office);
    
}
