package com.ticket.org.controller;

import com.ticket.org.exceptions.TravelTicketInvalidArgumentException;
import com.ticket.org.exceptions.TravelTicketNotFoundException;
import com.ticket.org.model.TravelTicket;
import com.ticket.org.service.TravelTicketService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/travel_tickets")
public class TravelTicketController {

    @Autowired
    private TravelTicketService service;

    @GetMapping
    public List<TravelTicket> getAll() {
        return service.findAll();
    }

    @GetMapping("/search")
    public List<TravelTicket> getAllByPeriod(@RequestParam(name = "Period") String period) {
        return service.findByPeriod(period);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id) {
        //  try {
        TravelTicket ticket = service.findById(id);
        return ResponseEntity.ok(ticket);
        //  } catch (TravelTicketNotFoundException exception) {
        //      return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        //  }
    }

    @PostMapping
    public TravelTicket create(@RequestBody TravelTicket ticket) {
        return service.save(ticket);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({TravelTicketInvalidArgumentException.class,
            TravelTicketNotFoundException.class})
    public String handleInvalidArgumentException(Exception exception) {
        return exception.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public Map<String, String> handleInvalidArgumentException(ValidationException exception) {
        if (exception instanceof ConstraintViolationException) {
            Map<String, String> map = new HashMap<>();
            ConstraintViolationException violationException = (ConstraintViolationException) exception;
            Set<ConstraintViolation<?>> constraintViolations = violationException.getConstraintViolations();
            constraintViolations.forEach(constraintViolation -> {
                Path propertyPath = constraintViolation.getPropertyPath();
                String message = constraintViolation.getMessage();
                Object invalidValue = constraintViolation.getInvalidValue();
                map.put(propertyPath.toString(), message + " " + invalidValue.toString());
            });
            return map;
        }

        return new HashMap<>();
    }
}
