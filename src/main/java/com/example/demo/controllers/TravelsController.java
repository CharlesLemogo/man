package com.example.demo.controllers;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.Travel;
import com.example.demo.services.TravelService;

@Controller
public class TravelsController {
	@Autowired
	TravelService travelService;
	
	@GetMapping("/")
	public String home(@ModelAttribute("travel") Travel travel, Model model) {
		List<Travel> travels = travelService.allTravels();
		model.addAttribute("travels", travels);
		return "index.jsp";
	}
	
	@GetMapping("/travels/{travelId}")
	public String index(Model model, @PathVariable("travelId") Long travelId) {
		System.out.println(travelId);
		Travel travel = travelService.findTravel(travelId);
		System.out.println(travel);
		
		
		model.addAttribute("travel", travel);
		
		return "show.jsp";
	}
	@PostMapping("/addTravel")
	public String home(@Valid @ModelAttribute("travel") Travel travel, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Travel> travels = travelService.allTravels();
			model.addAttribute("travels", travels);
			return "index.jsp";
		}
		travelService.addTravel(travel);
		return "redirect:/";
	}
	
	@RequestMapping("/expenses/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Travel travel = travelService.findTravel(id);
        model.addAttribute("travel", travel);
        return "edit.jsp";
    }
    
    @RequestMapping(value="/travels/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("travel") Travel travel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("travel", travel);
            return "edit.jsp";
        } else {
            travelService.updateTravel(travel);
            return "redirect:/";
        }
    }
    
    @DeleteMapping("/travels/{id}")
    public String destroy(@PathVariable("id") Long id) {
        travelService.deleteTravel(id);
        return "redirect:/";
    }
   
}