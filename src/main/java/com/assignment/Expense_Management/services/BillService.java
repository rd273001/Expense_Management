package com.assignment.Expense_Management.services;

import java.util.List;
import com.assignment.Expense_Management.entities.Bill;

public interface BillService {
    List<Bill> getAllBills();
    Bill getBillById(Long billId);
    Bill createBill(Bill bill);
    Bill updateBill(Long billId, Bill billDetails);
    void deleteBill(Long billId);
}