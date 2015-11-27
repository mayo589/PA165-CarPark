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
    Collection<ReservationDTO> getAllReservationsForEmployee(EmployeeDTO employee);
    Collection<ReservationDTO> getAllReservationsForCar(CarDTO car);
    Collection<ReservationDTO> getAllReservationsForOffice(OfficeDTO office);
    Collection<ReservationDTO> getReservationsForDateRange(Date fromDate, Date toDate);
    void addReservation(ReservationDTO reservationDTO);
    void cancelReservation(ReservationDTO reservationDTO);
    
}
