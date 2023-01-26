package com.example.promotionservice.command.event;

import com.example.promotionservice.data.Promotion;
import com.example.promotionservice.data.PromotionRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PromotionEventHandler {
    @Autowired
    private PromotionRepository repository;

    @EventHandler
    public void on(PromotionCreateEvent event){
        Promotion promotion = new Promotion();
        BeanUtils.copyProperties(event, promotion);
        repository.save(promotion);
    }

    @EventHandler
    public void on(PromotionUpdateEvent event){
        Promotion promotion = new Promotion();
        promotion.setPromotion_id(event.getId());
        promotion.setCode(event.getCode());
        promotion.setQuantity(event.getQuantity());
        promotion.setDiscount(event.getDiscount());
        repository.save(promotion);
    }

    @EventHandler
    public void on(PromotionDeleteEvent event){
        repository.deleteById(event.getId());
    }
}
