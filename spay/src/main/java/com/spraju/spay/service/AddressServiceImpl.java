package com.spraju.spay.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spraju.spay.dao.AddressDAO;
import com.spraju.spay.model.Address;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressDAO addressDAO;

	@Override
	public String addAddress(Address address) {
		
		return null;
	}

}
