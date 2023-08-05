package com.Banking_restapi.Banking_restapi.MainFolder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Loans {
	

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int srno;
	
	private int userid;
	private String name;
	private int accountno;
	   private int amount;
	   private String income;

		private  String existingloan;
		private String loantype;
		
		
   @Override
		public String toString() {
			return "Loans [srno=" + srno + ", userid=" + userid + ", name=" + name + ", accountno=" + accountno
					+ ", amount=" + amount + ", income=" + income + ", existingloan=" + existingloan + ", loantype="
					+ loantype + "]";
		}
public int getSrno() {
		return srno;
	}
	public void setSrno(int srno) {
		this.srno = srno;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getExistingloan() {
		return existingloan;
	}
	public void setExistingloan(String existingloan) {
		this.existingloan = existingloan;
	}
	public String getLoantype() {
		return loantype;
	}
	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}
public Loans() {
		super();
		// TODO Auto-generated constructor stub
	}


}
