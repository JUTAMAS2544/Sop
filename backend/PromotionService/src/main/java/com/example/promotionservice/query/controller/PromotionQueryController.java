package com.example.promotionservice.query.controller;

import com.example.promotionservice.data.Promotion;
import com.example.promotionservice.query.query.ReadPromotionQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/promotion")
@CrossOrigin(origins = "*")
public class PromotionQueryController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public List<Promotion> getPromotion(){
        Object model = rabbitTemplate.convertSendAndReceive("PromotionExchange", "read", "");
        return ((List<Promotion>) model);
    }
}
