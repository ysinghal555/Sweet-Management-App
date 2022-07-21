package org.gloabalogic.sweetShopManagement.entities;

public class Users {
	private int id;
	private String username;
	private String password;
	private boolean isAdminOrCustomer;

	// Default Constructor
	public Users() {
		super();
	}

	// Parameterized Constructor with all the parameters
	public Users(int id, String username, String password, boolean isAdminOrCustomer) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.isAdminOrCustomer = isAdminOrCustomer;
	}

	// Parameterized Constructor with username, password and isAdminOrCustomer
	public Users(String username, String password, boolean isAdminOrCustomer) {
		super();
		this.username = username;
		this.password = password;
		this.isAdminOrCustomer = isAdminOrCustomer;
	}

	// Getters and Setters for the the variables
	public Users(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getIsAdminOrCustomer() {
		return isAdminOrCustomer;
	}

	public void setIsAdminOrCustomer(boolean isAdminOrCustomer) {
		this.isAdminOrCustomer = isAdminOrCustomer;
	}

	// toString method to print
	@Override
	public String toString() {
		String isAdmin = "";
		if (isAdminOrCustomer) {
			isAdmin = "Admin";
		} else {
			isAdmin = "Customer";
		}
		return "User Id = " + id + ", Username = " + username + ", Password = " + password + ", Type of User = "
				+ isAdmin;
	}

}
