package com.ticket.org.repository;

import com.ticket.org.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public class TicketDao implements TicketRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private BeanPropertyRowMapper<Ticket> beanPropertyRowMapper = new BeanPropertyRowMapper<>(Ticket.class);

    @Override
    public List<Ticket> findAll() {
        String sql = "SELECT * FROM TICKET";
        return jdbcTemplate.query(sql,
                beanPropertyRowMapper);
    }

    @Override
    public Ticket findById(long id) {
        String sql = "Select * from ticket where id = ?";
        Ticket ticket = jdbcTemplate.queryForObject(sql,
                beanPropertyRowMapper,
                id);
        return ticket;
    }

    @Override
    public Ticket save(Ticket ticket) {
        String sql = "INSERT INTO ticket (source,destination, price) VALUES (?,?,?)";
        int update = jdbcTemplate.update(sql, ticket.getSource(), ticket.getDestination(), ticket.getPrice());
        String sqlLastTicket = "select * from ticket where id = select max(id) from ticket";
        return jdbcTemplate.queryForObject(sqlLastTicket, beanPropertyRowMapper);
    }

    @Override
    public List<Ticket> findByDestination(String destination) {
        String sql = "SELECT * FROM TICKET where destination = ?";
        return jdbcTemplate.query(sql,
                beanPropertyRowMapper, destination);
    }
}
