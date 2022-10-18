package com.icin.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.bean.Account;
import com.icin.bean.Loan;
import com.icin.bean.Transaction;
import com.icin.bean.User;
import com.icin.repository.AccountRepository;
import com.icin.repository.LoanRepository;
import com.icin.repository.TransactionRepository;
import com.icin.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	UserRepository ur;
	@Autowired
	AccountRepository ar;
	
	@Autowired
	LoanRepository lr;
	
	@Autowired
	TransactionRepository tr;
	
	
	public void register(User u,Account a )
	{
//		System.out.println("inside service");
//		System.out.println(u);
		ar.save(a);
		u.getAccountno().add(a);
		ur.save(u);

		System.out.println(ur.findById(2).get().getAccountno());
		
		
		
		

	}
	
	
	public String applyLoan(Loan l,long accountno)
	{
		System.out.println(l);
		System.out.println(accountno);
		
		try {
			if(lr.findById(l.getLoanid()).isPresent())
			{
				Optional<Account> result= ar.findById(accountno);
				
				result.get().getLoanid().add(l);
				
				ar.save(result.get());
				return "Loan Application Submitted";
			}
				
			return "Loan not Present";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "Request Unsuccessful";
		}
		
		
	}
	
	public String transferFund(Transaction t,long accountno)
	{
		tr.save(t);
		Optional<Account> result= ar.findById(accountno);
		if(result.isPresent())
		{	
			if(t.getAmount()<result.get().getBalance())
			{
				t.setTimestamp(LocalDateTime.now());
				tr.save(t);
				result.get().setBalance(result.get().getBalance()-t.getAmount());
				result.get().getTransactionid().add(t);
				ar.save(result.get());
				
				return "Funds transfered successfully";
			}
			
			return "Balance in your account is insufficient";
		}
		
		return "Funds transfered unccessful";
	}
	
	public List<Transaction> getByMonth(String month,long accountno)
	{
		Optional<Account> result= ar.findById(accountno);
		List<Transaction> result1= result.get().getTransactionid();
		if(result.isPresent())
		{	
			for (Transaction transaction : result1 ) {
				if(month.equalsIgnoreCase(transaction.getTimestamp().getMonth().name()))
				{
					System.out.println(month);
					result1.add(transaction);
				}
				
			}
						
			
			}
			
			return result1;
	}
	public List<Transaction> getByYear(int year,long accountno)
	{
		Optional<Account> result= ar.findById(accountno);
		List<Transaction> result1= result.get().getTransactionid();
		if(result.isPresent())
		{	
			for (Transaction transaction : result1 ) {
				if(year==(transaction.getTimestamp().getYear()))
				{
					System.out.println(year);
					result1.add(transaction);
				}
				
			}
						
			
			}
			
			return result1;
	}
	public List<Transaction> getByDate(String date,long accountno)
	{
		Optional<Account> result= ar.findById(accountno);
		List<Transaction> result1= result.get().getTransactionid();
		if(result.isPresent())
		{	
			for (Transaction transaction : result1 ) {
				if(transaction.getTimestamp().toLocalDate().toString().equals(date))
				{
					System.out.println(date);
					result1.add(transaction);
				}
				
			}
						
			
			}
			
			return result1;
	}
	
	
	

}
