package com.assignment.Expense_Management.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.Expense_Management.entities.Bill;
import com.assignment.Expense_Management.entities.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {

    List<Claim> findByBill(Bill bill);

}