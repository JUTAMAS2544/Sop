package com.example.reservservice.reservation.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
public class Reservation implements Serializable {
    @Id
    private String reserv_id;
    private Date booking_date;
    private Date eating_date;
    private Time eating_time;
    private String status;
    private String user_id;
    private String rest_id;

}
