package com.assignment.Expense_Management.services;

import java.util.List;

import com.assignment.Expense_Management.entities.Ticket;

public interface TicketService {

    List<Ticket> getAllTickets();
    Ticket getTicketById(Long ticketId);
    Ticket createTicket(Ticket ticket);
    Ticket updateTicket(Long ticketId, Ticket ticketDetails);
    void deleteTicket(Long ticketId);

}