package com.example.reservservice.table.query.service;

import com.example.reservservice.table.data.Seat;
import com.example.reservservice.table.query.query.ReadSeatQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableQueryService {
    @Autowired
    private QueryGateway queryGateway;

    @RabbitListener(queues = "ReadTable")
    public List<Seat> getSeat(ReadSeatQuery query){
        List<Seat> models = queryGateway.query(query, ResponseTypes.multipleInstancesOf(Seat.class)).join();
        return models;
    }
}
