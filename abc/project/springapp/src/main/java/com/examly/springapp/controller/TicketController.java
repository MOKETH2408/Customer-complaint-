package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Ticket;
import com.examly.springapp.repository.TicketRepo;

@RestController
@RequestMapping("/user")
public class TicketController {
    @Autowired
    private TicketRepo ticketRepo;

    @GetMapping("/{ticketId}")
    public Ticket disp(@PathVariable int ticketId)
    {
        return ticketRepo.findById(ticketId).orElse(null);
    }
}
