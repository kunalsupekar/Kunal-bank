package com.Banking_restapi.Banking_restapi.Services;
import java.util.List;

import com.Banking_restapi.Banking_restapi.MainFolder.Admin_Details;
import com.Banking_restapi.Banking_restapi.MainFolder.Customer_Details;
import com.Banking_restapi.Banking_restapi.MainFolder.Loans;
import com.Banking_restapi.Banking_restapi.MainFolder.Transaction;
import com.Banking_restapi.Banking_restapi.MainFolder.Transfermoney;

public interface BankServices {
	
	public List<Customer_Details> getCustomer_Details();
	
	public Customer_Details getSingle(int BankId);
	
	
	
	public String  addCustomer(Customer_Details  customer);

	public Customer_Details updateCustomer(Customer_Details customer);
	
	public String delteCustomer(int Accountno);
	
	public String sendSimpleEmail(String toEmail,String subject, String body); 
		
	public Customer_Details validateLogin(int AccountNo, String password);
	
	public Customer_Details getUserByAccountno(int Accountno) ;

	public String getAccountholdername(int accountNo);

	public String Transfer_money(Transfermoney transferData);

	public List<Transaction> get_transactions(int id);

	public String add_newadmin();

	public Admin_Details validateAdminLogin(String username, String password);

	public List<Transaction> get_Admin_transactions();

	public String applyforloans(Loans formdata);

	public List<Loans> get_Adminloans_applications();
	
	
	
}
