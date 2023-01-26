package com.example.reviewservice.query.service;

import com.example.reviewservice.data.Review;
import com.example.reviewservice.query.query.ReadRatingQuery;
import com.example.reviewservice.query.query.ReadReviewQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewQueryService {
    @Autowired
    private QueryGateway queryGateway;

    @RabbitListener(queues = "ReadReview")
    public List<Review> getReview(ReadReviewQuery query){
        List<Review> models = queryGateway.query(query, ResponseTypes.multipleInstancesOf(Review.class)).join();
        return models;
    }

    @RabbitListener(queues = "ReadRating")
    public Double getRating(ReadRatingQuery query){
        Double models = queryGateway.query(query, ResponseTypes.instanceOf(Double.class)).join();
        return models;
    }
}
