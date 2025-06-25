package InsurancePkg;

public class Admin extends User {
	
	public Admin(String id, String name, String email, String password) {
		super(id, name, email, password);
	}

	@Override
	public String getRole() {
		return "Admin";
	}
	
	public String toString() {
		return "Admin ID: " + id +
				"\nName: " + name +
				"\nEmail: " + email +
				"\nRole: Admin";
	}

}
