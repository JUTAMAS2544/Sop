package com.example.reservservice.restaurant.command.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
@Data
@Builder
public class UpdateRatingCommand {
    @TargetAggregateIdentifier
    private String rest_id;
    private Double rating;
    private String id;
}
