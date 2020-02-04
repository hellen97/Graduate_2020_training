package com.mastek.training.tests;

import org.junit.Test;

import com.mastek.training.bankaccount.BankAccount;
import com.mastek.training.bankaccount.CheckingAccount;
import com.mastek.training.bankaccount.SavingsAccount;

/**
 * AccountTest2.java 
 * Tests the various bank account classes.
 */


public class AccountTest2 {
  public static void main(String[] args) {
    BankAccount bensSavings = new SavingsAccount(0.5);
    BankAccount bensChecking = new CheckingAccount();

    bensSavings.deposit(10000.00);

    bensSavings.transfer(bensChecking, 2000);

    bensChecking.withdraw(200);
    bensChecking.withdraw(300);
    bensChecking.withdraw(80);
    bensChecking.withdraw(400);

    endOfMonth((SavingsAccount) bensSavings);
    endOfMonth((CheckingAccount) bensChecking);


    System.out.println("Bens's savings. " + bensSavings);
    // (10000 - 2000) * .5 % interest = 8040
    System.out.println("Benjamins's checking. " + bensChecking);
    // 2000 - 200 - 300 - 80 - 400 - 2 trans. fees + 980 = 1999
  }

  // Handle end-of-month operations. Overloaded method, because
  // checking account does different things than savings account.

  /** 
   * Handles end of month interest for a savings account
   * @param savings the savings account to handle
   */
  @Test
  public static void endOfMonth(SavingsAccount savings) {
    savings.addPeriodicInterest();
  }

  /** 
   * Handles end of month fee deduction for a checking account
   * @param checking the checking account to handle
   */
  @Test
  public static void endOfMonth(CheckingAccount checking) {
    checking.deductFees();
  }
}

