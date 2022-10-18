package com.icin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.icin.bean.AccountLoan;
import com.icin.bean.Transaction;
import com.icin.bean.User;
import com.icin.bean.UserRegister;
import com.icin.service.AdminService;
import com.icin.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService us;
	
	@Autowired
	AdminService as;
	
//	@PostMapping(value = "register")
//	public void register(@RequestBody UserRegister data)
//	{
//		System.out.println(data.getUser());
//		System.out.println(data.getAccount());
////		us.register(data.getUser(), data.getAccount());
//		us.register(data.getUser(), data.getAccount());
//		
//	}
	
	@PostMapping("addloan")
	public String applyLoan(@RequestBody AccountLoan al)
	{
		return us.applyLoan(al.getLoan(), al.getAccountno());
	}
	
	@PatchMapping("fundtransfer/{accountno}")
	public String fundTransfer(@RequestBody Transaction t,@PathVariable("accountno") long accountno)
	{
		
		return us.transferFund(t, accountno);
	}
	
	@GetMapping("bymonth/{month}/{accountno}")
	public List<Transaction> getByMonth(@PathVariable("month") String month,@PathVariable("accountno") long accountno)
	{
		System.out.println(month);
		return us.getByMonth(month,accountno);
	}
	
	@GetMapping("byyear/{year}/{accountno}")
	public List<Transaction> getByYear(@PathVariable("year") int year,@PathVariable("accountno") long accountno)
	{
		System.out.println(year);
		 return us.getByYear(year,accountno);
	}
	@GetMapping("bydate/{date}/{accountno}")
	public List<Transaction> getByDate(@PathVariable("date") String date,@PathVariable("accountno") long accountno)
	{
		System.out.println(date);
		 return us.getByDate(date,accountno);
	}

}
