package com.ticket.org.repository;

import com.ticket.org.model.Ticket;
import com.ticket.org.model.TravelTicket;

import java.util.List;

public interface TravelTicketRepository {

    List<TravelTicket> findAll();
    TravelTicket findByPeriod(String period);
}
