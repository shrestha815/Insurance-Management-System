package InsurancePkg;

public class Policy {
	
	private String policyNumber;
	private String name;
	private String category;
	private String description;
	private double coverageAmount;
	private double premiumAmount;
	private int termInYears;
	private boolean active;
	private String eligibilityCriteria;
	private String createdByAdminId;
	

	//constructor
	public Policy(String policyNumber, String name, String category, String description, double coverageAmount,
			double premiumAmount, int termInYears, boolean active, String eligibilityCriteria,
			String createdByAdminId) {
		super();
		this.policyNumber = policyNumber;
		this.name = name;
		this.category = category;
		this.description = description;
		this.coverageAmount = coverageAmount;
		this.premiumAmount = premiumAmount;
		this.termInYears = termInYears;
		this.active = active;
		this.eligibilityCriteria = eligibilityCriteria;
		this.createdByAdminId = createdByAdminId;
	}
	
	public String getPolicyNumber() {
		return policyNumber;
	}
	
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getCoverageAmount() {
		return coverageAmount;
	}
	
	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}
	
	public double getPremiumAmount() {
		return premiumAmount;
	}
	
	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	
	public int getTermInYears() {
		return termInYears;
	}
	
	public void setTermInYears(int termInYears) {
		this.termInYears = termInYears;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String getEligibilityCriteria() {
		return eligibilityCriteria;
	}
	
	public void setEligibilityCriteria(String eligibilityCriteria) {
		this.eligibilityCriteria = eligibilityCriteria;
	}
	
	public String getCreatedByAdminId() {
		return createdByAdminId;
	}
	
	public void setCreatedByAdminId(String createdByAdminId) {
		this.createdByAdminId = createdByAdminId;
	}
	
	
	//formatting for human readable print
	@Override
	public String toString() {
		return "Policy Number: " + policyNumber +
	           "\nName: " + name +
	           "\nCategory: " + category +
	           "\nDescription: " + description +
	           "\nPremium: $" + premiumAmount +
	           "\nCoverage: $" + coverageAmount +
	           "\nTerm: " + termInYears + " years" +
	           "\nEligibility: " + eligibilityCriteria +
	           "\nStatus: " + (active ? "Active" : "Inactive") +
	           "\nCreated By Admin ID: " + createdByAdminId;
	}
}
