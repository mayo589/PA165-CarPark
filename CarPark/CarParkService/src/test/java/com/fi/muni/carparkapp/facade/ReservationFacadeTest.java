package com.fi.muni.carparkapp.facade;

import com.fi.muni.carparkapp.dto.CarDTO;
import com.fi.muni.carparkapp.dto.EmployeeDTO;
import com.fi.muni.carparkapp.dto.OfficeDTO;
import com.fi.muni.carparkapp.dto.ReservationDTO;
import com.fi.muni.carparkapp.entity.Car;
import com.fi.muni.carparkapp.entity.Employee;
import com.fi.muni.carparkapp.entity.Office;
import com.fi.muni.carparkapp.entity.Reservation;
import com.fi.muni.carparkapp.service.ReservationService;
import com.fi.muni.carparkapp.service.config.ServiceConfiguration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Jan Hellar
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class ReservationFacadeTest extends AbstractTransactionalTestNGSpringContextTests {
    
    @Mock
    private ReservationService reservationService;
    
    @Autowired
    @InjectMocks
    private ReservationFacade reservationFacade;
    
    private ReservationDTO reservation1;
    private EmployeeDTO employee1;
    private CarDTO car1;
    private OfficeDTO office1;
    private Date date1;
    private Date date2;
    
    @BeforeClass
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @BeforeMethod
    public void setupMethod() {
        Calendar calendar1 = Calendar.getInstance(); 
        calendar1.setTime(new Date()); 
        calendar1.add(Calendar.DATE, -1);
        Calendar calendar2 = Calendar.getInstance(); 
        calendar2.setTime(new Date()); 
        calendar2.add(Calendar.DATE, 1);
        date1 = calendar1.getTime();
        date2 = calendar2.getTime();
        
        employee1 = new EmployeeDTO();
        employee1.setAddress("address1");
        employee1.setDateOfBirth(date1);
        employee1.setFirstName("Name");
        employee1.setLastName("Last");
        employee1.setTelephone("123");

        car1 = new CarDTO();
        car1.setColor("brown");
        car1.setFuelCapacity(2);
        car1.setModel("model");
        car1.setPlateNumber("123");
        car1.setVin("123");
        
        office1 = new OfficeDTO();
        office1.setAddress("address");
        office1.setName("name");
        
        reservation1 = new ReservationDTO();
        reservation1.setCar(car1);
        reservation1.setEmployee(employee1);
        reservation1.setFromDate(date1);
        reservation1.setToDate(date2);
        reservation1.setOffice(office1);
    }
    
    @Test
    public void getAllReservationsTest() {
        Reservation reservation = new Reservation(1L);
        ReservationDTO reserDto = new ReservationDTO();
        reserDto.setId(1L);
        
        reservationFacade.addReservation(reservation1);
        
        //when(reservationService.getReservationById(1L)).thenReturn(reservation);
        
        Assert.assertEquals(reservationFacade.getAllReservations().size(), 1);
    }
    
    @Test
    public void getReservationByIdTest() {
        Reservation reservation = new Reservation(1L);
        ReservationDTO reserDto = new ReservationDTO();
        reserDto.setId(1L);
        
        when(reservationService.getReservationById(1L)).thenReturn(reservation);
        
        ReservationDTO r = reservationFacade.getReservationById(1L);
        Assert.assertEquals(r, reserDto);
    }
    
    @Test
    public void addReservationTest() {
        Reservation reservation = new Reservation(1L);
        
        ReservationDTO reserDto = new ReservationDTO();
        reserDto.setId(1L);
        
        reservationFacade.addReservation(reserDto);
        
        when(reservationService.getReservationById(1L)).thenReturn(reservation);
        
        ReservationDTO r = reservationFacade.getReservationById(1L);
        Assert.assertEquals(r, reserDto);
        verify(reservationService).addReservation(reservation);
    }
    
    @Test
    public void cancelReservationTest() {
        Reservation reservation = new Reservation(1L);
        ReservationDTO reserDto = new ReservationDTO();
        reserDto.setId(1L);
        
        when(reservationService.getReservationById(1L)).thenReturn(reservation);
        reservationFacade.cancelReservation(reserDto);
        verify(reservationService).cancelReservation(reservation);
    }
    
    @Test
    public void getAllReservationsForEmployeeTest() {
        Employee e = new Employee(1L);
        EmployeeDTO ed = new EmployeeDTO();
        ed.setId(1L);
        
        Reservation reservation = new Reservation(1L);
        ReservationDTO reserDto = new ReservationDTO();
        reserDto.setId(1L);
        
        List<Reservation> lr = new ArrayList<>();
        lr.add(reservation);
        
        List<ReservationDTO> lrd = new ArrayList<>();
        lrd.add(reserDto);
        
        when(reservationService.getAllReservationsForEmloyee(e)).thenReturn(lr);
        
        Collection<ReservationDTO> rf = reservationFacade.getAllReservationsForEmployee(ed);
        Assert.assertEquals(rf.size(), lrd.size());
    }
    
    @Test
    public void getAllReservationsForOfficeTest() {
        Office o = new Office(1L);
        OfficeDTO od = new OfficeDTO();
        od.setId(1L);
        
        Reservation reservation = new Reservation(1L);
        ReservationDTO reserDto = new ReservationDTO();
        reserDto.setId(1L);
        
        List<Reservation> lr = new ArrayList<>();
        lr.add(reservation);
        
        List<ReservationDTO> lrd = new ArrayList<>();
        lrd.add(reserDto);
        
        when(reservationService.getAllReservationsForOffice(o)).thenReturn(lr);
        
        Collection<ReservationDTO> rf = reservationFacade.getAllReservationsForOffice(od);
        Assert.assertEquals(rf.size(), lrd.size());
    }
    
    @Test
    public void getAllReservationsForCarTest() {
        Car c = new Car(1L);
        CarDTO cd = new CarDTO();
        cd.setId(1L);
        
        Reservation reservation = new Reservation(1L);
        ReservationDTO reserDto = new ReservationDTO();
        reserDto.setId(1L);
        
        List<Reservation> lr = new ArrayList<>();
        lr.add(reservation);
        
        List<ReservationDTO> lrd = new ArrayList<>();
        lrd.add(reserDto);
        
        when(reservationService.getAllReservationsForCar(c)).thenReturn(lr);
        
        Collection<ReservationDTO> rf = reservationFacade.getAllReservationsForCar(cd);
        Assert.assertEquals(rf.size(), lrd.size());
    }
    
    @Test
    public void getReservationsForDateRangeTest() {
        Reservation reservation = new Reservation(1L);
        ReservationDTO reserDto = new ReservationDTO();
        reserDto.setId(1L);
        
        List<Reservation> lr = new ArrayList<>();
        lr.add(reservation);
        
        List<ReservationDTO> lrd = new ArrayList<>();
        lrd.add(reserDto);
        
        when(reservationService.getAllReservationsForDateRange(date1, date2)).thenReturn(lr);
        
        Collection<ReservationDTO> rf = reservationFacade.getReservationsForDateRange(date1, date2);
        Assert.assertEquals(rf.size(), lrd.size());
    }
    
}
