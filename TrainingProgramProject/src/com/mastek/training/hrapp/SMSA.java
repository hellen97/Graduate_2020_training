package com.mastek.training.hrapp;

public class SMSA extends Annoucement {
	// each derived class of the base abstract class must override all the abstract methods
	// from the /base/parent clas 

	@Override
	public void sendA() {
		
		System.out.println("Sending SMS to"+getForGroup()+"By"+getFrom()+"with title:" +getSubject()+ "and test :"+getContentText());
		// TODO Auto-generated method stub

	}

}
