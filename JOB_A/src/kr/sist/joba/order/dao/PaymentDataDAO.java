package kr.sist.joba.order.dao;

public class PaymentDataDAO {
	String orderProductName;
	int orderProductCount;
	
	public PaymentDataDAO() {
		
	}
	
	public PaymentDataDAO(String orderProductName, int orderProductCount) {

		this.orderProductName = orderProductName;
		this.orderProductCount = orderProductCount;
	}
	/**
	 * @return the orderProductName
	 */
	public String getOrderProductName() {
		return orderProductName;
	}
	/**
	 * @param orderProductName the orderProductName to set
	 */
	public void setOrderProductName(String orderProductName) {
		this.orderProductName = orderProductName;
	}


	/**
	 * @return the orderProductCount
	 */
	public int getOrderProductCount() {
		return orderProductCount;
	}
	/**
	 * @param orderProductCount the orderProductCount to set
	 */
	public void setOrderProductCount(int orderProductCount) {
		this.orderProductCount = orderProductCount;
	}

}
