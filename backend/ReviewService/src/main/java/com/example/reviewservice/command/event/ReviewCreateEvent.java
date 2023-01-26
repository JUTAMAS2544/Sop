package com.example.reviewservice.command.event;

import lombok.Data;

@Data
public class ReviewCreateEvent {
    private String rv_id;
    private String comment;
    private String rest_id;
    private String user_id;
    private Integer rating;
}
