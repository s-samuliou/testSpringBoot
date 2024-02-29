package com.ticket.org.repository;

import com.ticket.org.TicketApp;
import com.ticket.org.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketRepository {

    List<Ticket> findAll();

    Ticket findById(long id);

    Ticket save(Ticket ticket);

    List<Ticket> findByDestination(String destinations);
}
