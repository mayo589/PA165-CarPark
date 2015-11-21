package com.fi.muni.carparkapp.service;

import com.fi.muni.carparkapp.dao.OfficeDao;
import com.fi.muni.carparkapp.entity.Office;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jan Hellar
 */
@Service
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    private OfficeDao officeDao;
    
    @Override
    public Office findOfficeById(Long officeId) {
        return officeDao.findById(officeId);
    }

    @Override
    public List<Office> getAllOffices() {
        return officeDao.findAll();
    }

    @Override
    public void AddOffice(Office office) {
        officeDao.create(office);
    }
    
}
