package com.ticket.support_ticket_management.Service;

import com.ticket.support_ticket_management.Model.Ticket;
import com.ticket.support_ticket_management.Repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(Ticket ticket) {

        ticket.setStatus("OPEN");
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setUpdatedAt(LocalDateTime.now());

        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) {

        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    public List<Ticket> getTicketsByStatus(String status) {
        return ticketRepository.findByStatus(status);
    }

    public List<Ticket> getTicketsByPriority(String priority) {
        return ticketRepository.findByPriority(priority);
    }

    public Ticket assignTicket(Long ticketId, Long userId) {

        Ticket ticket = getTicketById(ticketId);

        ticket.setAssignedTo(userId);
        ticket.setUpdatedAt(LocalDateTime.now());

        return ticketRepository.save(ticket);
    }

    public Ticket updateStatus(Long id, String status) {

        Ticket ticket = getTicketById(id);

        ticket.setStatus(status);
        ticket.setUpdatedAt(LocalDateTime.now());

        return ticketRepository.save(ticket);
    }
}