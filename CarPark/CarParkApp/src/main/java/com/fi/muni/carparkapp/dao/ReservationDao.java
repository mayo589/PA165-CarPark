package com.fi.muni.carparkapp.dao;

import com.fi.muni.carparkapp.entity.Reservation;
import java.util.List;

/**
 *
 * @author Jan Starka
 */
public interface ReservationDao {
    public Reservation findById(Long id);
    public List<Reservation> findAll();
    public Reservation findByName(String name);
    public void create(Reservation o);
    public void delete(Reservation o);
}
