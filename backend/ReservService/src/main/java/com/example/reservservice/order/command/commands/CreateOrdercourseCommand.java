package com.example.reservservice.order.command.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateOrdercourseCommand {
    @TargetAggregateIdentifier
    private String order_id;
    private Double price;
    private Double discount;
    private Double total_price;
    private String reserv_id;
}
