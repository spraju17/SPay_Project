package com.spraju.spay.model;

import com.spraju.spay.entity.AddressEntity;

public class Address {
	private Integer addressId;
	private String line1;
	private String line2;
	private Integer zipCode;
	private String city;
	private String district;
	private String state;
	private String country;
	private Boolean defaultFlag;
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Boolean getDefaultFlag() {
		return defaultFlag;
	}
	public void setDefaultFlag(Boolean defaultFlag) {
		this.defaultFlag = defaultFlag;
	}
	
	public static AddressEntity prepareAddressEntity(Address address)
	{
		AddressEntity addressEntity=new AddressEntity();
		addressEntity.setCity(address.getCity());
		addressEntity.setCountry(address.getCountry());
		addressEntity.setDefaultFlag(address.getDefaultFlag());
		addressEntity.setDistrict(address.getDistrict());
		addressEntity.setLine1(address.getLine1());
		addressEntity.setLine2(address.getLine2());
		addressEntity.setZipCode(address.getZipCode());
		return addressEntity;
	}
	
}
