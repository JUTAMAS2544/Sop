package com.example.reservservice.reservation.query.projection;

import com.example.reservservice.reservation.data.Reservation;
import com.example.reservservice.reservation.data.ReservationRepository;
import com.example.reservservice.reservation.query.query.ReadReservationQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class ReservationProjection {
    @Autowired
    private ReservationRepository repository;

    @QueryHandler
    public List<Reservation> handler(ReadReservationQuery query){
        List<Reservation> models = repository.findAll();
        return models;
    }
}
