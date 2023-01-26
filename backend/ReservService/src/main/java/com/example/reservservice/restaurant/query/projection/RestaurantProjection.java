package com.example.reservservice.restaurant.query.projection;

import com.example.reservservice.restaurant.data.Restaurant;
import com.example.reservservice.restaurant.data.RestaurantRepository;
import com.example.reservservice.restaurant.query.query.ReadRestQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestaurantProjection {
    @Autowired
    private RestaurantRepository repository;
    @QueryHandler
    public List<Restaurant> handler(ReadRestQuery query){
        List<Restaurant> models = repository.findAll();
        return models;
    }
}
