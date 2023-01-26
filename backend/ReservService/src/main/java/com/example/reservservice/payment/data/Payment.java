package com.example.reservservice.payment.data;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
public class Payment implements Serializable {
    @Id
    private String payment_id;
    private String image;
    private Date date;
    private Time time;
    private Double price;
    private String reserv_id;
}
