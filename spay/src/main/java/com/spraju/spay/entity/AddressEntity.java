package com.spraju.spay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spraju.spay.model.Address;

@Entity
@Table(name ="ADDRESS" )
public class AddressEntity {
	@Id
	@Column(name = "ADDRESS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	@Column(name = "LINE_1")
	private String line1;
	@Column(name = "LINE_2")
	private String line2;
	@Column(name = "ZIP_CODE")
	private Integer zipCode;
	@Column(name = "CITY")
	private String city;
	@Column(name = "DISTRICT")
	private String district;
	@Column(name = "STATE")
	private String state;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "DEFAULT_FLAG")
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
	
	public static Address prepareAddress(AddressEntity addressEntity)
	{
		Address address=new Address();
		address.setAddressId(addressEntity.getAddressId());
		address.setCity(addressEntity.getCity());
		address.setCountry(addressEntity.getCountry());
		address.setDefaultFlag(addressEntity.getDefaultFlag());
		address.setDistrict(addressEntity.getDistrict());
		address.setLine1(addressEntity.getLine1());
		address.setLine2(addressEntity.getLine2());
		address.setZipCode(addressEntity.getZipCode());
		return address;
	}
}
