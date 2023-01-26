package com.example.reservservice.order.query.projection;

import com.example.reservservice.order.data.Ordercourse;
import com.example.reservservice.order.data.OrdercourseRepository;
import com.example.reservservice.order.query.query.ReadOrdercourseQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class OrdercourseProjection {
    @Autowired
    private OrdercourseRepository repository;

    @QueryHandler
    public List<Ordercourse> handler(ReadOrdercourseQuery query){
        List<Ordercourse> models = repository.findAll();
        return models;
    }
}
