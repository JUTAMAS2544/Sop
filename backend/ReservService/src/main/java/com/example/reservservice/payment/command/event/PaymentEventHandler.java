package com.example.reservservice.payment.command.event;

import com.example.reservservice.payment.data.Payment;
import com.example.reservservice.payment.data.PaymentRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PaymentEventHandler {
    @Autowired
    private PaymentRepository repository;

    @EventHandler
    public void on(PaymentCreateEvent event){
        Payment model = new Payment();
        BeanUtils.copyProperties(event, model);
        repository.save(model);
    }
}
