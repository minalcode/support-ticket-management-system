package com.ticket.support_ticket_management.Controller;

import com.ticket.support_ticket_management.Model.Ticket;
import com.ticket.support_ticket_management.Service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/status/{status}")
    public List<Ticket> getTicketsByStatus(
            @PathVariable String status
    ) {
        return ticketService.getTicketsByStatus(status);
    }

    @GetMapping("/priority/{priority}")
    public List<Ticket> getTicketsByPriority(
            @PathVariable String priority
    ) {
        return ticketService.getTicketsByPriority(priority);
    }

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }

    @PutMapping("/{id}/assign/{userId}")
    public Ticket assignTicket(
            @PathVariable Long id,
            @PathVariable Long userId
    ) {
        return ticketService.assignTicket(id, userId);
    }

    @PutMapping("/{id}/status/{status}")
    public Ticket updateStatus(
            @PathVariable Long id,
            @PathVariable String status
    ) {
        return ticketService.updateStatus(id, status);
    }
}