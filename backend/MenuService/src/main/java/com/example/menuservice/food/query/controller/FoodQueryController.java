package com.example.menuservice.food.query.controller;

import com.example.menuservice.food.data.Food;
import com.example.menuservice.food.query.query.ReadFoodQuery;
import org.axonframework.commandhandling.gateway.CommandGateway;
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
@RequestMapping("/food")
@CrossOrigin(origins = "*")
public class FoodQueryController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public List<Food> getFood(){
        Object model = rabbitTemplate.convertSendAndReceive("MenuExchange", "readFood", "");
        return ((List<Food>) model);
    }
}
