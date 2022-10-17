package com.icin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.icin.bean.Transaction;
import com.icin.repository.TransactionRepository;

@Service
public class AdminService {
	
	TransactionRepository tr;
	
	public void getTransactionByMonth(String month) {
		
		List<Transaction> result= new ArrayList<Transaction>();
		for (Transaction transaction : tr.findAll()) {
			if(transaction.getTimestamp().getMonth().equals(month))
			{
			result.add(transaction);
			}
			
		}
		
		System.out.println(result);
		
	}

}
