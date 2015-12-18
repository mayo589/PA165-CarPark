package com.fi.muni.carparkweb.controllers;

import com.fi.muni.carparkapp.dto.CarDTO;
import com.fi.muni.carparkapp.dto.EmployeeDTO;
import com.fi.muni.carparkapp.facade.EmployeeFacade;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

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
        model.addAttribute("employees", employeeFacade.getAllEmployees());
        return "employee/list";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newEmployee(Model model) {
        model.addAttribute("employeeCreate", new EmployeeDTO());
        return "employee/new";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createEmployee(@Valid @ModelAttribute("employeeCreate") EmployeeDTO formBean,
            BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes,
            UriComponentsBuilder uriBuilder) {
        if (bindingResult.hasErrors()) {
            return "employee/new";
        }
        employeeFacade.addEmployee(formBean, formBean.getPasswordHash());
        return "redirect:" + uriBuilder.path("/employee/list").build().toUriString();
    }
    
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable long id, Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        try {
            model.addAttribute("employee", employeeFacade.findEmployeeById(id));
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert_danger", "Employee " + id + " was not found.");
            return "redirect:" + uriBuilder.path("/employee/list").build().toUriString();
        }
        return "employee/detail";
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable long id, @ModelAttribute("employeeUpdate") EmployeeDTO formBean, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        if (bindingResult.hasErrors()) {
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
            }
            return "redirect:" + uriBuilder.path("/employee/update/{id}").build().toUriString(); 
        };
        formBean.setId(id);
        employeeFacade.updateEmployee(formBean);
        redirectAttributes.addFlashAttribute("alert_info", "Employee was updated "+formBean.getId()+formBean.getFirstName() + " " + formBean.getLastName()+ " " +id);
        return "redirect:" + uriBuilder.path("/employee/list").build().toUriString();
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable long id, Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        try {
            EmployeeDTO c = employeeFacade.findEmployeeById(id);
            c.setId(id);
            model.addAttribute("employeeUpdate", c);
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert_danger", "Employee " + id + " was not found.");
            return "redirect:" + uriBuilder.path("/employee/list").build().toUriString();
        }
        return "employee/update";
    }
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
