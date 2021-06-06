package com.spraju.spay.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spraju.spay.dao.UserDAO;
import com.spraju.spay.entity.UserEntity;
import com.spraju.spay.entity.UserWalletEntity;
import com.spraju.spay.model.Card;
import com.spraju.spay.model.UserWallet;
import com.spraju.spay.utility.CardToWalletTransfer;
import com.spraju.spay.validator.DetailsValidator;

@Service
@Transactional
public class UserWalletServiceImpl implements UserWalletService {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	CacheService cacheService;

	@Override
	public String loadUserWalletMoney(CardToWalletTransfer cardToWalletTransfer) throws Exception {
		DetailsValidator.amountValidator(cardToWalletTransfer);
		Optional<UserEntity> userEntity=userDAO.findById(cacheService.getCurrentlyLoggedUser());
		userEntity.get().getUserWalletEntity().setWalletAmount(cardToWalletTransfer.getAmountToTransfer());
		System.out.println(cardToWalletTransfer.getAmountToTransfer());
		System.out.println(userEntity.get().getUserWalletEntity().getWalletAmount());
		return "Amount added to wallet successfully";
		
	}

	@Override
	public UserWallet getUserwallet() {
		Optional<UserEntity> userEntity=userDAO.findById(cacheService.getCurrentlyLoggedUser());
		return UserWalletEntity.prepareUserWallet(userEntity.get().getUserWalletEntity());
		
	}

	
}
