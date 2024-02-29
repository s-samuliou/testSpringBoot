package com.ticket.org.exceptions;

public class TravelTicketNotFoundException extends RuntimeException {

    public TravelTicketNotFoundException(String message) {
        super(message);
    }
}
