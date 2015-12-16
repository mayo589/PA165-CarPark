package com.fi.muni.sampledata;

import com.fi.muni.carparkapp.entity.Car;
import com.fi.muni.carparkapp.entity.Employee;
import com.fi.muni.carparkapp.entity.Office;
import com.fi.muni.carparkapp.entity.Reservation;
import com.fi.muni.carparkapp.service.EmployeeService;
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
    
    public void loadData() {
        Employee karel = employee("Martin", "Karel", "Adresa", "123456789", getDate(2000, 2, 1), "heslo");
        Employee jan = employee("Martin", "Jan", "Adresa2", "223456789", getDate(2000, 3, 1), "heslo");
        Employee josef = employee("Martin", "Josef", "Adresa3", "323456789", getDate(2000, 4, 1), "heslo");
        
        Car car1 = car("blue", 50, "BMW", "1C10000", "46546ASD");
        Office office1 = office("Brno, Hrnčířská 15", "Brno - Královo pole");
        
        Reservation res1 = reservation(false, getDate(2012, 2, 1), getDate(2012, 3, 1), car1, office1 , karel);
    }
    
    private Employee employee(String lastName, String firstName, String address,
            String telephone, Date date, String password) {
        Employee e = new Employee();
        e.setLastName(lastName);
        e.setFirstName(firstName);
        e.setAddress(address);
        e.setTelephone(telephone);
        e.setDateOfBirth(date);
        employeeService.addEmployee(e, password);
        return e;
    }
    
    private Reservation reservation(boolean cancelled, Date fromDate, Date toDate, Car car, Office office, Employee employee) {
        Reservation r = new Reservation();
        r.setCancelled(cancelled);
        r.setFromDate(fromDate);
        r.setToDate(toDate);
        r.setCar(car);
        r.setOffice(office);
        r.setEmployee(employee);
        return r;
    }
    
    private Car car(String color, int fuelCapacity, String model, String plateNumber, String vin) {
        Car c = new Car();
        c.setColor(color);
        c.setFuelCapacity(fuelCapacity);
        c.setModel(model);
        c.setPlateNumber(plateNumber);
        c.setVin(vin);
        return c;
    }
    
    private Office office(String address, String name) {
        Office o = new Office();
        o.setAddress(address);
        o.setName(name);
        return o;
    }
    
    private Date getDate(int year, int month, int day) {
        return Date.from(LocalDate.of(year, month, day).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    
}
