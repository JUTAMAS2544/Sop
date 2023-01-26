package com.example.promotionservice.command.event;

import lombok.Data;

@Data
public class PromotionCreateEvent {
    private String promotion_id;
    private String code;
    private Integer quantity;
    private Double discount;
}
