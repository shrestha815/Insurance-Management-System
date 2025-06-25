package services;

import InsurancePkg.Admin;
import InsurancePkg.Policy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminService {
	
	private List<Admin> adminList;
	private PolicyService policyService;
	
	public AdminService(PolicyService policyService) {
		this.adminList = new ArrayList<>();
		this.policyService = policyService;
		
		//adding a default Admin for initial access
		adminList.add(new Admin("ROOT","System Admin", "admin@example.com", "admin123"));
	}
	
	
	public Admin loginAdmin(Scanner scanner) {
		System.out.println("Administrator Login");
		
		System.out.println("Enter Email: ");
		String email = scanner.nextLine();
		
		System.out.println("Enter password");
		String password = scanner.nextLine();
		
		for(Admin a : adminList) {
			if(a.getEmail().equalsIgnoreCase(email) && a.getPassword().equals(password)) {
				System.out.println("Login Successful. Welcome back " + a.getName());
				return a;
			}
		}
		
		System.out.println("Invalid Credentials");
		return null;
	}
	
	public void registerAdmin(Admin admin) {
		adminList.add(admin);
	}
	
	public void createPolicy(Scanner scanner, Admin admin) {
		System.out.println("Create new Policy");
		
		System.out.println("Policy Number: ");
		String policyNumber = scanner.nextLine();
		
		System.out.println("Name");
		String name = scanner.nextLine();
		
		System.out.println("Category (e.g., Health, Auto): ");
		String category = scanner.nextLine();
		
		System.out.println("Description: ");
		String description = scanner.nextLine();
		
		System.out.println("Premium Amount");
		Double premium = Double.parseDouble(scanner.nextLine());
		
		System.out.print("Coverage Amount: ");
        double coverage = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Term (years): ");
        int term = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Eligibility Criteria: ");
        String eligibility = scanner.nextLine();
        
        Policy policy = new Policy(policyNumber, name, category, description, premium, coverage, term, true, eligibility, admin.getId());
        policyService.addPolicy(policy);
	}
	
	public void deactivatePolicy(Scanner scanner) {
		System.out.println("Enter policy number to deactivate");
		String policyNumber = scanner.nextLine();
		
		boolean result = policyService.deactivatePolicy(policyNumber);
		if(result) {
			System.out.println("Policy Deactivated");
		} else {
			System.out.println("Policy not found");
		}
	}
	
	public void listAllPolicies() {
		policyService.listAllPolicies();
	}
	
}
