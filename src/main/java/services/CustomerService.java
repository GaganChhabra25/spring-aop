package services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	final static Logger logger = Logger.getLogger(CustomerService.class);

	public void findCustomer() {
		System.out.println("Customer name = Gagan");
	}

	public void findTotalNumberOfCustomers() {
		System.out.println("Total number of customers ");
	}

	public void findCustomerById() {
		System.out.println("Finding Customer By ID");
	}

	public void findCustomerByName() throws Throwable {
		System.out.println("Finding Customer By Name");
		throw new Throwable("Throwable exception generated manuallyy");
	}

	// It will throw exception
	public void findCustomerByAddress() throws Exception {
		throw new Exception("Exception is thrown manully");
	}

	public Integer findCustomerSalary() {
		return 10000;
	}

	public void customerRetry() throws Throwable {
		logger.info("***** Into Customer service retry method ******");
		throw new Throwable("Throws exception");
	}

}

