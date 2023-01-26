package com.example.promotionservice.query.service;

import com.example.promotionservice.data.Promotion;
import com.example.promotionservice.query.query.ReadPromotionQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PromotionQueryService {
    @Autowired
    private QueryGateway queryGateway;

    @RabbitListener(queues = "ReadPromotion")
    public List<Promotion> getPromotion(){
        ReadPromotionQuery readPromotionQuery = new ReadPromotionQuery();
        List<Promotion> promotions = queryGateway.query(readPromotionQuery, ResponseTypes.multipleInstancesOf(Promotion.class)).join();
        return promotions;
    }
}
