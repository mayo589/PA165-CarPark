/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fi.muni.carparkapp.service.facade;

import com.fi.muni.carparkapp.dto.CarDTO;
import com.fi.muni.carparkapp.entity.Car;
import com.fi.muni.carparkapp.facade.CarFacade;
import com.fi.muni.carparkapp.service.BeanMappingService;
import com.fi.muni.carparkapp.service.CarService;
import java.util.List;
import org.dozer.inject.Inject;

/**
 *
 * @author Marek Mihalech 410083
 */
public class CarFacadeImpl implements CarFacade{

    @Inject
    private CarService carService;
    
    @Inject
    private BeanMappingService beanMappingService;
    
    @Override
    public void addCar(CarDTO carDTO) {
        Car car = beanMappingService.mapTo(carDTO, Car.class);
        carService.create(car);
    }

    @Override
    public void deleteCar(CarDTO carDTO) {
        Car car = beanMappingService.mapTo(carDTO, Car.class);
        carService.remove(car);
    }

    @Override
    public List<CarDTO> getAllCars() {
        return beanMappingService.mapTo(carService.getAll(),CarDTO.class);
    }

    @Override
    public List<CarDTO> getAllAvailableCars() {
        return beanMappingService.mapTo(carService.getAvailable(),CarDTO.class);
    }

    @Override
    public void updateCar(CarDTO carDTO) {
        Car car = beanMappingService.mapTo(carDTO, Car.class);
        carService.update(car);
    }

    @Override
    public CarDTO getCarByVin(String vin) {
        return beanMappingService.mapTo(carService.findByVin(vin),CarDTO.class);
    }

    @Override
    public CarDTO getCarById(Long id) {
        return beanMappingService.mapTo(carService.findById(id),CarDTO.class);
    }
    
}
