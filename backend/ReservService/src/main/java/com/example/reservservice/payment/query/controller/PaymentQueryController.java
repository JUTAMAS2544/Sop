package com.example.reservservice.payment.query.controller;

import com.example.reservservice.payment.data.Payment;
import com.example.reservservice.payment.query.query.ReadPaymentQuery;
import com.example.reservservice.restaurant.data.Restaurant;
import com.example.reservservice.restaurant.query.query.ReadRestQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "*")
public class PaymentQueryController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public List<Payment> getPayment(){
        Object model = rabbitTemplate.convertSendAndReceive("ReservExchange", "readPayment", "");
        return ((List<Payment>) model);
    }
}
