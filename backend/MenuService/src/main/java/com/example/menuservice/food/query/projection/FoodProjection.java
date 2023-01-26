package com.example.menuservice.food.query.projection;

import com.example.menuservice.food.data.Food;
import com.example.menuservice.food.data.FoodRepository;
import com.example.menuservice.food.query.query.ReadFoodQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class FoodProjection {
    @Autowired
    private FoodRepository repository;

    @QueryHandler
    public List<Food> handler(ReadFoodQuery query){
        List<Food> foods = repository.findAll();
        return foods;
    }
}
