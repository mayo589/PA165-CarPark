/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fi.muni.carparkweb.controllers;

import com.fi.muni.carparkapp.dto.EmployeeDTO;
import com.fi.muni.carparkapp.dto.ReservationDTO;
import com.fi.muni.carparkapp.facade.EmployeeFacade;
import com.fi.muni.carparkapp.facade.ReservationFacade;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import com.fi.muni.carparkapp.dto.CarDTO;
import com.fi.muni.carparkapp.dto.EmployeeDTO;
import com.fi.muni.carparkapp.dto.OfficeDTO;
import com.fi.muni.carparkapp.dto.ReservationDTO;
import com.fi.muni.carparkapp.entity.Car;
import com.fi.muni.carparkapp.facade.CarFacade;
import com.fi.muni.carparkapp.facade.EmployeeFacade;
import com.fi.muni.carparkapp.facade.OfficeFacade;
import com.fi.muni.carparkapp.facade.ReservationFacade;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Jan Starka
 */

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    
    @Autowired
    private ReservationFacade reservationFacade;
    
     @Autowired
    private EmployeeFacade employeeFacade; 
     
     @Autowired
    private CarFacade carFacade;
    
    @Autowired
    private OfficeFacade officeFacade;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        if (hasRole("ROLE_ADMIN")) {
            model.addAttribute("reservations", reservationFacade.getAllReservations());
        } else {
            EmployeeDTO employee = employeeFacade.findEmployeeByName(getPrincipal());
            model.addAttribute("reservations", reservationFacade.getAllReservationsForEmployee(employee));
        }
        return "reservation/list";
    }
    
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable long id, Model model,
            RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        try {
            model.addAttribute("reservation", reservationFacade.getReservationById(id));
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert_danger", "Reservation " + id + " was not found.");
            return "redirect:" + uriBuilder.path("/reservation/list").build().toUriString();
        }
        return "reservation/detail";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newOffice(Model model) {
        model.addAttribute("reservationCreate", new ReservationDTO());
        return "reservation/new";
    }
    
    @ModelAttribute("availableCars")
    public List<CarDTO> carsList(){
        return carFacade.getAllAvailableCars();
    }
   
    @ModelAttribute("offices")
    public List<OfficeDTO> officesList(){
        return (List)officeFacade.getAllOffices();
    }
    
    
    @ModelAttribute("employees")
    public List<EmployeeDTO> employeesList(){
        return (List)employeeFacade.getAllEmployees();
    }
  
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createOffice(@Valid @ModelAttribute("reservationCreate") ReservationDTO formBean,
             @ModelAttribute("carid") Long carid,
             @ModelAttribute("employeeid") Long employeeid,
             @ModelAttribute("officeid") Long officeid,
            BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes,
            UriComponentsBuilder uriBuilder) {
        if (bindingResult.hasErrors()) {
            return "reservation/new";
        }
        CarDTO c = carFacade.getCarById(carid);
        c.setId(carid);
        OfficeDTO o = officeFacade.findOfficeById(officeid);
        o.setId(officeid);
        EmployeeDTO e = employeeFacade.findEmployeeById(employeeid);
        e.setId(employeeid);
        
        formBean.setCar(c);
        formBean.setOffice(o);
        formBean.setEmployee(e);
        reservationFacade.addReservation(formBean);
        return "redirect:" + uriBuilder.path("/reservation/list").build().toUriString();
    }
    
    @RequestMapping(value = "/cancel/{id}", method = RequestMethod.POST)
    public String cancel(@PathVariable("id") long id, UriComponentsBuilder uriBuilder) {
        ReservationDTO reservation = reservationFacade.getReservationById(id);
        reservationFacade.cancelReservation(reservation);
        return "redirect:" + uriBuilder.path("/reservation/list").build().toUriString();
    }
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
    
    private boolean hasRole(String role) {
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        boolean hasRole = false;
        for (GrantedAuthority authority : authorities) {
            hasRole = authority.getAuthority().equals(role);
            if (hasRole) {
                break;
            }
        }
        return hasRole;
    }
    
    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = "";//principal.toString();
        }
        return userName;
    }
    
}