package com.jeffreyghj.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeffreyghj.springdemo.dao.CustomerDAO;
import com.jeffreyghj.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//inject customerDAO
	@Autowired
	private CustomerDAO customerDAO; //will receive customerDAOImpl because that is a class that implements CustomerDAO
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

}
