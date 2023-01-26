package com.example.reservservice.reservation.command.event;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;
@Data
public class ReservationUpdateEvent {
    private String reserv_id;
    private Date booking_date;
    private Date eating_date;
    private Time eating_time;
    private String status;
    private String user_id;
    private String rest_id;
    private String id;
}
