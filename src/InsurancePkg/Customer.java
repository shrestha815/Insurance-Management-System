package InsurancePkg;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
	
	private List<String> appliedPolicyIds;
	
	public Customer(String id, String name, String email, String password) {
		super(id, name, email, password);
		this.appliedPolicyIds = new ArrayList<>();
	}
	
	public void applyForPolicy(String policyNumber) {
		if(!appliedPolicyIds.contains(policyNumber)) {
			appliedPolicyIds.add(policyNumber);
			System.out.println("Successfully Applied for policy: " + policyNumber);
		} else {
			System.out.println("You have already applied for this policy!!");
		}
	}
	
	//list applied policies
	public void listAppliedPolicies() {
		if(appliedPolicyIds.isEmpty()) {
			System.out.println("You have not applied to any policies yet.");
		} else {
			System.out.println("Applied Policies: ");
			for(String policyId : appliedPolicyIds) {
				System.out.println("- " + policyId);
			}
		}
	}
	
	public List<String> getAppliedPolicyIds() {
		return appliedPolicyIds;
	}

	public void setAppliedPolicyIds(List<String> appliedPolicyIds) {
		this.appliedPolicyIds = appliedPolicyIds;
	}

	@Override
	public String getRole() {
		return "Customer";
	}

}
