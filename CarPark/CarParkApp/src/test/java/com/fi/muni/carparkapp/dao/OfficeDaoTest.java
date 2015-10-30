package com.fi.muni.carparkapp.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fi.muni.carparkapp.JpaTestContext;
import com.fi.muni.carparkapp.dao.OfficeDao;
import com.fi.muni.carparkapp.entity.Office;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Marek Mihalech (410083)
 */
@ContextConfiguration(classes=JpaTestContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class OfficeDaoTest extends AbstractTestNGSpringContextTests{
    
   
    @Autowired
    private OfficeDao officeDao;
    
    @Test
    public void testFindAll() { 
        Office office1 = new Office();
        office1.setName("name1");
        office1.setAddress("address1");
        officeDao.create(office1);
        
        List<Office> listOffices = officeDao.findAll();
        Assert.isTrue(listOffices.size() == 1);
        
        Office office2 = new Office();
        office2.setName("name2");
        office2.setAddress("address2");
        officeDao.create(office2);
        
        List<Office> listOffices2 = officeDao.findAll();
        Assert.isTrue(listOffices2.size() == 2);
    }
    
    @Test
    public void testFindById() {
        Office office1 = new Office();
        office1.setName("name1");
        office1.setAddress("address1");
        officeDao.create(office1);
        
        Office found = officeDao.findById(office1.getId());
        Assert.isTrue(found.getName().equals("name1"));
        Assert.isTrue(found.getAddress().equals("address1"));
    }
    
    @Test
    public void testFindByName(){
        Office office1 = new Office();
        office1.setName("name1");
        office1.setAddress("address1");
        officeDao.create(office1);
        
        Office found = officeDao.findByName(office1.getName());
        Assert.isTrue(found.getName().equals("name1"));
        Assert.isTrue(found.getAddress().equals("address1"));
    }
    
    @Test
    public void testFindByAddress(){
        Office office1 = new Office();
        office1.setName("name1");
        office1.setAddress("address1");
        officeDao.create(office1);
        
        Office found = officeDao.findByAddress(office1.getAddress());
        Assert.isTrue(found.getName().equals("name1"));
        Assert.isTrue(found.getAddress().equals("address1"));
    }
    
    @Test
    public void testDelete(){
        Office office1 = new Office();
        office1.setName("name1");
        office1.setAddress("address1");
        officeDao.create(office1);
        officeDao.delete(office1);
        Office found = officeDao.findById(office1.getId());
        Assert.isNull(found);
    }
    
}
