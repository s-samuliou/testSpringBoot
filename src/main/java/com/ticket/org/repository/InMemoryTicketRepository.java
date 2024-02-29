package com.ticket.org.repository;

import com.ticket.org.model.Ticket;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class InMemoryTicketRepository implements TicketRepository{

    private Map<Long, Ticket> base = new HashMap<>();

    @PostConstruct
    private void init() {
        base.put(1L, new Ticket(1L, "Berlin", "Paris", 100.25));
        base.put(2L, new Ticket(2L, "Paris", "Hamburg", 150.30));
        base.put(3L, new Ticket(3L, "Bonn", "Hamburg", 90.10));
    }

    @Override
    public List<Ticket> findAll() {
        return new ArrayList<>(base.values());
    }

    @Override
    public Ticket findById(long id) {
        return base.get(id);
    }

    @Override
    public Ticket save(Ticket ticket) {
        Long currentIndex = base.keySet()
                .stream()
                .sorted(Comparator.reverseOrder())
                .findFirst().get();
        ticket.setId(++currentIndex);
        base.put(ticket.getId(), ticket);
        return ticket;
    }

    @Override
    public List<Ticket> findByDestination(String destination) {
        return null;
    }
}
