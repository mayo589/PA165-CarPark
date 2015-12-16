package com.fi.muni.sampledata;

import com.fi.muni.carparkapp.entity.Employee;
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
    
    private Date getDate(int year, int month, int day) {
        return Date.from(LocalDate.of(year, month, day).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    
}
