package com.example.promotionservice.command.aggregate;

import com.example.promotionservice.command.commands.CreatePromotionCommand;
import com.example.promotionservice.command.commands.DeletePromotionCommand;
import com.example.promotionservice.command.commands.UpdatePromotionCommand;
import com.example.promotionservice.command.event.PromotionCreateEvent;
import com.example.promotionservice.command.event.PromotionDeleteEvent;
import com.example.promotionservice.command.event.PromotionUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class PromotionAggregate {
    @AggregateIdentifier
    private String promotion_id;
    private String code;
    private Integer quantity;
    private Double discount;
    private String id;

    public PromotionAggregate() {
    }

    @CommandHandler
    public PromotionAggregate(CreatePromotionCommand command) {
        if(command.getCode() == null || command.getCode().isBlank()) {
            throw new IllegalArgumentException("Code can't be empty");
        }

        if(command.getQuantity() <= 0){
            throw new IllegalArgumentException("Quantity can't be less than or equal to 0");
        }

        if(command.getDiscount() <= 0){
            throw new IllegalArgumentException("Discount can't be less than or equal to 0");
        }

        PromotionCreateEvent event = new PromotionCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public PromotionAggregate(UpdatePromotionCommand command) {
        if(command.getCode() == null || command.getCode().isBlank()) {
            throw new IllegalArgumentException("Code can't be empty");
        }

        if(command.getQuantity() <= 0){
            throw new IllegalArgumentException("Quantity can't be less than or equal to 0");
        }

        if(command.getDiscount() <= 0){
            throw new IllegalArgumentException("Discount can't be less than or equal to 0");
        }

        PromotionUpdateEvent event = new PromotionUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public PromotionAggregate(DeletePromotionCommand command) {
        PromotionDeleteEvent event = new PromotionDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(PromotionCreateEvent event){
        this.promotion_id = event.getPromotion_id();
        this.code = event.getCode();
        this.quantity = event.getQuantity();
        this.discount = event.getDiscount();
    }

    @EventSourcingHandler
    public void on(PromotionUpdateEvent event){
        this.promotion_id = event.getPromotion_id();
        this.code = event.getCode();
        this.quantity = event.getQuantity();
        this.discount = event.getDiscount();
        this.id = event.getId();
    }

    @EventSourcingHandler
    public void on(PromotionDeleteEvent event){
        this.promotion_id = event.getPromotion_id();
        this.id = event.getId();
    }
}
