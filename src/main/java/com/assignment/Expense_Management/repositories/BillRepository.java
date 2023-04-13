package com.assignment.Expense_Management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.Expense_Management.entities.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    
}