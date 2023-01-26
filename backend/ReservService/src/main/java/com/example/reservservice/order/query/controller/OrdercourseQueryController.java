package com.example.reservservice.order.query.controller;

import com.example.reservservice.order.data.Ordercourse;
import com.example.reservservice.order.query.query.ReadOrdercourseQuery;
import com.example.reservservice.restaurant.data.Restaurant;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrdercourseQueryController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public List<Ordercourse> getReview(){
        Object model = rabbitTemplate.convertSendAndReceive("ReservExchange", "readOrder", "");
        return ((List<Ordercourse>) model);
    }
}
