package com.icin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icin.bean.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
