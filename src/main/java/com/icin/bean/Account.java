package com.icin.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Account {
	
	@Id
	long accountno;
	@ManyToOne
	@JoinColumn(name= "userid")
	User userid;
	
	@OneToMany
	List<Loan> loanid = new ArrayList<Loan>();
	
	@OneToMany
	List<Transaction> transactionid= new ArrayList<Transaction>();
	@Column(name="balance")
	float balance=0.0f;
	@Column(name="accounttype")
	String accounttype="none";
	@Column(name="transfer")
	String transfer="pending";
	@Column(name="deposit")
	String deposit="pending";
	@Column(name="withdrawl")
	String withdrawl="pending";
	@Column(name="cheque")
	String cheque="pending";
	@Column(name="status")
	String status="pending";
	@Column(name="loanstatus")
	String loanstatus="pending";
		
	public Account() {
		super();
	}
	

	public Account(long accountno, User userid, List<Loan> loanid, List<Transaction> transactionid, float balance,
			String accounttype, String transfer, String deposit, String withdrawl, String cheque, String status,
			String loanstatus) {
		super();
		this.accountno = accountno;
		this.userid = userid;
		this.loanid = loanid;
		this.transactionid = transactionid;
		this.balance = balance;
		this.accounttype = accounttype;
		this.transfer = transfer;
		this.deposit = deposit;
		this.withdrawl = withdrawl;
		this.cheque = cheque;
		this.status = status;
		this.loanstatus = loanstatus;
	}


	public long getAccountno() {
		return accountno;
	}

	public void setAccountno(long accountno) {
		this.accountno = accountno;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public List<Loan> getLoanid() {
		return loanid;
	}

	public void setLoanid(List<Loan> loanid) {
		this.loanid = loanid;
	}

	public List<Transaction> getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(List<Transaction> transactionid) {
		this.transactionid = transactionid;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getTransfer() {
		return transfer;
	}

	public void setTransfer(String transfer) {
		this.transfer = transfer;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getWithdrawl() {
		return withdrawl;
	}

	public void setWithdrawl(String withdrawl) {
		this.withdrawl = withdrawl;
	}

	public String getCheque() {
		return cheque;
	}

	public void setCheque(String cheque) {
		this.cheque = cheque;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLoanstatus() {
		return loanstatus;
	}

	public void setLoanstatus(String loanstatus) {
		this.loanstatus = loanstatus;
	}

	
	



}
