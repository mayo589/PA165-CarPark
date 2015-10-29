package com.fi.muni.carparkapp.dao;

import com.fi.muni.carparkapp.entity.Reservation;
import com.fi.muni.carparkapp.entity.Car;
import com.fi.muni.carparkapp.entity.Employee;
import com.fi.muni.carparkapp.entity.Office;
import java.util.List;

/**
 *
 * @author Jan Starka
 */
public interface ReservationDao {
    public Reservation findById(Long id);
    public List<Reservation> findAll();
    public Reservation findByEmployee(Employee employee);
    public Reservation findByCar(Car car);
    public Reservation findByOffice(Office office);
    public void create(Reservation o);
    public void delete(Reservation o);
}
