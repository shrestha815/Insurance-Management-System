package menus;

import java.util.Scanner;

import InsurancePkg.Admin;
import services.AdminService;

public class AdminPortal {
	private AdminService adminService;
	
	public AdminPortal(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public void showAdminMenu(Scanner scanner, Admin admin) {
		boolean adminRunning = true;
		while(adminRunning) {
			System.out.println("=========================================");
			System.out.println("\n--- Admin Menu ---");
			System.out.println("1. Create New Policy");
			System.out.println("2. List All Policies");
			System.out.println("3. Deactivate a Policy");
			System.out.println("4. Logout");
			System.out.println("Choose an Option");
			
			String choice = scanner.nextLine();
			
			switch(choice) {
			
			case "1":
				adminService.createPolicy(scanner, admin);
				break;
				
			case "2":
				adminService.listAllPolicies();
				break;
				
			case "3":
				adminService.deactivatePolicy(scanner);
				break;
				
			case "4":
				adminRunning = false;
				break;
				
			default:
				System.out.println("Invalid Option. Select options from 1-4");
			}
			
			
		}
	}

}
