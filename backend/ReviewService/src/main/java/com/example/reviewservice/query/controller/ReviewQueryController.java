package com.example.reviewservice.query.controller;

import com.example.reviewservice.data.Review;
import com.example.reviewservice.query.query.ReadRatingQuery;
import com.example.reviewservice.query.query.ReadReviewQuery;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/review")
@CrossOrigin(origins = "*")
public class ReviewQueryController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/get")
    public List<Review> getReview(@RequestBody ReadReviewQuery query){
        Object model = rabbitTemplate.convertSendAndReceive("ReviewExchange", "read", query);
        return ((List<Review>) model);
    }
    @PostMapping("/rating")
    public Double getRating(@RequestBody ReadRatingQuery query){
        Object model = rabbitTemplate.convertSendAndReceive("ReviewExchange", "rating", query);
        return ((Double) model);
    }
}
