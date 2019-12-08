package kr.sist.joba.store.dao;

import data.DTO;

public class StoreVO extends DTO {

	private String storeName;
	
	private String storeArea;
	
	private String storeCellPhone;

	public StoreVO() {}
	
	public StoreVO(String storeName, String storeArea, String storeCellPhone) {
		super();
		this.storeName = storeName;
		this.storeArea = storeArea;
		this.storeCellPhone = storeCellPhone;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreArea() {
		return storeArea;
	}

	public void setStoreArea(String storeArea) {
		this.storeArea = storeArea;
	}

	public String getStoreCellPhone() {
		return storeCellPhone;
	}

	public void setStoreCellPhone(String storeCellPhone) {
		this.storeCellPhone = storeCellPhone;
	}

	@Override
	public String toString() {
		return "StoreVO [storeName=" + storeName + ", storeArea=" + storeArea + ", storeCellPhone=" + storeCellPhone
				+ ", toString()=" + super.toString() + "]";
	}
}
