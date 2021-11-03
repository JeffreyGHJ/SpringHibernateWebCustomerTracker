package com.jeffreyghj.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.jeffreyghj.springdemo.dao.CustomerDAO;
//import com.jeffreyghj.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	/*
	@Autowired
	private CustomerDAO customerDAO; //will scan for a component that implements the CustomerDAO which will be CustomerDAOImpl
	*/
	//@GetMapping("/list")
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		/*
		//get customers from dao
		List<Customer> theCustomers = customerDAO.getCustomers(); 
		
		//add customers to spring MVC model
		theModel.addAttribute("customers", theCustomers);
		*/
		return "list-customers";
	}
}
