package com.example.reservservice.table.query.projection;

import com.example.reservservice.table.data.Seat;
import com.example.reservservice.table.data.SeatRepository;
import com.example.reservservice.table.query.query.ReadSeatQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class SeatProjection {
    @Autowired
    private SeatRepository repository;
    @QueryHandler
    public List<Seat> handler(ReadSeatQuery query){
        List<Seat> models = repository.readByRestId(query.getId());
        return models;
    }

}
