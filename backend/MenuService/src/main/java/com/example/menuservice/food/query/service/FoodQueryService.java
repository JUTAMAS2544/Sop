package com.example.menuservice.food.query.service;

import com.example.menuservice.food.data.Food;
import com.example.menuservice.food.query.query.ReadFoodQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodQueryService {
    @Autowired
    private QueryGateway queryGateway;

    @RabbitListener(queues = "ReadFood")
    public List<Food> getFood(String s){
        ReadFoodQuery query = new ReadFoodQuery();
        List<Food> foods = queryGateway.query(query, ResponseTypes.multipleInstancesOf(Food.class)).join();
        return foods;
    }
}
