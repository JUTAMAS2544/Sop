package com.example.reservservice.reservation.command.event;

import com.example.reservservice.reservation.data.Reservation;
import com.example.reservservice.reservation.data.ReservationRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationEventHandler {
    @Autowired
    private ReservationRepository repository;

    @EventHandler
    public void on(ReservationCreateEvent event){
        Reservation model = new Reservation();
        BeanUtils.copyProperties(event, model);
        repository.save(model);
    }

    @EventHandler
    public void on(ReservationUpdateEvent event){
        Reservation model = new Reservation();
        model.setReserv_id(event.getId());
        model.setStatus(event.getStatus());
        model.setBooking_date(event.getBooking_date());
        model.setEating_date(event.getEating_date());
        model.setEating_time(event.getEating_time());
        model.setUser_id(event.getUser_id());
        model.setRest_id(event.getRest_id());
        repository.save(model);
    }
}
