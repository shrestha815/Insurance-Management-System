package menus;

import InsurancePkg.Customer;
import InsurancePkg.Policy;
import services.PolicyService;

import java.util.List;
import java.util.Scanner;

public class CustomerPortal {
	private PolicyService policyService;
	
	public CustomerPortal(PolicyService policyService) {
		this.policyService = policyService;
	}
	
	public void showCustomerMenu(Scanner scanner, Customer customer) {
		boolean customerRunning = true;
		
		while(customerRunning) {
			System.out.println("================================================");
			System.out.println("\n--- Customer Menu ---");
			System.out.println("1. View Available Policies");
			System.out.println("2. Apply for a Policy");
			System.out.println("3. View Applied Policies");
			System.out.println("4. Logout");
			System.out.print("Choose an option: ");
			
			String choice = scanner.nextLine();
			
			switch(choice) {
			
			case "1":
				List<Policy> activePolicies = policyService.getActivePolicies();
				if(activePolicies.isEmpty()) {
					System.out.println("No active Policies found");
				} else {
					for(Policy p : activePolicies) {
						System.out.println("\n-------------------------------");
						System.out.println(p);
					}
				}
				break;
				
			case "2":
				System.out.println("Enter Policy Number to apply: ");
				String policyId = scanner.nextLine();
				Policy found = policyService.findPolicyById(policyId);
				
				if(found != null && found.isActive()) {
					customer.applyForPolicy(policyId);
				} else {
					System.out.println("The Policy is not found or is no longer active");
				}
				break;
				
			case "3":
				customer.listAppliedPolicies();
				break;
				
			case "4":
				customerRunning = false;
				break;
				
			default:
				System.out.println("Invalid Option, Please Select from options 1-4");
			}
		}
	}
}
