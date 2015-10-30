package com.fi.muni.carparkapp.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fi.muni.carparkapp.JpaTestContext;
import com.fi.muni.carparkapp.entity.Employee;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Jan Starka
 */
@ContextConfiguration(classes=JpaTestContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class EmployeeDaoTest extends AbstractTestNGSpringContextTests{
    
    /**
     *
     */
    @Autowired
    public EmployeeDao employeeDao;
    
    Calendar c1 = GregorianCalendar.getInstance();
    Date sDate;

    public EmployeeDaoTest() {
        c1.set(1962, 1, 30);  //January 30th 2000
        sDate = c1.getTime();
    }
    
    
    
    @Test
    public void findAll() throws ParseException {
 
        Employee e1 = new Employee();
        e1.setAddress("Boženy Němcové");
        e1.setFirstName("Jaroslav");
        e1.setLastName("Novák");
        e1.setDateOfBirth(sDate);
        e1.setTelephone("999000000");
        
        employeeDao.create(e1);
        
        List<Employee> employees = employeeDao.findAll();
        
        Assert.assertEquals(employees.size(), 1);
    }
    
    @Test
    public void find() throws ParseException {
        Employee e1 = new Employee();
        e1.setAddress("Boženy Němcové");
        e1.setFirstName("Jaroslav");
        e1.setLastName("Novák");
        e1.setDateOfBirth(sDate);
        e1.setTelephone("999000000");
        employeeDao.create(e1);
        Employee found = employeeDao.findById(e1.getId());
        Assert.assertEquals(found.getFirstName(), "Jaroslav");
    }
    
    @Test
    public void delete() throws ParseException {
        Employee e1 = new Employee();
        e1.setAddress("Boženy Němcové");
        e1.setFirstName("Jaroslav");
        e1.setLastName("Novák");
        e1.setDateOfBirth(sDate);
        e1.setTelephone("999000000");
        employeeDao.create(e1);
        employeeDao.delete(e1);
        Assert.assertNull(employeeDao.findById(e1.getId()));
    }
    
    @Test
    public void update() throws ParseException {
        Employee e1 = new Employee();
        e1.setAddress("Boženy Němcové");
        e1.setFirstName("Jaroslav");
        e1.setLastName("Novák");
        e1.setDateOfBirth(sDate);
        e1.setTelephone("999000000");
        employeeDao.create(e1);
        e1.setFirstName("Michal");
        employeeDao.update(e1);
        Assert.assertEquals(employeeDao.findById(e1.getId()).getFirstName(), "Michal");
    }
    
}
