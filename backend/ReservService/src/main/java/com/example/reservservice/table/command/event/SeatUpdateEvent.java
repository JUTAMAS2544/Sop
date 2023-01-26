package com.example.reservservice.table.command.event;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
@Data
public class SeatUpdateEvent {
    private String table_id;
    private String status;
    private String rest_id;
    private Integer table_no;
    private String id;
}
