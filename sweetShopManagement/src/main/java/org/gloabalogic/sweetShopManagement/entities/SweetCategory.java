package org.gloabalogic.sweetShopManagement.entities;

public class SweetCategory {
	private int sweetCategoryId;
	private String sweetCategoryName;

	// Default Constructor
	public SweetCategory() {
		super();
	}

	// Parameterized Constructor with all the parameters
	public SweetCategory(int sweetCategoryId, String sweetCategoryName) {
		super();
		this.sweetCategoryId = sweetCategoryId;
		this.sweetCategoryName = sweetCategoryName;
	}

	// Parameterized Constructor id as a parameter
	public SweetCategory(int sweetCategoryId) {
		super();
		this.sweetCategoryId = sweetCategoryId;
	}

	// Parameterized Construcall the tor with name as a parameter
	public SweetCategory(String sweetCategoryName) {
		super();
		this.sweetCategoryName = sweetCategoryName;

	}

	// Getters and Setters to access the variables
	public int getSweetCategoryId() {
		return sweetCategoryId;
	}

	public void setSweetCategoryId(int sweetCategoryId) {
		this.sweetCategoryId = sweetCategoryId;
	}

	public String getSweetCategoryName() {
		return sweetCategoryName;
	}

	public void setSweetCategoryName(String sweetCategoryName) {
		this.sweetCategoryName = sweetCategoryName;
	}

	// toString method to print
	@Override
	public String toString() {
		return "Sweet Category Id = " + sweetCategoryId + ", Sweet Category Name = " + sweetCategoryName;
	}

}
