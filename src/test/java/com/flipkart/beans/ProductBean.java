/**
 * 
 */
package com.flipkart.beans;

/**
 * @author Vikash.Singh
 */
public class ProductBean {

	private static String productName;
	private static String productPrice;
	private static String productColor;

	public static String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public static String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public static String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	public void info() {
		System.out.println(productPrice);
	}

}
