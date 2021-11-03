package com.jeffreyghj.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeffreyghj.springdemo.entity.Customer;
import com.jeffreyghj.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService; //will receive CustomerServiceImpl.java as object (not CustomerService.java; that's an interface)
	

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		
		//get customers from dao
		List<Customer> theCustomers = customerService.getCustomers(); 
		
		//add customers to spring MVC model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer); //stick theCustomer onto the model under the name "customer"
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//save theCustomer using our customerService
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
}
