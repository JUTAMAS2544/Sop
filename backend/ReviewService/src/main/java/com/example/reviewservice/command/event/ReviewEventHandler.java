package com.example.reviewservice.command.event;

import com.example.reviewservice.data.Review;
import com.example.reviewservice.data.ReviewRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewEventHandler {
    @Autowired
    private ReviewRepository repository;

    @EventHandler
    public void on(ReviewCreateEvent event){
        Review model = new Review();
        BeanUtils.copyProperties(event, model);
        repository.save(model);
    }

    @EventHandler
    public void on(ReviewUpdateEvent event){
        Review model = new Review();
        model.setRv_id(event.getId());
        model.setComment(event.getComment());
        model.setRating(event.getRating());
        model.setUser_id(event.getUser_id());
        model.setRest_id(event.getRest_id());
        repository.save(model);
    }

    @EventHandler
    public void on(ReviewDeleteEvent event){
        repository.deleteById(event.getId());
    }
}
