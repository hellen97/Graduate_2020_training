package com.mastek.hrapp.entities;

public class CardPayment  extends Payment {
	
	long cardNumber;
	String cardService;
	public long getCardNumber() {
		return cardNumber;
		
		
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardService() {
		return cardService;
	}
	public void setCardService(String cardService) {
		this.cardService = cardService;
	}
	@Override
	public String toString() {
		return "CardPayment [cardNumber=" + cardNumber + ", cardService=" + cardService + ", paymentId=" + paymentId
				+ ", amount=" + amount + "]";
	}

	
	
}
