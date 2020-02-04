package com.mastek.training.hrapp;

public class EmailA extends Annoucement {

	@Override
	public void sendA() {
		// TODO Auto-generated method stub
		
		
		System.out.println("Sending EMAIL to"+getForGroup()+"By"+getFrom()+"with Ttitle:" +getSubject()+ "and test :"+getContentText());

	}

}
