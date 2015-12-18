package com.fi.muni.carparkweb.controllers;

import com.fi.muni.carparkapp.dto.CarDTO;
import com.fi.muni.carparkapp.facade.CarFacade;
import com.fi.muni.carparkapp.service.config.ServiceConfiguration;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author Marek Mihalech 410083
 */
@Controller
@Import({ServiceConfiguration.class})
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarFacade carFacade;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newBook(Model model) {
        model.addAttribute("carCreate", new CarDTO());
        return "car/new";
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateCar(@PathVariable long id, Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        try {
            model.addAttribute("carUpdate", carFacade.getCarById(id));
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert_danger", "Car " + id + " was not found.");
            return "redirect:" + uriBuilder.path("/car/list").build().toUriString();
        }
        return "car/update";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("carCreate") CarDTO formBean, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        if (bindingResult.hasErrors()) {
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
            }
            return "car/new";
        }
        carFacade.addCar(formBean);
        redirectAttributes.addFlashAttribute("alert_info", "Car was created");
        return "redirect:" + uriBuilder.path("/car/list").build().toUriString();
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("carUpdate") CarDTO formBean, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        if (bindingResult.hasErrors()) {
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
            }
            return "car/update/{id}";
        }
        carFacade.updateCar(formBean);
        redirectAttributes.addFlashAttribute("alert_info", "Car was updated");
        return "redirect:" + uriBuilder.path("/car/list").build().toUriString();
    }
    
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable long id, Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        try {
            model.addAttribute("car", carFacade.getCarById(id));
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert_danger", "Car " + id + " was not found.");
            return "redirect:" + uriBuilder.path("/car/list").build().toUriString();
        }
        return "car/detail";
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
         model.addAttribute("cars", carFacade.getAllCars());
        return "car/list";
    }
    
    @RequestMapping(value = "/availableCars", method = RequestMethod.GET)
    public String listAvailable(Model model) {
         model.addAttribute("cars", carFacade.getAllAvailableCars());
        return "car/availableCars";
    }
    
    @RequestMapping(value = "/availabilityOfCar/{id}", method = RequestMethod.POST)
    public String availabilityOfCar(@PathVariable("id") long id, UriComponentsBuilder uriBuilder, RedirectAttributes redirectAttributes) {
        CarDTO car = carFacade.getCarById(id);
        boolean available = false;
        List<CarDTO> availableCars = carFacade.getAllAvailableCars();
        for(CarDTO c : availableCars){
            if(c.getId() == id){
                available = true;
                break;
            }
        }
        return "redirect:" + uriBuilder.path("/car/list").queryParam("available",available).build().toUriString();
    }
}