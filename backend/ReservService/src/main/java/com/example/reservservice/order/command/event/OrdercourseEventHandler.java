package com.example.reservservice.order.command.event;

import com.example.reservservice.order.data.Ordercourse;
import com.example.reservservice.order.data.OrdercourseRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class OrdercourseEventHandler {
    @Autowired
    private OrdercourseRepository repository;

    @EventHandler
    public void on(OrdercourseCreateEvent event){
        Ordercourse model = new Ordercourse();
        BeanUtils.copyProperties(event, model);
        repository.save(model);
    }
}
