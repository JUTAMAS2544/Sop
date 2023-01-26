package com.example.reviewservice.query.projection;

import com.example.reviewservice.data.Review;
import com.example.reviewservice.data.ReviewRepository;
import com.example.reviewservice.query.query.ReadRatingQuery;
import com.example.reviewservice.query.query.ReadReviewQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ReviewProjection {
    @Autowired
    private ReviewRepository repository;

    @QueryHandler
    public List<Review> handler(ReadReviewQuery query){
        List<Review> models = repository.readByRestId(query.getRest_id());
        return models;
    }

    @QueryHandler
    public Double handler(ReadRatingQuery query){
        Double model = repository.readAllRating(query.getRest_id());
        return model;
    }
}
