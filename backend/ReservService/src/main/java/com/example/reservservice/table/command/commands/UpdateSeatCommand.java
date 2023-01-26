package com.example.reservservice.table.command.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class UpdateSeatCommand {
    @TargetAggregateIdentifier
    private String table_id;
    private String status;
    private String rest_id;
    private Integer table_no;
    private String id;
}
