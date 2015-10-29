package com.fi.muni.carparkapp.dao;

import com.fi.muni.carparkapp.entity.Office;
import java.util.List;

/**
 *
 * @author Jan Hellar (436358)
 */
public interface OfficeDao {
    public Office findById(Long id);
    public List<Office> findAll();
    public Office findByName(String name);
    public Office findByAddress(String address);
    public void create(Office o);
    public void delete(Office o);
}
