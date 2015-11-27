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
    
    /**
     * Gets all reservations for employee
     * @param employee
     * @return list of reservations for given employee
     */
    List<Reservation> getAllReservationsForEmloyee(Employee employee);
    List<Reservation> getAllReservationsForCar(Car car);
    List<Reservation> getAllReservationsForOffice(Office office);
    List<Reservation> getAllReservationsForDateRange(Date fromDate, Date toDate);
    void addReservation(Reservation reservation);
    void cancelReservation(Reservation reservation);
    Reservation getReservationById(Long reservationId);
    
}
