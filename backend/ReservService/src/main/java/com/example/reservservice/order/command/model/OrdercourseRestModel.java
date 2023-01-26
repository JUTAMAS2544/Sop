package com.example.reservservice.order.command.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class OrdercourseRestModel implements Serializable {
    private Double price;
    private Double discount;
    private Double total_price;
    private String reserv_id;
}
