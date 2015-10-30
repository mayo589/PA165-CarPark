package com.fi.muni.carparkapp.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fi.muni.carparkapp.JpaTestContext;
import com.fi.muni.carparkapp.dao.ReservationDao;
import com.fi.muni.carparkapp.entity.Car;
import com.fi.muni.carparkapp.entity.Office;
import com.fi.muni.carparkapp.entity.Employee;
import com.fi.muni.carparkapp.entity.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Marek Mihalech
 */
@ContextConfiguration(classes=JpaTestContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class ReservationDaoTest extends AbstractTestNGSpringContextTests{

    @Autowired
    private ReservationDao reservationDao;
    
    @Autowired
    private CarDao carDao;
    
    @Autowired
    private OfficeDao officeDao;
    
    @Autowired
    private EmployeeDao employeeDao;
    
    private Car car1;
    private Employee employee1;
    private Office office1;

    @BeforeMethod
    public void before() throws ParseException {
        car1 = new Car();
        car1.setVin("vin1");
        carDao.create(car1);
        
        employee1 = new Employee();
        employee1.setFirstName("first");
        employee1.setLastName("last");
        employee1.setDateOfBirth(new Date());
        employeeDao.create(employee1);
        
        office1 = new Office();
        office1.setAddress("address1");
        office1.setName("name1");
        officeDao.create(office1);
        
    }

     
    
    @Test
    public void testFindAll() {
        Reservation res1 = new Reservation();
        res1.setFromDate(new Date());
        res1.setToDate(new Date());
        res1.setEmployee(employee1);
        res1.setCar(car1);
        res1.setOffice(office1);
        reservationDao.create(res1);
        
        List<Reservation> reservations = reservationDao.findAll();
        Assert.isTrue(reservations.size() == 1);
        
        Reservation res2 = new Reservation();
        res2.setFromDate(new Date());
        res2.setToDate(new Date());
        res2.setEmployee(employee1);
        res2.setCar(car1);
        res2.setOffice(office1);
        reservationDao.create(res2);
        
        List<Reservation> reservations2 = reservationDao.findAll();
        Assert.isTrue(reservations2.size() == 2);
    }
    
    @Test
    public void testFindById() {
        Reservation res1 = new Reservation();
        res1.setFromDate(java.sql.Date.valueOf("2000-11-01"));
        res1.setToDate(new Date());
        res1.setEmployee(employee1);
        res1.setCar(car1);
        res1.setOffice(office1);
        reservationDao.create(res1);
        
        Reservation found = reservationDao.findById(res1.getId());
        Assert.isTrue(found.getFromDate().equals(java.sql.Date.valueOf("2000-11-01")));
    }
    
    @Test
    public void testFindByEmployee() {
        Reservation res1 = new Reservation();
        res1.setFromDate(java.sql.Date.valueOf("2000-11-01"));
        res1.setToDate(new Date());
        res1.setEmployee(employee1);
        res1.setCar(car1);
        res1.setOffice(office1);
        reservationDao.create(res1);
        
        Reservation found = reservationDao.findByEmployee(res1.getEmployee());
        Assert.isTrue(found.getFromDate().equals(java.sql.Date.valueOf("2000-11-01")));
    }
    
    @Test
    public void testFindByCar() {
        Reservation res1 = new Reservation();
        res1.setFromDate(java.sql.Date.valueOf("2000-11-01"));
        res1.setToDate(new Date());
        res1.setEmployee(employee1);
        res1.setCar(car1);
        res1.setOffice(office1);
        reservationDao.create(res1);
        
        Reservation found = reservationDao.findByCar(res1.getCar());
        Assert.isTrue(found.getFromDate().equals(java.sql.Date.valueOf("2000-11-01")));
    }
    
    @Test
    public void testFindByOffice() {
        Reservation res1 = new Reservation();
        res1.setFromDate(java.sql.Date.valueOf("2000-11-01"));
        res1.setToDate(new Date());
        res1.setEmployee(employee1);
        res1.setCar(car1);
        res1.setOffice(office1);
        reservationDao.create(res1);
        
        Reservation found = reservationDao.findByOffice(res1.getOffice());
        Assert.isTrue(found.getFromDate().equals(java.sql.Date.valueOf("2000-11-01")));
    }
    
    @Test
    public void testDelete() {
        Reservation res1 = new Reservation();
        res1.setFromDate(java.sql.Date.valueOf("2000-11-01"));
        res1.setToDate(new Date());
        res1.setEmployee(employee1);
        res1.setCar(car1);
        res1.setOffice(office1);
        reservationDao.create(res1);
        reservationDao.delete(res1);
        Reservation found = reservationDao.findById(res1.getId());
        Assert.isNull(found);
    }
            
            
    
}
