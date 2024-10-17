package com.project.JP.Model;

public class JoinTable {
	private String categoryName;
    private String productName;
    private double price;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public JoinTable(String categoryName, String productName, double price) {
		super();
		this.categoryName = categoryName;
		this.productName = productName;
		this.price = price;
	}
	public JoinTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "JoinTable [categoryName=" + categoryName + ", productName=" + productName + ", price=" + price + "]";
	}
    
}
