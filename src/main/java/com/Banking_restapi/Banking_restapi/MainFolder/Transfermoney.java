package com.Banking_restapi.Banking_restapi.MainFolder;

public class Transfermoney {
	
	private int toaccountNo;
    private int amount;
    private int pin;
    private int accountno;
    private int id;
    private String accountHolderName;
    
	
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getToaccountNo() {
		return toaccountNo;
	}
	public void setToaccountNo(int toaccountNo) {
		this.toaccountNo = toaccountNo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	public Transfermoney() {
		super();
		// TODO Auto-generated constructor stub
	}


}
