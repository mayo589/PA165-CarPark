/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fi.muni.carparkapp.service;

import com.fi.muni.carparkapp.entity.Car;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marek Mihalech (410083)
 */
@Service
public interface CarService {
    
    public void create(Car c);
    
    public void remove(Car c);
    
    public void update(Car c);
    
    public Car findById(long id);
    
    public Car findByVin(String vin);
    
    public List<Car> getAll();
    
    public List<Car> getAvailable();
    
}
