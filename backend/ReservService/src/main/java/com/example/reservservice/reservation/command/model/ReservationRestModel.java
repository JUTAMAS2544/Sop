package com.example.reservservice.reservation.command.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Data
@Builder
public class ReservationRestModel implements Serializable {
    private Date booking_date;
    private Date eating_date;
    private Time eating_time;
    private String user_id;
    private String rest_id;

}
