package com.Banking_restapi.Banking_restapi.Services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Banking_restapi.Banking_restapi.MainFolder.Admin_Details;
import com.Banking_restapi.Banking_restapi.MainFolder.Customer_Details;

public interface AdminRepository extends JpaRepository<Admin_Details, Integer>{
	
	Admin_Details findByUsername(String username);

}
