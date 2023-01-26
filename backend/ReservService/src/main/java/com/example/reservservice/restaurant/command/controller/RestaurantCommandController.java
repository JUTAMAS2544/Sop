package com.example.reservservice.restaurant.command.controller;

import com.example.reservservice.restaurant.command.commands.UpdateRatingCommand;
import com.example.reservservice.restaurant.command.model.RatingModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RequestMapping("/rest")
@RestController
@CrossOrigin(origins = "*")
public class RestaurantCommandController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public String updateRating(@RequestBody RatingModel model)
    {
        Object result = rabbitTemplate.convertSendAndReceive("ReservExchange", "updateRating", model);
        return ((String) result);
    }
}
