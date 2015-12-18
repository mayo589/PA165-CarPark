package com.fi.muni.carparkapp.facade;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import com.fi.muni.carparkapp.dto.CarDTO;

/**
 *
 * @author Marek Mihalech 410083
 */
public interface CarFacade {
    
    /**
     *Adding CarDTO c
     * @param c
     */
    public void addCar(CarDTO c);
  
    /**
     *Deleting CarDTO c
     * @param c
     */
    public void deleteCar(CarDTO c);
  
    /**
     *Getting all cars
     * @return all cars
     */
    public List<CarDTO> getAllCars();
  
    /**
     *Getting available cars
     * @return available cars
     */
    public List<CarDTO> getAllAvailableCars();
  
    /**
     *Updating car
     * @param c car to update
     */
    public void updateCar(CarDTO c);
  
    /**
     *Getting car by vin
     * @param vin of the car
     * @return
     */
    public CarDTO getCarByVin(String vin);
  
    /**
     *Getting car by id
     * @param id of car
     * @return
     */
    public CarDTO getCarById(Long id);
    
    public boolean isAvailable(CarDTO c);
}
