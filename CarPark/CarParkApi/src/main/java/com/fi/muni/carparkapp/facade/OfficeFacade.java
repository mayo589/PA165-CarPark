package com.fi.muni.carparkapp.facade;

import com.fi.muni.carparkapp.dto.OfficeDTO;
import java.util.Collection;

/**
 *
 * @author Jan Hellar
 */
public interface OfficeFacade {
    
    /**
     * Find office by id
     * @param officeId
     * @return office
     */
    OfficeDTO findOfficeById(Long officeId);
    
    /**
     * Get all offices
     * @return offices
     */
    Collection<OfficeDTO> getAllOffices();
    
    /**
     * Add office
     * @param office 
     */
    void AddOffice(OfficeDTO office);
    
}
