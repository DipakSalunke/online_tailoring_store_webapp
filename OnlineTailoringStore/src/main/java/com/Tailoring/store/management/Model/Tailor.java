package com.Tailoring.store.management.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Tailor {
	
	private String shopName;
	private String address;
	private String contactNumber;
	private String workingHours;
	private String availableServices;
	private String courier;
	private String userId;
//	private String category;
//	private String dressType;

	@Override
	public String toString() {
		return "Tailor [shopName=" + shopName + ", Address=" + address + ", contactNumber=" + contactNumber
				+ ", workingHours=" + workingHours + ", availableServices=" + availableServices + ", courier=" + courier
				+ ", userId=" + userId + "]";
	}


//	public String getDressType() {
//		return dressType;
//	}
//
//
//	public void setDressType(String dressType) {
//		this.dressType = dressType;
//	}
//
//
//	public String getCategory() {
//		return category;
//	}
//
//
//	public void setCategory(String category) {
//		this.category = category;
//	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getShopName() {
		return shopName;
	}


	public void setShopName(String shopName) {
		this.shopName = shopName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getWorkingHours() {
		return workingHours;
	}


	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}


	public String getAvailableServices() {
		return availableServices;
	}


	public void setAvailableServices(String availableServices) {
		this.availableServices = availableServices;
	}


	public String getCourier() {
		return courier;
	}


	public void setCourier(String courier) {
		this.courier = courier;
	}


	


	
	
	
}
