package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Ticket {
    @Id
    public Long ticketId;

    public String subject;
    public String description;
    public String status;
    public String assignedTo;
}
