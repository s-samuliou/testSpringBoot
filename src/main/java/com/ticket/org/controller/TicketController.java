package com.ticket.org.controller;

import com.ticket.org.model.Ticket;
import com.ticket.org.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private static final Logger log = LoggerFactory.getLogger(TicketController.class);

    @Autowired
    private TicketService service;

    @GetMapping
    public List<Ticket> getAll() {
        log.info("Start method getAll in ticket controller");
        List<Ticket> tickets = service.findAll();
        log.debug("List all tickets is {}", tickets);
        log.info("End method getAll in ticket controller");
        return tickets;
    }

    @GetMapping("/{id}")
    public Ticket getById(@PathVariable(name = "id") int id) {
        log.info("Call method getbyId with id {} for ticket controller", id);
        return service.findById(id);
    }

    @PostMapping
    public Ticket create(@RequestBody Ticket ticket) {
        return service.save(ticket);
    }

    @GetMapping("/search")
    public List<Ticket> findByDestination(@RequestParam("destination") String destination) {
        return service.findByDestination(destination);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler
    public String handleExcep(Exception e) {
        return null;
    }
}
