package com.spraju.spay.service;

import org.springframework.stereotype.Service;

@Service
public class CacheService {
	private Integer currentlyLoggedUser;

	public Integer getCurrentlyLoggedUser() {
		return currentlyLoggedUser;
	}

	public void setCurrentlyLoggedUser(Integer currentlyLoggedUser) {
		this.currentlyLoggedUser = currentlyLoggedUser;
	}
}
