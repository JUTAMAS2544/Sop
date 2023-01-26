package com.example.reviewservice.command.event;

import lombok.Data;

@Data
public class ReviewDeleteEvent {
    private String rv_id;
    private String id;
}
