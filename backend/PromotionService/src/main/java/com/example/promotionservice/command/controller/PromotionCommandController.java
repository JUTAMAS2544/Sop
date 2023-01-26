package com.example.promotionservice.command.controller;

import com.example.promotionservice.command.model.PromotionRestModel;
import com.example.promotionservice.command.model.DeleteModel;
import com.example.promotionservice.command.model.UseCodeModel;
import com.example.promotionservice.data.Promotion;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/promotion")
@CrossOrigin(origins = "*")
public class PromotionCommandController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public String createPromotion(@RequestBody PromotionRestModel model)
    {
        Object result = rabbitTemplate.convertSendAndReceive("PromotionExchange", "create", model);
        return ((String) result);
    }

    @PutMapping
    public String updatePromotion(@RequestBody Promotion model){
        Object result = rabbitTemplate.convertSendAndReceive("PromotionExchange", "update", model);
        return ((String) result);
    }

    @DeleteMapping()
    public String deletePromotion(@RequestBody DeleteModel model){
        Object result = rabbitTemplate.convertSendAndReceive("PromotionExchange", "delete", model);
        return ((String) result);
    }

    @PutMapping("/usecode")
    public Double useCode(@RequestBody UseCodeModel model){
        Object result = rabbitTemplate.convertSendAndReceive("PromotionExchange", "code", model.getCode());
        return ((Double) result);
    }
}
