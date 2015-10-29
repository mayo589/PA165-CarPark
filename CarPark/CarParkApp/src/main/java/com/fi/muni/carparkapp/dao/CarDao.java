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
    public Car findById(Long id);
    public void create(Car c);
    public void delete(Car c);
    public List<Car> findAll();
    public void update(Car c);
}
