/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fi.muni.carparkapp.dao;

import com.fi.muni.carparkapp.entity.Car;
import java.util.List;

/**
 *
 * @author Marek Mihalech
 */
public interface CarDao {

    /**
     * Returns car by id
     * @param id id of car to be found
     * @return Car object with specified id
     */
    public Car findById(Long id);
    
     /**
     * Returns car by vin
     * @param vin vin of car to be found
     * @return Car object with specified vin
     */
    public Car findByVin(String vin);

    /**
     * Persists Car object
     * @param c Car object to be persisted
     */
    public void create(Car c);

    /**
     * Removes car object
     * @param c Car to be removed
     */
    public void delete(Car c);

    /**
     * Gets all cars 
     * @return list of all cars
     */
    public List<Car> findAll();

    /**
     * Updates car record
     * @param c updated car record
     */
    public void update(Car c);
}
