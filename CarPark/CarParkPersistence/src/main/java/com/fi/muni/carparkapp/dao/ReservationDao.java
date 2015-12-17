package com.fi.muni.carparkapp.dao;

import com.fi.muni.carparkapp.entity.Reservation;
import com.fi.muni.carparkapp.entity.Car;
import com.fi.muni.carparkapp.entity.Employee;
import com.fi.muni.carparkapp.entity.Office;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jan Starka
 */
public interface ReservationDao {

    /**
     * Gets reservation by ID
     * @param id ID, for which is reservation to be found
     * @return Reservation for given ID
     */
    public Reservation findById(Long id);

    /**
     * Gets all reservations
     * @return List of all reservations
     */
    public List<Reservation> findAll();

    /**
     * Gets reservations by employee
     * @param employee employee, for whom is reservation to be found
     * @return Reservations for given employee
     */
    public List<Reservation> findByEmployee(Employee employee);

    /**
     * Gets reservations by car
     * @param car car, for which is reservation to be found
     * @return Reservations for given car
     */
    public List<Reservation> findByCar(Car car);

    /**
     * Get all reservations by office
     * @param office office, for which is reservation to be found
     * @return Reservations for given office
     */
    //public List<Reservation> findByOffice(Office office);
    
    /**
     * Get all reservations in tange of two dates
     * @param fromDate beginning date
     * @param toDate ending date
     * @return Reservations for given date range
     */
    public List<Reservation> findByDateRange(Date fromDate, Date toDate);

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
