package com.fi.muni.carparkapp.service;

import com.fi.muni.carparkapp.entity.Reservation;
import com.fi.muni.carparkapp.entity.Employee;
import com.fi.muni.carparkapp.entity.Office;
import com.fi.muni.carparkapp.entity.Car;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Date;

/**
 *
 * @author Jan Starka
 */
@Service
public interface ReservationService {
    
    List<Reservation> getAllReservations();
    
    /**
     * Gets all reservations for employee
     * @param employee Employee for whose reservation will be returned
     * @return list of reservations for given employee
     */
    List<Reservation> getAllReservationsForEmloyee(Employee employee);
    
    /**
     * Gets all reservations for car
     * @param car Car for which reservation will be returned
     * @return 
     */
    List<Reservation> getAllReservationsForCar(Car car);
    
    /**
     * Gets all reservations for office
     * @param office Office for which reservation will be returned
     * @return 
     */
    //List<Reservation> getAllReservationsForOffice(Office office);
    
    /**
     * Gets all reservations for specified rage of dates
     * @param fromDate beginning date
     * @param toDate ending date
     * @return 
     */
    List<Reservation> getAllReservationsForDateRange(Date fromDate, Date toDate);
    
    /**
     * Adds new reservation
     * @param reservation Reservation to be added
     */
    void addReservation(Reservation reservation);
    
    /**
     * Cancels reservation
     * @param reservation Reservation to be cancelled
     */
    void cancelReservation(Reservation reservation);
    
    /**
     * Get reservation by ID
     * @param reservationId Reservation ID to be returned
     * @return 
     */
    Reservation getReservationById(Long reservationId);
    
}
