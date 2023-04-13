package com.assignment.Expense_Management.entities;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "source")
    private String source;
  
    @Column(name = "destination")
    private String destination;
  
    @Column(name = "booking_date")
    private LocalDate bookingDate;
}