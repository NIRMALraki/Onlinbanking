package com.icin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.bean.Account;
import com.icin.bean.Loan;
import com.icin.bean.User;
import com.icin.repository.AccountRepository;
import com.icin.repository.LoanRepository;
import com.icin.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	UserRepository ur;
	@Autowired
	AccountRepository ar;
	
	@Autowired
	LoanRepository lr;
	
	
	public void register(User u,Account a )
	{
//		System.out.println("inside service");
//		System.out.println(u);
		ar.save(a);
		u.getAccountno().add(a);
		ur.save(u);

		System.out.println(ur.findById(2).get().getAccountno());
		
		
		
		

	}
	
	
	public void addLoan(Loan l,long accountno)
	{
		System.out.println(l);
		System.out.println(accountno);
		
		lr.save(l); 
		
		Optional<Account> result= ar.findById(accountno);
		
		result.get().getLoanid().add(l);
		
		ar.save(result.get());
		
		
	}
	

}
