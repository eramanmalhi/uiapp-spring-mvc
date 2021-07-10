package org.aman.uiapp.controllers;

import java.util.Map;

import org.aman.uiapp.services.AdditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/portal/web-ui")
public class GreetController {

	@Autowired
	AdditionService addService;
	
	@GetMapping("/index")
	public String getFirstPage(Model model)
	{
		model.addAttribute("banner", "Hello, Welcome to Home Page...");
		return "index";
	}
	@PostMapping("/addition")
	public String loadAddition(Model model)
	{
		model.addAttribute("banner", "Kindly provide the numbers and Submit...");
		return "addition";
	}
	@PostMapping("/additionResult")
	public String performAddition(@RequestParam Map<String,String> requestParams, Model model)
	{
		
		Integer num1=Integer.parseInt(requestParams.get("num1"));
		Integer num2=Integer.parseInt(requestParams.get("num2"));
		Integer sum=addService.performAddition(num1,num2);
		model.addAttribute("banner", "Sum of "+num1+" and "+num2+" is given below:");
		model.addAttribute("sum",sum);
		return "additionResult";
	}
	
}
