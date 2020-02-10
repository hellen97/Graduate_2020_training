package com.mastek.hrapp.entities;

//import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="JPA_TABLE_PER_CLASS_CHECK_PAYMENT")
//@DiscriminatorValue("Check") // value to be stored in payment type for checkpayment objects
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
