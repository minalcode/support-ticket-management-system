package com.ticket.support_ticket_management.Repository;

import com.ticket.support_ticket_management.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByStatus(String status);

    List<Ticket> findByPriority(String priority);
}