package com.example.promotionservice.command.event;

import lombok.Data;

@Data
public class PromotionDeleteEvent {
    private String promotion_id;
    private String id;
}
