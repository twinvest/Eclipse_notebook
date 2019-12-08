package kr.sist.joba.orderhistory.dao;

import java.util.ArrayList;
import java.util.List;

public class OrderDAO  {
		
	int serialNum;
	String orderNum;
	String productName;
	int productPrice;
	int orderCount;
	String userHp;

	public OrderDAO(int serialNum, String orderNum, String productName, int productPrice, int orderCount,
			String userHp) {
		super();
		this.serialNum = serialNum;
		this.orderNum = orderNum;
		this.productName = productName;
		this.productPrice = productPrice;
		this.orderCount = orderCount;
		this.userHp = userHp;
		
	}

	public int getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public String getUserHp() {
		return userHp;
	}

	public void setUserHp(String userHp) {
		this.userHp = userHp;
	}

	@Override
	public String toString() {
		return "[" + serialNum + ",주문번호=" + orderNum + ",상품이름=" + productName
				+ ",상품가격=" + productPrice + ",주문갯수=" + orderCount + ", 전화번호=" + userHp + "]";
	}

	

}