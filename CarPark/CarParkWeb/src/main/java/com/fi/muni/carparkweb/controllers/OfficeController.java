/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fi.muni.carparkweb.controllers;

import com.fi.muni.carparkapp.facade.EmployeeFacade;
import com.fi.muni.carparkapp.facade.OfficeFacade;
import com.fi.muni.carparkapp.facade.ReservationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
