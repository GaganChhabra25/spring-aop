package repository;


import org.springframework.stereotype.Repository;

import model.Customer;

@Repository
public class CustomerRepository {

	public Customer findAll() {
		Customer customer = new Customer(1, "Ankit");
		return customer;
	}
}
