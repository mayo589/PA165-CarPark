package com.fi.muni.sampledata;

import com.fi.muni.carparkapp.entity.Car;
import com.fi.muni.carparkapp.entity.Employee;
import com.fi.muni.carparkapp.entity.Office;
import com.fi.muni.carparkapp.entity.Reservation;
import com.fi.muni.carparkapp.service.EmployeeService;
import com.fi.muni.carparkapp.service.CarService;
import com.fi.muni.carparkapp.service.ReservationService;
import com.fi.muni.carparkapp.service.OfficeService;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jan Hellar
 */
@Component
@Transactional
public class SampleDataLoadingFacade {
    
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private CarService carService;
    
    @Autowired
    private ReservationService reservationService;
    
    @Autowired
    private OfficeService officeService;
    
    public void loadData() {
        Employee karel = employee("Martin", "Karel", "Adresa", "123456789", getDate(2000, 2, 1), "heslo", true);
        Employee jan = employee("Martin2", "Jan", "Adresa2", "223456789", getDate(2000, 3, 1), "heslo", false);
        Employee josef = employee("Martin3", "Josef", "Adresa3", "323456789", getDate(2000, 4, 1), "heslo", false);
        
        Car car1 = car("blue", 50, "BMW", "1C10000", "46546ASD");
        Car mazda6 = car("Red", 120, "Mazda 6", "AC-157", "XCR-DFWRTJJH446ASF");
        Car mazda3 = car("Black", 89, "Mazda 3", "BC-784", "XCR-DDFGFJH446ASF");
        Car mazdaCX5 = car("White", 99, "Mazda CX5", "CC-155", "XCR-DFWRPOIH46ASF");
        
        Reservation res1 = reservation(false, getDate(2012, 2, 1), getDate(2012, 3, 1), car1, null , karel);
        Reservation res2 = reservation(false, getDate(2012, 2, 2), getDate(2012, 3, 1), mazda6, null , jan);
        
        Office office1 = office("Brno, Hrnčířská 15", "Brno - Královo pole", res1);
    }
    
    private Employee employee(String lastName, String firstName, String address,
            String telephone, Date date, String password, boolean admin) {
        Employee e = new Employee();
        e.setLastName(lastName);
        e.setFirstName(firstName);
        e.setAddress(address);
        e.setTelephone(telephone);
        e.setDateOfBirth(date);
        e.setAdmin(admin);
        employeeService.addEmployee(e, password);
        return e;
    }
    
    private Reservation reservation(boolean cancelled, Date fromDate, Date toDate, Car car, Office office, Employee employee) {
        Reservation r = new Reservation();
        r.setCancelled(cancelled);
        r.setFromDate(fromDate);
        r.setToDate(toDate);
        r.setCar(car);
        //r.setOffice(office);
        r.setEmployee(employee);
        reservationService.addReservation(r);
        return r;
    }
    
    private Car car(String color, int fuelCapacity, String model, String plateNumber, String vin) {
        Car c = new Car();
        c.setColor(color);
        c.setFuelCapacity(fuelCapacity);
        c.setModel(model);
        c.setPlateNumber(plateNumber);
        c.setVin(vin);
        carService.create(c);
        return c;
    }
    
    private Office office(String address, String name, Reservation reservation) {
        Office o = new Office();
        o.setAddress(address);
        o.setName(name);
        o.addReservation(reservation);
        officeService.AddOffice(o);
        return o;
    }
    
    private Date getDate(int year, int month, int day) {
        return Date.from(LocalDate.of(year, month, day).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    
}
