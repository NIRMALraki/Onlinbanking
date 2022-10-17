package com.icin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.icin.bean.AccountLoan;
import com.icin.bean.User;
import com.icin.bean.UserRegister;
import com.icin.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService us;
	
	@PostMapping(value = "register")
	public void register(@RequestBody UserRegister data)
	{
		System.out.println(data.getUser());
		System.out.println(data.getAccount());
//		us.register(data.getUser(), data.getAccount());
		us.register(data.getUser(), data.getAccount());
		
	}
	
	@PostMapping("addloan")
	public void addLoan(@RequestBody AccountLoan al)
	{
		us.addLoan(al.getLoan(), al.getAccountno());
	}

}
