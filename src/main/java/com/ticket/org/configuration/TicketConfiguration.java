package com.ticket.org.configuration;

import com.ticket.org.service.TravelTicketServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TicketConfiguration {

    @Bean
    public TravelTicketServiceImpl travelTicketService() {
        return new TravelTicketServiceImpl();
    }
}
