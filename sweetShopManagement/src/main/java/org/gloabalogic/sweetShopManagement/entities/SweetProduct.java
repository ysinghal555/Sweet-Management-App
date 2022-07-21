package org.gloabalogic.sweetShopManagement.entities;

public class SweetProduct {

	private int sweetProductId;
	private String sweetProductName;
	private double sweetProductPrice;
	private double sweetProductDiscount;
	private double sweetProductFinalPrice;

	// Default Constructor
	public SweetProduct() {
		super();
	}

	// Parameterized Constructor with all the parameters
	public SweetProduct(int sweetProductId, String sweetProductName, double sweetProductPrice,
			double sweetProductDiscount, double sweetProductFinalPrice) {
		super();
		this.sweetProductId = sweetProductId;
		this.sweetProductName = sweetProductName;
		this.sweetProductPrice = sweetProductPrice;
		this.sweetProductDiscount = sweetProductDiscount;
		this.sweetProductFinalPrice = sweetProductFinalPrice;
	}

	// Parameterized Constructor with id as a parameter
	public SweetProduct(int sweetProductId) {
		super();
		this.sweetProductId = sweetProductId;
	}

	// Parameterized Constructor name, price, discount and finalPrice as a parameter
	public SweetProduct(String sweetProductName, double sweetProductPrice, double sweetProductDiscount,
			double sweetProductFinalPrice) {
		super();
		this.sweetProductName = sweetProductName;
		this.sweetProductPrice = sweetProductPrice;
		this.sweetProductDiscount = sweetProductDiscount;
		this.sweetProductFinalPrice = sweetProductFinalPrice;
	}

	// Getters and Setters to access the variables
	public int getSweetProductId() {
		return sweetProductId;
	}

	public void setSweetProductId(int sweetProductId) {
		this.sweetProductId = sweetProductId;
	}

	public String getSweetProductName() {
		return sweetProductName;
	}

	public void setSweetProductName(String sweetProductName) {
		this.sweetProductName = sweetProductName;
	}

	public double getSweetProductPrice() {
		return sweetProductPrice;
	}

	public void setSweetProductPrice(double sweetProductPrice) {
		this.sweetProductPrice = sweetProductPrice;
	}

	public double getSweetProductDiscount() {
		return sweetProductDiscount;
	}

	public void setSweetProductDiscount(double sweetProductDiscount) {
		this.sweetProductDiscount = sweetProductDiscount;
	}

	public double getSweetProductFinalPrice() {
		return sweetProductFinalPrice;
	}

	public void setSweetProductFinalPrice(double sweetProductFinalPrice) {
		this.sweetProductFinalPrice = sweetProductFinalPrice;
	}

	// toString method to print
	@Override
	public String toString() {
		return "Sweet Product Id = " + sweetProductId + ", Sweet Product Name = " + sweetProductName
				+ ", Sweet Product Price = " + sweetProductPrice + ", Sweet Product Discount = " + sweetProductDiscount
				+ ", Sweet Product FinalPrice = " + sweetProductFinalPrice;
	}

}
