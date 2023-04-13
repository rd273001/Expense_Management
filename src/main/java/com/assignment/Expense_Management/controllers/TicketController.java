package com.assignment.Expense_Management.controllers;

import java.util.List;

import com.assignment.Expense_Management.entities.Ticket;
import com.assignment.Expense_Management.exception.ResourceNotFoundException;
import com.assignment.Expense_Management.repositories.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {
  
  @Autowired
  private TicketRepository ticketRepository;

  @GetMapping
  public List<Ticket> getAllTickets() {
    return ticketRepository.findAll();
  }
  
  @PostMapping("/add")
  public Ticket createTicket(@RequestBody Ticket ticket) {
    return ticketRepository.save(ticket);
  }
  
  @GetMapping("/{id}")
  public Ticket getTicketById(@PathVariable Long id) {
    return ticketRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
            "Train ticket not found with id " + id,"id",id));
  }
  
}
