package com.assignment.Expense_Management.entities;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bill")
public class Bill {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "invoice_date")
  private LocalDate invoiceDate;
  
  @Column(name = "expense")
  private String expense;
  
  @Column(name = "amount")
  private Double amount;

}