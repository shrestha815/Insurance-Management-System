package InsurancePkg;

import InsurancePkg.Admin;
import InsurancePkg.Customer;
import menus.AdminPortal;
import menus.CustomerPortal;
import services.AdminService;
import services.CustomerService;
import services.PolicyService;

import java.util.Scanner;

public class InsuranceApp {
	
	private PolicyService policyService;
    private AdminService adminService;
    private CustomerService customerService;
    private AdminPortal adminPortal;
    private CustomerPortal customerPortal;
    
    public InsuranceApp() {
    	policyService = new PolicyService();
        adminService = new AdminService(policyService);
        customerService = new CustomerService();
        adminPortal = new AdminPortal(adminService);
        customerPortal = new CustomerPortal(policyService);
    }
    
    public void start() {
    	Scanner scanner = new Scanner(System.in);
    	boolean running = true;
    	
    	while(running) {
    		System.out.println("\n--- Insurance Management System ---");
    		System.out.println("1. Admin Login");
            System.out.println("2. Customer Login");
            System.out.println("3. Register as Customer");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            String choice = scanner.nextLine();
            
            switch(choice) {
            
            case "1":
            	Admin admin = adminService.loginAdmin(scanner);
            	if(admin != null) {
            		adminPortal.showAdminMenu(scanner, admin);
            	}
            	break;
            	
            case "2":
            	Customer customer = customerService.loginCustomer(scanner);
            	if(customer != null) {
            		customerPortal.showCustomerMenu(scanner, customer);
            	}
            	break;
            	
            case "3":
            	customerService.registerCustomer(scanner);
            	break;
            	
            case "4":
            	running = false;
            	System.out.println("Exiting system. Goodbye!");
            	break;
            	
           default:
        	   System.out.println("Invalid option. Please try again.");
            }
    	}
    	scanner.close();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsuranceApp cli = new InsuranceApp();
		cli.start();
	}

}
