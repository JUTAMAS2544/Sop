package com.example.promotionservice.data;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {
    @Autowired
    private PromotionRepository repository;

    @RabbitListener(queues = "UseCodePromotion")
    public Double useCode(String code){
        String id = repository.getIdByCode(code);
        Promotion promotion = repository.getById(id);
        if(promotion.getQuantity() >= 1){
            promotion.setQuantity(promotion.getQuantity()-1);
            repository.save(promotion);
            return promotion.getDiscount();
        }
        else {
            return 0.0;
        }
    }
}
