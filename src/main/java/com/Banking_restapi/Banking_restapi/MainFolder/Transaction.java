package com.Banking_restapi.Banking_restapi.MainFolder;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date; // Import java.util.Date


@Entity
public class Transaction {
	
    // No @Id annotation, as we won't be using a generated primary key
    // This field will hold your custom primary key value
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int srno;
	private int userid;
    private int amount;
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDateTime;

    // Constructors, getters, and setters

    public Date getTransactionDateTime() {
		return transactionDateTime;
	}



	public void setTransactionDateTime(Date transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}



	// Method to set the current date and time before persisting
    @PrePersist
    private void setTransactionDateTime() {
        this.transactionDateTime = new Date();
    }
    
  

	// Constructor
    public Transaction() {
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



	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



    // Getters and setters

}
