package com.icin.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.icin.bean.Loan;
import com.icin.bean.Transaction;
import com.icin.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	AdminService as;
	
	@GetMapping("bymonth/{month}")
	public List<Transaction> getByMonth(@PathVariable("month") String month)
	{
		System.out.println(month);
		return as.getTransactionByMonth(month);
	}
	
	@GetMapping("byyear/{year}")
	public List<Transaction> getByYear(@PathVariable("year") int year)
	{
		System.out.println(year);
		 return as.getTransactionByYear(year);
	}
	@GetMapping("bydate/{date}")
	public List<Transaction> getByYear(@PathVariable("date") String date)
	{
		System.out.println(date);
		 return as.getTransactionByDate(date);
	}
	
	@GetMapping("ApprovedRejectedLoan")
	public List<Loan> getApprovedRejectedLoan()
	{
		return as.getApprovedRejectedLoan();
	}

}
