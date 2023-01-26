package com.example.reservservice.table.command.event;

import com.example.reservservice.table.data.Seat;
import com.example.reservservice.table.data.SeatRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SeatEventHandler {
    @Autowired
    private SeatRepository repository;

    @EventHandler
    public void on(SeatUpdateEvent event){
        Seat model = new Seat();
        model.setTable_id(event.getId());
        model.setTable_no(event.getTable_no());
        model.setStatus(event.getStatus());
        model.setRest_id(event.getRest_id());
        repository.save(model);
    }
}
