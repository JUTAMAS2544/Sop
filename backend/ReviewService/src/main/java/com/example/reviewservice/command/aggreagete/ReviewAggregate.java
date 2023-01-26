package com.example.reviewservice.command.aggreagete;

import com.example.reviewservice.command.commands.CreateReviewCommand;
import com.example.reviewservice.command.commands.DeleteReviewCommand;
import com.example.reviewservice.command.commands.UpdateReviewCommand;
import com.example.reviewservice.command.event.ReviewCreateEvent;
import com.example.reviewservice.command.event.ReviewDeleteEvent;
import com.example.reviewservice.command.event.ReviewUpdateEvent;
import com.example.reviewservice.data.Review;
import com.example.reviewservice.data.ReviewRepository;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

@Aggregate
public class ReviewAggregate {
    @Autowired
    private ReviewRepository repository;
    @AggregateIdentifier
    private String rv_id;
    private String comment;
    private String rest_id;
    private String user_id;
    private Integer rating;
    private String id;

    public ReviewAggregate() {
    }

    @CommandHandler
    public ReviewAggregate(CreateReviewCommand command) {
        if(command.getComment() == null || command.getComment().isBlank()) {
            throw new IllegalArgumentException("Comment can't be empty");
        }

        ReviewCreateEvent event = new ReviewCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ReviewCreateEvent event) {
        this.rv_id = event.getRv_id();
        this.comment = event.getComment();
        this.rating = event.getRating();
        this.user_id = event.getUser_id();
        this.rest_id = event.getRest_id();

    }

    @CommandHandler
    public ReviewAggregate(UpdateReviewCommand command) {
        if(command.getComment() == null || command.getComment().isBlank()) {
            throw new IllegalArgumentException("Comment can't be empty");
        }

        ReviewUpdateEvent event = new ReviewUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ReviewUpdateEvent event){
        this.rv_id = event.getRv_id();
        this.comment = event.getComment();
        this.rating = event.getRating();
        this.user_id = event.getUser_id();
        this.rest_id = event.getRest_id();
        this.id = event.getId();
    }

    @CommandHandler
    public ReviewAggregate(DeleteReviewCommand command) {
        ReviewDeleteEvent event = new ReviewDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ReviewDeleteEvent event){
        this.rv_id = event.getRv_id();
        this.id = event.getId();
    }
}
