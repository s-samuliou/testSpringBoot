package com.ticket.org.service;

import com.ticket.org.model.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> findAll();

    Ticket findById(long id);

    Ticket save(Ticket ticket);

    List<Ticket> findByDestination(String destinations);
}
