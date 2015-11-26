package com.fi.muni.carparkapp.service;

import com.fi.muni.carparkapp.dao.CarDao;
import com.fi.muni.carparkapp.dao.ReservationDao;
import com.fi.muni.carparkapp.entity.Car;
import com.fi.muni.carparkapp.entity.Reservation;
import com.fi.muni.carparkapp.service.config.ServiceConfiguration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Jan Hellar
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class CarServiceTest extends AbstractTransactionalTestNGSpringContextTests {
    
    @Mock
    private CarDao carDao;
    
    @Mock
    private ReservationDao reservationDao;
    
    @Autowired
    @InjectMocks
    private CarService carService;
    
    private Car testCar;
    
    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }
    
    @BeforeMethod
    public void prepareTestCar() {
        testCar = new Car(1L);
        testCar.setVin("1");
        testCar.setModel("a");
        testCar.setPlateNumber("2");
        testCar.setFuelCapacity(1);
        testCar.setColor("b");
    }
    
    @Test
    public void createAndFindByIdTest() {
        carService.create(testCar);
        Long id = testCar.getId();
        
        when(carDao.findById(any())).thenReturn(testCar);
        
        Car c = carService.findById(id);
        Assert.assertNotNull(id);
        Assert.assertNotNull(testCar);
        Assert.assertNotNull(c);
        Assert.assertEquals(c, testCar);
    }
    
    @Test
    public void findAllTest() {
        List<Car> cars = new ArrayList<>();
        cars.add(testCar);
        
        when(carDao.findAll()).thenReturn(cars);
        
        List<Car> f = carService.getAll();
        Assert.assertNotNull(f);
        Assert.assertEquals(f, cars);
    }
    
    @Test
    public void findAllAvailableTest() {
        Reservation r = new Reservation();
        r.setCar(testCar);
        Calendar c = Calendar.getInstance(); 
        c.setTime(new Date()); 
        c.add(Calendar.DATE, -1);
        Calendar c2 = Calendar.getInstance(); 
        c2.setTime(new Date()); 
        c2.add(Calendar.DATE, 1);
        r.setFromDate(c.getTime());
        r.setToDate(c2.getTime());
        
        Car car1 = new Car();
        
        Car car2 = new Car();
        Reservation r2 = new Reservation();
        r2.setCar(car2);
        r2.setToDate(c.getTime());
        
        List<Reservation> reservations = new ArrayList<>();
        reservations.add(r);
        reservations.add(r2);
        
        List<Car> cars = new ArrayList<>();
        cars.add(testCar);
        cars.add(car1);
        cars.add(car2);
        
        List<Car> availableCars = new ArrayList<>();
        availableCars.add(car1);
        availableCars.add(car2);
        
        when(carDao.findAll()).thenReturn(cars);
        when(reservationDao.findAll()).thenReturn(reservations);
        
        List<Car> f = carService.getAvailable();
        Assert.assertEquals(f, availableCars);
    }
    
}
