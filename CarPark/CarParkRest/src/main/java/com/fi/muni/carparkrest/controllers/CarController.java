/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fi.muni.carparkrest.controllers;

import com.fi.muni.carparkapp.dto.CarDTO;
import com.fi.muni.carparkapp.facade.CarFacade;
import java.util.List;
import javax.inject.Inject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marek mihalech 410083
 */
@RestController
@RequestMapping("/car")
public class CarController {
    @Inject
    private CarFacade carFacade;
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final List<CarDTO> getCars() {
        return carFacade.getAllCars();
    }
    
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final CarDTO getCarById(@PathVariable("id") long id) {
        return carFacade.getCarById(id);
    }
    
    @RequestMapping(value = "/vin/{vin}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final CarDTO getCarByVin(@PathVariable("vin") String vin) {
        return carFacade.getCarByVin(vin);
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final CarDTO createCar(@RequestBody CarDTO carDTO) {
        carFacade.addCar(carDTO);
        return carFacade.getCarByVin(carDTO.getVin());
    }
    
}
