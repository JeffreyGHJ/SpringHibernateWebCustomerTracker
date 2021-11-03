package com.jeffreyghj.springdemo.service;

import java.util.List;

import com.jeffreyghj.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	public void saveCustomer(Customer theCustomer);
}
