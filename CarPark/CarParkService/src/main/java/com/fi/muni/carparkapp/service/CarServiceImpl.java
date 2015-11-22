/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fi.muni.carparkapp.service;

import com.fi.muni.carparkapp.dao.CarDao;
import com.fi.muni.carparkapp.dao.ReservationDao;
import com.fi.muni.carparkapp.entity.Car;
import com.fi.muni.carparkapp.entity.Reservation;
import java.util.Date;
import java.util.List;
import org.dozer.inject.Inject;

/**
 *
 * @author Marek Mihalech
 */
public class CarServiceImpl implements CarService{

    @Inject 
    private CarDao carDao;
    
    @Inject 
    private ReservationDao reservationDao;
    
    @Override
    public void create(Car c) {
        carDao.create(c);
    }

    @Override
    public void remove(Car c) {
        carDao.delete(c);
    }

    @Override
    public void update(Car c) {
        carDao.update(c);
    }

    @Override
    public Car findById(long id) {
        return carDao.findById(id);
    }

    @Override
    public Car findByVin(String vin) {
        return carDao.findByVin(vin);
    }

    @Override
    public List<Car> getAll() {
        return carDao.findAll();
    }

    @Override
    public List<Car> getAvailable() {
        List<Car> allCars = carDao.findAll();
        
        List<Reservation>  reservations = reservationDao.findAll();
        for(Reservation res : reservations){
            if(res.getToDate().after(new Date()))
            {
                for(Car c : allCars)
                {
                    if(c.getVin()== res.getCar().getVin()){
                        allCars.remove(c);
                        break;
                    }
                }
            }
        }
        return allCars;
    }
    
}
