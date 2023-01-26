package com.example.reservservice.restaurant.command.event;

import com.example.reservservice.restaurant.data.Restaurant;
import com.example.reservservice.restaurant.data.RestaurantRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurantEventHandler {
    @Autowired
    private RestaurantRepository repository;

    @EventHandler
    public void on(UpdateRatingEvent event){
        Restaurant model = repository.readByRestId(event.getId());
        model.setRating(event.getRating());
        repository.save(model);
    }
}
