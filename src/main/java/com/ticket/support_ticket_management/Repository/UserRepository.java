package com.ticket.support_ticket_management.Repository;

import com.ticket.support_ticket_management.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}