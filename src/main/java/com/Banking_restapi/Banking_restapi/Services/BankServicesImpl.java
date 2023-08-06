package com.Banking_restapi.Banking_restapi.Services;
import java.util.List;

import java.util.Random;

// import org.hibernate.sql.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Banking_restapi.Banking_restapi.MainFolder.Admin_Details;
import com.Banking_restapi.Banking_restapi.MainFolder.Customer_Details;
import com.Banking_restapi.Banking_restapi.MainFolder.Loans;
import com.Banking_restapi.Banking_restapi.MainFolder.Transfermoney;
import com.Banking_restapi.Banking_restapi.MainFolder.Transaction;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class BankServicesImpl  implements BankServices {
	
	@Autowired
	private BankRepository  BankRepo;
	
	@Autowired
	private TransactionRepository TransactionRepo;
	
	@Autowired
	private LoanRepository LoanRepo;
	
	@Autowired
	private AdminRepository AdminRepo;
		
	 @Autowired
	    private JavaMailSender mailSender;

	    public String sendSimpleEmail(String toEmail,String subject, String body)
	      {
	    	
	    	System.out.println("request coming function working");
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("kunalsupekar965@gmail.com");
	        message.setTo(toEmail);
	        message.setText(body);
	        message.setSubject(subject);
	        mailSender.send(message);
	        System.out.println("Mail Send...");


	        return ("email sent to "+toEmail);
	    }
	
	public BankServicesImpl() {
		
	}


	@Override
	public List<Customer_Details> getCustomer_Details() {
		
		
		System.out.println("fecting all records");
		return (List<Customer_Details>) BankRepo.findAll();
		
	}


	@Override
	public Customer_Details getSingle(int BankId) {

		
		System.out.println("fetching single record");
		
		 return BankRepo.findById(BankId).get();
		
		
	}


	@Override
	public String addCustomer(Customer_Details customer) {
		
		System.out.println("implemantation class of the project");
		Random random = new Random();

        // Generate a random AccountNo
        int AccountNumber = random.nextInt(90000000) + 100000000;
         int c=customer.getAccountno();
         System.out.println("random Account no is "+AccountNumber+"entered no is "+c);
		 customer.setAccountno(AccountNumber);
		BankRepo.save (customer);
//		String s=sendSimpleEmail("kunal.supekar@mitaoe.ac.in",
//					"Account Created Successfully!..","this is new body");
		String name=customer.getFirstname();
		String message =  "Dear "+name+",\n"
		        + "\n"
		        + "Welcome to Nidhi Bank! \nWe're excited to have you as our valued customer.\n"
		        + "Download our mobile banking app to enjoy secure access to a wide range.\n"
		        + "of financial services, anytime, anywhere. Manage your accounts, transfer funds,\n"
		        + "pay bills, and more!\n"
		        + "\n"
		        + "This is your Account number:"
		        + AccountNumber;
		
	
		
		String text=sendSimpleEmail(customer.getEmail(),"Account Created Successfully!..",message);
		
		System.out.println("course added "+text);
	return "Account Created successfully"+text;
	}


	@Override
	public Customer_Details updateCustomer(Customer_Details customer) {
		BankRepo.save (customer);
		System.out.println("Update successful");
		return customer;
	}


	@Override
	public String delteCustomer(int Accountno) {
Customer_Details c1=BankRepo.findByAccountno(Accountno);
		BankRepo.deleteById(c1.getId());
		System.out.println("deleted successfully");
		return "Deleted successfully";
	}


	@Override
	public Customer_Details validateLogin(int AccountNo , String password) {
        Customer_Details user = BankRepo.findByAccountno(AccountNo);
        if (user != null) {
           
            if (user.getPassword().equals(password)) {
           
            	return user;
            }
        }
        return null;
	}
	
	
	
	@Override
	public Customer_Details getUserByAccountno(int Accountno) {
		return BankRepo.findByAccountno(Accountno);
	}

	
	
	
	@Override
	public String getAccountholdername(int accountNo) {
		Customer_Details c=BankRepo.findByAccountno(accountNo);
		if (c != null) {
			String first_name=c.getFirstname();
			String last_name=c.getLastname();
			System.out.println(c);
			String fullname=first_name+" "+last_name;
			System.out.println("Account found of "+fullname);
			return fullname;
		} else {
			System.out.println("account no not exists");
			return null;
		    
		}
		
		
		
		
	}

	@Override
	public String Transfer_money(Transfermoney transferData) {
		
		 int toaccountNo = transferData.getToaccountNo();
	        int amount = transferData.getAmount();
	        int pin = transferData.getPin();
	        int id = transferData.getId();
	        int fromaccountNo = transferData.getAccountno();
	        String toaccountHolderName=transferData.getAccountHolderName();
	        
	        System.out.println("Account Number: " + toaccountNo);
	        System.out.println("Amount: " + amount);
	        System.out.println("PIN: " + pin);
	        System.out.println("id: " + id);
	        System.out.println("account: " + fromaccountNo);
	        System.out.println("name: " + toaccountHolderName);
	        
	        Customer_Details c1=BankRepo.findById(id).get();
	        Customer_Details c2=BankRepo.findByAccountno(toaccountNo);
	        
	        int reciverid=c2.getId();
	        String sendername=c1.getFirstname()+" "+c1.getLastname();
	        
	        
	        System.out.println("setting balane");
	        System.out.println(c1.getBalance());
	        if(c1.getBalance()<amount)
	        {
	        	return "insufficient balance";
	        }
	        if(c1.getPin()==pin) {
	        	 c2.setBalance(c2.getBalance()+amount);
	 	        c1.setBalance(c1.getBalance()-amount);
	 	        BankRepo.save (c1);
	 	        BankRepo.save (c2);
	 	       System.out.println("transfer done");
	 	     
	 	       //saving senders records
	 	      saveTransactionRecord(id, (-1*amount), toaccountHolderName);
	 
	 	      //saving receivers transactions.
	 	     saveTransactionRecord(reciverid, amount, sendername);
	 	      
	 	      
	 	      return "Money transfer successful";
	        }
	        else {
	        	return "Incorrect pin";
			}
	      
	}
	
	
	 public void saveTransactionRecord(int id,int amount, String toaccountHolderName) {
	        Transaction transaction = new Transaction();
	        transaction.setUserid(id);
	        transaction.setAmount(amount);
	        transaction.setName(toaccountHolderName);
	        System.out.println("saving transaction  ");
	        TransactionRepo.save(transaction);
	        
	        
	    }

	@Override
	public List<Transaction> get_transactions(int id) {
		System.out.println("fecting all transactions");
		return (List<Transaction>) TransactionRepo.findByUserid(id);
	}

	@Override
	public String add_newadmin() {
		Admin_Details admin = new Admin_Details();
        admin.setUsername("abhishekbhosale");
        admin.setPassword("abhi123");
        admin.setEmail("abhishek.bhosale@mitaoe.ac.in");
        System.out.println("adding new admin");
        AdminRepo.save(admin);
		return "done";
	}

	@Override
	public Admin_Details validateAdminLogin(String username, String password) {
		Admin_Details user = AdminRepo.findByUsername(username);
        if (user != null) {
           
            if (user.getPassword().equals(password)) {
           
            	return user;
            }
        }
        return null;
	}

	@Override
	public List<Transaction> get_Admin_transactions() {
	
		return (List<Transaction>) TransactionRepo.findAll();
	}

	
	
	@Override
	public String applyforloans(Loans data) {
		
		LoanRepo.save(data);
		return "applied";
	}

	@Override
	public List<Loans> get_Adminloans_applications() {
		
		return  (List<Loans>) LoanRepo.findAll();
		
	}
	
	
	
	
	

	
	
	
	
		
}