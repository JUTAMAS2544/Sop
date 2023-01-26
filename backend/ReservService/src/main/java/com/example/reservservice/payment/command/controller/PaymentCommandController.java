package com.example.reservservice.payment.command.controller;

import com.example.reservservice.payment.command.commands.CreatePaymentCommand;
import com.example.reservservice.payment.command.model.PaymentRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "*")
public class PaymentCommandController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public String createPayment(
            @RequestBody PaymentRestModel model
    )
    {
        Object result = rabbitTemplate.convertSendAndReceive("ReservExchange", "createPayment", model);
        return ((String) result);
    }
}
