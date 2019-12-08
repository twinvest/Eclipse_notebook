package kr.sist.joba.order.dao;


public class ProductDAO {
	

	String productName;
	int productPrice;
	String imgName;
	
	int orderCount=0;
	
	public ProductDAO() {}
	
	public ProductDAO(String productName, int productPrice,String imgName) {

		this.productName = productName;
		this.productPrice = productPrice;
		this.imgName = imgName;
		
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productPrice
	 */
	public int getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the imgName
	 */
	public String getImgName() {
		return imgName;
	}

	/**
	 * @param imgName the imgName to set
	 */
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	/**
	 * @return the orderCount
	 */
	public int getOrderCount() {
		return orderCount;
	}

	/**
	 * @param orderCount the orderCount to set
	 */
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	
}