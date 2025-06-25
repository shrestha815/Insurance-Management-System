package services;

import InsurancePkg.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {
	private List<Customer> customerList;
	
	public CustomerService() {
		this.customerList = new ArrayList<>();
	}
	
	//scanner is passed through main cli navigation interface
	public void registerCustomer(Scanner scanner) {
		System.out.println("Register New Customer");
		
		System.out.println("Enter a name");
		String name = scanner.nextLine();
		
		System.out.println("Enter email: ");
		String email = scanner.nextLine();
		
		if(getCustomerByEmail(email) != null) {
			System.out.println("Customer With this email already exists!!!");
			return;
		}
		
		System.out.println("Enter a password");
		String password = scanner.nextLine();
		
		String id = "CUST" + (customerList.size() +1);
		Customer customer = new Customer(id, name, email, password);
		
		customerList.add(customer);
		System.out.println("Successfully Registered.  Your Id is " + id);
	}

	public Customer getCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		for (Customer c : customerList) {
			if(c.getEmail().equalsIgnoreCase(email)) {
				return c;
			}
		}
		return null;
	}
	
	//login
	public Customer loginCustomer(Scanner scanner) {
		System.out.println("=============Customer login==========");
		
		System.out.println("Enter email");
		String email = scanner.nextLine();
		
		System.out.println("Enter password");
		String password = scanner.nextLine();
		
		for(Customer c : customerList) {
			if(c.getEmail().equalsIgnoreCase(email) && c.getPassword().equals(password)) {
				System.out.println("Login Successful. Welcome " + c.getName() + "!");
				return c;
			}
		}
		
		System.out.println("Incorrect email or Password.");
		return null;
	}
	
	public void addCustomer(Customer customer) {
		customerList.add(customer);
	}
	
	public void listAllCustomers () {
		if(customerList.isEmpty()) {
			System.out.println("There are no registered customers yet.");
			return;
		}
		
		for(Customer c : customerList) {
			System.out.println("\n-----------");
			System.out.println(c);
		}
	}
	
	

}
