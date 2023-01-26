package com.example.reservservice.payment.query.projection;

import com.example.reservservice.payment.data.Payment;
import com.example.reservservice.payment.data.PaymentRepository;
import com.example.reservservice.payment.query.query.ReadPaymentQuery;
import com.example.reservservice.restaurant.data.Restaurant;
import com.example.reservservice.restaurant.data.RestaurantRepository;
import com.example.reservservice.restaurant.query.query.ReadRestQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class PaymentProjection {
    @Autowired
    private PaymentRepository repository;
    @QueryHandler
    public List<Payment> handler(ReadPaymentQuery query){
        List<Payment> models = repository.findAll();
        return models;
    }
}
