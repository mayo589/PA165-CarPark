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

    /**
     * Gets reservation by ID
     * @param id ID, for which is reservation to be found
     * @return
     */
    public Reservation findById(Long id);

    /**
     * Gets all reservations
     * @return
     */
    public List<Reservation> findAll();

    /**
     * Gets reservation by employee
     * @param employee employee, for whom is reservation to be found
     * @return
     */
    public Reservation findByEmployee(Employee employee);

    /**
     * Gets reservation by car
     * @param car car, for which is reservation to be found
     * @return
     */
    public Reservation findByCar(Car car);

    /**
     * Get all reservations by office
     * @param office office, for which is reservation to be found
     * @return
     */
    public Reservation findByOffice(Office office);

    /**
     * Persists Reservation object
     * @param o Reservation object to be persisted
     */
    public void create(Reservation o);

    /**
     * Removes Reservation object
     * @param o Reservation object to be removed
     */
    public void delete(Reservation o);
    
    /**
     * Updates Reservation object
     * @param o Reservation object to be updated
     */
    public void update(Reservation o);
}
