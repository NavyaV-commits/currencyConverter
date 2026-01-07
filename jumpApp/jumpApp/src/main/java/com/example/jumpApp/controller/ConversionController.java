package com.example.jumpApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jumpApp.service.ConversionService;

@Controller
public class ConversionController {

	
	@Autowired
	private ConversionService conversionService;
	
	
	@PostMapping("/convert")
	public String convert(@RequestParam Double amount, @RequestParam String currency,
			Model model) {
		Double converted = conversionService.save(amount, currency);
		model.addAttribute("result",converted);
		model.addAttribute("history",conversionService.findAll());
		
		return "index";
	}
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("history", conversionService.findAll());
		return "index";
	}
	
	
}
