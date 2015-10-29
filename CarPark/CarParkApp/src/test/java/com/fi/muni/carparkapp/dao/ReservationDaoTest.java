package com.fi.muni.carparkapp.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fi.muni.carparkapp.JpaTestContext;
import com.fi.muni.carparkapp.dao.ReservationDao;
import com.fi.muni.carparkapp.entity.Reservation;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
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
    
   
     @Test
    public void testCreate() {         
        Reservation resA = new Reservation();
        resA.setFromDate(new Date());
        resA.setEmployee(null);
        
        Assert.isNull(resA.getId());
        reservationDao.create(resA);
        Assert.notNull(reservationDao.findById(resA.getId()));
    }
}
