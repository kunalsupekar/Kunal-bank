package com.Banking_restapi.Banking_restapi.MainFolder;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Banking_restapi.Banking_restapi.Services.BankServices;


@RestController
@CrossOrigin
public class Controller {

	@Autowired
	private BankServices bank;
	
	//testing purpose
	@GetMapping("/bank")
	public String testing() {
		return "hello bank!";
		
	}
	
	//getting all the records.
	@GetMapping("/getdetails")
	public List<Customer_Details> getCustomer_Details() {
		
		return this.bank.getCustomer_Details();
		
	}
	
	
	//geting single record.
	@GetMapping("/getdetails/{BankId}")
	public Customer_Details getSingleCustomer_Details(@PathVariable int BankId)
	{
		return this.bank.getSingle(BankId);
	}
	
	
	//adding the records
	@PostMapping("/getdetails")
	public String addCustomer(@RequestBody Customer_Details customer) {
	
		
		System.out.println("call coming to controller for adding");
		//System.out.println(image.getOriginalFilename());
		return this.bank.addCustomer(customer);
		
	}
	
	
	//updating the records.
	@PutMapping("/getdetails")
	public Customer_Details updateCustomer(@RequestBody Customer_Details customer)
	{
		return this.bank.updateCustomer(customer);
		
	}
	
	
	//deleting the records.
	@DeleteMapping("/getdetails/{Accountno}")
	public  String deleteCustomer( @PathVariable int Accountno) {
		System.out.println("deleting user"+Accountno);
		return this.bank.delteCustomer(Accountno);
	}
	
	
	@GetMapping("/email")
	public String sendMail()
	{
	return	this.bank.sendSimpleEmail("kunal.supekar@mitaoe.ac.in",
				"Account Created Successfully!..","this is body");
	}

	//checking login 
	@PostMapping("/login")
    public Customer_Details login(@RequestBody Customer_Details loginRequest) {
        int AccountNo = loginRequest.getAccountno();
        String password = loginRequest.getPassword();            
            if(bank.validateLogin(AccountNo, password)==null) {
            	System.out.println("failed");    
            }
            else {
            	System.out.println("Success");    
            }
            return this.bank.validateLogin(AccountNo, password);
    }
	
	
	
	
	@GetMapping("/getname/{accountNo}")
	public String getAccountholder_name(@PathVariable int accountNo)
	{
		System.out.println("account details fetching "+accountNo);
		return this.bank.getAccountholdername(accountNo);
	
	}
	
	
	
	 @PostMapping("/transfer")
	    public String transferMoney(@RequestBody Transfermoney transferData) {
	        // Extract the necessary data from the TransferData object
	       

	       // return "Money transfer successful!";
	        return this.bank.Transfer_money(transferData);
	    }
	 
	 
	 
	 @GetMapping("/gettransactions")
		public List<Transaction> get_transactions(@RequestParam int id) {
			
			return this.bank.get_transactions(id);
			
		}
	 
	 
	 
	 @GetMapping("/getadmintransactions")
		public List<Transaction> get_Admin_transactions() {
			
			return this.bank.get_Admin_transactions();
			
		}
	 
	 
	 @GetMapping("/admin")
	 public String  add_admin() {
		 return this.bank.add_newadmin();
	 }
	
	 
	 
	 @PostMapping("/adminlogin")
	    public Admin_Details login1(@RequestBody Admin_Details loginRequest) {
	        String username = loginRequest.getUsername();
	        String password = loginRequest.getPassword();            
	            if(bank.validateAdminLogin(username, password)==null) {
	            	System.out.println("failed admin");    
	            }
	            else {
	            	System.out.println("Success admin");    
	            }
	            return this.bank.validateAdminLogin(username, password);
	    }
		
		
	 
	 @PostMapping("/loans")
	    public String  applyloans(@RequestBody Loans formdata) {
		 System.out.println(formdata);
	      
	        return this.bank.applyforloans(formdata);
	    }
	 
	 
	 @GetMapping("/getadminloans")
		public List<Loans> get_Admin_loans() {
			
			return this.bank.get_Adminloans_applications();
			
		}

	    @PutMapping("/loans/{id}")
	    public String updateLoanStatus(@PathVariable String id, @RequestBody Loans request) {
	    	  System.out.println("Received ID: " + id);
	    	String status=request.getStatus();
	    	int Id = Integer.parseInt(id);
	    	System.out.println(status+" "+Id);
	    	
	    	return this.bank.setloanstatus(Id,status);
	    }
	 
	 
	 
}
	

