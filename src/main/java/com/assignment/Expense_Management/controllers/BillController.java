package com.assignment.Expense_Management.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.assignment.Expense_Management.entities.Bill;
import com.assignment.Expense_Management.entities.Claim;
import com.assignment.Expense_Management.exception.ResourceNotFoundException;
import com.assignment.Expense_Management.repositories.BillRepository;
import com.assignment.Expense_Management.repositories.ClaimRepository;

@RestController
@RequestMapping("/bills")
public class BillController {
  
  @Autowired
  private BillRepository billRepository;
  
  @Autowired
  private ClaimRepository claimRepository;

  @GetMapping
  public List<Bill> getAllBills() {
    return billRepository.findAll();
  }
  
  @PostMapping("/add")
  public Bill createBill(@RequestBody Bill bill) {
    return billRepository.save(bill);
  }
  
  @GetMapping("/{id}")
  public Bill getBillById(@PathVariable Long id) {
    return billRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bill not found with id " + id,"id",id));
  }
  
  @PostMapping("/{billId}/claims")
  public Claim createClaim(@PathVariable Long billId, @RequestBody Claim claim) {
    Bill bill = billRepository.findById(billId).orElseThrow(() -> new ResourceNotFoundException("Bill not found with id " + billId,"billId",billId));
    claim.setBill(bill);
    return claimRepository.save(claim);
  }

  @GetMapping("/{billId}/claims")
  public List<Claim> getAllClaimsForBill(@PathVariable(value = "billId") Long billId) {
    Bill bill = billRepository.findById(billId)
        .orElseThrow(() -> new ResourceNotFoundException("Bill not found with id " + billId,"billId",billId));

    return claimRepository.findByBill(bill);
  }
}