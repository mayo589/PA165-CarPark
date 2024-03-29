package com.fi.muni.carparkweb.controllers;

import com.fi.muni.carparkapp.dto.CarDTO;
import com.fi.muni.carparkapp.facade.CarFacade;
import com.fi.muni.carparkapp.service.config.ServiceConfiguration;
import java.util.List;
import java.util.Objects;
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
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable long id, @ModelAttribute("carUpdate") CarDTO formBean, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        if (bindingResult.hasErrors()) {
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
            }
            return "redirect:" + uriBuilder.path("/car/update/{id}").build().toUriString(); 
        };
        formBean.setId(id);
        carFacade.updateCar(formBean);
        redirectAttributes.addFlashAttribute("alert_info", "Car was updated "+formBean.getId()+formBean.getVin()+id);
        return "redirect:" + uriBuilder.path("/car/list").build().toUriString();
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateCar(@PathVariable long id, Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        try {
            CarDTO c = carFacade.getCarById(id);
            c.setId(id);
            model.addAttribute("carUpdate", c);
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert_danger", "Car " + id + " was not found.");
            return "redirect:" + uriBuilder.path("/car/list").build().toUriString();
        }
        return "car/update";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("carCreate") CarDTO formBean, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder)   {
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
        List<CarDTO> cars = carFacade.getAllCars();
        for(CarDTO c : cars){
            c.setIsAvailable(carFacade.isAvailable(c));
        }
        model.addAttribute("cars", cars);
        return "car/list";
    }
}