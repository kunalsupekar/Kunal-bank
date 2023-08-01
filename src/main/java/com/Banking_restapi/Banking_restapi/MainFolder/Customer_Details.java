package com.Banking_restapi.Banking_restapi.MainFolder;


import jakarta.persistence.Entity;
//import jakarta.persistence.Lob;
import jakarta.persistence.Id;

@Entity
public class Customer_Details {
	
	
	@Id
	private int id;
	
	
	private int accountno;
	private int pin;
	private String mobile;
	private  String firstname;
	private  String lastname;
	private  String city;
	private  String state;
	private  String address;
	private  String email;
	private  String password;
	private int balance;

	
	public Customer_Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	@Override
	public String toString() {
		return "Customer_Details [id=" + id + ", accountno=" + accountno + ", pin=" + pin + ", mobile=" + mobile
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", city=" + city + ", state=" + state
				+ ", address=" + address + ", email=" + email + ", password=" + password + ", balance=" + balance + "]";
	}




	public Customer_Details(int id, int accountno, int pin, String mobile, String firstname, String lastname,
			String city, String state, String address, String email, String password,int balance) {
		super();
		this.id = id;
		this.accountno = accountno;
		this.pin = pin;
		this.mobile = mobile;
		this.firstname = firstname;
		this.lastname = lastname;
		this.city = city;
		this.state = state;
		this.address = address;
		this.email = email;
		this.password = password;
		this.balance=balance;
	}
	
	
	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	

}
