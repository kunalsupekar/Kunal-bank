package com.Banking_restapi.Banking_restapi.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Banking_restapi.Banking_restapi.MainFolder.Loans;

public interface LoanRepository extends JpaRepository<Loans, Integer>{

}
