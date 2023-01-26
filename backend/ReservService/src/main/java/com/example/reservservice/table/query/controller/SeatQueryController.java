package com.example.reservservice.table.query.controller;

import com.example.reservservice.table.data.Seat;
import com.example.reservservice.table.query.query.ReadSeatQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/seat")
@RestController
@CrossOrigin(origins = "*")
public class SeatQueryController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @PostMapping
    public List<Seat> getSeat(@RequestBody ReadSeatQuery query){
        Object model = rabbitTemplate.convertSendAndReceive("ReservExchange", "readTable", query);
        return ((List<Seat>) model);
    }

}
