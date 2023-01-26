package com.example.reservservice.reservation.query.controller;

import com.example.reservservice.reservation.data.Reservation;
import com.example.reservservice.reservation.query.query.ReadReservationQuery;
import com.example.reservservice.restaurant.data.Restaurant;
import lombok.Data;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins = "*")
public class ReservationController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public List<Reservation> getReservation(){
        Object model = rabbitTemplate.convertSendAndReceive("ReservExchange", "readResv", "");
        return ((List<Reservation>) model);
    }
}
