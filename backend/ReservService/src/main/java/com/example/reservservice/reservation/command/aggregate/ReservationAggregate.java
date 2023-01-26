package com.example.reservservice.reservation.command.aggregate;

import com.example.reservservice.reservation.command.commands.CreateReservationCommand;
import com.example.reservservice.reservation.command.commands.UpdateReservationCommand;
import com.example.reservservice.reservation.command.event.ReservationCreateEvent;
import com.example.reservservice.reservation.command.event.ReservationUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.sql.Date;
import java.sql.Time;

@Aggregate
public class ReservationAggregate {
    @AggregateIdentifier
    private String reserv_id;
    private Date booking_date;
    private Date eating_date;
    private Time eating_time;
    private String status;
    private String user_id;
    private String rest_id;
    private String id;

    public ReservationAggregate() {
    }
    @CommandHandler
    public ReservationAggregate(CreateReservationCommand command) {
        if(command.getEating_date() == null) {
            throw new IllegalArgumentException("Date can't be empty");
        }

        if(command.getEating_time() == null) {
            throw new IllegalArgumentException("Time can't be empty");
        }

        ReservationCreateEvent event = new ReservationCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ReservationCreateEvent event) {
        this.reserv_id = event.getReserv_id();
        this.booking_date = event.getBooking_date();
        this.eating_date = event.getEating_date();
        this.eating_time = event.getEating_time();
        this.status = event.getStatus();
        this.user_id = event.getUser_id();
    }

    @CommandHandler
    public ReservationAggregate(UpdateReservationCommand command) {
        if(command.getEating_date() == null) {
            throw new IllegalArgumentException("Date can't be empty");
        }

        if(command.getEating_time() == null) {
            throw new IllegalArgumentException("Time can't be empty");
        }

        ReservationUpdateEvent event = new ReservationUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ReservationUpdateEvent event) {
        this.reserv_id = event.getReserv_id();
        this.booking_date = event.getBooking_date();
        this.eating_date = event.getEating_date();
        this.eating_time = event.getEating_time();
        this.status = event.getStatus();
        this.user_id = event.getUser_id();
        this.id = event.getId();
    }
}
