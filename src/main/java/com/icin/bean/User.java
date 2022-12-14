package com.icin.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer userid;
	
	@OneToMany 
	List<Account> accountno = new ArrayList<Account>();
	String email,password,address,transactionpassword;
	long phno,panno;
	Date date;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public List<Account> getAccountno() {
		return accountno;
	}
	public void setAccountno(List<Account> accountno) {
		this.accountno = accountno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTransactionpassword() {
		return transactionpassword;
	}
	public void setTransactionpassword(String transactionpassword) {
		this.transactionpassword = transactionpassword;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public long getPanno() {
		return panno;
	}
	public void setPanno(long panno) {
		this.panno = panno;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", accountno=" + accountno + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", transactionpassword=" + transactionpassword + ", phno=" + phno
				+ ", panno=" + panno + ", date=" + date + "]";
	}
	
	
}
