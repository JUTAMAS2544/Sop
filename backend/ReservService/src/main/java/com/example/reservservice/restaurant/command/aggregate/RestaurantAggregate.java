package com.example.reservservice.restaurant.command.aggregate;

import com.example.reservservice.restaurant.command.commands.UpdateRatingCommand;
import com.example.reservservice.restaurant.command.event.UpdateRatingEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class RestaurantAggregate {
    @AggregateIdentifier
    private String rest_id;
    private Double rating;
    private String id;

    public RestaurantAggregate() {
    }
    @CommandHandler
    public RestaurantAggregate(UpdateRatingCommand command) {
        if(command.getRating() < 0) {
            throw new IllegalArgumentException("Rating can't be less than 0");
        }

        UpdateRatingEvent event = new UpdateRatingEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(UpdateRatingEvent event) {
        this.rest_id= event.getRest_id();
        this.rating = event.getRating();
        this.id = event.getId();
    }
}
