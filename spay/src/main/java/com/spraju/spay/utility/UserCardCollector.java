package com.spraju.spay.utility;

import java.util.ArrayList;
import java.util.List;

import com.spraju.spay.entity.CardEntity;
import com.spraju.spay.model.Card;

public class UserCardCollector {
	
	public static List<Card> collectUsercards(List<CardEntity> cardEntities){
		List<Card> cards=new ArrayList<Card>();
		for(CardEntity cardEntity:cardEntities) {
			cards.add(CardEntity.prepareCard(cardEntity));
		}
		return cards;}

}
