package com.Banking_restapi.Banking_restapi.Services;

import org.springframework.data.repository.CrudRepository;

import com.Banking_restapi.Banking_restapi.MainFolder.Customer_Details;

public interface BankRepository extends CrudRepository<Customer_Details, Integer>{

	

	Customer_Details findByAccountno(int Accountno);
	
}


