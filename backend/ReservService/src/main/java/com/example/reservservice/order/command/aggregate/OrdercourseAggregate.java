package com.example.reservservice.order.command.aggregate;

import com.example.reservservice.order.command.commands.CreateOrdercourseCommand;
import com.example.reservservice.order.command.event.OrdercourseCreateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class OrdercourseAggregate {
    @AggregateIdentifier
    private String order_id;
    private Double price;
    private Double discount;
    private Double total_price;
    private String reserv_id;

    public OrdercourseAggregate() {
    }

    @CommandHandler
    public OrdercourseAggregate(CreateOrdercourseCommand command) {
        OrdercourseCreateEvent event = new OrdercourseCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(OrdercourseCreateEvent event) {
        this.order_id = event.getOrder_id();
        this.price = event.getPrice();
        this.discount = event.getDiscount();
        this.total_price = event.getTotal_price();
        this.reserv_id = event.getReserv_id();
    }
}
