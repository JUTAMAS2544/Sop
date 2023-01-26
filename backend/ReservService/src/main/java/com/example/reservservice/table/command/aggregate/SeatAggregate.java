package com.example.reservservice.table.command.aggregate;

import com.example.reservservice.table.command.commands.UpdateSeatCommand;
import com.example.reservservice.table.command.event.SeatUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class SeatAggregate {
    @AggregateIdentifier
    private String table_id;
    private String status;
    private String rest_id;
    private Integer table_no;
    private String id;

    public SeatAggregate() {
    }

    @CommandHandler
    public SeatAggregate(UpdateSeatCommand command) {
        SeatUpdateEvent event = new SeatUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(SeatUpdateEvent event){
        this.table_id = event.getTable_id();
        this.status = event.getStatus();
        this.rest_id = event.getRest_id();
        this.table_no = event.getTable_no();
        this.id = event.getId();
    }
}
