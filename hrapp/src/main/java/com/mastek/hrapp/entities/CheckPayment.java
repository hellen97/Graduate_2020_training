package com.mastek.hrapp.entities;

public class CheckPayment extends Payment {
	
	
	int CheckNumber;
	String bankName;
	
	
	
	public int getCheckNumber() {
		return CheckNumber;
	}
	public void setCheckNumber(int checkNumber) {
		CheckNumber = checkNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	@Override
	public String toString() {
		return "CheckPayment [CheckNumber=" + CheckNumber + ", bankName=" + bankName + ", paymentId=" + paymentId
				+ ", amount=" + amount + "]";
	}
}
