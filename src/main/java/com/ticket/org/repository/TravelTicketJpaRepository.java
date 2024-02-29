package com.ticket.org.repository;


import com.ticket.org.model.TravelTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TravelTicketJpaRepository extends JpaRepository<TravelTicket, Long> {

    //Select * from travel_ticket where period = :period order by price desc;
    List<TravelTicket> findAllByPeriodOrderByPriceDesc(String period);

    Optional<TravelTicket> findById(long id);

//    @Query("SELECT tt.price FROM TravelTicket as tt where tt.id = :sss")
//    TravelTicket findBySuper(String sss);
}