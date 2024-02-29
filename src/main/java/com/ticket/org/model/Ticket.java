package com.ticket.org.model;

public class Ticket extends TravelOption{

    private long id;
    private String source;
    private String destination;
    private double price;

    public Ticket() {
    }

    public Ticket(long id, String source, String destination, double price) {
        this.source = source;
        this.destination = destination;
        this.price = price;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
