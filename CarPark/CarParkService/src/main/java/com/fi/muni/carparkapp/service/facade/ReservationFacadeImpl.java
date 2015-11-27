/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fi.muni.carparkapp.service.facade;

import com.fi.muni.carparkapp.dto.CarDTO;
import com.fi.muni.carparkapp.dto.EmployeeDTO;
import com.fi.muni.carparkapp.dto.OfficeDTO;
import com.fi.muni.carparkapp.dto.ReservationDTO;
import com.fi.muni.carparkapp.entity.Car;
import com.fi.muni.carparkapp.entity.Office;
import com.fi.muni.carparkapp.entity.Reservation;
import com.fi.muni.carparkapp.entity.Employee;
import com.fi.muni.carparkapp.facade.ReservationFacade;
import com.fi.muni.carparkapp.service.ReservationService;
import com.fi.muni.carparkapp.service.BeanMappingService;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.dozer.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jan Starka
 */
@Service
public class ReservationFacadeImpl implements ReservationFacade {

    @Autowired
    private ReservationService reservationService;
    
    @Autowired
    private BeanMappingService beanMappingService;
    
    @Override
    public ReservationDTO getReservationById(Long reservationId) {
        return beanMappingService.mapTo(reservationService.getReservationById(reservationId), ReservationDTO.class);
    }
    
    @Override
    public Collection<ReservationDTO> getAllReservationsForEmployee(EmployeeDTO employee) {
        Employee e = new Employee(employee.getId());
        e.setAddress(employee.getAddress());
        //e.setAdmin(employee.get);
        e.setDateOfBirth(employee.getDateOfBirth());
        e.setFirstName(employee.getFirstName());
        e.setLastName(employee.getLastName());
        //e.setPasswordHash(employee.get);
        e.setTelephone(employee.getTelephone());
        return beanMappingService.mapTo(reservationService.getAllReservationsForEmloyee(e), ReservationDTO.class);
    }

    @Override
    public Collection<ReservationDTO> getAllReservationsForCar(CarDTO car) {
        Car c = new Car(car.getId());
        c.setColor(car.getColor());
        c.setFuelCapacity(car.getFuelCapacity());
        c.setModel(car.getModel());
        c.setPlateNumber(car.getPlateNumber());
        c.setVin(car.getVin());
        return beanMappingService.mapTo(reservationService.getAllReservationsForCar(c), ReservationDTO.class);
    }

    @Override
    public Collection<ReservationDTO> getAllReservationsForOffice(OfficeDTO office) {
        Office o = new Office(office.getId());
        o.setAddress(office.getAddress());
        o.setName(office.getName());
        return beanMappingService.mapTo(reservationService.getAllReservationsForOffice(o), ReservationDTO.class);
    }

    @Override
    public Collection<ReservationDTO> getReservationsForDateRange(Date fromDate, Date toDate) {
        return beanMappingService.mapTo(reservationService.getAllReservationsForDateRange(fromDate, toDate), ReservationDTO.class);
    }

    @Override
    public void addReservation(ReservationDTO reservationDTO) {
        Reservation r = beanMappingService.mapTo(reservationDTO, Reservation.class);
        reservationService.addReservation(r);
    }

    @Override
    public void cancelReservation(ReservationDTO reservationDTO) {
        Reservation r = beanMappingService.mapTo(reservationDTO, Reservation.class);
        reservationService.cancelReservation(r);
    }   
    
}
