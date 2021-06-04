package com.spraju.spay.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spraju.spay.dao.CardDAO;
import com.spraju.spay.dao.UserDAO;
import com.spraju.spay.entity.CardEntity;
import com.spraju.spay.entity.UserEntity;
import com.spraju.spay.model.Card;
import com.spraju.spay.utility.UserCardCollector;
import com.spraju.spay.validator.DetailsValidator;

@Transactional
@Service
public class CardServiceImpl implements CardService {
	
	@Autowired
	CacheService cacheService;
	
	@Autowired
	CardDAO cardDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	DetailsValidator detailsValidator;

	@Override
	public String addUserCard(Card card) throws Exception {
		System.out.println(cacheService.getCurrentlyLoggedUser());
		detailsValidator.userCardValidator(card);
		
		List<CardEntity> cardEntities=userDAO.getUserCardsByUserid(cacheService.getCurrentlyLoggedUser());
		
		List<Card> cards=UserCardCollector.collectUsercards(cardEntities);
		for(Card crd:cards) {
			if(crd.getCardNumber().equals(card.getCardNumber()) && crd.getCvv().equals(card.getCvv()))
				throw new Exception("UserProfile_CARD_ALREADY_EXIST");
		}
		Optional<UserEntity> userEntity=userDAO.findById(cacheService.getCurrentlyLoggedUser());
	
		cardEntities.add(Card.preparecardEntity(card));
		userEntity.get().setCardEntities(cardEntities);
		System.out.println("card added");
		
		return "Card added successfully";
		}

	@Override
	public List<Card> getUserCardDetials(Integer cardId) throws Exception {
		ArrayList<Card> cards=new ArrayList<Card>();
		if(cardId==null){
			cards.addAll(userDAO.getUserCardsByUserid(cacheService.getCurrentlyLoggedUser()).stream().map(CardEntity::prepareCard).collect(Collectors.toCollection(ArrayList::new))) ;
			if(cards.isEmpty())
				throw new Exception("UserProfile_CARDS_NOT_SAVED");
		}
		else {
			cards.add(CardEntity.prepareCard(cardDAO.findById(cardId).get())); 
			if(cards.isEmpty())
				throw new Exception("UserProfile_CARD_NOT_SAVED");
		}
			
		return cards;
	}

	@Override
	public String updateUserCard(Integer cardId, Card card) throws Exception {
		detailsValidator.userCardValidator(card);
		Optional<CardEntity> cardEntity=cardDAO.findById(cardId);
		cardEntity.get().setCardNumber(card.getCardNumber());
		cardEntity.get().setCvv(card.getCvv());
		cardEntity.get().setDefaultFlag(card.getDefaultFlag());
		cardEntity.get().setExpiryMonth(card.getExpiryMonth());
		cardEntity.get().setExpiryYear(card.getExpiryYear());
		return "Card updated successfully";
	}

	@Override
	public String deleteUserCard(Integer cardId) {
		cardDAO.deleteById(cardId);
		return "Card deleted successfully";
	}

}
