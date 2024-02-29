package com.ticket.org.service;

import com.ticket.org.exceptions.TravelTicketInvalidArgumentException;
import com.ticket.org.exceptions.TravelTicketNotFoundException;
import com.ticket.org.model.TravelTicket;
import com.ticket.org.repository.TravelTicketJpaRepository;
import com.ticket.org.repository.TravelTicketRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class TravelTicketServiceImpl implements TravelTicketService {

    private static final Logger log = LoggerFactory.getLogger(TravelServiceImpl.class);

    @Autowired
    private TravelTicketJpaRepository repository;

    @Override
    public List<TravelTicket> findAll() {
        return repository.findAll();
    }

    @Override
    public List<TravelTicket> findByPeriod(String period) {
        if (period == null || period.isEmpty()) {
            throw new TravelTicketInvalidArgumentException("Period value " + period + " it is not correct");
        }

        return repository.findAllByPeriodOrderByPriceDesc(period);
    }

    @Override
    public TravelTicket save(TravelTicket ticket) {
        return repository.save(ticket);
    }

    @Override
    public TravelTicket findById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TravelTicketNotFoundException("Ticket with id " + id + " not found"));
    }
}
