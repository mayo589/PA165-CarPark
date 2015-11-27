package com.fi.muni.carparkapp.facade;

import com.fi.muni.carparkapp.dto.ReservationDTO;
import com.fi.muni.carparkapp.dto.EmployeeDTO;
import com.fi.muni.carparkapp.dto.CarDTO;
import com.fi.muni.carparkapp.dto.OfficeDTO;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Jan Starka
 */
public interface ReservationFacade {
    
    /**
     * Gets reservation by Id
     * @param reservationId
     * @return reservation for given id
     */
    ReservationDTO getReservationById(Long reservationId);
    
    /**
     * Gets reservations for given employee
     * @param employee employee for whom the reservation is given
     * @return reservation for given employee
     */
    Collection<ReservationDTO> getAllReservationsForEmployee(EmployeeDTO employee);
    
    /**
     * Gets reservations for given car
     * @param car car for which the reservation is given
     * @return reservation for given car
     */
    Collection<ReservationDTO> getAllReservationsForCar(CarDTO car);
    
    /**
     * Gets reservations for given office
     * @param office office for which the reservation is given
     * @return reservation for given office
     */
    Collection<ReservationDTO> getAllReservationsForOffice(OfficeDTO office);
    
    /**
     * Gets reservations for given date range
     * @param fromDate beginning date
     * @param toDate ending date
     * @return reservations for given date range
     */
    Collection<ReservationDTO> getReservationsForDateRange(Date fromDate, Date toDate);
    void addReservation(ReservationDTO reservationDTO);
    void cancelReservation(ReservationDTO reservationDTO);
    
}
