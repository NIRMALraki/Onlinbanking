package com.icin.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.bean.Account;
import com.icin.bean.Loan;
import com.icin.bean.Transaction;
import com.icin.repository.AccountRepository;
import com.icin.repository.TransactionRepository;

@Service
public class AdminService {
	
	@Autowired
	TransactionRepository tr;
	
	@Autowired
	AccountRepository ar;
	
	Transaction t;
	public List<Transaction> getTransactionByMonth(String month) {
		
//		 LocalDateTime now = LocalDateTime.now();  
//		 DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
//		 now.format(format);
//		 t= new Transaction();
//			t.setRecepientno(56789);
//			t.setAmount(100.0f);
//			t.setRecipient_name("nirmal");
//			t.setTimestamp(now);
//			t.setTransactionid(12345);
//			tr.save(t);
		System.out.println(month);
		List<Transaction> result= new ArrayList<Transaction>();
		for (Transaction transaction : tr.findAll()) {
			if(month.equalsIgnoreCase(transaction.getTimestamp().getMonth().name()))
			{
				System.out.println(month);
			result.add(transaction);
			}
			
		}
		
		return result;
		
	}
	
	public List<Transaction> getTransactionByYear(int year)
	{
		List<Transaction> result= new ArrayList<Transaction>();
		for (Transaction transaction : tr.findAll()) {
			if(year==transaction.getTimestamp().getYear())
			{
				System.out.println(year);
			result.add(transaction);
			}
			
		}
		System.out.println(result);
		return result;
	}
	
	public List<Transaction> getTransactionByDate(String d)
	{
		
		List<Transaction> result= new ArrayList<Transaction>();
		for (Transaction transaction : tr.findAll()) {
				if(transaction.getTimestamp().toLocalDate().toString().equals(d))
				{
					result.add(transaction);
				}
			
			
		}
		System.out.println(result);
		return result;
	}
	
	public List<Loan> getApprovedRejectedLoan()
	{
		List<Loan> result= new ArrayList<Loan>();
		for ( Account a : ar.findAll()) {
			if(a.getLoanstatus().equals("approved")||a.getLoanstatus().equals("rejected"))
			{
				for (Loan loan : a.getLoanid()) {
					
					result.add(loan);
				}
			}
		}
		return result;
		
	}

}
