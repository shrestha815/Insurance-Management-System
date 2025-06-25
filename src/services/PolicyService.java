package services;

import InsurancePkg.Policy;
import java.util.ArrayList;
import java.util.List;

public class PolicyService {
	
	private List<Policy> policyList;
	
	public PolicyService() {
		this.policyList = new ArrayList<>();
	}
	
	public void addPolicy(Policy policy) {
		policyList.add(policy);
		System.out.println("Successfully added policy");
	}
	
	public void listAllPolicies () {
		if(policyList.isEmpty()) {
			System.out.println("No policies available");
			return;
		}
		
		for(Policy policy : policyList) {
			System.out.println("\n-------------------------");
			System.out.println(policy);
		}
	}
	
	//view policy by policy number
	public Policy findPolicyById(String policyNumber) {
		for(Policy policy : policyList) {
			if(policy.getPolicyNumber().equalsIgnoreCase(policyNumber)) {
				return policy;
			}
		}
		return null;
	}
	
	public boolean deactivatePolicy(String policyNumber) {
		Policy policy = findPolicyById(policyNumber);
		if(policy != null) {
			policy.setActive(false);
			return true;
		}
		return false;
	}
	
	//get active policies
	public List<Policy> getActivePolicies(){
		List<Policy> active = new ArrayList<>();
		for (Policy p : policyList) {
			if(p.isActive()) {
				active.add(p);
			}
		}
		return active;
	}
	
	//delete a policy
	public boolean deletePolicy(String policyNumber) {
		Policy policy = findPolicyById(policyNumber);
		if(policy != null) {
			policyList.remove(policy);
			return true;
		}
		return false;
	}
	
}
