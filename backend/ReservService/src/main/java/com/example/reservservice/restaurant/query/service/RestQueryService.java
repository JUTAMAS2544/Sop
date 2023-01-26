package com.example.reservservice.restaurant.query.service;

import com.example.reservservice.restaurant.data.Restaurant;
import com.example.reservservice.restaurant.query.query.ReadRestQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestQueryService {
    @Autowired
    private QueryGateway queryGateway;

    @RabbitListener(queues = "ReadRest")
    public List<Restaurant> getRest (String s){
        ReadRestQuery query = new ReadRestQuery();
        List<Restaurant> models = queryGateway.query(query, ResponseTypes.multipleInstancesOf(Restaurant.class)).join();
        return models;
    }
}
