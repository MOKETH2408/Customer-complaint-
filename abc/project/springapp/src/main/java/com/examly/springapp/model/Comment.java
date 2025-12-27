package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Comment {
    @Id
    public Long commentId;

    public String content;
    public String createdDate;
    public String ticket;
}
