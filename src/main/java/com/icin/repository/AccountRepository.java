package com.icin.repository;

import org.springframework.stereotype.Repository;

import com.icin.bean.Account;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
	
	

}
