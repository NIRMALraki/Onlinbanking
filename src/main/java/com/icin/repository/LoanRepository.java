package com.icin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icin.bean.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer> {

}
