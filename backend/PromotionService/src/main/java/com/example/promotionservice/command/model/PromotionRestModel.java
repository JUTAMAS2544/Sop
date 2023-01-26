package com.example.promotionservice.command.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class PromotionRestModel implements Serializable {
    private String code;
    private Integer quantity;
    private Double discount;
}
