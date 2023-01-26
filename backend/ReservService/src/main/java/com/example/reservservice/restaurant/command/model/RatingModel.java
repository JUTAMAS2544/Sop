package com.example.reservservice.restaurant.command.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class RatingModel implements Serializable {
    private String rest_id;
    private Double rating;

}
