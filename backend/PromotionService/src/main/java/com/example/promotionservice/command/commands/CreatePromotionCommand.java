package com.example.promotionservice.command.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreatePromotionCommand {
    @TargetAggregateIdentifier
    private String promotion_id;
    private String code;
    private Integer quantity;
    private Double discount;
}
