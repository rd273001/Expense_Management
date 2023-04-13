package com.assignment.Expense_Management.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.Expense_Management.entities.Bill;
import com.assignment.Expense_Management.exception.ResourceNotFoundException;
import com.assignment.Expense_Management.repositories.BillRepository;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public Bill getBillById(Long billId) {
        return billRepository.findById(billId)
                .orElseThrow(() -> new ResourceNotFoundException("Bill", "id", billId));
    }

    @Override
    public Bill createBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Bill updateBill(Long billId, Bill billDetails) {
        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new ResourceNotFoundException("Bill", "id", billId));

        bill.setExpense(billDetails.getExpense());
        bill.setAmount(billDetails.getAmount());
        bill.setInvoiceDate(billDetails.getInvoiceDate());

        return billRepository.save(bill);
    }

    @Override
    public void deleteBill(Long billId) {
        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new ResourceNotFoundException("Bill", "id", billId));

        billRepository.delete(bill);
    }
}
