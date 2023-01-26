package com.example.reviewservice.command.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
@Data
@Builder
public class CreateReviewCommand {
    @TargetAggregateIdentifier
    private String rv_id;
    private String comment;
    private String rest_id;
    private String user_id;
    private Integer rating;
}
