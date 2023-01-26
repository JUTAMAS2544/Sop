package com.example.reviewservice.command.controller;

import com.example.reviewservice.command.model.DeleteModel;
import com.example.reviewservice.command.model.ReviewRestModel;
import com.example.reviewservice.data.Review;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
@CrossOrigin(origins = "*")
public class ReviewCommandController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public String createReview(@RequestBody ReviewRestModel model)
    {
        Object result = rabbitTemplate.convertSendAndReceive("ReviewExchange", "create", model);
        return ((String) result);
    }

    @PutMapping
    public String updateReview(@RequestBody Review model){
        Object result = rabbitTemplate.convertSendAndReceive("ReviewExchange", "update", model);
        return ((String) result);
    }

    @DeleteMapping
    public String deleteReview(@RequestBody DeleteModel model){
        Object result = rabbitTemplate.convertSendAndReceive("ReviewExchange", "delete", model);
        return ((String) result);
    }

}
