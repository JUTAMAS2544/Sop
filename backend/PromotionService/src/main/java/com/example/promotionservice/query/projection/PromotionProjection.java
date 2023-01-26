package com.example.promotionservice.query.projection;

import com.example.promotionservice.data.Promotion;
import com.example.promotionservice.data.PromotionRepository;
import com.example.promotionservice.query.query.ReadPromotionQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PromotionProjection {
    @Autowired
    private PromotionRepository repository;

    @QueryHandler
    public List<Promotion> handler(ReadPromotionQuery readPromotionQuery){
        List<Promotion> promotions = repository.findAll();
        return promotions;
    }
}
