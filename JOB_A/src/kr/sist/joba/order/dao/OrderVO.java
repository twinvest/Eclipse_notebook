package kr.sist.joba.order.dao;

import data.DTO;

public class OrderVO extends DTO {

	private String serialNum;
	
	private String orderNum;
	
	private String userCellPhone;

	private String orderCount;
	
	private String orderPrice;
	
	private String productName;
	
	private String userId;
	
	private String storeName;
	
	private String orderDivision;
	
	private String orderPreparing;

	public OrderVO() {}

	public OrderVO(String serialNum, String orderNum, String userCellPhone, String orderCount, String orderPrice,
			String productName, String userId, String storeName, String orderDivision, String orderPreparing) {
		super();
		this.serialNum = serialNum;
		this.orderNum = orderNum;
		this.userCellPhone = userCellPhone;
		this.orderCount = orderCount;
		this.orderPrice = orderPrice;
		this.productName = productName;
		this.userId = userId;
		this.storeName = storeName;
		this.orderDivision = orderDivision;
		this.orderPreparing = orderPreparing;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getUserCellPhone() {
		return userCellPhone;
	}

	public void setUserCellPhone(String userCellPhone) {
		this.userCellPhone = userCellPhone;
	}

	public String getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(String orderCount) {
		this.orderCount = orderCount;
	}

	public String getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getOrderDivision() {
		return orderDivision;
	}

	public void setOrderDivision(String orderDivision) {
		this.orderDivision = orderDivision;
	}

	public String getOrderPreparing() {
		return orderPreparing;
	}

	public void setOrderPreparing(String orderPreparing) {
		this.orderPreparing = orderPreparing;
	}

	@Override
	public String toString() {
		return "OrderVO [serialNum=" + serialNum + ", orderNum=" + orderNum + ", userCellPhone=" + userCellPhone
				+ ", orderCount=" + orderCount + ", orderPrice=" + orderPrice + ", productName=" + productName
				+ ", userId=" + userId + ", storeName=" + storeName + ", orderDivision=" + orderDivision
				+ ", orderPreparing=" + orderPreparing + ", toString()=" + super.toString() + "]";
	}
}
