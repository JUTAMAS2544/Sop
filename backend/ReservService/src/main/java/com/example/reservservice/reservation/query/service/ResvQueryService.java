package com.example.reservservice.reservation.query.service;

import com.example.reservservice.reservation.data.Reservation;
import com.example.reservservice.reservation.query.query.ReadReservationQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ResvQueryService {
    @Autowired
    private QueryGateway queryGateway;

    @RabbitListener(queues = "ReadResv")
    public List<Reservation> getReservation(String s){
        ReadReservationQuery query = new ReadReservationQuery();
        List<Reservation> models = queryGateway.query(query, ResponseTypes.multipleInstancesOf(Reservation.class)).join();
        return models;
    }
}
