package com.example.reservservice.order.command.event;

import lombok.Data;

@Data
public class OrdercourseCreateEvent {
    private String order_id;
    private Double price;
    private Double discount;
    private Double total_price;
    private String reserv_id;
}
