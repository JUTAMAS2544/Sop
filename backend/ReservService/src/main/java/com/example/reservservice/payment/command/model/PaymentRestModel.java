package com.example.reservservice.payment.command.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Data
@Builder
public class PaymentRestModel implements Serializable {
    private String image;
    private Date date;
    private Time time;
    private Double price;
    private String reserv_id;
}
