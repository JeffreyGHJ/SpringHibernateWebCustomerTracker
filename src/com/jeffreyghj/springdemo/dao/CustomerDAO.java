package com.jeffreyghj.springdemo.dao;

import java.util.List;

import com.jeffreyghj.springdemo.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();
}
