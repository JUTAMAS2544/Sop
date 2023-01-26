package com.example.reservservice.payment.command.event;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;

@Data
public class PaymentCreateEvent {
    private String payment_id;
    private String image;
    private Date date;
    private Time time;
    private Double price;
    private String reserv_id;
}
