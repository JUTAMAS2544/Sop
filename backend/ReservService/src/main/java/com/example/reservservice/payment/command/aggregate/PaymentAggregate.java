package com.example.reservservice.payment.command.aggregate;

import com.example.reservservice.payment.command.commands.CreatePaymentCommand;
import com.example.reservservice.payment.command.event.PaymentCreateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import javax.swing.*;
import java.sql.Date;
import java.sql.Time;

@Aggregate
public class PaymentAggregate {
    @AggregateIdentifier
    private String payment_id;
    private String image;
    private Date date;
    private Time time;
    private Double price;
    private String reserv_id;

    public PaymentAggregate() {
    }

    @CommandHandler
    public PaymentAggregate(CreatePaymentCommand command) {
        if(command.getDate() == null) {
            throw new IllegalArgumentException("Date can't be empty");
        }

        if(command.getTime() == null) {
            throw new IllegalArgumentException("Time can't be empty");
        }

        if(command.getPrice() <= 0) {
            throw new IllegalArgumentException("Price can't be less than or equal to 0");
        }

        PaymentCreateEvent event = new PaymentCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(PaymentCreateEvent event){
        this.payment_id = event.getPayment_id();
        this.image = event.getImage();
        this.date = event.getDate();
        this.time = event.getTime();
        this.price = event.getPrice();
        this.reserv_id = event.getReserv_id();
    }
}
