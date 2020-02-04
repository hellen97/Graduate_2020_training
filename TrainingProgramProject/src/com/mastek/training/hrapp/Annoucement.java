package com.mastek.training.hrapp;
//We delcare class as abstract 
// Any one of the method in the class is declared as abstract
// if any one of the abstract method from the base class is not overriden 
public abstract class Annoucement {
	
	private String from;
	private String forGroup;
	private String subject;
	private String contentText;

	// Declare the method as abstract when we want the derived class to define
	// the logic of this method/behavoir	
	
	// we cannot declare abstract metjpd / class as final 
	// we cannot declare abstract method as a private mthod, only oublic/protected is allowed .
	public abstract void sendA();
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getForGroup() {
		return forGroup;
	}
	public void setForGroup(String forGroup) {
		this.forGroup = forGroup;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContentText() {
		return contentText;
	}
	public void setContentText(String contentText) {
		this.contentText = contentText;
	}

}
