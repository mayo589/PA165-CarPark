/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fi.muni.carparkweb.controllers;

import com.fi.muni.carparkapp.dto.ReservationDTO;
import com.fi.muni.carparkapp.facade.ReservationFacade;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/reservation")
public class ReservationController {
    
    @Autowired
    private ReservationFacade reservationFacade;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("reservations", reservationFacade.getAllReservations());
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
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createOffice(@Valid @ModelAttribute("reservationCreate") ReservationDTO formBean,
            BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes,
            UriComponentsBuilder uriBuilder) {
        if (bindingResult.hasErrors()) {
            return "reservation/new";
        }
        reservationFacade.addReservation(formBean);
        return "redirect:" + uriBuilder.path("/reservation/list").build().toUriString();
    }
    
}
