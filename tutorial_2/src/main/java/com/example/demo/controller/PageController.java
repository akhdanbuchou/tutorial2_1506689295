package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController 
{
	@RequestMapping("/hello")
	public String hello()
	{
		return "hello";	
	}
	
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "dunia") String name, Model model)
	{
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@RequestMapping(value = {"/greetingPath", "greetingPath/{name}"})
	public String greetingPath(@PathVariable Optional<String> name, Model model)
	{
		if(name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "dengklek");
		}
		return "greeting";
	}
	
	@RequestMapping("/perkalian")
	public String perkalian(@RequestParam(value = "a", defaultValue = "0") int angka1, 
							@RequestParam(value = "b", defaultValue = "0") int angka2, 
							Model model)
	{
		int hasil = angka1 * angka2;
		model.addAttribute("a", angka1);
		model.addAttribute("b", angka2);
		model.addAttribute("hasil", hasil);
		
		return "perkalian";
	}
	
}


