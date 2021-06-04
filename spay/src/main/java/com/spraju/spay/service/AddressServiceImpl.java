package com.spraju.spay.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spraju.spay.dao.AddressDAO;
import com.spraju.spay.dao.UserDAO;
import com.spraju.spay.entity.AddressEntity;
import com.spraju.spay.entity.UserEntity;
import com.spraju.spay.model.Address;
import com.spraju.spay.validator.DetailsValidator;

@Service
@Transactional
public class AddressServiceImpl implements AddressService  {
	
	@Autowired
	AddressDAO addressDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	DetailsValidator detailsValidator;
	
	@Autowired
	CacheService cacheService;

	@Override
	public String addUserAddress(Address address) throws Exception {
		System.out.println("service");
		detailsValidator.userAddressValidator(address);
		System.out.println("after validation");
		UserEntity userEntity=userDAO.getById(cacheService.getCurrentlyLoggedUser());
		userEntity.setAddressEntity(Address.prepareAddressEntity(address));
		return "Address addedd successfully";
	}

	@Override
	public Address getUserAddress(Integer addressId) {
		return AddressEntity.prepareAddress(addressDAO.findById(addressId).get());
	}

	

	@Override
	public String updateUserAddress(Address address,Integer addressId) throws Exception {
		
		detailsValidator.userAddressValidator(address);
		AddressEntity addressEntity=addressDAO.getById(addressId);
		addressEntity.setCity(address.getCity());
		addressEntity.setCountry(address.getCity());
		addressEntity.setDefaultFlag(address.getDefaultFlag());
		addressEntity.setDistrict(address.getDistrict());
		addressEntity.setLine1(address.getLine1());
		addressEntity.setLine2(address.getLine2());
		addressEntity.setState(address.getState());
		addressEntity.setZipCode(address.getZipCode());
		return "Address addedd successfully";
	}

	@Override
	public String deleteUserAddress(Integer addressId) {
		addressDAO.deleteById(addressId);
		return "Address deleted successfully";
	}

	

}
