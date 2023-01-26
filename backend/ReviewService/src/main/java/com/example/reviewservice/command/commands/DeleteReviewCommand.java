package com.example.reviewservice.command.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class DeleteReviewCommand {
    @TargetAggregateIdentifier
    private String rv_id;
    private String id;
}
