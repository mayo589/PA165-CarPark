/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fi.muni.carparkweb.controllers;

import com.fi.muni.carparkapp.dto.CarDTO;
import com.fi.muni.carparkapp.dto.OfficeDTO;
import com.fi.muni.carparkapp.facade.EmployeeFacade;
import com.fi.muni.carparkapp.facade.OfficeFacade;
import com.fi.muni.carparkapp.facade.ReservationFacade;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Jan Starka
 */

@Controller
@RequestMapping("/office")
public class OfficeController {
    
    @Autowired
    private OfficeFacade officeFacade;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("offices", officeFacade.getAllOffices());
        return "office/list";
    }
    
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable long id, Model model,
            RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        try {
            model.addAttribute("office", officeFacade.findOfficeById(id));
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert_danger", "Office " + id + " was not found.");
            return "redirect:" + uriBuilder.path("/office/list").build().toUriString();
        }
        return "office/detail";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newOffice(Model model) {
        model.addAttribute("officeCreate", new OfficeDTO());
        return "office/new";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createOffice(@Valid @ModelAttribute("officeCreate") OfficeDTO formBean,
            BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes,
            UriComponentsBuilder uriBuilder) {
        if (bindingResult.hasErrors()) {
            return "office/new";
        }
        officeFacade.AddOffice(formBean);
        return "redirect:" + uriBuilder.path("/office/list").build().toUriString();
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable long id, @ModelAttribute("officeUpdate") OfficeDTO formBean, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        if (bindingResult.hasErrors()) {
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
            }
            return "redirect:" + uriBuilder.path("/office/update/{id}").build().toUriString(); 
        };
        formBean.setId(id);
        officeFacade.updateOffice(formBean);
        redirectAttributes.addFlashAttribute("alert_info", "Office was updated "+formBean.getId()+id);
        return "redirect:" + uriBuilder.path("/office/list").build().toUriString();
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable long id, Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        try {
            OfficeDTO c = officeFacade.findOfficeById(id);
            c.setId(id);
            model.addAttribute("officeUpdate", c);
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert_danger", "Office " + id + " was not found.");
            return "redirect:" + uriBuilder.path("/office/list").build().toUriString();
        }
        return "office/update";
    }
}
