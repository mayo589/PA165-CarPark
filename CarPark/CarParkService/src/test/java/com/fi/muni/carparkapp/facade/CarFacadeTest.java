/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fi.muni.carparkapp.facade;

import com.fi.muni.carparkapp.dao.ReservationDao;
import com.fi.muni.carparkapp.dto.CarDTO;
import com.fi.muni.carparkapp.entity.Car;
import com.fi.muni.carparkapp.entity.Employee;
import com.fi.muni.carparkapp.entity.Office;
import com.fi.muni.carparkapp.entity.Reservation;
import com.fi.muni.carparkapp.service.BeanMappingService;
import com.fi.muni.carparkapp.service.CarService;
import com.fi.muni.carparkapp.service.ReservationService;
import com.fi.muni.carparkapp.service.config.ServiceConfiguration;
import com.fi.muni.carparkapp.service.facade.CarFacadeImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.util.Assert;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author Marek Mihalech 410083
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class CarFacadeTest extends AbstractTransactionalTestNGSpringContextTests{
    
    @Mock
    private CarService carService;
    
    @Mock
    private ReservationService reservationService;
    
    @Inject
    private BeanMappingService beanMappingService;
    
    @Autowired
    @InjectMocks
    private CarFacade carFacade;
    
    @org.testng.annotations.BeforeClass
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    
    private Car car1;
    private Car car2;
    private Car car3;
    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private Office office1;
    private Office office2;
    private Office office3;
    
    
    @BeforeMethod
    public void setUpMethod() {
        office1 = new Office(1l);
        office1.setAddress("brno");
        office1.setName("AAA");
        
        office2 = new Office(2l);
        office2.setAddress("praha");
        office2.setName("BBB");
        
        office3 = new Office(3l);
        office3.setAddress("bratislava");
        office3.setName("CCC");
        
        employee1 =  new Employee(11l);
        employee1.setFirstName("first");
        employee1.setLastName("last");
        employee1.setDateOfBirth(new Date());
        
        employee2 =  new Employee(22L);
        employee2.setFirstName("first");
        employee2.setLastName("last");
        employee2.setDateOfBirth(new Date());
        
        employee3 =  new Employee(33L);
        employee3.setFirstName("first");
        employee3.setLastName("last");
        employee3.setDateOfBirth(new Date());
        
        
        car1 = new Car(1l);
        car1.setVin("vinvin");
        
        car2 = new Car(2l);
        car2.setVin("vinvinn");
        
        car3 = new Car(3l);
        car3.setVin("vinvinnn");
    }
    
    @org.testng.annotations.Test
    public void testAddCar() {
        Car car = new Car(1l);
        
        CarDTO carDTO = new CarDTO();
        carDTO.setId(1l);
        
        carFacade.addCar(carDTO);
        
        when(carService.findById(1l)).thenReturn(car);
        CarDTO foundCarDTO = carFacade.getCarById(1l);
        Assert.notNull(foundCarDTO);
        Assert.isTrue(foundCarDTO.equals(carDTO));
    }
    
    @org.testng.annotations.Test
    public void testDeleteCar() {
        Car car = new Car(1l);
        
        CarDTO carDTO = new CarDTO();
        carDTO.setId(1l);
        
        carFacade.addCar(carDTO);
        when(carService.findById(1l)).thenReturn(car);
        
        carFacade.deleteCar(carDTO);
        verify(carService).remove(any(Car.class));
    }
    
    @org.testng.annotations.Test
    public void testGetAll() {
        Car car1 = new Car(1l);
        
        CarDTO carDTO1 = new CarDTO();
        carDTO1.setId(1l);
        
        Car car2 = new Car(2l);
        
        CarDTO carDTO2 = new CarDTO();
        carDTO2.setId(2l);
        
        List<CarDTO> carsDTOs = new ArrayList<CarDTO>();
        carsDTOs.add(carDTO1);
        carsDTOs.add(carDTO2);
        
        List<Car> cars = new ArrayList<Car>();
        cars.add(car1);
        cars.add(car2);
        
        carFacade.addCar(carDTO1);
        carFacade.addCar(carDTO2);
        
        when(carService.getAll()).thenReturn(cars);
        assertEquals(carsDTOs.size(), carFacade.getAllCars().size());
    }
    
    @org.testng.annotations.Test
    public void testGetAvailable() {
        
        
        Car carr1 = new Car(1l);
        
        CarDTO carrDTO1 = new CarDTO();
        carrDTO1.setId(1l);
        
        
        Car carr2 = new Car(2l);
        
        CarDTO carrDTO2 = new CarDTO();
        carrDTO2.setId(2l);
        
        List<CarDTO> carsDTOs = new ArrayList<CarDTO>();
        carsDTOs.add(carrDTO1);
        
        List<Car> cars = new ArrayList<Car>();
        cars.add(carr1);
        
        carFacade.addCar(carrDTO1);
        carFacade.addCar(carrDTO2);
        
        
        Reservation res1 = new Reservation(4L);        
        res1.setEmployee(employee1);
        res1.setCar(carr1);
        //res1.setOffice(office1);
        res1.setFromDate(new Date());
        res1.setToDate(java.sql.Date.valueOf("2016-11-01"));
        reservationService.addReservation(res1);
        
        
        when(carService.getAvailable()).thenReturn(cars);
        assertEquals(carsDTOs.size(), carFacade.getAllAvailableCars().size());
    }
    
    @org.testng.annotations.Test
    public void getById() {
        Car car = new Car(1l);
        CarDTO carDTO = new CarDTO();
        carDTO.setId(1l);
        
        Car car2 = new Car(2l);
        CarDTO carDTO2 = new CarDTO();
        carDTO2.setId(2l);
        
        Car car3 = new Car(3l);
        CarDTO carDTO3 = new CarDTO();
        carDTO2.setId(3l);
        
        carFacade.addCar(carDTO);
        carFacade.addCar(carDTO2);
        carFacade.addCar(carDTO3);
        
        when(carService.findById(2l)).thenReturn(car2);
        CarDTO foundCarDTO = carFacade.getCarById(2l);
        Assert.notNull(foundCarDTO);
        Assert.isTrue(foundCarDTO.equals(carDTO2));
    }
    
    @org.testng.annotations.Test
    public void getByVin() {
        Car car = new Car(1l);
        car.setVin("vin");
        CarDTO carDTO = new CarDTO();
        carDTO.setId(1l);
        carDTO.setVin("vin");
        
        Car car2 = new Car(2l);
        car2.setVin("vinvin");
        CarDTO carDTO2 = new CarDTO();
        carDTO2.setId(2l);
        carDTO2.setVin("vinvin");
        
        carFacade.addCar(carDTO);
        carFacade.addCar(carDTO2);
        
        
        when(carService.findByVin("vinvin")).thenReturn(car2);
        CarDTO foundCarDTO = carFacade.getCarByVin("vinvin");
        Assert.notNull(foundCarDTO);
        Assert.isTrue(foundCarDTO.equals(carDTO2));
    }
    
    @org.testng.annotations.Test
    public void testUpdate() {
        Car car = new Car(1l);
        CarDTO carDTO = new CarDTO();
        carDTO.setId(1l);
        
        Car car2 = new Car(2l);
        car2.setModel("honda");
        CarDTO carDTO2 = new CarDTO();
        carDTO2.setId(2l);
        carDTO2.setModel("honda");
        
        carFacade.addCar(carDTO);
        carFacade.addCar(carDTO2);
        
        when(carService.findById(2l)).thenReturn(car2);
        CarDTO foundCarDTO = carFacade.getCarById(2l);
        Assert.notNull(foundCarDTO);
        Assert.isTrue(foundCarDTO.equals(carDTO2));
        
        carDTO2.setModel("mazda");
        car2.setModel("mazda");
        carFacade.updateCar(carDTO2);
        foundCarDTO = carFacade.getCarById(2l);
        Assert.notNull(foundCarDTO);
        Assert.isTrue(foundCarDTO.equals(carDTO2));
    }
}
