package com.example.reservservice.restaurant.command.event;

import lombok.Data;

@Data
public class UpdateRatingEvent {
    private String rest_id;
    private Double rating;
    private String id;
}
