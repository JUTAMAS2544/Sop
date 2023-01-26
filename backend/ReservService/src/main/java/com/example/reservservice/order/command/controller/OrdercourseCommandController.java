package com.example.reservservice.order.command.controller;

import com.example.reservservice.order.command.commands.CreateOrdercourseCommand;
import com.example.reservservice.order.command.model.OrdercourseRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/order")
@RestController
@CrossOrigin(origins = "*")
public class OrdercourseCommandController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public String createReview(
            @RequestBody OrdercourseRestModel model
    )
    {
        Object result = rabbitTemplate.convertSendAndReceive("ReservExchange", "createOrder", model);
        return ((String) result);
    }
}
