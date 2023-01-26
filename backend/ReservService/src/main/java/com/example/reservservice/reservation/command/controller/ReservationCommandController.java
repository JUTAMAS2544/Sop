package com.example.reservservice.reservation.command.controller;

import com.example.reservservice.reservation.command.commands.CreateReservationCommand;
import com.example.reservservice.reservation.command.commands.UpdateReservationCommand;
import com.example.reservservice.reservation.command.model.ReservationRestModel;
import com.example.reservservice.reservation.data.Reservation;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RequestMapping("/reservation")
@RestController
@CrossOrigin(origins = "*")
public class ReservationCommandController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public String createReservation(
            @RequestBody ReservationRestModel model
    )
    {
        Object result = rabbitTemplate.convertSendAndReceive("ReservExchange", "createResv", model);
        return ((String) result);
    }

    @PutMapping
    public String updateReservation(
            @RequestBody Reservation model
    )
    {
        Object result = rabbitTemplate.convertSendAndReceive("ReservExchange", "updateResv", model);
        return ((String) result);
    }
}
