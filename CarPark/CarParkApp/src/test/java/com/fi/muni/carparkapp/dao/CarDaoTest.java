package com.fi.muni.carparkapp.dao;

import com.fi.muni.carparkapp.JpaTestContext;
import com.fi.muni.carparkapp.entity.Car;
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
 * @author Jan Hellar (436358)
 */
@ContextConfiguration(classes=JpaTestContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class CarDaoTest extends AbstractTestNGSpringContextTests {
    
    @Autowired
    public CarDao carDao;
    
    @Test
    public void findAll() {
        Car car1 = new Car();
        Car car2 = new Car();
        car1.setVin("fake");
        car2.setVin("fake");
        
        carDao.create(car1);
        carDao.create(car2);
        
        List<Car> cars = carDao.findAll();
        
        Assert.assertEquals(cars.size(), 2);
    }
    
    @Test
    public void find() {
        Car car = new Car();
        car.setVin("fake");
        carDao.create(car);
        Car found = carDao.findById(car.getId());
        Assert.assertEquals(found.getVin(), "fake");
    }
    
    @Test
    public void delete() {
        Car car = new Car();
        car.setVin("fake");
        carDao.create(car);
        carDao.delete(car);
        Assert.assertNull(carDao.findById(car.getId()));
    }
    
    @Test
    public void update() {
        Car car = new Car();
        car.setVin("fake");
        carDao.create(car);
        car.setVin("fake2");
        carDao.update(car);
        Assert.assertEquals(carDao.findById(car.getId()).getVin(), "fake2");
    }
    
}
