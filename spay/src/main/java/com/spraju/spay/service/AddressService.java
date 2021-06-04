package com.spraju.spay.service;

import com.spraju.spay.model.Address;

public interface AddressService {
	

	public Address getUserAddress(Integer addressId);

	public String addUserAddress(Address address) throws Exception;

	public String updateUserAddress(Address address,Integer addressId) throws Exception;

	public String deleteUserAddress(Integer addressId);
}
