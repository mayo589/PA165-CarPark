package com.fi.muni.carparkapp.service;

import com.fi.muni.carparkapp.entity.Office;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jan Hellar
 */
@Service
public interface OfficeService {
    
    Office findOfficeById(Long officeId);
    
    List<Office> getAllOffices();
    
    void AddOffice(Office office);
    
    void updateOffice(Office office);
    
}
