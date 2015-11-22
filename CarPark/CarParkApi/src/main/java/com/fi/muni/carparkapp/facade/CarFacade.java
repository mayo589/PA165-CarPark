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
    
  public void addCar(CarDTO c);
  
  public void deleteCar(CarDTO c);
  
  public List<CarDTO> getAllCars();
  
  public List<CarDTO> getAllAvailableCars();
  
  public void updateCar(CarDTO c);
  
  public CarDTO getCarByVin(String vin);
  
  public CarDTO getCarById(Long id);
    
}
