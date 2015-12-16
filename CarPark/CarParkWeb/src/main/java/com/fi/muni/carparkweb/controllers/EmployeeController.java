package com.fi.muni.carparkweb.controllers;

import com.fi.muni.carparkapp.dto.EmployeeDTO;
import com.fi.muni.carparkapp.facade.EmployeeFacade;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jan Hellar
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeFacade employeeFacade;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        EmployeeDTO e = new EmployeeDTO();
        e.setFirstName("jan");
        e.setLastName("");
        e.setDateOfBirth(Date.from(LocalDate.of(2000, 1, 2).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        employeeFacade.addEmployee(e, "pass");
        model.addAttribute("employees", employeeFacade.getAllEmployees());
        model.addAttribute("employeesSize", employeeFacade.getAllEmployees().size());
        return "employee/list";
    }
    
}
