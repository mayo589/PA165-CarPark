/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fi.muni.carparkapp.service;

import com.fi.muni.carparkapp.dao.CarDao;
import com.fi.muni.carparkapp.dao.EmployeeDao;
import com.fi.muni.carparkapp.dao.OfficeDao;
import com.fi.muni.carparkapp.dao.ReservationDao;
import com.fi.muni.carparkapp.dto.ReservationDTO;
import com.fi.muni.carparkapp.entity.Car;
import com.fi.muni.carparkapp.entity.Employee;
import com.fi.muni.carparkapp.entity.Office;
import com.fi.muni.carparkapp.entity.Reservation;
import com.fi.muni.carparkapp.service.config.ServiceConfiguration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author Marek Mihalech 410083
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class ReservationServiceTest extends AbstractTransactionalTestNGSpringContextTests{
  
    @Mock
    private ReservationDao reservationDao;

    @Inject
    private BeanMappingService beanMappingService;

    @Autowired
    @InjectMocks
    private ReservationService reservationService;
    
    
    @Autowired
    @InjectMocks
    private CarService carService;
    
    @Autowired
    @InjectMocks
    private OfficeService officeService;
    
    @Autowired
    @InjectMocks
    private EmployeeService employeeService;
    
    @org.testng.annotations.BeforeClass
    public void setup() throws ServiceException {
        
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
        MockitoAnnotations.initMocks(this);
        
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
    public void addReservation() {
        Reservation res1 = new Reservation(4L);
        res1.setEmployee(employee1);
        res1.setCar(car1);
        //res1.setOffice(office1);
        res1.setFromDate(new Date());
        res1.setToDate(new Date());
        
        reservationService.addReservation(res1);
        verify(reservationDao).create(res1);
        verifyNoMoreInteractions(reservationDao);
    }
    
    @org.testng.annotations.Test
    public void findById() {
        Reservation res1 = new Reservation(4L);
        res1.setEmployee(employee1);
        res1.setCar(car1);
        //res1.setOffice(office1);
        res1.setFromDate(new Date());
        res1.setToDate(new Date());
        
        when(reservationDao.findById(4L)).thenReturn(res1);
        Assert.assertEquals(reservationService.getReservationById(4L), res1);
        verify(reservationDao).findById(4L);
        verifyNoMoreInteractions(reservationDao);
    }
    
    @org.testng.annotations.Test
    public void cancelRes() {
        Reservation res1 = new Reservation(4L);
        res1.setEmployee(employee1);
        res1.setCar(car1);
        //res1.setOffice(office1);
        res1.setFromDate(new Date());
        res1.setToDate(new Date());
        res1.setCancelled(false);
        
        when(reservationDao.findById(4L)).thenReturn(res1);
        Assert.assertEquals(reservationService.getReservationById(4L).isCancelled(), false);
        verify(reservationDao).findById(4L);
        
        res1.setCancelled(true);
        reservationService.cancelReservation(res1);
        Assert.assertEquals(reservationService.getReservationById(4L).isCancelled(), true);
    }
    
    @org.testng.annotations.Test
    public void getResForEmployee() {
        Reservation res1 = new Reservation(4L);        
        res1.setEmployee(employee1);
        res1.setCar(car1);
        //res1.setOffice(office1);
        res1.setFromDate(new Date());
        res1.setToDate(new Date());
        
        Reservation res2 = new Reservation(5L);        
        res2.setEmployee(employee1);
        res2.setCar(car2);
        //res2.setOffice(office1);
        res2.setFromDate(new Date());
        res2.setToDate(new Date());
        
        Reservation res3 = new Reservation(6L);        
        res3.setEmployee(employee2);
        res3.setCar(car3);
        //res3.setOffice(office1);
        res3.setFromDate(new Date());
        res3.setToDate(new Date());
        
        reservationService.addReservation(res1);
        reservationService.addReservation(res2);
        reservationService.addReservation(res3);
        
        
        List<Reservation> expectedReservationsForFirst = new ArrayList<>();
        expectedReservationsForFirst.add(res1);
        expectedReservationsForFirst.add(res2);
        
        List<Reservation> expectedReservationsForSecond = new ArrayList<>();
        expectedReservationsForSecond.add(res3);
        
        when(reservationDao.findByEmployee(employee1)).thenReturn(expectedReservationsForFirst);
        when(reservationDao.findByEmployee(employee2)).thenReturn(expectedReservationsForSecond);
        
        Assert.assertEquals(reservationService.getAllReservationsForEmloyee(employee1).size(), expectedReservationsForFirst.size());
        Assert.assertEquals(reservationService.getAllReservationsForEmloyee(employee2).size(), expectedReservationsForSecond.size());
    }
    
    @org.testng.annotations.Test
    public void getResForCar() {
        Reservation res1 = new Reservation(4L);        
        res1.setEmployee(employee1);
        res1.setCar(car1);
        //res1.setOffice(office1);
        res1.setFromDate(new Date());
        res1.setToDate(new Date());
        
        Reservation res2 = new Reservation(5L);        
        res2.setEmployee(employee1);
        res2.setCar(car2);
        //res2.setOffice(office1);
        res2.setFromDate(new Date());
        res2.setToDate(new Date());
        
        Reservation res3 = new Reservation(6L);        
        res3.setEmployee(employee1);
        res3.setCar(car2);
        //res3.setOffice(office1);
        res3.setFromDate(new Date());
        res3.setToDate(new Date());
        
        reservationService.addReservation(res1);
        reservationService.addReservation(res2);
        reservationService.addReservation(res3);
        
        List<Reservation> expectedReservationsForFirst = new ArrayList<>();
        expectedReservationsForFirst.add(res1);
        
        List<Reservation> expectedReservationsForSecond = new ArrayList<>();
        expectedReservationsForSecond.add(res2);
        expectedReservationsForSecond.add(res3);
        
        when(reservationDao.findByCar(car1)).thenReturn(expectedReservationsForFirst);
        when(reservationDao.findByCar(car2)).thenReturn(expectedReservationsForSecond);
        when(reservationDao.findByCar(car3)).thenReturn(new ArrayList<>());
        
        Assert.assertEquals(reservationService.getAllReservationsForCar(car1).size(), expectedReservationsForFirst.size());
        Assert.assertEquals(reservationService.getAllReservationsForCar(car2).size(), expectedReservationsForSecond.size());
        Assert.assertEquals(reservationService.getAllReservationsForCar(car3).size(), 0);
    }
    
    /*@org.testng.annotations.Test
    public void getResForOffice(){
        Reservation res1 = new Reservation(4L);        
        res1.setEmployee(employee1);
        res1.setCar(car1);
        //res1.setOffice(office1);
        res1.setFromDate(new Date());
        res1.setToDate(new Date());
        
        Reservation res2 = new Reservation(5L);        
        res2.setEmployee(employee1);
        res2.setCar(car2);
        //res2.setOffice(office1);
        res2.setFromDate(new Date());
        res2.setToDate(new Date());
        
        Reservation res3 = new Reservation(6L);        
        res3.setEmployee(employee1);
        res3.setCar(car2);
        //res3.setOffice(office2);
        res3.setFromDate(new Date());
        res3.setToDate(new Date());
        
        reservationService.addReservation(res1);
        reservationService.addReservation(res2);
        reservationService.addReservation(res3);
        
        List<Reservation> expectedReservationsForFirst = new ArrayList<>();
        expectedReservationsForFirst.add(res1);
        expectedReservationsForFirst.add(res2);
        
        List<Reservation> expectedReservationsForSecond = new ArrayList<>();
        expectedReservationsForSecond.add(res3);
        
        when(reservationDao.findByOffice(office1)).thenReturn(expectedReservationsForFirst);
        when(reservationDao.findByOffice(office2)).thenReturn(expectedReservationsForSecond);
        when(reservationDao.findByOffice(office3)).thenReturn(new ArrayList<>());
        
        Assert.assertEquals(reservationService.getAllReservationsForOffice(office1).size(), expectedReservationsForFirst.size());
        Assert.assertEquals(reservationService.getAllReservationsForOffice(office2).size(), expectedReservationsForSecond.size());
        Assert.assertEquals(reservationService.getAllReservationsForOffice(office3).size(), 0);
    }*/
    
    @org.testng.annotations.Test
    public void getResForRange(){
        Reservation res1 = new Reservation(4L);        
        res1.setEmployee(employee1);
        res1.setCar(car1);
        //res1.setOffice(office1);
        res1.setFromDate(new Date());
        res1.setToDate(java.sql.Date.valueOf("2015-11-01"));
        
        Reservation res2 = new Reservation(5L);        
        res2.setEmployee(employee1);
        res2.setCar(car2);
        //res2.setOffice(office1);
        res2.setFromDate(new Date());
        res2.setToDate(java.sql.Date.valueOf("2015-11-22"));
        
        Reservation res3 = new Reservation(6L);        
        res3.setEmployee(employee1);
        res3.setCar(car2);
        //res3.setOffice(office2);
        res3.setFromDate(new Date());
        res3.setToDate(java.sql.Date.valueOf("2015-05-15"));
        
        reservationService.addReservation(res1);
        reservationService.addReservation(res2);
        reservationService.addReservation(res3);
        
        List<Reservation> expectedReservationsForFirst = new ArrayList<>();
        expectedReservationsForFirst.add(res1);
        expectedReservationsForFirst.add(res2);
        
        List<Reservation> expectedReservationsForSecond = new ArrayList<>();
        expectedReservationsForSecond.add(res3);
        
        Date dateFrom1 = java.sql.Date.valueOf("2015-10-01");
        Date dateTo1 = java.sql.Date.valueOf("2015-11-30");
        
        Date dateFrom2 = java.sql.Date.valueOf("2015-05-10");
        Date dateTo2 = java.sql.Date.valueOf("2015-05-20");
        
        when(reservationDao.findByDateRange(dateFrom1, dateTo1)).thenReturn(expectedReservationsForFirst);
        when(reservationDao.findByDateRange(dateFrom2, dateTo2)).thenReturn(expectedReservationsForSecond);
        
        Assert.assertEquals(reservationService.getAllReservationsForDateRange(dateFrom1, dateTo1).size(), expectedReservationsForFirst.size());
        Assert.assertEquals(reservationService.getAllReservationsForDateRange(dateFrom2, dateTo2).size(), expectedReservationsForSecond.size());
    }
}
