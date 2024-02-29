package com.ticket.org.service;

import com.ticket.org.model.TravelTicket;

import java.util.List;

public interface TravelTicketService {

    List<TravelTicket> findAll();

    List<TravelTicket> findByPeriod(String period);

    TravelTicket save(TravelTicket ticket);

    TravelTicket findById(long id);
}
