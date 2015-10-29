package com.fi.muni.carparkapp.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fi.muni.carparkapp.dao.OfficeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

/**
 *
 * @author Marek Mihalec
 */
public class OfficeDaoTest {
    
   
    @Autowired
    private OfficeDao officeDao;
    
    @Test
    public void testCreate() { 
        
    }
    
}
