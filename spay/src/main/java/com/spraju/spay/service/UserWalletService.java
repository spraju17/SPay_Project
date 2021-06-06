package com.spraju.spay.service;

import com.spraju.spay.model.UserWallet;
import com.spraju.spay.utility.CardToWalletTransfer;

public interface UserWalletService {
	
	UserWallet getUserwallet();
	
	String loadUserWalletMoney(CardToWalletTransfer cardToWalletTransfer) throws Exception;

}
