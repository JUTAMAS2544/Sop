package com.example.reservservice.reservation.command.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.sql.Date;
import java.sql.Time;

@Data
@Builder
public class UpdateReservationCommand {
    @TargetAggregateIdentifier
    private String reserv_id;
    private Date booking_date;
    private Date eating_date;
    private Time eating_time;
    private String status;
    private String user_id;
    private String rest_id;
    private String id;
}
