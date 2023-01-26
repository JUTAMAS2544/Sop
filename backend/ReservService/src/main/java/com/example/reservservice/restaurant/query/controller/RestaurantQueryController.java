package com.example.reservservice.restaurant.query.controller;

import com.example.reservservice.restaurant.data.Restaurant;
import com.example.reservservice.restaurant.query.query.ReadRestQuery;
import com.example.reservservice.table.data.Seat;
import com.example.reservservice.table.query.query.ReadSeatQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
@CrossOrigin(origins = "*")
public class RestaurantQueryController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @GetMapping
    public List<Restaurant> getRest (){
        Object model = rabbitTemplate.convertSendAndReceive("ReservExchange", "readRest", "");
        return ((List<Restaurant>) model);
    }
}
