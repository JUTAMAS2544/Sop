package com.example.reservservice.order.query.service;

import com.example.reservservice.order.data.Ordercourse;
import com.example.reservservice.order.query.query.ReadOrdercourseQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class OrderQueryService {
    @Autowired
    private QueryGateway queryGateway;

    @RabbitListener(queues = "ReadOrder")
    public List<Ordercourse> getReview(String s){
        ReadOrdercourseQuery query = new ReadOrdercourseQuery();
        List<Ordercourse> models = queryGateway.query(query, ResponseTypes.multipleInstancesOf(Ordercourse.class)).join();
        return models;
    }
}
