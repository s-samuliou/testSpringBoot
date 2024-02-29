package com.ticket.org.service;

import com.ticket.org.model.Ticket;
import com.ticket.org.model.TravelOption;
import com.ticket.org.model.TravelTicket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TravelServiceImpl implements TravelService {
    //Сервис может обращаться только к своим репозиториям
    //Сервис не может обращаться к другим репозиториям, только к сервисам

    private static final Logger log = LoggerFactory.getLogger(TravelServiceImpl.class);

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TravelTicketService travelTicketService;

    public List<TravelOption> getAllTravelOptions() {
        List<TravelOption> options = new ArrayList<>();
        options.addAll(ticketService.findAll());
        options.addAll(travelTicketService.findAll());
        return options;
    }
}
