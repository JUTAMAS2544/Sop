package com.example.reservservice.table.command.controller;

import com.example.reservservice.table.command.commands.UpdateSeatCommand;
import com.example.reservservice.table.data.Seat;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/seat")
@CrossOrigin(origins = "*")
public class SeatCommandController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @PutMapping
    public String updateSeat(@RequestBody Seat model){
        Object result = rabbitTemplate.convertSendAndReceive("ReservExchange", "updateTable", model);
        return ((String) result);
    }
}
