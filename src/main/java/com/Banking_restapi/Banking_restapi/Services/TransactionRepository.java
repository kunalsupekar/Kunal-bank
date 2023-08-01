package com.Banking_restapi.Banking_restapi.Services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.Banking_restapi.Banking_restapi.MainFolder.Customer_Details;
import com.Banking_restapi.Banking_restapi.MainFolder.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	List<Transaction> findByUserid(int id);
	
}


