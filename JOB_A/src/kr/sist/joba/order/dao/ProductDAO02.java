package kr.sist.joba.order.dao;


public class ProductDAO02 {
	String productName[]= {"아메리카노","딸기라떼","케이크","딸기케이크"};
	int productCount[]= {7,2,3,4};
	int productPrice[]= {3000,3500,4000,5000};
	String imgName[]= {"amH.png","strawberryLatte.png","cake.jpg","strawberryCake.jpg"};
	
	int orderCount =1000;
	
	
	public String getImgName(int index) {
		return imgName[index];
	}
	/**
	 * @return the productName
	 */
	public String[] getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String[] productName) {
		this.productName = productName;
	}
	/**
	 * @return the productPrice
	 */
	public int[] getProductPrice() {
		return productPrice;
	}
	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice() {
		this.productPrice = productPrice;
	}
	/**
	 * @return the productCount
	 */
	public int[] getProductCount() {
		return productCount;
	}
	/**
	 * @param productCount the productCount to set
	 */
	public void setProductCount(int i) {
		this.productCount[i]++;
	}
	
	public int getOrderCount() {
		return orderCount;
	}
	
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
}
