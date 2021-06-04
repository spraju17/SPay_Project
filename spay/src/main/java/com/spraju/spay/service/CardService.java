package com.spraju.spay.service;

import java.util.List;

import com.spraju.spay.model.Card;

public interface CardService {

	public String addUserCard(Card card) throws Exception;

	public String updateUserCard(Integer cardId, Card card) throws Exception;

	public String deleteUserCard(Integer cardId);

	public List<Card> getUserCardDetials(Integer cardId) throws Exception;

	

}
