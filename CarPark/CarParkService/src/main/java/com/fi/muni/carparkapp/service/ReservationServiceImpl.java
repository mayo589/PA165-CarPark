package com.fi.muni.carparkapp.service;

import com.fi.muni.carparkapp.dao.ReservationDao;
import com.fi.muni.carparkapp.entity.Car;
import com.fi.muni.carparkapp.entity.Employee;
import com.fi.muni.carparkapp.entity.Office;
import com.fi.muni.carparkapp.entity.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jan Starka
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationDao reservationDao;

    @Override
    public Reservation getReservationById(Long reservationId) {
        return reservationDao.findById(reservationId);
    }

    @Override
    public List<Reservation> getAllReservationsForEmloyee(Employee employee) {
        return reservationDao.findByEmployee(employee);
    }

    @Override
    public List<Reservation> getAllReservationsForCar(Car car) {
        return reservationDao.findByCar(car);
    }

    @Override
    public List<Reservation> getAllReservationsForOffice(Office office) {
        return reservationDao.findByOffice(office);
    }

    @Override
    public List<Reservation> getAllReservationsForDateRange(Date fromDate, Date toDate) {
        return reservationDao.findByDateRange(fromDate, toDate);
    }

    @Override
    public void addReservation(Reservation reservation) {
        reservationDao.create(reservation);
    }

    @Override
    public void cancelReservation(Reservation reservation) {
        reservation.setCancelled(true);
        reservationDao.update(reservation);
    }

}
